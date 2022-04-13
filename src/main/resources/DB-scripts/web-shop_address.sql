-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: web-shop
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'afasa','Canada','Alberta','afasa','afasa'),(2,'same','Canada','Alberta','same','afasa'),(3,'afasa','Canada','Alberta','afasa','afasa'),(4,'same','Canada','Alberta','same','afasa'),(5,'afasa','Canada','Alberta','afasa','afasa'),(6,'same','Canada','Alberta','same','afasa'),(7,'afasa','Canada','Alberta','afasa','afasa'),(8,'same','Canada','Alberta','same','afasa'),(9,'asd','United States','Alabama','asd','asd'),(10,'asd','United States','Alabama','asd','asd'),(11,'dasdasd','India','Andhra Pradesh','asdas','asda'),(12,'dasdasd','India','Andhra Pradesh','asdas','asda'),(13,'afasa','Canada','Alberta','afasa','afasa'),(14,'same','Canada','Alberta','same','afasa'),(15,'afasa','Canada','Alberta','afasa','afasa'),(16,'same','Canada','Alberta','same','afasa'),(17,'asd','Canada','Alberta','asda','asd'),(18,'asd','Canada','Alberta','asda','asd'),(19,'123123','Turkey','Adıyaman','123123','123'),(20,'123123','Turkey','Adıyaman','123123','123'),(21,'asd','United States','Alabama','asdas','asd'),(22,'asd','United States','Alabama','asdas','asd'),(23,'asd','Turkey','Adıyaman','weqw','qwe'),(24,'asd','Turkey','Adıyaman','weqw','qwe'),(25,'123','Canada','Alberta','123','123'),(26,'123','Canada','Alberta','123','123'),(27,'random','Turkey','Adıyaman','random','random'),(28,'random','Turkey','Adıyaman','random','random'),(29,'test','Turkey','Niğde','test','1231'),(30,'test','Turkey','Niğde','test','1231'),(31,'test','United States','Alabama','test','123'),(32,'test','United States','Alabama','test','123'),(33,'test','United States','Alabama','test','123'),(34,'test','United States','Alabama','test','123'),(35,'asd','Canada','Alberta','asd','asd'),(36,'asd','Canada','Alberta','asd','asd');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-13 16:01:47
