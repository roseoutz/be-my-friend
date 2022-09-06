package be.friend.domain.common.persistence.service;

import be.friend.domain.common.dto.SearchParam;

import java.util.List;
import java.util.Optional;

public interface PersistenceService<D, ID> {

    /**
     * DTO를 저장소에 저장한다.
     * 이미 존재한 데이터의 경우 exception 발생
     * @param dto
     * @return
     */
    D add(D dto);

    D update(D dto);

    void delete(ID oid);

    Optional<D> get(ID oid);

    List<D> list(SearchParam searchParam);
}
