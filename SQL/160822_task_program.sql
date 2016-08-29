-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: heder-kosher
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_CLOSE` datetime(6) DEFAULT NULL,
  `DATE_CREATE` datetime(6) NOT NULL,
  `IS_TEMPLATE` bit(1) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `STATE` varchar(100) DEFAULT NULL,
  `CLIENT_ID` bigint(20) DEFAULT NULL,
  `OWNER_ID` bigint(20) DEFAULT NULL,
  `PRODUCER_ID` bigint(20) DEFAULT NULL,
  `ROOM_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PROGRAM$CLIENT_ID` (`CLIENT_ID`),
  KEY `FK_PROGRAM$OWNER_ID` (`OWNER_ID`),
  KEY `FK_PROGRAM$PRODUCER_ID` (`PRODUCER_ID`),
  KEY `FK_PROGRAM$ROOM_ID` (`ROOM_ID`),
  CONSTRAINT `FK_PROGRAM$CLIENT_ID` FOREIGN KEY (`CLIENT_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_PROGRAM$OWNER_ID` FOREIGN KEY (`OWNER_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_PROGRAM$PRODUCER_ID` FOREIGN KEY (`PRODUCER_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_PROGRAM$ROOM_ID` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AMOUNT_ITERATIONS` int(11) NOT NULL,
  `AMOUNT_TRIES` int(11) NOT NULL,
  `DESCRIPTION` text,
  `IS_TEMPLATE` bit(1) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `STATE` varchar(100) DEFAULT NULL,
  `TIME` int(11) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `OWNER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TASK$OWNER_ID` (`OWNER_ID`),
  CONSTRAINT `FK_TASK$OWNER_ID` FOREIGN KEY (`OWNER_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'heder-kosher'
--

--
-- Dumping routines for database 'heder-kosher'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-22 23:42:26