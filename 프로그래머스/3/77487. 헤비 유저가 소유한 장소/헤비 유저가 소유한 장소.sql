-- 코드를 입력하세요
with tmp as (
    select
        host_id as h,
        count(*) as c
    from places
    group by host_id
)

SELECT 
    p.id,
    p.name,
    p.host_id
from places p

join tmp t on t.h = p.host_id
where t.c >= 2

order by 1 asc;