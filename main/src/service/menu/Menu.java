package service.menu;

import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.SQLException;

public class Menu {

    public static void runPublicMenu() throws SQLException {
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
                case 4 -> {PrintMessage.showMsg(Constant.APPLICATION_CLOSED) ;System.exit(0);}
                default -> PrintMessage.showErr(Constant.INVALID_INPUT);
            }
        }}
    }
    public static void runDashboardMenu(String username) throws SQLException {
        PrintMessage.printMenu(Constant.Dashboard_MENU_ITEM, Constant.WELCOM+" ("+username+")");
        outer:{
            while (true) {
                switch (Integer.parseInt(ApplicationObject.getValidation().isValid(
                        Constant.SINGLE_NUMBER_REGEX,
                        Constant.ENTER_NUMERIC_CHOICE,
                        Constant.INVALID_INPUT
                ))) {
                    case 1 -> ApplicationObject.getUserMenu().showCart();
                    case 2 -> ApplicationObject.getUserMenu().showProductWithoutLognin();
                    case 3 -> ApplicationObject.getUserMenu().showOrder();
                    case 4 -> ApplicationObject.getUserMenu().changePassword();
                    case 5 -> {PrintMessage.showMsg(Constant.GOODBYE+username) ;
                    UserMenu.isLoggedIn=false;
                    UserMenu.cartList.clear();
                    break outer;
                    }
                    default -> PrintMessage.showErr(Constant.INVALID_INPUT);
                }
            }}
    }
}
