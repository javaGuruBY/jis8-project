# select occupied slots #49
SELECT slot.id,
       datetime as                           start,
       (datetime + interval duration minute) finish,
       duration,
       fitness_class_name
FROM slot
         JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
         JOIN slot_to_user stu on slot.id = stu.slot_id;
#Adding constraint to slot id and user id in slot_to_user table can't be null example
ALTER TABLE slot_to_user
    MODIFY slot_id BIGINT NOT NULL;
ALTER TABLE slot_to_user
    MODIFY user_id BIGINT NOT NULL;
#Adding constraint to fitness class id in slot table can't be null
ALTER TABLE slot
    MODIFY fitness_class_id BIGINT NOT NULL;

