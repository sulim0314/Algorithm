with tmp as (
    select 
        id, 
        size_of_colony, 
        rank() over (order by size_of_colony desc) as r,
        count(*) over() as total
    from ECOLI_DATA
)

select 
    tmp.id,
    case 
        when tmp.r <= total/4 then 'CRITICAL' 
        when tmp.r <= 2*total/4 then 'HIGH'
        when tmp.r <= 3*total/4 then 'MEDIUM' 
        when tmp.r > 3*total/4 then 'LOW' 
    end as colony_name
from tmp
order by 1 asc;