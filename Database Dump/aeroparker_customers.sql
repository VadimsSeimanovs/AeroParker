-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: aeroparker
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `REGISTERED` datetime NOT NULL,
  `E-MAIL ADDRESS` varchar(255) NOT NULL,
  `TITLE` varchar(5) NOT NULL,
  `FIRST NAME` varchar(50) NOT NULL,
  `LAST NAME` varchar(50) NOT NULL,
  `ADDRESS LINE 1` varchar(255) NOT NULL,
  `ADDRESS LINE 2` varchar(255) DEFAULT NULL,
  `CITY` varchar(255) NOT NULL,
  `POSTCODE` varchar(10) NOT NULL,
  `TELEPHONE NUMBER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `email address_UNIQUE` (`E-MAIL ADDRESS`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'2020-08-13 15:52:07','vadims.seimanovs@gmail.com','Sir','Vadims','Seimanovs','Address','','City','SK4 3EA','546456456'),(2,'2020-08-13 17:00:02','test@test.com','Sir','twets','tset','test','','test','sk13pj','0'),(3,'2020-08-13 17:01:55','test@test.co.uk','Sir','sadsad','dasdsad','test','','test','sk13pj','0'),(4,'2020-08-13 17:20:23','test@gmail.com','Sir','Test','TestSurname','1 Test Address','','Stockport','SK1 3PJ',''),(6,'2020-08-13 18:26:59','elean@test.com','Sir','tedst','ytst','test','','test','sk13pj',''),(7,'2020-08-13 18:34:20','sdfsd@dsfggfd.com','Sir','dfgdfs','sdgsd','dffdg','','sdfgds','sk13pj',''),(8,'2020-08-13 18:55:18','rwerwe@test.com','Sir','wetrwert','ewrweer','hjsdfjkhsa','','jwsdfhsk','sk13pj',''),(9,'2020-08-13 18:58:10','fsdg@dfsgh.com','Sir','Test123123','Test23142315','asdfhb','','hsabfd','SJ4 3DS',''),(13,'2020-08-13 20:15:41','vadims.seimanovs11@gmail.com','Sir','TEST','SFDAJNK','sdfkasdfm','','Stockport','Sk1 3pj',''),(14,'2020-08-13 20:45:48','vadims.seimanovs09@gmail.com','Sir','Vadims','Seimanovs','sdafsdf sdafasdf','','Stockport','SK10 5PQ',''),(15,'2020-08-13 20:48:39','asdhjfb@dsfa.com','Sir','Test','Test','asdhbf','','sdadhbf','Sk23 3qw',''),(16,'2020-08-13 20:49:48','sadfsdf@dsaf.cpv','Sir','Testy','asadf','asdf aSDF','','ASDA','sK1 3AS',''),(17,'2020-08-13 20:51:10','dsafnjsad@sdaf','Sir','Test','test','sdfaasdf','','asdf','SD12 3AS',''),(18,'2020-08-13 20:52:03','ssdjfna@sadf','Sir','Vadims','sdjfkaj','sdaf','','sadf','Sk1 3as',''),(19,'2020-08-13 20:58:38','dfsd@fsd/com','Miss','ds','sdfsd','dsfds','fsdf','fsd','sk13pj',''),(20,'2020-08-13 21:01:09','dsf@sdd.com','Sir','sdfds','fsdf','sfd','sdf','dsf','sk13pj',''),(21,'2020-08-13 21:02:04','dsf:@sdfsd.com','Sir','fdsfds','sdfds','dsdsd','','sdfds','sk13pj',''),(22,'2020-08-13 21:08:38','vasdv@asdf.com','Sir','TEST','SADF','sadfsa ','','sdafas','SK1 3KS',''),(23,'2020-08-13 21:50:00','elena.alexandra189@gmail.com','Sir','gfhgffgh','fghgfh','fghfg','fghfg','fghf','la141bx','56754546'),(24,'2020-08-13 21:55:01','sdfsd','Sir','sdfds','sdfsdsd','sdfsd','','sdfsd','sk13pj','435543453445343'),(25,'2020-08-13 21:56:53','fghfghgf@ds.com','Sir','trrtr','hgf','dfsd','','eefsd','sk13pj','4343434543534'),(26,'2020-08-13 21:58:53','ghjjhg@sd.com','Sir','jgjgf','gjhjh','sdfgds','d','sdfsdf','sk13pj',''),(27,'2020-08-13 21:59:48','sdfsd@sdfsd.com','Sir','sdfds','sdfds','sdfds','','sdfsd','sk13pj',''),(28,'2020-08-13 22:00:34','hfghgf@sdfsd.com','Sir','ghjgfh','hfgh','sddsf','','dsfsdf','sk13pj',''),(29,'2020-08-13 22:01:41','dfssd@dgdf.com','Sir','sfsdf','fsd','sdfsdfsd','','sdfsdf','sk13pj',''),(30,'2020-08-13 22:05:45','trytr@dsfsd.com','Sir','rtyrt','trytry','fsdf','','sdfsd','sk13pj',''),(31,'2020-08-13 22:13:03','sdfds@gmail.com','Sir','dfds','fds','sdfs','sdf','fds','sk13pj',''),(32,'2020-08-13 22:15:18','fsdf@dfsd.com','Sir','fdsfds','dsfsd','dfs','','sdfsd','sk13pj',''),(33,'2020-08-13 22:27:25','errert@sdfs.com','Sir','ewr esr','sdfsd ','dfsdf','','sfsdf','sk13pj',''),(34,'2020-08-13 22:34:59','trsdahasfdb@dsfsda.sad','Sir','Test','test','sadfsadf','','sdafsadf','Sk23 3qa',''),(35,'2020-08-13 22:36:13','dsaf@fdas.sdaf','Sir','sdafdsfa','sadfsadf','asdfsadf','','sadfsadf','AS23 3AS',''),(36,'2020-08-13 23:23:15','test12343@sdfasda.dsa','Sir','Vadims','Seimanovs','asdfhbb','','shajdfb','SK1 3AS',''),(37,'2020-08-13 23:31:06','test123123@dsafasd.cov','Sir','Vadims','Seimanovs','dsfafds','','Salford','SA12 1AS',''),(38,'2020-08-13 23:32:20','maks.gars@gmail.com','Sir','Maks','Gars','dsfadf sdf','','Heywood','OL10 3JR',''),(39,'2020-08-13 23:33:59','sadf@asdf.cas','Sir','asdfasd','fsadf','asdf','','asdfsadf','sd12 3aa',''),(40,'2020-08-13 23:36:05','asdfs@adf.com','Sir','sadfsdaf','asdfsadf','sdafsadf','','asdfsadf','Sk1 1aa',''),(41,'2020-08-13 23:36:55','dsfgdfsg@sdfg.vsd','Sir','sdfgdsfg','dsfgsdfgdsfg','sdfgdfsg','','sdfgdfsg','LK1 1AA',''),(42,'2020-08-13 23:38:55','sadfasdf@asfs.coi','Sir','hjdskafhjsa','sdhjfajh','sdafasdf','','asdfsadf','KA12 1AZ',''),(43,'2020-08-13 23:41:19','sadfsadf@xzcv.co','Sir','asfdasdf','sadfsadf','sdafasf','','sdfadf','SL12 1AS',''),(44,'2020-08-13 23:44:14','testets@test.com','Sir','VadimsTest','SeimanovsTest','asdas','','Salford','Ol10 3aq',''),(45,'2020-08-13 23:47:26','sadfbhjasdf@fdgdf.com','Sir','hjdfsgbhsdf','sdafhbsadf','sdafnjsdf','','City','Sk1 3oa',''),(46,'2020-08-13 23:53:34','elena.secara@test.com','Sir','test','tset','test','','test','la13 1bx','');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-14  0:06:59
