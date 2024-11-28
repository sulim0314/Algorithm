-- 코드를 입력하세요
SELECT animal_id, name,
    case when SEX_UPON_INTAKE like '%Neutered%' or 
    SEX_UPON_INTAKE like '%Spayed%' then 'O'
    else 'X' end as 중성화
from animal_ins
order by 1 asc;