# with tmp as (
#     select count(*), member_id
#     from rest_review
#     group by member_id
#     order by 1 desc
#     limit 1
# )

# SELECT
#     m.MEMBER_NAME,
#     r.REVIEW_TEXT,
#     date_format(r.REVIEW_DATE, '%Y-%m-%d')
# from MEMBER_PROFILE m
# join REST_REVIEW r
#     on m.member_id = r.member_id
# where m.member_id = (select member_id from tmp)
# order by 3 asc, 2 asc;


-- 리뷰를 가장 많이 작성한 회원들의 리뷰
-- 이름, 리뷰, 작성일
with tmp as (
    select *
    from REST_REVIEW
    group by member_id
    order by count(*) desc
    limit 1
)

select m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date
from MEMBER_PROFILE m
join REST_REVIEW r on r.member_id = m.member_id
where m.member_id in (
            select member_id
            from tmp
        )
order by 3 asc, 2 asc;