with recursive tmp as (
    select 0 as hour
    
    union all
    
    select hour+1
    from tmp
    where hour < 23
)

SELECT hour, count(animal_id)
from tmp
    left join animal_outs on hour = hour(datetime)
group by hour
order by 1 asc;