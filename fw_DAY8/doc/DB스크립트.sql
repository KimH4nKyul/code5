cd C:\public\sqlite
sqlite3 C:\public\sqlite\code5.db

UPDATE BZ_ID SET PIN = 'a74fefefc7febabc96b8a4034670c62d24f7dec741162d7457795ab5c6bf8b2b' WHERE ID  = 'idA0';
UPDATE BZ_ID SET PIN = 'bf793a9f94407d4b2bbab9ef01f31522fd03d20cc65f480a186e90d1dcff5a5d' WHERE ID  = 'idU0';


drop TABLE FW_SRT;

CREATE TABLE FW_SRT (
OPT PRIMARY KEY
, MODE
, KEY
, IV
);


INSERT INTO FW_SRT VALUES ('S01','Aria_ECB_ZERO','E231C123B7512A8A9027E9EE99C0C684','');
INSERT INTO FW_SRT VALUES ('S02','Aria_CBC_PKCS7','B426E1A441F6DBFC2B2D2412D0066D20','52A9A4CC4FB1EF00A72FF87583D44E5C');
INSERT INTO FW_SRT VALUES ('S03','Aes_CBC_PKCS7','BF210BE9E2ED4620B442D5AF8D000E40','CF80492ACF3166C7CC039818619E4859');
INSERT INTO FW_SRT VALUES ('SDB','Aria_CBC_PKCS7','B426E1A441F6DBFC2B2D2412D0066D20','52A9A4CC4FB1EF00A72FF87583D44E5C');

INSERT INTO FW_SQL VALUES ('DATACRYPT_01','SELECT * FROM FW_SRT WHERE OPT = [OPT]');