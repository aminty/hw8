package service;

public class Constant {
    /**
     * Regex for validation
     */
    public static final String SINGLE_NUMBER_REGEX = "^\\d+$";
    public static final String BOOL_QUESTION_REGEX = "^(yes)|(no)$";
    public static final String FIRST_NAME_REGEX = "^[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "^[A-Za-z]*";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String USERNAME_REGEX = "^[A-Za-z]\\w{5,29}$";
    /**
     * Message for methods
     */
    public static final String ENTER_BOOL_CHOICE = "Are you ready ? (yes/no) : ";
    public static final String CREATE_CONN_FAIL = "Create connection failed !";
    public static final String ENTER_NUMERIC_CHOICE = "Choose an item : ";
    public static final String INVALID_INPUT = "Wrong input , try again ! ";
    public static final String ENTER_NAME = "Enter your name: ";
    public static final String ENTER_LAST_NAME = "Enter your last name: ";
    public static final String CHOOSE_USERNAME = "Choose your username: ";
    public static final String CHOOSE_PASSWORD = "Choose your password: ";
    public static final String WELCOM = "Welcome";
    public static final String APPLICATION_CLOSED = "Applocation closed !";
    public static final String USER_IS_EXIST = "Sorry ! this username is exist . ";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong !";
    public static final String CREATE_CONN_SUCCESSFULY = "Connection created successfuly .";
    public static final String LOGIN_MENU_NAME = "L O G I N";
    public static final String USER_ADDED = "User added successfuly .";
    public static final String SIGN_IN_MENU_NAME = "S I G N I N ";
    public static final String[] PUBLIC_MENU_ITEM = {"Login", "Signup", "Show product", "Exit"};
    public static final String[] USER_MENU_ITEM = {"Show cart", "My order history", "Change info", "Exit"};
    public static final String ENTER_YOUR_USERNAME = "Enter your username: ";
    public static final String ENTER_YOUR_PASSWORD = "Enter your password: ";
    public static final String INCORRECT_DATA = "Username or password in not true !";
    public static final String SUCCESS_LOGIN = "You logged in successfuly .";
    public static final String USERNAME_COL = "username";
    public static final String PASSWORD_COL = "password";
    /**
     * JDBC parameter
     */
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/Digistore";
    public static final String USER = "root";
    public static final String PASSWORD = "aminty2015";
    public static final String [] Dashboard_MENU_ITEM ={"Show cart","See products","Show order history","Change password","Exit"};

    public static final String GOODBYE = "See you ";
    public static final String ENTER_PRODUCT_ID = "Enter product id to add: ";
    public static final String ID_NOT_FOUND = "Sorry , this product id not found !";
    public static final String MAX_ITEM = "Maximum item in cart is 5 .";
    public static final String ENTER_PRODUCT_COUNT = "Enter count of product: ";
    public static final String COUNT_NOT_ENOUGH = "Inventory is not enough !";
    public static final String DELETE_ANY_ITEM_FROM_CART = "Do you want to delete any item from cart ? ";
    public static final String CART_IS_EMPTY = "Cart is empty";
    public static final String VERIFY_PURCHASE = "Do you want to finish and purchase?";
}
