with tmp as (
    select item_id
    from item_info
    where rarity = 'RARE'
),

tmp2 as (
    select item_tree.item_id
    from item_tree
    join tmp t on t.item_id = item_tree.parent_item_id
)

select i.item_id, i.item_name, i.rarity 
from item_info i
join tmp2 t2 on t2.item_id = i.item_id
order by 1 desc;