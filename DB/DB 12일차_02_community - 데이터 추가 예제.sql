-- 일반 게시글을 조회하는데, 게시글번호, 게시글제목, 댓글 수가 조회
select bd_num, bd_title, count(co_bd_num) as `댓글 수` from board
	left join comment on co_bd_num = bd_num
    where bd_ca_name = '일반'
    group by bd_num;

-- 각 카테고리별 게시글 수를 조회
select ca_name, count(bd_ca_name) from category
	 left join board on ca_name = bd_ca_name
     group by ca_name;

-- case를 이용한 추천, 비추천, 미추천 표시 
select likes.*,
	case 
		when li_state = 1 then '추천'
		when li_state = -1 then '비추'
		when li_state = 0 then '미추천' 
	end as 추천여부
from likes;

-- 일반 게시글에 대해 게시글번호, 게시글 제목과 추천수와 비추천수를 조회
-- li_state가 1일때 개수를 세는 방법
-- 개수를 세는데 li_state가 1일때 세는 방법
select bd_num as 번호, bd_title as 제목, 
	count(case when li_state = 1 then li_state end) as 추천, 
    count(case when li_state = -1 then li_state end) as 비추천
    from board 
     left join (select * from likes where li_target = 'board') as li
		on li_target_num = bd_num
     where bd_ca_name = '일반'
     group by bd_num;
-- sum을 활용한 방법 (이 쿼리에서 sum이 count처럼 작동된다.)     
select bd_num as 번호, bd_title as 제목, 
	ifnull(sum(li_state = 1),0) as 추천,
    ifnull(sum(li_state = -1),0) as 비추천
    from board 
     left join (select * from likes where li_target = 'board') as li
		on li_target_num = bd_num
     where bd_ca_name = '일반'