package repo;

import java.sql.SQLException;

public class ProductRepo<R, T> implements CommonQuery<R, T> {

    @Override
    public boolean isExist(T arg) throws SQLException {
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
    public void insert(T[] arg) throws SQLException {
    }

    @Override
    public void createTable() throws SQLException {

    }
}
