-- 1. 학생 정보 추가
insert into student(st_num, st_name, st_pr_num) 
	values('2022160001', '고길동', null), ('2022160002', '홍길동', null),
    ('2022135001', '유관순', null), ('2022135002', '이순신', null),
    ('2022123001', '논개', null), ('2022123002', '세종대왕', null);

-- 2. 교수 정보 추가
insert into professor(pr_num, pr_name)
	values('2022160001', '유재석'), ('2022135001', '강호동'), ('2022123001', '나영석');
    
-- 3. 학생들은 학과 교수님들에게 지도를 받음
update student set st_pr_num = '2022160001' where st_num like  '____160___';
update student set st_pr_num = '2022135001' where st_num like  '____135___';
update student set st_pr_num = '2022123001' where st_num like  '____123___';

-- 4. 강좌 정보 추가
insert into subject(su_code, su_name, su_pr_num) 
	select 'MSC001', '대학수학기초', pr_num from professor where pr_name = '유재석';
insert into subject(su_code, su_name, su_pr_num) 
	select 'MSC002', '대학영어', pr_num from professor where pr_name = '나영석';
insert into subject(su_code, su_name, su_pr_num) 
	select 'ITC001', '컴퓨터개론', pr_num from professor where pr_name = '유재석';
insert into subject(su_code, su_name, su_pr_num) 
	select 'ITE001', '기초전기', pr_num from professor where pr_name = '강호동';
insert into subject(su_code, su_name, su_pr_num) 
	select 'ITT001', '기초기계', pr_num from professor where pr_name = '나영석';
    
-- 5. 수강 정보 추가
insert into course(co_num, co_st_num, co_su_code) select '1', '2022160001', su_code from subject where su_name = '대학수학기초';
insert into course(co_num, co_st_num, co_su_code) select '2', '2022160001', su_code from subject where su_name = '대학영어';
insert into course(co_num, co_st_num, co_su_code) select '3', '2022160001', su_code from subject where su_name = '컴퓨터개론';
insert into course(co_num, co_st_num, co_su_code) select '4', '2022160002', su_code from subject where su_name = '대학수학기초';
insert into course(co_num, co_st_num, co_su_code) select '5', '2022160002', su_code from subject where su_name = '컴퓨터개론';
insert into course(co_num, co_st_num, co_su_code) select '6', '2022135001', su_code from subject where su_name = '대학영어';
insert into course(co_num, co_st_num, co_su_code) select '7', '2022135001', su_code from subject where su_name = '기초전기';
insert into course(co_num, co_st_num, co_su_code) select '8', '2022135002', su_code from subject where su_name = '대학수학기초';
insert into course(co_num, co_st_num, co_su_code) select '9', '2022135002', su_code from subject where su_name = '대학영어';
insert into course(co_num, co_st_num, co_su_code) select '10', '2022123001', su_code from subject where su_name = '기초기계';
insert into course(co_num, co_st_num, co_su_code) select '11', '2022123002', su_code from subject where su_name = '대학수학기초';
insert into course(co_num, co_st_num, co_su_code) select '12', '2022123002', su_code from subject where su_name = '대학영어';
insert into course(co_num, co_st_num, co_su_code) select '13', '2022123002', su_code from subject where su_name = '기초기계';

-- 6. 정보 검색
-- 나영석 교수가 강의하는 강좌명을 조회
select pr_name, su_name from professor
	join subject on su_pr_num = pr_num
    where pr_name = '나영석';
    
-- 컴퓨터개론을 수강하는 학생들 이름을 조회 
select su_name, st_name from student
	join course on co_st_num = st_num
	join subject on su_code = co_su_code
    where su_name = '컴퓨터개론';

-- 나영석 교수의 지도 학생 이름을 조회
select pr_name, st_name from professor
	join student on st_pr_num = pr_num
    where pr_name = '나영석';
