-- 노션별로 노선, 총 누계 거리, 평균 역 사이 거리

select
    route,
    concat(round(sum(D_BETWEEN_DIST),1),'km') as total_distance,
    concat(round(avg(D_BETWEEN_DIST),2),'km') as average_distance
from SUBWAY_DISTANCE
group by route
order by SUM(D_BETWEEN_DIST) DESC;