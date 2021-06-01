-- id : c##bituser / pw : bituser 계정 생성 - 21.05.31 by.준형
CREATE USER C##bituser IDENTIFIED BY bituser;

-- c##bituser 사용자에게 로그인 권한 부여 - 21.05.31 by.준형
GRANT create session TO C##bituser;

-- c##bituser 사용자에게 테이블을 만들고 사용할 수 있는 권한 부여 - 21.05.31 by.준형
GRANT connect, resource TO C##bituser;

-- 사용자 테이블 스페이스에 공간 부여하여 사용할 수 있도록 설정 - 21.05.31 by.준형
ALTER USER C##bituser DEFAULT TABLESPACE USERS QUOTA unlimited ON USERS;

-- 조회, 수정, 삽입, 삭제 권한 부여 - 21.05.31 by.준형 
-- GRANT select, update, insert, delete ON PhoneBook.phone_book TO C##bituser;