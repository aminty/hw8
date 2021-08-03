package repo.impl;

import base.repo.impl.BaseRepositoryImpl;
import entity.Order;
import service.ApplicationObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepositotryImpl extends BaseRepositoryImpl<Order,Integer> {
    public OrderRepositotryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public <R, T> R findByColumn(T t, String beSelect, String whichColumn) throws SQLException {
        return null;
    }

    @Override
    public <T> boolean isExist(T arg, String column) throws SQLException {
        return false;
    }

    @Override
    public void insert(Order order) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "insert into orders (user, product_id, count,price) values (?,?,?,?)"
        );
        ps.setString(1, ((Order) order).getUsername());
        ps.setInt(2, ((Order) order).getProductId());
        ps.setInt(3, ((Order) order).getCount());
        ps.setInt(4, ((Order) order).getPrice());
        ps.executeUpdate();


    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void findAll() {
    }

    @Override
    public Order[] findAllById(Integer[] integers) {
        return new Order[0];
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Order findById(Integer integer) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
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
