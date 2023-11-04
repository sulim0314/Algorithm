-- 코드를 입력하세요

-- select 
--     name, 
--     count(name) as cnt 
-- from animal_ins
--     where name is not null
--     group by name
--     HAVING count(name) > 1
-- order by name

SELECT NAME, COUNT(*) AS COUNT
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
HAVING count(name) > 1
ORDER BY NAME;
