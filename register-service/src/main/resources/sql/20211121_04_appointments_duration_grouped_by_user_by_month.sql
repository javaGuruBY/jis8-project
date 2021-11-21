# Develop sql script that calculates total duration of all appointments of each user during the month. #45
SELECT month(start) AS month, year(start), SUM(duration) AS total, fullname
from appointment_calendar
GROUP BY fullname, year(start), month(start);
