package be.friend.domain.common.persistence.service;

import be.friend.domain.common.dto.SearchParam;

import java.util.List;
import java.util.Optional;

public interface PersistenceService<D, ID> {

    D add(D dto);

    D update(D dto);

    void delete(ID oid);

    Optional<D> get(ID oid);

    List<D> list(SearchParam searchParam);
}
