-- 평균 길이가 33 이상인 물고기들 종류별로 분류
-- 잡은 수, 최대 길이, 종류
# with tmp as (
#     select 
#         fish_type,
#         case 
#             when length < 10 then 10
#             when length is null then 10
#         end as len
#     from fish_info
# ),
# tmp2 as (
#     select
#         fish_type as ft
#     from tmp
#     where avg(len) >= 33
#     group by fish_type
# )

# select 
#     count(tmp2.ft),
#     max


# SELECT 
#     COUNT(*) FISH_COUNT, 
#     MAX(LENGTH) MAX_LENGTH, 
#     FISH_TYPE
# FROM FISH_INFO 
# GROUP BY FISH_TYPE
# HAVING 
#     avg(CASE 
#             WHEN LENGTH <= 10 or LENGTH is null THEN 10 
#             ELSE LENGTH 
#         END) >= 33
# ORDER BY FISH_TYPE;


-- 평균 길이가 33 이상인 물고기들 종류별로 분류
-- 잡은수, 최대 길이, 물고기 종류 출력
-- 물고기 종류 오름차순, 10이하는 10으로

select
    count(*) as fish_count,
    max(length) as max_length,
    fish_type
from fish_info
group by fish_type
having avg(
          case 
            when length is null then 10
            else length end  
        ) >= 33
order by 3 asc;
