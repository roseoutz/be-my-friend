package me.friend.domain.common.persistence.service;

import java.util.List;

public interface PersistenceService<D, T, ID> {

    D add(T friendDTO);

    D update(T friendDTO);

    void delete(ID oid);

    D get(ID oid);

    List<D> list();
}
