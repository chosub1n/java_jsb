-- 1번 게시글에 qwer1234 회원이 만나서 반가워요. 라고 댓글을 달았다.
-- 새로운 댓글을 추가 => insert문 => 댓글 => comment테이블
insert into comment(co_contents, co_us_id, co_bd_num, co_secret, co_ori_num, co_depth) 
	select '만나서 반가워요.', 'qwer1234', 1, 0, ifnull(max(co_num),0)+1, 1 from comment;
    
-- 1번 댓글의 댓글로 admin123 관리자가 잘 부탁합니다. 라고 댓글을 달았다.
insert into comment(co_contents, co_us_id, co_bd_num, co_secret, co_ori_num, co_depth)
	select '잘 부탁합니다.', 'admin123', co_bd_num, 0, 1, co_depth + 1 from comment 
    where co_num = 1;

-- 1번 게시글의 제목을 가입인사입니다. 라고 수정
update board set bd_title = '가입인사합니다.', bd_up_date = now() where bd_num = 1;

-- 카테코리 게시글 종류에 스터디 추가
insert category(ca_name) values('스터디');

-- 샘플 추천/비추천 추가
INSERT INTO `community`.`likes` (`li_us_id`, `li_state`, `li_target`, `li_target_num`) VALUES ('admin123', '1', 'board', '1');
INSERT INTO `community`.`likes` (`li_us_id`, `li_state`, `li_target`, `li_target_num`) VALUES ('abcd1234', '-1', 'board', '1');
INSERT INTO `community`.`likes` (`li_us_id`, `li_state`, `li_target`, `li_target_num`) VALUES ('qwer1234', '-1', 'board', '4');
UPDATE `community`.`likes` SET `li_state` = '1' WHERE (`li_num` = '1');