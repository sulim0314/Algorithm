-- 대여 시작일을 기준으로 2022.08.01~ 2022.10.31 까지 총 대여 횟수가 5회 이상
-- 해당 기간 동안 월결 자동차 id 별 총 대여 횟수 
-- 월 오름차순, 자동차 id 내림차순, 특정 월 총 대여횟수 0은 제외

with tmp1 as (
    select car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where start_date between '2022-08-01' and '2022-10-31'
    group by car_id
    having count(*) >= 5
)

select month(c.start_date) as month, c.car_id, count(*) as records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY c

where c.car_id in (
        select car_id
        from tmp1
    ) AND start_date BETWEEN '2022-08-01' AND '2022-10-31'
    
group by month, c.car_id
order by 1 asc, 2 desc;