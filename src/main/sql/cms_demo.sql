/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : cms

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 11/25/2017 14:26:20 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cms_demo`
-- ----------------------------
DROP TABLE IF EXISTS `cms_demo`;
CREATE TABLE `cms_demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `cms_demo`
-- ----------------------------
BEGIN;
INSERT INTO `cms_demo` VALUES ('1', 'test', '测试数据'), ('2', 'doneDate', '测试2017.11.25');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
