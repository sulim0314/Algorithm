-- 코드를 입력하세요
# SELECT a.NAME, a.DATETIME, ROW_NUMBER() OVER (ORDER BY a.DATETIME ASC) as num
# from animal_ins a
# where a.animal_id not in (
#         select animal_id
#         from animal_outs
#     )
# order by 2 asc
# limit 3;

-- 아직 입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리의 이름, 보호 시작일
select 
    a.name, a.datetime
from animal_ins a
where a.animal_id 
    not in (
        select animal_id
        from animal_outs
    )
order by 2 asc
limit 3;