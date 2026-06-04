/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : myspace

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 15/08/2023 15:13:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三四', 12);
INSERT INTO `user` VALUES (2, '马德宝', 27);
INSERT INTO `user` VALUES (4, '马远', 23);
INSERT INTO `user` VALUES (5, '鲁智深', 26);
INSERT INTO `user` VALUES (6, '郭达', 57);
INSERT INTO `user` VALUES (7, '姜维', 78);
INSERT INTO `user` VALUES (8, '张麻子', 57);

SET FOREIGN_KEY_CHECKS = 1;
