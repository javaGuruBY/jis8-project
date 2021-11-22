#53_find users who goes more time then the average user does
#1.create view of total time per every user

CREATE VIEW total_time_per_user AS
SELECT SUM(duration) AS total, fullname
from appointment_calendar
GROUP BY fullname;

#2.finds users who goes more time then the average user does
SELECT *
from total_time_per_user
WHERE total > (SELECT ROUND(AVG(total), 0)
               from total_time_per_user);

#3.replace total_time_per_user view with subquery
SELECT SUM(duration) AS total, fullname
from appointment_calendar
GROUP BY fullname
HAVING total < (SELECT ROUND(AVG(total2), 0)
                from (SELECT SUM(duration) AS total2
                      from appointment_calendar
                      GROUP BY fullname) AS ttpu);

#4.replace appointment_calendar view with subquery
SELECT SUM(duration) AS total, fullname
from (SELECT duration,
             CONCAT(name, ' ', surname) AS fullname
      FROM slot
               JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
               JOIN slot_to_user stu on slot.id = stu.slot_id
               JOIN user u on stu.user_id = u.user_id) AS ac
GROUP BY fullname
HAVING total > (SELECT ROUND(AVG(total2), 0)
                from (SELECT SUM(duration) AS total2
                      from appointment_calendar
                      GROUP BY fullname) AS ttpu);

# Another way: how long in average user spent in jum (trailing duration)
#1. make an average of average time user spent (single result)
select avg(averageforusers)
from (SELECT AVG(duration) as averageforusers
      from appointment_calendar
      GROUP BY fullname, duration) as avfu;

#2. filter average time user spent by average for users, got from #1.
SELECT AVG(duration) as avgdur, fullname
from appointment_calendar
GROUP BY fullname, duration
HAVING avgdur > (select avg(averageforusers)
                 from (SELECT AVG(duration) as averageforusers
                       from appointment_calendar
                       GROUP BY fullname, duration) as avfu)
;

#3. replace appointment_calendar view with subquery
SELECT AVG(duration) as avgdur, fullname
from (SELECT duration,
             CONCAT(name, ' ', surname) AS fullname
      FROM slot
               JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
               JOIN slot_to_user stu on slot.id = stu.slot_id
               JOIN user u on stu.user_id = u.user_id) AS ap
GROUP BY fullname, duration
HAVING avgdur > (select avg(averageforusers)
                 from (SELECT AVG(duration) as averageforusers
                       from appointment_calendar
                       GROUP BY fullname, duration) as avfu);
