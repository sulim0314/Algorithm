-- 코드를 입력하세요

SELECT
    animal_type ,
    NVL(name , 'No name') as "Name" ,
    sex_upon_intake
FROM
    animal_ins
ORDER BY
    animal_id
