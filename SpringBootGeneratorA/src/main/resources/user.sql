/*
 Navicat Premium Data Transfer

 Source Server         : myTest
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : aspace2

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/09/2023 21:18:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'mayuan', '123');
INSERT INTO `user` VALUES (2, 'Rina', '223232');
INSERT INTO `user` VALUES (3, 'Bog', '2324');
INSERT INTO `user` VALUES (4, 'Tim', '2wewe');
INSERT INTO `user` VALUES (5, 'Alice', '234323');
INSERT INTO `user` VALUES (6, 'Tian', '22fwewe');
INSERT INTO `user` VALUES (7, 'Nana', 'mam');
INSERT INTO `user` VALUES (8, 'wang', '232v');
INSERT INTO `user` VALUES (9, 'rice', '23239');

SET FOREIGN_KEY_CHECKS = 1;
