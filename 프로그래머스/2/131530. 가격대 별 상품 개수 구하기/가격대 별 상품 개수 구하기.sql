SELECT 
    floor(price/10000) * 10000 as price_group, 
    count(*) as products
from PRODUCT
group by price_group
order by 1 asc;

# select floor(price/10000) * 10000
# from product;