WITH tmp as (
    select 
        user_id as u,
        gender as g
    from USER_INFO
    where gender is not null
) -- gender가 있는 user_id, gender
    
SELECT 
    YEAR(o.sales_date) as YEAR,
    MONTH(o.sales_date) as MONTH,
    t.g as GENDER,
    COUNT(distinct o.user_id)as USERS
from 
    ONLINE_SALE o
join 
    tmp t on o.user_id = t.u
group by
    YEAR(o.sales_date), MONTH(o.sales_date), t.g
order by 1 asc, 2 asc, 3 asc, 4 asc;