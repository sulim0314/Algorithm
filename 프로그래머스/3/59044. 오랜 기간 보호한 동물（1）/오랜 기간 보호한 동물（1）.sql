-- 코드를 입력하세요
-- animalID ins엔 있는데 out엔 없는 것
SELECT a.NAME, a.DATETIME
from animal_ins a
where a.animal_id not in (
        select animal_id
        from animal_outs
    )
order by 2 asc
limit 3;

