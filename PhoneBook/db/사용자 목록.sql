-- phone_book 테이블 생성 - 21.05.31 by.준형
CREATE TABLE phone_book(
    id NUMBER(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    hp VARCHAR2(20) NOT NULL,
    tel VARCHAR2(20) NOT NULL);

-- 기본키 id 컬럼에 시퀀스 부여 - 21.05.31 by.준형
CREATE SEQUENCE seq_phone_book_pk START WITH 1
                                INCREMENT BY 1
                                MINVALUE 1
                                MAXVALUE 1000000
                                NOCACHE;

-- 시퀀스를 이용한  PK 부여 및 사용자 목록 삽입 - 21.05.31 by.준형
INSERT INTO phone_book(id, name, hp, tel) VALUES (seq_phone_book_pk.NEXTVAL, '고길동', '010-10**-23**', '02-43**-90**');
INSERT INTO phone_book(id, name, hp, tel) VALUES (seq_phone_book_pk.NEXTVAL, '도우너', '010-55**-55**', '02-43**-90**');
INSERT INTO phone_book(id, name, hp, tel) VALUES (seq_phone_book_pk.NEXTVAL, '마이콜', '010-99**-77**', '02-43**-90**');
INSERT INTO phone_book(id, name, hp, tel) VALUES (seq_phone_book_pk.NEXTVAL, '또치', '010-88**-90**', '02-43**-90**');

COMMIT;

