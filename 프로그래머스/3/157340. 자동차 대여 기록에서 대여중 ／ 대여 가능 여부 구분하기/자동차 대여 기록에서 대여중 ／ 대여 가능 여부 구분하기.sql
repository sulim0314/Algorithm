WITH tmp AS (
    SELECT car_id
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE '2022-10-16' BETWEEN start_date AND end_date
    GROUP BY car_id
)

SELECT
    c.car_id,
    CASE 
        WHEN t.car_id IS NOT NULL THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM (SELECT DISTINCT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) c
LEFT JOIN tmp t ON c.car_id = t.car_id
ORDER BY c.car_id DESC;
