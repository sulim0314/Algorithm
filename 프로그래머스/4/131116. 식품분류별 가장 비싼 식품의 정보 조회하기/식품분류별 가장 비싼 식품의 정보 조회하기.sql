-- 코드를 입력하세요
SELECT a.CATEGORY, a.PRICE as MAX_PRICE, a.PRODUCT_NAME
FROM FOOD_PRODUCT a
join (
    Select category, max(price) as max_price
    From food_product
    WHERE CATEGORY in ('과자', '국', '김치', '식용유')
    GROUP BY CATEGORY    
) b
on a.category = b.category and a.price = b.max_price
ORDER BY 2 DESC;

# select * from food_product;


-- 식품분류(과자, 국, 김치, 식용유)별로 가격이 제일 비싼 식품의
-- 분류, 가격, 이름 조회
select a.category, a.price as max_price, a.product_name
from food_product a

join (
        select category, max(price) as p
        from food_product
        WHERE CATEGORY in ('과자', '국', '김치', '식용유')
        GROUP BY CATEGORY
    ) b
    on a.price = b.p and a.category = b.category

order by 2 desc;