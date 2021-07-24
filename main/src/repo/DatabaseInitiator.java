package repo;

import service.Constant;
import service.PrintMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInitiator {


    public Connection getCreatedConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Digistore",
                    "root",
                    "aminty2015");
            PrintMessage.showMsg(Constant.CREATE_CONN_SUCCESSFULY);
            return connection;
        } catch (Exception e) {
            PrintMessage.showErr(Constant.CREATE_CONN_FAIL);
        }
        return null;
    }


}
