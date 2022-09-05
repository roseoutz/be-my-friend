package be.friend.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractTestService <R extends JpaRepository<T, ID>, T, ID> {

    private final R repository;


    protected AbstractTestService(R repository) {
        this.repository = repository;
    }

    protected R getRepository() {
        return repository;
    }

    public T save(T entity) {
        return repository.saveAndFlush(entity);
    }

    public Optional<T> findById(ID oid) {
        return repository.findById(oid);
    }

    public void deleteById(ID oid) { repository.deleteById(oid); }

    public void delete(T entity) { repository.delete(entity); }
}
