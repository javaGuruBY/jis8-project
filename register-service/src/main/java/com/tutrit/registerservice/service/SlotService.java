package com.tutrit.registerservice.service;

import com.tutrit.registerservice.bean.Slot;
import com.tutrit.registerservice.repository.SlotGateWayWithFileApiImpl;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SlotService {

  @Autowired
  SlotGateWayWithFileApiImpl slotGateWayWithFileApiImpl;


  public void save(Slot slot) {
    slotGateWayWithFileApiImpl.create(slot);
  }

  public Map<LocalDateTime, Slot> findAll() {
    return StreamSupport.stream(slotGateWayWithFileApiImpl.findAll().spliterator(), false)
        .collect(Collectors.toMap(Slot::getDateTime, slot -> slot));
  }

  public void deleteAll() {
    findAll().values()
        .forEach(slot -> slotGateWayWithFileApiImpl.delete(slot));
  }
}
