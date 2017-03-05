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
-- Dumping data for table `ppv`
--

LOCK TABLES `ppv` WRITE;
/*!40000 ALTER TABLE `ppv` DISABLE KEYS */;
INSERT INTO `ppv` VALUES (1,'Royal Rumble',1,'royal_rumble.jpg','/pages/ppv/RoyalRumble.xhtml?faces-redirect=true'),(2,'Fastlane',2,'fastlane.jpg','/pages/ppv/Fastlane.xhtml?faces-redirect=true'),(3,'WrestleMania ',3,'wrestlemania.jpg','/pages/ppv/WrestleMania.xhtml?faces-redirect=true'),(4,'Extreme Rules',4,'extreme_rules.jpg','/pages/ppv/ExtremeRules.xhtml?faces-redirect=true'),(5,'Payback',5,'payback.jpg','/pages/ppv/Payback.xhtml?faces-redirect=true'),(6,'Money in the Bank',6,'money_in_the_bank.jpg','/pages/ppv/MoneyInTheBank.xhtml?faces-redirect=true'),(7,'Battleground',7,'battleground.jpg','/pages/ppv/Battleground.xhtml?faces-redirect=true'),(8,'SummerSlam',8,'summer_slam.jpg','/pages/ppv/Summerslam.xhtml?faces-redirect=true'),(9,'Backlash',9,'backlash.jpg','/pages/ppv/Backlash.xhtml?faces-redirect=true'),(10,'Clash Of Champions',10,'clash_of_champions.jpg','/pages/ppv/ClashOfChampions.xhtml?faces-redirect=true'),(11,'No Mercy',11,'no_mercy.jpg','/pages/ppv/NoMercy.xhtml?faces-redirect=true'),(12,'TLC',12,'tlc.jpg','/pages/ppv/TLC.xhtml?faces-redirect=true');
/*!40000 ALTER TABLE `ppv` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-17  0:36:57
