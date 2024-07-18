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