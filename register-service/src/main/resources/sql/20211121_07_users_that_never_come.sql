# find users that never come #51
SELECT user.user_id, CONCAT(name, ' ', surname) fullname
FROM user
         LEFT JOIN slot_to_user on user.user_id = slot_to_user.user_id
WHERE slot_to_user.user_id IS NULL;
