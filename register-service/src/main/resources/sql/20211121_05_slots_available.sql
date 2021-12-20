# select available slots #47
SELECT slot.id,
       datetime as                           start,
       (datetime + interval duration minute) finish,
       duration,
       fitness_class_name
FROM slot
         LEFT JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
         LEFT JOIN slot_to_user stu on slot.id = stu.slot_id
WHERE user_id IS NULL
;
