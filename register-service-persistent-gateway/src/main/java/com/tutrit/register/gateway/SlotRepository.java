package com.tutrit.register.gateway;

import java.time.LocalDateTime;
import java.util.Optional;

import com.tutrit.register.model.Slot;


public interface SlotRepository extends CrudRepository<Slot, LocalDateTime> {

  @Override
  Slot create(Slot slot);

  @Override
  Optional<Slot> findById(LocalDateTime id);

  @Override
  Iterable<Slot> findAll();

  @Override
  Slot update(Slot slot);

  @Override
  void deleteById(LocalDateTime id);

  @Override
  void delete(Slot slot);
}
