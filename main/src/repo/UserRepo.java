package repo;

import service.ApplicationObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepo<R, T> implements CommonQuery<R, T> {
    @Override
    public boolean isExist(T arg, String column) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                //todo Q2 ?=?
                "select * from user where " + column + "=?");
        //todo Q1 check type
        if (arg.getClass().getSimpleName().equals(String.class.getSimpleName()))
            ps.setString(1, (String) arg);
        if (arg.getClass().getSimpleName().equals(Integer.class.getSimpleName()))
            ps.setInt(1, (Integer) arg);
        ResultSet rs = ps.executeQuery();
        return rs.next();
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
        Statement st = ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20)," +
                "lastname VARCHAR (20)," +
                "username VARCHAR (20)," +
                "password VARCHAR (20))");
        st.close();
    }

}
