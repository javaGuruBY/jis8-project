CREATE VIEW appointment_calendar AS
SELECT slots.id,
       datetime                   as         start,
       (datetime + interval duration minute) finish,
       duration,
       fitness_class_name,
       CONCAT(name, ' ', surname) AS         fullname
FROM slots
         JOIN fitness_class fc on slots.fitness_class_id = fc.fitness_class_id
         JOIN slot_to_user stu on slots.id = stu.slot_id
         JOIN user u on stu.user_id = u.user_id
;
