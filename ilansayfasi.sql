/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : ilansayfasi

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 04/01/2018 14:45:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adid` int(11) NOT NULL AUTO_INCREMENT,
  `adname` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `adpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for arabalar
-- ----------------------------
DROP TABLE IF EXISTS `arabalar`;
CREATE TABLE `arabalar`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL,
  `secim` set('Sunroof','Otomatik Vites','Dağ Aracı','Dizel') CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL DEFAULT '',
  `karar` enum('Kırmızı','Siyah','Mavi') CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `tarih` datetime(0) NULL DEFAULT NULL,
  `test` text CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `param` decimal(5, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE,
  FULLTEXT INDEX `full_text_arama_1`(`test`, `title`)
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ekiralik
-- ----------------------------
DROP TABLE IF EXISTS `ekiralik`;
CREATE TABLE `ekiralik`  (
  `ekid` int(11) NOT NULL AUTO_INCREMENT,
  `ekbaslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ekacik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ekdetay` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ekresim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `ekfiyat` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`ekid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for esatilik
-- ----------------------------
DROP TABLE IF EXISTS `esatilik`;
CREATE TABLE `esatilik`  (
  `esid` int(11) NOT NULL AUTO_INCREMENT,
  `esbaslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `esacik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `esdetay` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `esresim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `esfiyat` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`esid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for urun_resimleri
-- ----------------------------
DROP TABLE IF EXISTS `urun_resimleri`;
CREATE TABLE `urun_resimleri`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `urun_id` int(11) NOT NULL,
  `adi` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `klasor` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for varazi
-- ----------------------------
DROP TABLE IF EXISTS `varazi`;
CREATE TABLE `varazi`  (
  `vaid` int(11) NOT NULL AUTO_INCREMENT,
  `vabaslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vaacik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vadetay` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `varesim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vafiyat` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`vaid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for vkamyonet
-- ----------------------------
DROP TABLE IF EXISTS `vkamyonet`;
CREATE TABLE `vkamyonet`  (
  `vkid` int(11) NOT NULL AUTO_INCREMENT,
  `vkbaslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vkacik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vkdetay` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vkresim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vkfiyat` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`vkid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for votomobil
-- ----------------------------
DROP TABLE IF EXISTS `votomobil`;
CREATE TABLE `votomobil`  (
  `voidd` int(11) NOT NULL AUTO_INCREMENT,
  `vobaslik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `voacik` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vodetay` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `voresim` varchar(255) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `vofiyat` double(255, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`voidd`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
