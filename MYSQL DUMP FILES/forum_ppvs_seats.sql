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
-- Dumping data for table `ppvs_seats`
--

LOCK TABLES `ppvs_seats` WRITE;
/*!40000 ALTER TABLE `ppvs_seats` DISABLE KEYS */;
INSERT INTO `ppvs_seats` VALUES (1,'Royal Rumble','27','/pages/ppv/RoyalRumble.xhtml?faces-redirect=true','royalrumble.jpg'),(2,'Fastlane','27','/pages/ppv/Fastlane.xhtml?faces-redirect=true','fastlane.jpg'),(3,'WrestleMania','27','/pages/ppv/WrestleMania.xhtml?faces-redirect=true','wrestlemania.jpg'),(4,'Extreme Rules','27','/pages/ppv/ExtremeRules.xhtml?faces-redirect=true','extreme_rules.jpg'),(5,'Payback','27','/pages/ppv/Payback.xhtml?faces-redirect=true','payback.jpg'),(6,'Money in the bank','27','/pages/ppv/MoneyInTheBank.xhtml?faces-redirect=true','money_in_the_bank.jpg'),(7,'Battleground','27','/pages/ppv/Battleground.xhtml?faces-redirect=true','battleground.jpg'),(8,'SummerSlam','27','/pages/ppv/Summerslam.xhtml?faces-redirect=true','summer_slam.jpeg'),(9,'Backlash','27','/pages/ppv/Backlash.xhtml?faces-redirect=true','backlash.jpg'),(10,'Clash Of Champions','27','/pages/ppv/ClashOfChampions.xhtml?faces-redirect=true','clash_of_champions.jpg'),(11,'No Mercy','27','/pages/ppv/NoMercy.xhtml?faces-redirect=true','no_mercy.jpg'),(12,'TLC','27','/pages/ppv/TLC.xhtml?faces-redirect=true','tlc.jpg');
/*!40000 ALTER TABLE `ppvs_seats` ENABLE KEYS */;
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
