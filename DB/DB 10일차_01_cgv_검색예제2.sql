-- 6/14일 CGV청주성안길에서 11:30에 상영하는 영화 브로커에 예매 가능한 좌석을 조회(예매된 좌석도 조회)
-- 두 가지 방법이 있음.
select mo_title as 제목, ci_th_name as 영화관, ci_name as 상영관, sc_start_time as 상영시간, 
	se_name as 좌석명, count(bd_bo_num) as 예약수 from screen
	join movie on sc_mo_num = mo_num
    join cinema on sc_ci_num = ci_num
    join seat on se_ci_num = ci_num
    left join book on sc_num = bo_sc_num 
    left join bookdetail on bo_num = bd_bo_num and bd_se_num = se_num 
    where mo_title = '브로커' 
		and ci_th_name = 'CGV청주성안길'
		and sc_start_time like '2022-06-14 11:30:00'
	group by 좌석명 
    having count(bd_bo_num) >= 0;
-- 이 쿼리가 더 효율적인 방법!!
select se_name, count(bd_se_num) from seat
	join (select * from cinema where ci_th_name = 'CGV청주성안길') as ci
		on se_ci_num = ci_num
    join (select * from screen where sc_start_time = '2022-06-14 11:30:00') as sc
		on sc_ci_num = ci_num
    join (select * from movie where mo_title = '브로커') as mo
		on sc_mo_num = mo_num
	left join book on bo_sc_num = sc_num 
    left join bookdetail on bo_num = bd_bo_num and bd_se_num = se_num
    where se_use = 'Y'
    group by se_num; -- 좌석번호로 그룹을 만듦.

-- 개봉일 기준으로 최신영화 10개를 조회
select * from movie order by mo_open_date desc limit 10;

-- 현재 상영중인(개봉이 된) 영화 중 개봉일을 기준으로 최신영화 10개를 조회
select mo_title from movie
	join screen on sc_mo_num = mo_num
    where sc_start_time >= now() and mo_open_date <= now()
    group by mo_num
    order by mo_open_date desc
    limit 10;
    
-- 서울에 있는 모든 영화관 정보를 조회
select * from theater where th_region = '서울';

-- 예매가 높은 순으로 영화 10개를 조회
-- 내가 짠 쿼리.. ㅠ
select bo_amount, mo_title from book
	join screen on bo_sc_num = sc_num
    join movie on sc_mo_num = mo_num
    join bookdetail on bo_num = bd_bo_num 
	group by mo_title
    order by bo_amount asc
    limit 10;
-- 강사님 쿼리    
select mo_title as 영화제목, sum(bo_amount) as 예매수 from movie
	join (select * from screen where sc_start_time > now()) as sc 
		on sc_mo_num = mo_num
    join book on bo_sc_num = sc_num
    where bo_state = 'Y'
    group by mo_num
    order by 예매수 desc
    limit 10;

-- CGV에서 영화를 관람한 영화별 관람객 수를 조회
-- 내가 짠 쿼리
select distinct mo_title as 영화, sum(bo_amount) as 관람객수 from book
	join screen on bo_sc_num = sc_num
    join movie on sc_mo_num = mo_num
    where sc_start_time <= now()
    group by 영화;
-- 강사님 쿼리
select mo_title as 영화, sum(bo_amount) as 관람객수 from movie
	join (select * from screen where sc_start_time <= now()) as sc 
		on sc_mo_num = mo_num
    join (select * from book where bo_state = 'Y') as bo 
		on bo_sc_num = sc_num
	group by mo_num
	order by 관람객수 desc; -- 그룹은 기본키로 묶는게 좋음.