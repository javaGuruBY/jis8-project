package com.tutrit.registerservice.service;


import com.tutrit.register.model.Slot;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class AppointmentCalendar {

    private static final Map<LocalDateTime, Slot> appointmentCalendarMap = new HashMap<>();

    public void addSlot(Slot slot) {
        appointmentCalendarMap.put(slot.getDateTime(), slot);
    }

    public Map<LocalDateTime, Slot> findAll(){
        return appointmentCalendarMap;
    }

    public Slot findByDateTime(LocalDateTime dateTime) {
        return appointmentCalendarMap.get(dateTime);
    }

    public boolean isPresent(LocalDateTime dateTime) {
        return appointmentCalendarMap.containsKey(dateTime);
    }

    public void removeAllSlots() {
        appointmentCalendarMap.clear();
    }
}
