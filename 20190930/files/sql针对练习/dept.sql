/*
Navicat MySQL Data Transfer

Source Server         : ttt
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-10-15 09:02:44
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(100) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO dept VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO dept VALUES ('40', 'OPERATIONS', 'BOSTON');
