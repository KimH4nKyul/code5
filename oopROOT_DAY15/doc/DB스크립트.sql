drop TABLE BZ_ALNC;

CREATE TABLE BZ_ALNC (
KEY -- KEY
, ALNC_DTM  -- �����Ͻ�
, ALNC_N -- ���ι�ȣ
, CRD_N -- ī���ȣ
, AMT -- ���αݾ�
, RET -- ���ΰ��
, RG_ID -- �Է¾��̵�
, RG_IP -- �Է¾�����
, RG_DTM -- �Է½ð�
, MDF_ID -- �������̵�
, MDF_IP -- ����������
, MDF_DTM -- �����ð�
, PRIMARY KEY(KEY)
);

CREATE UNIQUE INDEX IX_BZ_ALNC_01 ON BZ_ALNC(ALNC_DTM, ALNC_N, CRD_N);



delete from fw_sql WHERE KEY LIKE 'EXE001%';

insert into fw_sql values('EXE001D_01','INSERT INTO BZ_ALNC (
KEY
, CRD_N
, AMT
, RG_ID
, RG_IP
, RG_DTM
) VALUES (
[KEY]
, [ENC_CRD_N]
, [AMT]
, [USER_ID]
, [USER_IP]
, [DTM]
)
');

insert into fw_sql values('EXE001D_02','UPDATE BZ_ALNC
SET ALNC_DTM = [ALNC_DTM]
, ALNC_N = [ALNC_N]
, RET = [RET]
, MDF_ID = [USER_ID]
, MDF_IP = [USER_IP]
, MDF_DTM = [MDF_DTM]
WHERE KEY = [KEY]
');

insert into fw_sql values ('EXE001D_03','SELECT 
KEY
, ALNC_DTM
, ALNC_N
, CRD_N
, AMT
, RET
, RG_ID
, RG_IP
, RG_DTM
, MDF_ID
, MDF_IP
, MDF_DTM
FROM BZ_ALNC
WHERE RG_ID = [USER_ID]
ORDER BY RG_DTM DESC 
');

insert into fw_sql values ('EXE001D_04','SELECT 
KEY
, ALNC_DTM
, ALNC_N
, CRD_N
, AMT
, RET
, RG_ID
, RG_IP
, RG_DTM
, MDF_ID
, MDF_IP
, MDF_DTM
FROM BZ_ALNC
WHERE RG_ID = [USER_ID]
AND CRD_N = [ENC_CRD_N] 
ORDER BY ALNC_DTM DESC 
');


insert into fw_controller values ('exe00110','com.code5.biz.exe001.Exe001','exe00110','Y','');
insert into fw_controller values ('exe00111','com.code5.biz.exe001.Exe001','exe00111','Y','');
insert into fw_controller values ('exe00120','com.code5.biz.exe001.Exe001','exe00120','Y','');

insert into fw_view values ('exe00110','/WEB-INF/classes/com/code5/biz/exe001/jsp/exe00110.jsp');
insert into fw_view values ('exe00120','/WEB-INF/classes/com/code5/biz/exe001/jsp/exe00120.jsp');


0