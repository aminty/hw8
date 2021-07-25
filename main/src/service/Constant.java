package service;

public class Constant {
    /**
     * Regex for validation
     */
    public static final String SINGLE_NUMBER_REGEX="^\\d$";
    public static final String BOOL_QUESTION_REGEX="^(yes)|(no)$";
    public static final String FIRST_NAME_REGEX = "^[A-Za-z]*";
    public static final String LAST_NAME_REGEX = "^[A-Za-z]*";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String USERNAME_REGEX = "^[A-Za-z]\\w{5,29}$";
    /**
     * Message for methods
     */
    public static final String ENTER_BOOL_CHOICE="Are you ready ? (yes/no) : ";
    public static final String CREATE_CONN_FAIL="Create connection failed !";
    public static final String ENTER_NUMERIC_CHOICE="Choose an item : ";
    public static final String CREATE_CONN_SUCCESSFULY="Connection created successfuly .";
    public static final String LOGIN_MENU_NAME="L O G I N";
    public static final String SIGN_IN_MENU_NAME="S I G N I N ";
    public static final String[] PUBLIC_MENU_ITEM= {"Login","Signup","Show product","Exit"};
    public static final String[] USER_MENU_ITEM= {"Show cart","My order history","Change info","Exit"};
    /**
     * JDBC parameter
     */
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/Digistore";
    public static final String USER = "root";
    public static final String PASSWORD = "aminty2015";
}
