# with recursive generation as (
#     select 
#         id,
#         parent_id,
#         1 as gen
#     from ECOLI_DATA
#     WHERE PARENT_ID IS NULL
    
#     union all
    
#     select
#         e.id,
#         e.parent_id,
#         g.gen + 1
#     from ECOLI_DATA e
    
#     inner join generation g on g.id = e.parent_id
# )

# select * from generation;

# select id
# from generation
# where gen = 3
# order by id;

with recursive gen as (
    select id, parent_id, 1 as gg
    from ECOLI_DATA
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.gg+1
    from ECOLI_DATA e
    join gen g on g.id = e.parent_id
)

select id
from gen
where gg = 3;