package skyapi.hexagonal.domain.ports.out;

public interface GenericPersistencePort<T, ID> {
    T create(T entity);
    T read(ID id);
    T update(ID id, T entity);
    void delete(ID id);
}
