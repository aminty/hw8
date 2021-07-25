package repo;

import service.ApplicationObject;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductRepo<R, T> implements CommonQuery<R, T> {

    @Override
    public boolean isExist(T arg, String column) throws SQLException {
        return false;
    }

    @Override
    public R find(T arg) throws SQLException {
        return null;
    }

    @Override
    public void delete(T arg) throws SQLException {
    }

    @Override
    public void update(T[] arg) throws SQLException {
    }

    @Override
    public void insert(T arg) throws SQLException {
    }

    @Override
    public void createTable() throws SQLException {
        Statement st= ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS product (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20)," +
                "count double ," +
                "category_id int ," +
                "price double ,"+
                "FOREIGN KEY (category_id) references category(id))");
        st.close();
    }
}
