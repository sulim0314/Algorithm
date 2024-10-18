-- 코드를 입력하세요
# SELECT A.FLAVOR
# FROM (
#     SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
#     FROM FIRST_HALF
#     GROUP BY FLAVOR
#     ) A

# JOIN (
#     SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
#     FROM JULY
#     GROUP BY FLAVOR
#     ) B
    
#     ON A.FLAVOR = B.FLAVOR

# ORDER BY (A.TOTAL_ORDER + B.TOTAL_ORDER) DESC
# LIMIT 3;

-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 3개

with tmp1 as (
    select flavor, sum(total_order) as total
    from july
    group by flavor
)

select f.flavor 
from FIRST_HALF f
join tmp1 t on t.flavor = f.flavor
order by (t.total + f.total_order) desc
limit 3;

