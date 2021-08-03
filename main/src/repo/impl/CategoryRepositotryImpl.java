package repo.impl;

import base.repo.impl.BaseRepositoryImpl;
import entity.Category;
import repo.CategoryRepository;
import service.ApplicationObject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoryRepositotryImpl extends BaseRepositoryImpl<Category,Integer> implements CategoryRepository {

    public CategoryRepositotryImpl(Connection connection) {
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
    public void insert(Category category) {

    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public void findAll() {
    }

    @Override
    public Category[] findAllById(Integer[] integers) {
        return new Category[0];
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Category findById(Integer integer) {
        return null;
    }

    @Override
    public Boolean existsById(Integer integer) {
        return null;
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
