-- 코드를 입력하세요
SELECT user_id, product_id
from online_sale
    group by user_id, product_id
    having count(user_id) > 1
order by user_id, product_id desc;

# SELECT USER_ID, PRODUCT_ID 
# FROM ONLINE_SALE
# GROUP BY USER_ID, PRODUCT_ID
# HAVING COUNT(USER_ID) > 1
# ORDER BY USER_ID, PRODUCT_ID DESC