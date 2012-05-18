-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.46-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema jshopactive
--

CREATE DATABASE IF NOT EXISTS jshopactive;
USE jshopactive;

--
-- Definition of table `article_category_t`
--

DROP TABLE IF EXISTS `article_category_t`;
CREATE TABLE `article_category_t` (
  `ARTICLE_CATEGORY_TID` varchar(20) NOT NULL,
  `GRADE` varchar(1) NOT NULL,
  `META_KEYWORDS` varchar(255) DEFAULT NULL,
  `META_DES` varchar(255) DEFAULT NULL,
  `NAME` varchar(45) NOT NULL,
  `STATUS` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `PATH` varchar(2000) NOT NULL,
  `SORT` int(10) unsigned NOT NULL,
  `PARENT_ID` varchar(20) DEFAULT NULL,
  `SIGN` varchar(45) NOT NULL,
  `PARENT_NAME` varchar(45) DEFAULT NULL,
  `POSITION` varchar(1) NOT NULL,
  PRIMARY KEY (`ARTICLE_CATEGORY_TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article_category_t`
--

/*!40000 ALTER TABLE `article_category_t` DISABLE KEYS */;
INSERT INTO `article_category_t` (`ARTICLE_CATEGORY_TID`,`GRADE`,`META_KEYWORDS`,`META_DES`,`NAME`,`STATUS`,`CREATETIME`,`CREATORID`,`PATH`,`SORT`,`PARENT_ID`,`SIGN`,`PARENT_NAME`,`POSITION`) VALUES 
 ('20110928001','0','','3','常见问题','1','2011-09-28 15:00:30','20100721001','20110928001',1,NULL,'normalquestion','','0'),
 ('20110928002','1','','','安装说明','0','2011-09-28 15:01:17','20100721001','20110928001,20110928002',1,'20110928001','1','常见问题','0'),
 ('20110928003','1','1','1','常见问题211','1','2012-02-28 14:30:15','20100721001','20110928001,20110928003',1,'20110928001','3','常见问题','1'),
 ('20111025004','0','','','支付方式','1','2011-10-25 16:48:55','20100721001','20111025004',10,NULL,'payway','','0'),
 ('20111114005','0','11','11','售后服务','1','2011-11-14 13:53:19','20100721001','20111114005',1,NULL,'shfw','','1'),
 ('20120216006','2','1','1','123123','1','2012-02-16 22:08:51','20100721001','20110928001,20110928003,20120216006',1,'20110928003','ss','常见问题2','0'),
 ('20120216007','2','1','1','1212','1','2012-02-16 22:09:31','20100721001','20110928001,20110928003,20120216007',11,'20110928003','121','常见问题2','0'),
 ('20120216008','0','21','1','333','0','2012-02-16 22:14:11','20100721001','20120216008',3,NULL,'22','','0'),
 ('20120216009','0','123','123','123','1','2012-02-16 22:12:43','20100721001','20120216009',123,NULL,'123','','1'),
 ('201202170010','0','4','4','44444','0','2012-02-17 11:49:03','20100721001','201202170010',4,NULL,'4','','1'),
 ('201202170011','0','123','12','444222','0','2012-02-17 11:57:27','20100721001','201202170011',3213,NULL,'44111','','1'),
 ('201202280012','0','1','11','d1','1','2012-02-28 14:31:30','20100721001','201202280012',11,NULL,'1231','','0');
/*!40000 ALTER TABLE `article_category_t` ENABLE KEYS */;


--
-- Definition of table `article_t`
--

DROP TABLE IF EXISTS `article_t`;
CREATE TABLE `article_t` (
  `ARTICLEID` varchar(20) NOT NULL,
  `ARTICLE_CATEGORY_TID` varchar(20) NOT NULL,
  `TITLE` varchar(100) NOT NULL,
  `META_KEYWORDS` varchar(225) DEFAULT NULL,
  `META_DES` varchar(225) DEFAULT NULL,
  `CONTENTVALUE` longtext NOT NULL,
  `STATUS` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `AUTHOR` varchar(45) NOT NULL,
  `ISPUBLICATION` varchar(1) NOT NULL,
  `ISRECOMMEND` varchar(1) NOT NULL,
  `ISTOP` varchar(1) NOT NULL,
  `READCOUNT` int(10) unsigned DEFAULT NULL,
  `HTML_PATH` varchar(225) DEFAULT NULL,
  `PAGE_COUNT` int(10) unsigned DEFAULT NULL,
  `ARTICLE_CATEGORY_NAME` varchar(45) NOT NULL,
  `POSITION` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`ARTICLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `article_t`
--

/*!40000 ALTER TABLE `article_t` DISABLE KEYS */;
INSERT INTO `article_t` (`ARTICLEID`,`ARTICLE_CATEGORY_TID`,`TITLE`,`META_KEYWORDS`,`META_DES`,`CONTENTVALUE`,`STATUS`,`CREATETIME`,`CREATORID`,`AUTHOR`,`ISPUBLICATION`,`ISRECOMMEND`,`ISTOP`,`READCOUNT`,`HTML_PATH`,`PAGE_COUNT`,`ARTICLE_CATEGORY_NAME`,`POSITION`) VALUES 
 ('201110260027','0','测试文章','测试文章','测试文章','测试文章<br />','1','2011-10-26 15:22:41','20100721001','陈达','1','1','1',0,'html/default/article/201110260027.html',1,'顶级分类',NULL),
 ('201110260028','0','测试文章','测试文章','测试文章','测试文章<br />','1','2011-10-26 15:28:30','20100721001','陈达','1','1','1',0,'html/default/article/201110260028.html',1,'顶级分类',NULL),
 ('201110260029','0','测试文章','测试文章','测试文章','测试文章<br />','1','2011-10-26 15:34:02','20100721001','陈达','1','1','1',0,'html/default/article/201110260029.html',1,'顶级分类',NULL),
 ('201110260030','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 15:36:31','20100721001','陈达','1','1','1',0,'html/default/article/201110260030.html',1,'顶级分类',NULL),
 ('201110260031','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 15:38:04','20100721001','陈达','1','1','1',0,'html/default/article/201110260031.html',1,'顶级分类',NULL),
 ('201110260032','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 15:39:04','20100721001','陈达','1','1','1',0,'html/default/article/201110260032.html',1,'顶级分类',NULL),
 ('201110260033','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 15:39:20','20100721001','陈达','1','1','1',0,'html/default/article/201110260033.html',1,'顶级分类',NULL),
 ('201110260034','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 15:40:40','20100721001','陈达','1','1','1',0,'html/default/article/201110260034.html',1,'顶级分类',NULL),
 ('201110260035','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:13:55','20100721001','陈达','1','1','1',0,'html/default/article/201110260035.html',1,'顶级分类',NULL),
 ('201110260036','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:18:06','20100721001','陈达','1','1','1',0,'html/default/article/201110260036.html',1,'顶级分类',NULL),
 ('201110260037','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:27:37','20100721001','陈达','1','1','1',0,'html/default/article/201110260037.html',1,'顶级分类',NULL),
 ('201110260038','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:29:13','20100721001','陈达','1','1','1',0,'html/default/article/201110260038.html',1,'顶级分类',NULL),
 ('201110260039','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:31:15','20100721001','陈达','1','1','1',0,'html/default/article/201110260039.html',1,'顶级分类',NULL),
 ('201110260040','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:32:46','20100721001','陈达','1','1','1',0,'html/default/article/201110260040.html',1,'顶级分类',NULL),
 ('201110260041','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:38:33','20100721001','陈达','1','1','1',0,'html/default/article/201110260041.html',1,'顶级分类',NULL),
 ('201110260042','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:46:00','20100721001','陈达','1','1','1',0,'html/default/article/201110260042.html',1,'顶级分类',NULL),
 ('201110260043','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 16:49:37','20100721001','陈达','1','1','1',0,'html/default/article/201110260043.html',1,'顶级分类',NULL),
 ('201110260044','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 17:04:04','20100721001','陈达','1','1','1',0,'html/default/article/201110260044.html',1,'顶级分类',NULL),
 ('201110260045','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 17:04:54','20100721001','陈达','1','1','1',0,'html/default/article/201110260045.html',1,'顶级分类',NULL),
 ('201110260046','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-10-26 17:06:00','20100721001','陈达','1','1','1',0,'html/default/article/201110260046.html',1,'顶级分类',NULL),
 ('201110260047','0','测试文章2','createhtml','createhtml','createhtmlcreatehtmlcreatehtmlcreatehtml<br />','1','2011-11-14 21:00:48','20100721001','陈达','1','1','1',NULL,'html/default/article/201110260047.html',1,'顶级分类',NULL),
 ('201110260048','0','新的测试系统','1','1','<p>1fileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileN</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>&nbsp;</p>\n<p>amefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileNamefileName</p>','1','2011-10-26 17:11:51','20100721001','陈达','1','1','1',0,'html/default/article/201110260048.html',1,'顶级分类',NULL),
 ('201111140050','20111114005','售后1','1','1','11<br />','1','2011-11-14 13:58:11','20100721001','售后','1','1','1',0,'html/default/article/201111140050.html',1,'售后服务',NULL),
 ('201111140051','20111114005','1','1','1','1<br />','1','2011-11-14 13:59:46','20100721001','1','1','1','1',0,'html/default/article/201111140051.html',1,'售后服务',NULL),
 ('201111140057','20111114005','2','2','2','2<br />','1','2011-11-14 21:23:06','20100721001','2','1','1','1',NULL,'html/default/article/201111140057.html',1,'售后服务','1'),
 ('201202070058','20110928003','111','1','1','12<br />','0','2012-02-07 09:43:51','20100721001','11','0','0','0',0,NULL,1,'常见问题2','0'),
 ('201202280059','0','11','1','1','1<br />','1','2012-02-28 15:05:46','20100721001','121','1','0','0',0,'html/default/article/201202280059.html',1,'顶级分类',NULL),
 ('201202280060','0','11','1','1','1<br />','1','2012-02-28 15:05:53','20100721001','121','1','0','0',0,'html/default/article/201202280060.html',1,'顶级分类',NULL),
 ('201202280065','0','11','1','1','1<br />','1','2012-02-28 15:11:10','20100721001','121','1','0','0',0,'html/default/article/201202280065.html',1,'顶级分类',NULL),
 ('201202280066','0','11','1','1','1<br />','1','2012-02-28 15:11:46','20100721001','121','1','0','0',0,'html/default/article/201202280066.html',1,'顶级分类',NULL),
 ('201202280067','0','1','1','1','1<br />','1','2012-02-28 15:12:31','20100721001','12','1','1','0',0,'html/default/article/201202280067.html',1,'顶级分类',NULL),
 ('201202280068','201202280012','1','1','1','1<br />','1','2012-02-28 15:18:50','20100721001','1','1','0','1',NULL,'html/default/article/201202280068.html',1,'d1','0');
/*!40000 ALTER TABLE `article_t` ENABLE KEYS */;


--
-- Definition of table `authority_t`
--

DROP TABLE IF EXISTS `authority_t`;
CREATE TABLE `authority_t` (
  `AUTID` varchar(20) NOT NULL,
  `CHPAGENAME` varchar(45) NOT NULL,
  `ENPAGENAME` varchar(100) NOT NULL,
  `OPERATE` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `ROLEID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`AUTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `authority_t`
--

/*!40000 ALTER TABLE `authority_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority_t` ENABLE KEYS */;


--
-- Definition of table `brand_t`
--

DROP TABLE IF EXISTS `brand_t`;
CREATE TABLE `brand_t` (
  `BRANDID` varchar(20) NOT NULL,
  `BRANDNAME` varchar(50) NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `INTRO` text,
  `LOGO_PATH` varchar(255) DEFAULT NULL,
  `SORT` int(11) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BRANDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brand_t`
--

/*!40000 ALTER TABLE `brand_t` DISABLE KEYS */;
INSERT INTO `brand_t` (`BRANDID`,`BRANDNAME`,`CREATORID`,`USERNAME`,`CREATETIME`,`INTRO`,`LOGO_PATH`,`SORT`,`URL`) VALUES 
 ('20110318001','DQ','20100721001','sasasa','2011-03-18 21:21:24',NULL,NULL,NULL,NULL),
 ('201104060010','月湾湾','20100721001','sasasa','2011-04-06 17:56:02',NULL,NULL,NULL,NULL),
 ('201104060011','十月初五','20100721001','sasasa','2011-04-06 17:56:20',NULL,NULL,NULL,NULL),
 ('201104060012','麻仔','20100721001','sasasa','2011-04-06 17:59:07',NULL,NULL,NULL,NULL),
 ('201104060013','沈师傅','20100721001','sasasa','2011-04-06 17:59:16',NULL,NULL,NULL,NULL),
 ('201104060014','品品','20100721001','sasasa','2011-04-06 17:59:26',NULL,NULL,NULL,NULL),
 ('201104060015','拉友','20100721001','sasasa','2011-04-06 17:59:35',NULL,NULL,NULL,NULL),
 ('201104060016','栗源','20100721001','sasasa','2011-04-06 17:59:43',NULL,NULL,NULL,NULL),
 ('201104060017','日本昆布','20100721001','sasasa','2011-04-06 17:59:53',NULL,NULL,NULL,NULL),
 ('201104060018','有友','20100721001','sasasa','2011-04-06 18:00:03',NULL,NULL,NULL,NULL),
 ('201104060019','金大洲','20100721001','sasasa','2011-04-06 18:00:12',NULL,NULL,NULL,NULL),
 ('201104060020','乐滋','20100721001','sasasa','2011-04-06 18:00:30',NULL,NULL,NULL,NULL),
 ('201104060021','山楂','20100721001','sasasa','2011-04-06 18:00:45',NULL,NULL,NULL,NULL),
 ('201104060022','佳荣小生','20100721001','sasasa','2011-04-06 18:05:22',NULL,NULL,NULL,NULL),
 ('201104060023','苏伯汤','20100721001','sasasa','2011-04-06 18:07:25',NULL,NULL,NULL,NULL),
 ('201104060024','艾尔发','20100721001','sasasa','2011-04-06 18:07:36',NULL,NULL,NULL,NULL),
 ('201104060025','鱿鱼','20100721001','sasasa','2011-04-06 18:09:14',NULL,NULL,NULL,NULL),
 ('201104060026','山椒','20100721001','sasasa','2011-04-06 18:09:31',NULL,NULL,NULL,NULL),
 ('201104060027','陈大妈','20100721001','sasasa','2011-04-06 18:09:38',NULL,NULL,NULL,NULL),
 ('201104060028','日本芝士','20100721001','sasasa','2011-04-06 18:09:58',NULL,NULL,NULL,NULL),
 ('201104060029','牛浪汉','20100721001','sasasa','2011-04-06 18:10:05',NULL,NULL,NULL,NULL),
 ('20110406003','毛哥','20100721001','sasasa','2011-04-06 17:37:11',NULL,NULL,NULL,NULL),
 ('201104060030','魔力纤','20100721001','sasasa','2011-04-06 18:10:18',NULL,NULL,NULL,NULL),
 ('201104060031','金口开','20100721001','sasasa','2011-04-06 18:10:27',NULL,NULL,NULL,NULL),
 ('201104060032','7D','20100721001','sasasa','2011-04-06 18:12:29',NULL,NULL,NULL,NULL),
 ('201104060033','牛肉粒','20100721001','sasasa','2011-04-06 18:19:39',NULL,NULL,NULL,NULL),
 ('201104060034','温州','20100721001','sasasa','2011-04-06 18:19:45',NULL,NULL,NULL,NULL),
 ('201104060035','蜜汁肉脯','20100721001','sasasa','2011-04-06 18:19:57',NULL,NULL,NULL,NULL),
 ('201104060037','CEBU','20100721001','sasasa','2011-04-06 18:21:40',NULL,NULL,NULL,NULL),
 ('201104060038','cashews','20100721001','sasasa','2011-04-06 18:21:57',NULL,NULL,NULL,NULL),
 ('201104060039','阿胶','20100721001','sasasa','2011-04-06 18:22:07',NULL,NULL,NULL,NULL),
 ('20110406004','黄飞红','20100721001','sasasa','2011-04-06 17:51:39',NULL,NULL,NULL,NULL),
 ('201104060040','黄金薯','20100721001','sasasa','2011-04-06 18:22:20',NULL,NULL,NULL,NULL),
 ('201104060041','卜珂','20100721001','sasasa','2011-04-06 18:25:13',NULL,NULL,NULL,NULL),
 ('201104060042','红薯','20100721001','sasasa','2011-04-06 18:25:53',NULL,NULL,NULL,NULL),
 ('201104060043','牛轧糖','20100721001','sasasa','2011-04-06 18:27:26',NULL,NULL,NULL,NULL),
 ('201104060044','维维','20100721001','sasasa','2011-04-06 18:28:05',NULL,NULL,NULL,NULL),
 ('201104060045','星球杯','20100721001','sasasa','2011-04-06 18:30:57',NULL,NULL,NULL,NULL),
 ('201104060046','果子町','20100721001','sasasa','2011-04-06 18:31:53',NULL,NULL,NULL,NULL),
 ('201104060047','和风','20100721001','sasasa','2011-04-06 18:31:59',NULL,NULL,NULL,NULL),
 ('201104060048','旧街场','20100721001','sasasa','2011-04-06 18:32:22',NULL,NULL,NULL,NULL),
 ('20110406005','活力颂','20100721001','sasasa','2011-04-06 17:52:03',NULL,NULL,NULL,NULL),
 ('201104060050','明仁牌','20100721001','sasasa','2011-04-06 18:33:13',NULL,NULL,NULL,NULL),
 ('201104060051','北田','20100721001','sasasa','2011-04-06 18:34:59',NULL,NULL,NULL,NULL),
 ('201104060052','3点1刻','20100721001','sasasa','2011-04-06 18:35:06',NULL,NULL,NULL,NULL),
 ('201104060054','亚细亚田园','20100721001','sasasa','2011-04-06 18:35:33',NULL,NULL,NULL,NULL),
 ('201104060055','如香惠香','20100721001','sasasa','2011-04-06 18:35:57',NULL,NULL,NULL,NULL),
 ('201104060056','AK德诚','20100721001','sasasa','2011-04-06 18:36:03',NULL,NULL,NULL,NULL),
 ('201104060057','金装威拿','20100721001','sasasa','2011-04-06 18:37:24',NULL,NULL,NULL,NULL),
 ('201104060058','宏亚77','20100721001','sasasa','2011-04-06 18:37:32',NULL,NULL,NULL,NULL),
 ('201104060059','张君雅小妹妹','20100721001','sasasa','2011-04-06 18:37:41',NULL,NULL,NULL,NULL),
 ('20110406006','AJI','20100721001','sasasa','2011-04-06 17:53:01',NULL,NULL,NULL,NULL),
 ('201104060060','素手浣花','20100721001','sasasa','2011-04-06 18:37:48',NULL,NULL,NULL,NULL),
 ('201104060061','新亚','20100721001','sasasa','2011-04-06 18:37:56',NULL,NULL,NULL,NULL),
 ('201104060062','雪之恋','20100721001','sasasa','2011-04-06 18:38:16',NULL,NULL,NULL,NULL),
 ('201104060063','BANH TO','20100721001','sasasa','2011-04-06 18:39:22',NULL,NULL,NULL,NULL),
 ('201104060064','富达','20100721001','sasasa','2011-04-06 18:39:29',NULL,NULL,NULL,NULL),
 ('201104060065','咪咪','20100721001','sasasa','2011-04-06 18:39:40',NULL,NULL,NULL,NULL),
 ('201104060066','其他品牌','20100721001','sasasa','2011-04-06 18:39:46',NULL,NULL,NULL,NULL),
 ('201104060067','御之味','20100721001','sasasa','2011-04-06 18:39:52',NULL,NULL,NULL,NULL),
 ('201104060068','黄龙','20100721001','sasasa','2011-04-06 18:39:59',NULL,NULL,NULL,NULL),
 ('201104060069','悠哈','20100721001','sasasa','2011-04-06 18:41:43',NULL,NULL,NULL,NULL),
 ('20110406007','上海锅巴','20100721001','sasasa','2011-04-06 17:53:43',NULL,NULL,NULL,NULL),
 ('201104060070','G7','20100721001','sasasa','2011-04-06 18:41:53',NULL,NULL,NULL,NULL),
 ('201104060071','朋多','20100721001','sasasa','2011-04-06 18:42:02',NULL,NULL,NULL,NULL),
 ('201104060072','大哥','20100721001','sasasa','2011-04-06 18:42:21',NULL,NULL,NULL,NULL),
 ('201104060073','sollite','20100721001','sasasa','2011-04-06 18:42:38',NULL,NULL,NULL,NULL),
 ('201104060074','铜锣烧','20100721001','sasasa','2011-04-06 18:43:01',NULL,NULL,NULL,NULL),
 ('201104060075','优之良品','20100721001','sasasa','2011-04-06 18:45:21',NULL,NULL,NULL,NULL),
 ('201104060076','丹夫','20100721001','sasasa','2011-04-06 18:47:42',NULL,NULL,NULL,NULL),
 ('201104060077','德菲斯','20100721001','sasasa','2011-04-06 18:47:47',NULL,NULL,NULL,NULL),
 ('201104060078','德芙','20100721001','sasasa','2011-04-06 18:47:53',NULL,NULL,NULL,NULL),
 ('201104060079','雀巢','20100721001','sasasa','2011-04-06 18:48:05',NULL,NULL,NULL,NULL),
 ('20110406008','车里哥夫','20100721001','sasasa','2011-04-06 17:55:20',NULL,NULL,NULL,NULL),
 ('201104060080','好时','20100721001','sasasa','2011-04-06 18:48:10',NULL,NULL,NULL,NULL),
 ('201104060081','嘉云糖','20100721001','sasasa','2011-04-06 18:48:15',NULL,NULL,NULL,NULL),
 ('201104060082','lotus合情','20100721001','sasasa','2011-04-06 18:48:19',NULL,NULL,NULL,NULL),
 ('201104060083','Ocean Spray 优鲜沛','20100721001','sasasa','2011-04-06 18:48:25',NULL,NULL,NULL,NULL),
 ('201104060084','W.L.','20100721001','sasasa','2011-04-06 18:50:24',NULL,NULL,NULL,NULL),
 ('201104060085','德菲丝','20100721001','sasasa','2011-04-06 18:50:34',NULL,NULL,NULL,NULL),
 ('201104060086','德菲斯','20100721001','sasasa','2011-04-06 18:50:45',NULL,NULL,NULL,NULL),
 ('201104060087','费列罗','20100721001','sasasa','2011-04-06 18:51:02',NULL,NULL,NULL,NULL),
 ('201104060088','汉斯','20100721001','sasasa','2011-04-06 18:51:21',NULL,NULL,NULL,NULL),
 ('201104060089','Davidoff/大卫杜夫','20100721001','sasasa','2011-04-06 18:51:26',NULL,NULL,NULL,NULL),
 ('20110406009','TIPO','20100721001','sasasa','2011-04-06 17:55:49',NULL,NULL,NULL,NULL),
 ('201104130090','苏格格','20100721001','sasasa','2011-04-13 21:56:26',NULL,NULL,NULL,NULL),
 ('2011112500105','华硕','20100721001','sasasa','2011-11-25 09:04:01','','#',1,''),
 ('2011112500106','苹果','20100721001','sasasa','2011-11-25 09:04:14','','#',2,''),
 ('2011112500107','联想','20100721001','sasasa','2011-11-25 09:04:29','','#',3,''),
 ('2011112500108','惠普','20100721001','sasasa','2011-11-25 09:04:43','','#',4,''),
 ('2011112500109','三星','20100721001','sasasa','2011-11-25 09:05:03','','#',5,''),
 ('2011112500110','东芝','20100721001','sasasa','2011-11-25 09:05:15','','#',6,''),
 ('2011112500111','戴尔','20100721001','sasasa','2011-11-25 09:07:06','','#',7,''),
 ('2011112500112','索尼','20100721001','sasasa','2011-11-25 09:07:16','','#',8,''),
 ('2011112500113','诺基亚','20100721001','sasasa','2011-11-25 10:56:59','','#',4,''),
 ('2011112500115','摩托罗拉','20100721001','sasasa','2011-11-25 10:57:28','','#',5,''),
 ('2011112500116','苹果','20100721001','sasasa','2011-11-25 10:58:14','','#',1,''),
 ('2011112500118','天语','20100721001','sasasa','2011-11-25 10:58:43','','#',8,'');
/*!40000 ALTER TABLE `brand_t` ENABLE KEYS */;


--
-- Definition of table `cart_t`
--

DROP TABLE IF EXISTS `cart_t`;
CREATE TABLE `cart_t` (
  `CARTID` varchar(20) DEFAULT NULL,
  `ORDERID` varchar(20) DEFAULT NULL,
  `GOODSID` varchar(20) NOT NULL,
  `GOODSNAME` varchar(50) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `NEEDQUANTITY` int(10) unsigned NOT NULL,
  `PRICE` double(10,2) NOT NULL,
  `FAVORABLE` double(10,2) NOT NULL,
  `CHANGEPRICE` double(10,2) DEFAULT NULL,
  `POINTS` double(10,2) NOT NULL,
  `SUBTOTAL` double(10,2) NOT NULL,
  `ADDTIME` datetime NOT NULL,
  `QUANTITY` int(10) unsigned DEFAULT NULL,
  `PICTURE` varchar(250) NOT NULL,
  `USERSETNUM` varchar(20) NOT NULL,
  `WEIGHT` varchar(20) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `ID` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart_t`
--

/*!40000 ALTER TABLE `cart_t` DISABLE KEYS */;
INSERT INTO `cart_t` (`CARTID`,`ORDERID`,`GOODSID`,`GOODSNAME`,`USERID`,`USERNAME`,`NEEDQUANTITY`,`PRICE`,`FAVORABLE`,`CHANGEPRICE`,`POINTS`,`SUBTOTAL`,`ADDTIME`,`QUANTITY`,`PICTURE`,`USERSETNUM`,`WEIGHT`,`STATE`,`ID`) VALUES 
 ('201105180037','201105180023','201104090056','牛浪汉 泡椒牛肉 60g','20100721002','sasasa',1,9.50,6.50,NULL,6.50,6.50,'2011-05-18 23:21:38',1000,'2011041200152498957.jpg','00','60','3','20110518007'),
 ('201105180038','201105180024','201104080037','栗源优质燕山板栗 68g','20100721002','sasasa',1,10.00,6.50,NULL,6.50,6.50,'2011-05-18 23:24:10',1000,'2011041123182161164.jpg','00','68','3','20110518008'),
 ('201105180038','201105180024','201104090059','日本芝士鱼肠 17g','20100721002','sasasa',1,4.00,2.20,NULL,2.20,2.20,'2011-05-18 23:24:19',1000,'2011041200273136683.jpg','00','17','3','20110518009'),
 ('201105240050','201105240032','201104090062','鱿鱼足片250g/袋','20100721002','sasasa',1,25.00,0.10,NULL,19.48,0.10,'2011-05-24 14:11:24',1000,'2011041200380391162.jpg','00','250','3','201105240018'),
 ('201105240060','201105240033','201104090062','鱿鱼足片250g/袋','20100721002','sasasa',1,25.00,0.10,NULL,19.48,0.10,'2011-05-24 14:13:30',1000,'2011041200380391162.jpg','00','250','3','201105240019'),
 ('201105240059',NULL,'201104080044','佳荣小生芝士腰果 200g','20100721002','sasasa',4,25.00,25.00,NULL,25.00,25.00,'2011-05-24 15:15:29',1000,'2011041123510488837.jpg','00','200','2','201105240020'),
 ('201105240059',NULL,'201104090057','牛浪汉 烧烤牛肉 60g','20100721002','sasasa',30,9.50,6.50,NULL,6.50,19.50,'2011-05-24 15:30:47',1000,'2011041200211784664.jpg','00','60','2','201105240021'),
 ('201105240060','201105240033','201104090056','牛浪汉 泡椒牛肉 60g','20100721002','sasasa',1,9.50,0.10,NULL,6.50,0.10,'2011-05-24 15:47:28',1000,'2011041200152498957.jpg','00','60','3','201105240022'),
 (NULL,NULL,'201104090062','鱿鱼足片250g/袋','20100721002','sasasa',1,25.00,0.10,NULL,19.48,0.10,'2011-05-24 16:15:56',1000,'2011041200380391162.jpg','00','250','1','201105240023'),
 (NULL,NULL,'2011111800282','优鲜沛蔓越莓干（切片）200g/袋','20100721002','sasasa',1,27.00,18.20,NULL,1.00,18.20,'2011-12-05 13:10:05',1,'/Uploads/2011111923512342263.jpg','00','200','1','201112050024'),
 ('201201050061','201201050037','2011111800282','优鲜沛蔓越莓干（切片）200g/袋','201112130018','sdywcd',1,27.00,18.20,NULL,1.00,18.20,'2012-01-05 10:48:46',1,'/Uploads/2011111923512342263.jpg','00','200','3','201201050025'),
 ('201201050064',NULL,'2011112500320','韩国巧克力 三进X5巧克力棒 巧克力威化5层口味 36克','201112130018','sdywcd',120,4.50,3.30,NULL,3.00,3.30,'2012-01-05 15:54:11',1000,'/Uploads/2011112509492970299.jpg','123','41','1','201201050026'),
 ('201202210027',NULL,'2011111800282','优鲜沛蔓越莓干（切片）200g/袋','20100721001','sasasa',1,27.00,18.20,NULL,1.00,18.20,'2012-02-21 14:56:18',1,'/Uploads/2011111923512342263.jpg','00','200','1','201202210065');
/*!40000 ALTER TABLE `cart_t` ENABLE KEYS */;


--
-- Definition of table `coupon_t`
--

DROP TABLE IF EXISTS `coupon_t`;
CREATE TABLE `coupon_t` (
  `CID` varchar(20) NOT NULL,
  `CTITLE` varchar(225) NOT NULL,
  `CIMAGE` varchar(225) NOT NULL,
  `ENDTIME` datetime NOT NULL,
  `DETAILS` longtext NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `MODIFYTIME` datetime NOT NULL,
  `BEGINTIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `LAT` double NOT NULL,
  `LNG` double NOT NULL,
  `ZOOM` int(10) unsigned NOT NULL,
  `READCOUNT` int(10) unsigned NOT NULL,
  `STARSUM` int(10) unsigned NOT NULL,
  `STARUSERSUM` int(10) unsigned NOT NULL,
  `REPLYCOUNT` int(10) unsigned NOT NULL,
  `GOUSERSUM` int(10) unsigned NOT NULL,
  `COUPONTYPENAME` varchar(45) NOT NULL,
  `COUPONTYPEID` varchar(20) NOT NULL,
  PRIMARY KEY (`CID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coupon_t`
--

/*!40000 ALTER TABLE `coupon_t` DISABLE KEYS */;
INSERT INTO `coupon_t` (`CID`,`CTITLE`,`CIMAGE`,`ENDTIME`,`DETAILS`,`CREATETIME`,`MODIFYTIME`,`BEGINTIME`,`CREATORID`,`LAT`,`LNG`,`ZOOM`,`READCOUNT`,`STARSUM`,`STARUSERSUM`,`REPLYCOUNT`,`GOUSERSUM`,`COUPONTYPENAME`,`COUPONTYPEID`) VALUES 
 ('1','标题1','1','2011-05-18 14:27:23','12123123','2011-05-18 14:27:23','2011-05-18 14:27:23','2011-05-18 14:27:23','201122222',0,0,0,0,0,0,0,0,'',''),
 ('2','2','2','2011-05-18 14:27:23','1212','2011-05-18 14:27:23','2011-05-18 14:27:23','2011-05-18 14:27:23','1212',0,0,0,0,0,0,0,0,'','');
/*!40000 ALTER TABLE `coupon_t` ENABLE KEYS */;


--
-- Definition of table `deliver_address_t`
--

DROP TABLE IF EXISTS `deliver_address_t`;
CREATE TABLE `deliver_address_t` (
  `ADDRESSID` varchar(20) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PROVINCE` varchar(12) NOT NULL,
  `CITY` varchar(12) NOT NULL,
  `DISTRICT` varchar(12) NOT NULL,
  `STREET` varchar(100) NOT NULL,
  `POSTCODE` varchar(10) NOT NULL,
  `TELNO` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(20) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `COUNTRY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ADDRESSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deliver_address_t`
--

/*!40000 ALTER TABLE `deliver_address_t` DISABLE KEYS */;
INSERT INTO `deliver_address_t` (`ADDRESSID`,`USERID`,`USERNAME`,`PROVINCE`,`CITY`,`DISTRICT`,`STREET`,`POSTCODE`,`TELNO`,`MOBILE`,`EMAIL`,`CREATETIME`,`STATE`,`COUNTRY`) VALUES 
 ('201105180010','20110518002','孟成','上海市','上海市','闵行区','都市路元江路1800号9号302','','58999999999','13999999999','','2011-05-18 17:26:36','1','中国'),
 ('20110518005','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 14:27:02','1','中国'),
 ('201201050012','201112130018','陈达','上海市','上海市','浦东新区','金桥路3068号','','','13671892195','','2012-01-05 10:49:25','0','中国');
/*!40000 ALTER TABLE `deliver_address_t` ENABLE KEYS */;


--
-- Definition of table `expresstemplete_t`
--

DROP TABLE IF EXISTS `expresstemplete_t`;
CREATE TABLE `expresstemplete_t` (
  `EXPRESSTEMPLETEID` varchar(20) NOT NULL,
  `SEND_NAME` varchar(45) DEFAULT NULL,
  `SEND_COUNTRY` varchar(20) DEFAULT NULL,
  `SEND_PROVINCE` varchar(20) DEFAULT NULL,
  `SEND_CITY` varchar(20) DEFAULT NULL,
  `SEND_DISTRICT` varchar(20) DEFAULT NULL,
  `SEND_STREET` varchar(20) DEFAULT NULL,
  `SEND_TELNO` varchar(20) DEFAULT NULL,
  `SEND_MOBILE` varchar(20) DEFAULT NULL,
  `RECIPIENT_NAME` varchar(20) DEFAULT NULL,
  `RECIPIENT_COUNTRY` varchar(20) DEFAULT NULL,
  `RECIPIENT_PROVINCE` varchar(20) DEFAULT NULL,
  `RECIPIENT_CITY` varchar(20) DEFAULT NULL,
  `RECIPIENT_DISTRICT` varchar(20) DEFAULT NULL,
  `RECIPIENT_STREET` varchar(20) DEFAULT NULL,
  `RECIPIENT_TELNO` varchar(20) DEFAULT NULL,
  `RECIPIENT_MOBILE` varchar(20) DEFAULT NULL,
  `RECIPIENT_POSTCODE` varchar(20) DEFAULT NULL,
  `YEAR` varchar(20) DEFAULT NULL,
  `MONTH` varchar(20) DEFAULT NULL,
  `DAY` varchar(20) DEFAULT NULL,
  `ORDERID` varchar(20) DEFAULT NULL,
  `NOTES` varchar(20) DEFAULT NULL,
  `SEND_TIME` varchar(20) DEFAULT NULL,
  `RIGHT_TAG` varchar(20) DEFAULT NULL,
  `LOGISTICSID` varchar(20) DEFAULT NULL,
  `STATE` varchar(1) DEFAULT NULL,
  `EXPRESS_CSS` varchar(500) DEFAULT NULL,
  `EXPRESS_IMG` varchar(255) DEFAULT NULL,
  `KINDEDITOR_CODE` text,
  `SEND_CONTACTOR` varchar(20) DEFAULT NULL,
  `RECIPIENT_CONTACTOR` varchar(20) DEFAULT NULL,
  `HOUR` varchar(20) DEFAULT NULL,
  `MINUTES` varchar(20) DEFAULT NULL,
  `QUANTITY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`EXPRESSTEMPLETEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `expresstemplete_t`
--

/*!40000 ALTER TABLE `expresstemplete_t` DISABLE KEYS */;
INSERT INTO `expresstemplete_t` (`EXPRESSTEMPLETEID`,`SEND_NAME`,`SEND_COUNTRY`,`SEND_PROVINCE`,`SEND_CITY`,`SEND_DISTRICT`,`SEND_STREET`,`SEND_TELNO`,`SEND_MOBILE`,`RECIPIENT_NAME`,`RECIPIENT_COUNTRY`,`RECIPIENT_PROVINCE`,`RECIPIENT_CITY`,`RECIPIENT_DISTRICT`,`RECIPIENT_STREET`,`RECIPIENT_TELNO`,`RECIPIENT_MOBILE`,`RECIPIENT_POSTCODE`,`YEAR`,`MONTH`,`DAY`,`ORDERID`,`NOTES`,`SEND_TIME`,`RIGHT_TAG`,`LOGISTICSID`,`STATE`,`EXPRESS_CSS`,`EXPRESS_IMG`,`KINDEDITOR_CODE`,`SEND_CONTACTOR`,`RECIPIENT_CONTACTOR`,`HOUR`,`MINUTES`,`QUANTITY`) VALUES 
 ('201105060017','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'<img src=\"/jshop/Uploads/20110506213643_246.png\" alt=\"\" border=\"0\" /><br />\n	   		\n	   <div id=\"sendname\" style=\"position:absolute;width:100px;height:50px;border:2px solid;text-align:left;line-height:20px;font-size:14px;left:98px;top:137px;opacity:1;\">${sendName}</div>\n	   		\n	   <div id=\"righttag\" style=\"position:absolute;width:100px;height:50px;border:2px solid;text-align:left;line-height:20px;font-size:14px;left:561px;top:117px;opacity:1;\">√(勾)</div>\n	   		\n	   ','sendcontactor','recipientcontactor','hour','minutes','quantity'),
 ('201107270018','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'\n	   		\n	   <div id=\"sendname\" style=\"position: absolute; width: 100px; height: 50px; border: 2px solid; text-align: left; line-height: 20px; font-size: 14px; left: 71px; top: 245px; opacity: 1;\">寄件方-姓名(公司)</div>','sendcontactor','recipientcontactor','hour','minutes','quantity'),
 ('201108160019','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'\n	   		\n	   ','sendcontactor','recipientcontactor','hour','minutes','quantity'),
 ('201111110020','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'\n	   		\n	   ','sendcontactor','recipientcontactor','hour','minutes','quantity'),
 ('201111110021','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'\n	   		\n	   <div id=\"sendname\" style=\"position: absolute; width: 100px; height: 50px; border: 2px solid; text-align: left; line-height: 20px; font-size: 14px; left: 159px; top: 337px; opacity: 1;\">寄件方-姓名(公司)</div>','sendcontactor','recipientcontactor','hour','minutes','quantity'),
 ('201111230022','sendname','sendcountry','sendprovince','sendcity','senddistrict','sendstreet','sendtelno','sendmobile','recipientname','recipientcountry','recipientprovince','recipientcity','recipientdistrict','recipientstreet','recipienttelno','recipientmobile','recipientpostcode','year','month','day','orderid','notes','sendtime','righttag','20110404004','1',NULL,NULL,'\n	   		\n	   ','sendcontactor','recipientcontactor','hour','minutes','quantity');
/*!40000 ALTER TABLE `expresstemplete_t` ENABLE KEYS */;


--
-- Definition of table `favorite_t`
--

DROP TABLE IF EXISTS `favorite_t`;
CREATE TABLE `favorite_t` (
  `FAVORITEID` varchar(20) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `GOODSID` varchar(20) DEFAULT NULL,
  `TAG` varchar(20) DEFAULT NULL,
  `DESCRIPT` varchar(50) DEFAULT NULL,
  `USERID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `ADDTIME` datetime NOT NULL,
  `READCOUNT` int(10) unsigned DEFAULT NULL,
  `MEMBERPRICE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`FAVORITEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `favorite_t`
--

/*!40000 ALTER TABLE `favorite_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite_t` ENABLE KEYS */;


--
-- Definition of table `global_param_m`
--

DROP TABLE IF EXISTS `global_param_m`;
CREATE TABLE `global_param_m` (
  `GKEY` varchar(45) NOT NULL,
  `GVALUE` varchar(45) NOT NULL,
  PRIMARY KEY (`GKEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `global_param_m`
--

/*!40000 ALTER TABLE `global_param_m` DISABLE KEYS */;
INSERT INTO `global_param_m` (`GKEY`,`GVALUE`) VALUES 
 ('canuserregistermoreshopinfo','0'),
 ('integralconversionratio','1'),
 ('isautolockaccount','0'),
 ('issendactivatemail','0'),
 ('isusercanregister','1'),
 ('maxloginnum','1'),
 ('stockwarning','5'),
 ('unlocktime','1');
/*!40000 ALTER TABLE `global_param_m` ENABLE KEYS */;


--
-- Definition of table `goods_attribute_t`
--

DROP TABLE IF EXISTS `goods_attribute_t`;
CREATE TABLE `goods_attribute_t` (
  `GOODSATTRIBUTEID` varchar(20) NOT NULL,
  `GOODSATTRIBUTENAME` varchar(45) NOT NULL,
  `GOODS_TYPE_ID` varchar(20) NOT NULL,
  `GOODS_TYPE_NAME` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `ATTRIBUTE_TYPE` varchar(1) NOT NULL,
  `ATTRIBUTELIST` text NOT NULL,
  `SORT` varchar(10) NOT NULL,
  `ATTRIBUTE_INDEX` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`GOODSATTRIBUTEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_attribute_t`
--

/*!40000 ALTER TABLE `goods_attribute_t` DISABLE KEYS */;
INSERT INTO `goods_attribute_t` (`GOODSATTRIBUTEID`,`GOODSATTRIBUTENAME`,`GOODS_TYPE_ID`,`GOODS_TYPE_NAME`,`CREATETIME`,`STATE`,`CREATORID`,`ATTRIBUTE_TYPE`,`ATTRIBUTELIST`,`SORT`,`ATTRIBUTE_INDEX`) VALUES 
 ('201108090079','包装','20110809007','食品','2012-02-28 10:28:09','1','20100721001','0','大包,中包,小包,超大包','1','1');
/*!40000 ALTER TABLE `goods_attribute_t` ENABLE KEYS */;


--
-- Definition of table `goods_category_t`
--

DROP TABLE IF EXISTS `goods_category_t`;
CREATE TABLE `goods_category_t` (
  `GOODS_CATEGORY_TID` varchar(20) NOT NULL,
  `GRADE` varchar(1) NOT NULL,
  `META_KEYWORDS` varchar(255) DEFAULT NULL,
  `META_DES` varchar(255) DEFAULT NULL,
  `NAME` varchar(45) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `PATH` varchar(2000) NOT NULL,
  `SORT` int(10) unsigned DEFAULT NULL,
  `SIGN` varchar(45) NOT NULL,
  `GOODS_TYPE_ID` varchar(45) NOT NULL,
  `PARENT_ID` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `PARENT_NAME` varchar(45) DEFAULT NULL,
  `HTMLPATH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`GOODS_CATEGORY_TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_category_t`
--

/*!40000 ALTER TABLE `goods_category_t` DISABLE KEYS */;
INSERT INTO `goods_category_t` (`GOODS_CATEGORY_TID`,`GRADE`,`META_KEYWORDS`,`META_DES`,`NAME`,`STATE`,`PATH`,`SORT`,`SIGN`,`GOODS_TYPE_ID`,`PARENT_ID`,`CREATETIME`,`CREATORID`,`PARENT_NAME`,`HTMLPATH`) VALUES 
 ('201108160052','0','粮油调味','粮油调味','粮油调味','1','201108160052',1,'lytw','20110809007',NULL,'2012-03-19 00:00:00','20100721001','','html/default/shop/lytw_1.html'),
 ('201108160058','0','2','2','进口美食','1','201108160058',2,'jkms','20110809007',NULL,'2011-11-18 11:23:19','20100721001','','html/default/shop/jkms_1.html'),
 ('201108160059','0','3','3','冲调饮品','1','201108160059',3,'ctyp','20110809007',NULL,'2011-11-17 10:14:20','20100721001','','html/default/shop/ctyp_1.html'),
 ('201108160060','0','1','1','肉脯熟食','1','201108160060',1,'rpss','20110809007',NULL,'2011-11-17 10:14:28','20100721001','','html/default/shop/rpss_1.html'),
 ('201108160061','0','5','5','果干蜜饯','1','201108160061',5,'ggrp','20110809007',NULL,'2011-11-17 10:14:40','20100721001','','html/default/shop/ggrp_1.html'),
 ('201108160062','0','6','6','饼干糕点','1','201108160062',6,'bggd','20110809007',NULL,'2011-11-17 10:14:44','20100721001','',''),
 ('201108160063','0','7','7','糖果布丁','1','201108160063',7,'tgbd','20110809007',NULL,'2011-11-17 10:15:35','20100721001','',''),
 ('201108160064','1','8','8','调味酱','1','201108160052,201108160064',8,'twj','20110809007','201108160052','2011-11-17 10:15:41','20100721001','粮油调味','html/default/shop/twj_1.html'),
 ('201108160065','1','11','11','腌料','1','201108160052,201108160065',11,'yl','20110809007','201108160052','2011-11-17 10:15:45','20100721001','粮油调味',''),
 ('201108160066','1','12','12','日韩','1','201108160058,201108160066',11,'rh','20110809007','201108160058','2011-11-17 10:15:50','20100721001','进口美食','html/default/shop/rh_1.html'),
 ('201108160067','1','11','11','欧美','1','201108160058,201108160067',11,'om','20110809007','201108160058','2011-11-17 10:15:57','20100721001','进口美食',''),
 ('201108160068','1','11','11','东南亚','1','201108160058,201108160068',11,'dny','20110809007','201108160058','2011-11-17 10:16:02','20100721001','进口美食',''),
 ('201108160069','1','11','11','港澳台','1','201108160058,201108160069',11,'gat','20110809007','201108160058','2011-11-17 10:16:05','20100721001','进口美食','html/default/shop/gat_1.html'),
 ('201108160070','1','11','11','功能保健茶','1','201108160059,201108160070',11,'gnbjc','20110809007','201108160059','2011-11-17 10:16:08','20100721001','冲调饮品','html/default/shop/gnbjc_1.html'),
 ('201108160071','1','11','11','果味茶','1','201108160059,201108160071',11,'gwc','20110809007','201108160059','2011-11-17 10:16:11','20100721001','冲调饮品',''),
 ('201108160072','1','11','11','花草茶','1','201108160059,201108160072',11,'hcc','20110809007','201108160059','2011-11-17 10:20:16','20100721001','冲调饮品',''),
 ('201108160073','1','11','11','奶茶','1','201108160059,201108160073',11,'nc','20110809007','201108160059','2011-11-17 10:20:20','20100721001','冲调饮品',''),
 ('201108160074','1','11','11','咖啡','1','201108160059,201108160074',11,'kf','20110809007','201108160059','2011-11-17 10:20:25','20100721001','冲调饮品',''),
 ('201108160075','1','11','11','卤制品','1','201108160060,201108160075',11,'lzp','20110809007','201108160060','2011-11-17 10:20:29','20100721001','肉脯熟食','html/default/shop/lzp_1.html'),
 ('201108160076','1','11','11','海产即食','1','201108160060,201108160076',11,'hcjs','20110809007','201108160060','2011-11-17 10:20:32','20100721001','肉脯熟食',''),
 ('201108160077','1','11','11','肉脯','1','201108160060,201108160077',11,'rp','20110809007','201108160060','2011-11-17 10:20:36','20100721001','肉脯熟食',''),
 ('201108160078','1','11','11','豆制品','1','201108160061,201108160078',11,'dzp','20110809007','201108160061','2011-11-17 10:20:40','20100721001','果干蜜饯',''),
 ('201108160079','1','11','11','果脯','1','201108160061,201108160079',11,'gp','20110809007','201108160061','2011-11-17 10:20:46','20100721001','果干蜜饯',''),
 ('201108160080','1','1','1','坚果炒货','1','201108160061,201108160080',11,'jgch','20110809007','201108160061','2011-11-17 09:28:36','20100721001','果干蜜饯','html/default/shop/jgch_1.html'),
 ('201108160081','1','11','11','蜜饯','1','201108160061,201108160081',11,'mj','20110809007','201108160061','2011-11-17 10:21:02','20100721001','果干蜜饯',''),
 ('201108160082','1','11','11','蔬果干','1','201108160061,201108160082',11,'scg','20110809007','201108160061','2011-11-17 10:21:07','20100721001','果干蜜饯','html/default/shop/scg_1.html'),
 ('201108160083','1','11','11','点心面','1','201108160062,201108160083',11,'dxm','20110809007','201108160062','2011-11-17 10:21:13','20100721001','饼干糕点',''),
 ('201108160084','1','11','11','西式糕点','1','201108160062,201108160084',11,'xsgd','20110809007','201108160062','2011-11-17 10:21:17','20100721001','饼干糕点',''),
 ('201108160085','1','11','11','传统糕点','1','201108160062,201108160085',11,'ctgd','20110809007','201108160062','2011-11-17 10:21:22','20100721001','饼干糕点',''),
 ('201108160086','1','11','11','膨化零食','1','201108160062,201108160086',11,'phsp','20110809007','201108160062','2011-11-17 10:21:26','20100721001','饼干糕点',''),
 ('201108160087','1','11','11','饼干','1','201108160062,201108160087',11,'bg','20110809007','201108160062','2011-11-17 10:21:31','20100721001','饼干糕点',''),
 ('201108160088','1','11','11','果冻布丁','1','201108160063,201108160088',11,'gdbd','20110809007','201108160063','2011-11-17 10:21:35','20100721001','糖果布丁',''),
 ('201108160089','1','11','11','混合糖果','1','201108160063,201108160089',11,'hhtg','20110809007','201108160063','2011-11-17 10:21:39','20100721001','糖果布丁',''),
 ('201108160090','1','11','11','棒棒糖','1','201108160063,201108160090',11,'bbt','20110809007','201108160063','2011-11-17 10:21:42','20100721001','糖果布丁',''),
 ('201108160091','1','1','1','奶糖','1','201108160063,201108160091',11,'nt','20110809007','201108160063','2011-11-17 10:21:45','20100721001','糖果布丁',''),
 ('201108160092','1','巧克力','巧克力','巧克力','1','201108160063,201108160092',11,'qkl','20110809007','201108160063','2011-11-17 10:21:48','20100721001','糖果布丁',''),
 ('2011112500100','2','N9','N9','诺基亚 N9','0','201111250096,201111250097,2011112500100',9,'N9','201111250010','201111250097','2011-11-25 13:24:37','20100721001','诺基亚',NULL),
 ('2011112500101','1','苹果','苹果','苹果手机','1','201111250096,2011112500101',5,'apple','201111250010','201111250096','2011-11-25 13:40:35','20100721001','手机通讯','html/default/shop/apple_1.html'),
 ('2011112500102','2','苹果 iphone','iphone','Iphone 4','1','201111250096,2011112500101,2011112500102',5,'iphone','201111250010','2011112500101','2011-11-25 13:41:19','20100721001','苹果手机','html/default/shop/iphone_1.html'),
 ('2011112500103','2','诺基亚','诺基亚','诺基亚 N97','1','201111250096,201111250097,2011112500103',7,'诺基亚','201111250010','201111250097','2011-11-25 14:18:44','20100721001','诺基亚','html/default/shop/诺基亚_1.html'),
 ('2011112500104','0','电脑','电脑','电脑','1','2011112500104',5,'电脑','20111124008',NULL,'2011-11-25 15:05:39','20100721001','','html/default/shop/电脑_1.html'),
 ('2011112500105','1','苹果','苹果','苹果电脑','1','2011112500104,2011112500105',4,'苹果','20111124008','2011112500104','2011-11-25 15:06:48','20100721001','电脑','html/default/shop/苹果_1.html'),
 ('2011112500106','1','苹果','苹果','苹果电脑','1','2011112500104,2011112500106',4,'苹果','20111124008','2011112500104','2011-11-25 15:06:48','20100721001','电脑',''),
 ('2011112500107','2','笔记本','笔记本电脑','苹果笔记本电脑','1','2011112500104,2011112500105,2011112500107',12345,'network','20111124008','2011112500105','2011-11-25 15:08:26','20100721001','苹果电脑','html/default/shop/network_1.html'),
 ('2011112500108','1','12','123','笔记本','1','2011112500104,2011112500108',12,'笔记本','20111124008','2011112500104','2011-11-25 15:26:11','20100721001','电脑',''),
 ('2011112500109','1','台式','台式','台式','1','2011112500104,2011112500109',4,'台式','1','2011112500104','2011-11-25 15:26:47','20100721001','电脑',''),
 ('2011112500110','2','戴尔','戴尔','戴尔电脑','1','2011112500104,2011112500108,2011112500110',5,'戴尔','20111124008','2011112500108','2011-11-25 15:27:29','20100721001','笔记本',''),
 ('2011112500111','2','笔记本','三星笔记本电脑','三星笔记本电脑','1','2011112500104,2011112500108,2011112500111',6,'三星','20111124008','2011112500108','2011-11-25 15:28:21','20100721001','笔记本',''),
 ('201111250093','0','戴尔','戴尔','戴尔','1','201111250093',1,'de','20111124008',NULL,'2011-11-25 17:06:13','20100721001','',''),
 ('201111250094','0','苹果','苹果','苹果','1','201111250094',2,'pg','20111124008',NULL,'2011-11-25 09:21:17','20100721001','',''),
 ('201111250095','1','ipad','ipad','Ipad','1','201111250094,201111250095',12,'ipad','20111124008','201111250094','2011-11-25 10:32:51','20100721001','苹果',''),
 ('201111250096','0','手机','手机','手机通讯','1','201111250096',3,'sj','201111250010',NULL,'2011-11-25 11:02:03','20100721001','','html/default/shop/sj_1.html'),
 ('201111250097','1','诺基亚','诺基亚','诺基亚','1','201111250096,201111250097',2,'njy','201111250010','201111250096','2011-11-25 11:08:25','20100721001','手机通讯','html/default/shop/njy_1.html'),
 ('201111250098','1','摩托罗拉','摩托罗拉','摩托罗拉','1','201111250096,201111250098',3,'mtll','201111250010','201111250096','2011-11-25 11:09:47','20100721001','手机通讯',''),
 ('201111250099','2','me525','me525','摩托罗拉 ME525','1','201111250096,201111250098,201111250099',5,'me525','201111250010','201111250098','2011-11-25 13:19:31','20100721001','摩托罗拉','');
/*!40000 ALTER TABLE `goods_category_t` ENABLE KEYS */;


--
-- Definition of table `goods_comment_t`
--

DROP TABLE IF EXISTS `goods_comment_t`;
CREATE TABLE `goods_comment_t` (
  `COMMENTID` varchar(20) NOT NULL,
  `GOODSID` varchar(20) NOT NULL,
  `GOODSNAME` varchar(100) NOT NULL,
  `REPLYORCOMMENTUSERNAME` varchar(50) NOT NULL,
  `POSTTIME` datetime NOT NULL,
  `COMMENTCONTENT` varchar(500) NOT NULL,
  `SCORE` int(10) unsigned DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `REPLYORCOMMENT` varchar(1) NOT NULL,
  `REPLYID` varchar(20) DEFAULT NULL,
  `REPLYORCOMMENTUSERID` varchar(20) NOT NULL,
  `EMAILABLE` varchar(1) DEFAULT NULL,
  `TITLE` varchar(45) DEFAULT NULL,
  `VIRTUALADD` varchar(1) DEFAULT '0',
  PRIMARY KEY (`COMMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_comment_t`
--

/*!40000 ALTER TABLE `goods_comment_t` DISABLE KEYS */;
INSERT INTO `goods_comment_t` (`COMMENTID`,`GOODSID`,`GOODSNAME`,`REPLYORCOMMENTUSERNAME`,`POSTTIME`,`COMMENTCONTENT`,`SCORE`,`STATE`,`REPLYORCOMMENT`,`REPLYID`,`REPLYORCOMMENTUSERID`,`EMAILABLE`,`TITLE`,`VIRTUALADD`) VALUES 
 ('201112310036','2011123000344','1','','2011-12-31 20:35:53','',0,'1','1','0','20100721001','0',NULL,'1'),
 ('201112310037','2011123000343','1','5','2011-12-31 21:05:58','',0,'1','1','0','20100721001','0',NULL,'1'),
 ('201112310038','2011123000343','1','5','2011-12-31 21:05:59','',0,'1','1','0','20100721001','0',NULL,'1'),
 ('201112310039','2011123000343','1','5','2011-12-31 21:05:59','',0,'1','1','0','20100721001','0',NULL,'1'),
 ('201201030040','2011123000344','1','5','2012-01-03 10:01:12','111',0,'1','1','0','20100721001','0',NULL,'1'),
 ('201201030041','2011123000344','1','5','2012-01-03 10:10:02','我的天',0,'1','1','0','20100721001','0',NULL,'1');
/*!40000 ALTER TABLE `goods_comment_t` ENABLE KEYS */;


--
-- Definition of table `goods_specifications_relationship_t`
--

DROP TABLE IF EXISTS `goods_specifications_relationship_t`;
CREATE TABLE `goods_specifications_relationship_t` (
  `GOODS_SET_ID` varchar(20) NOT NULL,
  `SPECIDICATIONS_ID` varchar(20) NOT NULL,
  PRIMARY KEY (`GOODS_SET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_specifications_relationship_t`
--

/*!40000 ALTER TABLE `goods_specifications_relationship_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods_specifications_relationship_t` ENABLE KEYS */;


--
-- Definition of table `goods_t`
--

DROP TABLE IF EXISTS `goods_t`;
CREATE TABLE `goods_t` (
  `GOODSID` varchar(20) NOT NULL,
  `GOODSNAME` varchar(100) NOT NULL,
  `BRANDNAME` varchar(50) NOT NULL,
  `MODEL` varchar(50) DEFAULT NULL,
  `NNAME` varchar(50) NOT NULL,
  `LNAME` varchar(50) NOT NULL,
  `SNAME` varchar(50) DEFAULT NULL,
  `FNAME` varchar(50) DEFAULT NULL,
  `NAVID` varchar(20) NOT NULL,
  `LTYPEID` varchar(20) NOT NULL,
  `STYPEID` varchar(20) DEFAULT NULL,
  `PRICE` double DEFAULT NULL,
  `MEMBERPRICE` double DEFAULT NULL,
  `POINTS` double unsigned DEFAULT NULL,
  `PICTUREURL` varchar(2000) NOT NULL,
  `QUANTITY` int(10) unsigned NOT NULL,
  `SALESTATE` varchar(1) DEFAULT NULL,
  `DETAIL` longtext NOT NULL,
  `UNITNAME` varchar(45) DEFAULT NULL,
  `KEYWORDNAME` varchar(45) DEFAULT NULL,
  `WEIGHT` varchar(20) DEFAULT NULL,
  `READCOUNT` int(10) unsigned DEFAULT '0',
  `RELATEDPRODUCTID` varchar(500) DEFAULT NULL,
  `RECOMMENDED` varchar(1) NOT NULL,
  `HOTSALE` varchar(1) DEFAULT NULL,
  `BARGAINPRICE` varchar(1) DEFAULT NULL,
  `SORT` int(10) unsigned DEFAULT '0',
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `REPLYCOUNT` int(10) unsigned DEFAULT '0',
  `BRANDID` varchar(20) DEFAULT NULL,
  `PLACE_STORE` varchar(100) DEFAULT NULL,
  `META_KEYWORDS` varchar(255) DEFAULT NULL,
  `META_DESCRIPTION` varchar(255) DEFAULT NULL,
  `COST` double DEFAULT NULL,
  `SALEPRICE` double NOT NULL,
  `IS_NEW` varchar(1) DEFAULT NULL,
  `HTML_PATH` varchar(255) DEFAULT NULL,
  `PRODUCT_SN` varchar(45) DEFAULT NULL,
  `GOODS_PARAMETER_VALUE` varchar(5000) DEFAULT NULL,
  `FREEZE_STORE` int(10) DEFAULT NULL,
  `KEYWORDID` varchar(20) DEFAULT NULL,
  `UNITNAMEID` varchar(20) DEFAULT NULL,
  `GOODS_TYPE_ID` varchar(20) DEFAULT NULL,
  `GOODS_TYPE_NAME` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL1` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL2` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL3` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL4` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL5` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL6` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL7` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL8` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL9` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL10` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL11` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL12` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL13` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL14` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL15` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL16` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL17` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL18` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL19` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL20` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL21` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL22` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL23` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL24` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL25` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL26` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL27` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL28` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL29` varchar(45) DEFAULT NULL,
  `GOODS_ATTR_VAL0` varchar(45) DEFAULT NULL,
  `USERSETNUM` varchar(45) DEFAULT NULL,
  `IS_SPECIFICATIONS_OPEN` varchar(1) DEFAULT NULL,
  `STAR` int(10) unsigned DEFAULT NULL,
  `STARUSER` int(10) unsigned DEFAULT NULL,
  `TOTALCOMMENT` int(10) unsigned DEFAULT NULL,
  `VIRTUALSALE` int(10) unsigned DEFAULT NULL,
  `ISMOBILEPLATFORMGOODS` varchar(1) DEFAULT NULL,
  `SALES` int(10) unsigned DEFAULT NULL,
  `REALSALES` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`GOODSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_t`
--

/*!40000 ALTER TABLE `goods_t` DISABLE KEYS */;
INSERT INTO `goods_t` (`GOODSID`,`GOODSNAME`,`BRANDNAME`,`MODEL`,`NNAME`,`LNAME`,`SNAME`,`FNAME`,`NAVID`,`LTYPEID`,`STYPEID`,`PRICE`,`MEMBERPRICE`,`POINTS`,`PICTUREURL`,`QUANTITY`,`SALESTATE`,`DETAIL`,`UNITNAME`,`KEYWORDNAME`,`WEIGHT`,`READCOUNT`,`RELATEDPRODUCTID`,`RECOMMENDED`,`HOTSALE`,`BARGAINPRICE`,`SORT`,`CREATETIME`,`CREATORID`,`REPLYCOUNT`,`BRANDID`,`PLACE_STORE`,`META_KEYWORDS`,`META_DESCRIPTION`,`COST`,`SALEPRICE`,`IS_NEW`,`HTML_PATH`,`PRODUCT_SN`,`GOODS_PARAMETER_VALUE`,`FREEZE_STORE`,`KEYWORDID`,`UNITNAMEID`,`GOODS_TYPE_ID`,`GOODS_TYPE_NAME`,`GOODS_ATTR_VAL1`,`GOODS_ATTR_VAL2`,`GOODS_ATTR_VAL3`,`GOODS_ATTR_VAL4`,`GOODS_ATTR_VAL5`,`GOODS_ATTR_VAL6`,`GOODS_ATTR_VAL7`,`GOODS_ATTR_VAL8`,`GOODS_ATTR_VAL9`,`GOODS_ATTR_VAL10`,`GOODS_ATTR_VAL11`,`GOODS_ATTR_VAL12`,`GOODS_ATTR_VAL13`,`GOODS_ATTR_VAL14`,`GOODS_ATTR_VAL15`,`GOODS_ATTR_VAL16`,`GOODS_ATTR_VAL17`,`GOODS_ATTR_VAL18`,`GOODS_ATTR_VAL19`,`GOODS_ATTR_VAL20`,`GOODS_ATTR_VAL21`,`GOODS_ATTR_VAL22`,`GOODS_ATTR_VAL23`,`GOODS_ATTR_VAL24`,`GOODS_ATTR_VAL25`,`GOODS_ATTR_VAL26`,`GOODS_ATTR_VAL27`,`GOODS_ATTR_VAL28`,`GOODS_ATTR_VAL29`,`GOODS_ATTR_VAL0`,`USERSETNUM`,`IS_SPECIFICATIONS_OPEN`,`STAR`,`STARUSER`,`TOTALCOMMENT`,`VIRTUALSALE`,`ISMOBILEPLATFORMGOODS`,`SALES`,`REALSALES`) VALUES
 ('2011112500320','韩国巧克力 三进X5巧克力棒 巧克力威化5层口味 36克','sollite',NULL,'进口美食','日韩','',NULL,'201108160058','201108160066','0',4.5,3.3,3,'/Uploads/2011112509492970299.jpg,',1000,'1','<p><img src=\"http://www.soipay.com/Uploads/20110822164028_106.jpg\" alt=\"\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','41',0,NULL,'1','1','1',0,'2011-11-25 09:49:55','20100721001',0,'201104060073','1','巧克力','巧克力',3.3,4.5,'1','html/default/shop/2011112500320.html','123','{\"id\":\"paramlistname4272\",\"value\":\"36\"},{\"id\":\"paramlistname48621\",\"value\":\"41\"},{\"id\":\"paramlistname4952\",\"value\":\"1\"},{\"id\":\"paramlistname4963\",\"value\":\"1\"},{\"id\":\"paramlistname49157\",\"value\":\"1\"},{\"id\":\"paramlistname19836\",\"value\":\"1\"},{\"id\":\"paramlistname37133\",\"value\":\"1\"}',10,'20110320001','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','中包','123','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500321','台湾进口零食 鲜奶长松口袋饼 鲜奶口味30g 奶香浓脆','嘉云糖',NULL,'进口美食','港澳台','',NULL,'201108160058','201108160069','0',4.5,3.5,3,'/Uploads/2011112509533511745.jpg,',1000,'1','<p><img src=\"http://www.soipay.com/Uploads/20110822151321_138.jpg\" alt=\"\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','35',0,NULL,'1','1','1',0,'2011-11-25 09:54:00','20100721001',0,'201104060081','1','饼干','饼干',3.5,4.5,'1','html/default/shop/2011112500321.html','121','{\"id\":\"paramlistname4272\",\"value\":\"30\"},{\"id\":\"paramlistname48621\",\"value\":\"35\"},{\"id\":\"paramlistname4952\",\"value\":\"1\"},{\"id\":\"paramlistname4963\",\"value\":\"1\"},{\"id\":\"paramlistname49157\",\"value\":\"1\"},{\"id\":\"paramlistname19836\",\"value\":\"1\"},{\"id\":\"paramlistname37133\",\"value\":\"1\"}',10,'20110320001','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','大包','8484','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500322','韩国进口大洋蜂蜜柚子茶 清热 去火 补维C 375克','嘉云糖',NULL,'进口美食','日韩','',NULL,'201108160058','201108160066','0',42,26.8,30,'/Uploads/2011112510014263432.jpg,',1000,'1','<p><img src=\"http://www.soipay.com/Uploads/20110824162544_919.jpg\" alt=\"\" border=\"0\" /></p>\n<p><img src=\"http://www.soipay.com/Uploads/20110824162631_630.jpg\" alt=\"\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','--请选择--','375',0,NULL,'1','1','1',0,'2011-11-25 10:03:37','20100721001',0,'201104060081','1','茶','茶',26.8,42,'1','html/default/shop/2011112500322.html','45','{\"id\":\"paramlistname4272\",\"value\":\"375\"},{\"id\":\"paramlistname48621\",\"value\":\"430\"},{\"id\":\"paramlistname4952\",\"value\":\"1\"},{\"id\":\"paramlistname4963\",\"value\":\"1\"},{\"id\":\"paramlistname49157\",\"value\":\"1\"},{\"id\":\"paramlistname19836\",\"value\":\"1\"},{\"id\":\"paramlistname37133\",\"value\":\"1\"}',10,'0','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','中包','4567','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500323','甘源蟹黄瓜子仁 韩式小袋烤瓜子仁 250克半斤包装','lotus合情',NULL,'果干蜜饯','蔬果干','',NULL,'201108160061','201108160082','0',12,8,12,'/Uploads/2011112510093095244.jpg,',1000,'1','<p><img src=\"http://www.soipay.com/Uploads/20110826132145_255.jpg\" alt=\"\" border=\"0\" /><img src=\"http://www.soipay.com/Uploads/20110826131723_968.jpg\" alt=\"\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','250',0,NULL,'1','1','1',0,'2011-11-25 10:10:35','20100721001',0,'201104060082','1','瓜子仁','瓜子仁',8,12,'1','html/default/shop/2011112500323.html','123','{\"id\":\"paramlistname4272\",\"value\":\"250\"},{\"id\":\"paramlistname48621\",\"value\":\"255\"},{\"id\":\"paramlistname4952\",\"value\":\"1\"},{\"id\":\"paramlistname4963\",\"value\":\"1\"},{\"id\":\"paramlistname49157\",\"value\":\"1\"},{\"id\":\"paramlistname19836\",\"value\":\"1\"},{\"id\":\"paramlistname37133\",\"value\":\"1\"}',10,'20110320001','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','大包','1234','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500324','台湾卤香翁财记珍味鸭舌 台湾地道卤味 8g','陈大妈',NULL,'肉脯熟食','卤制品','',NULL,'201108160060','201108160075','0',2,1.8,2,'/Uploads/2011112510170372464.jpg,',1000,'1','<p><img src=\"http://www.soipay.com/Uploads/20110826135746_896.jpg\" alt=\"\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','10',0,NULL,'1','1','1',0,'2011-11-25 10:18:11','20100721001',0,'201104060027','1','鸭舌','鸭舌',1.8,2,'1','html/default/shop/2011112500324.html','123','{\"id\":\"paramlistname4272\",\"value\":\"8\"},{\"id\":\"paramlistname48621\",\"value\":\"10\"},{\"id\":\"paramlistname4952\",\"value\":\"1\"},{\"id\":\"paramlistname4963\",\"value\":\"1\"},{\"id\":\"paramlistname49157\",\"value\":\"1\"},{\"id\":\"paramlistname19836\",\"value\":\"11\"},{\"id\":\"paramlistname37133\",\"value\":\"1\"}',10,'20110320001','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','中包','1234','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500325','苹果 iPhone 4 16G版 3G手机','苹果',NULL,'手机通讯','苹果手机','Iphone 4',NULL,'201111250096','2011112500101','2011112500102',6999,5999,6000,'/Uploads/2011112513584822966.jpg,',1000,'1','<p><img alt=\"\" src=\"http://demo.image.shopxx.net/201101/9a74511298564656a474400cdc1c3d10.png\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','580',0,NULL,'1','1','1',0,'2011-11-25 13:59:03','20100721001',0,'2011112500116','1','手机','手机',5999,6999,'1','html/default/shop/2011112500325.html','123','',10,'20110320001','20110318001','201111250010','手机通讯','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','123','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500326','诺基亚（Nokia）N97 mini 3G手机 导航版','诺基亚',NULL,'手机通讯','诺基亚','诺基亚 N97',NULL,'201111250096','201111250097','2011112500103',2520,2100,2100,'/Uploads/2011112514295366958.jpg,',1000,'1','<p><img alt=\"\" src=\"http://demo.image.shopxx.net/201101/30391fa996cf41ae9022cde4c0703491.png\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','480',0,NULL,'1','1','1',0,'2011-11-25 14:32:53','20100721001',0,'2011112500113','12','诺基亚','诺基亚',2100,2520,'1','html/default/shop/2011112500326.html','123456','{\"id\":\"paramlistname39702\",\"value\":\"N97\"},{\"id\":\"paramlistname39893\",\"value\":\"棕色\"},{\"id\":\"paramlistname4061\",\"value\":\"8G\"},{\"id\":\"paramlistname40221\",\"value\":\"手写 键盘\"},{\"id\":\"paramlistname40365\",\"value\":\"GSM\"},{\"id\":\"paramlistname40525\",\"value\":\"3.2\"},{\"id\":\"paramlistname40653\",\"value\":\"是\"},{\"id\":\"paramlistname40789\",\"value\":\"1460*1230\"},{\"id\":\"paramlistname40949\",\"value\":\"wifi GSM\"},{\"id\":\"paramlistname4193\",\"value\":\"前后\"},{\"id\":\"paramlistname41262\",\"value\":\"有\"},{\"id\":\"paramlistname41405\",\"value\":\"有\"}',10,'20110320001','20110318001','201111250010','手机通讯','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','123456','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500327','苹果 MacBook Air MC504CH/A','苹果',NULL,'电脑','苹果电脑','苹果笔记本电脑',NULL,'2011112500104','2011112500105','2011112500107',15999,12999,13000,'/Uploads/20111125151101101110.jpg,',1000,'1','<p><img alt=\"\" src=\"http://demo.image.shopxx.net/201101/6710a2562ad14d93902c24f197ff727d.png\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','2000',0,NULL,'1','1','1',0,'2011-11-25 15:14:01','20100721001',0,'2011112500116','1','笔记本电脑','笔记本电脑',12999,14599,'1','html/default/shop/2011112500327.html','45','{\"id\":\"paramlistname22614\",\"value\":\"苹果\"},{\"id\":\"paramlistname34894\",\"value\":\"123\"},{\"id\":\"paramlistname3562\",\"value\":\"白色\"},{\"id\":\"paramlistname35238\",\"value\":\"win7\"},{\"id\":\"paramlistname35390\",\"value\":\"独立\"},{\"id\":\"paramlistname35534\",\"value\":\"1121\"},{\"id\":\"paramlistname35670\",\"value\":\"321\"},{\"id\":\"paramlistname35790\",\"value\":\"231\"},{\"id\":\"paramlistname36126\",\"value\":\"321\"},{\"id\":\"paramlistname36294\",\"value\":\"321\"},{\"id\":\"paramlistname36446\",\"value\":\"321\"},{\"id\":\"paramlistname36614\",\"value\":\"321\"},{\"id\":\"paramlistname36766\",\"value\":\"123\"},{\"id\":\"paramlistname36902\",\"value\":\"321\"},{\"id\":\"paramlistname42988\",\"value\":\"123\"},{\"id\":\"paramlistname43181\",\"value\":\"123\"},{\"id\":\"paramlistname43373\",\"value\":\"123\"},{\"id\":\"paramlistname43524\",\"value\":\"123\"},{\"id\":\"paramlistname43692\",\"value\":\"123\"},{\"id\":\"paramlistname43852\",\"value\":\"123\"},{\"id\":\"paramlistname43996\",\"value\":\"12\"},{\"id\":\"paramlistname44140\",\"value\":\"12\"},{\"id\":\"paramlistname44292\",\"value\":\"213\"},{\"id\":\"paramlistname39892\",\"value\":\"213\"}',10,'20110320001','20110318001','20111124008','笔记本','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','45','0',1,0,0,0,'1',NULL,NULL),
 ('2011112500328','戴尔 Inspiron 13R','戴尔',NULL,'电脑','','',NULL,'2011112500104','0','0',5999,4999,5000,'/Uploads/2011112515303157825.jpg,',1000,'1','<p><img alt=\"\" src=\"http://demo.image.shopxx.net/201101/6cc2f3056b824de2827cd168a48e1874.png\" border=\"0\" /></p>\n<p>&nbsp;</p>','克','7D','3000',0,NULL,'1','1','1',0,'2011-11-30 14:29:33','20100721001',0,'2011112500111','1','笔记本','笔记本',4999,5999,'1','html/default/shop/2011112500328.html','12345','{\"id\":\"paramlistname22614\",\"value\":\"戴尔\"},{\"id\":\"paramlistname34894\",\"value\":\"123\"},{\"id\":\"paramlistname3562\",\"value\":\"123\"},{\"id\":\"paramlistname35238\",\"value\":\"32123\"},{\"id\":\"paramlistname35390\",\"value\":\"1231\"},{\"id\":\"paramlistname35534\",\"value\":\"3123\"},{\"id\":\"paramlistname35670\",\"value\":\"123123\"},{\"id\":\"paramlistname35790\",\"value\":\"132\"},{\"id\":\"paramlistname36126\",\"value\":\"131\"},{\"id\":\"paramlistname36294\",\"value\":\"33\"},{\"id\":\"paramlistname36446\",\"value\":\"3212\"},{\"id\":\"paramlistname36614\",\"value\":\"123\"},{\"id\":\"paramlistname36766\",\"value\":\"2\"},{\"id\":\"paramlistname36902\",\"value\":\"22\"},{\"id\":\"paramlistname42988\",\"value\":\"1612\"},{\"id\":\"paramlistname43181\",\"value\":\"3123\"},{\"id\":\"paramlistname43373\",\"value\":\"123\"},{\"id\":\"paramlistname43524\",\"value\":\"32\"},{\"id\":\"paramlistname43692\",\"value\":\"12123\"},{\"id\":\"paramlistname43852\",\"value\":\"21\"},{\"id\":\"paramlistname43996\",\"value\":\"213123\"},{\"id\":\"paramlistname44140\",\"value\":\"123\"},{\"id\":\"paramlistname44292\",\"value\":\"12\"},{\"id\":\"paramlistname39892\",\"value\":\"12\"}',10,'20110320001','20110318001','20111124008','笔记本','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','4567','0',1,0,0,0,'1',NULL,NULL),
 ('2011123000333','gatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgat','苹果',NULL,'进口美食','欧美','',NULL,'201108160058','201108160067','0',0,0,0,'0,',0,'0','123123<br />','克','7D','11',0,NULL,'0','0','0',0,'2011-12-30 15:24:23','20100721001',0,'2011112500116','','11','11',0,0,'1','html/default/shop/2011123000333.html','113','',10,'20110320001','20110318001','20110809007','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','中包','123123','1',1,0,0,0,'0',NULL,NULL),
 ('2011123000334','1','苹果',NULL,'进口美食','欧美','',NULL,'201108160058','201108160067','0',0,0,0,'0,',0,'0','1<br />','克','7D','1',0,NULL,'0','0','0',0,'2011-12-30 16:25:50','20100721001',0,'2011112500116','1','1','1',0,0,'1','html/default/shop/2011123000334.html','1','',10,'20110320001','20110318001','0','食品','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','中包','1','1',1,0,0,0,'0',NULL,NULL),
 ('2011123000337','11','苹果',NULL,'粮油调味','调味酱','',NULL,'201108160052','201108160064','0',0,0,0,'0,',0,'0','12<br />','克','7D','1',0,NULL,'0','0','0',0,'2011-12-30 18:15:11','20100721001',0,'2011112500116','1','1','1',0,0,'1','#','1','',10,'20110320001','20110318001','0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1','1',1,0,0,0,'0',NULL,NULL);
/*!40000 ALTER TABLE `goods_t` ENABLE KEYS */;

--
-- Definition of table `goods_type_brand_t`
--

DROP TABLE IF EXISTS `goods_type_brand_t`;
CREATE TABLE `goods_type_brand_t` (
  `GOODS_TYPE_BRAND_TID` varchar(20) NOT NULL,
  `GOODS_TYPE_ID` varchar(20) DEFAULT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `BRANDNAME` varchar(45) DEFAULT NULL,
  `BRANDID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`GOODS_TYPE_BRAND_TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_type_brand_t`
--

/*!40000 ALTER TABLE `goods_type_brand_t` DISABLE KEYS */;
INSERT INTO `goods_type_brand_t` (`GOODS_TYPE_BRAND_TID`,`GOODS_TYPE_ID`,`NAME`,`BRANDNAME`,`BRANDID`) VALUES 
 ('201108160010','20110809007','食品','Davidoff/大卫杜夫','201104060089'),
 ('201108160011','20110809007','食品','汉斯','201104060088'),
 ('201108160012','20110809007','食品','费列罗','201104060087'),
 ('201108160013','20110809007','食品','德菲斯','201104060086'),
 ('201108160014','20110809007','食品','德菲丝','201104060085'),
 ('201108160015','20110809007','食品','W.L.','201104060084'),
 ('201108160016','20110809007','食品','Ocean Spray 优鲜沛','201104060083'),
 ('201108160017','20110809007','食品','lotus合情','201104060082'),
 ('201108160018','20110809007','食品','嘉云糖','201104060081'),
 ('201108160019','20110809007','食品','好时','201104060080'),
 ('201108160020','20110809007','食品','雀巢','201104060079'),
 ('201108160021','20110809007','食品','德芙','201104060078'),
 ('201108160022','20110809007','食品','德菲斯','201104060077'),
 ('201108160023','20110809007','食品','丹夫','201104060076'),
 ('201108160024','20110809007','食品','优之良品','201104060075'),
 ('201108160025','20110809007','食品','铜锣烧','201104060074'),
 ('201108160026','20110809007','食品','sollite','201104060073'),
 ('201108160027','20110809007','食品','大哥','201104060072'),
 ('201108160028','20110809007','食品','朋多','201104060071'),
 ('20110816009','20110809007','食品','苏格格','201104130090'),
 ('201112290033','20110809007','食品','苹果','2011112500118'),
 ('201112290034','20110809007','食品','摩托罗拉','2011112500116'),
 ('201112290035','20110809007','食品','诺基亚','2011112500115'),
 ('201112290036','20110809007','食品','索尼','2011112500113'),
 ('201112290037','20110809007','食品','戴尔','2011112500112'),
 ('201112290038','20110809007','食品','东芝','2011112500111'),
 ('201112290039','20110809007','食品','三星','2011112500110'),
 ('201112290040','20110809007','食品','惠普','2011112500109'),
 ('201112290041','20110809007','食品','惠普','2011112500108'),
 ('201112290042','20110809007','食品','联想','2011112500107');
/*!40000 ALTER TABLE `goods_type_brand_t` ENABLE KEYS */;


--
-- Definition of table `goods_type_t_n`
--

DROP TABLE IF EXISTS `goods_type_t_n`;
CREATE TABLE `goods_type_t_n` (
  `GOODS_TYPE_ID` varchar(20) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `GOODS_PARAMETER` text,
  PRIMARY KEY (`GOODS_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goods_type_t_n`
--

/*!40000 ALTER TABLE `goods_type_t_n` DISABLE KEYS */;
INSERT INTO `goods_type_t_n` (`GOODS_TYPE_ID`,`NAME`,`CREATETIME`,`CREATORID`,`GOODS_PARAMETER`) VALUES 
 ('20110809007','食品','2012-03-07 09:57:25','20100721001','[{\"name\":\"进含量\",\"id\":\"paramlistname4272\",\"sortList\":\"1\"},{\"name\":\"毛重\",\"id\":\"paramlistname48621\",\"sortList\":\"2\"},{\"name\":\"保质期\",\"id\":\"paramlistname4952\",\"sortList\":\"3\"},{\"name\":\"生产许可证编号\",\"id\":\"paramlistname4963\",\"sortList\":\"4\"},{\"name\":\"卫生许可证编号\",\"id\":\"paramlistname49157\",\"sortList\":\"5\"},{\"name\":\"产品标准号\",\"id\":\"paramlistname19836\",\"sortList\":\"6\"},{\"name\":\"产地\",\"id\":\"paramlistname37133\",\"sortList\":\"7\"}]'),
 ('20111124008','笔记本','2011-11-24 15:00:23','20100721001','[{\"name\":\"品牌\",\"id\":\"paramlistname22614\",\"sortList\":\"1\"},{\"name\":\"型号\",\"id\":\"paramlistname34894\",\"sortList\":\"2\"},{\"name\":\"颜色\",\"id\":\"paramlistname3562\",\"sortList\":\"3\"},{\"name\":\"平台\",\"id\":\"paramlistname35238\",\"sortList\":\"4\"},{\"name\":\"显卡类型\",\"id\":\"paramlistname35390\",\"sortList\":\"5\"},{\"name\":\"显示芯片\",\"id\":\"paramlistname35534\",\"sortList\":\"6\"},{\"name\":\"显存容量 \",\"id\":\"paramlistname35670\",\"sortList\":\"7\"},{\"name\":\"CPU类型\",\"id\":\"paramlistname35790\",\"sortList\":\"8\"},{\"name\":\"CPU型号\",\"id\":\"paramlistname36126\",\"sortList\":\"9\"},{\"name\":\"CPU速度\",\"id\":\"paramlistname36294\",\"sortList\":\"10\"},{\"name\":\"三级缓存\",\"id\":\"paramlistname36446\",\"sortList\":\"11\"},{\"name\":\"芯片组\",\"id\":\"paramlistname36614\",\"sortList\":\"12\"},{\"name\":\"内存容量\",\"id\":\"paramlistname36766\",\"sortList\":\"13\"},{\"name\":\"内存类型\",\"id\":\"paramlistname36902\",\"sortList\":\"14\"},{\"name\":\"硬盘容量\",\"id\":\"paramlistname42988\",\"sortList\":\"15\"},{\"name\":\"光驱类型\",\"id\":\"paramlistname43181\",\"sortList\":\"16\"},{\"name\":\"显示比例\",\"id\":\"paramlistname43373\",\"sortList\":\"17\"},{\"name\":\"屏幕类型\",\"id\":\"paramlistname43524\",\"sortList\":\"18\"},{\"name\":\"内置蓝牙\",\"id\":\"paramlistname43692\",\"sortList\":\"19\"},{\"name\":\"PC卡插槽\",\"id\":\"paramlistname43852\",\"sortList\":\"20\"},{\"name\":\"USB\",\"id\":\"paramlistname43996\",\"sortList\":\"21\"},{\"name\":\"电池\",\"id\":\"paramlistname44140\",\"sortList\":\"22\"},{\"name\":\"尺寸\",\"id\":\"paramlistname44292\",\"sortList\":\"23\"},{\"name\":\"重量\",\"id\":\"paramlistname39892\",\"sortList\":\"24\"}]'),
 ('20111124009','台式机','2011-11-24 15:04:26','20100721001','[{\"name\":\"品牌\",\"id\":\"paramlistname16425\",\"sortList\":\"1\"},{\"name\":\"型号\",\"id\":\"paramlistname18401\",\"sortList\":\"2\"},{\"name\":\"操作系统\",\"id\":\"paramlistname18593\",\"sortList\":\"3\"},{\"name\":\"平台\",\"id\":\"paramlistname18905\",\"sortList\":\"4\"},{\"name\":\"显卡类型\",\"id\":\"paramlistname1981\",\"sortList\":\"5\"},{\"name\":\"显示器尺寸\",\"id\":\"paramlistname19233\",\"sortList\":\"6\"},{\"name\":\"芯片组\",\"id\":\"paramlistname19393\",\"sortList\":\"7\"},{\"name\":\"CPU类型\",\"id\":\"paramlistname19537\",\"sortList\":\"8\"},{\"name\":\"CPU核心数\",\"id\":\"paramlistname19785\",\"sortList\":\"9\"},{\"name\":\"CPU速度\",\"id\":\"paramlistname19953\",\"sortList\":\"10\"},{\"name\":\"CPU二级缓存\",\"id\":\"paramlistname20249\",\"sortList\":\"11\"},{\"name\":\"显示芯片\",\"id\":\"paramlistname20401\",\"sortList\":\"12\"},{\"name\":\"显存容量\",\"id\":\"paramlistname20561\",\"sortList\":\"13\"},{\"name\":\"内存容量\",\"id\":\"paramlistname20713\",\"sortList\":\"14\"},{\"name\":\"内存速度\",\"id\":\"paramlistname20873\",\"sortList\":\"15\"},{\"name\":\"硬盘容量\",\"id\":\"paramlistname219\",\"sortList\":\"16\"},{\"name\":\"硬盘类型\",\"id\":\"paramlistname21145\",\"sortList\":\"17\"},{\"name\":\"光驱类型\",\"id\":\"paramlistname21280\",\"sortList\":\"18\"},{\"name\":\"前(侧)面USB接口\",\"id\":\"paramlistname41248\",\"sortList\":\"19\"},{\"name\":\"前(侧)面音频接口\",\"id\":\"paramlistname41448\",\"sortList\":\"20\"},{\"name\":\"后面视频接口\",\"id\":\"paramlistname41631\",\"sortList\":\"21\"},{\"name\":\"后面音频接口\",\"id\":\"paramlistname41799\",\"sortList\":\"22\"},{\"name\":\"后面USB\",\"id\":\"paramlistname41967\",\"sortList\":\"23\"}]'),
 ('201111250010','手机通讯','2011-11-25 11:16:37','20100721001','[{\"name\":\"型号\",\"id\":\"paramlistname39702\",\"sortList\":\"1\"},{\"name\":\"外观\",\"id\":\"paramlistname39893\",\"sortList\":\"2\"},{\"name\":\"机身内存\",\"id\":\"paramlistname4061\",\"sortList\":\"3\"},{\"name\":\"输入方式\",\"id\":\"paramlistname40221\",\"sortList\":\"4\"},{\"name\":\"数据传输\",\"id\":\"paramlistname40365\",\"sortList\":\"5\"},{\"name\":\"屏幕尺寸\",\"id\":\"paramlistname40525\",\"sortList\":\"6\"},{\"name\":\"智能手机\",\"id\":\"paramlistname40653\",\"sortList\":\"7\"},{\"name\":\"分辨率\",\"id\":\"paramlistname40789\",\"sortList\":\"8\"},{\"name\":\"网络\",\"id\":\"paramlistname40949\",\"sortList\":\"9\"},{\"name\":\"摄像头\",\"id\":\"paramlistname4193\",\"sortList\":\"10\"},{\"name\":\"收音机\",\"id\":\"paramlistname41262\",\"sortList\":\"11\"},{\"name\":\"电子书\",\"id\":\"paramlistname41405\",\"sortList\":\"12\"}]');
/*!40000 ALTER TABLE `goods_type_t_n` ENABLE KEYS */;


--
-- Definition of table `goodsstar_comment_t`
--

DROP TABLE IF EXISTS `goodsstar_comment_t`;
CREATE TABLE `goodsstar_comment_t` (
  `STARCOMMENTID` varchar(20) NOT NULL,
  `GOODSID` varchar(20) NOT NULL,
  `STARNUM` int(10) unsigned NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`STARCOMMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goodsstar_comment_t`
--

/*!40000 ALTER TABLE `goodsstar_comment_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `goodsstar_comment_t` ENABLE KEYS */;


--
-- Definition of table `goodsunit_t`
--

DROP TABLE IF EXISTS `goodsunit_t`;
CREATE TABLE `goodsunit_t` (
  `UNITID` varchar(20) NOT NULL,
  `UNITNAME` varchar(45) NOT NULL,
  `ENGUNITNAME` varchar(20) DEFAULT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`UNITID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goodsunit_t`
--

/*!40000 ALTER TABLE `goodsunit_t` DISABLE KEYS */;
INSERT INTO `goodsunit_t` (`UNITID`,`UNITNAME`,`ENGUNITNAME`,`CREATORID`,`CREATETIME`) VALUES 
 ('20120319003','克',NULL,'20100721001','2012-03-19 00:00:00');
/*!40000 ALTER TABLE `goodsunit_t` ENABLE KEYS */;


--
-- Definition of table `grade_t`
--

DROP TABLE IF EXISTS `grade_t`;
CREATE TABLE `grade_t` (
  `GRADEID` varchar(20) NOT NULL,
  `GRADEVALUE` varchar(1) NOT NULL,
  `GRADENAME` varchar(45) NOT NULL,
  `NEEDCOST` double(10,2) DEFAULT NULL,
  `DISCOUNT` double(10,2) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  PRIMARY KEY (`GRADEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `grade_t`
--

/*!40000 ALTER TABLE `grade_t` DISABLE KEYS */;
INSERT INTO `grade_t` (`GRADEID`,`GRADEVALUE`,`GRADENAME`,`NEEDCOST`,`DISCOUNT`,`CREATETIME`,`CREATORID`) VALUES 
 ('20110421001','2','银卡会员',1000.00,9.00,'2011-04-22 13:38:51','20100721001'),
 ('20110421002','1','普通会员',3000.00,8.00,'2011-04-22 13:38:16','20100721001');
/*!40000 ALTER TABLE `grade_t` ENABLE KEYS */;


--
-- Definition of table `img_t`
--

DROP TABLE IF EXISTS `img_t`;
CREATE TABLE `img_t` (
  `IMG_ID` varchar(20) NOT NULL,
  `IMG_NAME` varchar(45) DEFAULT NULL,
  `USED_GOODSID` varchar(20) DEFAULT NULL,
  `IMG_TYPE` varchar(10) DEFAULT NULL,
  `IMG_HREF` varchar(225) NOT NULL,
  `DES` varchar(100) DEFAULT NULL,
  `IMG_TYPE_ID` varchar(20) DEFAULT NULL,
  `IMG_TYPE_NAME` varchar(45) DEFAULT NULL,
  `USED_POSITION_NAME` varchar(45) DEFAULT NULL,
  `USED_POSITION_ID` varchar(20) DEFAULT NULL,
  `VERSION` int(10) unsigned DEFAULT NULL,
  `USED_GOODSNAME` varchar(100) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  PRIMARY KEY (`IMG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `img_t`
--

/*!40000 ALTER TABLE `img_t` DISABLE KEYS */;
INSERT INTO `img_t` (`IMG_ID`,`IMG_NAME`,`USED_GOODSID`,`IMG_TYPE`,`IMG_HREF`,`DES`,`IMG_TYPE_ID`,`IMG_TYPE_NAME`,`USED_POSITION_NAME`,`USED_POSITION_ID`,`VERSION`,`USED_GOODSNAME`,`CREATETIME`,`CREATORID`,`STATE`) VALUES 
 ('20111102001','2011101421495529630.jpg','2011101000281','.jpg','/Uploads/2011101421495529630.jpg',NULL,NULL,NULL,NULL,NULL,NULL,'苏格格巴噔巴噔 黑芝麻核桃 40g','2011-11-02 17:05:40','20100721001','1');
/*!40000 ALTER TABLE `img_t` ENABLE KEYS */;


--
-- Definition of table `img_type_t`
--

DROP TABLE IF EXISTS `img_type_t`;
CREATE TABLE `img_type_t` (
  `IMG_TYPE_ID` varchar(20) NOT NULL,
  `IMG_TYPE_NAME` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  PRIMARY KEY (`IMG_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `img_type_t`
--

/*!40000 ALTER TABLE `img_type_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `img_type_t` ENABLE KEYS */;


--
-- Definition of table `invoice_print_t`
--

DROP TABLE IF EXISTS `invoice_print_t`;
CREATE TABLE `invoice_print_t` (
  `INVOICEPRINTID` varchar(20) NOT NULL,
  `INVOICEPRINTTIME` datetime NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `ORDERID` varchar(20) NOT NULL,
  `SHIPPINGADDRESSID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `LOGISTICSID` varchar(20) NOT NULL,
  `LOGISTICSNUMBER` varchar(50) DEFAULT NULL,
  `INVOICENUMBER` varchar(50) DEFAULT NULL,
  `OPERATORNAME` varchar(50) NOT NULL,
  `ORDERNAME` varchar(1000) NOT NULL,
  PRIMARY KEY (`INVOICEPRINTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoice_print_t`
--

/*!40000 ALTER TABLE `invoice_print_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `invoice_print_t` ENABLE KEYS */;


--
-- Definition of table `invoicetemplete_t`
--

DROP TABLE IF EXISTS `invoicetemplete_t`;
CREATE TABLE `invoicetemplete_t` (
  `INVOICETEMPLETEID` varchar(20) NOT NULL,
  `LOGISTICSID` varchar(20) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `KINDEDITOR_CODE` text NOT NULL,
  PRIMARY KEY (`INVOICETEMPLETEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `invoicetemplete_t`
--

/*!40000 ALTER TABLE `invoicetemplete_t` DISABLE KEYS */;
INSERT INTO `invoicetemplete_t` (`INVOICETEMPLETEID`,`LOGISTICSID`,`STATE`,`KINDEDITOR_CODE`) VALUES 
 ('20110511002',NULL,'1','<table class=\"ke-zeroborder\" width=\"900\" border=\"0\">\n  <tbody><tr>\n    <td rowspan=\"8\" width=\"193\">&nbsp;</td>\n    <td id=\"purchasetime\">订购日期：</td>\n  </tr>\n  <tr>\n    <td id=\"invoicenumber\">发货单号：</td>\n  </tr>\n  <tr>\n    <td id=\"orderid\">订单号：</td>\n  </tr>\n  <tr>\n    <td id=\"hasprintfpinvoice\">是否已开发票：</td>\n  </tr>\n  <tr>\n    <td id=\"shippingusername\">收货人姓名：</td>\n  </tr>\n  <tr>\n    <td id=\"country\">国家：,省：,市：</td>\n  </tr>\n  <tr>\n    <td id=\"district\">区：,邮编：</td>\n  </tr>\n  <tr>\n    <td id=\"street\">地址：</td>\n  </tr>\n </tbody>\n</table>\n<br />\n<div>\n  </div>\n<table style=\"border:1px solid #ccc;\" class=\"ke-zeroborder\" width=\"900\">\n  <tbody><tr>\n    <td style=\"border:1px solid #ccc;\" width=\"74\">序号</td>\n    <td style=\"border:1px solid #ccc;\" colspan=\"2\">商品名称</td>\n    <td style=\"border:1px solid #ccc;\" width=\"82\">编码</td>\n    <td style=\"border:1px solid #ccc;\" width=\"107\">单价(元)</td>\n    <td style=\"border:1px solid #ccc;\" width=\"55\">数量</td>\n    <td style=\"border:1px solid #ccc;\" width=\"142\">金额(元)</td>\n  </tr>\n<tr id=\"afterappend\" style=\"line-height:2px;\">\n    <td cplspan=\"6\"><br />\n</td>\n</tr>\n<tr id=\"detailgoodsarea\">\n    <td id=\"id\">&nbsp;</td>\n    <td id=\"goodsname\" colspan=\"2\">&nbsp;</td>\n    <td id=\"usersetnum\">&nbsp;</td>\n    <td id=\"favorable\">&nbsp;</td>\n    <td id=\"needquantity\">&nbsp;</td>\n    <td id=\"subtotal\">&nbsp;</td>\n  </tr>\n <tr>\n    <td>小计</td>\n    <td id=\"amount\" colspan=\"4\">&nbsp;</td>\n    <td><br />\n</td>\n    <td><br />\n</td>\n  </tr>\n  <tr>\n    <td>运费(元)：</td>\n    <td id=\"freight\" width=\"210\"><br />\n</td>\n    <td width=\"184\" align=\"right\">订单总金额(元):</td>\n    <td id=\"shouldpay\" colspan=\"2\"><br />\n</td>\n    <td colspan=\"2\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td>&nbsp;</td>\n    <td colspan=\"4\">&nbsp;</td>\n    <td>&nbsp;</td>\n    <td>&nbsp;</td>\n  </tr>\n</tbody>\n</table>');
/*!40000 ALTER TABLE `invoicetemplete_t` ENABLE KEYS */;


--
-- Definition of table `jshopbasic_info_t`
--

DROP TABLE IF EXISTS `jshopbasic_info_t`;
CREATE TABLE `jshopbasic_info_t` (
  `BASICINFOID` varchar(20) NOT NULL,
  `JSHOPNAME` varchar(45) NOT NULL,
  `JSHOPSLOGAN` varchar(45) DEFAULT NULL,
  `COUNTRY` varchar(12) DEFAULT NULL,
  `PROVINCE` varchar(12) DEFAULT NULL,
  `CITY` varchar(12) DEFAULT NULL,
  `STREET` varchar(50) DEFAULT NULL,
  `QQSERVICE` varchar(100) DEFAULT NULL,
  `TAOBAOWWSERVICE` varchar(100) DEFAULT NULL,
  `SKYPESERVICE` varchar(100) DEFAULT NULL,
  `YAHOOSERVICE` varchar(100) DEFAULT NULL,
  `MSNSERVICE` varchar(100) DEFAULT NULL,
  `EMAILSERVICE` varchar(200) DEFAULT NULL,
  `PHONESERVICE` varchar(200) DEFAULT NULL,
  `OPENSTATE` varchar(1) DEFAULT NULL,
  `SITECLOSENOTES` varchar(200) DEFAULT NULL,
  `SITELOGO` varchar(500) DEFAULT NULL,
  `LICENSED` varchar(1) DEFAULT NULL,
  `USERCENTERNOTE` varchar(500) DEFAULT NULL,
  `JSHOPNOTICE` varchar(500) DEFAULT NULL,
  `REGISTERCLOSE` varchar(1) DEFAULT NULL,
  `ICPNUM` varchar(45) DEFAULT NULL,
  `SEND_NAME` varchar(45) DEFAULT NULL,
  `SEND_COUNTRY` varchar(12) DEFAULT NULL,
  `SEND_PROVINCE` varchar(12) DEFAULT NULL,
  `SEND_CITY` varchar(12) DEFAULT NULL,
  `SEND_DISTRICT` varchar(12) DEFAULT NULL,
  `SEND_STREET` varchar(100) DEFAULT NULL,
  `SEND_TELNO` varchar(20) DEFAULT NULL,
  `SEND_MOBILE` varchar(20) DEFAULT NULL,
  `SEND_CONTACTOR` varchar(45) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `DISTRICT` varchar(12) DEFAULT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `META_KEYWORDS` varchar(255) DEFAULT NULL,
  `META_DES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`BASICINFOID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jshopbasic_info_t`
--

/*!40000 ALTER TABLE `jshopbasic_info_t` DISABLE KEYS */;
INSERT INTO `jshopbasic_info_t` (`BASICINFOID`,`JSHOPNAME`,`JSHOPSLOGAN`,`COUNTRY`,`PROVINCE`,`CITY`,`STREET`,`QQSERVICE`,`TAOBAOWWSERVICE`,`SKYPESERVICE`,`YAHOOSERVICE`,`MSNSERVICE`,`EMAILSERVICE`,`PHONESERVICE`,`OPENSTATE`,`SITECLOSENOTES`,`SITELOGO`,`LICENSED`,`USERCENTERNOTE`,`JSHOPNOTICE`,`REGISTERCLOSE`,`ICPNUM`,`SEND_NAME`,`SEND_COUNTRY`,`SEND_PROVINCE`,`SEND_CITY`,`SEND_DISTRICT`,`SEND_STREET`,`SEND_TELNO`,`SEND_MOBILE`,`SEND_CONTACTOR`,`STATE`,`DISTRICT`,`CREATORID`,`CREATETIME`,`META_KEYWORDS`,`META_DES`) VALUES 
 ('2011100500','ostocy-jshop','ostocy-jshop2.0系统演示','1','上海','上海','1','1','1','1','1','1','1','1','0','1','20111006130324104565.jpg,http://localhost:80/undefined,http://localhost:80//Uploads/20120104/2012010423030938942.jpg,','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','浦东','20100721001','2012-03-19 00:00:00','ostocy-jshop2.0系统演示','ostocy-jshop2.0系统演示');
/*!40000 ALTER TABLE `jshopbasic_info_t` ENABLE KEYS */;


--
-- Definition of table `keyword_t`
--

DROP TABLE IF EXISTS `keyword_t`;
CREATE TABLE `keyword_t` (
  `KEYWORDID` varchar(20) NOT NULL,
  `KEYWORDNAME` varchar(45) NOT NULL,
  `SEARCH_COUNT` int(10) unsigned DEFAULT '0',
  `SORT` int(10) unsigned DEFAULT '0',
  `TYPE` varchar(1) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  PRIMARY KEY (`KEYWORDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `keyword_t`
--

/*!40000 ALTER TABLE `keyword_t` DISABLE KEYS */;
INSERT INTO `keyword_t` (`KEYWORDID`,`KEYWORDNAME`,`SEARCH_COUNT`,`SORT`,`TYPE`,`STATE`,`CREATETIME`,`CREATORID`) VALUES 
 ('20110320001','7D',0,2,'1','1','2012-01-05 14:47:12','20100721001'),
 ('20120105002','2',0,1,'1','2','2012-01-05 13:43:12','20100721001'),
 ('20120105003','2',0,11,'1','1','2012-01-05 14:46:52','20100721001');
/*!40000 ALTER TABLE `keyword_t` ENABLE KEYS */;


--
-- Definition of table `location_t`
--

DROP TABLE IF EXISTS `location_t`;
CREATE TABLE `location_t` (
  `LID` varchar(20) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `LAT` double NOT NULL,
  `LNG` double NOT NULL,
  `ZOOM` int(10) unsigned NOT NULL,
  `VERSION` int(10) unsigned NOT NULL,
  PRIMARY KEY (`LID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `location_t`
--

/*!40000 ALTER TABLE `location_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `location_t` ENABLE KEYS */;


--
-- Definition of table `logistics_business_t`
--

DROP TABLE IF EXISTS `logistics_business_t`;
CREATE TABLE `logistics_business_t` (
  `LOGISTICSID` varchar(20) NOT NULL,
  `LOGISTICSNAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `CONTRACTOR` varchar(45) NOT NULL,
  `TELNO` varchar(20) DEFAULT NULL,
  `FAXNO` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `RECEIVER` varchar(45) NOT NULL,
  `BANKADDRESS` varchar(45) DEFAULT NULL,
  `BANKACCOUNT` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `DES` varchar(200) DEFAULT NULL,
  `INSURE` varchar(1) DEFAULT NULL,
  `IS_COD` varchar(1) DEFAULT NULL,
  `VISIBLE` varchar(1) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `WEBSITE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`LOGISTICSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logistics_business_t`
--

/*!40000 ALTER TABLE `logistics_business_t` DISABLE KEYS */;
INSERT INTO `logistics_business_t` (`LOGISTICSID`,`LOGISTICSNAME`,`ADDRESS`,`CONTRACTOR`,`TELNO`,`FAXNO`,`EMAIL`,`RECEIVER`,`BANKADDRESS`,`BANKACCOUNT`,`CREATETIME`,`CREATORID`,`DES`,`INSURE`,`IS_COD`,`VISIBLE`,`STATE`,`CITY`,`WEBSITE`) VALUES 
 ('20110404004','上海韵达快递','1','1','1','1','1','1','1','1','2011-04-25 18:13:45','20100721001','','1','1','1','1','上海','http://www.yundaex.com/www/index.html'),
 ('20110406005','E邮宝','','','','','','','','','2011-04-06 11:12:39','20100721001','','1','1','0','1','',NULL);
/*!40000 ALTER TABLE `logistics_business_t` ENABLE KEYS */;


--
-- Definition of table `logisticsbusinessarea_t`
--

DROP TABLE IF EXISTS `logisticsbusinessarea_t`;
CREATE TABLE `logisticsbusinessarea_t` (
  `LOGBUSAREAID` varchar(20) NOT NULL,
  `LOGISTICSID` varchar(20) NOT NULL,
  `LOGISTICSNAME` varchar(45) DEFAULT NULL,
  `AREANAME` varchar(1) NOT NULL,
  `COSTWAY` varchar(1) DEFAULT NULL,
  `NORMALCOST` double DEFAULT NULL,
  `OVERCOST` double(10,2) DEFAULT NULL,
  `FREECOUNT` double(10,2) DEFAULT NULL,
  `SENDAREA` varchar(5000) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  `OVERVALUE` double DEFAULT NULL,
  `NEEDCOSTMIN` double DEFAULT NULL,
  `NEEDCOSTMAX` double DEFAULT NULL,
  PRIMARY KEY (`LOGBUSAREAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `logisticsbusinessarea_t`
--

/*!40000 ALTER TABLE `logisticsbusinessarea_t` DISABLE KEYS */;
INSERT INTO `logisticsbusinessarea_t` (`LOGBUSAREAID`,`LOGISTICSID`,`LOGISTICSNAME`,`AREANAME`,`COSTWAY`,`NORMALCOST`,`OVERCOST`,`FREECOUNT`,`SENDAREA`,`STATE`,`OVERVALUE`,`NEEDCOSTMIN`,`NEEDCOSTMAX`) VALUES 
 ('20110405008','20110404004',NULL,'1','1',10,1.00,NULL,'上海，四川','1',2,0,68);
/*!40000 ALTER TABLE `logisticsbusinessarea_t` ENABLE KEYS */;


--
-- Definition of table `msgtext_t`
--

DROP TABLE IF EXISTS `msgtext_t`;
CREATE TABLE `msgtext_t` (
  `MSGTEXTID` varchar(20) NOT NULL,
  `TEXT` text NOT NULL,
  `SENDTIME` datetime NOT NULL,
  PRIMARY KEY (`MSGTEXTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `msgtext_t`
--

/*!40000 ALTER TABLE `msgtext_t` DISABLE KEYS */;
INSERT INTO `msgtext_t` (`MSGTEXTID`,`TEXT`,`SENDTIME`) VALUES 
 ('20110516001','1212<br />','2011-05-16 19:30:24'),
 ('20110516002','1212<br />','2011-05-16 19:30:38'),
 ('20110516003','','2011-05-16 19:31:09'),
 ('20110516004','1212<br />','2011-05-16 19:35:15'),
 ('20110516005','qwdqwdqwdqwdqwd<br />','2011-05-16 21:43:29'),
 ('20110516006','<p>1211212121http://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>\n<p>http://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>','2011-05-16 21:53:30'),
 ('20110516007','<p>1211212121http://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>\n<p>http://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>','2011-05-16 21:53:30'),
 ('20110516008','<p>1211212121http://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>\n<p>http://localhost:8088/jshop/1212121212usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsphttp://localhost:8088/jshop/usercenter/businessmag/mycart.jsp</p>','2011-05-16 22:20:15');
/*!40000 ALTER TABLE `msgtext_t` ENABLE KEYS */;


--
-- Definition of table `order_invoice_t`
--

DROP TABLE IF EXISTS `order_invoice_t`;
CREATE TABLE `order_invoice_t` (
  `ORDER_INVOICEID` varchar(20) NOT NULL,
  `ORDERID` varchar(20) NOT NULL,
  `INV_TYPE` varchar(10) NOT NULL,
  `INV_PAYEE` varchar(45) NOT NULL,
  `AMOUNT` varchar(20) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `INV_CONTENT` varchar(45) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`ORDER_INVOICEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_invoice_t`
--

/*!40000 ALTER TABLE `order_invoice_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_invoice_t` ENABLE KEYS */;


--
-- Definition of table `order_t`
--

DROP TABLE IF EXISTS `order_t`;
CREATE TABLE `order_t` (
  `ORDERID` varchar(20) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PAYMENTID` varchar(20) NOT NULL,
  `PAYMENTNAME` varchar(50) NOT NULL,
  `DELIVERMODE` varchar(50) NOT NULL,
  `DELIVERYNUMBER` varchar(50) DEFAULT NULL,
  `ORDERSTATE` varchar(1) NOT NULL,
  `LOGISTICSID` varchar(20) NOT NULL,
  `FREIGHT` double NOT NULL,
  `AMOUNT` double(10,2) NOT NULL,
  `POINTS` double DEFAULT NULL,
  `PURCHASETIME` datetime NOT NULL,
  `DELIVERYTIME` datetime DEFAULT NULL,
  `INVOICE` varchar(1) NOT NULL,
  `SHIPPINGADDRESSID` varchar(20) NOT NULL,
  `CUSTOMERNOTES` varchar(100) DEFAULT NULL,
  `LOGISTICSWEBADDRESS` varchar(225) DEFAULT NULL,
  `PAYTIME` datetime DEFAULT NULL,
  `ORDER_TAG` varchar(1) DEFAULT NULL,
  `TO_BUYER` varchar(100) DEFAULT NULL,
  `SHOULDPAY` double(10,2) NOT NULL,
  `USEPOINTS` double(10,2) NOT NULL,
  `VOUCHERSID` varchar(20) DEFAULT NULL,
  `GOODID` varchar(1000) DEFAULT NULL,
  `GOODSNAME` varchar(5000) DEFAULT NULL,
  `NEEDQUANTITY` int(11) DEFAULT NULL,
  `PAYSTATE` varchar(1) NOT NULL,
  `SHIPPINGSTATE` varchar(1) DEFAULT NULL,
  `DELIVERADDRESSID` varchar(20) DEFAULT NULL,
  `SHIPPINGUSERNAME` varchar(50) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  `HASPRINTEXPRESS` varchar(1) DEFAULT NULL,
  `HASPRINTINVOICE` varchar(1) DEFAULT NULL,
  `HASPRINTFPINVOICE` varchar(1) DEFAULT NULL,
  `EXPRESSNUMBER` varchar(50) DEFAULT NULL,
  `TRADE_NO` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ORDERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `order_t`
--

/*!40000 ALTER TABLE `order_t` DISABLE KEYS */;
INSERT INTO `order_t` (`ORDERID`,`USERID`,`USERNAME`,`PAYMENTID`,`PAYMENTNAME`,`DELIVERMODE`,`DELIVERYNUMBER`,`ORDERSTATE`,`LOGISTICSID`,`FREIGHT`,`AMOUNT`,`POINTS`,`PURCHASETIME`,`DELIVERYTIME`,`INVOICE`,`SHIPPINGADDRESSID`,`CUSTOMERNOTES`,`LOGISTICSWEBADDRESS`,`PAYTIME`,`ORDER_TAG`,`TO_BUYER`,`SHOULDPAY`,`USEPOINTS`,`VOUCHERSID`,`GOODID`,`GOODSNAME`,`NEEDQUANTITY`,`PAYSTATE`,`SHIPPINGSTATE`,`DELIVERADDRESSID`,`SHIPPINGUSERNAME`,`CREATETIME`,`HASPRINTEXPRESS`,`HASPRINTINVOICE`,`HASPRINTFPINVOICE`,`EXPRESSNUMBER`,`TRADE_NO`) VALUES 
 ('201105240032','20100721002','sasasa','20110406004','支付宝','EXPRESS',NULL,'0','20110404004',0,0.20,38.96,'2011-05-24 14:12:42',NULL,'0','201105240040','','http://www.yundaex.com/www/index.html',NULL,'1',NULL,0.20,0.00,NULL,'201104090062,','鱿鱼足片250g/袋',2,'0','0','20110518005','陈达','2011-05-24 14:12:42','0','0','0',NULL,NULL),
 ('201105240033','20100721002','sasasa','20110406004','支付宝','EXPRESS','2012220210519191','1','20110404004',0,0.20,25.98,'2011-05-24 17:13:28','2012-03-20 00:00:00','0','201105240041','','http://www.yundaex.com/www/index.html',NULL,'2',NULL,0.20,0.00,NULL,'201104090056,201104090062,','牛浪汉 泡椒牛肉 60g鱿鱼足片250g/袋',2,'0','0','20110518005','陈达','2011-05-24 17:13:28','0','0','0','1',NULL),
 ('201201050034','201112130018','sdywcd','20120105007','支付宝','EXPRESS',NULL,'0','20110404004',0,18.20,1,'2012-01-05 11:20:57',NULL,'0','201201050042','','http://www.yundaex.com/www/index.html',NULL,'2',NULL,18.20,0.00,NULL,'2011111800282,','优鲜沛蔓越莓干（切片）200g/袋',1,'0','0','201201050012','陈达','2012-01-05 11:20:57','0','0','0',NULL,NULL),
 ('201201050037','201112130018','sdywcd','20120105007','支付宝','EXPRESS',NULL,'0','20110404004',0,0.00,0,'2012-01-05 10:57:10',NULL,'0','201201050043','','http://www.yundaex.com/www/index.html',NULL,'1',NULL,0.00,0.00,NULL,'','',0,'0','0','201201050012','陈达','2012-01-05 10:57:10','0','0','0',NULL,NULL);
/*!40000 ALTER TABLE `order_t` ENABLE KEYS */;


--
-- Definition of table `page_editarea_t`
--

DROP TABLE IF EXISTS `page_editarea_t`;
CREATE TABLE `page_editarea_t` (
  `PAGEEDITAREAID` varchar(20) NOT NULL,
  `GOODSCATEGORYID` varchar(20) DEFAULT NULL,
  `NAME` varchar(45) NOT NULL,
  `SIGN` varchar(45) NOT NULL,
  `HTMLPATH` varchar(255) DEFAULT NULL,
  `EDITAREATITLE` varchar(45) NOT NULL,
  `EDITAREAVALUE` text,
  `EDITFLAG` int(10) unsigned DEFAULT NULL,
  `STATE` varchar(1) DEFAULT NULL,
  `SNID` varchar(20) DEFAULT NULL,
  `CREATORID` varchar(20) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`PAGEEDITAREAID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `page_editarea_t`
--

/*!40000 ALTER TABLE `page_editarea_t` DISABLE KEYS */;
INSERT INTO `page_editarea_t` (`PAGEEDITAREAID`,`GOODSCATEGORYID`,`NAME`,`SIGN`,`HTMLPATH`,`EDITAREATITLE`,`EDITAREAVALUE`,`EDITFLAG`,`STATE`,`SNID`,`CREATORID`,`CREATETIME`) VALUES 
 ('201103210012','null','[\n											导航\n										]首页','index','index.html','今日特卖','<div class=\"rightmiddle\">\n                	<div id=\"area9\">\n                    	<div id=\"area9title\" class=\"normaltitle\">今日特卖</div>\n                        <div class=\"todaygoods\">\n                        	<img src=\"ui/default/images/rightmiddlepc1.png\" />                         </div>\n                    </div>\n                </div>',9,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111100029','null','[\n											导航\n										]首页','index','index.html','本月热销','<div class=\"righttop\">\n                    <div id=\"area8\">\n                     	<div id=\"area8title\" class=\"normaltitle\">本月热销</div>\n                        <div class=\"monthgoods\">\n                            	<div class=\"title\">\n                                	<p>宏基笔记本</p>\n                                  \n                                   <a href=\"#\">D100Win8</a>                                 </div>\n                                <img src=\"ui/default/images/righttoppc1.png\" />                          </div>\n                         <div class=\"monthgoods\">\n                             	<div class=\"title\">\n                                	<p>宏基笔记本</p>\n                                  \n                                   <a href=\"#\">D100Win8</a>                                 </div>\n                                <img src=\"ui/default/images/righttoppc2.png\" />                          </div>\n                   	</div>\n				</div>',8,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110030','null','[\n											导航\n										]首页','index','index.html','新品推荐','<div class=\"xpgoods\">\n                            	<img src=\"ui/default/images/goodsxp1.png\" />                                 <div class=\"title\">\n                                	<p>DSLR</p>\n                                  \n                                   <a href=\"#\">单反</a>                                 </div>\n                            </div>\n                            <br class=\"clear\" />\n                            <div class=\"xpgoods\">\n                            	<img src=\"ui/default/images/goodsxp2.png\" />                                 <div class=\"title\">\n                                	<p>PDA</p>\n                                  \n                                   <a href=\"#\">摩托罗拉</a>                                 </div>\n                            </div>\n                             <br class=\"clear\" />\n                            <div class=\"xpgoods\">\n                            	<img src=\"ui/default/images/goodsxp3.png\" />                                 <div class=\"title\">\n                                	<p>LED</p>\n                                  \n                                   <a href=\"#\">夏普</a>                                 </div>\n                            </div>',2,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110031','null','[\n											导航\n										]首页','index','index.html','首页滚动宣传图片','<li><a href=\"#\"><img src=\"ui/default/images/mainsliderpc1.png\" alt=\"\" border=\"0\" /></a> </li>\n                                   <li><a href=\"#\"><img src=\"ui/default/images/mainsliderpc1.png\" alt=\"\" border=\"0\" /></a> </li>\n                                   <li><a href=\"#\"><img src=\"ui/default/images/mainsliderpc1.png\" alt=\"\" border=\"0\" /></a> </li>',4,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110032','null','[\n											导航\n										]首页','index','index.html','品牌推荐','<li><a href=\"#\"><img src=\"ui/default/images/brand1.png\" /></a></li>\n                            <li><img src=\"ui/default/images/brand2.png\" /></li>\n                            <li><img src=\"ui/default/images/brand3.png\" /></li>\n                            <li><img src=\"ui/default/images/brand4.png\" /></li>',3,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110033','null','[\n											导航\n										]首页','index','index.html','广告位10','<div class=\"rightmiddle\">\n                    <div id=\"area10\">\n                    	<div class=\"coupon\">\n                        	<img src=\"ui/default/images/rightmiddlepc2.png\" />                         </div>\n                    </div>\n                </div>',10,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110034','null','[\n											导航\n										]首页','index','index.html','3分栏商品显示区','<div id=\"tabarea\">\n				<div id=\"area5\">\n					<ul class=\"tabs\">\n                    	<li><a href=\"#\">热卖推荐</a></li>\n                        <li><a href=\"#\">本周推荐</a></li>\n                        <li><a href=\"#\">超值低价</a></li>\n					</ul>\n                    <div class=\"panes\">\n                          <div>\n                            <a href=\"#\"><img src=\"ui/default/images/tab1pc1.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc2.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc3.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc4.png\" alt=\"\" /></a>                           </div>\n                          <div>\n                            <a href=\"#\"><img src=\"ui/default/images/tab1pc1.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc2.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc4.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc3.png\" alt=\"\" /></a>                           </div>\n                          <div>\n                            <a href=\"#\"><img src=\"ui/default/images/tab1pc1.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc3.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc2.png\" alt=\"\" /></a>                             <a href=\"#\"><img src=\"ui/default/images/tab1pc4.png\" alt=\"\" /></a>                           </div>\n                    </div>\n                 </div>\n</div>',5,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110035','null','[\n											导航\n										]首页','index','index.html','首页促销商品','<div id=\"bestsale\">\n                	<div id=\"area6\">\n                    <div class=\"best\">\n                    	<ul>\n                        	<li>\n                            	<img class=\"ads\" src=\"ui/default/images/middlecenterpc1.png\" />                             </li>\n                            <li>\n                            	<div class=\"bestpc\">\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/middlecenterpc2.png\" /></a>                                 <div class=\"title\">\n                                	<span><a href=\"#\">11111111111111111111111111</a></span>                                     <span>￥2000</span>                                 </div>\n                                </div>\n                            </li>\n                            <li>\n                            	<div class=\"bestpc\">\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/middcenterpc3.png\" /></a>                                 <div class=\"title\">\n                                	<span><a href=\"#\">11111111111111111111111111</a></span>                                     <span>￥2000</span>                                 </div>\n                                </div>\n                            </li>\n                            <li>\n                            	<div class=\"bestpc\">\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/middlecenterpc4.png\" /></a>                                 <div class=\"title\">\n                                	<span><a href=\"#\">11111111111111111111111111</a></span>                                     <span>￥2000</span>                                 </div>\n                                </div>\n                            </li>\n                        </ul>\n                    </div>\n					</div>\n					\n                    </div>',6,'1','20111103001','20100721001','2012-03-13 00:00:00'),
 ('201111110036','null','[\n											导航\n										]首页','index','index.html','特价商品','<div id=\"recommendsale\">\n                	<div id=\"area6\">\n                    <div class=\"recommend\">\n                    	<div class=\"normaltitle\">推荐商品</div>\n                        <div>\n                    	<ul>\n                            <li>\n                            	<div class=\"recommendpc\">\n                                <div class=\"title\">\n                                	<p><a href=\"#\">夏普液晶显示器</a></p>\n                                    \n                                    <span>市场价：<del>￥2000</del></span><br />\n                                    <span>会员价：￥1000</span>                                 </div>\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/recommendpc1.png\" /></a>                               \n                                </div>\n                            </li>\n                            <li>\n                            	<div class=\"recommendpc\">\n                                <div class=\"title\">\n                                	<p><a href=\"#\">三星手机</a></p>\n                                    <span>市场价：<del>￥2000</del></span><br />\n                                    <span>会员价：￥1000</span>                                 </div>\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/recommendpc2.png\" /></a>                               \n                                </div>\n                            </li>\n                            <li>\n                            	<div class=\"recommendpc\">\n                                <div class=\"title\">\n                                	<p><a href=\"#\">Dell笔记本</a></p>\n                                     <span>市场价：<del>￥5000</del></span><br />\n                                    <span>会员价：￥3000</span>                                 </div>\n                            	<a href=\"#\"><img class=\"adspc\" src=\"ui/default/images/recommendpc3.png\" /></a>                               \n                                </div>\n                            </li>\n                        </ul>\n                        </div>\n                    </div>\n					</div>\n                    </div>',7,'1','20111103001','20100721001','2012-03-13 00:00:00');
/*!40000 ALTER TABLE `page_editarea_t` ENABLE KEYS */;


--
-- Definition of table `page_t`
--

DROP TABLE IF EXISTS `page_t`;
CREATE TABLE `page_t` (
  `PAGEID` varchar(20) NOT NULL,
  `ENPAGENAME` varchar(45) DEFAULT NULL,
  `CNPAGENAME` varchar(45) DEFAULT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `RANGEAREA` varchar(1) NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`PAGEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `page_t`
--

/*!40000 ALTER TABLE `page_t` DISABLE KEYS */;
INSERT INTO `page_t` (`PAGEID`,`ENPAGENAME`,`CNPAGENAME`,`URL`,`RANGEAREA`,`CREATORID`,`CREATETIME`) VALUES 
 ('20110321002','首页','index.jsp','www.soipay.com/index.jsp','1','20100721001','2011-03-21 01:27:34'),
 ('20110322003','商品列表','goodslist.jsp','www.soipay.com/goods/goodslist.jsp','1','20100721001','2011-03-22 16:48:40');
/*!40000 ALTER TABLE `page_t` ENABLE KEYS */;


--
-- Definition of table `payment_m`
--

DROP TABLE IF EXISTS `payment_m`;
CREATE TABLE `payment_m` (
  `PAYMENTID` varchar(20) NOT NULL,
  `PAYMENTNAME` varchar(45) DEFAULT NULL,
  `PAYMENT_CODE` varchar(20) DEFAULT NULL,
  `PAYMENT_FREE` varchar(20) DEFAULT NULL,
  `PAYMENT_INTERFACE` varchar(1) DEFAULT NULL,
  `ACCOUNT` varchar(100) DEFAULT NULL,
  `SAFECODE` varchar(128) DEFAULT NULL,
  `PARTNERID` varchar(128) DEFAULT NULL,
  `DES` varchar(200) DEFAULT NULL,
  `IS_COD` varchar(1) DEFAULT NULL,
  `IS_ONLINE` varchar(1) DEFAULT NULL,
  `STATE` varchar(1) NOT NULL,
  PRIMARY KEY (`PAYMENTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment_m`
--

/*!40000 ALTER TABLE `payment_m` DISABLE KEYS */;
INSERT INTO `payment_m` (`PAYMENTID`,`PAYMENTNAME`,`PAYMENT_CODE`,`PAYMENT_FREE`,`PAYMENT_INTERFACE`,`ACCOUNT`,`SAFECODE`,`PARTNERID`,`DES`,`IS_COD`,`IS_ONLINE`,`STATE`) VALUES 
 ('20120105007','支付宝','zfb','0','2','cxlmc@qq.com','cqpvatw3271iudi63176b7em28b60f','2088102579269997','支付宝信息','1','1','1');
/*!40000 ALTER TABLE `payment_m` ENABLE KEYS */;


--
-- Definition of table `placeoforigin_t`
--

DROP TABLE IF EXISTS `placeoforigin_t`;
CREATE TABLE `placeoforigin_t` (
  `PLACEID` varchar(20) NOT NULL,
  `PLACENAME` varchar(50) NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`PLACEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `placeoforigin_t`
--

/*!40000 ALTER TABLE `placeoforigin_t` DISABLE KEYS */;
INSERT INTO `placeoforigin_t` (`PLACEID`,`PLACENAME`,`CREATORID`,`CREATETIME`) VALUES 
 ('20110318001','台湾','20100721001','2011-03-18 21:21:37'),
 ('201104060010','四川成都','20100721001','2011-04-06 18:01:02'),
 ('201104060011','四川','20100721001','2011-04-06 18:03:50'),
 ('201104060012','广西','20100721001','2011-04-06 18:03:57'),
 ('201104060013','河北','20100721001','2011-04-06 18:04:06'),
 ('201104060014','东北','20100721001','2011-04-06 18:04:13'),
 ('201104060015','广东','20100721001','2011-04-06 18:05:10'),
 ('201104060016','美国原料 上海制造','20100721001','2011-04-06 18:07:58'),
 ('201104060017','日本','20100721001','2011-04-06 18:10:48'),
 ('201104060018','浙江','20100721001','2011-04-06 18:11:01'),
 ('201104060019','菲律宾','20100721001','2011-04-06 18:12:24'),
 ('20110406002','重庆','20100721001','2011-04-06 17:50:12'),
 ('201104060020','韩国','20100721001','2011-04-06 18:25:59'),
 ('201104060021','靖江','20100721001','2011-04-06 18:27:02'),
 ('201104060022','马来西亚','20100721001','2011-04-06 18:32:41'),
 ('201104060023','云南','20100721001','2011-04-06 18:33:21'),
 ('201104060024','苏州','20100721001','2011-04-06 18:35:40'),
 ('201104060025','印尼','20100721001','2011-04-06 18:38:06'),
 ('201104060026','泰国','20100721001','2011-04-06 18:42:28'),
 ('201104060027','香港','20100721001','2011-04-06 18:45:30'),
 ('201104060028','美国','20100721001','2011-04-06 18:48:33'),
 ('201104060029','法国','20100721001','2011-04-06 18:48:42'),
 ('20110406003','山东','20100721001','2011-04-06 17:51:16'),
 ('201104060030','比利时','20100721001','2011-04-06 18:48:54'),
 ('201104060031','德国','20100721001','2011-04-06 18:49:01'),
 ('201104060032','意大利','20100721001','2011-04-06 18:51:52'),
 ('20110406004','越南','20100721001','2011-04-06 17:53:21'),
 ('20110406005','上海','20100721001','2011-04-06 17:53:58'),
 ('20110406006','江门','20100721001','2011-04-06 17:55:25'),
 ('20110406007','澳门','20100721001','2011-04-06 17:56:42'),
 ('201104090033','温州','20100721001','2011-04-09 00:41:24'),
 ('201104130034','江苏','20100721001','2011-04-13 22:00:26'),
 ('201104130035','江苏无锡','20100721001','2011-04-13 22:03:16');
/*!40000 ALTER TABLE `placeoforigin_t` ENABLE KEYS */;


--
-- Definition of table `product_specifications_t`
--

DROP TABLE IF EXISTS `product_specifications_t`;
CREATE TABLE `product_specifications_t` (
  `SPECIFICATIONSID` varchar(20) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `NOTE` varchar(45) DEFAULT NULL,
  `SORT` varchar(45) DEFAULT NULL,
  `SPECIFICATIONS_TYPE` varchar(1) NOT NULL,
  `SPECIFICATIONS_VALUE` varchar(5000) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  PRIMARY KEY (`SPECIFICATIONSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_specifications_t`
--

/*!40000 ALTER TABLE `product_specifications_t` DISABLE KEYS */;
INSERT INTO `product_specifications_t` (`SPECIFICATIONSID`,`NAME`,`NOTE`,`SORT`,`SPECIFICATIONS_TYPE`,`SPECIFICATIONS_VALUE`,`CREATETIME`,`CREATORID`,`STATE`) VALUES 
 ('20111226004','尺码','尺码','1','1','{\"id\":\"46424\",\"goodsattributename\":\"S\",\"attributelist\":\"\",\"sort\":\"1\"}-{\"id\":\"41465\",\"goodsattributename\":\"X\",\"attributelist\":\"\",\"sort\":\"2\"}-{\"id\":\"45299\",\"goodsattributename\":\"XL\",\"attributelist\":\"\",\"sort\":\"3\"}','2011-12-30 13:45:39','20100721001','1'),
 ('20111230007','颜色','颜色','1','2','{\"id\":\"49931\",\"goodsattributename\":\"紫色\",\"attributelist\":\"\",\"sort\":\"1\"}-{\"id\":\"248\",\"goodsattributename\":\"红色\",\"attributelist\":\"\",\"sort\":\"2\"}','2012-03-01 13:48:49','20100721001','1'),
 ('20111230008','产地','产地','3','1','{\"id\":\"35572\",\"goodsattributename\":\"上海\",\"attributelist\":\"\",\"sort\":\"1\"}','2012-03-01 13:38:45','20100721001','1');
/*!40000 ALTER TABLE `product_specifications_t` ENABLE KEYS */;


--
-- Definition of table `product_t`
--

DROP TABLE IF EXISTS `product_t`;
CREATE TABLE `product_t` (
  `PRODUCTID` varchar(20) NOT NULL,
  `PRICE` double DEFAULT NULL,
  `MEMBERPRICE` double DEFAULT NULL,
  `COST` double DEFAULT NULL,
  `SALEPRICE` double DEFAULT NULL,
  `FREEZE_STORE` int(10) unsigned DEFAULT NULL,
  `STORE` int(10) unsigned DEFAULT NULL,
  `IS_DEFAULT` varchar(1) NOT NULL,
  `IS_SALESTATE` varchar(1) NOT NULL,
  `PRODUCT_NAME` varchar(100) NOT NULL,
  `PRODUCT_SN` varchar(45) DEFAULT NULL,
  `SPECIFICATIONS_VALUE` varchar(5000) NOT NULL,
  `WAREHOUSE_LOCATION` varchar(100) DEFAULT NULL,
  `PLACE_STORE` varchar(100) DEFAULT NULL,
  `WEIGHT` varchar(45) DEFAULT NULL,
  `GOODSID` varchar(20) NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  PRIMARY KEY (`PRODUCTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product_t`
--

/*!40000 ALTER TABLE `product_t` DISABLE KEYS */;
INSERT INTO `product_t` (`PRODUCTID`,`PRICE`,`MEMBERPRICE`,`COST`,`SALEPRICE`,`FREEZE_STORE`,`STORE`,`IS_DEFAULT`,`IS_SALESTATE`,`PRODUCT_NAME`,`PRODUCT_SN`,`SPECIFICATIONS_VALUE`,`WAREHOUSE_LOCATION`,`PLACE_STORE`,`WEIGHT`,`GOODSID`,`CREATORID`,`CREATETIME`) VALUES 
 ('201112300030',1,1,1,1,1,1,'1','1','gatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgatgat','1','','1','1','1','2011123000333','20100721001','2011-12-30 15:24:23'),
 ('201112300031',1,1,1,1,1,1,'1','1','1','1','','1','1','1','2011123000334','20100721001','2011-12-30 16:25:50');
/*!40000 ALTER TABLE `product_t` ENABLE KEYS */;


--
-- Definition of table `role_t`
--

DROP TABLE IF EXISTS `role_t`;
CREATE TABLE `role_t` (
  `ROLEID` varchar(20) NOT NULL,
  `ROLENAME` varchar(45) NOT NULL,
  `NOTE` varchar(100) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  PRIMARY KEY (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role_t`
--

/*!40000 ALTER TABLE `role_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_t` ENABLE KEYS */;


--
-- Definition of table `serial_t`
--

DROP TABLE IF EXISTS `serial_t`;
CREATE TABLE `serial_t` (
  `BIZ` varchar(45) NOT NULL,
  `HEAD` varchar(20) DEFAULT NULL,
  `LASTID` varchar(20) NOT NULL,
  `INCREMENT` int(10) unsigned NOT NULL,
  `UPDATETIME` datetime NOT NULL,
  PRIMARY KEY (`BIZ`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `serial_t`
--

/*!40000 ALTER TABLE `serial_t` DISABLE KEYS */;
INSERT INTO `serial_t` (`BIZ`,`HEAD`,`LASTID`,`INCREMENT`,`UPDATETIME`) VALUES 
 ('adcontent','00','1',1,'2010-06-25 12:48:21'),
 ('adposition','00','1',1,'2010-06-25 12:48:21'),
 ('article','00','69',1,'2010-06-25 12:48:21'),
 ('articlecategory','00','13',1,'2010-06-25 12:48:21'),
 ('authority','00','1',1,'2010-06-25 12:48:21'),
 ('brand','00','127',1,'2010-06-25 12:48:21'),
 ('cart','00','28',1,'2010-06-25 12:48:21'),
 ('cartinfo','00','66',1,'2010-06-25 12:48:21'),
 ('consult','00','1',1,'2010-06-25 12:48:21'),
 ('deliver','00','1',1,'2010-06-25 12:48:21'),
 ('deliveraddress','00','13',1,'2010-06-25 12:48:21'),
 ('expresstemplete','00','23',1,'2010-06-25 12:48:21'),
 ('favoriteinfo','00','1',1,'2010-06-25 12:48:21'),
 ('friendlink','00','2',1,'2010-06-25 12:48:21'),
 ('goodsattribute','00','90',1,'2010-06-25 12:48:21'),
 ('goodsbargain','00','1',1,'2010-06-25 12:48:21'),
 ('goodsbunding','00','1',1,'2010-06-25 12:48:21'),
 ('goodscategory','00','112',1,'2010-06-25 12:48:21'),
 ('goodscomment','00','42',1,'2010-06-25 12:48:21'),
 ('goodsgif','00','8',1,'2010-06-25 12:48:21'),
 ('goodsinfo','00','345',1,'2010-06-25 12:48:21'),
 ('goodslimit','00','2',1,'2010-06-25 12:48:21'),
 ('goodspoint','00','1',1,'2010-06-25 12:48:21'),
 ('goodsproperty','00','1',1,'2010-06-25 12:48:21'),
 ('goodspropertyvalue','00','1',1,'2010-06-25 12:48:21'),
 ('goodsquestion','00','1',1,'2010-06-25 12:48:21'),
 ('goodsredemption','00','1',1,'2010-06-25 12:48:21'),
 ('goodssort','00','1',1,'2010-06-25 12:48:21'),
 ('goodsspecifications','00','1',1,'2010-06-25 12:48:21'),
 ('goodstype','00','14',1,'2010-06-25 12:48:21'),
 ('goodstypebrand','00','58',1,'2010-06-25 12:48:21'),
 ('grade','00','3',1,'2010-06-25 12:48:21'),
 ('groupbuy','00','1',1,'2010-06-25 12:48:21'),
 ('helpcontent','00','9',1,'2010-06-25 12:48:21'),
 ('img','00','2',1,'2010-06-25 12:48:21'),
 ('imgtype','00','1',1,'2010-06-25 12:48:21'),
 ('invoiceprint','00','1',1,'2010-06-25 12:48:21'),
 ('invoicetemplete','00','7',1,'2010-06-25 12:48:21'),
 ('jshopbasicinfo','00','7',1,'2010-06-25 12:48:21'),
 ('jshophelp','00','8',1,'2010-06-25 12:48:21'),
 ('keyword','00','4',1,'2010-06-25 12:48:21'),
 ('location','00','1',1,'2010-06-25 12:48:21'),
 ('logbusarea','00','12',1,'2010-06-25 12:48:21'),
 ('logistics','00','6',1,'2010-06-25 12:48:21'),
 ('msgtext','00','1',1,'2010-06-25 12:48:21'),
 ('notice','00','3',1,'2010-06-25 12:48:21'),
 ('order','00','38',1,'2010-06-25 12:48:21'),
 ('orderaction','00','1',1,'2010-06-25 12:48:21'),
 ('orderinvoice','00','2',1,'2010-06-25 12:48:21'),
 ('organization','00','1',1,'2010-06-25 12:48:21'),
 ('origin','00','40',1,'2010-06-25 12:48:21'),
 ('pageeditarea','00','37',1,'2010-06-25 12:48:21'),
 ('pageinfo','00','4',1,'2010-06-25 12:48:21'),
 ('payment','00','9',1,'2010-06-25 12:48:21'),
 ('product','00','47',1,'2010-06-25 12:48:21'),
 ('productspecifications','00','10',1,'2010-06-25 12:48:21'),
 ('returngoods','00','1',1,'2010-06-25 12:48:21'),
 ('shippingaddress','00','44',1,'2010-06-25 12:48:21'),
 ('sitenavigation','00','10',1,'2010-06-25 12:48:21'),
 ('starcomment','00','1',1,'2010-06-25 12:48:21'),
 ('systemmail','00','14',1,'2010-06-25 12:48:21'),
 ('template','00','36',1,'2010-06-25 12:48:21'),
 ('templateset','00','20',1,'2010-06-25 12:48:21'),
 ('templatetheme','00','10',1,'2010-06-25 12:48:21'),
 ('unit','00','4',1,'2010-06-25 12:48:21'),
 ('user','00','24',1,'2010-06-25 12:48:21'),
 ('vouchers','00','2',1,'2010-06-25 12:48:21'),
 ('websitemsg','00','1',1,'2010-06-25 12:48:21');
/*!40000 ALTER TABLE `serial_t` ENABLE KEYS */;


--
-- Definition of table `shipping_address_t`
--

DROP TABLE IF EXISTS `shipping_address_t`;
CREATE TABLE `shipping_address_t` (
  `SHIPPINGADDRESSID` varchar(20) NOT NULL,
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PROVINCE` varchar(12) NOT NULL,
  `CITY` varchar(12) NOT NULL,
  `DISTRICT` varchar(12) NOT NULL,
  `STREET` varchar(100) NOT NULL,
  `POSTCODE` varchar(10) DEFAULT NULL,
  `TELNO` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(20) NOT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `CREATETIME` datetime NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `ISSEND` varchar(1) NOT NULL,
  `DELIVERADDRESSID` varchar(20) DEFAULT NULL,
  `ORDERID` varchar(20) DEFAULT NULL,
  `COUNTRY` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`SHIPPINGADDRESSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shipping_address_t`
--

/*!40000 ALTER TABLE `shipping_address_t` DISABLE KEYS */;
INSERT INTO `shipping_address_t` (`SHIPPINGADDRESSID`,`USERID`,`USERNAME`,`PROVINCE`,`CITY`,`DISTRICT`,`STREET`,`POSTCODE`,`TELNO`,`MOBILE`,`EMAIL`,`CREATETIME`,`STATE`,`ISSEND`,`DELIVERADDRESSID`,`ORDERID`,`COUNTRY`) VALUES 
 ('20110518001','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 14:27:23','2','0','20110518005','20110518001','中国'),
 ('201105180010','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:36:49','0','0','20110518005','20110518004','中国'),
 ('201105180011','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:44:22','0','0','20110518005','20110518005','中国'),
 ('201105180012','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:52:28','0','0','20110518005','20110518006','中国'),
 ('201105180013','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:06:04','0','0','20110518005','20110518007','中国'),
 ('201105180014','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:21:00','0','0','20110518005','20110518008','中国'),
 ('201105180015','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:49:35','0','0','20110518005','20110518009','中国'),
 ('201105180016','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:51:44','0','0','20110518005','201105180010','中国'),
 ('201105180017','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:54:53','0','0','20110518005','201105180011','中国'),
 ('201105180018','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 16:59:28','0','0','20110518005','201105180012','中国'),
 ('201105180019','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 17:21:49','2','0','20110518005','201105180013','中国'),
 ('20110518002','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 14:31:16','2','0','20110518005','20110518001','中国'),
 ('201105180020','20110518002','孟成','上海市','上海市','闵行区','都市路元江路1800号9号302','','58999999999','13999999999','','2011-05-18 17:27:03','0','0','20110518006','201105180014','中国'),
 ('201105180021','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 17:44:01','2','0','20110518005','201105180013','中国'),
 ('201105180022','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 17:51:53','1','0','20110518005','201105180013','中国'),
 ('201105180023','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 19:40:43','1','0','20110518005','201105180015','中国'),
 ('201105180024','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 19:53:51','1','0','20110518005','201105180016','中国'),
 ('201105180025','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 19:59:05','1','0','20110518005','201105180017','中国'),
 ('201105180026','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 20:10:59','1','0','20110518005','201105180018','中国'),
 ('201105180027','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 20:24:37','1','0','20110518005','201105180019','中国'),
 ('201105180028','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 20:25:12','1','0','20110518005','201105180020','中国'),
 ('201105180029','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 20:44:19','1','0','20110518005','201105180021','中国'),
 ('20110518003','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 14:38:17','2','0','20110518005','20110518001','中国'),
 ('201105180030','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 22:45:15','1','0','20110518005','201105180022','中国'),
 ('201105180031','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 23:22:45','1','0','20110518005','201105180023','中国'),
 ('201105180032','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 23:24:33','1','0','20110518005','201105180024','中国'),
 ('201105180033','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 23:35:51','1','0','20110518005','201105180025','中国'),
 ('20110518004','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 14:57:59','2','0','20110518005','20110518001','中国'),
 ('20110518006','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:00:08','0','0','20110518005','20110518001','中国'),
 ('20110518007','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:02:56','2','0','20110518005','20110518002','中国'),
 ('20110518008','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:04:16','0','0','20110518005','20110518002','中国'),
 ('20110518009','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-18 15:29:26','0','0','20110518005','20110518003','中国'),
 ('201105190034','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-19 10:00:50','1','0','20110518005','201105190026','中国'),
 ('201105200035','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-20 14:38:49','1','0','20110518005','201105200027','中国'),
 ('201105200036','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-20 15:52:51','1','0','20110518005','201105200028','中国'),
 ('201105200037','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-20 20:23:53','1','0','20110518005','201105200029','中国'),
 ('201105200038','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-20 20:32:19','1','0','20110518005','201105200030','中国'),
 ('201105240039','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-24 12:04:31','1','0','20110518005','201105240031','中国'),
 ('201105240040','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-24 14:12:41','1','0','20110518005','201105240032','中国'),
 ('201105240041','20100721002','陈达','河南省','安阳市','文峰区','都市路1800弄','','','13671892195','','2011-05-24 16:15:27','1','0','20110518005','201105240033','中国'),
 ('201201050042','201112130018','陈达','上海市','上海市','浦东新区','金桥路3068号','','','13671892195','','2012-01-05 10:49:36','1','0','201201050012','201201050034','中国'),
 ('201201050043','201112130018','陈达','上海市','上海市','浦东新区','金桥路3068号','','','13671892195','','2012-01-05 10:57:10','1','0','201201050012','201201050037','中国');
/*!40000 ALTER TABLE `shipping_address_t` ENABLE KEYS */;


--
-- Definition of table `site_navigation_t`
--

DROP TABLE IF EXISTS `site_navigation_t`;
CREATE TABLE `site_navigation_t` (
  `SNID` varchar(20) NOT NULL,
  `IS_TARGET_BLANK` varchar(1) NOT NULL,
  `IS_VISIBLE` varchar(1) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `POSITION` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `HTML_PATH` varchar(255) NOT NULL,
  `SORT` int(10) unsigned NOT NULL,
  `SIGN` varchar(45) NOT NULL,
  PRIMARY KEY (`SNID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `site_navigation_t`
--

/*!40000 ALTER TABLE `site_navigation_t` DISABLE KEYS */;
INSERT INTO `site_navigation_t` (`SNID`,`IS_TARGET_BLANK`,`IS_VISIBLE`,`NAME`,`POSITION`,`CREATETIME`,`CREATORID`,`HTML_PATH`,`SORT`,`SIGN`) VALUES 
 ('20111103001','1','1','首页','2','2012-03-13 00:00:00','20100721001','index.html',1,'index'),
 ('20111115009','1','0','粮油食品','2','2012-02-19 21:14:37','20100721001','html/default/shop/lytw_1.html',1,'1');
/*!40000 ALTER TABLE `site_navigation_t` ENABLE KEYS */;


--
-- Definition of table `system_mail_m`
--

DROP TABLE IF EXISTS `system_mail_m`;
CREATE TABLE `system_mail_m` (
  `SMAILID` varchar(20) NOT NULL,
  `SYS_SENDMAIL` varchar(100) NOT NULL,
  `SYS_MAIL_SMTP` varchar(100) NOT NULL,
  `SYS_MAIL_PORT` varchar(45) NOT NULL,
  `SMTPUSERNAME` varchar(100) NOT NULL,
  `SMTPPWD` varchar(100) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `USERID` varchar(100) NOT NULL,
  `NICK` varchar(100) NOT NULL,
  PRIMARY KEY (`SMAILID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `system_mail_m`
--

/*!40000 ALTER TABLE `system_mail_m` DISABLE KEYS */;
INSERT INTO `system_mail_m` (`SMAILID`,`SYS_SENDMAIL`,`SYS_MAIL_SMTP`,`SYS_MAIL_PORT`,`SMTPUSERNAME`,`SMTPPWD`,`STATE`,`USERID`,`NICK`) VALUES 
 ('201112120011','sdywcd@126.com','11','11','11','11','1','',''),
 ('201201050012','sdywcd@126.com','smtp.126.com','25','sdywcd','chenda121','0','20100721001',''),
 ('201201090013','1','11','1','11','1','0','20100721001','');
/*!40000 ALTER TABLE `system_mail_m` ENABLE KEYS */;


--
-- Definition of table `taobao_user_t`
--

DROP TABLE IF EXISTS `taobao_user_t`;
CREATE TABLE `taobao_user_t` (
  `taobao_userid` varchar(100) NOT NULL,
  `taobao_nick` varchar(100) NOT NULL,
  PRIMARY KEY (`taobao_userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `taobao_user_t`
--

/*!40000 ALTER TABLE `taobao_user_t` DISABLE KEYS */;
INSERT INTO `taobao_user_t` (`taobao_userid`,`taobao_nick`) VALUES 
 ('',''),
 ('114055901','sdywcd'),
 ('197247141','mc19870910'),
 ('317891891','june_happy军'),
 ('411723870','ruguokeyi1236'),
 ('85410189','ttzj5201314');
/*!40000 ALTER TABLE `taobao_user_t` ENABLE KEYS */;


--
-- Definition of table `template_t`
--

DROP TABLE IF EXISTS `template_t`;
CREATE TABLE `template_t` (
  `TID` varchar(20) NOT NULL,
  `URL` varchar(255) NOT NULL,
  `NOTE` varchar(100) NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `TYPE` varchar(1) DEFAULT NULL,
  `THEMEID` varchar(20) DEFAULT NULL,
  `THEMENAME` varchar(45) DEFAULT NULL,
  `TVALUE` longtext,
  `SIGN` varchar(100) DEFAULT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `template_t`
--

/*!40000 ALTER TABLE `template_t` DISABLE KEYS */;
INSERT INTO `template_t` (`TID`,`URL`,`NOTE`,`NAME`,`CREATETIME`,`CREATORID`,`TYPE`,`THEMEID`,`THEMENAME`,`TVALUE`,`SIGN`,`STATUS`) VALUES 
 ('201110190013','WEB-INF/theme/default/shop/footer.ftl','页脚','footer','2012-02-04 11:26:57','20100721001','1','20120203001','default','\n<body>\n<div id=\"footer\" class=\"fixed\">\n		<div id=\"service\">\n			\n			<#list footcategory as fc>\n					<dl class=\"fore1\">\n	                <dt>\n	                <b></b>\n	                <strong>${fc.name}</strong>\n	                </dt>\n	            	<dd>\n					\n	            	<#list footerarticle as fa>\n	                 <#if fc.articleCategoryTid=fa.articleCategoryTid>\n					 <div class=\"item\">\n	                	<#if fa.htmlPath! !=\"\">\n						<a href=\"${basePath}<@fa.htmlPath?interpret />\">${fa.title}</a>\n	                   </#if>\n					</div>\n					</#if>\n	               </#list>\n				  \n	            	</dd>\n	            	</dl>\n			</#list>\n			\n        </div>\n    \n        </div>\n <div id=\"dfooter\">\n 	<img src=\"${basePath}ui/default/images_green/footerlogo.jpg\" alt=\"\" />\n </div>	\n <div id=\"dfooter\" >		\n	Copyright &copy; 2011 www.soipay.com. All rights reserved. Design by <dy>\n<a href=\"http://www.ostocy.com/\">OSTOCY</a>.\n</div>\n\n','default_footer','1'),
 ('201110190014','WEB-INF/theme/default/shop/articlecontent.ftl','文章详细','articlecontent','2012-02-04 11:20:31','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>${article.title} Soipay帮助中心 - Powered By Soipay</title>\n	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n	<meta name=\"Author\" content=\"OSTOCY TEAM\" />\n	<meta name=\"Copyright\" content=\"JSHOP\" />\n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (article.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${article.metaKeywords}\" /></#if>\n	<#if (article.metaDescription)! != \"\"><meta name=\"description\" content=\"${article.metaDescription}\" /></#if>\n	<link rel=\"icon\" href=\"favicon.ico\" type=\"image/x-icon\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}/ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}/ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}/ui/default/css/tabs-accordion-usercenter.css\"/>\n  	<script type=\"text/javascript\"  src=\"${basePath}/ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}/ui/default/js/jquery.tools.min.js\"></script>\n\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}/ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n  <body>\n  <input id=\"hidurl\" name=\"hidurl\" value=\"\" type=\"hidden\"/>\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n	<div id=\"header_inner\" class=\"fixed\">\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n\n		   <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n	</div>\n</div>\n<div id=\"main\">\n	<div id=\"main_inner\" class=\"fixed\">\n		  <div id=\"top_main_inner\" class=\"fixed\">\n				<!--<jsp:include page=\"../../header.jsp\"></jsp:include>-->\n				\n		  </div>\n		  <div id=\"primaryContent_2columns\">\n				<div id=\"columnA_2columns\">\n						<div class=\"detail\">\n							<div class=\"title\">${article.title}</div>\n								<div class=\"blank\"></div>\n								<div class=\"info\">\n									<span class=\"createDate\">日期: ${article.createtime?string(\"yyyy-MM-dd HH: mm\")}</span>\n									<#if article.author??>\n										<span class=\"author\">作者: ${article.author}</span>\n									</#if>\n									点击: <span id=\"hits\"></span> 次\n									<span class=\"fontSize\">【<a id=\"changeBigFontSize\" href=\"javascript: void(0);\">大</a> <a id=\"changeNormalFontSize\" href=\"javascript: void(0);\">中</a> <a id=\"changeSmallFontSize\" href=\"javascript: void(0);\">小</a>】</span>\n								</div>\n								<div id=\"articleContent\" class=\"content\">\n									${article.contentvalue}\n									<div class=\"blank\"></div>\n								</div>\n						</div>\n				</div>\n		  </div>\n		  <div id=\"secondaryContent_2columns\">\n				<div id=\"columnC_2columns\">\n					<#include \"/WEB-INF/theme/default/shop/helprightmenu.ftl\">\n					\n				</div>\n		  </div>\n		  <br class=\"clear\" />\n	</div>\n\n</div>\n\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n	<!-- This JavaScript snippet activates those tabs -->\n<script>             \n$(function() { \n$(\"#accordion\").tabs(\"#accordion div.pane\", {tabs: \'h2\', effect: \'slide\', initialIndex: null});\n});\n</script>\n</body>\n\n</html>\n','default_articlecontent','1'),
 ('201110190015','WEB-INF/theme/default/shop/articlelist.ftl','文章列表','articlelist','2012-02-04 11:28:00','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>${articleCategory.name} Soipay帮助中心<#if setting.isShowPoweredInfo=\"1\"> - Powered By Soipay</#if></title>\n	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n	<meta name=\"Author\" content=\"OSTOCY TEAM\" />\n	<meta name=\"Copyright\" content=\"JSHOP\" />\n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (articleCategory.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${articleCategory.metaKeywords}\" /></#if>\n	<#if (articleCategory.metaDescription)! != \"\"><meta name=\"description\" content=\"${articleCategory.metaDescription}\" /></#if>\n	<link rel=\"icon\" href=\"favicon.ico\" type=\"image/x-icon\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}/ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}/ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}/ui/default/css/tabs-accordion-usercenter.css\"/>\n  	<script type=\"text/javascript\"  src=\"${basePath}/ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}/ui/default/js/jquery.tools.min.js\"></script>\n\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}/ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n  <body>\n  <input id=\"hidurl\" name=\"hidurl\" value=\"\" type=\"hidden\"/>\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n	<div id=\"header_inner\" class=\"fixed\">\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		<!-- 读取导航菜单 \n		  <s:action name=\"GetIndexMenu\" namespace=\"/jshop_system\" id=\"bean\" /> -->\n		  <div id=\"menu\">\n			<ul>\n				<!--<li><a href=\"<%=basePath %>index.jsp \" class=\"active\">首页</a></li>\n			    <s:if test=\"#bean.mainmenu!=null\">\n                <s:iterator id=\"bean\" value=\"#bean.mainmenu\" status=\"findindexmenu\">\n				<li><a href=\"<%=basePath %>goods/goodslist.jsp?navid=<s:property value=\"navid\"/>\" target=\"_blank\" class=\"active\"><s:property value=\"nname\"/></a></li>\n                </s:iterator>\n			    </s:if>-->\n				<@mainmenu_list mainmenu_navid=mainmenu.navid type=\"recommend\" count=mainmenucount;mainmenuList>\n					<#list mainmenuList as mmenu>\n						<li><a href=\"$(basePath)/index.jsp\" class=\"active\" title=\"首页\"</a></li>\n					</#list>\n				</@mainmenu_list>\n			</ul>\n		 </div>\n	</div>\n</div>\n<div id=\"main\">\n	<div id=\"main_inner\" class=\"fixed\">\n		  <div id=\"top_main_inner\" class=\"fixed\">\n				<!--<jsp:include page=\"../../header.jsp\"></jsp:include>-->\n				<#include \"../../header.jsp\">\n		  </div>\n		  <div id=\"primaryContent_2columns\">\n				<div id=\"columnA_2columns\">\n						<div class=\"detail\">\n							$(contentvalue)\n						</div>\n				</div>\n		  </div>\n		  <div id=\"secondaryContent_2columns\">\n				<div id=\"columnC_2columns\">\n					<!--<jsp:include page=\"helpcentermenu.jsp\"></jsp:include>-->\n					<#include \"helpcentermenu.jsp\">\n				</div>\n		  </div>\n		  <br class=\"clear\" />\n	</div>\n\n</div>\n<#include \"../../footer.jsp\">\n<#include \"/WEB-INF/template/shop/footer.ftl\">\n	<!-- This JavaScript snippet activates those tabs -->\n<script>             \n$(function() { \n$(\"#accordion\").tabs(\"#accordion div.pane\", {tabs: \'h2\', effect: \'slide\', initialIndex: null});\n});\n</script>\n</body>\n\n</html>\n','default_articlelist','1'),
 ('201110250016','WEB-INF/theme/default/shop/top_header.ftl','顶部内容','top_header','2012-02-04 11:19:04','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n  <head>\n	<!--\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n	-->\n<!--[if IE 6]>\n	<style>\n	/* tooltip styling */\n	.tooltip {\n		/*display:none;*/\n		background:url(http://static.flowplayer.org/tools/img/tooltip/black_arrow_big.png);\n		height:163px;\n		padding:40px 30px 10px 30px;\n		width:310px;\n		font-size:11px;\n		color:#fff;\n		position:absolute;\n		z-index:999;\n		float:left;\n		margin-left:50px;\n	}\n	</style>\n	<![endif]-->\n<style>\n\n/* trigger button */\n#download_now {\n	/*background:transparent url(/img/home/download.png) no-repeat scroll 0 0;\n	display:block;\n	height:44px;\n	margin-bottom:30px;\n	overflow:hidden;\n	text-indent:-999em;\n	width:159px;\n	cursor:pointer;*/\n}\n\n/* mouseover state */\n#download_now:hover {\n	/*background-position:0 -44px ;	*/	\n}\n\n/* clicked state */\n#download_now:focus {\n	/*background-position:0 -88px;*/\n}\n\n/* tooltip styling */\n.tooltip {\n	display:none;\n	background:#fff;\n	height:163px;\n	padding:40px 30px 10px 30px;\n	width:310px;\n	font-size:12px;\n	color:#000;\n	position:absolute;\n	z-index:999;\n	float:left;\n	margin-left:870px !important;\n	overflow:scroll;\n	overflow-x:hidden;\n	scrollbar-face-color:#DEDEDE;\n	 scrollbar-base-color:#F5F5F5;\n	 scrollbar-arrow-color:black;\n	 scrollbar-track-color:#F5F5F5;\n	 scrollbar-shadow-color:#EBF5FF;\n	 scrollbar-highlight-color:#F5F5F5;\n	 scrollbar-3dlight-color:#C3C3C3;\n	 scrollbar-darkshadow-Color:#9D9D9D;\n}\n\n/* a .label element inside tooltip */\n.tooltip .label {\n	color:yellow;\n	width:35px;\n}\n\n.tooltip a {\n	color:#ad4;\n	font-size:11px;\n	font-weight:bold;\n}\n</style>\n\n<body>\n\n<!-- 读取购物车数据 \n<s:if test=\"#session.user!=null&&#session.usercart==null\">\n	<s:action name=\"findAllCartByUserIdFortopCart\" namespace=\"/jshop_system\" id=\"bean\" /> \n</s:if>\n-->\n	<ul>\n		<li><a href=\"${basePath}index.html\">欢迎来到${(jshopbasicinfo.jshopname)}</a></li>\n        <li><a href=\"${basePath}html/default/shop/register.html\" class=\"active\">【请注册】</a></li>\n      	<li><span>新用户？</span></li>\n        <li><a href=\"${basePath}html/default/shop/login.html\" >【请登录】</a></li>\n       \n        <li><a href=\"InitUserCenterIndex.action\">我的Soipay</a></li>\n         <#if Session[\"usercart\"]?exists>\n	\n        <li><a id=\"download_now\" href=\"findAllCartByUserId.action\">购物车$(Session.usercart.count)</a></li>\n  \n        <li><a id=\"download_now\" href=\"findAllCartByUserId.action\">购物车[0]</a></li>\n        </#if>\n        <li><a href=\"findAllUserOrderOn.action\">我的订单</a></li>\n		\n	\n			<#list siteNavigationList as navigation>\n				<#if navigation.position=\"1\">\n				<li>\n					<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n					 <#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if>>${navigation.name}\n					</a>|\n				</li>\n				</#if>\n				<#if navigation_has_next></#if>\n				\n			</#list>\n	\n		\n    </ul>\n    \n\n<!-- tooltip element \n<br class=\"clear\"/>\n <div id=\"cartmark\" class=\"tooltip\">\n 			<s:if test=\"#session.usercart!=null\">\n 			<s:iterator id=\"bean\" value=\"#session.usercart.cart\" status=\"usercart\">\n 		\n			<div style=\"margin:0\">\n				<img style=\"float:left;margin:0 15px 20px 0\" width=\"80px\" height=\"80px\" src=\"<%=basePath %>Uploads/<s:property value=\"picture\"/>\"/>\n				<dl>\n					<dd ><s:property value=\"goodsname\"/></dd>\n				</dl>\n		\n				<dl>\n					<dd>单价￥<s:property value=\"favorable\"/></dd>\n				</dl>\n				<dl>\n					<dd ><s:property value=\"needquantity\"/>件</dd>\n				\n				</dl>\n				<dl>\n					<dd><a href=\"findAllCartByUserId.action\">管理并结算</a></dd>\n				</dl>		\n			</div>\n			\n			<br class=\"clear\"/>\n				\n 			</s:iterator>\n			</s:if>\n		</div>\n\n-->\n\n   \n</body>\n</html>\n','default_top_header','1'),
 ('201111030018','WEB-INF/theme/default/shop/goodsdetail.ftl','商品详细','goodsdetail','2012-02-04 11:12:44','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>${(goodsdetail.goodsname)}</title>\n	<meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n    <#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/cssreset.css\"/>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/goodshow.css\"/>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/jqzoom.css\"/>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/detailtabs.css\"/>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.jqzoom.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.dimensions.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.sexy-vote.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}jshop/admin/js/kindeditor-min.js\"></script>\n	\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n	\n	<script language=\"javascript\" type=\"text/javascript\">\n\n$(function() {\n$(\".myImages\").jqueryzoom({\n				xzoom:300, //zooming div default width(default width value is 200)\n				yzoom: 300, //zooming div default width(default height value is 200)\n				offset: 10, //zooming div default offset(default offset value is 10)\n				position: \"left\", //zooming div position(default position value is \"right\")\n 				preload:1,\n				lens:1\n			});\n\n\n});\n\n	jQuery.fn.loadthumb = function(options) {\n		options = $.extend({\n			 src : \"\"\n		},options);\n		var _self = this;\n		_self.hide();\n		var img = new Image();\n		$(img).load(function(){\n			_self.attr(\"src\", options.src);\n			_self.fadeIn(\"slow\");\n		}).attr(\"src\", options.src);  //.atte(\"src\",options.src)要放在load后面，\n		return _self;\n	}\n	\n	\n\n  $(function(){\n	  var i = 5;  //已知显示的<a>元素的个数\n	  var m = 5;  //用于计算的变量\n      var $content = $(\"#myImagesSlideBox .scrollableDiv\");\n	  var count = $content.find(\"a\").length;//总共的<a>元素的个数\n	  //下一张\n	  $(\".next\").live(\"click\",function(){\n			var $scrollableDiv = $(this).siblings(\".items\").find(\".scrollableDiv\");\n			if( !$scrollableDiv.is(\":animated\")){  //判断元素是否正处于动画，如果不处于动画状态，则追加动画。\n				if(m<count){  //判断 i 是否小于总的个数\n					m++;\n					$scrollableDiv.animate({left: \"-=50px\"}, 600);\n				}\n			}\n			return false;\n	  });\n	   //上一张\n	  $(\".prev\").live(\"click\",function(){\n			var $scrollableDiv = $(this).siblings(\".items\").find(\".scrollableDiv\");\n			if( !$scrollableDiv.is(\":animated\")){\n				if(m>i){ //判断 i 是否小于总的个数\n					m--;\n					$scrollableDiv.animate({left: \"+=50px\"}, 600);\n				}\n			}\n			return false;\n	  });\n\n	  $(\".scrollableDiv a\").live(\"click\",function(){\n\n			var src = $(this).find(\"img\").attr(\"imgb\");\n			var bigimgSrc = $(this).find(\"img\").attr(\"bigimg\");\n			$(this).parents(\".myImagesSlideBox\").find(\".myImgs\").loadthumb({src:src}).attr(\"bigimg\",bigimgSrc);\n			$(this).parents(\".myImagesSlideBox\").find(\".myImgs\").loadthumb({src:src}).attr(\"jqimg\",bigimgSrc);\n			$(this).addClass(\"active\").siblings().removeClass(\"active\");\n	  });\n	  $(\".scrollableDiv a:nth-child(1)\").trigger(\"click\");\n		\n	  $(\".myTxts a\").live(\"click\",function(){\n			var bigimgSrc =$(this).parents(\".myImagesSlideBox\").find(\".myImgs\").attr(\"bigimg\");\n			popZoom( bigimgSrc , \"500\" , \"500\");\n			return false;\n	  });\n\n		//以新窗口的方式打开图片\n		var windowWidth  =$(window).width();\n		var windowHeight  =$(window).height();\n		function popZoom(pictURL, pWidth, pHeight) {\n			var sWidth = windowWidth;\n			var sHeight = windowHeight;\n			var x1 = pWidth;\n			var y1 = pHeight;\n			var opts = \"height=\" + y1 + \",width=\" + x1 + \",left=\" + ((sWidth-x1)/2) +\",top=\"+ ((sHeight-y1)/2)+\",scrollbars=0,menubar=0\";\n			pZoom = window.open(\"\",\"\", opts);\n			pZoom.document.open();\n			pZoom.document.writeln(\"<html><body bgcolor=\\\"skyblue\\\"\" +\" onblur=\'self.close();\' style=\'margin:0;padding:0;\'>\");\n			pZoom.document.writeln(\"<img src=\\\"\" + pictURL + \"\\\" width=\\\"\" +pWidth + \"px\\\" height=\\\"\" + pHeight + \"px\\\">\");\n			pZoom.document.writeln(\"</body></html>\");\n			pZoom.document.close();\n		} \n		\n		/*关闭遮罩层*/\n		$(\".closeMyDiv a\").live(\"click\",function(){\n			$(\"#MyDiv\").empty().hide();\n			$(\"#BigDiv\").hide();\n			return false;\n		}).focus(function(){\n			$(this).blur();\n			return false;\n		});\n\n		/*使用遮罩层*/\n		$(\"#myImagesSlideBox .myImages img\").click(function(){\n			/*遮罩层居中 和 宽度 高度设置 */\n			$(\"#BigDiv\").css({\n						width:  $(\"body\").width() , \n						height: (   $(\"body\").height()  >  $(\"html\").height() ) ? $(\"body\").height() : $(\"html\").height()  \n					});\n			$(\"#MyDiv\").css({left: (($(window).width()-300)/2)  ,top: (($(window).height()-390)/2)  });\n\n			var $myDiv = $(\"#MyDiv\").html( $(\"#myImagesSlideBox\").html() ).show();\n			$(\'<div class=\"closeMyDiv\"><a href=\"#\">关闭</a></div>\').prependTo( $myDiv );\n			$(\"#BigDiv\").show();\n			return false;\n		});\n  })\n</script>\n	\n	\n  </head>\n  \n<body>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<jsp:include page=\"../header.jsp\"></jsp:include>\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n			\n			\n				<#if (goodsdetail??)&&(goodsdetail?size>0)>\n				<div id=\"detailmenu\"><img width=\"15px\" height=\"15px\" src=\"${basePath}ui/default/images_green/smallhouse.png\"/><span>></span>所有分类<span>></span>${goodsdetail.nname}<span>></span>${goodsdetail.lname}</div>\n			\n				<div class=\"title\">${goodsdetail.goodsname}</div>\n					<div id=\"myImagesSlideBox\" class=\"myImagesSlideBox\">\n                             <div class=\"myImages\">\n                             <#list goodsdetail.pictureurl?split(\",\") as img>\n							 \n                             <img src=\"${basePath}${img}\" class=\"myImgs\" bigimg=\"${basePath}${img}\"  jqimg=\"${basePath}${img}\">\n                             </img>\n                            \n							 </#list>\n                             </div> \n                         <div class=\"myTxts\">\n                         <a href=\"#\">在新窗口查看大图.</a>\n                         </div>\n                         <div id=\"scrollable\">\n                            <a class=\"prev\" href=\"#\" title=\"上一张\"></a>\n                            <div class=\"items\" >\n                                <div class=\"scrollableDiv\">\n                                	<#list goodsdetail.pictureurl?split(\",\") as img>\n                                    <a><img src=\"${basePath}${img}\" imgb=\"${basePath}${img}\"  bigimg=\"${basePath}${img}\" ></a>\n                					</#list>\n                                </div>\n                                <br clear=\"all\"/>            \n                            </div>\n                            <a class=\"next\" href=\"#\" title=\"下一张\"></a>\n                        </div>\n					</div>\n\n					<div class=\"goodsinfo\">\n						\n						<ul class=\"dt_info\">\n							<li>商品编码：${goodsdetail.usersetnum}</li>\n							<p >\n							soipay价：<span class=\"soipayprice\">￥${goodsdetail.memberprice}</span><br class=\"clear\"/>\n							市场价：<span><del  class=\"marketprice\">￥${goodsdetail.price}</del></span>\n							</p>\n							<div class=\"buy\">\n							\n							<p>\n								我要买<input id=\"needquantity\" name=\"needquantity\" value=\"1\" size=\"5\"/>件\n									\n							</p>\n							<p>\n								<input type=\"button\" name=\"addcart\" id=\"addcart\" value=\"\"/>\n								<input type=\"button\" name=\"addfav\" id=\"addfav\" value=\"\"/>\n								<span id=\"addfavok\"></span>\n								<!-- 隐藏的goodsid -->\n								<input type=\"hidden\" id=\"hidgoodsid\" name=\"hidgoodsid\" value=\"${goodsdetail.goodsid}\"/>\n								<input type=\"hidden\" id=\"hidgoodsname\" name=\"hidgoodsname\" value=\"${goodsdetail.goodsname}\"/>\n								<input type=\"hidden\" id=\"hidreadcount\" name=\"hidreadcount\" value=\"${goodsdetail.readcount}\"/>\n								<input type=\"hidden\" id=\"hidprice\" name=\"hidprice\" value=\"${goodsdetail.price}\"/>\n								<input type=\"hidden\" id=\"hidpictureurl\" name=\"hidpictureurl\" value=\"${goodsdetail.pictureurl}\">\n                                                                <input type=\"hidden\" id=\"hidhtmlpath\" name=\"hidhtmlpath\" value=\"${goodsdetail.htmlPath}\">\n								<input type=\"hidden\" id=\"hidmemberprice\" name=\"hidmemberprice\" value=\"${goodsdetail.memberprice}\"/>\n							</p>\n						\n							</div>\n						\n							<li>毛重：${goodsdetail.weight}${goodsdetail.unitname}</li>\n							<li>品牌：${goodsdetail.brandname}</li>\n							<li class=\"comments\">浏览：${goodsdetail.readcount}次</li>\n							 <li class=\"comments\">商品评分：\n							 	<span>\n				\n	                        	<#if goodsdetail.star=1><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif goodsdetail.star=2><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img  class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif goodsdetail.star=3><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif goodsdetail.star=4><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#else><img class=\"goodsstar\"  src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /></#if>\n	                   \n								</span>\n	                        	(已有${goodsdetail.totalcomment}条买家评分)\n							 </li>\n							<li>库存：\n							<#if (goodsdetail.quantity>0)>\n							有货\n							<#else>\n							缺货\n							</#if>\n							</li>\n							\n							<#if goodsgift??&&goodsgift?size>0> \n								<#list goodsgift as gg>\n									<!--<li><a href=\"GetGoodsgiftBygoodsid.action?goodsid=<s:property value=\"goodsid\"/>&gifid=<s:property value=\"gifid\"/>\"><font size=\"3\"><s:property value=\"giftitle\"/></font></a></li>-->\n		    	  				</#list>\n							</#if>\n							\n						</ul>	\n					\n						<br/>\n						<!-- JiaThis Button BEGIN -->\n						<div id=\"ckepop\">\n							<span class=\"jiathis_txt\">分享到：</span>\n							<a class=\"jiathis_button_qzone\">QQ空间</a>\n							<a class=\"jiathis_button_tsina\">新浪微博</a>\n							<a class=\"jiathis_button_renren\">人人网</a>\n							<a class=\"jiathis_button_kaixin001\">开心网</a>\n							<a href=\"http://www.jiathis.com/share\" class=\"jiathis jiathis_txt jiathis_separator jtico jtico_jiathis\" target=\"_blank\">更多</a>\n							<a class=\"jiathis_counter_style\"></a>\n						</div>\n						<script type=\"text/javascript\" src=\"http://v2.jiathis.com/code/jia.js\" charset=\"utf-8\"></script>\n						<!-- JiaThis Button END -->\n					\n\n					</div>\n				<br class=\"clear\" />\n				\n				<div class=\"righttitle\">商品详细</div>\n				<div class=\"detail\">\n				${goodsdetail.detail}\n				</div>\n				</#if>\n				\n				<br class=\"clear\" />\n				\n				\n				<div id=\"goodcommentarea\"></div>\n				\n\n				<br class=\"clear\" />\n				<!-- the tabs -->\n				<ul class=\"tabs\">\n					<li><a href=\"#first\">我要评论</a></li>\n					<li><a href=\"#second\">商品咨询</a></li>\n				</ul>\n				\n				<!-- tab \"panes\" -->\n				<div class=\"panes\">\n					\n					<div>\n						<p id=\"vote\"></p>\n						\n						<p id=\"scorefield\"></p>\n						\n						\n						<p id=\"goodscommentp\">\n						<textarea id=\"commentcontent\" name=\"commentcontent\" cols=\"100\" rows=\"8\" style=\"width:870px;height:200px;visibility:hidden;\"></textarea>\n						<input id=\"addgoodscomment\" name=\"addgoodscomment\" type=\"button\" value=\"提交评论\"/>\n						</p>\n						<input  type=\"hidden\" id=\"hidurl\" name=\"hidurl\" value=\"\"/>\n						\n						\n					</div>\n					<!--  -->\n					<div>\n				\n						<p>我要咨询：</p>\n						<p >\n						<textarea id=\"goodconsult\" name=\"goodconsult\" cols=\"100\" rows=\"8\" style=\"width:870px;height:200px;visibility:hidden;\"></textarea>\n						\n						 <input type=\"hidden\" id=\"hidurl\" name=\"hidurl\"/>\n						<input id=\"question\" name=\"question\" type=\"button\" value=\"提交咨询\"/>\n						</p>		\n					</div>\n					\n				</div>\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n				<div id=\"goodscookiearea\"></div>\n				\n\n				\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n<script type=\"text/javascript\">\n$(function() {\n	// setup ul.tabs to work as tabs for each div directly under div.panes\n	$(\"ul.tabs\").tabs(\"div.panes > div\");\n	\n	 $(\"#vote\").sexyVote();\n	\n		\n	KE.show({\n				id : \'commentcontent\',\n				resizeMode : 1,\n				allowPreviewEmoticons : false,\n				allowUpload : false,\n				items : [\n				\'fontname\', \'fontsize\', \'|\', \'textcolor\', \'bgcolor\', \'bold\', \'italic\', \'underline\',\n				\'removeformat\', \'|\', \'justifyleft\', \'justifycenter\', \'justifyright\', \'insertorderedlist\',\n				\'insertunorderedlist\', \'|\', \'emoticons\', \'image\', \'link\']\n			});\n	\n	KE.show({\n				id : \'goodconsult\',\n				resizeMode : 1,\n				allowPreviewEmoticons : false,\n				allowUpload : false,\n				items : [\n				\'fontname\', \'fontsize\', \'|\', \'textcolor\', \'bgcolor\', \'bold\', \'italic\', \'underline\',\n				\'removeformat\', \'|\', \'justifyleft\', \'justifycenter\', \'justifyright\', \'insertorderedlist\',\n				\'insertunorderedlist\', \'|\', \'emoticons\', \'image\', \'link\']\n			});\n	\n});\n</script>\n\n\n    <jsp:include page=\"../footer.jsp\"></jsp:include>\n    <script type=\"text/javascript\" src=\"${basePath}ui/default/js/goodsdetailjs.js\"></script>\n  </body>\n</html>\n\n','default_goodsdetail','1'),
 ('201111030021','WEB-INF/theme/default/shop/login.ftl','用户登录','login','2012-02-04 11:18:33','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n\n    <base href=\"${basePath}\">\n    \n    <title>${(jshopbasicinfo.jshopname)}用户登录</title>\n	<meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/form.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/easyvalidator/css/validate.css\" />\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}js/jquery.query.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyvalidator/js/easy_validator.pack.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyvalidator/js/jquery.bgiframe.min.js\"></script>\n\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n<body>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n \n      </div>\n      \n     <div id=\"primaryContent_columnless\">\n\n			<div id=\"columnA_columnless\">\n				<div class=\"register\">\n				<h3>${(jshopbasicinfo.jshopname)}用户登录</h3>\n				\n				<div id=\"myform_register\">\n      			<p>\n         			<label>用户名称*</label>\n         		    \n         			<input type=\"text\" id=\"username\" name=\"username\"  reg=\"^\\w{6,20}$\" tip=\"请输入用户名称\"  size=\"40\"  maxlength=\"40\"></input><br/>\n      			\n      				<label>用户密码*</label>\n         		    \n         			<input type=\"password\" id=\"password\" name=\"password\"  reg=\"^\\w{6,20}$\" tip=\"请输入用户密码\"   size=\"40\"   maxlength=\"40\"></input><br/>\n      			</p>\n      			<input type=\"button\" id=\"submit\" name=\"submit\" value=\"登录\"/>\n      			<input type=\"button\" id=\"register\" name=\"register\" value=\"我要注册\"/>\n      			</div>\n				</div>\n			</div>\n		</div>\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n    <script>\n\n$.tools.validator.fn(\"[data-equals]\", \"\", function(input) {\n	var name = input.attr(\"data-equals\"),\n		 field = this.getInputs().filter(\"[name=\" + name + \"]\"); \n	return input.val() == field.val() ? true : [name]; \n});\n\n// supply the language\n$.tools.validator.localize(\"fi\", {\n	\'[required]\'	: \'该项必须填写\',\n});\n\n// use the finnish language in the validator\n$(\"#myform_register\").validator({ lang: \'fi\' });\n\n</script>\n	<script type=\"text/javascript\" src=\"${basePath}js/loginjs.js\"></script>\n  </body>\n</html>\n','default_login','1'),
 ('201111030022','WEB-INF/theme/default/shop/register.ftl','用户注册','register','2012-02-04 11:14:06','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n<html>\n  <head>\n    <title>${(jshopbasicinfo.jshopname)}用户注册</title>\n   <meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/form.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/easyvalidator/css/validate.css\" />\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.query.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyvalidator/js/easy_validator.pack.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyvalidator/js/jquery.bgiframe.min.js\"></script>\n	\n	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n	  <script type=\"text/javascript\"> \n		  $(function(){\n		    var timenow = new Date().getTime();	       \n	         $(\'#random\').attr(\"src\",\"randomchecknum.action?d=\"+timenow);  \n		  });\n		  \n	     function changeValidateCode(obj) {  \n	         var timenow = new Date().getTime();	       \n	         obj.src=\"randomchecknum.action?d=\"+timenow;  \n	     }\n		 var isExtendsValidate = true;	//如果要试用扩展表单验证的话，该属性一定要申明\nfunction extendsValidate(){	//函数名称，固定写法\n	\n	//密码匹配验证\n	if( $(\'#password\').val() == $(\'#rpassword\').val() ){	//匹配成功\n		$(\'#rpassword\').validate_callback(null,\"sucess\");	//此次是官方提供的，用来消除以前错误的提示\n	}else{//匹配失败\n		$(\'#rpassword\').validate_callback(\"密码不匹配\",\"failed\");	//此处是官方提供的API，效果则是当匹配不成功，pwd2表单 显示红色标注，并且TIP显示为“密码不匹配”\n		return false;\n	}\n	\n\n	\n	\n}\n      </script>  \n  </head>\n  \n<body>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n		<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n \n      </div>\n      \n     <div id=\"primaryContent_columnless\">\n\n			<div id=\"columnA_columnless\">\n				<div class=\"register\">\n				<h3>${(jshopbasicinfo.jshopname)} 用户注册</h3>\n				<div id=\"msg\"></div>\n				<form id=\"myform_register\" name=\"register\" action=\"register.action\" method=\"post\">\n      			<p>\n         			<label>用户名称*</label>\n         		    \n         			<input type=\"text\" id=\"username\" name=\"username\"  reg=\"^\\w{6,20}$\" size=\"40\" tip=\"6-20个字符建议使用您的邮箱或者手机号码不允许中文字符\"  maxlength=\"40\"></input><br/>\n      			\n      				<label>用户密码*</label>\n         		    \n         			<input type=\"password\" id=\"password\" name=\"password\"  reg=\"^\\w{6,20}$\" tip=\"6-20个非中文字符\" size=\"40\" maxlength=\"40\"></input><br/>\n      			\n      				<label>重复密码*</label>\n         		    \n         			<input type=\"password\" id=\"rpassword\" name=\"rpassword\"  reg=\"^\\w{6,20}$\" tip=\"6-20个非中文字符，请确认两次密码输入相同\" size=\"40\" maxlength=\"40\"></input><br/>\n      			\n      				<label>邮箱*</label>\n         		    \n         			<input type=\"email\" id=\"email\" name=\"email\"  reg=\"^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$\" tip=\"邮箱地址，如ostocy@sina.com\"  size=\"60\" maxlength=\"60\"></input><br/>\n         			<label>验证码*</label>\n         			<input type=\"text\" id=\"rand\" name=\"rand\"  reg=\"[^0]\" tip=\"请输入右边的验证码\"/><span><img id=\"random\" src=\"rand.action\" onclick=\"changeValidateCode(this)\"/></span><br/>\n      			</p>\n      			<p>\n      				\n      			</p>\n      			<input type=\"submit\" id=\"submit\" name=\"submit\" value=\"提交\"/>\n      			<input type=\"reset\" id=\"reset\" name=\"reset\" value=\"重置所有\"/>\n      			</form>\n      			\n				</div>\n				\n		\n		\n			</div>\n	\n		</div>\n\n\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n <script type=\"text/javascript\" src=\"${basePath}js/registerjs.js\"></script>   \n  </body>\n</html>\n','default_register','1'),
 ('201111030023','WEB-INF/theme/default/shop/index.ftl','主页模板','index','2012-03-13 00:00:00','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n<html>\n  <head>\n    <title>${(jshopbasicinfo.jshopname)}</title>\n	<meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/style.css\" />\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/easyslider1.7/css/screen.css\"/>\n  	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs.css\"/>\n  	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion.css\"/>\n  	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery-1.6.2.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyslider1.7/js/easySlider1.7.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n        \n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"//ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n  <body>\n\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>${(jshopbasicinfo.jshopname)}</h2><!--商城名称-->\n		</div>\n        <div id=\"header_left\">\n        	<ul>\n            	<li class=\"en\">ID</li>\n            	<li><input type=\"text\" id=\"username\" name=\"username\" value=\"\"/></li>\n            	<li class=\"en\">PW</li>\n                <li><input type=\"password\" id=\"password\" name=\"password\" value=\"\"/></li>\n                <li><input type=\"button\" class=\"lbutton\" id=\"login\" name=\"login\" value=\"LOGIN\"/></li>\n        		<li class=\"loginlink\"></li>\n                <li ><a href=\"#\">登录</a></li>\n                <li class=\"registerlink\"></li>\n                <li><a href=\"#\">注册</a></li>\n        </div>\n  </div>\n   \n</div>\n<div id=\"header_menu\" class=\"fixed\">\n <div id=\"menu\">\n			<div class=\"menu_right\">\n            	<ul>\n                	<li class=\"hi\"></li>\n                    <li class=\"hiword\">欢迎光临！这里是欧斯塔克商城</li>\n                </ul>\n                <ul>\n				\n                	\n					<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li class=\"right\">\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"right\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n					</#list>\n                </ul>\n               \n                \n           </div>\n           <div id=\"top_main_inner\">\n				<div class=\"search\">\n                	<span>SEARCH</span>\n					<input type=\"text\" class=\"text\" id=\"goodsname\" name=\"goodsname\" />\n					<input type=\"submit\" class=\"button\" value=\"\" />\n	 	    </div>\n        	<div class=\"keywords\">\n            	<ul>\n                	<li><a href=\"#\">宏基</a></li>\n                    <li><a href=\"#\">宏基</a></li>\n                    <li><a href=\"#\">宏基</a></li>\n                    <li><a href=\"#\">宏基</a></li>\n                    <li><a href=\"#\">宏基</a></li>\n                </ul>\n            </div>      \n       		</div>\n            \n            \n		 </div>\n\n</div>\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	 \n	  <div id=\"primaryContent_3columns\">\n			<div id=\"columnA_3columns\">\n			 <div class=\"category\" >\n                                 <ul  id=\"categoryvalue\">\n					<#list goodsCategoryTree as firstGoodsCategory>\n					<#if firstGoodsCategory.grade==\'0\'>\n					<li><a target=\'_blank\' href=\"${basePath}${firstGoodsCategory.htmlpath}\">${firstGoodsCategory.name}</a>\n						<div class=\"cms_submenu\">\n                                                <div class=\"cmsmenuleft\">\n                                                    <dl class=\"menu_recommend\">\n                                                     <dt>热门类目</dt>\n                                                     <dd>\n                                                     <#list goodsCategoryTree as secondGoodsCategory>\n                                                     <#if secondGoodsCategory.parentId! !=\"\">\n						     <#if secondGoodsCategory.parentId=firstGoodsCategory.goodsCategoryTid>\n													<#if secondGoodsCategory.htmlpath! !=\"\">\n                                                     <i><a href=\"${basePath}<@secondGoodsCategory.htmlpath?interpret />\">${secondGoodsCategory.name}</a></i>\n													 </#if>\n                                                     </#if>\n					             </#if>\n					             </#list>\n                                                     </dd>\n                                                     <div class=\"clear\"></div>\n                                                    </dl>\n                                                    <dl class=\"menu_price\">\n                                                        <div class=\"clear\"></div>\n                                                    </dl>\n                                                    <dl class=\"menu_new\"></dl>\n                                               </div>  \n                                               <div class=\"cmsmenuright\">\n                                                  <dl></dl>\n                                               </div>\n                        </div>\n					</li>\n					</#if>\n                                        <#if firstGoodsCategory_index+1==goodsCategoryTreeFirstCount>\n					        <#break/>\n					       </#if>\n					</#list>\n                                </ul>\n				</div>\n				\n                <!-- 2号自定义区域 -->\n                <div id=\"edit2\">\n				<#if p2! !=\"\">\n				<div id=\"specialarea\">\n                	<div id=\"area2title\" class=\"normaltitle\"><!--新品推荐-->${p2.editareatitle}</div>\n                    <div class=\"xpbg\">\n                		<div id=\"area2\">\n                        	${p2.editareavalue}\n							\n                        </div>\n                     </div>\n                </div>\n				</#if>\n                </div>\n               	<!-- 3号自定义区域 -->\n                <div id=\"edit3\">\n				<#if p3! !=\"\">\n				<div id=\"brand\">\n				\n					<div id=\"area3title\" class=\"normaltitle\">${p3.editareatitle}<!--品牌推荐--></div>\n						<div id=\"area3\">\n						<ul>\n						${p3.editareavalue} \n                        </ul>\n                        </div>\n               \n				</div>\n				</#if>\n                </div>\n			    <br  class=\"clear\"/>\n                \n				\n			</div>\n		\n			\n		</div>\n		\n		<div id=\"secondaryContent_3columns\">\n			\n			<div id=\"columnB_3columns\">\n            	<!-- 4号编辑区域 -->\n            	<div id=\"edit4\">\n				<#if p4! !=\"\">\n	              <div id=\"container\">\n	            		<div id=\"content\">\n	            		\n	            			<div id=\"area4\">\n	                  		<div id=\"slider\">\n	                    		<ul>\n									${p4.editareavalue}								\n	                    		</ul>\n                            \n	                		</div>\n	                		</div>\n	            		</div>\n				   </div>\n				   </#if>\n                   </div>\n				<br class=\"clear\"/>\n                <!--5号编辑区域-->\n				<div id=\"edit5\">\n				<#if p5! !=\"\">\n				${p5.editareavalue}\n				 </#if>\n        		 </div>\n                <!-- 6号编辑区域 -->\n                <div id=\"edit6\">\n				<#if p6! !=\"\">\n					${p6.editareavalue}\n              \n				</#if>\n             	</div>\n                <br  class=\"clear\"/>\n                <!-- 7号编辑区域 -->\n                <div id=\"edit7\">\n				<#if p7! !=\"\">\n				${p7.editareavalue}\n				</#if>\n					\n                </div>\n 				 <br  class=\"clear\"/>\n				\n	</div>\n	<div id=\"columnC_3columns\">\n				<!--8号编辑区域-->\n                <div id=\"edit8\">\n				<#if p8! !=\"\">\n				${p8.editareavalue}\n				\n				</#if>\n                </div>\n				<!-- 9 号编辑区域-->\n                <div id=\"edit9\">\n				<#if p9! !=\"\">\n				${p9.editareavalue}\n				\n				</#if>\n                </div>\n				\n				<!--10号编辑区域-->\n                <div id=\"edit10\">\n				<#if p10! !=\"\">\n				${p10.editareavalue}\n \n				</#if>\n				</div>\n            \n			</div>\n</div>\n\n\n\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n\n<script>\n\n// add new effect to the tabs\n$.tools.tabs.addEffect(\"slide\", function(i, done) {\n\n	// 1. upon hiding, the active pane has a ruby background color\n	this.getPanes().slideUp().css({backgroundColor: \"#fff\"});\n\n	// 2. after a pane is revealed, its background is set to its original color (transparent)\n	this.getPanes().eq(i).slideDown(function()  {\n		$(this).css({backgroundColor: \'transparent\'});\n\n		// the supplied callback must be called after the effect has finished its job\n		done.call();\n	});\n});\n$(function(data){\n/*商品tabs*/\n		 // setup ul.tabs to work as tabs for each div directly under div.panes\n        $(\"ul.tabs\").tabs(\"div.panes > div\");\n        \n		/*首页互动sliderjs*/\n		$(\"#slider\").easySlider({\n			auto: true, \n			continuous: true,\n			numeric: true,\n			controlsText:\'Dell笔记本促销,SonyPSP新品发售,苹果iPad3发布\',\n		});\n});\n\n</script>\n   \n</body>\n</html>\n','default_index','1'),
 ('201111140024','WEB-INF/theme/default/shop/helprightmenu.ftl','帮助中心右侧导航','helprightmenu','2012-02-04 11:20:14','20100721001','1','20120203001','default','\n<div id=\"area8title\" class=\"normaltitle\">soipay帮助中心</div>\n				<!-- accordion -->\n				<div id=\"accordion\">\n				<#list footcategory as fc>\n					<h2 class=\"current\">${fc.name}</h2>\n					<div class=\"pane\" style=\"display:block\">			\n						<ul class=\"paneul\">\n						<#list footerarticle as fa>\n							<#if fc.articleCategoryTid=fa.articleCategoryTid>\n							<#if fa.htmlPath! !=\"\">\n								<li><a href=\"${basePath}<@fa.htmlPath?interpret />\">${fa.title}</a></li>\n							</#if>\n							</#if>\n						</#list>\n						</ul>\n					</div>\n					</#list>\n				</div>\n','default_helprightmenu','1'),
 ('201111150025','WEB-INF/theme/default/shop/goodscategorylist.ftl','商品分类列表','goodscategorylist','2012-02-04 10:57:53','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>${(goodsCategory.name)}--商品列表--Powered By OSTOCY</title>\n    <meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (goodsCategory.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${goodsCategory.metaKeywords}\"/></#if>\n	<#if (goodsCategory.metaDes)! != \"\"><meta name=\"description\" content=\"${goodsCategory.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/category.css\"/>\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/easyslider1.7/css/screen.css\"/>\n  	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs.css\"/>\n  	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion.css\"/>\n  	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/easyslider1.7/js/easySlider1.7.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.query.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/goodscategory.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n\n  </head>\n  \n  <body>\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n		<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n	</div>\n</div>\n<div id=\"header\">\n<div id=\"header_inner\" class=\"fixed\">\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		 <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n	  \n	  <div id=\"primaryContent_3columns\">\n			<div id=\"columnA_3columns\">\n			 <div class=\"categorytitle\">全部商品分类</div>\n				<div class=\"category\" >\n                                 <ul  id=\"categoryvalue\">\n					<#list goodsCategoryTree as firstGoodsCategory>\n					<li><a target=\'_blank\' href=\"${basePath}${firstGoodsCategory.htmlpath}\">${firstGoodsCategory.name}</a>\n						<div class=\"cms_submenu\">\n                                                <div class=\"cmsmenuleft\">\n                                                    <dl class=\"menu_recommend\">\n                                                     <dt>热门类目</dt>\n                                                     <dd>\n                                                     <#list goodsCategoryTree as secondGoodsCategory>\n                                                     <#if secondGoodsCategory.parentId! !=\"\">\n						     <#if secondGoodsCategory.parentId=firstGoodsCategory.goodsCategoryTid>\n                                                     <#if secondGoodsCategory.htmlpath! !=\"\">\n                                                     <i><a href=\"${basePath}<@secondGoodsCategory.htmlpath?interpret />\">${secondGoodsCategory.name}</a></i>\n													 </#if>\n                                                     </#if>\n					             </#if>\n					             </#list>\n                                                     </dd>\n                                                     <div class=\"clear\"></div>\n                                                    </dl>\n                                                    <dl class=\"menu_price\">\n                                                        <div class=\"clear\"></div>\n                                                    </dl>\n                                                    <dl class=\"menu_new\"></dl>\n                                               </div>  \n                                               <div class=\"cmsmenuright\">\n                                                  <dl></dl>\n                                               </div>\n                                               </div>\n					</li>\n                                        <#if firstGoodsCategory_index+1==goodsCategoryTreeFirstCount>\n					        <#break/>\n					       </#if>\n					</#list>\n                                </ul>\n				</div>\n				<br class=\"clear\"/>\n           \n             \n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_3columns\">\n		\n			<div id=\"columnB_3columns_goodsmore\">\n                <div class=\"p_div\">\n                    <ul class=\"t_ul\">\n                    \n                    <!-- 排序区域 -->\n                    <div class=\"list_sort_title\">\n                    	<div class=\"list_sort1\">\n                    		<span class=\"list_sort_t_1\">${goodsCategory.name}</span>\n                    		(共有<span class=\"list_sort_t_2\"><#if (allgoods??)&&(allgoods?size>0)>${allgoods?size}</#if></span>个商品)\n                    	</div>\n                    	<div class=\"list_sort2\">\n                    		<span class=\"list_sort_t_3\">排序：</span>\n                    		<span ><input class=\"list_sort_button\" type=\"button\" id=\"default\" name=\"default\" value=\"默认\"/></span>\n                    		<span ><input class=\"list_sort_button\" type=\"button\" id=\"sales\" name=\"sales\" value=\"销量\"/></span>\n                    		<span ><input class=\"list_sort_button\" type=\"button\" id=\"memberprice\" name=\"memberprice\" value=\"价格\"/></span>\n                    		<span ><input class=\"list_sort_button\" type=\"button\" id=\"totalcomment\" name=\"totalcomment\" value=\"评价\"/></span>\n                    	</div>\n                    	<div class=\"list_sort3\">\n                    		<span class=\"list_sort_t_3\">筛选：</span>\n                    		<span ><input  type=\"checkbox\" id=\"bargainprice\" name=\"bargainprice\" value=\"1\"/></span><span class=\"list_sort_w\">特价</span>\n                    		<span ><input type=\"checkbox\" id=\"hotsale\" name=\"hotsale\" value=\"1\"/></span>热销\n                    		<span ><input  type=\"checkbox\" id=\"recommended\" name=\"recommended\" value=\"1\"/></span>推荐\n                    		<span ><input  type=\"checkbox\" id=\"isNew\" name=\"isNew\" value=\"1\"/></span>新品\n                    	</div>\n                    </div>\n					<input type=\"hidden\" id=\"hidsign\" name=\"hidsign\" value=\"${goodsCategory.sign}\"/>\n                    <!-- 排序区域结束 -->\n                    <#if (goods.getList()??)&&(goods.getList()?size>0)>\n					<#list goods.getList() as g>\n                    	 <li class=\"fore\">\n	                    	<div class=\"p_img\">\n	                         <a href=\"${basePath}<@g.htmlPath?interpret />\">\n							<#list g.pictureurl?split(\",\") as img>\n							<#if img_index=0>\n							<img  src=\"${basePath}${img}\"/>\n							</#if>\n							</#list>\n							</a>\n	                     \n							</div>\n	                        <div class=\"p_name\">\n	                       \n							<a href=\"${basePath}<@g.htmlPath?interpret />\">${g.goodsname}</a>\n	                        \n							</div>\n	                        <div class=\"p_price\">\n	                        	<span class=\"reduce\">${g.price}</span>\n	                            <span class=\"price\">${g.memberprice}</span>\n	                        </div>\n	                        <div class=\"p_price\">\n	                        	<span>\n				\n	                        	<#if g.star=1><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif g.star=2><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img  class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif g.star=3><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#elseif g.star=4><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" />\n	                        	<#else><img class=\"goodsstar\"  src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /><img class=\"goodsstar\" src=\"${basePath}ui/default/images_green/goodsstar.png\" alt=\"\" /></#if>\n	                        	\n								</span>\n								\n	                            <span>(${g.totalcomment}条买家评分)</span>\n								\n								\n	                        </div>\n	                        <div class=\"p_buy_fav\">\n	                        	<input onclick=\"addtocart(${g.goodsid})\" type=\"button\" id=\"addtocart${g.goodsid}\" name=\"addtocart${g.goodsid}\" value=\"立即购买\"/>\n	                        	<input onclick=\"addtofav(\'${g.goodsid}\',\'${g.goodsname}\',\'${g.readcount}\',\'${g.memberprice}\')\" type=\"button\" id=\"addtofav${g.goodsid}\" name=\"addtofav${g.goodsid}\" value=\"收藏\"/>\n	                        </div>\n\n                    	</li>\n                    </#list>\n					<input type=\"hidden\" id=\"hidurl\" name=\"hidurl\" value=\"\"/>\n             		\n				  	<br class=\"clear\"/>\n				  \n                    \n                  	<#else>\n                  		<div id=\"errorinfo\">\n                  		对不起，未找到合适的商品信息\n                  		</div>\n                  	</#if>\n                    </ul>\n                    \n                    \n				</div>\n               \n				\n			</div>\n			<br class=\"clear\"/>\n  	      	<!-- 读取分页控件 -->\n				<div id=\"splitpage\">\n				 <#include \"/WEB-INF/theme/default/shop/splitpage.ftl\">\n				</div>\n				  \n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n <input type=\"hidden\" id=\"sorttag\" name=\"sorttag\" value=\"all\" />\n</div>\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n\n \n	<!-- This JavaScript snippet activates those tabs -->\n<script>\n                    \n                    // perform JavaScript after the document is scriptable.\n                    $(function() {\n                        // setup ul.tabs to work as tabs for each div directly under div.panes\n                        $(\"ul.tabs\").tabs(\"div.panes > div\");\n                    });\n                    </script>\n</body>\n</html>','default_goodscategorylist','1'),
 ('201111180026','WEB-INF/theme/default/shop/splitpage.ftl','分页模板','splitpage','2012-02-04 11:19:45','20100721001','1','20120203001','default','<#macro isDisabled comparePage>\n    <#if \"${comparePage}\"  == \"${goods.pageNo}\"><#t>\n        disabled=\"disabled\" href=\"#\"<#t>\n    <#else>\n        href=\"${sign}_${comparePage}.html\"<#t>\n    </#if>\n</#macro>\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<style type=\"text/css\">\n	.button_myway3{\n	background:#ffffff;\n    border: 1px solid #fb7510;\n    color: #000;\n    font-size: 12px;\n    font-weight: lighter;\n    height: 20px;\n	}\n		.button_myway4{\n	background:#ffffff;\n    border: 1px solid #fb7510;\n    color: #000;\n    font-size: 12px;\n    font-weight: lighter;\n    height: 20px;\n    width:20px;\n	}\n</style>\n <body>\n <center>\n<a <@isDisabled comparePage=\"1\" />>首页</a> <#t>\n<a <@isDisabled comparePage=\"${goods.previousPageNo}\" />>上一页</a> <#t>\n<a <@isDisabled comparePage=\"${goods.nextPageNo}\" />>下一页</a> <#t>\n<a <@isDisabled comparePage=\"${goods.bottomPages}\" />>尾页</a> <#t>\n${goods.pageNo}/${goods.bottomPages} <#t>\n共${goods.totalRecord}条记录\n\n\n </body>\n</html>','default_splitpage','1'),
 ('201112050027','WEB-INF/theme/default/shop/useractivates.ftl','用户激活','useractivates','2012-02-04 11:19:19','20100721001','2','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n\n    <title>${(jshopbasicinfo.jshopname)}用户激活邮件</title>\n	<meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/form.css\" />\n\n\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n<body>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n \n      </div>\n      \n     <div id=\"primaryContent_columnless\">\n\n			<div id=\"columnA_columnless\">\n				<div class=\"register\">\n				<h3>${(jshopbasicinfo.jshopname)}用户激活</h3>\n				\n				<div id=\"myform_register\">\n      			<p>\n         			<label>${useractivates}</label>\n         		    \n         			\n      			\n      			</div>\n				</div>\n			</div>\n		</div>\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n\n	\n  </body>\n</html>\n','default_useractivates','1');
INSERT INTO `template_t` (`TID`,`URL`,`NOTE`,`NAME`,`CREATETIME`,`CREATORID`,`TYPE`,`THEMEID`,`THEMENAME`,`TVALUE`,`SIGN`,`STATUS`) VALUES 
 ('201112060028','WEB-INF/theme/default/shop/useractivatescallback.ftl','用户激活回调页面','useractivatescallback','2012-02-19 22:55:49','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n\n    <title>${jshopbasicinfo.jshopname}用户激活邮件</title>\n	<meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! != \"\"><meta name=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! != \"\"><meta name=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/form.css\" />\n    <script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n    <script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.query.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n    <script>\n	     var uid=$.query.get(\'uid\');\n		 if(uid!=\"\"){\n			$.post(\"updateUserstate.action\",{\"uid\":uid},function(data){\n				if(data.sucflag){\n					$(\"#myform_register p label\").html(\"用户激活成功访问<a href=\'${basePath}index.html\'>首页</a>\");\n				}else{\n					$(\"#myform_register p label\").text(\"非法操作\");\n				}\n			});\n		 }\n	</script>\n  </head>\n  \n<body>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n \n      </div>\n      \n     <div id=\"primaryContent_columnless\">\n\n			<div id=\"columnA_columnless\">\n				<div class=\"register\">\n				<h3>${(jshopbasicinfo.jshopname)}用户激活状态</h3>\n				\n				<div id=\"myform_register\">\n      			<p>\n         			<label></label>\n         		    \n         		</p>\n      			\n      			</div>\n				</div>\n			</div>\n		</div>\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n\n	\n  </body>\n</html>\n','default_useractivatescallback','1'),
 ('201112130029','WEB-INF/theme/default/shop/headersearch.ftl','头部搜索','headersearch','2012-02-04 11:18:49','20100721001','1','20120203001','default','<div class=\"search\">\n				<input type=\"text\" class=\"text\" id=\"goodsname\" name=\"goodsname\" />\n				<input type=\"submit\" class=\"button\" value=\"搜索\" />\n				<br class=\"clear\" />\n	 		</div>\n        <div id=\"keywords\">\n       		热门搜索：\n       		<!-- 获取热门关键字 -->\n       		\n   		\n            	<a href=\"findGoodsByKeyword.action?keywordid=\">11</a>\n           \n       </div>','default_headersearch','1'),
 ('201112130030','WEB-INF/theme/default/shop/emailtemplate.ftl','活动邮件模板','emailtemplate','2012-02-04 11:13:47','20100721001','2','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title></title>\n    <meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	\n\n\n\n  </head>\n  \n  <body>\n${emailcontent}\n\n\n</body>\n</html>','default_emailtemplate','1'),
 ('201112140031','WEB-INF/theme/default/shop/usercenter.ftl','用户中心','usercenter','2012-02-19 23:31:15','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>${(goodsCategory.name)}用户中心</title>\n    <meta name=\"Author\" content=\"OSTOCY\">\n	<meta name=\"Copyright\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">      \n    <meta name=\"keywords\" content=\"\"/>\n	<meta name=\"description\" content=\"\"/>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n  	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"${basePath}ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n  </head>\n  \n  <body>\n  <input type=\"hidden\" id=\"hidurl\" name=\"hidurl\" value=\"\"/>\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   			<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n					<div class=\"detail\">\n						<div class=\"usercenter_userinfo\">\n							<div class=\"head\">\n								<a href=\"#\">\n									<!--<s:if test=\"#session.user.headurl!=null\">\n										<img src=\"<%=basePath %>ui/default/images_green/hui.jpg\" alt=\"\" />\n									</s:if>\n									<s:else>\n										<img src=\"<%=basePath %>ui/default/images_green/hui.jpg\" alt=\"\" />\n									</s:else>-->\n									\n								</a>\n								<!--<a class=\"modify\" href=\"#\">修改头像</a>-->\n							</div>\n							<div class=\"info\">\n								<strong>sdywcd</strong>\n								<span class=\"point\">积分：88</span>\n							</div>\n							<div class=\"useful-actions\">\n								<a href=\"#\">安全设置</a>\n								<a href=\"#\">收货地址管理</a>\n							</div>\n							<div class=\"notice\">\n								<div class=\"wrapper\">\n									<div class=\"section\">\n										<ul>\n											<li>待付款<a href=\"\">(1)</a></li>\n											<li>待确认收货<a href=\"\">(2)</a></li>\n										</ul>\n									</div>\n								</div>\n							</div>\n						</div>\n					</div>\n					\n				<div class=\"title\">待处理订单</div>\n				<div id=\"cart_info\">\n				<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">订单编号</td>\n									<td>商品名称</td>\n									<td width=\"14%\">应付金额</td>\n									<td width=\"15%\">成交时间</td>\n									<td width=\"5%\">数量</td>\n									<td width=\"12%\">订单操作</td>\n									<td width=\"12%\"></td>\n								</tr>\n								<#if (userorderon??)&&(userorderon?size>0)\">\n								<#list userorderon as uo>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${uo.orderid}</td>\n									<td class=\"align_Left\">\n										<span>\n											<a target=\"_blank\"   href=\"InitMyOrdersDetail.action?orderid=${uo.orderid}\">\n												${uo.goodsname}\n											</a>\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${uo.shouldpay}</span>\n									</td>\n									<td>${uo.purchasetime}</td>\n									<td>\n										${uo.needquantity}\n										<!-- 隐藏的orderid -->\n										<input type=\"hidden\" id=\"hidorderid\" name=\"hidorderid\" value=\"${uo.orderid}\"/>\n									</td>\n									<td>\n									<#if uo.orderstate=0>\n										<span>等待商家确认</span><br/>\n									<#elseif uo.orderstate=1>\n										<span>已确认配货中</span><br/>\n									<#elseif uo.orderstate=4>\n										<span>退货</span><br/>\n									<#elseif uo.orderstate=5>\n										<span>关闭</span><br/>\n									<#elseif uo.orderstate=7>\n										<span>缺货</span><br/>\n									<#elseif uo.orderstate=9>\n										<span>成功</span><br/>\n									<#elseif uo.orderstate=3>\n										<a href=\"http://www.alipay.com\" target=\"_blank\"><font color=\"red\">确认收货</font></a><br/>\n									</#if>\n									<#if uo.paystate=0>\n										<a href=\"InitPayPage.action?redirecturl=findAllUserOrderOn.action?&orderid=${uo.orderid}\"><font color=\"red\">付款</font></a><br/>\n									</#if>\n									\n										<a target=\"_blank\"   href=\"InitMyOrdersDetail.action?orderid=<s:property value=\"${uo.orderid}\">订单详细</a><br/>\n										<a>物流信息</a><br/>\n									</td>\n									<td>\n										<#if uo.paystate=1>\n											<span>您已付款</span><br/>\n											<#if uo.shippingstate=1>\n											<span>商家已发货</span>\n											</#if>\n											<#if uo.shippingstate=0>\n												<span>配货中</span>\n											</#if>\n										<#else>\n											<span>您未付款</span>\n										</#if>\n										<br/>\n										<a id=\"customernotes\" onclick=\"showcustomernotes(<s:property value=\"${uo.orderid}\"/>)\">备注</a><br/>			\n									</td>\n								</tr>\n								<tr>\n									<td style=\"display:none;\" id=\"bz<s:property value=\"${uo.orderid}\"/>\" colspan=\"7\">${uo.customernotes}</td>\n								</tr>\n								</#list>\n								</#if>\n								\n							</tbody>\n						</table>\n						<ul class=\"cart_bottom\">\n							<li class=\"libuyandjs\">\n								\n								<div class=\"submit_btn\" style=\"text-align:right;\">\n								\n								</div>\n							</li>\n						</ul>\n					</div>\n					\n				</div>\n		    \n			    <div class=\"title\">我的购物车</div>\n					<div id=\"cart_info\">\n					<div class=\"cart_table\">\n							<table>\n								<tbody>\n									<tr class=\"trhead\">\n										<td width=\"10%\" style=\"height:30px;\">商品编号</td>\n										<td>商品名称</td>\n										<td width=\"14%\">会员价</td>\n										<td width=\"8%\">赠送积分</td>\n										<td width=\"10%\">商品数量</td>\n										<td width=\"9%\">删除商品</td>\n									</tr>\n									<s:if test=\"#session.usercart!=null\">\n									<s:iterator id=\"bean\" value=\"#session.usercart.cart\" status=\"cart\">\n									<tr class=\"align_Center\">\n										<td style=\"padding: 5px 0pt;\"><s:property value=\"usersetnum\"/></td>\n										<td class=\"align_Left\">\n											<div class=\"p-img\">\n												<a href=\"GetGoodsdetailBygoodsid.action?goodsid=<s:property value=\"goodsid\"/>\">\n													<img src=\"Uploads/<s:property value=\"picture\"/>\"/>\n												</a>\n											</div>\n											<span>\n												<a href=\"GetGoodsdetailBygoodsid.action?goodsid=<s:property value=\"goodsid\"/>\">\n													<s:property value=\"goodsname\"/>\n												</a>\n											</span>\n										</td>\n										<td>\n											<span class=\"price\"><s:property value=\"favorable\"/></span>\n										</td>\n										<td><s:property value=\"points\"/></td>\n										<td>\n											<a id=\"reduceamount\" onclick=\"changereduceamount(<s:property value=\"goodsid\"/>,<s:property value=\"weight\"/>,<s:property value=\"favorable\"/>)\">\n												<img src=\"ui/default/images_green/bag_close.gif\" alt=\"\" />\n											</a>\n											<input onblur=\"changeinfo(<s:property value=\"goodsid\"/>,<s:property value=\"weight\"/>,<s:property value=\"favorable\"/>)\" type=\"text\" name=\"amount,<s:property value=\"favorable\"/>,<s:property value=\"weight\"/>\" id=\"amount<s:property value=\"goodsid\"/>\" value=\"<s:property value=\"needquantity\"/>\" size=\"2\"/>\n											<a id=\"plusamount\"  onclick=\"changeplusamount(<s:property value=\"goodsid\"/>,<s:property value=\"weight\"/>,<s:property value=\"favorable\"/>)\">\n												<img src=\"ui/default/images_green/bag_open.gif\" alt=\"\" />\n											</a>\n											<!-- 隐藏的goodsid -->\n											<input type=\"hidden\" id=\"hidgoodsid\" name=\"hidgoodsid\" value=\"<s:property value=\"goodsid\"/>\"/>\n											</td>\n										<td><a href=\"DelCartByGoodsId.action?goodsid=<s:property value=\"goodsid\"/>\">删除</a></td>\n									</tr>\n									</s:iterator>\n									</s:if>\n								</tbody>\n							</table>\n							<ul class=\"cart_bottom\">\n								<li class=\"libuyandjs\">\n									\n									<div class=\"submit_btn\" style=\"text-align:right;\">\n										<a href=\"<%=basePath %>index.jsp\" id=\"goonbuy\">继续购物</a>\n										<a  id=\"gotojs\">去结算</a>\n									</div>\n								</li>\n							</ul>\n						</div>\n					</div>\n			  \n			    \n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n				<jsp:include page=\"usercentermenu.jsp\"></jsp:include>\n				\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n\n	<!-- This JavaScript snippet activates those tabs -->\n<script>\n                    \n$(function() { \n\n$(\"#accordion\").tabs(\"#accordion div.pane\", {tabs: \'h2\', effect: \'slide\', initialIndex: null});\n});\n\n                    </script>\n</body>\n\n</html>\n','default_usercenter','1'),
 ('201201030027','WEB-INF/theme/default/shop/deliveraddress.ftl','收货地址管理','deliveraddress','2012-02-21 15:05:18','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n  \n    \n        <title><#if jshopbasicinfo! !=\"\">${(jshopbasicinfo.jshopname)}</#if>我的收获地址</title>\n    \n	<meta http-equiv=\"pragma\" content=\"OSTOCY\">\n	<meta http-equiv=\"cache-control\" content=\"OSTOCY\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n<meta http-equiv=\"Content-type\" content=\"text/html; charset=UTF-8\">\n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"/></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"/></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"js/mydeliveraddressjs.js\"></script>\n  	<script type=\"text/javascript\" src=\"js/location.js\"></script>\n	<script type=\"text/javascript\" src=\"js/YLChinaArea.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n<script type=\"text/javascript\">    \n       $(document).ready(function() {\n         $(\"#ChinaArea\").jChinaArea({\n             aspnet:false,\n             s1:\"河南省\",//默认选中的省名\n             s2:\"安阳市\",//默认选中的市名\n             s3:\"文峰区\"//默认选中的县区名\n         });\n       });\n   </script>\n\n  </head>\n  \n<body>\n\n\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n		\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		\n		  <div id=\"menu\">\n			<ul>\n<#if (siteNavigationList??)&&(siteNavigationList?size>0)>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n</#if>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n <div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_009.gif\" alt=\"我的收获地址\" />\n					</div>\n					<div class=\"list_cart\">\n						<h2><strong>我的收货地址</strong> </h2><a id=\"addnewa\">[增加新地址]</a><a id=\"closenewa\">[关闭]</a>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">收货人</td>\n									<td>地址</td>\n									<td width=\"14%\">邮编</td>\n									<td width=\"8%\">手机号码</td>\n									<td width=\"10%\">固定电话</td>\n									<td width=\"9%\">邮箱</td>\n									<td width=\"9%\">删除商品</td>\n								</tr>\n								<#if (deliveraddress??)&&(deliveraddress?size>0)>\n								<#list deliveraddress as d >\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${d.username}</td>\n									<td class=\"align_Left\">\n										<span>\n											${d.province}${d.city}${d.district}${d.street}\n										</span>\n									</td>\n									<td>\n										${d.postcode}\n									</td>\n									<td>${d.mobile}</td>\n									<td>${d.telno}</td>\n									<td>\n										${d.email}\n									</td>\n									<td><a href=\"UserDelDeliverAddress.action?addressid=${d.addressid}\">删除</a></td>\n								</tr>\n								</#list>\n								</#if>\n							</tbody>\n						</table>\n	\n					</div>\n<div id=\"addnewaddressarea\" style=\"display:none;\" class=\"middle\" >\n									<div id=\"addressform\">\n										<table cellspacing=\"0\" border=\"0\" width=\"100%\" >\n											<tbody>\n												<tr>\n													<td align=\"right\" width=\"85\" valign=\"middle\">\n														<font color=\"red\">*</font>\n														收货人姓名：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input id=\"username\" class=\"txt\" type=\"text\" value=\"\" maxlength=\"20\"/>\n														<span id=\"deliver_username_info\" style=\"display:none;\" class=\"alertinfo\">请填写收货人姓名</span>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" width=\"85\" valign=\"middle\">\n														<font color=\"red\">*</font>\n														国家：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<select id=\"country\" name=\"country\">\n															<option value=\"1\">中国</option>\n														</select>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														<font color=\"red\">*</font>\n														省     份：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<div id=\"ChinaArea\">\n														 <select id=\"province\" name=\"province\" style=\"width: 100px;\"></select>\n													     <select id=\"city\" name=\"city\" style=\"width: 100px;\"></select>\n													     <select id=\"district\" name=\"district\" style=\"width: 120px;\"> </select>      \n													     </div>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														<font color=\"red\">*</font>\n														地     址：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input type=\"text\" id=\"street\" name=\"street\" style=\"width:320px;\" maxlength=\"100\"/>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														<font color=\"red\">*</font>\n														手机号码：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input type=\"text\" id=\"mobile\" name=\"mobile\" style=\"width:100px;\" maxlength=\"11\"/>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														\n														固定电话：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input type=\"text\" id=\"telno\" name=\"telno\" style=\"width:100px;\" maxlength=\"11\"/>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														\n														电子邮件：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input type=\"text\" id=\"email\" name=\"email\" style=\"width:200px;\" maxlength=\"50\"/>\n													</td>\n												</tr>\n												<tr>\n													<td align=\"right\" valign=\"middle\">\n														\n														邮政编码：\n													</td>\n													<td align=\"left\" valign=\"middle\">\n														<input type=\"text\" id=\"postcode\" name=\"postcode\" style=\"width:100px;\" maxlength=\"11\"/>\n													</td>\n												</tr>\n											</tbody>\n										</table>\n									</div>\n									<div style=\"padding:10px 0px 20px 45px;\">\n										<a id=\"addaddress\" >[添加到常用地址]</a>\n									</div>\n								</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n<#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n\n  </body>\n</html>\n\n','default_deliveraddress','1'),
 ('201201060028','WEB-INF/theme/default/shop/usercentermenu.ftl','会员soipay管理','usercentermenu','2012-02-04 11:12:21','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<body>\n<div id=\"area8title\" class=\"normaltitle\">我是Soipay用户</div>\n				<!-- accordion -->\n				<div id=\"accordion\">\n				<h2 class=\"current\">交易管理</h2>\n					 \n					<div class=\"pane\" style=\"display:block\">			\n						<ul class=\"paneul\">\n							<li><a href=\"${basePath}usercenter/businessmag/mycart.jsp\">我的购物车</a></li>\n							<li><a href=\"findAllUserOrderOn.action\">我的订单</a></li>\n							<li><a href=\"findAllUserOrder.action\">已买到的商品</a></li>\n							<li><a href=\"GetMyFavoriteByUserId.action\">我的收藏</a></li>\n							<!--<li><a href=\"\">我的积分</a></li>  -->\n							<li><a href=\"GetUserDeliverAddressForUserCenter.action\">收获地址管理</a></li>\n							<li><a href=\"findUserVouchers.action\">我的抵用券</a></li>\n							<li><a href=\"findAllWebsiteMsgByToUsername.action\">我的信件</a></li>				\n						</ul>\n					</div>\n	\n				<h2>用户信息</h2>		\n					<div class=\"pane\"  style=\"display:block\">\n						<ul class=\"paneul\">\n						<li><a href=\"findUserByuserId.action\">我的资料</a></li>\n						</ul>\n					\n					</div>\n				 \n				\n				</div>','default_usercentermenu','1'),
 ('201201060029','WEB-INF/theme/default/shop/mycart.ftl','购物车','mycart','2012-02-04 11:11:51','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n    <title>购物车</title>\n    \n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n	<meta http-equiv=\"description\" content=\"This is my page\">\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/mycartjs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n  </head>\n  \n<body>\n\n<s:hidden name=\"hidurl\" id=\"hidurl\" value=\"\"></s:hidden>\n\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  \n		  <div id=\"menu\">\n			<ul>\n				<li><a href=\"${basePath}index.jsp \" class=\"active\">首页</a></li>\n			    <s:if test=\"#bean.mainmenu!=null\">\n                <s:iterator id=\"bean\" value=\"#bean.mainmenu\" status=\"findindexmenu\">\n				<li><a href=\"${basePath}goods/goodslist.jsp?navid=<s:property value=\"navid\"/>\" target=\"_blank\" class=\"active\"><s:property value=\"nname\"/></a></li>\n                </s:iterator>\n			    </s:if>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_001.gif\" alt=\"我的购物车\" />\n					</div>\n					<div class=\"list_cart\">\n						<h2><strong>我挑选的商品</strong></h2>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">商品编号</td>\n									<td>商品名称</td>\n									<td width=\"14%\">soipay价</td>\n									<td width=\"8%\">赠送积分</td>\n									<td width=\"10%\">商品数量</td>\n									<td width=\"9%\">删除商品</td>\n								</tr>\n								<#if (usercart??)&&(usercart?size>0)>\n								<#list usercart as cart>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${cart.usersetnum}</td>\n									<td class=\"align_Left\">\n										<div class=\"p-img\">\n											<a href=\"GetGoodsdetailBygoodsid.action?goodsid=${cart.goodsid}\">\n												<img src=\"Uploads/${cart.picture}\"/>\n											</a>\n										</div>\n										<span>\n											<a href=\"GetGoodsdetailBygoodsid.action?goodsid=${cart.goodsid}\">\n												${cart.goodsname}\n											</a>\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${cart.favorable}</span>\n									</td>\n									<td>${cart.points}</td>\n									<td>\n										<a id=\"reduceamount\" onclick=\"changereduceamount(${cart.goodsid},${cart.weight},${cart.favorable})\">\n											<img src=\"ui/default/images_green/bag_close.gif\" alt=\"\" />\n										</a>\n										<input onblur=\"changeinfo(${cart.goodsid},${cart.weight},${cart.favorable})\" type=\"text\" name=\"amount,${cart.favorable},${cart.weight}\" id=\"amount${cart.goodsid}\" value=\"${cart.needquantity}\" size=\"2\"/>\n										<a id=\"plusamount\"  onclick=\"changeplusamount(${cart.goodsid},${cart.weight},${cart.favorable})\">\n											<img src=\"ui/default/images_green/bag_open.gif\" alt=\"\" />\n										</a>\n										<!-- 隐藏的goodsid -->\n										<input type=\"hidden\" id=\"hidgoodsid\" name=\"hidgoodsid\" value=\"${cart.goodsid}\"/>\n										</td>\n									<td><a href=\"DelCartByGoodsId.action?goodsid=${cart.goodsid}\">删除</a></td>\n								</tr>\n								</#list>\n								</#if>\n								<tr>\n									<td class=\"trfoot\" colspan=\"6\">\n										重量总计<span id=\"totalweight\">${usercart.totalweight}</span>克<br/>\n										商品总金额（不含运费）￥<span id=\"totalmemberprice\">${usercart.totalmemberprice}</span>\n									</td>\n								</tr>\n								\n							</tbody>\n						</table>\n						<ul class=\"cart_bottom\">\n							<li class=\"libuyandjs\">\n								\n								<div class=\"submit_btn\" style=\"text-align:right;\">\n									<a href=\"${basePath }index.jsp\" id=\"goonbuy\">继续购物</a>\n									<a  id=\"gotojs\">去结算</a>\n								</div>\n							</li>\n						</ul>\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\">\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>','default_mycart','1'),
 ('201201090034','WEB-INF/theme/default/shop/mywebsitemsg.ftl','我的信件','mywebsitemsg','2012-02-04 11:11:32','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>  \n    \n    <title>${jshopbasicinfo.jshopname}我的信件</title>    \n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}jshop/admin/js/kindeditor-min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/mywebsitemsgjs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n<script type=\"text/javascript\">\n$(function() {\n	KE.show({\n				id : \'text\',\n				resizeMode : 1,\n				allowPreviewEmoticons : false,\n				allowUpload : false,\n				items : [\n				\'fontname\', \'fontsize\', \'|\', \'textcolor\', \'bgcolor\', \'bold\', \'italic\', \'underline\',\n				\'removeformat\', \'|\', \'justifyleft\', \'justifycenter\', \'justifyright\', \'insertorderedlist\',\n				\'insertunorderedlist\', \'|\', \'emoticons\', \'link\']\n			});\n});\n</script>\n\n  </head>\n  \n<body>\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  \n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img id=\"newmsg\" src=\"ui/default/images_green/cart_010.gif\" alt=\"我的购物车\" />\n					</div>\n					\n					<div id=\"msgarea\" style=\"display:none;\">\n						<div class=\"list_cart\">\n						<h2><strong>新信件</strong></h2>\n					</div>\n					<div id=\"msgarea1\" class=\"cart_table1\" style=\"display:none;\">\n						<label>主题</label>\n						<p><input id=\"title\" name=\"title\" value=\"\" size=\"50\" maxlength=\"45\"/></p>\n						<label>发送给</label>\n						<p><input id=\"msgToUsername\" name=\"msgToUsername\" value=\"\" size=\"30\" maxlength=\"25\"/></p>\n						<label>内容</label>\n						\n						<p>\n							<textarea id=\"text\" name=\"text\" cols=\"100\" rows=\"8\" style=\"width:860px;height:400px;visibility:hidden;\"></textarea>\n						</p>\n						<p><input id=\"submit\" name=\"submit\" value=\"提交\" type=\"button\"></input><span id=\"msginfo\" name=\"msginfo\"></span></p>\n					</div>\n					</div>\n				\n					<div class=\"list_cart\">\n						<h2><strong>我的信件</strong></h2>\n					</div>\n					<#if (msgtext??)&&(msgtext?size>0)>\n						<table class=\"cart_table1\" >\n							<tr>\n								<td colspan=\"6\">\n									<p>${msgtext.mymsgtext}</p>\n								</td>\n							</tr>\n						</table>\n					</#if>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td style=\"height:30px;\">主题</td>\n									<td width=\"14%\">来自于</td>\n									<td width=\"14%\">类型</td>\n									<td width=\"6%\">状态</td>\n									<td width=\"15%\">时间</td>\n									<td width=\"5%\" ></td>\n								</tr>\n								<#if (websitemsg??)&&(websitemsg?size>0)>\n								<#list websitemsg as msg>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\" class=\"align_Left\">\n										<span>\n												<a href=\"findMsgtextById.action?msgtextid=${msg.msgtextid}\">${msg.title}</a>\n										</span>\n									</td>\n									<td>\n										<span>${msg.msgfromusrname}</span>\n									</td>\n									<td><span><#if (msg.msgstate==1)>普通信件\n									<#elseif (msg.msgstate==2)>系统信件\n											\n										</span></td></#if>\n									<td>									\n										<span><#if (msg.state==1) >已读\n										<#elseif (msg.state==0) >未读\n										\n										</span>\n										</td>\n										</#if>\n									<td>${msg.createtime}</td>\n									<td>\n									\n									<a href=\"DelWebsiteMsgT.action?msgid=${msg.msgid}\">删除</a></td>\n								</tr>\n								\n								\n								</#list>\n								</#if>\n							</tbody>\n						</table>\n	\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>\n<%!\nprivate String htmlspecialchars(String str) {\n	str = str.replaceAll(\"&\", \"&amp;\");\n	str = str.replaceAll(\"<\", \"&lt;\");\n	str = str.replaceAll(\">\", \"&gt;\");\n	str = str.replaceAll(\"\\\"\", \"&quot;\");\n	return str;\n}\n%>','default_mywebsitemsg','1'),
 ('201201100036','WEB-INF/theme/default/shop/favorite.ftl','我的收藏','favorite','2012-02-04 11:11:17','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>  \n    \n    <title>${jshopbasicinfo.jshopname}我的收藏</title>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/myfavoritejs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n  </head>\n  \n<body>\n\n\n<input type=\"hidden\" name=\"hidurl\" id=\"hidurl\"/>\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->		 \n		<div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_002.gif\" alt=\"我的收藏\" />\n					</div>\n					<div class=\"list_cart\">\n						<h2><strong>我收藏的商品</strong></h2>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">商品编号</td>\n									<td>商品名称</td>\n									<td width=\"14%\">soipay价</td>\n									<td width=\"8%\">人气</td>\n									<td width=\"10%\">收藏时间</td>\n									<td width=\"9%\">删除商品</td>\n								</tr>\n								<#if (favorite??)&&(favorite?size>0)>\n								<#list  favorite as myfavorite>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${myfavorite.goodsid}</td>\n									<td class=\"align_Left\">\n										<span>\n											<a href=\"GetGoodsdetailBygoodsid.action?goodsid=${myfavorite.goodsid}\">\n												${myfavorite.title}\n											</a>\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${myfavorite.memberprice}</span>\n									</td>\n									<td>${myfavorite.readcount}</td>\n									<td>\n										<span>${myfavorite.addtime}</span>\n										<!-- 隐藏的goodsid -->\n										<input type=\"hidden\" id=\"hidgoodsid\" name=\"hidgoodsid\" value=\"${myfavorite.goodsid}\"/>\n										</td>\n									<td><a href=\"DelMyFavoriteByid.action?favoriteid=${myfavorite.favoriteid}\">删除</a></td>\n								</tr>\n								</#list>\n								</#if>\n							</tbody>\n						</table>\n	\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>\n','default_favorite','1'),
 ('201201100037','WEB-INF/theme/default/shop/vouchers.ftl','我的优惠券','vouchers','2012-02-04 11:11:02','20100721001','1','20120203001','default','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n   \n    \n    <title>我的抵用券</title>\n    \n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/myvouchersjs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n  </head>\n  \n<body>\n\n<input type=\"hidden\" name=\"hidurl\" id=\"hidurl\"/>\n\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_007.gif\" alt=\"我的抵用券\" />\n					</div>\n					<div class=\"list_cart\">\n						<h2><strong>我的抵用券</strong></h2>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">兑换码</td>\n									<td>内容</td>\n									<td width=\"14%\">开始时间</td>\n									<td width=\"14%\">结束时间</td>\n									<td width=\"10%\">状态</td>\n									<td width=\"9%\"></td>\n								</tr>\n								<#if (vouchers??)&&(vouchers?size>0)>\n								<#list vouchers as myvouchers>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${myvouchers.vouchersname}</td>\n									<td class=\"align_Left\">\n										<span>\n												${myvouchers.voucherscontent}\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${myvouchers.begintime}</span>\n									</td>\n									<td>${myvouchers.endtime}</td>\n									<td>\n										<span>${myvouchers.state}</span>\n										<!-- 隐藏的抵用券id -->\n										<input type=\"hidden\" id=\"hidvouchersid\" name=\"hidvouchersid\" value=\"${myvouchers.vouchersid}\"/>\n										</td>\n									<td></td>\n								</tr>\n								</#list>\n								</#if>\n							</tbody>\n						</table>\n	\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>\n','default_vouchers','1'),
 ('201201110038','WEB-INF/theme/default/shop/mygoods.ftl','已买到的商品','mygoods','2012-02-04 11:10:39','20100721001','1','20120203001','default','\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head> \n    \n   <title>${jshopbasicinfo.jshopname}我的抵用券</title>\n    \n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/mygoodsjs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n  </head>\n  \n<body>\n\n<input type=\"hidden\" name=\"hidurl\" id=\"hidurl\"/>\n\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   			<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_004.gif\" alt=\"已买到商品\" />\n					</div>\n					\n					<div class=\"list_cart\">\n						<h2><strong>我的未处理订单</strong></h2>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">订单编号</td>\n									<td>商品名称</td>\n									<td width=\"14%\">应付金额</td>\n									<td width=\"15%\">成交时间</td>\n									<td width=\"5%\">数量</td>\n									<td width=\"12%\">订单操作</td>\n									<td width=\"12%\"></td>\n								</tr>\n								<#if (userorder??)&&(userorder?size>0)>\n								<#list userorder as myorder>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${myorder.orderid}</td>\n									<td class=\"align_Left\">\n										<span>\n											<a href=\"GetOrderdetailbyorderid.action?orderid=${myorder.orderid}\">\n												${myorder.goodsname}\n											</a>\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${myorder.shouldpay}</span>\n									</td>\n									<td>${myorder.purchasetime}</td>\n									<td>\n										${myorder.needquantity}\n										<!-- 隐藏的orderid -->\n										<input type=\"hidden\" id=\"hidorderid\" name=\"hidorderid\" value=\"${myorder.orderid}\"/>\n									</td>\n									<td>\n									<#if (myorder.orderstate==3)>\n										\n										<a href=\"ConfirmGoodsReceive.action?orderid=${myorder.orderid}\">确认收货</a><br/>\n									\n									<#else>\n										<a href=\"InitMyOrdersDetail.action?orderid=${myorder.orderid}\" target=\"_blank\">订单详细</a><br/>\n										<a>追踪物流</a><br/>\n									</#if>\n									\n									</td>\n									<td>\n										<#if (myorder.shippingstate==1)>\n											<span>商家已发货</span>\n										\n										<#else>\n											<span>配货中</span>\n										</#if>\n										<br/>\n										\n										<#if (myorder.paystate==1)>\n											<span>您已付款</span>\n										\n										<#else>\n											<span>您未付款</span>\n										</#if>\n										<br/>\n										\n										<#if (myorder.orderstate==6)||(myorder.orderstate==5)>\n										<a href=\"DelOrderByorderid.action?orderid=${myorder.orderid}\">删除</a><br/>\n										</#if>\n									</td>\n								</tr>\n								<tr>\n									<td style=\"display:none;\" id=\"bz${myorder.orderid}\" colspan=\"7\">${myorder.customernotes}</td>\n								</tr>\n								</#list>\n								</#if>\n								\n							</tbody>\n						</table>\n						<ul class=\"cart_bottom\">\n							<li class=\"libuyandjs\">\n								\n								<div class=\"submit_btn\" style=\"text-align:right;\">\n								\n								</div>\n							</li>\n						</ul>\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n		\n			\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>\n','default_mygoods','1'),
 ('201201110039','WEB-INF/theme/default/shop/myorder.ftl','我的订单','myorder','2012-02-04 11:10:10','20100721001','1','20120203001','default','\n<#import \"/WEB-INF/theme/default/shop/pager.ftl\" as pager>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n\n<html>\n  <head>\n   \n   \n    \n    <title>${jshopbasicinfo.jshopname}我的订单</title>\n    \n	<meta http-equiv=\"pragma\" content=\"no-cache\">\n	<meta http-equiv=\"cache-control\" content=\"no-cache\">\n	<meta http-equiv=\"expires\" content=\"0\">    \n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n	<#if (jshopbasicinfo.metaKeywords)! !=\"\"><meta http-equiv=\"keywords\" content=\"${jshopbasicinfo.metaKeywords}\"></#if>\n	<#if (jshopbasicinfo.metaDes)! !=\"\"><meta http-equiv=\"description\" content=\"${jshopbasicinfo.metaDes}\"></#if>\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_usercenter.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" title=\"Green\" href=\"${basePath}ui/default/css/style_green.css\" />\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"${basePath}ui/default/css/tabs-accordion-usercenter.css\"/>\n	<script type=\"text/javascript\"  src=\"${basePath}ui/default/js/jquery1.4.2.js\"></script>\n	<script type=\"text/javascript\" src=\"${basePath}ui/default/js/jquery.tools.min.js\"></script>\n  	<script type=\"text/javascript\" src=\"${basePath}js/myorderjs.js\"></script>\n  	<!--[if IE 6]>\n	<style>\n	body {behavior: url(\"<%=basePath%>ui/default/css/csshover3.htc\");}\n	</style>\n	<![endif]-->\n\n\n  </head>\n  \n<body>\n\n<input type=\"hidden\" name=\"hidurl\" id=\"hidurl\"/>\n\n\n<div id=\"top_header\">\n	<div id=\"top_header_menu\">\n	<#include \"/WEB-INF/theme/default/shop/top_header.ftl\">\n    </div>\n</div>\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h2>www.soipay.com</h2>\n		</div>\n		\n		<!-- 读取导航菜单 -->\n		  <div id=\"menu\">\n			<ul>\n				<#list siteNavigationList as navigation>\n					<#if navigation.position=\"2\">\n					<li>\n						<a href=\"${basePath}<@navigation.htmlPath?interpret />\"\n						<#if navigation.isTargetBlank=\"1\"> target=\"_blank\"</#if> class=\"active\">${navigation.name}\n						</a>\n					</li>\n				        </#if>\n				</#list>\n			</ul>\n		 </div>\n		\n		\n  </div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n	  <div id=\"top_main_inner\" class=\"fixed\">\n   		<#include \"/WEB-INF/theme/default/shop/headersearch.ftl\">\n      </div>\n      \n                   \n	  <div id=\"primaryContent_2columns\">\n			<div id=\"columnA_2columns\">\n\n				<br class=\"clear\"/>\n				<div id=\"cart_info\">\n					<div class=\"cart_img\">\n						<img src=\"ui/default/images_green/cart_003.gif\" alt=\"我的订单\" />\n					</div>\n					\n					<div class=\"list_cart\">\n						<h2><strong>我的未处理订单</strong></h2>\n					</div>\n					<div class=\"cart_table\">\n						<table>\n							<tbody>\n								<tr class=\"trhead\">\n									<td width=\"10%\" style=\"height:30px;\">订单编号</td>\n									<td>商品名称</td>\n									<td width=\"14%\">应付金额</td>\n									<td width=\"15%\">成交时间</td>\n									<td width=\"5%\">数量</td>\n									<td width=\"12%\">订单操作</td>\n									<td width=\"12%\"></td>\n								</tr>\n								<#if (userorderon??)&&(userorderon?size>0)>								\n								<#list userorderon as myorderon>\n								<tr class=\"align_Center\">\n									<td style=\"padding: 5px 0pt;\">${myorderon.orderid}</td>\n									<td class=\"align_Left\">\n										<span>\n											<a  target=\"_blank\"  href=\"InitMyOrdersDetail.action?orderid=${myorderon.orderid}\">\n												${myorderon.goodsname}\n											</a>\n										</span>\n									</td>\n									<td>\n										<span class=\"price\">${myorderon.shouldpay}</span>\n									</td>\n									<td>${myorderon.purchasetime}</td>\n									<td>\n										${myorderon.needquantity}\n										<!-- 隐藏的orderid -->\n										<input type=\"hidden\" id=\"hidorderid\" name=\"hidorderid\" value=\"${myorderon.orderid}\"/>\n									</td>\n									<td>\n									<#if (myorderon.orderstate==\'0\')>\n										<span>等待商家确认</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'1\')>\n										<span>已确认配货中</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'4\')>\n										<span>退货</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'5\')>\n										<span>关闭</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'7\')>\n										<span>缺货</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'9\')>\n										<span>成功</span><br/>\n									\n									<#elseif (myorderon.orderstate==\'3\')>\n										<a href=\"http://www.alipay.com\" target=\"_blank\"><font color=\"red\">确认收货</font></a>										\n									<br/>\n									</#if>\n									\n									<#if (myorderon.paystate==\'0\')>\n										<a href=\"InitPayPage.action?redirecturl=findAllUserOrderOn.action?&orderid=${myorderon.orderid}\"><font color=\"red\">付款</font></a><br/>\n									\n									\n									\n										<a href=\"InitMyOrdersDetail.action?orderid=${myorderon.orderid}\" target=\"_blank\">订单详细</a><br/>\n										<a href=\"${myorderon.logisticswebaddress}\" target=\"_blank\">追踪物流</a><br/>\n									</#if>\n									</td>\n									<td>\n										<#if (myorderon.paystate==\'1\')>\n											<span>您已付款</span><br/>\n											</#if>\n											<#if (myorderon.shippingstate==\'1\')>\n											<span>商家已发货</span>\n											</#if>\n											<#if (myorderon.shippingstate==\'0\')>\n												<span>配货中</span>									\n											\n										\n										<#else>\n											<span>您未付款</span>\n										</#if>\n										<br/>\n									</td>\n								</tr>\n								<tr>\n									<td style=\"text-align:center;background-color:#EBF4FB;\">订单备注</td>\n									<td style=\"\" id=\"bz${myorderon.orderid}\" colspan=\"6\">${myorderon.customernotes}</td>\n								</tr>\n								</#list>\n								</#if>\n								\n							</tbody>\n							\n							<@pager.p page=currentPage totalpage=allRecorders/>\n						\n						</table>\n						<@pager.p page=currentPage totalpage=allRecorders/>\n						\n						<ul class=\"cart_bottom\">\n							<li class=\"libuyandjs\">\n								\n								<div class=\"submit_btn\" style=\"text-align:right;\">\n								\n								</div>\n							</li>\n						</ul>\n						\n					</div>\n					\n					<div class=\"round\">\n						<div class=\"lround\"></div>\n						<div class=\"rround\"></div>\n					</div>\n					\n				</div>\n				\n				<br class=\"clear\" />\n				\n\n				\n				\n			</div>\n	\n		</div>\n		\n		<div id=\"secondaryContent_2columns\">\n		\n			<div id=\"columnC_2columns\">\n	\n				<#include  \"/WEB-INF/theme/default/shop/usercentermenu.ftl\" >\n\n			</div>\n\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n\n    <#include \"/WEB-INF/theme/default/shop/footer.ftl\">\n  </body>\n</html>\n\n  ','default_myorder','1'),
 ('201201120041','WEB-INF/theme/default/shop/pager.ftl','宏分页','pager','2012-02-04 11:10:24','20100721001','1','20120203001','default','   <#macro p page totalpage params=\'\' maxsteps=6>  \n      <#assign ipage=page?number>  \n     <#if maxsteps <= 0>  \n          <#assign maxsteps=5>  \n    </#if>  \n      <#assign offset = ((ipage - 1) / maxsteps)?int>  \n       <#assign offsetLast = ((totalpage - 1) / maxsteps)?int>  \n        \n       <#-- url附加参数的判断 -->  \n       <#assign requestParams = \"\">  \n      <#if (params?? && params != \'\')>  \n           <#assign requestParams = \'&\' + params>  \n       </#if>  \n         \n       <#-- 首页 -->  \n       <#if ipage gt 1>  \n          <a href=\"?page=1${requestParams}\">&lt;&lt;</a>  \n       <#else>  \n          <span class=\"disabled\">&lt;&lt;</span>  \n     </#if>  \n      <#-- 前组-->  \n     <#if offset gt 0>  \n         <a href=\"?page=${offset * maxsteps}${requestParams}\">…</a>  \n     <#else>  \n           <span class=\"disabled\">…</span>  \n      </#if>  \n       <#-- 当前组中的页号-->  \n       <#if (offset + 1) * maxsteps < totalpage>  \n           <#assign pagelist = (offset + 1) * maxsteps>  \n       <#else>  \n           <#assign pagelist = totalpage>  \n       </#if>  \n      <#if ipage gt 0 && ipage lte totalpage>  \n          <#list (offset * maxsteps + 1)..pagelist as num>  \n              <#if ipage != num>  \n                 <a href=\"?page=${num}${requestParams}\">${num}</a>  \n              <#else>  \n                  <strong>${num}</strong>  \n               </#if>  \n          </#list>  \n       </#if>  \n       <#-- 下组 -->  \n       <#if offset lt offsetLast>  \n           <a href=\"?page=${(offset + 1) * maxsteps + 1}${requestParams}\">…</a>  \n       <#else>  \n          <span class=\"disabled\">…</span>  \n      </#if>  \n      <#-- 尾页 -->  \n       <#if ipage lt totalpage>  \n         <a href=\"?page=${totalpage}${requestParams}\">&gt;&gt;</a>  \n      <#else>  \n          <span class=\"disabled\">&gt;&gt;</span>  \n     </#if>  \n     <#-- 前一页 -->  \n     <#if ipage gt 1>  \n           <a href=\"?page=${ipage - 1}${requestParams}\">前一页</a>  \n     <#else>  \n           <span class=\"disabled\">前一页</span>  \n       </#if>  \n      <#-- 后一页 -->  \n       <#if ipage lt totalpage>  \n           <a href=\"?page=${ipage + 1}${requestParams}\">后一页</a>  \n      <#else>  \n           <span class=\"disabled\">后一页</span>  \n       </#if>  \n   </#macro>  ','default_pager','1'),
 ('201202270035','WEB-INF/theme/ostocyblue/shop/index.ftl','欧斯塔克在线介绍网站首页','index','2012-02-27 09:22:03','20100721001','1','20120227009','ostocyblue','<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>欧斯塔克商城系统介绍网站</title>\n<meta name=\"keywords\" content=\"\" />\n<meta name=\"description\" content=\"\" />\n<link rel=\"stylesheet\" type=\"text/css\" title=\"Blue\" href=\"${basePath}ui/ostocyblue/css/style_blue.css\" />\n</head>\n<body>\n\n<div id=\"header\">\n\n	<div id=\"header_inner\" class=\"fixed\">\n\n		<div id=\"logo\">\n			<h1>Ostocy-Jshop</h1>\n		</div>\n		\n		<div id=\"menu\">\n			<ul>\n				<li><a href=\"#\" class=\"active\">首页</a></li>\n				<li><a href=\"#\">关于</a></li>\n				<li><a href=\"#\">成功案例</a></li>\n				<li><a href=\"#\">下载</a></li>\n				<li><a href=\"#\">文档</a></li>\n                <li><a href=\"#\">Google+</a></li>\n                 <li><a href=\"#\">微博</a></li>\n			</ul>\n		</div>\n		\n	</div>\n</div>\n\n<div id=\"main\">\n\n	<div id=\"main_inner\" class=\"fixed\">\n\n		<div id=\"primaryContent_columnless\">\n\n			<div id=\"columnA_columnless\">\n		\n				<h3>最新公告</h3>\n				<img src=\"images/pic.gif\" class=\"floatTL\" alt=\"Something scenic\" />\n\n				<p>开源</p>\n				\n		  		<p>\n					You can find more of our free work at this site or <a href=\"http://www.88web.org/\">our site</a>,\n					or some of our commercial work on <a href=\"http://www.88web.org/css-templates\">巴巴唔模板网</a>,\n					a commercial website template site.\n				</p>\n				\n				\n				<br class=\"clear\" />\n			\n				<h3>文档</h3>\n				<img src=\"images/pic.gif\" class=\"floatTL\" alt=\"Something scenic\" />\n\n				<p>文档</p>\n				\n		  		<p>\n					You can find more of our free work at this site or <a href=\"http://www.88web.org/\">our site</a>,\n					or some of our commercial work on <a href=\"http://www.88web.org/css-templates\">巴巴唔模板网</a>,\n					a commercial website template site.\n				</p>\n				\n				\n				<br class=\"clear\" />\n			</div>\n	\n		</div>\n\n		<br class=\"clear\" />\n\n	</div>\n\n</div>\n\n<div id=\"footer\" class=\"fluid\">\n	Copyright &copy; 2008 Your Website. All rights reserved. Design by <a href=\"http://www.88web.org/\">巴巴唔模板网</a>.\n</div>\n\n</body>\n</html>','ostocyblue_index','0');
/*!40000 ALTER TABLE `template_t` ENABLE KEYS */;


--
-- Definition of table `templateset_t`
--

DROP TABLE IF EXISTS `templateset_t`;
CREATE TABLE `templateset_t` (
  `TSID` varchar(20) NOT NULL,
  `TEMPLATEURL` varchar(255) NOT NULL,
  `SYSTEMCONTENT` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `BUILDHTMLPATH` varchar(255) NOT NULL,
  `SIGN` varchar(45) NOT NULL,
  `STATUS` varchar(1) DEFAULT NULL,
  `THEMEID` varchar(20) DEFAULT NULL,
  `THEMENAME` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `templateset_t`
--

/*!40000 ALTER TABLE `templateset_t` DISABLE KEYS */;
INSERT INTO `templateset_t` (`TSID`,`TEMPLATEURL`,`SYSTEMCONTENT`,`CREATETIME`,`CREATORID`,`BUILDHTMLPATH`,`SIGN`,`STATUS`,`THEMEID`,`THEMENAME`) VALUES 
 ('20111103009','WEB-INF/theme/default/shop/index.ftl','首页','2012-02-07 16:52:48','20100721001','index.html','default_index','1','20120203001','default'),
 ('201111140011','WEB-INF/theme/default/shop/articlecontent.ftl','文章详细','2012-02-07 16:16:18','20100721001','html/default/article/','default_articlecontent','1','20120203001','default'),
 ('201111150013','WEB-INF/theme/default/shop/goodscategorylist.ftl','商品分类列表','2012-02-07 16:52:56','20100721001','html/default/shop/','default_goodscategorylist','1','20120203001','default'),
 ('201111200014','WEB-INF/theme/default/shop/goodsdetail.ftl','商品详细','2012-02-07 16:16:42','20100721001','html/default/shop/','default_goodsdetail','1','20120203001','default'),
 ('201111210015','WEB-INF/theme/default/shop/goodscategorylist.ftl','粮油调味','2012-02-07 16:53:31','20100721001','html/default/shop/lytw_1.html','default_goodscategorylist','1','20120203001','default'),
 ('201111240016','WEB-INF/theme/default/shop/login.ftl','登录','2012-02-07 16:16:53','20100721001','html/default/shop/login.html','default_login','1','20120203001','default'),
 ('201111250017','WEB-INF/theme/default/shop/register.ftl','用户注册','2012-02-07 16:52:28','20100721001','html/default/shop/register.html','default_register','1','20120203001','default'),
 ('201112060018','WEB-INF/theme/default/shop/useractivatescallback.ftl','用户激活回调页面','2012-02-07 16:52:39','20100721001','html/default/shop/useractivatescallback.html','default_useractivatescallback','1','20120203001','default'),
 ('201202270019','WEB-INF/theme/ostocyblue/shop/index.ftl','欧斯塔克首页','2012-02-27 09:26:42','20100721001','index.html','ostocyblue_index','0','20120227009','ostocyblue');
/*!40000 ALTER TABLE `templateset_t` ENABLE KEYS */;


--
-- Definition of table `templatetheme_t`
--

DROP TABLE IF EXISTS `templatetheme_t`;
CREATE TABLE `templatetheme_t` (
  `TTID` varchar(20) NOT NULL,
  `NOTE` varchar(45) NOT NULL,
  `THEMENAME` varchar(45) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  `SIGN` varchar(100) NOT NULL,
  `STATUS` varchar(1) NOT NULL,
  PRIMARY KEY (`TTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `templatetheme_t`
--

/*!40000 ALTER TABLE `templatetheme_t` DISABLE KEYS */;
INSERT INTO `templatetheme_t` (`TTID`,`NOTE`,`THEMENAME`,`CREATETIME`,`CREATORID`,`SIGN`,`STATUS`) VALUES 
 ('20120203001','默认主题','default','2012-03-05 22:09:05','20100721001','default','1'),
 ('20120227009','欧斯塔克商城在线介绍网站模板','ostocyblue','2012-03-05 22:09:16','20100721001','ostocyblue','0');
/*!40000 ALTER TABLE `templatetheme_t` ENABLE KEYS */;


--
-- Definition of table `user_t`
--

DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `USERID` varchar(20) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `REALNAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `TELNO` varchar(20) DEFAULT NULL,
  `MOBILE` varchar(20) DEFAULT NULL,
  `QUESTION` varchar(50) DEFAULT NULL,
  `ANSWER` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `USERSTATE` varchar(1) NOT NULL,
  `POINTS` double(10,2) NOT NULL,
  `POSTINGCOUNT` int(10) unsigned NOT NULL,
  `SEX` varchar(2) DEFAULT NULL,
  `REGISTTIME` datetime NOT NULL,
  `DISABLEBEGIN` datetime DEFAULT NULL,
  `DISABLEEND` datetime DEFAULT NULL,
  `SECTION` varchar(20) DEFAULT NULL,
  `POSITION` varchar(20) DEFAULT NULL,
  `GROUPID` varchar(20) DEFAULT NULL,
  `PARTTIME1` varchar(20) DEFAULT NULL,
  `PARTTIME2` varchar(20) DEFAULT NULL,
  `PARTTIME3` varchar(20) DEFAULT NULL,
  `PARTTIME4` varchar(20) DEFAULT NULL,
  `PARTTIME5` varchar(20) DEFAULT NULL,
  `PARTTIME6` varchar(20) DEFAULT NULL,
  `HOBBY` varchar(50) DEFAULT NULL,
  `QQ` varchar(50) DEFAULT NULL,
  `MSN` varchar(50) DEFAULT NULL,
  `OTHERCONTRACT` varchar(50) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `POSTCODE` varchar(20) DEFAULT NULL,
  `BIRTHDAY` varchar(20) DEFAULT NULL,
  `GRADE` varchar(20) DEFAULT NULL,
  `GRADETIME` datetime DEFAULT NULL,
  `STATE` varchar(1) DEFAULT NULL,
  `UID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_t`
--

/*!40000 ALTER TABLE `user_t` DISABLE KEYS */;
INSERT INTO `user_t` (`USERID`,`USERNAME`,`REALNAME`,`EMAIL`,`TELNO`,`MOBILE`,`QUESTION`,`ANSWER`,`PASSWORD`,`USERSTATE`,`POINTS`,`POSTINGCOUNT`,`SEX`,`REGISTTIME`,`DISABLEBEGIN`,`DISABLEEND`,`SECTION`,`POSITION`,`GROUPID`,`PARTTIME1`,`PARTTIME2`,`PARTTIME3`,`PARTTIME4`,`PARTTIME5`,`PARTTIME6`,`HOBBY`,`QQ`,`MSN`,`OTHERCONTRACT`,`ADDRESS`,`POSTCODE`,`BIRTHDAY`,`GRADE`,`GRADETIME`,`STATE`,`UID`) VALUES 
 ('20100721001','sasasa',NULL,'5424@aa.com','3344555',NULL,NULL,'生日？','53B76CC34444F5B08F9A0A333437E32D','1',80.00,27,NULL,'2010-07-19 18:04:01',NULL,NULL,'20100721005','201007210035','201007210027','20100721001','201007210030',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'1988-10-09','4',NULL,'3',NULL);
/*!40000 ALTER TABLE `user_t` ENABLE KEYS */;


--
-- Definition of table `vouchers_t`
--

DROP TABLE IF EXISTS `vouchers_t`;
CREATE TABLE `vouchers_t` (
  `VOUCHERSID` varchar(20) NOT NULL,
  `VOUCHERSNAME` varchar(20) NOT NULL,
  `BEGINTIME` varchar(20) NOT NULL,
  `ENDTIME` varchar(20) NOT NULL,
  `VOUCHERSCONTENT` varchar(45) NOT NULL,
  `LIMITPRICE` double(10,2) NOT NULL,
  `GIVENUSERID` varchar(20) DEFAULT NULL,
  `VOUCHERSTATE` varchar(1) NOT NULL,
  `VOUCHERUSEWAY` varchar(1) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `CREATORID` varchar(20) NOT NULL,
  PRIMARY KEY (`VOUCHERSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `vouchers_t`
--

/*!40000 ALTER TABLE `vouchers_t` DISABLE KEYS */;
INSERT INTO `vouchers_t` (`VOUCHERSID`,`VOUCHERSNAME`,`BEGINTIME`,`ENDTIME`,`VOUCHERSCONTENT`,`LIMITPRICE`,`GIVENUSERID`,`VOUCHERSTATE`,`VOUCHERUSEWAY`,`STATE`,`CREATETIME`,`CREATORID`) VALUES 
 ('20110412002','qmna9z1e6r','04/12/11','04/21/11','50',200.00,'20100721002','1','0','0','2011-04-12 19:37:31','20100721001');
/*!40000 ALTER TABLE `vouchers_t` ENABLE KEYS */;


--
-- Definition of table `website_msg_t`
--

DROP TABLE IF EXISTS `website_msg_t`;
CREATE TABLE `website_msg_t` (
  `MSGID` varchar(20) NOT NULL,
  `MSGTOUSERNAME` varchar(50) NOT NULL,
  `MSGFROMUSERID` varchar(20) NOT NULL,
  `MSGFROMUSRNAME` varchar(50) NOT NULL,
  `MSGTEXTID` varchar(20) NOT NULL,
  `STATE` varchar(1) NOT NULL,
  `TITLE` varchar(50) NOT NULL,
  `CREATETIME` datetime NOT NULL,
  `MSGSTATE` varchar(20) NOT NULL,
  PRIMARY KEY (`MSGID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `website_msg_t`
--

/*!40000 ALTER TABLE `website_msg_t` DISABLE KEYS */;
/*!40000 ALTER TABLE `website_msg_t` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
