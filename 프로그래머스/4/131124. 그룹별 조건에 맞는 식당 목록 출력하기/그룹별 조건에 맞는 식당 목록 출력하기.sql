with tmp as (
    select count(*), member_id
    from rest_review
    group by member_id
    order by 1 desc
    limit 1
)

SELECT
    m.MEMBER_NAME,
    r.REVIEW_TEXT,
    date_format(r.REVIEW_DATE, '%Y-%m-%d')
from MEMBER_PROFILE m
join REST_REVIEW r
    on m.member_id = r.member_id
where m.member_id = (select member_id from tmp)
order by 3 asc, 2 asc;