-- 코드를 입력하세요
SELECT
    c.apnt_no,
    a.pt_name,
    a.pt_no,
    b.mcdp_cd,
    b.dr_name,
    c.apnt_ymd
from appointment c
    join patient a on a.pt_no = c.pt_no
    join doctor b on c.mddr_id = b.dr_id

where c.apnt_ymd like '2022-04-13%'
    and c.apnt_cncl_yn = 'N'

order by 6 asc;