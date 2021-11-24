#58 find total classes with max available slots
SELECT fitness_class_name, COUNT(fitness_class_name) as available_slot
from (SELECT fitness_class_name
      FROM slot
               LEFT JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
               LEFT JOIN slot_to_user stu on slot.id = stu.slot_id
      WHERE user_id IS NULL) as slot
GROUP BY fitness_class_name
ORDER BY available_slot desc;


#58-1 find 3d max available slots classes, dynamic
SELECT fitness_class_name, COUNT(fitness_class_name) as available_slot
from (SELECT fitness_class_name
      FROM slot
               LEFT JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
               LEFT JOIN slot_to_user stu on slot.id = stu.slot_id
      WHERE user_id IS NULL) as slot
GROUP BY fitness_class_name
HAVING available_slot =
       (SELECT COUNT(fitness_class_name) as available_slot
        from (SELECT fitness_class_name
              FROM slot
                       LEFT JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
                       LEFT JOIN slot_to_user stu on slot.id = stu.slot_id
              WHERE user_id IS NULL) as slot
        GROUP BY fitness_class_name
        ORDER BY available_slot desc
        LIMIT 2, 1);
