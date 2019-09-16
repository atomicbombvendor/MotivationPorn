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
    `create_time` timestamp(0)    NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建的时间',
    `user_id`     int(0)          NULL COMMENT '用户Id',
    `status`      TINYINT         NOT NULL DEFAULT 1 COMMENT '状态值，1表示正常',
    PRIMARY KEY (`id`)
);

ALTER TABLE `motivationporn`.`motivation_porn` ADD INDEX user_index1 ( `user_id`, `content`, `status`);

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