-- abc123 회원의 누적 구매액을 조회
select bu_us_id, sum(pr_price) as 누적금액 from buy 
	join `option` on op_num = bu_op_num
    join product on pr_code = op_pr_code
    where bu_us_id = 'abc123';
-- 데이터가 많은 경우에는 아래 코드가 훨씬 효율적이다. -- as가 꼭 있어야해서 tmp라고 이름을 붙여줌.
select bu_us_id, sum(pr_price) as 누적금액 
	from (select * from buy where bu_us_id = 'abc123') as tmp
	join `option` on op_num = bu_op_num
    join product on pr_code = op_pr_code;
    
-- 모든 제품에 대해 각 제품별 구매 횟수를 조회(동일 회원 구매도 포함)
select op_pr_code as 제품, count(bu_num) as 구매횟수 from buy
	right join `option` on bu_op_num = op_num
    group by op_pr_code;
    
-- 모든 제품에 대해 각 제품별, 옵션별 구매 횟수를 조회(동일 회원 구매도 포함)
select  op_pr_code as 제품코드, op_size as 옵션, count(bu_num) as 구매횟수 from `option`
	left join buy on op_num = bu_op_num
    group by op_num;
 
 -- 제품코드가 ABC001인 제품 정보를 조회(제품코드, 제품명, 제품상세, 제품분류, 가격, 구매 가능한 사이즈) 구매 가능한 사이즈 => and op_amount > 0;
 select * from product
	join `option` on op_pr_code = pr_code
    where pr_code = 'ABC001' and op_amount > 0;

-- abc123 회원이 구매한 제품 목록(제품명)을 조회(중복x)
select pr_title as 제품명 from buy
	join `option` on op_num = bu_op_num
	join product on pr_code = op_pr_code
    where bu_us_id = 'abc123'
    group by pr_code; -- group by로 중복제거

-- 2000년생 회원들의 구매 제품 목록을 조회(제품코드)
select op_pr_code from buy
	join `option` on bu_op_num = op_num
	join user on bu_us_id = us_id
    where us_birth like '2000%'
	group by op_pr_code;
-- distinct로도 가능함. 
select distinct op_pr_cod from buy
	join `option` on bu_op_num = op_num
	join user on bu_us_id = us_id
    where us_birth between '2000-01-01' and '2000-12-31';
    