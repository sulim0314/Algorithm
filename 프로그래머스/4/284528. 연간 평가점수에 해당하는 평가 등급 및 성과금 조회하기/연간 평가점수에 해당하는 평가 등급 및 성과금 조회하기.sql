with tmp as (
    select
        emp_no,
        case 
            when avg(score) >= 96 then 'S'
            when avg(score) >= 90 then 'A'
            when avg(score) >= 80 then 'B'
            else 'C'
        end as GRADE
    from HR_GRADE
    group by emp_no
)

select
    h.emp_no,
    h.emp_name,
    tmp.grade,
    case 
        when tmp.grade = 'S' then h.SAL * 0.20
        when tmp.grade = 'A' then h.SAL * 0.15
        when tmp.grade = 'B' then h.SAL * 0.10
        else h.SAL * 0
    end as bonus
from HR_EMPLOYEES h
join tmp on tmp.emp_no = h.emp_no
