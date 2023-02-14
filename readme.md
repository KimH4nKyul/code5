2023-02-13

1. MYSQL DBMS 지원, 사용가능한 MYSQL DBMS 를 이용 코드를 실행할 수 있습니다.
2. 테입블 컬럼명에 KEY 불가능 해서 FW_KEY 로 변경
3. MYSQL SQL 호환 가능하도록 변경
3. 메타데이터 조회시 metaData.getColumnName() 에서 metaData.getColumnLabel() 로 변경 

2022-05-22

1. code5 프레임웍크의 저작권은 MIT 라이센스를 따릅니다.

2022-04-15

1. 타임리프(thymeleaf) 기능 추가


2021-08-18

1. 백엔드 프레임워크 만들기 개정판 완성

2021-07-25

1. 섹션4, 섹션5 심화 ppt 작성
2. 접근제어 기능 확장 - checkMethod
3. InitCode5DBByDev.java 신규 SQL 추가를 쉽도록 개선
4. 배포 편의성 개선

2021-06-21

1. AOP 메소드 이름 변경
2. 섹션2, 섹션3 심화 ppt 작성
3. version 1 강의 자료 복구

2021-06-09

1. SQL PREFIX, SUFFIX 규칙 지원
2. 배치프로그램 개발환경 지원
3. 섹션1 심화과정 ppt 작성


2021-06-01

1. 레퍼지토리 이름 code5 변경
2. 이클립스/인텔리제이 환경에서 프로젝트 또는 모듈이 알아서 구성되도록 자원 정리
3. 게시판 만들기 프로젝트 최종 완료
4. 섹션0, 섹션1 자원 확정



2021-05-54 

1. UTF-8 파일 변환 : 바이너리제외 프로젝트 모든 파일은 UTF-8 인코딩으로 저장합니다.
2. 임베디드 톰캣 적용 : 별도의 WAS 설정이 필요 없습니다. 인텔리제이 커뮤니티 버전에서도 수행할 수 있습니다.
3. YAML 확장 : SQL 또는 properties 를 DB 에서 YAML 파일에서 사용할 수 있도록 변경
4. 어노테이션 기능 추가 : 서비스키, 뷰키 메타정보를 DB 에서 어노테이션에서 가져올 수 있도록 변경
5. lib 디렉토리 추가 : 백엔드프레임워크 실행에 필요한 파일을 쉽게 추가할 수 있도록 git 추가
6. code5.db 자동 완성 : doc 디렉토리에 sqlite data 파일을 둬 별도의 DB 작업이 필요 없도록 개선
