-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: lost_children
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `found`
--

DROP TABLE IF EXISTS `found`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `found` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `mother_name` varchar(20) DEFAULT NULL,
  `image_url` varchar(2000) DEFAULT NULL,
  `from_age` int(11) DEFAULT NULL,
  `to_age` int(11) DEFAULT NULL,
  `gender` varchar(5) NOT NULL,
  `found_date` varchar(45) DEFAULT NULL,
  `found_location` varchar(200) DEFAULT NULL,
  `description` longtext,
  `returned` varchar(5) NOT NULL DEFAULT 'no',
  `found_user_id` int(11) NOT NULL,
  `current_location` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user1_id_idx` (`found_user_id`),
  CONSTRAINT `found_user_id` FOREIGN KEY (`found_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `found`
--

LOCK TABLES `found` WRITE;
/*!40000 ALTER TABLE `found` DISABLE KEYS */;
INSERT INTO `found` VALUES (6,NULL,NULL,NULL,'found_images\\islamanwar27@gmail.com-Mon-Jun-04-10-11-58-GMT-08-00-2018291617594559910.jpg',NULL,NULL,'male',NULL,NULL,NULL,'no',1,NULL),(7,'islam',NULL,NULL,'found_images\\islamanwar27@gmail.com-Mon-Jun-04-10-11-58-GMT-08-00-2018291617594559910.jpg',NULL,NULL,'male',NULL,NULL,NULL,'no',1,NULL),(8,'islam',NULL,NULL,'found_images\\islamanwar27@gmail.com-Mon-Jun-04-10-11-58-GMT-08-00-2018291617594559910.jpg',NULL,NULL,'male',NULL,NULL,NULL,'yes',1,NULL);
/*!40000 ALTER TABLE `found` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lost`
--

DROP TABLE IF EXISTS `lost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `image_url` varchar(2000) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `orginal_address` varchar(100) DEFAULT NULL,
  `phone` varchar(45) NOT NULL,
  `gender` varchar(5) NOT NULL,
  `lost_date` varchar(45) DEFAULT NULL,
  `description` longtext,
  `returned` varchar(5) NOT NULL,
  `lost_location` varchar(200) DEFAULT NULL,
  `lost_user_id` int(11) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `mother_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`lost_user_id`),
  CONSTRAINT `lost_user_id` FOREIGN KEY (`lost_user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lost`
--

LOCK TABLES `lost` WRITE;
/*!40000 ALTER TABLE `lost` DISABLE KEYS */;
INSERT INTO `lost` VALUES (1,'islam','lost_images/islamanwar27@gmail.com-Mon-Jun-04-10-11-58-GMT-08-00-2018291617594559910.jpg',10,'asdasdasdasd','01288973254','male','dasdas','dasdasdsad','yes','dasdsadsad',1,'adasdsad','asdsadasd'),(2,'dsadad','lost_images/islamanwar27@gmail.com-Mon-Jun-04-10-11-58-GMT-08-00-2018291617594559910.jpg',22,'dsadasdsad','dasdadasd','male','asdasda','adadasdsa','no','adadasda',1,'asdasdasd','dasdasdas');
/*!40000 ALTER TABLE `lost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `image_url` varchar(2000) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'islam','anwar','users_images\\islamanwar27@gmail.com.jpg','islamanwar27@gmail.com','islamanwar',NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-27  6:52:25
