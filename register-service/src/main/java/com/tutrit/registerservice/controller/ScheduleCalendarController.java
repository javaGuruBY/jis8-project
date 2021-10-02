package com.tutrit.registerservice.controller;

import com.tutrit.registerservice.bean.Slot;
import com.tutrit.registerservice.service.ScheduleCalendar;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleCalendarController {

  @Autowired
  private ScheduleCalendar scheduleCalendar;

  public ScheduleCalendarController() {
  }

  public ScheduleCalendarController(final ScheduleCalendar scheduleCalendar) {
    this.scheduleCalendar = scheduleCalendar;
  }

  @GetMapping("/showSlots")
  public Map<LocalDateTime, Slot> showAllSlots() {
    return scheduleCalendar.findAll();
  }

  @GetMapping("/addSlot")
  public Map<LocalDateTime, Slot> addSlot(String date, String duration) {
    Slot slot = new Slot(LocalDateTime.parse(date), Integer.parseInt(duration));
    scheduleCalendar.addSlot(slot);
    return scheduleCalendar.findAll();
  }

  @GetMapping("/addBatchSlot")
  public Map<LocalDateTime, Slot> addBatchSlot(String[] args) {
    for (int i = 0; i < args.length; i += 2) {
      Slot slot = new Slot(LocalDateTime.parse(args[i]), Integer.parseInt(args[i + 1]));
      scheduleCalendar.addSlot(slot);
    }
    return scheduleCalendar.findAll();
  }
}
