package service;
import repo.DatabaseInitiator;
import java.sql.Connection;

public class ApplicationObject {
    private static final Connection connection=new DatabaseInitiator().getCreatedConnection();

    public static Connection getConnection() {
        return connection;
    }
}
