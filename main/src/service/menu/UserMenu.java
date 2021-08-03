package service.menu;

import entity.Order;
import entity.Product;
import entity.User;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserMenu implements UserMenuInterface {
    static boolean isLoggedIn = false;
    static Map<Integer, Product> cartList = new HashMap<>();
    static String username;

    @Override
    public void signup() throws SQLException {
        User user = new User();

        String name = ApplicationObject.getValidation().isValid(Constant.FIRST_NAME_REGEX,
                Constant.ENTER_NAME, Constant.INVALID_INPUT);
        if (name.equals("0")) Menu.runPublicMenu();
        user.setFirstName(name);
        String lastName = ApplicationObject.getValidation().isValid(Constant.LAST_NAME_REGEX,
                Constant.ENTER_LAST_NAME, Constant.INVALID_INPUT);
        if (lastName.equals("0")) Menu.runPublicMenu();
        user.setLastName(lastName);
        String username = isUserExist(Constant.USERNAME_COL);
        if (username.equals("0")) Menu.runPublicMenu();
        user.setUsername(username);
        String password = ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.CHOOSE_PASSWORD, Constant.INVALID_INPUT);
        if (password.equals("0")) Menu.runPublicMenu();
        user.setPassword(password);
        ApplicationObject.getUserRepo().insert(user);
        Menu.runPublicMenu();
    }

    @Override
    public void login() throws SQLException {
        String username = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                Constant.ENTER_YOUR_USERNAME, Constant.INVALID_INPUT);
        if (ApplicationObject.getUserRepo().isExist(username, Constant.USERNAME_COL)) {
            String password = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                    Constant.ENTER_YOUR_PASSWORD, Constant.INVALID_INPUT);
            String realPass = ApplicationObject.getUserRepo().findByColumn(username, Constant.PASSWORD_COL, Constant.USERNAME_COL);
            if (realPass.equals(password)) {
                PrintMessage.showMsg(Constant.SUCCESS_LOGIN);
                isLoggedIn = true;
                this.username = username;
                Menu.runDashboardMenu(username);
                Menu.runPublicMenu();
            } else PrintMessage.showErr(Constant.INCORRECT_DATA);
        }
    }

    @Override
    public void addToCart() throws SQLException {
        Product product;
        while (true) {
            int productId = Integer.parseInt(ApplicationObject.getValidation().isValid(Constant.SINGLE_NUMBER_REGEX,
                    Constant.ENTER_PRODUCT_ID, Constant.INVALID_INPUT));
            if (productId == 0) break;
            int count = Integer.parseInt(ApplicationObject.getValidation().isValid(Constant.SINGLE_NUMBER_REGEX,
                    Constant.ENTER_PRODUCT_COUNT, Constant.INVALID_INPUT));
            if (ApplicationObject.getProductRepo().isExist(productId, "id")) {
                if (cartList.size() < 5) {
                    product = ApplicationObject.getProductRepo().findByColumn(productId, "*", "id");
                    product.setCurrentCount(count);
                    if (product.getCount() >= count)
                        cartList.put(productId, product);
                    else PrintMessage.showMsg(Constant.COUNT_NOT_ENOUGH);
                } else {
                    PrintMessage.showMsg(Constant.MAX_ITEM);
                    break;
                }
            } else PrintMessage.showMsg(Constant.ID_NOT_FOUND);
        }
        PrintMessage.printMenu(Constant.Dashboard_MENU_ITEM);
    }

    @Override
    public void deleteFromCart() throws SQLException {
        while (true) {
            if (cartList.isEmpty()) break;
            int id = Integer.parseInt(ApplicationObject.getValidation().isValid(Constant.SINGLE_NUMBER_REGEX,
                    Constant.ENTER_PRODUCT_ID, Constant.INVALID_INPUT));
            if (id == 0) break;
            if (cartList.containsKey(id))
                cartList.remove(id);
            else
                PrintMessage.showMsg(Constant.ID_NOT_FOUND);
        }
    }

    @Override
    public void showCart() throws SQLException {
        if (cartList.isEmpty()) PrintMessage.showMsg(Constant.CART_IS_EMPTY);
        PrintMessage.printCartItem(cartList);
        if (!cartList.isEmpty()) {
            String answer = ApplicationObject.getValidation().isValid(
                    Constant.BOOL_QUESTION_REGEX, Constant.DELETE_ANY_ITEM_FROM_CART, Constant.INVALID_INPUT);
            if (answer.equals("yes"))
                deleteFromCart();
        }
        if (!cartList.isEmpty()) {
            String answer = ApplicationObject.getValidation().isValid(
                    Constant.BOOL_QUESTION_REGEX, Constant.VERIFY_PURCHASE, Constant.INVALID_INPUT);
            if (answer.equals("yes"))
                purchase();
        }
        PrintMessage.printMenu(Constant.Dashboard_MENU_ITEM);
    }

    private void purchase() throws SQLException {

        Order order=new Order();

        for (Map.Entry<Integer,Product> pair: cartList.entrySet()) {
            order.setUsername(username);
            order.setPrice(pair.getValue().getPrice()*pair.getValue().getCount());
            order.setProductId(pair.getValue().getId());
            order.setCount(pair.getValue().getCurrentCount());
            ApplicationObject.getOrderRepo().insert(order);
            ApplicationObject.getProductRepo().update(pair.getValue());
            PrintMessage.showMsg("Purchase completed !");

        }


    }

    @Override
    public void showOrder() throws SQLException {

    }

    @Override
    public void changePassword() throws SQLException {
    }
    @Override
    public void showProductWithoutLognin() throws SQLException {
        ApplicationObject.getProductRepo().findAll();
        if (!isLoggedIn) {
            if (ApplicationObject.getValidation().isValid(Constant.BOOL_QUESTION_REGEX,
                    "You must be logged in to purchase.\nDo you want to login?",
                    Constant.INVALID_INPUT).equals("yes"))
                login();
            else PrintMessage.printMenu(Constant.PUBLIC_MENU_ITEM);//Menu.runPublicMenu();
        } else {
            addToCart();
        }
    }
    private String isUserExist(String column) throws SQLException {
        while (true) {
            String uniqueUsername = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                    Constant.CHOOSE_USERNAME, Constant.INVALID_INPUT);
            if (!ApplicationObject.getUserRepo().isExist( uniqueUsername, column))
                return uniqueUsername;
            else PrintMessage.showMsg(Constant.USER_IS_EXIST);
        }
    }
}
