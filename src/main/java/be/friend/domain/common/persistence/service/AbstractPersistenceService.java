package be.friend.domain.common.persistence.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractPersistenceService<R extends JpaRepository<T, ID>, T, D, ID> {

    protected abstract R getRepository();

    protected abstract JPAQueryFactory getQueryFactory();

    protected abstract D convertToDTO(T entity);

    protected abstract T convertToEntity(D dto);

}
