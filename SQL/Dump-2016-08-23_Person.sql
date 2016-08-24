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
  UNIQUE KEY `person_ID_uindex` (`ID`),
  KEY `FK_PERSON$USER_ID` (`USER_ID`),
  CONSTRAINT `FK_PERSON$USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `user` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_contact
CREATE TABLE IF NOT EXISTS `person_contact` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PERSON_ID` bigint(20) NOT NULL,
  `TELEPHONES` varchar(50) NOT NULL DEFAULT '',
  `EMAIL` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `contact_telephones_uindex` (`TELEPHONES`),
  UNIQUE KEY `contact_email_uindex` (`EMAIL`),
  UNIQUE KEY `contact_idContact_uindex` (`ID`),
  KEY `FK_PERSON_CONTACT$PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_PERSON_CONTACT$PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `person` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_role
CREATE TABLE IF NOT EXISTS `person_role` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `personrole_idRole_uindex` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person_room
CREATE TABLE IF NOT EXISTS `person_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `personroom_id_uindex` (`id`),
  KEY `personroom_person_idPerson_fk` (`person`),
  KEY `personroom_room_idRoom_fk` (`room`),
  KEY `personroom_personrole_idRole_fk` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.room
CREATE TABLE IF NOT EXISTS `room` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL DEFAULT '',
  `ADDRESS` varchar(255) NOT NULL DEFAULT '',
  `DATE_CREATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DATE_CLOSE` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
