
/**
 * 创建系统用户表
 */

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id`        varchar(64) NOT NULL,
  `user_name` varchar(64)   NOT NULL,
  `user_pwd`  varchar(64)   NOT NULL,
  `email`     varchar(64)   NOT NULL,
  `phone`     varchar(15)   NOT NULL,
  `state`     INT           NOT NULL DEFAULT 1,
  `version`   varchar(64) 	NOT NULL ,
  `gmtCreate` datetime 			NOT NULL,
  `gmtModified` datetime 		DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_user_name` (`user_name`),
  UNIQUE KEY `UK_user_email` (`email`),
  UNIQUE KEY `UK_user_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;