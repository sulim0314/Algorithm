with tmp1 as (
    select cart_id
    from CART_PRODUCTS
    where name = 'Milk'
    group by cart_id
),
tmp2 as (
    select cart_id
    from CART_PRODUCTS
    where name='Yogurt'
    group by cart_id
)

select tmp1.cart_id
from tmp1
inner join tmp2 on tmp1.cart_id = tmp2.cart_id;