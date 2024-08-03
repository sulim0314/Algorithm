# with tmp as (
#     select month(time) as m
#     from fish_info
#     group 
# )

select 
    count(month(time)) as fish_count,
    month(time) as month
from fish_info
group by month(time)
order by 2 asc;
