/*
Navicat MySQL Data Transfer

Source Server         : hello
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : weijidb3

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2016-11-07 00:28:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `chat`
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `chat_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `chat_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `chat_detail` varchar(100) default NULL,
  `competition_id` int(11) default NULL,
  PRIMARY KEY  (`chat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('1', '1', '2016-10-31 09:57:23', '好好学习', '1');
INSERT INTO `chat` VALUES ('2', '2', '2016-10-31 09:57:34', '天天向上', '1');
INSERT INTO `chat` VALUES ('3', '1', '2016-10-31 14:19:13', '运动快乐', '1');
INSERT INTO `chat` VALUES ('20', '1', '2016-11-01 22:12:49', 'TATæä»¬', '1');
INSERT INTO `chat` VALUES ('21', '1', '2016-11-01 22:16:16', '看扣扣', '1');
INSERT INTO `chat` VALUES ('22', '1', '2016-11-02 09:45:46', '统计', '11');
INSERT INTO `chat` VALUES ('23', '1', '2016-11-02 10:06:23', '通知下看看', '28');
INSERT INTO `chat` VALUES ('24', '1', '2016-11-02 06:03:30', 'xuexi hurt', '11');
INSERT INTO `chat` VALUES ('25', '1', '2016-11-02 14:28:21', '好好学习', '12');
INSERT INTO `chat` VALUES ('26', '1', '2016-11-04 13:50:15', 'djjjh', '10');
INSERT INTO `chat` VALUES ('27', '1', '2016-11-06 13:11:01', '????????', '3');
INSERT INTO `chat` VALUES ('28', '1', '2016-11-06 13:30:10', '??', '3');

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collection_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `dynamic_id` int(11) default NULL,
  `collection_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `collention_state` int(11) default NULL,
  PRIMARY KEY  (`collection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('2', '2', '1', '2016-10-29 11:36:27', '1');
INSERT INTO `collection` VALUES ('3', '1', '2', '2016-10-31 15:48:31', '1');
INSERT INTO `collection` VALUES ('4', '2', '3', '2016-10-29 11:36:49', '0');
INSERT INTO `collection` VALUES ('5', '1', '4', null, '1');
INSERT INTO `collection` VALUES ('6', '3', '2', '2016-10-29 14:34:36', '1');
INSERT INTO `collection` VALUES ('7', '1', '13', '2016-10-29 16:44:36', '1');
INSERT INTO `collection` VALUES ('8', '1', '2', '2016-10-31 15:48:31', '1');
INSERT INTO `collection` VALUES ('9', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('10', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('11', '1', '9', '2016-10-31 18:31:00', '0');
INSERT INTO `collection` VALUES ('12', '1', '9', '2016-10-31 18:31:12', '1');
INSERT INTO `collection` VALUES ('13', '1', '9', '2016-10-31 18:31:28', '1');
INSERT INTO `collection` VALUES ('14', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('15', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('16', '1', '1', '2016-11-02 09:56:43', '1');
INSERT INTO `collection` VALUES ('17', '1', '3', '2016-11-05 11:06:39', '1');
INSERT INTO `collection` VALUES ('18', '1', '3', '2016-11-05 11:06:39', '1');
INSERT INTO `collection` VALUES ('19', '1', '3', '2016-11-05 11:06:39', '1');

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `comments_id` int(11) NOT NULL auto_increment,
  `dynamic_id` int(11) default NULL,
  `pater_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `comments_content` varchar(200) default NULL,
  `comments_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `comments_state` int(11) default NULL,
  PRIMARY KEY  (`comments_id`),
  KEY `dynamic_id` (`dynamic_id`),
  KEY `user_id` (`pater_id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', '1', null, '1', '飞流直下三千尺，疑是银河落九天', '2016-10-23 22:52:03', '1');
INSERT INTO `comments` VALUES ('2', '1', null, '4', '勿以往之不谏，知来者之可追', '2016-10-29 00:42:17', '0');
INSERT INTO `comments` VALUES ('3', '1', null, '2', '一上高城万里愁，蒹葭杨柳似汀州。溪云初起日沉阁，山雨欲来风满楼', '2016-10-29 00:29:42', '1');
INSERT INTO `comments` VALUES ('4', '1', null, '3', '此去经年，应是良辰美景虚设，便纵有千种风情，更与何人说？', '2016-10-29 00:54:34', '0');
INSERT INTO `comments` VALUES ('5', '1', null, '5', '来日大难，口燥舌干，今日相乐，皆当喜欢', '2016-10-23 22:52:09', '1');
INSERT INTO `comments` VALUES ('6', '2', null, '1', '小楼一夜听春雨，深巷明早卖杏花', '2016-10-29 00:29:44', '1');
INSERT INTO `comments` VALUES ('7', '2', null, '2', '何人知我忧，何人知我愁。何人知我思，何人我想留。何人伴一生，何人醒时有。何人独饮酒，和人牵我手。山外青山楼外楼，能否陪我到白头', '2016-10-23 22:52:13', '1');
INSERT INTO `comments` VALUES ('8', '2', null, '3', '无人与我立黄昏，无人问我粥可温', '2016-10-23 23:11:17', '1');
INSERT INTO `comments` VALUES ('93', '11', '0', '1', '再来一条', '2016-10-25 13:33:32', null);
INSERT INTO `comments` VALUES ('94', '11', '93', '1', '回复自己一条吧', '2016-10-25 13:33:47', null);
INSERT INTO `comments` VALUES ('95', '8', '0', '1', '无言独上西楼，月如钩，寂寞梧桐深院锁清秋', '2016-10-29 01:50:54', '1');
INSERT INTO `comments` VALUES ('96', '8', '0', '1', '无言独上西楼，月如钩，寂寞梧桐深院锁清秋', '2016-10-29 01:50:52', '1');
INSERT INTO `comments` VALUES ('97', '8', '0', '1', '无言独上西楼，月如钩，寂寞梧桐深院锁清秋', '2016-10-29 01:50:51', '1');
INSERT INTO `comments` VALUES ('116', '3', '0', '1', '啦咯啦咯啦咯啦', '2016-10-29 01:50:51', '1');
INSERT INTO `comments` VALUES ('117', '8', '97', '1', '啦啦啦', '2016-10-29 01:53:18', null);
INSERT INTO `comments` VALUES ('118', '8', '95', '1', '噢噢噢', '2016-10-29 01:53:23', null);
INSERT INTO `comments` VALUES ('124', '1', '0', '1', '啦啦啦', '2016-10-29 02:06:30', '1');
INSERT INTO `comments` VALUES ('125', '1', '0', '1', '', '2016-10-29 02:06:36', '1');
INSERT INTO `comments` VALUES ('126', '1', '3', '1', '啦啦啦', '2016-10-29 02:07:54', '1');
INSERT INTO `comments` VALUES ('127', '1', '3', '1', '继续', '2016-10-29 02:08:02', '1');
INSERT INTO `comments` VALUES ('128', '1', '0', '1', '擦。', '2016-10-29 02:08:22', '1');
INSERT INTO `comments` VALUES ('129', '1', '5', '1', '哭个毛', '2016-10-29 02:08:34', '1');
INSERT INTO `comments` VALUES ('130', '4', '0', '1', '彩礼', '2016-10-31 18:29:52', '1');
INSERT INTO `comments` VALUES ('131', '4', '0', '1', '出来吧', '2016-10-31 18:30:02', '1');
INSERT INTO `comments` VALUES ('132', '9', '0', '1', '好卡啊', '2016-10-31 18:30:32', '1');
INSERT INTO `comments` VALUES ('133', '9', '132', '1', '回复自己一个', '2016-10-31 18:30:45', '1');
INSERT INTO `comments` VALUES ('134', '1', '0', '1', '群', '2016-11-02 09:57:11', '1');
INSERT INTO `comments` VALUES ('135', '1', '0', '1', '继续', '2016-11-02 09:57:22', '1');
INSERT INTO `comments` VALUES ('136', '1', '0', '1', '来咯', '2016-11-02 09:57:35', '1');
INSERT INTO `comments` VALUES ('137', '1', '136', '1', '回来张鹏', '2016-11-02 09:57:52', '1');
INSERT INTO `comments` VALUES ('138', '5', '0', '1', '孔', '2016-11-02 09:59:39', '1');
INSERT INTO `comments` VALUES ('139', '3', '0', '1', '洪', '2016-11-02 10:08:15', '1');
INSERT INTO `comments` VALUES ('140', '2', '6', '1', '好咯', '2016-11-02 10:08:37', '1');
INSERT INTO `comments` VALUES ('141', '3', '0', '1', 'hhhh', '2016-11-05 15:50:37', '1');
INSERT INTO `comments` VALUES ('142', '3', '0', '1', 'hyg', '2016-11-05 15:50:41', '1');

-- ----------------------------
-- Table structure for `competition_detail_table`
-- ----------------------------
DROP TABLE IF EXISTS `competition_detail_table`;
CREATE TABLE `competition_detail_table` (
  `competition_detail_id` int(11) NOT NULL auto_increment,
  `competition_table_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `distance` float(15,0) default NULL,
  `state` int(2) default NULL,
  PRIMARY KEY  (`competition_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition_detail_table
-- ----------------------------
INSERT INTO `competition_detail_table` VALUES ('147', '1', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('148', '2', '2', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('149', '3', '3', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('150', '9', '4', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('151', '10', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('152', '11', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('153', '12', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('154', '3', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('155', '2', '1', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('156', '1', '2', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('157', '1', '3', '0', '2');
INSERT INTO `competition_detail_table` VALUES ('158', '13', '1', '0', '2');

-- ----------------------------
-- Table structure for `competition_table`
-- ----------------------------
DROP TABLE IF EXISTS `competition_table`;
CREATE TABLE `competition_table` (
  `competition_table_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `type` varchar(20) character set gbk default NULL COMMENT '竞赛类型',
  `create_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP COMMENT '竞赛创建时间',
  `begin_time` timestamp NULL default '0000-00-00 00:00:00' COMMENT '开始时间',
  `end_time` timestamp NULL default NULL COMMENT '结束时间',
  `score` int(11) default NULL COMMENT '积分',
  `detail` varchar(255) character set gbk default NULL COMMENT '详情',
  `title` varchar(20) character set gbk default NULL COMMENT '标题',
  `num` int(4) default NULL COMMENT '人数',
  `imageurl` varchar(50) character set gbk default NULL COMMENT '图片地址',
  PRIMARY KEY  (`competition_table_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition_table
-- ----------------------------
INSERT INTO `competition_table` VALUES ('1', '1', '跑步', '2016-11-05 14:39:58', '2016-11-30 00:00:00', '2016-10-31 16:20:30', '90', '我要减肥', '减肥', '1', null);
INSERT INTO `competition_table` VALUES ('2', '1', '跑步', '2016-11-05 14:40:00', '2016-11-26 15:26:46', '2016-10-31 16:20:34', '2', '跑步减肥', '减肥', '1', null);
INSERT INTO `competition_table` VALUES ('3', '1', '跑步', '2016-11-05 14:40:03', '2016-11-26 20:26:53', '2016-10-31 20:26:53', '2', '减肥快乐', '减肥', '1', null);
INSERT INTO `competition_table` VALUES ('9', '1', '跑步', '2016-11-05 14:37:21', '2016-11-27 00:00:00', '2016-10-31 00:00:00', '2', '跑跑跑', '健身', '6', null);
INSERT INTO `competition_table` VALUES ('10', '1', '跑步', '2016-11-05 14:37:33', '2016-11-19 15:24:49', '2016-10-31 15:24:49', '5', '跑跑跑', '健身', '6', '');
INSERT INTO `competition_table` VALUES ('11', '1', '跑步', '2016-11-05 14:37:37', '2016-11-27 00:00:00', '2016-10-31 00:00:00', '5', '跑跑跑', '健身', '6', null);
INSERT INTO `competition_table` VALUES ('12', '1', '跑步', '2016-11-05 14:37:56', '2016-11-24 04:09:00', '2016-10-31 16:19:00', '5', '跑跑跑', '健身', '5', null);
INSERT INTO `competition_table` VALUES ('13', '1', '??', '2016-11-06 13:31:00', '2016-11-06 13:31:00', '2016-02-06 13:31:00', null, '???????PK?', null, '2', null);

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `dynamic_id` int(11) NOT NULL auto_increment,
  `dynamic_title` varchar(40) character set gbk default NULL COMMENT '动态标题',
  `dynamic_content` varchar(200) character set gbk default NULL COMMENT '动态内容',
  `dynamic_address` varchar(50) character set gbk default NULL COMMENT '动态地址',
  `dynamic_thumbup` int(11) default NULL COMMENT '点赞',
  `dynamic_report` int(11) default NULL COMMENT '举报',
  `user_id` int(11) default NULL,
  `dynamic_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `dynamic_img` varchar(50) character set gbk default NULL COMMENT '图片地址',
  `dynamic_type` int(11) default NULL,
  PRIMARY KEY  (`dynamic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES ('2', '葫芦玩与蛇精的故事', '很久很久以前，有一个老头得到一颗神奇的种子，他种下去之后，日夜悉心照料，终于可以卖钱了', '马六甲', '333', '1', '1', '2016-11-06 14:21:39', 'images/jingxuan_1.png', '1');
INSERT INTO `dynamic` VALUES ('3', '黑暗中奔跑', '黑暗中舞者，奔跑中拥抱人生，用拼搏奏响生命的乐章', '加勒比', '122', '4', '1', '2016-11-06 14:21:44', 'images/jingxuan_2.png', '1');
INSERT INTO `dynamic` VALUES ('4', 'helloworld', '锄禾日当午，汗滴禾下土，谁知盘中餐粒粒皆辛苦', '唐朝', '432', '8', '3', '2016-10-25 14:20:51', 'images/movie1.png', '2');
INSERT INTO `dynamic` VALUES ('5', '嘿嘿嘿', '飞流直下三千尺，疑是银河落九天', '宋城', '7645', '2', '2', '2016-10-25 14:22:19', 'images/movie1.png', '2');
INSERT INTO `dynamic` VALUES ('6', '大话西游', '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊暗暗', '非洲', '3132', '2', '3', '2016-10-25 14:21:23', 'images/movie2.png', '2');
INSERT INTO `dynamic` VALUES ('7', '慢慢一书的唐人风情', '小时候看唐传奇，读的是《长恨歌转》，《莺莺传》《昆仑奴》', '天涯', '432', '1', '4', '2016-10-25 14:21:51', 'images/dynamic1.jpg', '2');
INSERT INTO `dynamic` VALUES ('9', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaaaa', '322', '1', '2', '2016-11-06 14:59:50', 'images/movie1.png', '2');
INSERT INTO `dynamic` VALUES ('10', 'bbbbbbbbbbbbb', 'bbbbbbbbb', 'bbbbbbb', '123', '2', '2', '2016-10-25 14:21:59', 'images/dynamic2.jpg', '2');
INSERT INTO `dynamic` VALUES ('11', 'cccccccccccc', 'cccccccccccccccccccccccccccccccccccc', 'cccccccccc', '756', '1', '3', '2016-10-25 14:22:11', 'images/dynamic1.jpg', '2');
INSERT INTO `dynamic` VALUES ('12', 'dddddddddd', 'dddddddddddddddddd', 'ddddddddd', '7777', '2', '4', '2016-10-25 14:20:59', 'images/movie2.png', '2');
INSERT INTO `dynamic` VALUES ('13', 'ffffff', 'ffffffffffffffffffffffffffffffff', 'fffffffff', '55555', '2', '2', '2016-10-25 14:22:15', 'images/dynamic2.jpg', '2');
INSERT INTO `dynamic` VALUES ('26', '?????', '????', null, null, null, '1', '2016-11-06 15:55:11', 'images/1/20161106155559.jpg', '2');

-- ----------------------------
-- Table structure for `dynamictype`
-- ----------------------------
DROP TABLE IF EXISTS `dynamictype`;
CREATE TABLE `dynamictype` (
  `dynamictype_id` int(11) NOT NULL auto_increment,
  `dynamictype_name` varchar(20) character set gbk default NULL,
  PRIMARY KEY  (`dynamictype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamictype
-- ----------------------------
INSERT INTO `dynamictype` VALUES ('1', '官方发布的动态');
INSERT INTO `dynamictype` VALUES ('2', '用户发布的动态');

-- ----------------------------
-- Table structure for `focus_on`
-- ----------------------------
DROP TABLE IF EXISTS `focus_on`;
CREATE TABLE `focus_on` (
  `focus_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `son_id` int(11) default NULL,
  `time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `state` int(11) default NULL,
  PRIMARY KEY  (`focus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of focus_on
-- ----------------------------
INSERT INTO `focus_on` VALUES ('1', '1', '2', '2016-11-06 13:07:32', '1');
INSERT INTO `focus_on` VALUES ('2', '4', '3', '2016-10-25 21:33:25', '1');
INSERT INTO `focus_on` VALUES ('3', '2', '1', '2016-10-25 21:11:14', '1');
INSERT INTO `focus_on` VALUES ('4', '3', '4', '2016-10-25 21:34:06', '1');
INSERT INTO `focus_on` VALUES ('5', '2', '5', '2016-10-25 21:11:21', '0');
INSERT INTO `focus_on` VALUES ('6', '5', '1', '2016-10-25 21:11:22', '0');
INSERT INTO `focus_on` VALUES ('52', '1', '3', '2016-11-06 17:47:48', '1');
INSERT INTO `focus_on` VALUES ('53', '1', '1', '2016-11-06 14:53:42', '1');
INSERT INTO `focus_on` VALUES ('54', '1', '4', '2016-11-06 17:47:46', '1');
INSERT INTO `focus_on` VALUES ('56', '6', '6', '2016-11-04 21:24:33', '0');
INSERT INTO `focus_on` VALUES ('57', '7', '7', '2016-11-05 15:39:02', '0');
INSERT INTO `focus_on` VALUES ('58', '7', '1', '2016-11-05 15:39:48', '1');
INSERT INTO `focus_on` VALUES ('59', '8', '8', '2016-11-06 03:09:08', '0');
INSERT INTO `focus_on` VALUES ('60', '1', '5', '2016-11-18 17:48:27', '1');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL auto_increment,
  `goods_name` varchar(255) default NULL,
  `goods_desc` varchar(255) default NULL,
  `stock` int(11) default NULL,
  `price` int(11) default NULL,
  `exchange_date_time` timestamp NULL default NULL,
  `image_url` varchar(255) default NULL,
  PRIMARY KEY  (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of goods
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `goods_id` int(11) default NULL,
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `plan_detail`
-- ----------------------------
DROP TABLE IF EXISTS `plan_detail`;
CREATE TABLE `plan_detail` (
  `plan_detail` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `train_plan_id` int(11) default NULL,
  PRIMARY KEY  (`plan_detail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plan_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `report_type` int(11) default NULL,
  `dynamic_id` int(11) default NULL,
  `report_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (`report_id`),
  KEY `user_id` (`user_id`),
  KEY `dynamic_id` (`dynamic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('1', '1', '1', '1', '2016-10-23 00:31:21');
INSERT INTO `report` VALUES ('2', '1', '1', '1', '2016-10-23 00:31:38');
INSERT INTO `report` VALUES ('3', '1', '1', '1', '2016-10-23 01:00:43');
INSERT INTO `report` VALUES ('4', '1', '1', '1', '2016-10-23 02:07:32');
INSERT INTO `report` VALUES ('5', '1', '1', '1', '2016-10-23 02:07:32');
INSERT INTO `report` VALUES ('6', '1', '1', '1', '2016-10-23 02:07:32');
INSERT INTO `report` VALUES ('7', '1', '1', '1', '2016-10-25 09:29:17');

-- ----------------------------
-- Table structure for `reporttype`
-- ----------------------------
DROP TABLE IF EXISTS `reporttype`;
CREATE TABLE `reporttype` (
  `reporttype_id` int(11) NOT NULL auto_increment,
  `reporttype_name` varchar(30) character set gbk default NULL,
  PRIMARY KEY  (`reporttype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reporttype
-- ----------------------------
INSERT INTO `reporttype` VALUES ('1', '色情或违法信息');
INSERT INTO `reporttype` VALUES ('2', '广告信息');
INSERT INTO `reporttype` VALUES ('3', '骚扰谩骂');
INSERT INTO `reporttype` VALUES ('4', '其他');

-- ----------------------------
-- Table structure for `result_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `result_tbl`;
CREATE TABLE `result_tbl` (
  `result_id` int(11) NOT NULL,
  `result_name` varchar(50) default NULL,
  PRIMARY KEY  (`result_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result_tbl
-- ----------------------------
INSERT INTO `result_tbl` VALUES ('1', '未完成');
INSERT INTO `result_tbl` VALUES ('2', '已完成');

-- ----------------------------
-- Table structure for `run_tbl`
-- ----------------------------
DROP TABLE IF EXISTS `run_tbl`;
CREATE TABLE `run_tbl` (
  `run_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `month` int(11) default NULL,
  `day` int(11) default NULL,
  `mileages` double default NULL,
  `mileage` double default NULL,
  `week_day` varchar(20) default NULL,
  `time_length` varchar(20) default NULL,
  `calories` double default NULL,
  `velocity` double default NULL,
  `step_count` int(11) default NULL,
  PRIMARY KEY  (`run_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `run_tbl_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of run_tbl
-- ----------------------------
INSERT INTO `run_tbl` VALUES ('3', '1', '10', '20', '100', '3.9', '星期四', '00:00:01', '0.27', '2.1', '4');
INSERT INTO `run_tbl` VALUES ('4', '1', '10', '20', '100', '5.85', '星期四', '00:00:02', '0.4', '2.12', '6');
INSERT INTO `run_tbl` VALUES ('5', '1', '10', '21', '100', '0', '星期五', '00:00:01', '0.18', '1.77', '3');
INSERT INTO `run_tbl` VALUES ('6', '1', '10', '21', '100', '0.29', '星期五', '00:02:29', '19.62', '1.93', '296');
INSERT INTO `run_tbl` VALUES ('7', '1', '10', '21', '100', '0.35', '星期五', '00:03:03', '24.04', '1.93', '363');
INSERT INTO `run_tbl` VALUES ('8', '1', '10', '21', '100', '23.4', '星期五', '00:00:11', '1.59', '2', '24');
INSERT INTO `run_tbl` VALUES ('9', '1', '10', '21', '0.12', '117', '星期五', '00:01:00', '7.96', '1.93', '120');
INSERT INTO `run_tbl` VALUES ('10', '1', '10', '21', '0.01', '8.4', '星期五', '00:00:03', '0.42', '2.25', '8');
INSERT INTO `run_tbl` VALUES ('11', '1', '10', '22', '0.01', '9.1', '星期六', '00:00:04', '0.46', '2.08', '9');
INSERT INTO `run_tbl` VALUES ('12', '1', '10', '22', '0.01', '6.3', '星期六', '00:00:02', '0.32', '2.26', '6');
INSERT INTO `run_tbl` VALUES ('13', '1', '10', '23', '0', '4.9', '星期天', '00:00:02', '0.24', '2.01', '5');
INSERT INTO `run_tbl` VALUES ('14', '1', '10', '23', '0.18', '182.7', '星期天', '00:01:27', '9.14', '2.09', '174');
INSERT INTO `run_tbl` VALUES ('15', '1', '10', '24', '0', '4.2', '星期一', '00:00:01', '0.21', '2.67', '4');
INSERT INTO `run_tbl` VALUES ('16', '1', '10', '24', '0', '4.2', '星期一', '00:00:01', '0.21', '2.59', '4');
INSERT INTO `run_tbl` VALUES ('17', '1', '10', '24', '0', '2.8', '星期一', '00:00:01', '0.14', '2.43', '3');
INSERT INTO `run_tbl` VALUES ('18', '1', '10', '25', '0.01', '7', '星期二', '00:00:05', '0.35', '1.33', '7');
INSERT INTO `run_tbl` VALUES ('19', '1', '10', '25', '0', '2.1', '星期二', '00:00:03', '0.1', '0.57', '2');
INSERT INTO `run_tbl` VALUES ('20', '1', '10', '26', '0.02', '15.4', '星期三', '00:00:17', '0.77', '0.88', '15');

-- ----------------------------
-- Table structure for `train_plan`
-- ----------------------------
DROP TABLE IF EXISTS `train_plan`;
CREATE TABLE `train_plan` (
  `train_plan_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `result_id` int(11) default NULL,
  `score` int(11) default NULL,
  `create_date_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `train_plan_name` varchar(20) default NULL,
  `schedule` varchar(20) default NULL,
  PRIMARY KEY  (`train_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of train_plan
-- ----------------------------
INSERT INTO `train_plan` VALUES ('28', '1', '1', null, '2016-10-24 08:37:23', '新手训练营-5公里', '10月24日(周一) - 12月11日');
INSERT INTO `train_plan` VALUES ('29', '1', '2', null, '2016-10-24 18:33:08', '新手训练营-5公里', '10月17日(周一) - 12月4日');
INSERT INTO `train_plan` VALUES ('30', '1', '1', null, '2016-10-24 10:28:08', '新手训练营-5公里', '10月17日(周一) - 12月4日');
INSERT INTO `train_plan` VALUES ('31', '1', '1', null, '2016-10-24 10:28:12', '新手训练营-5公里', '10月24日(周一) - 12月11日');
INSERT INTO `train_plan` VALUES ('32', '1', '1', null, '2016-10-24 10:37:14', '新手训练营-5公里', '10月24日(周一) - 12月11日');
INSERT INTO `train_plan` VALUES ('33', '1', '1', null, '2016-10-24 16:26:10', '新手训练营-5公里', '10月17日(周一) - 12月4日');
INSERT INTO `train_plan` VALUES ('34', '1', '1', null, '2016-10-25 10:44:49', '新手训练营-5公里', '10月17日(周一) - 12月4日');
INSERT INTO `train_plan` VALUES ('35', '1', '1', null, '2016-10-26 09:23:39', '新手训练营-5公里', '10月17日(周一) - 12月4日');
INSERT INTO `train_plan` VALUES ('36', '1', '1', null, '2016-10-26 09:53:17', '新手训练营-5公里', '10月17日(周一) - 12月4日');

-- ----------------------------
-- Table structure for `upvote`
-- ----------------------------
DROP TABLE IF EXISTS `upvote`;
CREATE TABLE `upvote` (
  `upvote_id` int(11) NOT NULL auto_increment,
  `dynamic_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `upvote_time` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `state` int(11) default NULL,
  PRIMARY KEY  (`upvote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of upvote
-- ----------------------------
INSERT INTO `upvote` VALUES ('10', '2', '1', '2016-10-27 21:39:57', '1');
INSERT INTO `upvote` VALUES ('11', '2', '2', '2016-10-26 18:48:01', '1');
INSERT INTO `upvote` VALUES ('12', '2', '3', '2016-10-26 15:13:00', '0');
INSERT INTO `upvote` VALUES ('13', '3', '1', '2016-11-03 21:19:41', '1');
INSERT INTO `upvote` VALUES ('14', '3', '2', '2016-10-26 15:13:04', '1');
INSERT INTO `upvote` VALUES ('15', '4', '2', '2016-10-26 15:13:01', '0');
INSERT INTO `upvote` VALUES ('16', '1', '2', '2016-10-26 15:13:02', '0');
INSERT INTO `upvote` VALUES ('17', '1', '1', '2016-11-02 09:56:17', '1');
INSERT INTO `upvote` VALUES ('18', '1', '3', '2016-10-26 15:13:01', '0');
INSERT INTO `upvote` VALUES ('19', '1', '4', '2016-10-26 18:06:53', '0');
INSERT INTO `upvote` VALUES ('24', '1', '3', '2016-10-26 19:02:08', '1');
INSERT INTO `upvote` VALUES ('25', '13', '1', '2016-10-26 21:10:40', '1');
INSERT INTO `upvote` VALUES ('26', '5', '1', '2016-11-02 09:59:31', '1');
INSERT INTO `upvote` VALUES ('27', '11', '1', '2016-10-26 21:29:40', '0');
INSERT INTO `upvote` VALUES ('28', '10', '1', '2016-10-26 21:43:46', '0');
INSERT INTO `upvote` VALUES ('29', '9', '1', '2016-11-06 14:59:49', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment COMMENT '用户id',
  `user_name` varchar(20) character set gbk default NULL COMMENT '用户名',
  `real_name` varchar(10) character set gbk default NULL COMMENT '真是姓名',
  `password` varchar(11) character set gbk default NULL COMMENT '密码',
  `sex` varchar(4) character set gbk default NULL COMMENT '性别',
  `age` int(4) default NULL COMMENT '年龄',
  `score` int(11) default NULL COMMENT '积分',
  `height` float(11,0) default NULL COMMENT '身高',
  `weight` float(11,0) default NULL COMMENT '体重',
  `imageurl` varchar(100) character set gbk default NULL COMMENT '头像地址',
  `address` varchar(20) character set gbk default NULL COMMENT '地址',
  `phone` int(20) default NULL COMMENT '电话',
  `create_time` timestamp NULL default '0000-00-00 00:00:00' COMMENT '创建时间',
  `account` varchar(20) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '张三', '123456', '男', '12', '555', '165', '100', 'images/tou1.jpg', '北京', '83843598', '2016-10-20 14:14:03', '123456');
INSERT INTO `user` VALUES ('2', '李四', '李四', '123456', '男', '25', '666', '170', '120', 'images/tou2.jpg', '上海', '123', '2016-10-20 16:26:29', '123');
INSERT INTO `user` VALUES ('3', '王五', '王五', '123456', '女', '18', '999', '165', '100', 'images/tou3.jpg', '江苏', '46546565', '2016-10-20 16:26:32', '321');
INSERT INTO `user` VALUES ('4', '玛丽', '玛丽', '123456', '女', '17', '888', '170', '100', 'images/tou4.jpg', '深圳', '12345678', '2016-10-20 16:37:39', '456');
INSERT INTO `user` VALUES ('5', '老王', '老王', '123456', '男', '55', '658', '150', '200', 'images/tou5.jpg', '大西北', '12345678', '2016-11-15 17:52:32', '789');
INSERT INTO `user` VALUES ('7', null, null, 'kk', null, null, null, null, null, null, null, null, '2016-11-05 15:39:01', '111');
INSERT INTO `user` VALUES ('8', null, 'abc', '123456', null, null, null, null, null, null, null, null, '2016-11-06 03:09:08', null);

-- ----------------------------
-- Table structure for `user_competition_table`
-- ----------------------------
DROP TABLE IF EXISTS `user_competition_table`;
CREATE TABLE `user_competition_table` (
  `user_competition_id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `step` int(11) default NULL COMMENT '步数',
  `mileage` float(11,0) default NULL COMMENT '里程',
  PRIMARY KEY  (`user_competition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_competition_table
-- ----------------------------
