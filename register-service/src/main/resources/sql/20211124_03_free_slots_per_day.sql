#62 count free slots per day *per class
SELECT DATE(start), fitness_class_name, COUNT(DATE(start))
from (SELECT datetime as start,
             fitness_class_name
      FROM slot
               LEFT JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
               LEFT JOIN slot_to_user stu on slot.id = stu.slot_id
      WHERE user_id IS NULL) as slot
GROUP BY DATE(start), fitness_class_name
ORDER BY DATE(start);
