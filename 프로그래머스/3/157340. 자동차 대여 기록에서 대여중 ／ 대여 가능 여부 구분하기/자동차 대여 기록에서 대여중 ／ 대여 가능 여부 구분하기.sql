# WITH 
#     tmp AS (
#         SELECT car_id
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         WHERE '2022-10-16' BETWEEN start_date AND end_date
#         GROUP BY car_id
#     ),
#     c AS (
#         SELECT DISTINCT car_id 
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     )

# SELECT
#     c.car_id,
#     CASE 
#         WHEN t.car_id IS NOT NULL THEN '대여중'
#         ELSE '대여 가능'
#     END AS AVAILABILITY
# FROM c
# LEFT JOIN tmp t ON c.car_id = t.car_id
# ORDER BY c.car_id DESC;

-- 2022.10.16에 대여중이면 대여중

WITH tmp1 AS (
    SELECT car_id, start_date, end_date
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE '2022-10-16' BETWEEN start_date AND end_date
)

SELECT a.car_id, 
    CASE 
        WHEN tmp1.car_id IS NOT NULL THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
    
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a

LEFT JOIN tmp1 ON a.car_id = tmp1.car_id
GROUP BY a.car_id
ORDER BY a.car_id DESC;


