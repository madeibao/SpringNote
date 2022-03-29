/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : workspace

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 10/03/2022 22:48:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'aaa', 3900);
INSERT INTO `account` VALUES (2, 'bbb', 1100);
INSERT INTO `account` VALUES (3, 'mc', 300);
INSERT INTO `account` VALUES (4, 'md', 400);
INSERT INTO `account` VALUES (5, 'me', 200);

SET FOREIGN_KEY_CHECKS = 1;
