-- 메뉴 목록
CREATE TABLE MENUS (
   MENU_ID     VARCHAR2(6)  PRIMARY KEY
   ,MENU_NAME  VARCHAR2(100)
   ,MENU_SEQ   NUMBER(5))
   ;
   
   INSERT INTO MENUS VALUES ('MENU01', 'JAVA', 1);
   
   COMMIT;

--회원정보
CREATE TABLE TUSER (
   USERID      VARCHAR(12)  PRIMARY KEY
 , PASSWD      VARCHAR(12)  NOT NULL
 , USERNAME    VARCHAR(30)  NOT NULL 
 , EMAIL       VARCHAR(320)  
 , UPOINT      NUMBER(10)   DEFAULT 0
 , INDATE      DATE         DEFAULT SYSDATE
 );