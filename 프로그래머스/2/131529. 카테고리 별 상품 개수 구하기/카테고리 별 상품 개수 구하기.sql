SELECT substring(product_code, 1, 2) as category, count(*) as products
from product
group by category
order by 1 asc;