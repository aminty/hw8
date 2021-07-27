package repo;

import entity.Product;
import service.ApplicationObject;
import service.PrintMessage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductRepo<R, T> implements BaseRepo<R, T> {

    @Override
    public boolean isExist(T arg, String column) throws SQLException {
            PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                    "select * from product where " + column + "=?");
            if (arg.getClass().getSimpleName().equals(String.class.getSimpleName()))
                ps.setString(1, (String) arg);
            if (arg.getClass().getSimpleName().equals(Integer.class.getSimpleName()))
                ps.setInt(1, (Integer) arg);
            ResultSet rs = ps.executeQuery();
            return rs.next();
    }

    @Override
    public R find(T arg, String beSelect, String whichColumn) throws SQLException {
        Product product=new Product();
        PreparedStatement ps=ApplicationObject.getConnection().prepareStatement(
                "select "+beSelect+" from product where "+ whichColumn +" = ?;"
        );
        if (arg.getClass().getSimpleName().equals(String.class.getSimpleName()))
            ps.setString(1, (String) arg);
        if (arg.getClass().getSimpleName().equals(Integer.class.getSimpleName()))
            ps.setInt(1, (Integer) arg);

        ResultSet rs=ps.executeQuery();
        if (rs.next()){
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getInt("price"));
            product.setCount(rs.getInt("count"));
            return (R) product;
        }
        return (R) product;
    }

    @Override
    public void findAll() throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "select product.id,name,main_category_name,sub_name,price,count from product\n" +
                        "    join main_category mcat on mcat.id = product.main_cat_id\n" +
                        "    join sub_category scat on scat.id = product.sub_cat_id order by product.id;"
        );
        ResultSet rs = ps.executeQuery();
        System.out.println("|-----------------|");
        System.out.println("| Print all goods |");
        System.out.println("|-----------------|");
        while (rs.next()) {
            ArrayList<String> item = new ArrayList<>();
            item.add(String.valueOf(rs.getInt("id")));
            item.add(rs.getString("name"));
            item.add(rs.getString("main_category_name"));
            item.add(rs.getString("sub_name"));
            item.add(String.valueOf(rs.getInt("price")));
            item.add(String.valueOf(rs.getInt("count")));
            PrintMessage.printItem(item);
        }
    }

    @Override
    public void delete(T arg) throws SQLException {
    }

    @Override
    public void update(T arg) throws SQLException {
        Product product=(Product)arg;
        PreparedStatement ps =ApplicationObject.getConnection().prepareStatement(
                "update product set count=? where id=?");
        ps.setInt(1,product.getCount()-product.getCurrentCount());
        ps.setInt(2,product.getId());
        ps.executeUpdate();
    }

    @Override
    public void insert(T arg) throws SQLException {




    }

    @Override
    public void createTable() throws SQLException {
        Statement st = ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS product (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20)," +
                "count int ," +
                "sub_cat_id int ," +
                "main_cat_id int ," +
                "price int ," +
                "Foreign Key  (main_cat_id) references main_category(id)," +
                "FOREIGN KEY (sub_cat_id) references sub_category(id))");
        st.close();
    }
}
