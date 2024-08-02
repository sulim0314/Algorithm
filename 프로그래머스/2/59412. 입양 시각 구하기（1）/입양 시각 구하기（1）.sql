SELECT
    HOUR(DATETIME) as HOUR,
    count(*) as 'COUNT'
from ANIMAL_OUTS
where HOUR(DATETIME) between 9 and 19
group by hour
order by 1 asc;