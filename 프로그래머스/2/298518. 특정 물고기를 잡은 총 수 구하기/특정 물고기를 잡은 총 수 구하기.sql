with tmp as (
    select fi.fish_type, fni.fish_name
    from FISH_INFO fi
    join FISH_NAME_INFO fni on fi.fish_type = fni.fish_type
)

select count(*) as fish_count
from tmp
where tmp.fish_name = 'bass' or tmp.fish_name = 'snapper';