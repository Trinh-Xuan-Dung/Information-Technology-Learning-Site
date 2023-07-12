-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: learning_site
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Alley` varchar(255) DEFAULT NULL,
  `HouseNumber` varchar(255) DEFAULT NULL,
  `Residential_GroupsID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `Residential_GroupsID` (`Residential_GroupsID`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`Residential_GroupsID`) REFERENCES `residential_groups` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (7,'Alle1','21-ngo 156 Ton That Tung',NULL),(8,'Alle1','21-ngo 156 Ton That Tung',NULL),(10,NULL,NULL,NULL),(11,NULL,NULL,NULL),(12,NULL,NULL,NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `ApplicationId` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) DEFAULT NULL,
  `Content` text,
  `SendTime` datetime DEFAULT NULL,
  `Sender` int DEFAULT NULL,
  PRIMARY KEY (`ApplicationId`),
  KEY `Sender` (`Sender`),
  CONSTRAINT `application_ibfk_1` FOREIGN KEY (`Sender`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `AssignmentId` int NOT NULL AUTO_INCREMENT,
  `WeekId` int DEFAULT NULL,
  `AssignmentTitle` varchar(100) DEFAULT NULL,
  `Description` text,
  PRIMARY KEY (`AssignmentId`),
  KEY `WeekId` (`WeekId`),
  CONSTRAINT `assignment_ibfk_1` FOREIGN KEY (`WeekId`) REFERENCES `weekcourse` (`WeekId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assignmentprogress`
--

DROP TABLE IF EXISTS `assignmentprogress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignmentprogress` (
  `AssignmentProgressId` int NOT NULL AUTO_INCREMENT,
  `IsCompleted` tinyint(1) DEFAULT '0',
  `EnrollmentId` int DEFAULT NULL,
  `Score` decimal(5,2) DEFAULT NULL,
  `FileSubmission` blob,
  `Answer` text,
  PRIMARY KEY (`AssignmentProgressId`),
  KEY `EnrollmentId` (`EnrollmentId`),
  CONSTRAINT `assignmentprogress_ibfk_1` FOREIGN KEY (`EnrollmentId`) REFERENCES `courseenrollment` (`EnrollmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignmentprogress`
--

LOCK TABLES `assignmentprogress` WRITE;
/*!40000 ALTER TABLE `assignmentprogress` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignmentprogress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chatsupport`
--

DROP TABLE IF EXISTS `chatsupport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chatsupport` (
  `ChatId` int NOT NULL AUTO_INCREMENT,
  `DateCreate` datetime DEFAULT NULL,
  `Content` text,
  `Userid` int DEFAULT NULL,
  `Supporrter` int DEFAULT NULL,
  `SentAt` datetime DEFAULT NULL,
  PRIMARY KEY (`ChatId`),
  KEY `Userid` (`Userid`),
  KEY `Supporrter` (`Supporrter`),
  CONSTRAINT `chatsupport_ibfk_1` FOREIGN KEY (`Userid`) REFERENCES `users` (`ID`),
  CONSTRAINT `chatsupport_ibfk_2` FOREIGN KEY (`Supporrter`) REFERENCES `users` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chatsupport`
--

LOCK TABLES `chatsupport` WRITE;
/*!40000 ALTER TABLE `chatsupport` DISABLE KEYS */;
/*!40000 ALTER TABLE `chatsupport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cities` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `ProviceId` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProviceId` (`ProviceId`),
  CONSTRAINT `cities_ibfk_1` FOREIGN KEY (`ProviceId`) REFERENCES `provinces` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `ClassId` int NOT NULL AUTO_INCREMENT,
  `ClassName` varchar(50) DEFAULT NULL,
  `CreateBy` int DEFAULT NULL,
  `DateCreate` datetime DEFAULT NULL,
  PRIMARY KEY (`ClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classcourse`
--

DROP TABLE IF EXISTS `classcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classcourse` (
  `CourseId` int DEFAULT NULL,
  `ClassId` int DEFAULT NULL,
  KEY `CourseId` (`CourseId`),
  KEY `ClassId` (`ClassId`),
  CONSTRAINT `classcourse_ibfk_1` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`),
  CONSTRAINT `classcourse_ibfk_2` FOREIGN KEY (`ClassId`) REFERENCES `class` (`ClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classcourse`
--

LOCK TABLES `classcourse` WRITE;
/*!40000 ALTER TABLE `classcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `classcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `CourseId` int NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(250) DEFAULT NULL,
  `Image` varchar(250) DEFAULT NULL,
  `CourseDescription` text,
  `DateCreate` datetime DEFAULT CURRENT_TIMESTAMP,
  `CourseTitle` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`CourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Java Course 1','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, youâll be able to develop large systems, software, and mobile applications â and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Introduction to Programming'),(2,'Java Course 2','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Data Structures'),(3,'Java Course 3','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Web Development'),(4,'Java Course 4','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','','2023-06-11 02:35:48','Database Management'),(5,'Java Course 5','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Object-Oriented Programming'),(6,'Java Course 6','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Network Security'),(7,'Java Course 7','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Software Engineering'),(8,'Java Course 8','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Artificial Intelligence'),(9,'Java Course 9','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Mobile App Development'),(10,'Java Course 10','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Cloud Computing'),(11,'Java Course 11','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Operating Systems'),(12,'Java Course 12','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Data Science'),(13,'Java Course 13','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Cybersecurity'),(14,'Java Course 14','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Computer Graphics'),(15,'Java Course 15','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Machine Learning'),(16,'Java Course 16','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Computer Networks'),(17,'Java Course 17','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Human-Computer Interaction'),(18,'Java Course 18','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Algorithms'),(19,'Java Course 19','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, youâll be able to develop large systems, software, and mobile applications â and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Software Testing'),(20,'Java Course 20','https://contentstatic.techgig.com/photo/93000110/What-makes-Java-still-popular-among-developers.jpg','Popular for its versatility and ability to create a wide variety of applications, learning Java opens up your possibilities when coding. With it, you’ll be able to develop large systems, software, and mobile applications — and even create mobile apps for Android. Learn important Java coding fundamentals and practice your new skills with real-world projects.','2023-06-11 02:35:48','Computer Architecture'),(21,'course 21','https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg','haha','2023-06-12 23:56:57',NULL),(22,'course 22','https://www.simplilearn.com/ice9/free_resources_article_thumb/what_is_image_Processing.jpg','aasdafsafas','2023-06-13 12:24:34',NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courseenrollment`
--

DROP TABLE IF EXISTS `courseenrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courseenrollment` (
  `EnrollmentId` int NOT NULL AUTO_INCREMENT,
  `UserId` int DEFAULT NULL,
  `CourseId` int DEFAULT NULL,
  `EnrollmentDate` datetime DEFAULT NULL,
  PRIMARY KEY (`EnrollmentId`),
  KEY `UserId` (`UserId`),
  KEY `CourseId` (`CourseId`),
  CONSTRAINT `courseenrollment_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `users` (`ID`),
  CONSTRAINT `courseenrollment_ibfk_2` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseenrollment`
--

LOCK TABLES `courseenrollment` WRITE;
/*!40000 ALTER TABLE `courseenrollment` DISABLE KEYS */;
/*!40000 ALTER TABLE `courseenrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `districts`
--

DROP TABLE IF EXISTS `districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `districts` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CityId` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CityId` (`CityId`),
  CONSTRAINT `districts_ibfk_1` FOREIGN KEY (`CityId`) REFERENCES `cities` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `districts`
--

LOCK TABLES `districts` WRITE;
/*!40000 ALTER TABLE `districts` DISABLE KEYS */;
/*!40000 ALTER TABLE `districts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `LessonId` int NOT NULL AUTO_INCREMENT,
  `WeekId` int DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `VideoPath` varchar(255) DEFAULT NULL,
  `Script` text,
  PRIMARY KEY (`LessonId`),
  KEY `WeekId` (`WeekId`),
  CONSTRAINT `lesson_ibfk_1` FOREIGN KEY (`WeekId`) REFERENCES `weekcourse` (`WeekId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lessonprogress`
--

DROP TABLE IF EXISTS `lessonprogress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lessonprogress` (
  `LessonProgressId` int NOT NULL AUTO_INCREMENT,
  `IsCompleted` tinyint(1) DEFAULT '0',
  `EnrollmentId` int DEFAULT NULL,
  PRIMARY KEY (`LessonProgressId`),
  KEY `EnrollmentId` (`EnrollmentId`),
  CONSTRAINT `lessonprogress_ibfk_1` FOREIGN KEY (`EnrollmentId`) REFERENCES `courseenrollment` (`EnrollmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lessonprogress`
--

LOCK TABLES `lessonprogress` WRITE;
/*!40000 ALTER TABLE `lessonprogress` DISABLE KEYS */;
/*!40000 ALTER TABLE `lessonprogress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `module` (
  `ModuleId` int NOT NULL AUTO_INCREMENT,
  `CourseId` int DEFAULT NULL,
  `ModuleName` varchar(100) DEFAULT NULL,
  `ModuleDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ModuleId`),
  KEY `CourseId` (`CourseId`),
  CONSTRAINT `module_ibfk_1` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,1,'modul1 for course1','in this module we will learn about Java basic '),(2,1,'module 2','Google Cloud has the tools Java developers need to be successful building cloud-native applications. Leverage deep integrations with familiar tools like Spring, Maven, Kubernetes, and IntelliJ to get started quickly.'),(3,1,'module 3','Google Cloud has the tools Java developers need to be successful building cloud-native applications. Leverage deep integrations with familiar tools like Spring, Maven, Kubernetes, and IntelliJ to get started quickly.'),(4,1,'module 4 ','Google Cloud has the tools Java developers need to be successful building cloud-native applications. Leverage deep integrations with familiar tools like Spring, Maven, Kubernetes, and IntelliJ to get started quickly.'),(5,19,'module 1','abcdef'),(6,2,'module 1','This module help you learn java basic ');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provinces` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CountryId` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `CountryId` (`CountryId`),
  CONSTRAINT `provinces_ibfk_1` FOREIGN KEY (`CountryId`) REFERENCES `countries` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `QuizId` int NOT NULL,
  `QContent` varchar(1000) DEFAULT NULL,
  `OptionA` varchar(1000) DEFAULT NULL,
  `AnswerA` bit(1) DEFAULT b'0',
  `OptionB` varchar(1000) DEFAULT NULL,
  `AnswerB` bit(1) DEFAULT b'0',
  `OptionC` varchar(1000) DEFAULT NULL,
  `AnswerC` bit(1) DEFAULT b'0',
  `OptionD` varchar(1000) DEFAULT NULL,
  `AnswerD` bit(1) DEFAULT b'0',
  PRIMARY KEY (`Id`),
  KEY `QuizId` (`QuizId`),
  CONSTRAINT `questions_ibfk_1` FOREIGN KEY (`QuizId`) REFERENCES `quiz` (`QuizId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `QuizId` int NOT NULL AUTO_INCREMENT,
  `QuizTopic` varchar(255) DEFAULT NULL,
  `WeekId` int DEFAULT NULL,
  `QTime` int DEFAULT NULL,
  `QuizName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`QuizId`),
  KEY `WeekId` (`WeekId`),
  CONSTRAINT `quiz_ibfk_1` FOREIGN KEY (`WeekId`) REFERENCES `weekcourse` (`WeekId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'java',1,15,'java basic quiz'),(8,'topic1',1,30,'Name'),(12,'javacourse',1,15,'Quiz test1'),(13,'15',1,30,'15'),(14,'15',1,30,'15'),(15,'15',1,30,'15'),(16,'javacourse 1',5,30,'Quiz test1'),(17,'151',1,30,'151');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizhistory`
--

DROP TABLE IF EXISTS `quizhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quizhistory` (
  `QuizHistoryId` int NOT NULL AUTO_INCREMENT,
  `QuestionId` int DEFAULT NULL,
  `QContent` varchar(1000) DEFAULT NULL,
  `OptionA` varchar(1000) DEFAULT NULL,
  `AnswerA` bit(1) DEFAULT b'0',
  `UserAnswerA` bit(1) DEFAULT b'0',
  `OptionB` varchar(1000) DEFAULT NULL,
  `AnswerB` bit(1) DEFAULT b'0',
  `UserAnswerB` bit(1) DEFAULT b'0',
  `OptionC` varchar(1000) DEFAULT NULL,
  `AnswerC` bit(1) DEFAULT b'0',
  `UserAnswerC` bit(1) DEFAULT b'0',
  `OptionD` varchar(1000) DEFAULT NULL,
  `AnswerD` bit(1) DEFAULT b'0',
  `UserAnswerD` bit(1) DEFAULT b'0',
  `UserID` int DEFAULT NULL,
  `QuizId` int DEFAULT NULL,
  PRIMARY KEY (`QuizHistoryId`),
  KEY `UserID` (`UserID`),
  KEY `QuizId` (`QuizId`),
  CONSTRAINT `quizhistory_ibfk_1` FOREIGN KEY (`UserID`) REFERENCES `users` (`ID`),
  CONSTRAINT `quizhistory_ibfk_2` FOREIGN KEY (`QuizId`) REFERENCES `quiz` (`QuizId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizhistory`
--

LOCK TABLES `quizhistory` WRITE;
/*!40000 ALTER TABLE `quizhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `quizhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizprogress`
--

DROP TABLE IF EXISTS `quizprogress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quizprogress` (
  `QuizProgressId` int NOT NULL AUTO_INCREMENT,
  `IsCompleted` tinyint(1) DEFAULT '0',
  `Score` decimal(5,2) DEFAULT NULL,
  `EnrollmentId` int DEFAULT NULL,
  PRIMARY KEY (`QuizProgressId`),
  KEY `EnrollmentId` (`EnrollmentId`),
  CONSTRAINT `quizprogress_ibfk_1` FOREIGN KEY (`EnrollmentId`) REFERENCES `courseenrollment` (`EnrollmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizprogress`
--

LOCK TABLES `quizprogress` WRITE;
/*!40000 ALTER TABLE `quizprogress` DISABLE KEYS */;
/*!40000 ALTER TABLE `quizprogress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `replyapplication`
--

DROP TABLE IF EXISTS `replyapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `replyapplication` (
  `ReplyApplicationId` int NOT NULL AUTO_INCREMENT,
  `ApplicationId` int DEFAULT NULL,
  `RepContent` text,
  `SendTime` datetime DEFAULT NULL,
  `Responder` int DEFAULT NULL,
  PRIMARY KEY (`ReplyApplicationId`),
  KEY `Responder` (`Responder`),
  KEY `ApplicationId` (`ApplicationId`),
  CONSTRAINT `replyapplication_ibfk_1` FOREIGN KEY (`Responder`) REFERENCES `users` (`ID`),
  CONSTRAINT `replyapplication_ibfk_2` FOREIGN KEY (`ApplicationId`) REFERENCES `application` (`ApplicationId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `replyapplication`
--

LOCK TABLES `replyapplication` WRITE;
/*!40000 ALTER TABLE `replyapplication` DISABLE KEYS */;
/*!40000 ALTER TABLE `replyapplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `residential_groups`
--

DROP TABLE IF EXISTS `residential_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `residential_groups` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `WardId` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `WardId` (`WardId`),
  CONSTRAINT `residential_groups_ibfk_1` FOREIGN KEY (`WardId`) REFERENCES `wards` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `residential_groups`
--

LOCK TABLES `residential_groups` WRITE;
/*!40000 ALTER TABLE `residential_groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `residential_groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'User'),(2,'Suporter'),(3,'Teacher'),(4,'Admin');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `SubjectId` int NOT NULL AUTO_INCREMENT,
  `SubjectName` varchar(250) DEFAULT NULL,
  `SubjectDescription` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`SubjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Java','j'),(2,'Python','p'),(3,'C#','c');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectcourse`
--

DROP TABLE IF EXISTS `subjectcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjectcourse` (
  `SubjectId` int NOT NULL,
  `CourseId` int NOT NULL,
  PRIMARY KEY (`SubjectId`,`CourseId`),
  KEY `CourseId` (`CourseId`),
  CONSTRAINT `subjectcourse_ibfk_1` FOREIGN KEY (`CourseId`) REFERENCES `course` (`CourseId`),
  CONSTRAINT `subjectcourse_ibfk_2` FOREIGN KEY (`SubjectId`) REFERENCES `subject` (`SubjectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectcourse`
--

LOCK TABLES `subjectcourse` WRITE;
/*!40000 ALTER TABLE `subjectcourse` DISABLE KEYS */;
INSERT INTO `subjectcourse` VALUES (1,1),(2,1),(3,1),(1,2),(2,2),(3,2),(1,3),(2,3),(3,3),(1,4),(2,4),(3,4),(1,5),(2,5),(3,5),(1,6),(2,6),(3,6),(1,7),(2,7),(3,7),(1,8),(2,8),(3,8),(1,9),(2,9),(3,9),(1,10),(2,10),(3,10),(1,11),(2,11),(3,11),(1,12),(2,12),(3,12),(1,13),(2,13),(3,13),(1,14),(3,14),(1,15),(2,15),(3,15),(1,16),(2,16),(3,16),(1,17),(2,17),(3,17),(1,18),(2,18),(1,19),(3,19),(1,20),(3,20),(2,21),(1,22),(2,22),(3,22);
/*!40000 ALTER TABLE `subjectcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userrole` (
  `UserId` int NOT NULL,
  `RoleId` int NOT NULL,
  PRIMARY KEY (`UserId`,`RoleId`),
  KEY `RoleId` (`RoleId`),
  CONSTRAINT `userrole_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `users` (`ID`),
  CONSTRAINT `userrole_ibfk_2` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userrole`
--

LOCK TABLES `userrole` WRITE;
/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` VALUES (1,1),(3,1),(4,1),(5,1),(6,1);
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `FirstName` varchar(250) DEFAULT NULL,
  `LastName` varchar(250) DEFAULT NULL,
  `Email` varchar(250) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `AddressId` int DEFAULT NULL,
  `Image` blob,
  `DOB` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `AddressId` (`AddressId`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`AddressId`) REFERENCES `address` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'duannv','MTIz',NULL,NULL,'abc@123.com',NULL,7,NULL,NULL),(3,'admin','YWRtaW4jMDE=',NULL,NULL,'abc@123.com',NULL,8,NULL,NULL),(4,'duannv1011','RHVhbjEwMTFA',NULL,NULL,'duan101120@gmail.com',NULL,10,NULL,NULL),(5,'admin100','QWRtaW4xMDBA',NULL,NULL,'admin100@gmail.com',NULL,11,NULL,NULL),(6,'duannv10000','S2FrYWthQDEyMw==',NULL,NULL,'duan101120@gmail.com',NULL,12,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wards`
--

DROP TABLE IF EXISTS `wards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wards` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `DistrictID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `DistrictID` (`DistrictID`),
  CONSTRAINT `wards_ibfk_1` FOREIGN KEY (`DistrictID`) REFERENCES `districts` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wards`
--

LOCK TABLES `wards` WRITE;
/*!40000 ALTER TABLE `wards` DISABLE KEYS */;
/*!40000 ALTER TABLE `wards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekcourse`
--

DROP TABLE IF EXISTS `weekcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weekcourse` (
  `WeekId` int NOT NULL AUTO_INCREMENT,
  `ModuleId` int DEFAULT NULL,
  `WeekNumber` int DEFAULT NULL,
  `WeekTitle` varchar(255) DEFAULT NULL,
  `WeekDescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`WeekId`),
  KEY `ModuleId` (`ModuleId`),
  CONSTRAINT `weekcourse_ibfk_1` FOREIGN KEY (`ModuleId`) REFERENCES `module` (`ModuleId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekcourse`
--

LOCK TABLES `weekcourse` WRITE;
/*!40000 ALTER TABLE `weekcourse` DISABLE KEYS */;
INSERT INTO `weekcourse` VALUES (1,1,1,'week 1','this week will learn about operator in java'),(2,5,1,'week1','1111'),(3,5,2,'week2','Æ°eeeeee2'),(4,1,2,'week2','wwwwwwwwwwwwwwwwwwa'),(5,6,1,'week1',' learn operator and conditon ');
/*!40000 ALTER TABLE `weekcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'learning_site'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-10 20:43:21
