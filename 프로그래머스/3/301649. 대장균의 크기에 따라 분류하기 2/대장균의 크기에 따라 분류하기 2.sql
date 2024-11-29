with tmp as (
    select
        id,
        rank() over(order by SIZE_OF_COLONY desc) as s,
        (SELECT COUNT(*) FROM ecoli_data) AS total_count
    from ecoli_data
)

select
    id,
    case
        when s/total_count <= 0.25 then 'CRITICAL'
        when s/total_count <= 0.5 then 'HIGH'
        when s/total_count <= 0.75 then 'MEDIUM'
    else 'LOW' end as COLONY_NAME
from tmp
order by 1 asc;