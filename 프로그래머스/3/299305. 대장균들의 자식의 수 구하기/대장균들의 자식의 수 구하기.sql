with b as (
    select
        parent_id as p,
        count(*) as c
    from ECOLI_DATA
    group by parent_id
)

select
    a.id,
    case when b.c is null then 0
    else b.c end as child_count
from ECOLI_DATA a
left join b on a.id = b.p;