/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : myspace5

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/09/2023 14:59:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (1, '购买了手机', '2022-08-25 05:34:17');
INSERT INTO `order_info` VALUES (2, '购买了电脑', '2022-08-25 07:30:39');
INSERT INTO `order_info` VALUES (3, '购买了护手霜', '2022-08-17 22:35:07');
INSERT INTO `order_info` VALUES (4, '购买了泡面', '2022-08-23 08:35:36');
INSERT INTO `order_info` VALUES (5, '购买了纸巾', '2022-07-21 15:26:06');
INSERT INTO `order_info` VALUES (6, '购买了自热米饭', '2021-06-20 13:21:06');
INSERT INTO `order_info` VALUES (7, '购买了移动硬盘', '2022-06-11 11:22:03');
INSERT INTO `order_info` VALUES (8, '购买了狗粮', '2022-05-10 11:21:02');
INSERT INTO `order_info` VALUES (9, '购买了猫粮', '2022-04-10 09:11:02');
INSERT INTO `order_info` VALUES (10, '购买了遥控器', '2022-08-22 22:35:07');
INSERT INTO `order_info` VALUES (11, '购买了裤子', '2022-08-15 08:35:36');
INSERT INTO `order_info` VALUES (12, '购买了鞋子', '2022-08-21 08:35:36');
INSERT INTO `order_info` VALUES (13, '购买了水杯', '2022-08-26 19:39:19');

SET FOREIGN_KEY_CHECKS = 1;
