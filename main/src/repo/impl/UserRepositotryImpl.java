package repo.impl;

import base.repo.impl.BaseRepositoryImpl;
import entity.User;
import repo.UserRepository;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.*;

public class UserRepositotryImpl extends BaseRepositoryImpl<User,Integer>implements UserRepository {

    public UserRepositotryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public <R, T> R findByColumn(T arg, String beSelect, String whichColumn) throws SQLException {
        PreparedStatement ps=ApplicationObject.getConnection().prepareStatement(
                "select "+beSelect+" from user where "+ whichColumn +" = ?;"
        );
        ps.setObject(1,arg);
//        if (arg.getClass().getSimpleName().equals(String.class.getSimpleName()))
//            ps.setString(1, (String) arg);
//        if (arg.getClass().getSimpleName().equals(Integer.class.getSimpleName()))
//            ps.setInt(1, (Integer) arg);
        ResultSet rs=ps.executeQuery();
        if (rs.next())
            return (R) rs.getObject(beSelect);
        else return (R) "0";    }

    @Override
    public <T> boolean isExist(T arg, String column) throws SQLException {
        PreparedStatement ps = ApplicationObject.getConnection().prepareStatement(
                "select * from user where " + column + "=?");
        ps.setObject(1, arg);

        ResultSet rs = ps.executeQuery();
        return rs.next();
    }

    @Override
    public void insert(User user) throws SQLException {
        PreparedStatement ps=ApplicationObject.getConnection().prepareStatement(
                "insert into user(name, lastname, username, password) values (?,?,?,?)"
        );
        ps.setString(1,user.getFirstName());
        ps.setString(2,user.getLastName());
        ps.setString(3,user.getUsername());
        ps.setString(4,user.getPassword());
        ps.executeUpdate();
        PrintMessage.showMsg(Constant.USER_ADDED);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void findAll() {
    }

    @Override
    public User[] findAllById(Integer[] integers) {
        return new User[0];
    }

    @Override
    public void deleteById(Integer integer) {
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
    }

    @Override
    public void createTable() throws SQLException {
        Statement st = ApplicationObject.getConnection().createStatement();
        st.executeUpdate("CREATE TABLE IF NOT EXISTS user (" +
                "id INT AUTO_INCREMENT PRIMARY KEY ," +
                "name VARCHAR (20)," +
                "lastname VARCHAR (20)," +
                "username VARCHAR (20) unique ," +
                "password VARCHAR (20))");
        st.close();

    }
}
