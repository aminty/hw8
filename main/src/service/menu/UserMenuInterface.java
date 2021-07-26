package service.menu;

import java.sql.SQLException;

public interface UserMenuInterface {
    void signup() throws SQLException;
    void login() throws SQLException;
    void addToCart(int productId)throws SQLException;
    void deleteFromCart(int productId)throws SQLException;
    void showCart() throws SQLException;
    void showOrder() throws SQLException;
    void changePassword(int id) throws SQLException;
    void showProductWithoutLognin() throws SQLException;

}
