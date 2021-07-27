package repo;

import entity.Order;
import service.ApplicationObject;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepo<R, T> implements BaseRepo<R, T> {
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
        Order order = (Order) arg;
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "insert into orders (user, product_id, count,price) values (?,?,?,?)"
        );
        ps.setString(1, ((Order) arg).getUsername());
        ps.setInt(2, ((Order) arg).getProductId());
        ps.setInt(3, ((Order) arg).getCount());
        ps.setInt(4, ((Order) arg).getPrice());
        ps.executeUpdate();


    }

    @Override
    public void createTable() throws SQLException {
        Statement st = ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS orders (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "user varchar(20) ," +
                "product_id int ," +
                "count int," +
                "price int default 0 ," +
                "FOREIGN KEY (user)references user(username)," +
                "FOREIGN KEY (product_id)references product(id))");
        st.close();

    }
}
