with recursive tmp as (
    select
        id,
        parent_id,
        1 as gen
    from ECOLI_DATA
    where parent_id is null

    union all
    
    select
        e.id,
        e.parent_id,
        g.gen+1 as gen
    from ECOLI_DATA e
    join tmp g on e.parent_id = g.id
)

SELECT
    count(id) as count,
    gen as generation
FROM tmp
WHERE id NOT IN (SELECT parent_id FROM ECOLI_DATA WHERE parent_id IS NOT NULL)
group by gen
ORDER BY 2 asc;