ALTER TABLE slot ADD fitness_class_id BIGINT;
UPDATE slot SET fitness_class_id = 2 WHERE id = 1;
UPDATE slot SET fitness_class_id = 1 WHERE id = 2;
UPDATE slot SET fitness_class_id = 3 WHERE id = 3;
