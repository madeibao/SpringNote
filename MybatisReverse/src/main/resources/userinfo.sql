/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : myspace3

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 30/08/2023 16:25:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userpwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `useraddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `usertel` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `isdelete` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '张三', '123', '南京', '七天', 1);
INSERT INTO `userinfo` VALUES (2, '李四', '233', '北京', '圣地酒店', 1);
INSERT INTO `userinfo` VALUES (3, 'admin', '7849', '青岛', '北极星', 1);
INSERT INTO `userinfo` VALUES (4, 'admin2', '32', '烟台', '北极星', 1);
INSERT INTO `userinfo` VALUES (5, '张六', '232', '青岛', '南极星', 1);
INSERT INTO `userinfo` VALUES (6, '张三', '123456', '大连', '13698745698', 1);
INSERT INTO `userinfo` VALUES (7, '张三', '123456', '大连', '13698745698', 1);
INSERT INTO `userinfo` VALUES (8, '尼古拉特斯拉', '123456', '大连', '13698745698', 1);

SET FOREIGN_KEY_CHECKS = 1;
