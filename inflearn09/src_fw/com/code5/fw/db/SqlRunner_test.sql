--[[[ SQLRUNNER_TEST_01

SELECT 
N 
, TITLE
, RG_DTM PRN_DTM__DTM
, RG_ID
FROM
BZ_BOARD
WHERE TITLE LIKE '%'||[TITLE]||'%'
AND DEL_Y IS NULL
ORDER BY N

--]]]

--[[[ SQLRUNNER_TEST_02

UPDATE BZ_BOARD
SET DEL_Y = 'Y'
WHERE N = [N]



--]]]

--[[[ SQLRUNNER_TEST_04

[~ P1 ^ IS_NOT_NULL ^ AND [P1] = [P1] ~]
[~ P2 ^ IS_NULL ^ AND 2 = 2 ~]
[~ P3 ^ Y ^ AND 'Y' = [P3] ~]

--]]]

--[[[ SQLRUNNER_TEST_03

SELECT
[HP_N] HP_N
, [HP_N] PRN_HP_N__HP_N2__DEC
, [HP_N__ENC] HP_N3
, [SYSDTM.DTM] DTM1
, [SYSDTM.DTM] PRN_DTM__DTM2
, [SESSIONB.ID] SESSION_ID
, [SESSIONB.IP] SESSION_IP
, [SESSIONB.AUTH] SESSION_AUTH
, [PIN__PIN, ID ] PIN
FROM BZ_BOARD
WHERE 1 = 1

[~ P1 ^ IS_NOT_NULL ^ AND [P1] = [P1] ~]
[~ P2 ^ IS_NULL ^ AND 2 = 2 ~]
[~ P3 ^ Y ^ AND 'Y' = [P3] ~]

[[ com.code5.fw.db.SqlRunner_test.SQLRUNNER_TEST_04 ]]

AND 'FIN'='FIN'

--]]]