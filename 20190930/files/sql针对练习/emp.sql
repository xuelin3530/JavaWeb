/*
Navicat MySQL Data Transfer

Source Server         : ttt
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-10-15 09:02:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int(11) NOT NULL,
  `ename` varchar(10) DEFAULT NULL,
  `job` varchar(9) DEFAULT NULL,
  `mgr` int(11) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` int(11) DEFAULT NULL,
  `comm` float DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  PRIMARY KEY (`empno`),
  UNIQUE KEY `ename` (`ename`),
  KEY `fk_deptno` (`deptno`),
  CONSTRAINT `fk_deptno` FOREIGN KEY (`deptno`) REFERENCES `dept` (`deptno`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO emp VALUES ('7369', 'SMITH', 'CLERK', '7499', '1980-12-17', '850', null, '10');
INSERT INTO emp VALUES ('7499', 'ALLEN', 'SALEMAN', '7698', '1981-02-20', '1600', '300', '30');
INSERT INTO emp VALUES ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250', '500', '30');
INSERT INTO emp VALUES ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2850', null, '20');
INSERT INTO emp VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250', '1400', '30');
INSERT INTO emp VALUES ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850', null, '30');
INSERT INTO emp VALUES ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450', null, '10');
INSERT INTO emp VALUES ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000', null, '20');
INSERT INTO emp VALUES ('7839', 'KING', 'PRESIDENT', null, '1981-11-17', '5000', null, '10');
INSERT INTO emp VALUES ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500', '0', '30');
INSERT INTO emp VALUES ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100', null, '20');
INSERT INTO emp VALUES ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '960', null, '30');
INSERT INTO emp VALUES ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000', null, '20');
INSERT INTO emp VALUES ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '1300', null, '10');
