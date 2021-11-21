CREATE VIEW appointment_calendar AS
SELECT slot.id,
       datetime                   as         start,
       (datetime + interval duration minute) finish,
       duration,
       fitness_class_name,
       CONCAT(name, ' ', surname) AS         fullname
FROM slot
         JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
         JOIN slot_to_user stu on slot.id = stu.slot_id
         JOIN user u on stu.user_id = u.user_id
;
