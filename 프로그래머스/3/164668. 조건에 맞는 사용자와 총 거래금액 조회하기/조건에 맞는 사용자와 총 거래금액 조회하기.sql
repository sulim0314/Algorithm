-- 코드를 입력하세요
-- SELECT A.WRITER_ID, B.NICKNAME, SUM(A.PRICE) AS TOTAL_SALES
-- FROM USED_GOODS_BOARD A, USED_GOODS_USER B
-- WHERE A.WRITER_ID = B.USER_ID AND A.STATUS = 'DONE'
-- GROUP BY 
--     A.WRITER_ID, 
--     B.NICKNAME
-- HAVING
--     SUM(A.PRICE) >= 700000
-- ORDER BY TOTAL_SALES ASC;

-- 완료된 중고거래, 총 금액 70만원 이상인 사람
-- 회원 id, 닉네임, 총거래금액

SELECT a.user_id, a.nickname, sum(b.price) as total_sales
FROM USED_GOODS_user a, USED_GOODS_BOARD b

where a.user_id = b.writer_id
    and b.status = 'DONE'

group by a.user_id, a.nickname
having sum(b.price) >= 700000

order by 3 asc;