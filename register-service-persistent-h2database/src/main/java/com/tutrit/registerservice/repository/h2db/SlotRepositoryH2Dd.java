package com.tutrit.registerservice.repository.h2db;

import com.tutrit.register.gateway.SlotRepository;
import com.tutrit.register.model.Slot;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class SlotRepositoryH2Dd  implements SlotRepository {

    @Override
    public Slot create(Slot slot) {
        return null;
    }

    @Override
    public Optional<Slot> findById(LocalDateTime id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Slot> findAll() {
        return null;
    }

    @Override
    public Slot update(Slot slot) {
        return null;
    }

    @Override
    public void deleteById(LocalDateTime id) {

    }

    @Override
    public void delete(Slot slot) {

    }
}
