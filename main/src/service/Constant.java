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




}
