-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.14-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.3.0.5109
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры для таблица heder-kosher.person
CREATE TABLE IF NOT EXISTS `person` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PASSPORT_NO` varchar(50) NOT NULL DEFAULT '',
  `FIRST_NAME` varchar(100) NOT NULL DEFAULT '',
  `LAST_NAME` varchar(100) DEFAULT '',
  `SECOND_NAME` varchar(100) DEFAULT '',
  `BIRTHDAY` date NOT NULL,
  `USER_ID` bigint(20) DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UI_PERSON$ID` (`ID`),
  UNIQUE KEY `UI_PERSON$PASSPORT_NO_FIRST_NAME_LAST_NAME_SECOND_NAME_BIRTHDAY` (`PASSPORT_NO`,`FIRST_NAME`,`LAST_NAME`,`SECOND_NAME`,`BIRTHDAY`),
  KEY `FK_PERSON$USER_ID` (`USER_ID`),
  CONSTRAINT `FK_PERSON$USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1107 DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_contact
CREATE TABLE IF NOT EXISTS `person_contact` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERSON_ID` bigint(20) NOT NULL,
  `TELEPHONE` varchar(50) NOT NULL DEFAULT '',
  `EMAIL` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UI_PERSON_CONTACT$EMAIL` (`EMAIL`),
  UNIQUE KEY `UI_PERSON_CONTACT$ID` (`ID`),
  UNIQUE KEY `UI_PERSON_CONTACT$TELEPHONE` (`TELEPHONE`),
  KEY `FK_PERSON_CONTACT$PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_CONTACT$PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_role
CREATE TABLE IF NOT EXISTS `person_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL DEFAULT '""',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UI_PERSON_ROLE$ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_room
CREATE TABLE IF NOT EXISTS `person_room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERSON_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  `ROOM_ID` bigint(20) NOT NULL,
  `DATE` date NOT NULL,
  `ENABLED` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UI_PERSON_ROOM$ID` (`ID`),
  KEY `FK_PERSON_ROOM$PERSON_ID` (`PERSON_ID`),
  KEY `FK_PERSON_ROOM$ROLE_ID` (`ROLE_ID`),
  KEY `FK_PERSON_ROOM$ROOM_ID` (`ROOM_ID`),
  CONSTRAINT `FK_PERSON_ROOM$PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`),
  CONSTRAINT `FK_PERSON_ROOM$ROLE_ID` FOREIGN KEY (`ROLE_ID`) REFERENCES `person_role` (`ID`),
  CONSTRAINT `FK_PERSON_ROOM$ROOM_ID` FOREIGN KEY (`ROOM_ID`) REFERENCES `room` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.room
CREATE TABLE IF NOT EXISTS `room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL DEFAULT '',
  `ADDRESS` varchar(255) NOT NULL DEFAULT '',
  `DATE_CREATE` date NOT NULL,
  `DATE_CLOSE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UI_ROOM$ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
