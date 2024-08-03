-- 물고기의 종류 별 물고기의 이름과 잡은 수 출력
with tmp as (
    select 
        fish_type,
        count(*) as c
    from FISH_INFO
    group by fish_type
)

select 
    t.c as fish_count,
    f.fish_name as fish_name
from 
    tmp t
left join FISH_NAME_INFO f on t.fish_type = f.fish_type
order by 1 desc;