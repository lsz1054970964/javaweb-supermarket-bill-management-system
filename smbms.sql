-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: localhost    Database: smbms
-- ------------------------------------------------------
-- Server version	8.0.33

CREATE DATABASE `smbms`;

USE `smbms`;

-- ----------------------------
-- Table structure for smbms_address
-- ----------------------------
DROP TABLE IF EXISTS `smbms_address`;
CREATE TABLE `smbms_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key ID',
  `contact` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Contact Name',
  `addressDesc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Address Details',
  `postCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Post Code Number',
  `tel` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Contact Telephone Number',
  `createdBy` bigint(20) DEFAULT NULL COMMENT 'Creator ID',
  `creationDate` datetime DEFAULT NULL COMMENT 'Created Date',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT 'Modifier ID',
  `modifyDate` datetime DEFAULT NULL COMMENT 'Modified Dates',
  `userId` bigint(20) DEFAULT NULL COMMENT 'User ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of smbms_address
-- ----------------------------
INSERT INTO `smbms_address` VALUES (1,'Wang Li','No.44, Dongjiaomin Lane, Dongcheng District, Beijing','100010','13678789999',1,'2016-04-13 00:00:00',NULL,NULL,1);
INSERT INTO `smbms_address` VALUES (2,'Zhang Hongli','No.3 Danling Street, Haidian District, Beijing','100000','18567672312',1,'2016-04-13 00:00:00',NULL,NULL,1);
INSERT INTO `smbms_address` VALUES (3,'Ren Zhiqiang','No.23 Back Street, Art Museum, Dongcheng District, Beijing','100021','13387906742',1,'2016-04-13 00:00:00',NULL,NULL,1);
INSERT INTO `smbms_address` VALUES (4,'Cao Ying','No.14, Chaoyangmen South Street, Chaoyang District, Beijing','100053','13568902323',1,'2016-04-13 00:00:00',NULL,NULL,2);
INSERT INTO `smbms_address` VALUES (5,'Li Hui','No.3, South Third Lane, Sanlihe Road, Xicheng District, Beijing','100032','18032356666',1,'2016-04-13 00:00:00',NULL,NULL,3);
INSERT INTO `smbms_address` VALUES (6,'Wang Guoqiang','No.18, Jinma Industrial Zone, Gaoliying Town, Shunyi District, Beijing','100061','13787882222',1,'2016-04-13 00:00:00',NULL,NULL,3);


-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Primary Key ID',
  `billCode` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Bill Code',
  `productName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Product Name',
  `productDesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Product Description',
  `productUnit` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Product Unit',
  `productCount` decimal(20,2) DEFAULT NULL COMMENT 'Product Count',
  `totalPrice` decimal(20,2) DEFAULT NULL COMMENT 'Total Price',
  `isPayment` int(10) DEFAULT NULL COMMENT 'Whether the bill is paid（1：not paid 2：paid）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT 'Creator ID',
  `creationDate` datetime DEFAULT NULL COMMENT 'Created Date',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT 'Modifier ID',
  `modifyDate` datetime DEFAULT NULL COMMENT 'Modified Date',
  `providerId` int(20) DEFAULT NULL COMMENT 'Provider ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of smbms_bill
-- ----------------------------
INSERT INTO `smbms_bill` VALUES (1,'BILL2016_001','shampoo, conditioner','Daily Necessities - Shampoo, Hair Conditioner','bottle',500.00,25000.00,2,1,'2014-12-14 13:02:03',15,'2019-04-16 21:43:12',13);
INSERT INTO `smbms_bill` VALUES (2,'BILL2016_002','soap, bar soap, medicated soap','Daily Necessities - Soap','bar',1000.00,10000.00,2,1,'2016-03-23 04:20:40',NULL,NULL,13);
INSERT INTO `smbms_bill` VALUES (3,'BILL2016_003','soybean oil','Food - Cooking Oil','kilo',300.00,5890.00,2,1,'2014-12-14 13:02:03',NULL,NULL,6);
INSERT INTO `smbms_bill` VALUES (4,'BILL2016_004','olive oil','Food - Imported Cooking Oil','kilo',200.00,9800.00,2,1,'2013-10-10 03:12:13',NULL,NULL,7);
INSERT INTO `smbms_bill` VALUES (5,'BILL2016_005','dish soap','Daily necessities - Kitchen Cleaning','bottle',500.00,7000.00,2,1,'2014-12-14 13:02:03',NULL,NULL,9);
INSERT INTO `smbms_bill` VALUES (6,'BILL2016_006','American almonds','Food - Nuts','pack',300.00,5000.00,2,1,'2016-04-14 06:08:09',NULL,NULL,4);
INSERT INTO `smbms_bill` VALUES (7,'BILL2016_007','body soap, essential oil','Daily Necessities - Bath','bottle',500.00,23000.00,1,1,'2016-07-22 10:10:22',NULL,NULL,14);
INSERT INTO `smbms_bill` VALUES (8,'BILL2016_008','stainless steel bowl','Daily necessities - Kitchen Utensils','piece',600.00,6000.00,2,1,'2016-04-14 05:12:13',NULL,NULL,14);
INSERT INTO `smbms_bill` VALUES (9,'BILL2016_009','plastic cup','Daily necessities - Cup','kilo',350.00,1750.00,2,1,'2016-02-04 11:40:20',NULL,NULL,14);
INSERT INTO `smbms_bill` VALUES (10,'BILL2016_010','bean paste','Food - Seasoning','bottle',200.00,2000.00,2,1,'2013-10-29 05:07:03',NULL,NULL,8);
INSERT INTO `smbms_bill` VALUES (11,'BILL2016_011','Haizhilan','Wine - Chinese Wine','bottle',50.00,10000.00,1,1,'2016-04-14 16:16:00',NULL,NULL,1);
INSERT INTO `smbms_bill` VALUES (12,'BILL2016_012','Chivas','Wine - Foreign Wine','bottle',20.00,6000.00,1,1,'2016-09-09 17:00:00',NULL,NULL,1);
INSERT INTO `smbms_bill` VALUES (13,'BILL2016_013','Changcheng red wine','Wine - Red Wine','bottle',60.00,800.00,2,1,'2016-11-14 15:23:00',NULL,NULL,1);
INSERT INTO `smbms_bill` VALUES (14,'BILL2016_014','Thai rice','Food - Rice','kilo',400.00,5000.00,2,1,'2016-10-09 15:20:00',NULL,NULL,3);
INSERT INTO `smbms_bill` VALUES (15,'BILL2016_015','Northeast rice','Food - Rice','kilo',600.00,4000.00,2,1,'2016-11-14 14:00:00',NULL,NULL,3);
INSERT INTO `smbms_bill` VALUES (16,'BILL2016_016','Coca Cola','Drinks','bottle',2000.00,6000.00,2,1,'2012-03-27 13:03:01',NULL,NULL,2);
INSERT INTO `smbms_bill` VALUES (17,'BILL2016_017','Maidong','Drinks','bottle',1500.00,4500.00,2,1,'2016-05-10 12:00:00',NULL,NULL,2);

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary Key ID',
  `proCode` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Code',
  `proName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Name',
  `proDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Description',
  `proContact` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Contact',
  `proPhone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Telephone Number',
  `proAddress` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Address',
  `proFax` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'Provider Fax Number',
  `createdBy` bigint(20) DEFAULT NULL COMMENT 'Creator ID',
  `creationDate` datetime DEFAULT NULL COMMENT 'Created Date',
  `modifyDate` datetime DEFAULT NULL COMMENT 'Modifier ID',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT 'Modified Date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of smbms_provider
-- ----------------------------
INSERT INTO `smbms_provider` VALUES (1,'BJ_GYS001','Beijing Sanmutang Trading Co., Ltd','Long-term partner, main products: Moutai, Wuliangye, Langjiu, Jiuguijiu, Luzhou Laojiao, Lai Maojiu, French red wine, etc.','Zhang Guoqiang','13566669999','North Yufangyuan Road, Fengtai District, Beijing','010-58858787',1,'2013-03-21 16:52:07','2019-04-12 16:44:03',10);
INSERT INTO `smbms_provider` VALUES (2,'HB_GYS001','Shijiazhuang Shuaiyi Food Trading Co., Ltd.','Long-term partner, main products: beverages, water drinks, plant protein drinks, snack foods, fruit juice drinks, functional drinks, etc.','Wang Jun','13309094212','Hebei Xinhua District, Shijiazhuang, Province','0311-67738876',1,'2016-04-13 04:20:40',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (3,'GZ_GYS001','Shenzhen Taixiang Rice Industry Co., Ltd','Initial partner, main products: Liangji Jinlun Rice, Longlun Fragrant Rice, etc','Zheng Chenghan','13402013312','Huafeng Building, 6006 Shennan Avenue, Futian District, Shenzhen, Guangdong Province','0755-67776212',1,'2014-03-21 16:56:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (4,'GZ_GYS002','Shenzhen Xilaike Trading Co., Ltd','Long-term partner, main products: Roasted nuts, candied fruit, natural scented tea, nutritious beans, specialty food, imported food, seafood snacks, dried meat','Lin Ni','18599897645','West Floor 3, Building B2, Fulong Industrial Zone, Shenzhen, Guangdong Province','0755-67772341',1,'2013-03-22 16:52:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (5,'JS_GYS001','Xinghua Jiamei Seasoning Factory','Long-term partner, main products: natural spices, chicken essence, compound seasoning','Xu Guoyang','13754444221','Linhu Industrial Zone, Xinghua City, Jiangsu Province','0523-21299098',1,'2015-11-22 16:52:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (6,'BJ_GYS002','Beijing Naful Edible Oil Co., Ltd.','Long-term partner, main products: camellia oil, soybean oil, peanut oil, olive oil, etc.','Maying','13422235678','Zhujiang Dijing 1, Chaoyang District, Beijing Building No.','010-588634233',1,'2012-03-21 17:52:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (7,'BJ_GYS003','Beijing National Grain Oil Co., Ltd.','Initial partner, main products: peanut oil, soybean oil, small mill oil, etc.','Wang Chi','13344441135','Beijing Daxing Qingyundian Development Zone','010-588134111',1,'2016-04-13 00:00:00',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (8,'ZJ_GYS001','Cixi Guanghe Green Food Factory','Long-term partner, main products: bean paste, soybean paste, sweet noodle sauce, chili, garlic and other agricultural products','Xue Shengdan','18099953223','Zhou Lane, Cixi, Ningbo City, Zhejiang Province Xiao`an Village','0574-34449090',1,'2013-11-21 06:02:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (9,'GX_GYS001','Youbai Trading Co., Ltd','Long-term partner, main products: daily chemical products','Li Liguo','13323566543','No. 42-1, Xiuxiang Avenue, Nanning, Guangxi','0771-98861134',1,'2013-03-21 19:52:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (10,'JS_GYS002','Nanjing Huotoujun Information Technology Co., Ltd.','Long-term partner, main products: stainless steel kitchenware, etc.','Ms. Chen','13098992113','Room 903, Block A, Xincheng Headquarters Building, No. 1 Pukou Avenue, Pukou District, Nanjing City, Jiangsu Province room','025-86223345',1,'2013-03-25 16:52:07',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (11,'GZ_GYS003','Guangzhou Baiyun District Meixing Hardware Products Factory','Long-term partner, main products: sponge mattresses, cushions, cushions, sponge pillows, headrests, etc','Liang Tian','13562276775','Baiyun District, Guangzhou No. 20, Fulong Road, Zhongluotan Town','020-85542231',1,'2016-12-21 06:12:17',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (12,'BJ_GYS004','Beijing Longsheng Daily Chemical Technology','Long-term partner, main products: daily chemical environmental protection cleaning agent, household cleaning monopoly, washing supplies network, wall mold remover, wall mold remover, etc','Sun Xin','13689865678','Jiugong, Daxing District, Beijing','010-35576786',1,'2014-11-21 12:51:11',NULL,NULL);
INSERT INTO `smbms_provider` VALUES (13,'SD_GYS001','Shandong Haoke Huaguang United Development Co., Ltd.','Long-term partner, main products: laundry soap, laundry powder, laundry detergent, detergent, disinfectant, soap, etc.','Wu Hongzhuan','13245468787 ','No. 21, Renhe Street, Jibei Industrial Zone, Jiyang, Shandong','0531-53362445',1,'2015-01-28 10:52:07',NULL,NULL);
-- ----------------------------
-- Table structure for smbms_role
-- ----------------------------
DROP TABLE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary Key ID',
  `roleCode` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT 'Role Code',
  `roleName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'Role Name',
  `createdBy` bigint(20) DEFAULT NULL COMMENT 'Creator ID',
  `creationDate` datetime DEFAULT NULL COMMENT 'Created Date',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT 'Modifier ID',
  `modifyDate` datetime DEFAULT NULL COMMENT 'Modified Date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of smbms_role
-- ----------------------------
INSERT INTO `smbms_role` VALUES (1,'SMBMS_ADMIN','System administrator',1,'2016-04-13 00:00:00',NULL,NULL);
INSERT INTO `smbms_role` VALUES (2,'SMBMS_MANAGER','Manager',1,'2016-04-13 00:00:00',NULL,NULL);
INSERT INTO `smbms_role` VALUES (3,'SMBMS_EMPLOYEE','Employee',1,'2016-04-13 00:00:00',NULL,NULL);

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary Key ID',
  `userCode` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT 'User Code',
  `userName` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User Name',
  `userPassword` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT 'User Password',
  `gender` int(10) DEFAULT NULL COMMENT 'Gender（1: Female、 2: Male）',
  `birthday` date DEFAULT NULL COMMENT 'Date of Birth',
  `phone` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT 'Telephone Number',
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT 'Address',
  `userRole` int(10) DEFAULT NULL COMMENT 'User Role（from smbms_role - id）',
  `createdBy` bigint(20) DEFAULT NULL COMMENT 'Creator ID',
  `creationDate` datetime DEFAULT NULL COMMENT 'Created Date',
  `modifyBy` bigint(20) DEFAULT NULL COMMENT 'Modifier ID',
  `modifyDate` datetime DEFAULT NULL COMMENT 'Modified Date',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES (1,'wen','admin','123',1,'1997-01-01','15200981234','Nanhua University, Zhengxiang District, Hengyang City, Hunan Province',1,1,'2019-04-07 10:15:55',NULL,NULL);
INSERT INTO `smbms_user` VALUES (5,'hanlubiao','Han Lubiao','0000000',2,'1984-06-05','18567542321','No.12, Beichen Center, Chaoyang District, Beijing',2,1,'2014-12-31 19:52:09',NULL,NULL);
INSERT INTO `smbms_user` VALUES (6,'zhanghua','Zhang Hua','0000000',1,'1983-06-15','13544561111','No.61 Xueyuan Road, Haidian District, Beijing',3,1,'2013-02-11 10:51:17',NULL,NULL);
INSERT INTO `smbms_user` VALUES (7,'wangyang','Wang Yang','0000000',2,'1982-12-31','13444561124','16th Floor, Brilliant International, West Second Banner, Haidian District, Beijing',3,1,'2014-06-11 19:09:07',NULL,NULL);
INSERT INTO `smbms_user` VALUES (8,'zhaoyan','Zhao Yan','0000000',1,'1986-03-07','18098764545','Building 10, Huilongguan Community, Haidian District, Beijing',3,1,'2016-04-21 13:54:07',NULL,NULL);
INSERT INTO `smbms_user` VALUES (10,'sunlei','Sun Lei','0000000',2,'1981-01-04','13387676765','12th Floor, Guanzhuang Xinyue Community, Chaoyang District, Beijing',3,1,'2015-05-06 10:52:07',NULL,NULL);
INSERT INTO `smbms_user` VALUES (11,'sunxing','Sun Xing','0000000',2,'1978-03-12','13367890900','No.10 Jianguomen South Street, Chaoyang District, Beijing',3,1,'2016-11-09 16:51:17',NULL,NULL);
INSERT INTO `smbms_user` VALUES (12,'zhangchen','Zhang Chen','0000000',1,'1986-03-28','18098765434','Building 13, North Berlin Philharmonic Phase III, Guanzhuang Road Crossing, Chaoyang District',3,1,'2016-08-09 05:52:37',1,'2016-04-14 14:15:36');
INSERT INTO `smbms_user` VALUES (13,'dengchao','Deng Chao','0000000',2,'1981-11-04','13689674534','Building 10, Beihang Family Hospital, Haidian District, Beijing',3,1,'2016-07-11 08:02:47',NULL,NULL);
INSERT INTO `smbms_user` VALUES (14,'yangguo','Yang Guo','0000000',2,'1980-01-01','13388886623','Building 20, Jasmine Garden, Beiyuan Homeland, Chaoyang District, Beijing',3,1,'2015-02-01 03:52:07',NULL,NULL);
INSERT INTO `smbms_user` VALUES (15,'test','test','111',1,'2019-04-16','123456789','Nanhua University',1,1,'2019-04-16 19:52:37',NULL,NULL);
