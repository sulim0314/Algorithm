with 
    tmp as (
        select board_id as b
        from USED_GOODS_BOARD
        order by USED_GOODS_BOARD.views desc
        limit 1
    )


SELECT 
    concat('/home/grep/src/', board_id, '/', file_id, file_name, file_ext) as FILE_PATH
from USED_GOODS_FILE a
join tmp
where a.board_id = tmp.b
order by 1 desc;