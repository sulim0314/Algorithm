-- 코드를 입력하세요
# with tmp as (
#     select
#         host_id as h,
#         count(*) as c
#     from places
#     group by host_id
# )

# SELECT 
#     p.id,
#     p.name,
#     p.host_id
# from places p

# join tmp t on t.h = p.host_id
# where t.c >= 2

# order by 1 asc;
with tmp as (
    select host_id, count(*) as num
    from places
    group by host_id
)

select p.id, p.name, p.host_id
from places p
join tmp t on p.host_id = t.host_id
where t.num >= 2
order by 1 asc;
