-- 코드를 작성해주세요
select
    id,
    case
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony <= 1000 then 'MEDIUM'
        when size_of_colony > 1000 then 'HIGH' 
    end as size
from 
    ECOLI_DATA
order by 1 asc;