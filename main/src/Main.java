import service.ApplicationObject;
import service.PrintMessage;
import service.menu.Menu;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationObject.firstDbInitiator();
        try {

        Menu.runMenu();
        }catch (Exception e){
            PrintMessage.showErr("Something went wrong !");
        }
        finally {
            Menu.runMenu();
        }

    }
}
