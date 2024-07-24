-- 코드를 입력하세요
SELECT b.user_id, b.nickname, 
    concat(b.city,' ',b.street_address1, 
           ' ', b.street_address2) as '전체주소',
    concat(substring(b.tlno, 1, 3),'-',
          substring(b.tlno, 4, 4),'-',
          substring(b.tlno, 8, 4)) as '전화번호' -- 전화번호 - 짝대기 붙이기
from used_goods_user b

join used_goods_board a
on a.writer_id = b.user_id

group by a.writer_id
having count(a.writer_id) >= 3
order by 1 desc;