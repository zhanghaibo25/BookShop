/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bookshop

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 24/08/2020 09:15:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_sepassword` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '二级密码',
  `admin_phone` int(11) NOT NULL,
  `category_id` int(11) NOT NULL COMMENT '权限代码',
  `admin_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_image` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `admin_sex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, '123', '123', '123', 123, 1, '123', 'asd', 'asd');
INSERT INTO `admin` VALUES (2, '李四', '111', '111', 1234, 2, 'asd', 'sdad', 'asdf');
INSERT INTO `admin` VALUES (3, '张三', '111', '12345', 12345, 1, 'asd', 'asad', 'afdsa');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `book_publisher` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出版商',
  `book_price` decimal(10, 2) NOT NULL COMMENT '价格',
  `book_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面',
  `book_first_category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主类',
  `book_second_category` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '次类',
  `book_transaction_time` int(11) NOT NULL COMMENT '交易次数',
  `book_stock` int(11) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`book_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '时间简史', '霍金', 'qweqw', 25.00, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764231844,3223001859&fm=26&gp=0.jpg', '科普', '少儿', 5, 20);
INSERT INTO `book` VALUES (2, '生命简史', '123', '1321', 101.00, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764231844,3223001859&fm=26&gp=0.jpg', '科普', '少儿', 4, 22);
INSERT INTO `book` VALUES (3, '叙事经济学', '罗伯特', '123445', 66.50, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764231844,3223001859&fm=26&gp=0.jpg', '经济', '国外', 2, 25);
INSERT INTO `book` VALUES (4, '半小时漫画经济', '陈磊', '2134', 20.00, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764231844,3223001859&fm=26&gp=0.jpg', '经济', '漫画', 5, 20);
INSERT INTO `book` VALUES (5, '聂卫平围棋教程', '聂卫平', '3423', 19.50, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3764231844,3223001859&fm=26&gp=0.jpg', '体育', '教育', 6, 15);

-- ----------------------------
-- Table structure for loginrecord
-- ----------------------------
DROP TABLE IF EXISTS `loginrecord`;
CREATE TABLE `loginrecord`  (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginrecord
-- ----------------------------

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(11) NOT NULL COMMENT '订单',
  `user_id` int(11) NOT NULL,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_price` decimal(10, 2) NULL DEFAULT NULL,
  `order_status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for purchaserecord
-- ----------------------------
DROP TABLE IF EXISTS `purchaserecord`;
CREATE TABLE `purchaserecord`  (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` date NOT NULL,
  `book_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_price` decimal(10, 2) NOT NULL,
  `record_time` datetime(6) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`record_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchaserecord
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_sex` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_mail` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_login_time` datetime(6) NOT NULL,
  `user_pur_record` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买记录',
  `user_img` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (00000000001, '张三', '123', '男', '123', '123', '123', '2020-05-01 00:15:11.000000', '1', NULL);
INSERT INTO `user` VALUES (00000000002, '李四', '234', '男', '234', '234', '234', '2020-05-08 00:15:28.000000', '1', NULL);
INSERT INTO `user` VALUES (00000000003, '王五', '345', '女', '345', '345', '345', '2020-05-02 00:16:27.000000', '2', NULL);
INSERT INTO `user` VALUES (00000000004, '岳云鹏', '456', '男', '456', '456', '456', '2020-05-03 00:18:50.000000', '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
