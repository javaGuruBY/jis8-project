package com.tutrit.register.gateway;

import java.util.Optional;

public interface CrudRepository<T, D> {
  // Create
  // Read
  // Update
  // Delete

  T create(T object);
  Optional<T> findById(D id);
  Iterable<T> findAll();
  T update(T object);
  void deleteById(D id);
  void delete(T object);

}
