-- 코드를 입력하세요
# SELECT a.PRODUCT_ID, a.PRODUCT_NAME, (a.price * b.amount) as TOTAL_SALES
# FROM food_product a

# JOIN (
#     select product_id, sum(amount) as amount
#     from food_order
#     where produce_date LIKE '2022-05%'
#     GROUP BY product_id
# ) b
# ON a.product_id = b.product_id

# order by 3 desc, 1 asc;


-- 생산일자가 2022.05인 식품들의
-- 식품id, 식품 이름, 총매출 초회

select a.product_id, a.product_name, (a.price * b.amount) as total_sales
from food_product a

join (
    select product_id, sum(amount) as amount
    from food_order
    where produce_date like '2022-05%'
    group by product_id
    ) b
    on a.product_id = b.product_id

order by 3 desc, 1 asc;