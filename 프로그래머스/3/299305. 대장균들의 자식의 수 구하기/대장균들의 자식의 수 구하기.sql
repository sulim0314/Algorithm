# with b as (
#     select
#         parent_id as p,
#         count(*) as c
#     from ECOLI_DATA
#     group by parent_id
# )

# select
#     a.id,
#     ifnull(b.c, 0) as child_count
# from ECOLI_DATA a
# left join b on a.id = b.p;

-- 대장균 개체의 id와 자식의 수를 출력하는 sql
-- 자식이 없다면 0, id 오름차순
with child as (
    select parent_id, count(*) as cnt
    from ECOLI_DATA
    where parent_id is not null
    group by parent_id
)

select e.id, 
    case when c.cnt is null then 0
        else c.cnt end as child_count
from ECOLI_DATA e
left join child c on e.id = c.parent_id
order by 1 asc;