package com.tutrit.registerservice.service;

import com.tutrit.register.model.Slot;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class BookingService {

    private final AppointmentCalendar appointmentCalendar;
    private final ScheduleCalendar scheduleCalendar;

    public BookingService(AppointmentCalendar appointmentCalendar, ScheduleCalendar scheduleCalendar) {
        this.appointmentCalendar = appointmentCalendar;
        this.scheduleCalendar = scheduleCalendar;
    }

    public boolean isAvailableForBooking(Slot slot){
        return appointmentCalendar.isPresent(slot.getDateTime());
    }

    public Map<LocalDateTime, Slot> findAllAvailableSlots(){
        Map<LocalDateTime, Slot> allSlots = new HashMap(scheduleCalendar.findAll());
        Map<LocalDateTime, Slot> freeSlots = new HashMap<>();
        for(Map.Entry<LocalDateTime,Slot> slot : allSlots.entrySet()) {
            if(!appointmentCalendar.isPresent(slot.getKey())) {
                freeSlots.put(slot.getKey(), slot.getValue());
            }
        }
        return freeSlots;
    }
}
