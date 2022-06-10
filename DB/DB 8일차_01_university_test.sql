drop database if exists university;
create database if not exists university;

use university;

create table if not exists professor(
	pr_num varchar(10),
    pr_name char(10) NOT NULL,
    primary key(pr_num)
);

create table if not exists subject(
	su_code varchar(6),
    su_name char(15) NOT NULL,
    su_pr_num varchar(10) NOT NULL,
    primary key(su_code),
    foreign key(su_pr_num) references professor(pr_num)
);

create table if not exists student(
	st_num varchar(10),
    st_name char(10) NOT NULL,
    st_pr_num varchar(10) NOT NULL,
    primary key(st_num),
    foreign key(st_pr_num) references professor(pr_num)
);

create table if not exists course(
	co_num varchar(10),
    co_st_num varchar(10) NOT NULL,
    co_su_code varchar(6) NOT NULL,
    co_mid int NOT NULL default 0,
	co_final int NOT NULL default 0,
	co_homework int NOT NULL default 0,
	co_attendance int NOT NULL default 0,
	co_total int NOT NULL default 0,
    primary key(co_num),
    foreign key(co_st_num) references student(st_num),
    foreign key(co_su_code) references subject(su_code)
);