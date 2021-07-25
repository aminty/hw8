package service.menu;

public interface UserMenuInterface {
    void signup();
    void login();
    void addToCart(int productId);
    void deleteFromCart(int productId);
    void showCart();
    void showOrder();
    void changeInfo(int id);

}
