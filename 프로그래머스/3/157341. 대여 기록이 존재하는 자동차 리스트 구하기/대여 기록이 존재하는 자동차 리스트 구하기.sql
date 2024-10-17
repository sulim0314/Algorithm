-- 코드를 입력하세요
# SELECT DISTINCT(A.CAR_ID)
# FROM CAR_RENTAL_COMPANY_CAR A
# LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B
#     ON A.CAR_ID = B.CAR_ID
# WHERE MONTH(B.START_DATE) = '10' AND CAR_TYPE='세단'
# ORDER BY 1 DESC;

-- 자동차 종류가 세단
-- 10월에 대여를 시작한 기록이 있는,, 중복ㄴ,
select distinct(a.car_id)
from car_rental_company_car a

right join CAR_RENTAL_COMPANY_RENTAL_HISTORY b
    on a.car_id = b.car_id
where month(b.start_date) = '10' and car_type='세단'
order by 1 desc;