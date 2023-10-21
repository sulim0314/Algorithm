-- 코드를 입력하세요
-- SELECT * FROM APPOINTMENT;
-- SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
-- FROM APPOINTMENT
-- --WHERE APNT_CNCL_YN IS NOT 'N'
-- WHERE APNT_YMD LIKE '2022-05%'
-- GROUP BY MCDP_CD
-- ORDER BY '5월예약건수' ASC, '진료과코드' ASC;

-- SELECT MCDP_CD AS "진료과 코드", COUNT(*) AS "5월예약건수"
-- FROM APPOINTMENT
-- WHERE APNT_YMD LIKE '2022-05%'
-- GROUP BY MCDP_CD
-- ORDER BY "5월예약건수" ASC, "MCDP_CD" ASC;

SELECT MCDP_CD "진료과 코드",COUNT(MCDP_CD) "5월예약건수"
FROM APPOINTMENT
WHERE APNT_YMD BETWEEN TO_DATE('20220501','YYYY-MM-DD') AND TO_DATE('20220531','YYYY-MM-DD') 
GROUP BY MCDP_CD
ORDER BY "5월예약건수" ASC,"진료과 코드" ASC