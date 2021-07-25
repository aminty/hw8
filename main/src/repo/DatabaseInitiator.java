package repo;

import service.Constant;
import service.PrintMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInitiator {


    public Connection getCreatedConnection() {

        try {
            Class.forName(Constant.JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(
                    Constant.URL,
                    Constant.USER,
                    Constant.PASSWORD);
            PrintMessage.showMsg(Constant.CREATE_CONN_SUCCESSFULY);
            return connection;
        } catch (Exception e) {
            PrintMessage.showErr(Constant.CREATE_CONN_FAIL);
        }
        return null;
    }


}
