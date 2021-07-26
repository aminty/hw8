import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;
import service.menu.Menu;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        ApplicationObject.firstDbInitiator();
        try {

        Menu.runMenu();
        }catch (Exception e){
            PrintMessage.showErr(Constant.SOMETHING_WENT_WRONG);
            System.out.println(e.getMessage());
        }
        finally {
            Menu.runMenu();
        }



    }
}
