-- 코드를 입력하세요
# SELECT * from used_goods_board;
# select * from used_goods_reply;

select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, 
        date_format(r.created_date, '%Y-%m-%d') as created_date
from USED_GOODS_BOARD as b
inner join used_goods_reply as r
on b.BOARD_ID = r.BOARD_ID
where date_format(b.CREATED_DATE, '%Y-%m') = '2022-10'
order by CREATED_DATE asc, title asc;
