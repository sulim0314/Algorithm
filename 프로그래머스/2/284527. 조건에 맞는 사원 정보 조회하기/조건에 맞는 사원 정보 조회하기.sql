-- 2022년 한해 평가 점수가 가장 높은 사원 정보 조회.
-- 점수, 사번, 성명, 직책, 이메일

with tmp as (
    select
        emp_no,
        sum(score) as total
    from HR_GRADE
    group by emp_no
),
tmp_max as (
    select
        max(tmp.total) as m
    from tmp
)

select 
    tm.m as score,
    he.emp_no,
    he.emp_name,
    he.position,
    he.email
from HR_EMPLOYEES he
join tmp t on he.emp_no = t.emp_no
join tmp_max tm on t.total = tm.m;
