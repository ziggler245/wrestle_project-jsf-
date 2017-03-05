CREATE DATABASE  IF NOT EXISTS `forum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `forum`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: forum
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Dumping data for table `wrestlers`
--

LOCK TABLES `wrestlers` WRITE;
/*!40000 ALTER TABLE `wrestlers` DISABLE KEYS */;
INSERT INTO `wrestlers` VALUES (1,'AJ Styles','1977',180,'2015','aj_styles.jpg',90,'Figure-four leglock,Spiral Tap,Styles Clash','Male'),(2,'Brock Lesnar','1980',185,'2000','b_lesnar.jpg',110,'Kimura lock,Shooting star press,F-5','Male'),(3,'Big Show','1975',210,'2001','b_show.png',200,'Chokeslam','Male'),(4,'Chris Jericho','1970',190,'2003','c_jerricho.jpg',190,'Breakdown ,Walls of Jericho','Male'),(5,'Cm Punk','1975',172,'1999','c_punk.jpg',110,'Anaconda vise,GTS,Diving crossbody','Male'),(6,'Dean Ambrose','1989',180,'2014','d_ambrose.jpg',120,'Air Lunatic,Corner forearm smash,Tornado DDT','Male'),(7,'Daniel Bryan','1978',172,'2005','d_bryan.jpg',110,'Guillotine choke,LeBell Lock,Ankle lock','Male'),(8,'Edge','1975',178,'2001','edge.jpg',105,'Diving crossbody,Spear','Male'),(9,'Aj Lee','1989',180,'2003','aj_lee.jpg',60,'Black Widow,Shining Wizard,Diving crossbody','Female'),(10,'Becky Lynch','1990',175,'2008','b_lynch.png',75,'Four-Leg Clover,Exploder,Back kick','Female'),(11,'Bayley','1989',180,'2007','bayley.jpg',80,'Rose Plant,Bayley-to-Belly,Bayleycanrana','Female'),(12,'Carmella','1990',170,'2009','carmella.jpg',70,'Superkick,Code of Silence','Female'),(13,'Charlotte ','1989',175,'2010','charlotte.jpg',70,'Spear,Figure Eight Leglock','Female'),(14,'Eva Marie','1973',170,'2006','e_marie.png',70,'Sliced Red,Running senton','Female'),(15,'Eve Torres','1985',178,'2005','e_torres.jpg',72,'Evesault ','Female');
/*!40000 ALTER TABLE `wrestlers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-17  0:36:56
