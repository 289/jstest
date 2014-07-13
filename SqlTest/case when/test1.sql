DROP TABLE IF EXISTS `test_tab`;
CREATE TABLE `test_tab` (
  `t_date` varchar(16) DEFAULT NULL,
  `t_result` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_tab
-- ----------------------------
INSERT INTO `test_tab` VALUES ('2013-05-09', '负');
INSERT INTO `test_tab` VALUES ('2013-05-09', '负');
INSERT INTO `test_tab` VALUES ('2013-05-09', '胜');
INSERT INTO `test_tab` VALUES ('2013-05-09', '胜');
INSERT INTO `test_tab` VALUES ('2013-05-10', '胜');
INSERT INTO `test_tab` VALUES ('2013-05-10', '负');
INSERT INTO `test_tab` VALUES ('2013-05-10', '负');


select t_date as '日期',
sum(case when t_result='胜' then 1 else 0 end) as '胜',
sum(case when t_result='负' then 1 else 0 end) as '负'
from test_tab group by t_date
