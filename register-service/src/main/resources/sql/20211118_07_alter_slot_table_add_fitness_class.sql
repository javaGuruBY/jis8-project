ALTER TABLE slots ADD fitness_class_id BIGINT;
UPDATE slots SET fitness_class_id = 2 WHERE id = 1;
UPDATE slots SET fitness_class_id = 1 WHERE id = 2;
UPDATE slots SET fitness_class_id = 3 WHERE id = 3;
