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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_g6g6arw2xba1pirbuf4ig44jq` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `office`
--

DROP TABLE IF EXISTS `office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `office` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` text NOT NULL,
  `DATE_CLOSE` datetime(6) DEFAULT NULL,
  `DATE_CREATE` datetime(6) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BIRTHDAY` datetime(6) NOT NULL,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PASSPORT_NO` varchar(255) NOT NULL,
  `SECOND_NAME` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_peg7sp1le3ac0l7gdfld6wmb1` (`PASSPORT_NO`),
  KEY `FK_PERSON$USER_ID` (`USER_ID`),
  CONSTRAINT `FK_PERSON$USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person_contact`
--

DROP TABLE IF EXISTS `person_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_contact` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) NOT NULL,
  `PERSON_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PERSON_CONTACT$PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_CONTACT$PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person_role`
--

DROP TABLE IF EXISTS `person_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `role_authority`
--

DROP TABLE IF EXISTS `role_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_authority` (
  `ROLE_ID` bigint(20) NOT NULL,
  `AUTH_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`AUTH_ID`),
  KEY `FKkesq26pgcrmkv87q0jy6xdl7a` (`AUTH_ID`),
  CONSTRAINT `FKjc6ciosfvjylyb1y49e2y3naj` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FKkesq26pgcrmkv87q0jy6xdl7a` FOREIGN KEY (`AUTH_ID`) REFERENCES `authority` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` text NOT NULL,
  `DATE_CLOSE` datetime(6) DEFAULT NULL,
  `DATE_CREATE` datetime(6) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
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
  `DESCRIPTION` text,
  `IS_TEMPLATE` bit(1) NOT NULL,
  `N_ITERATIONS` int(11) NOT NULL,
  `N_TRIES` int(11) NOT NULL,
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
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TOKEN` varchar(255) NOT NULL,
  `TSCREATE` datetime(6) NOT NULL,
  `user_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_h145ctegcqqd0dmjgqcgmrvkb` (`TOKEN`),
  KEY `FKoc4kh16quoapfrc2fb2tpjqqs` (`user_ID`),
  CONSTRAINT `FKoc4kh16quoapfrc2fb2tpjqqs` FOREIGN KEY (`user_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL,
  `REG_DATE` datetime(6) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_t8tbwelrnviudxdaggwr1kd9b` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_granted_authority`
--

DROP TABLE IF EXISTS `user_granted_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_granted_authority` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime(6) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `ROOM_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USER_GRANTED_AUTHORITY$ROLE_ID` (`ROLE_ID`),
  KEY `FK_USER_GRANTED_AUTHORITY$ROOM_ID` (`ROOM_ID`),
  KEY `FKmyjut4iohc9pqnwc5aa2nhti0` (`USER_ID`),
  CONSTRAINT `FK_USER_GRANTED_AUTHORITY$ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_USER_GRANTED_AUTHORITY$ROOM_ID` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ID`),
  CONSTRAINT `FKmyjut4iohc9pqnwc5aa2nhti0` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
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

-- Dump completed on 2016-11-08 22:10:27
