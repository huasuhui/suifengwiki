-- MySQL dump 10.13  Distrib 5.6.33, for Win64 (x86_64)
--
-- Host: localhost    Database: suifengwiki
-- ------------------------------------------------------
-- Server version	5.6.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `articleId` int(10) NOT NULL AUTO_INCREMENT,
  `theme` varchar(200) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `author` varchar(20) DEFAULT NULL,
  `articleKindId` int(10) DEFAULT NULL,
  `articleTag` varchar(50) DEFAULT NULL,
  `pageview` varchar(10) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `makedate` varchar(10) DEFAULT NULL,
  `maketime` varchar(10) DEFAULT NULL,
  `modifydate` varchar(10) DEFAULT NULL,
  `modifytime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'test','test','test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articlecomment`
--

DROP TABLE IF EXISTS `articlecomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articlecomment` (
  `articleCommentId` int(10) NOT NULL AUTO_INCREMENT,
  `articleComment` varchar(200) DEFAULT NULL,
  `articleId` int(10) DEFAULT NULL,
  `makedate` varchar(10) DEFAULT NULL,
  `maketime` varchar(10) DEFAULT NULL,
  `modifydate` varchar(10) DEFAULT NULL,
  `modifytime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`articleCommentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articlecomment`
--

LOCK TABLES `articlecomment` WRITE;
/*!40000 ALTER TABLE `articlecomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `articlecomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articlekind`
--

DROP TABLE IF EXISTS `articlekind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articlekind` (
  `articleKindId` int(10) NOT NULL AUTO_INCREMENT,
  `articleKindName` varchar(50) NOT NULL,
  `kindShortName` varchar(20) DEFAULT NULL,
  `makedate` varchar(10) DEFAULT NULL,
  `maketime` varchar(10) DEFAULT NULL,
  `modifydate` varchar(10) DEFAULT NULL,
  `modifytime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`articleKindId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articlekind`
--

LOCK TABLES `articlekind` WRITE;
/*!40000 ALTER TABLE `articlekind` DISABLE KEYS */;
/*!40000 ALTER TABLE `articlekind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articletag`
--

DROP TABLE IF EXISTS `articletag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articletag` (
  `articleTagId` int(10) NOT NULL AUTO_INCREMENT,
  `articleTagName` varchar(20) NOT NULL,
  `makedate` varchar(10) DEFAULT NULL,
  `maketime` varchar(10) DEFAULT NULL,
  `modifydate` varchar(10) DEFAULT NULL,
  `modifytime` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`articleTagId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articletag`
--

LOCK TABLES `articletag` WRITE;
/*!40000 ALTER TABLE `articletag` DISABLE KEYS */;
/*!40000 ALTER TABLE `articletag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-18 22:47:03
