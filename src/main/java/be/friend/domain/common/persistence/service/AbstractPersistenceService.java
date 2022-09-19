package be.friend.domain.common.persistence.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractPersistenceService<R extends JpaRepository<T, ID>, T, D, ID> {

    private final R repository;
    private final JPAQueryFactory jpaQueryFactory;
    private final ObjectMapper objectMapper;

    public AbstractPersistenceService(R repository, JPAQueryFactory jpaQueryFactory, ObjectMapper objectMapper) {
        this.repository = repository;
        this.jpaQueryFactory = jpaQueryFactory;
        this.objectMapper = objectMapper;
    }

    protected R getRepository() {
        return repository;
    }

    protected JPAQueryFactory getQueryFactory() {
        return jpaQueryFactory;
    }

    protected D convertToDTO(T entity) {
        if (entity == null) {
            return null;
        }
        return objectMapper.convertValue(entity, getDtoClass());
    }

    protected T convertToEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return objectMapper.convertValue(dto, getEntityClass());
    }

    protected abstract Class<D> getDtoClass();

    protected abstract Class<T> getEntityClass();

}
