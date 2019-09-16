USE motivationporn;

# CREATE USER `dbAdmin`@`localhost` IDENTIFIED BY '123456';
#
# GRANT Alter, Alter Routine, Create, Create Routine, Create Temporary Tables, Create View, Delete, Drop, Event, Execute, Grant Option, Index, Insert, Lock Tables, References, Select, Show View, Trigger, Update ON `motivationporn`.* TO `dbAdmin`@`localhost`;

DROP TABLE IF EXISTS `motivation_porn`;

CREATE TABLE `motivationporn`.`motivation_porn`
(
    `id`          int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键，自增长',
    `title`       varchar(30)     NULL COMMENT '标题，不超过30个字符',
    `content`     varchar(255)    NULL COMMENT '内容，不超过255个字符',
    `create_time` timestamp(0)    NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建的时间',
    `user_id`     int(0)          NULL COMMENT '用户Id',
    `user_name`         varchar(10)     NULL COMMENT '用户名',
    `status`      TINYINT         NOT NULL DEFAULT 1 COMMENT '状态值，1表示正常',
    PRIMARY KEY (`id`)
);

ALTER TABLE `motivationporn`.`motivation_porn` ADD INDEX user_index1 ( `user_id`, `content`, `status`, `user_name`);

INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '熟练的用运“关我屁事”“关你屁事”，可以节省80%的时间。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '别人骂你你要听，别人夸你你别信。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '千万不要自己感动自己。大部分人看似的努力，不过是愚蠢导致的。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '不要把别人想的太坏，也不要把别人想的太好，都是凡人。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '漂亮的女人像是放在展柜里的工艺品，欣赏的人很多，但买下的人只能一个人。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '童话里的灰姑娘虽然穷，但都很漂亮，你漂亮吗？');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '不爱你的人，比你想象中的还不爱你。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '失败是成功之母，可惜成功六亲不认。');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '丑小鸭能变成白天鹅，不是因为它有多努力，而是它的父母都是白天鹅！');
INSERT INTO `motivation_porn`(user_id, user_name, content) VALUES (1, 'xiaobaili', '你全心全意的付出，还不如别人的随便搞搞！');

DROP TABLE IF EXISTS `motivation_user`;

CREATE TABLE `motivationporn`.`motivation_user`
(
    `user_id`           int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
    `user_name`         varchar(10)     NULL COMMENT '用户名',
    `password`          varchar(30)     NULL COMMENT '密码',
    `avatar_url`        VARCHAR(300)    NULl COMMENT '头像的URL',
    `email`             varchar(30)     NULL COMMENT '邮箱',
    `status`            tinyint(255) DEFAULT 1 COMMENT '状态，1表示正常',
    `priority`          tinyint(255) DEFAULT 1 COMMENT '权限，1表示最低',
    `create_time`       timestamp(0) DEFAULT CURRENT_TIMESTAMP(0),
    `last_visited_time` timestamp(0) DEFAULT CURRENT_TIMESTAMP(0),
    `update_time`       timestamp(0) DEFAULT CURRENT_TIMESTAMP(0),
    PRIMARY KEY (`user_id`)
);

ALTER TABLE `motivationporn`.`motivation_user` ADD INDEX user_index1 ( `user_name`, `password`, `avatar_url`, `email` );

INSERT INTO `motivation_user` VALUES (1, 'xiaobaili', 'xiaobaili', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1270903507,3056052260&fm=26&gp=0.jpg', NULL, 1, 1, '2019-09-16 17:30:43', '2019-09-16 17:30:43', '2019-09-16 17:30:43');
INSERT INTO `motivation_user` VALUES (2, 'huaxiaomei', 'huaxiamei', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4172362726,3703199410&fm=26&gp=0.jpg', NULL, 1, 2, '2019-09-16 17:32:08', '2019-09-16 17:32:08', '2019-09-16 17:32:08');