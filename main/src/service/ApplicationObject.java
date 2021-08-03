package service;

import repo.*;
import repo.impl.CategoryRepositotryImpl;
import repo.impl.OrderRepositotryImpl;
import repo.impl.ProductRepositotryImpl;
import repo.impl.UserRepositotryImpl;
import service.menu.UserMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationObject {
    private static final Connection connection = new DatabaseInitiator().getCreatedConnection();

    public static Connection getConnection() {
        return connection;
    }

    private static ProductRepositotryImpl productRepo = new ProductRepositotryImpl(connection);
    private static OrderRepositotryImpl orderRepo = new OrderRepositotryImpl(connection);
    private static CategoryRepositotryImpl categoryRepo = new CategoryRepositotryImpl(connection);
    private static Validation validation = new Validation();
    private static UserMenu userMenu = new UserMenu();
    private static UserRepositotryImpl userRepositotry=new UserRepositotryImpl(connection);
    public static UserMenu getUserMenu() {
        return userMenu;
    }

    public static UserRepositotryImpl getUserRepo() {
        return userRepositotry;
    }

    public static CategoryRepositotryImpl getCategoryRepo() {
        return categoryRepo;
    }

    public static OrderRepositotryImpl getOrderRepo() {
        return orderRepo;
    }

    public static ProductRepositotryImpl getProductRepo() {
        return productRepo;
    }

    public static void firstDbInitiator() throws SQLException {
        getUserRepo().createTable();
        getCategoryRepo().createTable();
        getProductRepo().createTable();
        getOrderRepo().createTable();
    }

    public static Validation getValidation() {
        return validation;
    }
}
