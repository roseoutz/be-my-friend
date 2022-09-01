package me.friend.domain.common.persistence.service;

import java.util.List;

public interface PersistenceService<D, T, ID> {

    /**
     * DTO를 저장소에 저장한다.
     * 이미 존재한 데이터의 경우 exception 발생
     * @param dto
     * @return
     */
    D add(T dto);

    D update(T dto);

    void delete(ID oid);

    D get(ID oid);

    List<D> list();
}
