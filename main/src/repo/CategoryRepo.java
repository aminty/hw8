package repo;

import service.ApplicationObject;

import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepo <R,T> implements BaseRepo<R,T> {

    @Override
    public boolean isExist(T arg, String column) throws SQLException {
        return false;
    }

    @Override
    public R find(T arg, String column, String whichColumn) throws SQLException {
        return null;
    }

    @Override
    public void findAll() {

    }

    @Override
    public void delete(T arg) throws SQLException {

    }

    @Override
    public void update(T arg) throws SQLException {

    }

    @Override
    public void insert(T arg) throws SQLException {

    }

    @Override
    public void createTable() throws SQLException {
        Statement st1= ApplicationObject.getConnection().createStatement();
        st1.executeUpdate("CREATE TABLE IF NOT EXISTS main_category (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20))");
        st1.close();
        Statement st2= ApplicationObject.getConnection().createStatement();
        st2.executeUpdate("CREATE TABLE IF NOT EXISTS sub_category (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20)," +
                "super_id int ," +
                "FOREIGN KEY (super_id) references main_category(id))");
        st2.close();
    }
}
