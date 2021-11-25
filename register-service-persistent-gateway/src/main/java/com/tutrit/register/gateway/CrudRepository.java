package com.tutrit.register.gateway;

import java.io.IOException;
import java.util.Optional;

/**
 * @param <T> is entity
 * @param <D> is Id(key)
 * @see  GateWayEntity
 */
public interface CrudRepository<T, D> {

    //TODO методы пробрасывают IOException, так как думаю будет удобнее их обрабатывать но более верхнем уровне
    // все сразу, чем в каждом методе по-отдельности.
    T create(T object) throws IOException;

    Optional<T> findById(D id) throws IOException;

    Iterable<T> findAll() throws IOException, ClassNotFoundException;

    T update(T object) throws IOException;

    void deleteById(D id) throws IOException;

    void delete(T object) throws IOException;
}
