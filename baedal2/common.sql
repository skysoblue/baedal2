SHUTDOWN;
------------------------------------------
---------HSQL 스키마 생성 및 권한---------------
------------------------------------------
--------- 멤버 테이블
SELECT TABLE_NAME, COLUMN_NAME, TYPE_NAME, COLUMN_SIZE, DECIMAL_DIGITS, IS_NULLABLE FROM INFORMATION_SCHEMA.SYSTEM_COLUMNS WHERE TABLE_NAME NOT LIKE 'SYSTEM_%'
SELECT PASSWORD FROM MEMBER WHERE USERID = 'hong' AND QUESTION = '첫강아지' AND ANSWER = '멍멍'
DROP SEQUENCE SEQ;
DROP TABLE MEMBER;
DROP TABLE CATEGORY;
DROP TABLE STORE CASCADE;
DROP TABLE MENU;

SELECT * FROM MEMBER;
SELECT * FROM CATEGORY;
SELECT * FROM STORE;
SELECT * FROM MENU;
SELECT * FROM ORDERS;
SELECT * FROM STORE WHERE CAT_ID = 'hansik';
CREATE SEQUENCE SEQ START WITH 1000;
CREATE TABLE MEMBER(
	USERID VARCHAR(30),-- 아이디
	PASSWORD VARCHAR(30),-- 비번
	NAME VARCHAR(30), -- 이름
	PHONE VARCHAR(30), -- 전화번호
	ADDR VARCHAR(30), -- 주소
	BIRTH VARCHAR(30), -- 생년
	QUESTION VARCHAR(30), -- 비번찾기 질문
	ANSWER VARCHAR(30), -- 비번찾기 대답
	CONSTRAINT MEMBER_PK PRIMARY KEY(USERID)
);
INSERT INTO MEMBER VALUES('hong','1','홍길동','01022223333','서울','20000101','첫강아지','멍멍');
INSERT INTO MEMBER VALUES('kim','1','김유신','01044445555','강원','20000101','첫강아지','멍멍');
INSERT INTO MEMBER VALUES('lee','1','이순신','01066667777','충남','20000101','첫강아지','멍멍');
UPDATE MEMBER SET ANSWER = '멍멍';
-------- 푸드 카테고리 테이블
CREATE TABLE CATEGORY(
	CAT_ID VARCHAR(30),
	CAT_NAME VARCHAR(30),
	CONSTRAINT CATEGORY_PK PRIMARY KEY(CAT_ID)
);
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('bossam', '보쌈'); 
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('joongsik', '중식'); 
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('ilsik', '일식'); 
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('chicken', '치킨'); 
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('hansik', '한식'); 
INSERT INTO CATEGORY(CAT_ID, CAT_NAME) VALUES('pizza', '피자'); 
-------- 식당 테이블
CREATE TABLE STORE(
	STORE_ID VARCHAR(30),
	STORE_NAME VARCHAR(30),
	CAT_ID VARCHAR(30),
	CONSTRAINT STORE_PK PRIMARY KEY(STORE_ID),
	CONSTRAINT STORE_FK_CATEGORY
	FOREIGN KEY(CAT_ID) REFERENCES CATEGORY(CAT_ID)
);
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_boodae','강남 부대찌개','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_cold_remen','육쌈냉면','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_gimbab','고봉민김밥인','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_jayun','재윤한식당','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_jook','죽이야기','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_park','박가부대찌개','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_rice','고고라이스','hansik')
INSERT INTO STORE(STORE_ID,STORE_NAME,CAT_ID)VALUES('store_ukgaejang','맛있는육개장','hansik')

-- 메뉴 테이블 
CREATE TABLE MENU(
	MENU_ID VARCHAR(30),
	MENU_NAME VARCHAR(30), -- 메뉴 이름
	PRICE INT, -- 가격
	MENU_IMG VARCHAR(30),  -- 메뉴 이미지
	CONSTRAINT MENU_PK PRIMARY KEY(MENU_ID)
);
INSERT INTO MENU VALUES('ddokbokki', '떡볶이',3000, 'menu_ddokbokki.png'); 
INSERT INTO MENU VALUES('karbonara', '카르보나',7000, 'menu_karbonara.png'); 
INSERT INTO MENU VALUES('soondae', '순대',4000, 'menu_soondae.png'); 
INSERT INTO MENU VALUES('dongas', '돈까스',6000, 'menu_dongas.png'); 
INSERT INTO MENU VALUES('kimchibok', '김치볶음밥',7000, 'menu_kimchibok.png'); 
INSERT INTO MENU VALUES('dakbal', '닭발',12000, 'menu_dakbal.png'); 
INSERT INTO MENU VALUES('kimbab', '김밥',3000, 'menu_kimbab.png'); 
INSERT INTO MENU VALUES('ramen', '라면',3500, 'menu_ramen.png'); 
-----------------------------------------
CREATE TABLE ORDERS(
	SEQ INT GENERATED BY DEFAULT AS SEQUENCE SEQ,
	USERID VARCHAR(30),
	CAT_ID VARCHAR(30),
	STORE_ID VARCHAR(30),
	MENU_ID VARCHAR(30),
	CONSTRAINT ORDERS_PK PRIMARY KEY(SEQ)
);
INSERT INTO ORDERS(SEQ,USERID)VALUES( NEXT VALUE FOR SEQ, 'hong');
DROP TABLE TEST_Z1;
COMMIT;
SHUTDOWN;


