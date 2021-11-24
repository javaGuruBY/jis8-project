#66 calculate changes in total appointments in percent against same month in last year by className
#1. calculate percentage for each month in each column
select CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 1 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 1 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `01`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 2 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 2 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `02`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 3 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 3 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `03`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 4 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 4 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `04`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 5 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 5 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `05`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 6 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 6 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `06`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 7 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 7 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `07`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 8 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 8 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `08`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 9 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 9 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `09`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 10 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 10 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `10`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 11 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 11 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `11`,
CONCAT(ROUND((SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 12 AND YEAR(start) = YEAR(NOW())) / (SELECT COUNT(*) from appointment_calendar WHERE MONTH(start) = 12 AND YEAR(start) = YEAR(NOW()) -1) * 100), '%') AS `12`;
#2. create function to calculate percentage for selected month instead of repeating each month (above)
CREATE function appointments_dynamic_against_last_year (month int)
RETURNS varchar(16)
READS SQL DATA
BEGIN
    RETURN (select CONCAT(ROUND(
                    (SELECT COUNT(*)
                     from appointment_calendar
                     WHERE MONTH(start) = month
                       AND YEAR(start) = YEAR(NOW())
                    )
                    /
                    (SELECT COUNT(*)
                     from appointment_calendar
                     WHERE MONTH(start) = month
                       AND YEAR(start) = YEAR(NOW()) - 1)
                * 100), '%')
        );
END;
#3. create procedure to call 12 times function for 1-12 range calculation
CREATE PROCEDURE year_dynamic()
BEGIN
    SELECT appointments_dynamic_against_last_year(1) AS '01',
           appointments_dynamic_against_last_year(2) AS '02',
           appointments_dynamic_against_last_year(3) AS '03',
           appointments_dynamic_against_last_year(4) AS '04',
           appointments_dynamic_against_last_year(5) AS '05',
           appointments_dynamic_against_last_year(6) AS '06',
           appointments_dynamic_against_last_year(7) AS '07',
           appointments_dynamic_against_last_year(8) AS '08',
           appointments_dynamic_against_last_year(9) AS '09',
           appointments_dynamic_against_last_year(10) AS '10',
           appointments_dynamic_against_last_year(11) AS '11',
           appointments_dynamic_against_last_year(12) AS '12';
END;
#4. print result as table
CALL year_dynamic();