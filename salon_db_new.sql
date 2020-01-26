/*
Navicat MySQL Data Transfer

Source Server         : uat
Source Server Version : 80012
Source Host           : localhost:3333
Source Database       : salon_db

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-01-26 21:56:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address_master
-- ----------------------------
DROP TABLE IF EXISTS `address_master`;
CREATE TABLE `address_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `customer_master_pk` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `pincode` varchar(10) NOT NULL,
  `default_flag` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`pk`),
  KEY `fk3` (`customer_master_pk`),
  CONSTRAINT `fk3` FOREIGN KEY (`customer_master_pk`) REFERENCES `customer_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of address_master
-- ----------------------------

-- ----------------------------
-- Table structure for customer_master
-- ----------------------------
DROP TABLE IF EXISTS `customer_master`;
CREATE TABLE `customer_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `contact1` varchar(15) NOT NULL,
  `contact2` varchar(15) DEFAULT NULL,
  `active_deactive` int(11) DEFAULT '1',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `unique_constr` (`email`) USING BTREE,
  UNIQUE KEY `unique_constr_1` (`contact1`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of customer_master
-- ----------------------------
INSERT INTO `customer_master` VALUES ('1', 'Sonali', 'Yadav', 'simplysonali10053@gmail.com', '9565848471', '', '1', 'Female');
INSERT INTO `customer_master` VALUES ('2', 'Pankaj', 'Garg', 'gargpankaj015@gmail.com', '9565848470', '123456', '0', 'Male');
INSERT INTO `customer_master` VALUES ('3', 'Pulkit', 'Kewlani', 'ptg251294@gmail.com', '9565123456', '', '1', 'Male');
INSERT INTO `customer_master` VALUES ('4', 'Vriti', 'Bhandula', 'v@gmail.com', '234569872', '', '1', 'Female');

-- ----------------------------
-- Table structure for online_cart
-- ----------------------------
DROP TABLE IF EXISTS `online_cart`;
CREATE TABLE `online_cart` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `customer_master_pk` int(11) NOT NULL,
  `salon_service_mapping_pk` int(11) NOT NULL,
  `quantity` int(11) DEFAULT '1',
  `date_added` datetime DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk1` (`customer_master_pk`),
  KEY `fk2` (`salon_service_mapping_pk`),
  CONSTRAINT `fk1` FOREIGN KEY (`customer_master_pk`) REFERENCES `customer_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`salon_service_mapping_pk`) REFERENCES `salon_service_mapping` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of online_cart
-- ----------------------------

-- ----------------------------
-- Table structure for payment_master
-- ----------------------------
DROP TABLE IF EXISTS `payment_master`;
CREATE TABLE `payment_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `payment_date datetime` datetime NOT NULL,
  `reconcile_date datetime` datetime NOT NULL,
  `amount` int(11) NOT NULL,
  `net_amount` int(11) NOT NULL,
  `response_amount` int(11) NOT NULL,
  `transaction_id` varchar(255) NOT NULL,
  `from_upi_id` varchar(255) NOT NULL,
  `to_upi_id` varchar(255) NOT NULL,
  `customer_master_pk` int(11) NOT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of payment_master
-- ----------------------------

-- ----------------------------
-- Table structure for salon_master
-- ----------------------------
DROP TABLE IF EXISTS `salon_master`;
CREATE TABLE `salon_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `salon_name` varchar(30) NOT NULL,
  `address` text,
  `contact1` varchar(15) DEFAULT NULL,
  `contact2` varchar(15) DEFAULT NULL,
  `description` text,
  `type` tinyint(2) DEFAULT NULL,
  `home_service_flag` tinyint(2) DEFAULT '0',
  `date_created` datetime DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `current_rating` int(11) DEFAULT '0',
  `active_deactive` tinyint(4) DEFAULT '1',
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `unique_constr_2` (`email`) USING BTREE,
  UNIQUE KEY `unique_constr_1` (`contact1`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salon_master
-- ----------------------------

-- ----------------------------
-- Table structure for salon_service_mapping
-- ----------------------------
DROP TABLE IF EXISTS `salon_service_mapping`;
CREATE TABLE `salon_service_mapping` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `salon_master_pk` int(11) NOT NULL,
  `service_master_pk` int(11) NOT NULL,
  `service_cost` int(11) NOT NULL,
  `home_service_flag` tinyint(4) NOT NULL DEFAULT '0',
  `active_deactive` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`pk`),
  KEY `fk4` (`salon_master_pk`),
  KEY `fk5` (`service_master_pk`),
  CONSTRAINT `fk4` FOREIGN KEY (`salon_master_pk`) REFERENCES `salon_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk5` FOREIGN KEY (`service_master_pk`) REFERENCES `service_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salon_service_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for service_master
-- ----------------------------
DROP TABLE IF EXISTS `service_master`;
CREATE TABLE `service_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(30) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk6` (`type`),
  CONSTRAINT `fk6` FOREIGN KEY (`type`) REFERENCES `types_master` (`pk`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of service_master
-- ----------------------------

-- ----------------------------
-- Table structure for types_master
-- ----------------------------
DROP TABLE IF EXISTS `types_master`;
CREATE TABLE `types_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(10) NOT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of types_master
-- ----------------------------

-- ----------------------------
-- Table structure for user_mapping
-- ----------------------------
DROP TABLE IF EXISTS `user_mapping`;
CREATE TABLE `user_mapping` (
  `pk` int(11) NOT NULL,
  `user_id` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) DEFAULT '1' COMMENT '1: customer, 2: salon',
  `master_pk` int(11) NOT NULL,
  `active_deactive` int(11) DEFAULT '1',
  PRIMARY KEY (`pk`),
  UNIQUE KEY `unique_c1` (`user_id`) USING BTREE,
  UNIQUE KEY `unique_c2` (`password`) USING BTREE,
  UNIQUE KEY `unique_c3` (`master_pk`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_mapping
-- ----------------------------
