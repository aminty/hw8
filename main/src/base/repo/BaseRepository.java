package base.repo;


import base.entity.BaseEntity;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    E save(E e);

    E update(E e);

    E[] findAll();

    E[] findAllById(ID[] ids);

    void deleteById(ID id);

    E findById(ID id);

    Boolean existsById(ID id);
}
