-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: OnlineFoodOrderingSystem
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phoneNo` varchar(10) DEFAULT NULL,
  `areaAddress` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `flat` int DEFAULT NULL,
  `pasword` varchar(100) NOT NULL,
  `cnfirmpassword` varchar(100) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'go','glo','lush@gmail.com','0745689521','bellville, chez Danel','31teddington Road',28,'fifi','fifi');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `cellphone` varchar(10) DEFAULT NULL,
  `staffNo` varchar(8) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`staffNo`),
  UNIQUE KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (7,'Rachel','Bintu','0741023658','65202169','RaBi#834'),(6,'jomack','Mputu','0784512563','65202179','joMp#554'),(2,'Franck','Muland','0782014785','66202173','FrMu#404'),(5,'Junior','garoule','0845236589','67202187','Juga#844'),(1,'Prince','schenider','0785441236','69202175','Prsc#834'),(3,'Juliana','mianda','0654786324','76202178','Jumi#864');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `managerlogin`
--

DROP TABLE IF EXISTS `managerlogin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `managerlogin` (
  `name` varchar(20) NOT NULL,
  `staffNumber` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`staffNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `managerlogin`
--

LOCK TABLES `managerlogin` WRITE;
/*!40000 ALTER TABLE `managerlogin` DISABLE KEYS */;
INSERT INTO `managerlogin` VALUES ('lushombo','216042062','Lus@2062');
/*!40000 ALTER TABLE `managerlogin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Order_No` int NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `Items` varchar(100) NOT NULL,
  `Quantity` varchar(10) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `total_Price` varchar(50) NOT NULL,
  PRIMARY KEY (`Order_No`),
  KEY `email` (`email`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`email`) REFERENCES `customers` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'lush@gmail.com','Salad','1','3.5','received','3.5'),(3,'lush@gmail.com','Vietnam Food','2','6.5','received','13.0'),(4,'lush@gmail.com','Chicken Rice','1','3.5','received','3.5'),(5,'lush@gmail.com','Chicken Rice','1','3.5','received','3.5'),(6,'lush@gmail.com','Chicken Rice','1','3.5','received','3.5'),(7,'lush@gmail.com','Raspberry','1','3.5','received','3.5'),(8,'lush@gmail.com','Chicken Rice','1','3.5','received','3.5'),(9,'lush@gmail.com','Raspberry','1','3.5','received','3.5'),(10,'lush@gmail.com','Strawberry Cake','1','2.5','received','2.5');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rate` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `feedback` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `email` (`email`),
  CONSTRAINT `rate_ibfk_1` FOREIGN KEY (`email`) REFERENCES `customers` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (1,'lush@gmail.com','happy');
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-04 22:36:50
