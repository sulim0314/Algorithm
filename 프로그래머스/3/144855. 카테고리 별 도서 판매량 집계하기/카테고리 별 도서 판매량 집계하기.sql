# select a.category, sum(b.sales) as total_sales
# from book a

# join book_sales b on a.book_id = b.book_id
# where date_format(b.sales_date, '%Y-%m') = '2022-01'

# group by a.category
# order by 1;

SELECT a.category, SUM(b.sales) AS total_sales
FROM book a
JOIN book_sales b ON a.book_id = b.book_id
WHERE b.sales_date LIKE '2022-01%'
GROUP BY a.category
ORDER BY 1;
