with tmp as (
    select floor(price/10000) * 10000 as p
    from PRODUCT
)

SELECT 
    p as price_group, 
    count(*) as products
from tmp 
group by p
order by 1 asc;

# select floor(price/10000) * 10000
# from product;