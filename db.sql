-- Adminer 4.2.5 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `Nenuphar`;
CREATE DATABASE `Nenuphar` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `Nenuphar`;

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Login` varchar(15) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `isRespoAPP` varchar(30) NOT NULL,
  `isAdmin` varchar(30) NOT NULL,
  `isTutor` varchar(30) NOT NULL,
  `isStudent` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `User`;

DROP TABLE IF EXISTS `Record`;
CREATE TABLE `Record` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nbr_of_Courses` int(2) NOT NULL,
  `Deadline` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Record`;

DROP TABLE IF EXISTS `Course`;
CREATE TABLE `Course` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Nbr_of_Skills` int(2) NOT NULL,
  `RecordID` int(10) NOT NULL,
  `ManagerID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `RecordID` (`RecordID`),
  KEY `ManagerID` (`ManagerID`),
  CONSTRAINT `Course_ibfk_1` FOREIGN KEY (`RecordID`) REFERENCES `Record` (`ID`),
  CONSTRAINT `Course_ibfk_2` FOREIGN KEY (`RecordID`) REFERENCES `Record` (`ID`),
  CONSTRAINT `Course_ibfk_3` FOREIGN KEY (`ManagerID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Course`;

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `TeacherID` int(10) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Size` int(2) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `TeacherID` (`TeacherID`),
  CONSTRAINT `Group_ibfk_1` FOREIGN KEY (`TeacherID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Group`;



DROP TABLE IF EXISTS `Record_Users`;
CREATE TABLE `Record_Users` (
  `Record_ID` int(10) NOT NULL,
  `User_ID` int(10) NOT NULL,
  KEY `Record_ID` (`Record_ID`),
  KEY `User_ID` (`User_ID`),
  CONSTRAINT `Record_Users_ibfk_1` FOREIGN KEY (`Record_ID`) REFERENCES `Record` (`ID`),
  CONSTRAINT `Record_Users_ibfk_2` FOREIGN KEY (`User_ID`) REFERENCES `User` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Record_Users`;

DROP TABLE IF EXISTS `Skill`;
CREATE TABLE `Skill` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Nbr_of_Subskills` int(10) NOT NULL,
  `Deadline` date NOT NULL,
  `CourseID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CourseID` (`CourseID`),
  CONSTRAINT `Skill_ibfk_1` FOREIGN KEY (`CourseID`) REFERENCES `Course` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Skill`;

DROP TABLE IF EXISTS `Subskills`;
CREATE TABLE `Subskills` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Level` int(1) NOT NULL,
  `SkillID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `SkillID` (`SkillID`),
  CONSTRAINT `Subskills_ibfk_1` FOREIGN KEY (`SkillID`) REFERENCES `Skill` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Subskills`;

DROP TABLE IF EXISTS `Team`;
CREATE TABLE `Team` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) NOT NULL,
  `Size` int(2) NOT NULL,
  `GroupID` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `GroupID` (`GroupID`),
  CONSTRAINT `Team_ibfk_1` FOREIGN KEY (`GroupID`) REFERENCES `Group` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

TRUNCATE `Team`;



-- 2017-12-16 18:01:16