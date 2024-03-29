-- 코드를 입력하세요
SELECT 
    B.AUTHOR_ID, 
    B.AUTHOR_NAME, 
    A.CATEGORY,
    SUM(C.SALES * A.PRICE)
FROM 
    BOOK A, AUTHOR B, BOOK_SALES C
WHERE 
    A.BOOK_ID = C.BOOK_ID
    AND A.AUTHOR_ID = B.AUTHOR_ID
    AND EXTRACT (YEAR FROM C.SALES_DATE) = 2022 
    AND EXTRACT (MONTH FROM C.SALES_DATE) = 1
GROUP BY 
    B.AUTHOR_ID,
    B.AUTHOR_NAME, -- 추가
    A.CATEGORY
ORDER BY 1 ASC, 3 DESC;