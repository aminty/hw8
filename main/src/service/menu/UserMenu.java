package service.menu;

import entity.User;
import repo.ProductRepo;
import repo.UserRepo;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.SQLException;

public class UserMenu implements UserMenuInterface {

    @Override
    public void signup() throws SQLException {
        User user = new User();
        UserRepo<String, User> userRepo = new UserRepo<>();
        String name = ApplicationObject.getValidation().isValid(Constant.FIRST_NAME_REGEX,
                Constant.ENTER_NAME, Constant.INVALID_INPUT);
        if (name.equals("0")) Menu.runMenu();
        user.setFirstName(name);
        String lastName = ApplicationObject.getValidation().isValid(Constant.LAST_NAME_REGEX,
                Constant.ENTER_LAST_NAME, Constant.INVALID_INPUT);
        if (lastName.equals("0")) Menu.runMenu();
        user.setLastName(lastName);
        String username = isUserExist(new UserRepo<Boolean, String>(), Constant.USERNAME_COL);
        if (username.equals("0")) Menu.runMenu();
        user.setUsername(username);
        String password = ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.CHOOSE_PASSWORD, Constant.INVALID_INPUT);
        if (password.equals("0")) Menu.runMenu();
        user.setPassword(password);
        userRepo.insert(user);
        Menu.runMenu();

    }

    @Override
    public void login() throws SQLException {
        UserRepo<String,String> userRepo=new UserRepo<>();
        String username=ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                Constant.ENTER_YOUR_USERNAME,Constant.INVALID_INPUT);
        if (userRepo.isExist(username, Constant.USERNAME_COL)){
        String password=ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                Constant.ENTER_YOUR_PASSWORD,Constant.INVALID_INPUT);
        String realPass=userRepo.find(username, Constant.PASSWORD_COL,Constant.USERNAME_COL );
        if (realPass.equals(password)){
            PrintMessage.showMsg(Constant.SUCCESS_LOGIN);

        }
        else
            PrintMessage.showErr(Constant.INCORRECT_DATA);
        }
    }

    @Override
    public void addToCart(int productId) throws SQLException {

    }

    @Override
    public void deleteFromCart(int productId) throws SQLException {

    }

    @Override
    public void showCart() throws SQLException {

    }

    @Override
    public void showOrder() throws SQLException {

    }

    @Override
    public void changePassword(int id) throws SQLException {

    }

    @Override
    public void showProductWithoutLognin() throws SQLException {
        ProductRepo productRepo=new ProductRepo();
        productRepo.findAll();
        if(ApplicationObject.getValidation().isValid(Constant.BOOL_QUESTION_REGEX,
                "You must be logged in to purchase.\nDo you want to login?",
                Constant.INVALID_INPUT).equals("yes"))
            login();
        else Menu.runMenu();

    }


    private <R, T> String isUserExist(UserRepo<R, T> userRepo, String column) throws SQLException {
        while (true) {
            String uniqueUsername = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                    Constant.CHOOSE_USERNAME, Constant.INVALID_INPUT);
            //todo Q3 (T)cast
            if (!userRepo.isExist((T) uniqueUsername, column))
                return uniqueUsername;
            else PrintMessage.showMsg(Constant.USER_IS_EXIST);
        }
    }
}
