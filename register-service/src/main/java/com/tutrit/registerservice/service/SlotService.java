package com.tutrit.registerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutrit.register.gateway.SlotRepository;
import com.tutrit.register.model.Slot;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class SlotService {

  @Autowired
  SlotRepository slotRepository;


  public void save(Slot slot) {
    slotRepository.create(slot);
  }

  public Map<LocalDateTime, Slot> findAll() {
    return StreamSupport.stream(slotRepository.findAll().spliterator(), false)
        .collect(Collectors.toMap(slot -> slot.getDateTime(), slot -> slot));
  }

  public void deleteAll() {
    findAll().values().stream()
        .forEach(slot -> slotRepository.delete(slot));
  }
}
