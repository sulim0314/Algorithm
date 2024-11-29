-- 수원 지역의 연도 별 평균 미세먼ㅁ지 오염도와
-- 평균 초미세먼지 오염도 조회 !

select 
    year(ym) as year, 
    round(avg(pm_val1), 2) as 'PM10',
    round(avg(pm_val2), 2) as 'PM2.5'
from AIR_POLLUTION
where LOCATION2 = '수원'
group by year
order by 1 asc;