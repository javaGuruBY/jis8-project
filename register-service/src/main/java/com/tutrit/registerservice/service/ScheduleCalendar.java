package com.tutrit.registerservice.service;


import com.tutrit.registerservice.bean.Slot;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCalendar implements Serializable {

    @Autowired
    SlotService slotService;

    public void addSlot(Slot slot) {
        slotService.save(slot);
    }

    public Map<LocalDateTime, Slot> findAll() {
        return slotService.findAll();
    }

    public void removeAllSlots() {
        slotService.deleteAll();
    }
}
