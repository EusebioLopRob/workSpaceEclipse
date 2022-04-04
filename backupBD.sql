-- MySQL dump 10.13  Distrib 8.0.28, for Linux (x86_64)
--
-- Host: localhost    Database: MVC_JSP
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `PRODUCTOS`
--

DROP TABLE IF EXISTS `PRODUCTOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCTOS` (
  `CODPROD` varchar(10) NOT NULL,
  `SECCION` varchar(50) DEFAULT NULL,
  `NOMBREPROD` varchar(50) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `IMPORTADO` tinyint DEFAULT '0',
  `PAISORIGEN` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CODPROD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTOS`
--

LOCK TABLES `PRODUCTOS` WRITE;
/*!40000 ALTER TABLE `PRODUCTOS` DISABLE KEYS */;
INSERT INTO `PRODUCTOS` VALUES ('p1','Ferretería','destornillador',6.8,'2019-02-18',0,'Indonesia'),('p2','Confección','traje caballero',168.8,'2018-12-13',1,'China'),('p3','Deportes','raqueta tenis',100.8,'2017-12-23',1,'USA'),('p4','Confección','camisa caballero',5.4,'2018-12-13',0,'España'),('p5','Ferretería','llave inglesa',16,'2018-12-13',0,'España'),('p6','Ferretería','Tornillo',0.34,'2021-01-01',1,'Francia'),('p7','Ferretería','Tuerca',0.34,'2021-01-02',0,'España');
/*!40000 ALTER TABLE `PRODUCTOS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RECETA`
--

DROP TABLE IF EXISTS `RECETA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RECETA` (
  `titulo` varchar(20) NOT NULL,
  `tipo_harina` varchar(20) DEFAULT NULL,
  `cant_harina` smallint DEFAULT NULL,
  `liq_agua` smallint DEFAULT NULL,
  `liq_leche` smallint DEFAULT NULL,
  `liq_aceite` smallint DEFAULT NULL,
  `cant_lev` smallint DEFAULT NULL,
  `cant_azu` smallint DEFAULT NULL,
  `cant_sal` smallint DEFAULT NULL,
  `preparacion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RECETA`
--

LOCK TABLES `RECETA` WRITE;
/*!40000 ALTER TABLE `RECETA` DISABLE KEYS */;
/*!40000 ALTER TABLE `RECETA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIOS`
--

DROP TABLE IF EXISTS `USUARIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIOS` (
  `ID_USUARIO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDOS` varchar(20) NOT NULL,
  `USUARIO` varchar(20) NOT NULL,
  `CONTRASENA` varchar(20) NOT NULL,
  `PAIS` varchar(20) DEFAULT NULL,
  `TECNOLOGIA` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  UNIQUE KEY `USUARIO` (`USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIOS`
--

LOCK TABLES `USUARIOS` WRITE;
/*!40000 ALTER TABLE `USUARIOS` DISABLE KEYS */;
INSERT INTO `USUARIOS` VALUES (1,'Javier','Sánchez','jav','jav','España','JAVA'),(2,'Teresa','López','ter','ter','España','MECÁNICA'),(3,'Agustín','Domínguez','agu','agu','Alemania','JAVA'),(4,'Euse','Lop','Sav','1234','Espana','Ja');
/*!40000 ALTER TABLE `USUARIOS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-04 12:42:02
