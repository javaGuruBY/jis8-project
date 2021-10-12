package com.tutrit.registerservice.repository;

import java.io.IOException;
import java.util.Optional;

/**
 *
 * @param <T> is entity
 * @param <D> is Id(key)
 */
public interface CrudRepository<T, D> {
  // Create
  // Read
  // Update
  // Delete

  T create(T object) throws IOException;
  Optional<T> findById(D id) throws IOException;
  Iterable<T> findAll() throws IOException, ClassNotFoundException;
  T update(T object) throws IOException;
  void deleteById(D id) throws IOException;
  void delete(T object) throws IOException;

}
