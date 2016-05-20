/*
Navicat MySQL Data Transfer

Source Server         : wyz
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2016-05-20 23:08:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'aa', 'aa', 's', null);
INSERT INTO `user` VALUES ('2', '123', '123', '123@123.com', '1463755985548.jpg');
INSERT INTO `user` VALUES ('3', '123', '123', '123@123.com', '1463756007330.jpg');
INSERT INTO `user` VALUES ('4', '123', '123', '123@123.com', '1463756234409.jpg');
INSERT INTO `user` VALUES ('5', '123', '123', '123@123.com', '1463756348704.jpg');
INSERT INTO `user` VALUES ('6', '123', '123', '123@123.com', '1463756402919.jpg');
INSERT INTO `user` VALUES ('7', '123', '123', '123@123.com', '1463756582247.jpg');
INSERT INTO `user` VALUES ('8', '123', '123', '123@123.com', '');
