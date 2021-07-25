package repo;

import java.sql.SQLException;

public interface CommonQuery<R, T> {
     boolean isExist(T arg, String column)  throws SQLException;

    R find(T arg) throws SQLException;

    void delete(T arg) throws SQLException;

    void update(T[] arg) throws SQLException;

    void insert(T arg) throws SQLException;

    void createTable() throws SQLException;

}
