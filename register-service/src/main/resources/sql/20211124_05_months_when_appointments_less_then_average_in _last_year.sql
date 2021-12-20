#64 select months in current year where number of appointments  is less that average in last year
SELECT slot.id,
       COUNT(MONTHNAME(datetime)) as total,
       MONTHNAME(datetime)        as month
FROM slot
         JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
         JOIN slot_to_user stu on slot.id = stu.slot_id
         JOIN user u on stu.user_id = u.user_id
WHERE YEAR(datetime) = YEAR(NOW())
GROUP BY month
HAVING total < (
    select round(avg(total)) as avg_in_month_last_year
    from (SELECT COUNT(MONTHNAME(datetime)) as total,
                 MONTHNAME(datetime)        as month
          FROM slot
                   JOIN fitness_class fc on slot.fitness_class_id = fc.fitness_class_id
                   JOIN slot_to_user stu on slot.id = stu.slot_id
                   JOIN user u on stu.user_id = u.user_id
          WHERE YEAR(datetime) = YEAR(NOW()) - 1
          GROUP BY month
          ORDER BY total DESC) as totals
);
