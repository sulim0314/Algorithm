-- 코드를 입력하세요
# SELECT A.ANIMAL_ID, A.NAME
# FROM ANIMAL_OUTS A
# JOIN ANIMAL_INS B
#     ON A.ANIMAL_ID = B.ANIMAL_ID
# ORDER BY TIMESTAMPDIFF(SECOND, B.DATETIME, A.DATETIME) DESC
# LIMIT 2;

select a.animal_id, a.name
from animal_ins a
join animal_outs b
    on a.animal_id = b.animal_id
order by (b.datetime - a.datetime) desc
limit 2;