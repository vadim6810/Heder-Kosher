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


-- Дамп структуры базы данных heder-kosher
CREATE DATABASE IF NOT EXISTS `heder-kosher` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `heder-kosher`;

-- Дамп структуры для таблица heder-kosher.contact
CREATE TABLE IF NOT EXISTS `contact` (
  `person` int(11) NOT NULL,
  `telephones` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `idPerson` int(11) NOT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE KEY `contact_telephones_uindex` (`telephones`),
  UNIQUE KEY `contact_email_uindex` (`email`),
  KEY `contact_person_idPerson_fk` (`person`),
  CONSTRAINT `contact_person_idPerson_fk` FOREIGN KEY (`person`) REFERENCES `person` (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.person
CREATE TABLE IF NOT EXISTS `person` (
  `idPerson` int(10) NOT NULL AUTO_INCREMENT,
  `passportNo` varchar(50) NOT NULL DEFAULT '',
  `fistName` varchar(100) DEFAULT '',
  `lastname` varchar(100) DEFAULT '',
  `secondname` varchar(100) DEFAULT '',
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE KEY `person_idPerson_uindex` (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.personrole
CREATE TABLE IF NOT EXISTS `personrole` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT '',
  PRIMARY KEY (`idRole`),
  UNIQUE KEY `personrole_idRole_uindex` (`idRole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.personroom
CREATE TABLE IF NOT EXISTS `personroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `room` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `personroom_id_uindex` (`id`),
  KEY `personroom_person_idPerson_fk` (`person`),
  KEY `personroom_room_idRoom_fk` (`room`),
  KEY `personroom_personrole_idRole_fk` (`role`),
  CONSTRAINT `personroom_person_idPerson_fk` FOREIGN KEY (`person`) REFERENCES `person` (`idPerson`),
  CONSTRAINT `personroom_personrole_idRole_fk` FOREIGN KEY (`role`) REFERENCES `personrole` (`idRole`),
  CONSTRAINT `personroom_room_idRoom_fk` FOREIGN KEY (`room`) REFERENCES `room` (`idRoom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.room
CREATE TABLE IF NOT EXISTS `room` (
  `idRoom` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL DEFAULT '',
  `adress` varchar(255) NOT NULL DEFAULT '',
  `dcreate` datetime DEFAULT NULL,
  `dclose` datetime DEFAULT NULL,
  PRIMARY KEY (`idRoom`),
  UNIQUE KEY `room_idRoom_uindex` (`idRoom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
-- Дамп структуры для таблица heder-kosher.token
CREATE TABLE IF NOT EXISTS `token` (
  `idtoken` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `person` int(11) NOT NULL,
  PRIMARY KEY (`idtoken`),
  UNIQUE KEY `token_idtoken_uindex` (`idtoken`),
  UNIQUE KEY `token_person_pk` (`person`),
  UNIQUE KEY `token_token_uindex` (`token`),
  CONSTRAINT `token_person_idPerson_fk` FOREIGN KEY (`idtoken`) REFERENCES `person` (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
