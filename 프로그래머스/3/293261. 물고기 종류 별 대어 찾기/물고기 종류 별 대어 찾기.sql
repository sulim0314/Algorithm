-- 코드를 작성해주세요

# SELECT ID, FISH_NAME, LENGTH
# FROM FISH_INFO JOIN FISH_NAME_INFO USING(FISH_TYPE)

# WHERE (FISH_TYPE, LENGTH)
#     IN (
#         SELECT FISH_TYPE, MAX(LENGTH) AS LENGTH
#         FROM FISH_INFO
#         GROUP BY FISH_TYPE
#     );


-- 물고기 종류 별로 가장 큰 물고기 id, 이름, 길이
with tmp as (
    select fish_type, MAX(length) as len
    from FISH_INFO
    group by fish_type
)

select f.id, fn.fish_name, f.length
from FISH_INFO f
join tmp t on f.fish_type = t.fish_type
join fish_name_info fn on fn.fish_type = f.fish_type
where f.length = t.len
order by 1 asc;
