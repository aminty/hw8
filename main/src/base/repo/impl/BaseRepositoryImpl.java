package base.repo.impl;



import base.entity.BaseEntity;
import base.repo.BaseRepository;

import java.sql.Connection;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID>
        implements BaseRepository<E, ID> {

    protected final Connection connection;

    public BaseRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

}
