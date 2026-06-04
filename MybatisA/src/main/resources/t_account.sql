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

 Date: 26/02/2022 21:02:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account
-- ----------------------------
INSERT INTO `t_account` VALUES (1, '小马', '111', 22);
INSERT INTO `t_account` VALUES (2, '小鲁', '222', 23);
INSERT INTO `t_account` VALUES (3, '小马', '111', 22);
INSERT INTO `t_account` VALUES (4, '小鲁', '222', 23);
INSERT INTO `t_account` VALUES (5, '小马', '111', 22);
INSERT INTO `t_account` VALUES (6, '小鲁', '222', 23);
INSERT INTO `t_account` VALUES (30, '小马', '111', 22);
INSERT INTO `t_account` VALUES (31, '小鲁', '222', 23);

SET FOREIGN_KEY_CHECKS = 1;
