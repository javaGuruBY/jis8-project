package com.tutrit.registerservice.service;

import com.tutrit.registerservice.bean.Slot;
import com.tutrit.registerservice.repository.SlotRepository;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
