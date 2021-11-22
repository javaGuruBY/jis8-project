#55 find total appointments by days of week
SELECT COUNT(*), DAYNAME(start) as day
from appointment_calendar
GROUP BY day;


# average appointments per day of week
#1.
select round(avg(total_for_day)) average_appointments_per_day, day
from (select count(cast(start as date))   as total_for_day,
             cast(start as date)          as data,
             DAYNAME(cast(start as date)) as day
      from appointment_calendar
      group by data) as totals
group by day;

#2. replace appointment calendar view with subquery
select round(avg(total_for_day)) average_appointments_per_day, day
from (select count(cast(start as date))   as total_for_day,
             cast(start as date)          as data,
             DAYNAME(cast(start as date)) as day
      from (SELECT datetime                   as         start
            FROM slot
                     JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
                     JOIN slot_to_user stu on slot.id = stu.slot_id
                     JOIN user u on stu.user_id = u.user_id) as ap
      group by data) as totals
group by day;