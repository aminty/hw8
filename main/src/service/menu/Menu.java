package service.menu;

import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.SQLException;

public class Menu {

    public static void runMenu() throws SQLException {
        PrintMessage.printMenu(Constant.PUBLIC_MENU_ITEM, Constant.WELCOM);
        outer:{
            while (true) {
            switch (Integer.parseInt(ApplicationObject.getValidation().isValid(
                    Constant.SINGLE_NUMBER_REGEX,
                    Constant.ENTER_NUMERIC_CHOICE,
                    Constant.INVALID_INPUT
            ))) {
                case 1 -> ApplicationObject.getUserMenu().login();
                case 2 -> ApplicationObject.getUserMenu().signup();
                case 3 -> ApplicationObject.getUserMenu().showProductWithoutLognin();
                case 4 -> {PrintMessage.showMsg(Constant.APPLOCATION_CLOSED) ;break outer;}
                default -> PrintMessage.showErr(Constant.INVALID_INPUT);
            }
        }}
    }
}
