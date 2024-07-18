-- 코드를 입력하세요
SELECT a.PRODUCT_ID, a.PRODUCT_NAME, (a.price * b.amount) as TOTAL_SALES
FROM food_product a

JOIN (
    select product_id, sum(amount) as amount
    from food_order
    where produce_date LIKE '2022-05%'
    GROUP BY product_id
) b
ON a.product_id = b.product_id

order by 3 desc, 1 asc;