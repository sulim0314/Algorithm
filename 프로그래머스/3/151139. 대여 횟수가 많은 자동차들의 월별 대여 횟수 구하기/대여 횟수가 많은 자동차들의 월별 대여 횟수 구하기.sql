SELECT  EXTRACT (MONTH FROM start_date) AS "MONTH",CAR_ID, count(*) AS "RECORDS"
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where start_date 
    BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD')
    AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
    AND CAR_ID IN ( SELECT DISTINCT CAR_ID
                    FROM
                        (SELECT CAR_ID, COUNT(*)
                           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                           WHERE start_date 
                                 BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD')
                                 AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
                           GROUP BY CAR_ID
                           HAVING COUNT(*) >= 5 ))
GROUP BY  EXTRACT (MONTH FROM start_date),CAR_ID 
ORDER BY EXTRACT(MONTH FROM start_date),CAR_ID DESC;