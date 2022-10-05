DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`pr_code`	char(6)	NOT NULL,
	`pr_thumb`	varchar(255)	NULL,
	`pr_title`	varchar(255)	NULL,
	`pr_content`	longtext	NULL,
	`pr_spec`	longtext	NULL,
	`pr_price`	int	NULL,
	`pr_ca_name`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
	`ca_name`	varchar(10)	NOT NULL,
	`ca_code`	char(3)	NULL,
	`ca_count`	int	NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_email`	varchar(30)	NOT NULL,
	`me_pw`	varchar(225)	NULL,
	`me_birth`	date	NULL,
	`me_post_code`	varchar(10)	NULL,
	`me_addr`	varchar(50)	NULL,
	`me_addr_detail`	varchar(50)	NULL,
	`me_s_id`	varchar(50)	NULL,
	`me_s_limit`	datetime	NULL,
	`me_code`	char(6)	NULL,
	`me_pos`	enum('0','1')	NULL,
	`me_pos_count`	int	NULL,
	`me_authority`	int	NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bd_num`	int	NOT NULL,
	`bd_type`	varchar(10)	NULL,
	`bd_title`	varchar(255)	NULL,
	`bd_content`	longtext	NULL,
	`bd_secret`	enum('0','1')	NULL,
	`bd_reg_date`	datetime	NULL,
	`bd_pr_code`	char(6)	NOT NULL,
	`bd_me_email`	varchar(30)	NOT NULL,
	`bd_ori_num`	int	NULL
);

DROP TABLE IF EXISTS `likes`;

CREATE TABLE `likes` (
	`li_num`	int	NOT NULL,
	`li_pr_code`	char(6)	NOT NULL,
	`li_me_email`	varchar(30)	NOT NULL
);

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
	`pr_code`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`ca_name`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_email`
);

ALTER TABLE `board` ADD CONSTRAINT `PK_BOARD` PRIMARY KEY (
	`bd_num`
);

ALTER TABLE `likes` ADD CONSTRAINT `PK_LIKES` PRIMARY KEY (
	`li_num`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_category_TO_product_1` FOREIGN KEY (
	`pr_ca_name`
)
REFERENCES `category` (
	`ca_name`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_product_TO_board_1` FOREIGN KEY (
	`bd_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bd_me_email`
)
REFERENCES `member` (
	`me_email`
);

ALTER TABLE `likes` ADD CONSTRAINT `FK_product_TO_likes_1` FOREIGN KEY (
	`li_pr_code`
)
REFERENCES `product` (
	`pr_code`
);

ALTER TABLE `likes` ADD CONSTRAINT `FK_member_TO_likes_1` FOREIGN KEY (
	`li_me_email`
)
REFERENCES `member` (
	`me_email`
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num`	int	NOT NULL,
	`fi_ori_name`	varchar(255)	NULL,
	`fi_name`	varchar(255)	NULL,
	`fi_bd_num`	int	NOT NULL
);

ALTER TABLE `file` ADD CONSTRAINT `PK_FILE` PRIMARY KEY (
	`fi_num`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bd_num`
)
REFERENCES `board` (
	`bd_num`
);
