-- 코드를 입력하세요
-- 보호소에서 중성화 수술을 거친 동물 정보.
-- 들어올 당시에는 중성화 노
-- 나갈 당시에는 중성되 예스
SELECT a.animal_id, a.animal_type, a.name
from animal_ins a 
    join ANIMAL_OUTS b
    on a.animal_id = b.animal_id
where a.SEX_UPON_INTAKE in("Intact Male", "Intact Female")
    and b.SEX_UPON_OUTCOME in ("Spayed Female", "Neutered Male")
order by a.animal_id;

