with tmp as (
    select year(DIFFERENTIATION_DATE) as y, MAX(SIZE_OF_COLONY) as m
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
)

select 
    year(e.DIFFERENTIATION_DATE) as year,
    (t.m - e.SIZE_OF_COLONY) as year_dev,
    e.id
from ECOLI_DATA e
join tmp t on t.y = year(e.DIFFERENTIATION_DATE)
order by 1 asc, 2 asc;