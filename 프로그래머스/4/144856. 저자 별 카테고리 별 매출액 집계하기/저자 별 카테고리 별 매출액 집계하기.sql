-- 2022.01의 도서 판매 데이터를 기준으로
-- 저자 별, 카테고리 별 매출액 을 구하여
-- 저자 id, 저자명, 카테고리, 매출액 리스트 출력
with tmp1 as (
    select b.book_id, a.author_name, b.category, b.author_id, b.price
    from book b
    join author a on b.author_id = a.author_id
),
tmp2 as (
    select book_id, sum(sales) as total
    from book_sales
    where sales_date like '2022-01%'
    group by book_id
)

# select * from tmp1;
# select * from tmp2;

SELECT tmp1.author_id, tmp1.author_name, tmp1.category, 
    sum(tmp1.price * tmp2.total) as total_sales
from tmp1
join tmp2 on tmp1.book_id = tmp2.book_id
group by tmp1.author_id, tmp1.category
order by 1 asc, 3 desc;