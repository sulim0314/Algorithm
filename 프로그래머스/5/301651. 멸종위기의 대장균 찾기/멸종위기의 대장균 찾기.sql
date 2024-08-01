with recursive GENERATION as (
    select id, 1 as g_level
    from ECOLI_DATA
    where parent_id is null
union all
    select e.id, g.g_level+1 as g_level
    from ECOLI_DATA e
        join GENERATION g on e.parent_id = g.id
)

select
    count(*) as 'count',
    g.g_level as generation
from generation g
    left join ECOLI_DATA e on e.parent_id = g.id
where e.id is null
group by GENERATION
order by 2 asc;