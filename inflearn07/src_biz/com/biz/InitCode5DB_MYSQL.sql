--[[[ INITCODE5DBBYDEV_01

DROP TABLE BZ_BOARD;

--]]]
--[[[ INITCODE5DBBYDEV_02

CREATE TABLE BZ_BOARD(
N INT(10) AUTO_INCREMENT
, TITLE VARCHAR(1000)
, TXT VARCHAR(1000)
, EM VARCHAR(1000)
, FILE_NM_1 VARCHAR(1000)
, FILE_ID_1 VARCHAR(1000)
, FILE_NM_2 VARCHAR(1000)
, FILE_ID_2 VARCHAR(1000)
, RG_ID VARCHAR(1000)
, RG_IP VARCHAR(1000)
, RG_DTM VARCHAR(1000)
, MDF_ID VARCHAR(1000)
, MDF_IP VARCHAR(1000)
, MDF_DTM VARCHAR(1000)
, DEL_Y VARCHAR(1000)
, CONSTRAINT PK_BZ_BOARD PRIMARY KEY(N)
);

--]]]

--[[[ INITCODE5DBBYDEV_03

DROP TABLE BZ_ID;

--]]]
--[[[ INITCODE5DBBYDEV_04

CREATE TABLE BZ_ID (
ID VARCHAR(1000)
, PIN VARCHAR(1000)
, AUTH VARCHAR(1000)
, FAIL_CNT VARCHAR(1000)
, LAST_LOGIN_DTM VARCHAR(1000)
);

--]]]
--[[[ INITCODE5DBBYDEV_05


INSERT INTO BZ_ID VALUES(
'admin'
,'413190dd77a132b98077112e493ce5bceef53ef60dfb4360764c1f9ceba85289'
,'A0'
,'0'
,''
);

--]]]
--[[[ INITCODE5DBBYDEV_06

INSERT INTO BZ_ID VALUES(
'user1'
,'eaab2eac6bfb55c5994efbac5ec6b116a45f53892649c700003fdeeab765a1a3'
,'U0'
,'0'
,''
);

--]]]
--[[[ INITCODE5DBBYDEV_07

INSERT INTO BZ_ID VALUES(
'user2'
,'5ced0bc626a116b6dafbf341db47bad167c444f53c4a769d8d7c09e1c6231c17'
,'U0'
,'0'
,''
);

--]]]
--[[[ INITCODE5DBBYDEV_08


drop table FW_CONTROLLER;

--]]]
--[[[ INITCODE5DBBYDEV_09

CREATE TABLE FW_CONTROLLER(
FW_KEY VARCHAR(1000)
, CLASS_NAME VARCHAR(1000)
, METHOD_NAME VARCHAR(1000)
);

--]]]
--[[[ INITCODE5DBBYDEV_10


INSERT INTO FW_CONTROLLER VALUES('file001','com.code5.fw.web.MasterControllerMultipart','file001');

--]]]
--[[[ INITCODE5DBBYDEV_11

INSERT INTO FW_CONTROLLER VALUES('exeLogin','com.biz.login.Login','exeLogin');

--]]]
--[[[ INITCODE5DBBYDEV_12
INSERT INTO FW_CONTROLLER VALUES('exeLogout','com.biz.login.Login','exeLogout');

--]]]
--[[[ INITCODE5DBBYDEV_13
INSERT INTO FW_CONTROLLER VALUES('callLogin','com.biz.login.Login','callLogin');

--]]]
--[[[ INITCODE5DBBYDEV_14


INSERT INTO FW_CONTROLLER VALUES('callList','com.biz.board.Board','callList');

--]]]
--[[[ INITCODE5DBBYDEV_15
INSERT INTO FW_CONTROLLER VALUES('callWrite','com.biz.board.Board','callWrite');

--]]]
--[[[ INITCODE5DBBYDEV_16
INSERT INTO FW_CONTROLLER VALUES('callUpdate','com.biz.board.Board','callUpdate');

--]]]
--[[[ INITCODE5DBBYDEV_17
INSERT INTO FW_CONTROLLER VALUES('listJson','com.biz.board.Board','listJson');

--]]]
--[[[ INITCODE5DBBYDEV_18


INSERT INTO FW_CONTROLLER VALUES('exeUpdate','com.biz.board.Board','exeUpdate');

--]]]
--[[[ INITCODE5DBBYDEV_19
INSERT INTO FW_CONTROLLER VALUES('exeWrite','com.biz.board.Board','exeWrite');

--]]]
--[[[ INITCODE5DBBYDEV_20
INSERT INTO FW_CONTROLLER VALUES('exeDelete','com.biz.board.Board','exeDelete');

--]]]
--[[[ INITCODE5DBBYDEV_21

INSERT INTO FW_CONTROLLER VALUES('delete','com.biz.board.Board','delete');

--]]]

--[[[ INITCODE5DBBYDEV_21_2

INSERT INTO FW_CONTROLLER VALUES('readBoardAndCheckRgId','com.biz.board.Board','readBoardAndCheckRgId');

--]]]


--[[[ INITCODE5DBBYDEV_22

INSERT INTO FW_CONTROLLER VALUES('forceDelete','com.biz.board.BoardAdmin','forceDelete');

--]]]
--[[[ INITCODE5DBBYDEV_23
INSERT INTO FW_CONTROLLER VALUES('allDelete','com.biz.board.BoardAdmin','allDelete');

--]]]
--[[[ INITCODE5DBBYDEV_24
INSERT INTO FW_CONTROLLER VALUES('allUpdate','com.biz.board.BoardAdmin','allUpdate');

--]]]


--[[[ INITCODE5DBBYDEV_25


drop TABLE FW_VIEW ;

--]]]
--[[[ INITCODE5DBBYDEV_26

CREATE TABLE FW_VIEW (
FW_KEY VARCHAR(1000)
, VIEW VARCHAR(1000)
, TMPL VARCHAR(1000)
, TITLE VARCHAR(1000)
);

--]]]
--[[[ INITCODE5DBBYDEV_27


INSERT INTO FW_VIEW VALUES('file001','/WEB-INF/classes/com/code5/fw/web/jsp/file001.jsp','','');

--]]]
--[[[ INITCODE5DBBYDEV_28
INSERT INTO FW_VIEW VALUES('null','/WEB-INF/classes/com/code5/fw/web/jsp/null.jsp','','');

--]]]
--[[[ INITCODE5DBBYDEV_29
INSERT INTO FW_VIEW VALUES('err','/WEB-INF/classes/com/code5/fw/web/jsp/err.jsp','','');

--]]]
--[[[ INITCODE5DBBYDEV_30

INSERT INTO FW_VIEW VALUES('login','/WEB-INF/classes/com/biz/login/jsp/login.jsp','','');

--]]]
--[[[ INITCODE5DBBYDEV_31S


INSERT INTO FW_VIEW VALUES('list','/WEB-INF/classes/com/biz/board/jsp/list.jsp','/WEB-INF/classes/com/biz/board/jsp/main.jsp','list');



--]]]
--[[[ INITCODE5DBBYDEV_32

INSERT INTO FW_VIEW VALUES('write','write.jsp','main.jsp','write');


--]]]
--[[[ INITCODE5DBBYDEV_33
INSERT INTO FW_VIEW VALUES('update','update.jsp','main.jsp','update');

--]]]
--[[[ INITCODE5DBBYDEV_34

drop table FW_UPLOAD_FILE;

--]]]
--[[[ INITCODE5DBBYDEV_35
CREATE TABLE FW_UPLOAD_FILE (
FILE_ID VARCHAR(1000)
, SIZE VARCHAR(1000)
, CONTENT_TYPE VARCHAR(1000)
, FILE_NAME VARCHAR(1000)
, FILE_URL VARCHAR(1000)
, RG_ID VARCHAR(1000)
, RG_DTM VARCHAR(1000)
, DEL_Y VARCHAR(1000)
, DEL_ID VARCHAR(1000)
, DEL_DTM VARCHAR(1000)
);

--]]]
--[[[ INITCODE5DBBYDEV_36

drop table FW_DOWNLOAD_FILE;

--]]]
--[[[ INITCODE5DBBYDEV_37

CREATE TABLE FW_DOWNLOAD_FILE (
FILE_ID VARCHAR(1000)
, ID VARCHAR(1000)
, DTM VARCHAR(1000)
);

--]]]



--]]]
--[[[ INITCODE5DBBYDEV_38
INSERT INTO FW_CONTROLLER VALUES('brd01010','com.biz.brd.Brd01','brd01010');
--]]]
--[[[ INITCODE5DBBYDEV_39

INSERT INTO FW_CONTROLLER VALUES('brd01020','com.biz.brd.Brd01','brd01020');
--]]]
--[[[ INITCODE5DBBYDEV_40

INSERT INTO FW_CONTROLLER VALUES('brd01021','com.biz.brd.Brd01','brd01021');
--]]]
--[[[ INITCODE5DBBYDEV_41

INSERT INTO FW_CONTROLLER VALUES('brd01030','com.biz.brd.Brd01','brd01030');
--]]]
--[[[ INITCODE5DBBYDEV_42

INSERT INTO FW_CONTROLLER VALUES('brd01031','com.biz.brd.Brd01','brd01031');
--]]]
--[[[ INITCODE5DBBYDEV_43

INSERT INTO FW_CONTROLLER VALUES('brd01040','com.biz.brd.Brd01','brd01040');
--]]]
--[[[ INITCODE5DBBYDEV_44

INSERT INTO FW_CONTROLLER VALUES('Brd01.delete','com.biz.brd.Brd01','delete');
--]]]
--[[[ INITCODE5DBBYDEV_45

INSERT INTO FW_CONTROLLER VALUES('brd02011','com.biz.brd.Brd02','brd02011');
--]]]
--[[[ INITCODE5DBBYDEV_46

INSERT INTO FW_CONTROLLER VALUES('brd02021','com.biz.brd.Brd02','brd02021');
--]]]
--[[[ INITCODE5DBBYDEV_47

INSERT INTO FW_CONTROLLER VALUES('brd02031','com.biz.brd.Brd02','brd02031');
--]]]

--[[[ INITCODE5DBBYDEV_48
INSERT INTO FW_VIEW VALUES('brd01010','brd01010.jsp','brdtmpl.jsp','list');
--]]]

--[[[ INITCODE5DBBYDEV_49
INSERT INTO FW_VIEW VALUES('brd01020','brd01020.jsp','brdtmpl.jsp','write');
--]]]


--[[[ INITCODE5DBBYDEV_50

INSERT INTO FW_VIEW VALUES('listJson','listJson.jsp','','JSON');

--]]]

--[[[ INITCODE5DBBYDEV_51

INSERT INTO FW_CONTROLLER VALUES('admin001','com.code5.fw.web.Admin','admin001');

--]]]


--[[[ INITCODE5DBBYDEV_BZ_BOARD_I1
INSERT INTO BZ_BOARD (TITLE, TXT) VALUES('TITLE 1','TXT 1');
--]]]

--[[[ INITCODE5DBBYDEV_BZ_BOARD_I2
INSERT INTO BZ_BOARD (TITLE, TXT) VALUES('TITLE 2','TXT 2');
--]]]

--[[[ INITCODE5DBBYDEV_BZ_BOARD_I3
INSERT INTO BZ_BOARD (TITLE, TXT) VALUES('TITLE 3','TXT 3');
--]]]
