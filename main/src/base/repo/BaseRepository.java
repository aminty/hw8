package base.repo;


import base.entity.BaseEntity;

import java.sql.SQLException;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    <R, T> R findByColumn(T t, String beSelect, String whichColumn) throws SQLException;

    <T> boolean isExist(T arg, String column) throws SQLException;

    void insert(E e) throws SQLException;

    E update(E e) throws SQLException;

    void findAll() throws SQLException;

    E[] findAllById(ID[] ids);

    void deleteById(ID id);

    E findById(ID id);

    Boolean existsById(ID id);

    void createTable() throws SQLException;
}
