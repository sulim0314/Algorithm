with tmp as (
    select 
        year(DIFFERENTIATION_DATE) as y,
        max(SIZE_OF_COLONY) as m
    from ECOLI_DATA
    group by y
)

select
    year(DIFFERENTIATION_DATE) as year,
    tmp.m - SIZE_OF_COLONY as year_dev,
    id
from ECOLI_DATA e
join tmp on YEAR(e.DIFFERENTIATION_DATE) = tmp.y
order by 1 asc, 2 asc;

