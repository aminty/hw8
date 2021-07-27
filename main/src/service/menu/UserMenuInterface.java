package service.menu;

import java.sql.SQLException;

public interface UserMenuInterface {
    void signup() throws SQLException;
    void login() throws SQLException;
    void addToCart()throws SQLException;
    void deleteFromCart()throws SQLException;
    void showCart() throws SQLException;
    void showOrder() throws SQLException;
    void changePassword() throws SQLException;
    void showProductWithoutLognin() throws SQLException;

}
