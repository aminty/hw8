package repo;

import service.ApplicationObject;

import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepo<R,T> implements BaseRepo<R,T> {
    @Override
    public   boolean isExist(T arg, String column) throws SQLException {
        return false;
    }

    @Override
    public R find(T arg, String column, String where) throws SQLException {
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
        Statement st= ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS orders (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "user_id int ," +
                "product_id int ," +
                "count int," +
                "FOREIGN KEY (user_id)references user(id)," +
                "FOREIGN KEY (product_id)references product(id))");
        st.close();

    }
}
