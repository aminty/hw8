package service.menu;

import entity.User;
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
        user.setFirstName(ApplicationObject.getValidation().isValid(Constant.FIRST_NAME_REGEX,
                Constant.ENTER_NAME, Constant.INVALID_INPUT));
        user.setLastName(ApplicationObject.getValidation().isValid(Constant.LAST_NAME_REGEX,
                Constant.ENTER_LAST_NAME, Constant.INVALID_INPUT));
        user.setUsername(isValueExist(new UserRepo<Boolean,String>(),"username"));
        user.setPassword(ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.CHOOSE_PASSWORD, Constant.INVALID_INPUT));
        userRepo.insert(user);

    }

    @Override
    public void login() throws SQLException {

    }

    @Override
    public void addToCart(int productId) throws SQLException{

    }

    @Override
    public void deleteFromCart(int productId)throws SQLException {

    }

    @Override
    public void showCart() throws SQLException {

    }

    @Override
    public void showOrder() throws SQLException {

    }

    @Override
    public void changeInfo(int id) throws SQLException {

    }

    @Override
    public void showProductWithoutLognin() throws SQLException {

    }


    private <R,T> String isValueExist(UserRepo<R,T> userRepo, String column) throws SQLException {
        while (true){
            String uniqeUser=ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                    Constant.CHOOSE_USERNAME, Constant.INVALID_INPUT);
            //todo Q3 (T)cast
            if (!userRepo.isExist((T) uniqeUser,column))
                return uniqeUser;
            else PrintMessage.showMsg(Constant.VALUE_IS_EXIST);
        }
    }
}
