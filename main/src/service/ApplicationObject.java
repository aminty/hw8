package service;

import repo.*;
import service.menu.UserMenu;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationObject {
    private static final Connection connection = new DatabaseInitiator().getCreatedConnection();

    public static Connection getConnection() {
        return connection;
    }

    private static UserRepo userRepo = new UserRepo();
    private static ProductRepo productRepo = new ProductRepo();
    private static OrderRepo orderRepo = new OrderRepo();
    private static CategoryRepo categoryRepo = new CategoryRepo();
    private static Validation validation = new Validation();
    private static UserMenu userMenu = new UserMenu();

    public static UserMenu getUserMenu() {
        return userMenu;
    }

    public static UserRepo getUserRepo() {
        return userRepo;
    }

    public static CategoryRepo getCategoryRepo() {
        return categoryRepo;
    }

    public static OrderRepo getOrderRepo() {
        return orderRepo;
    }

    public static ProductRepo getProductRepo() {
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
