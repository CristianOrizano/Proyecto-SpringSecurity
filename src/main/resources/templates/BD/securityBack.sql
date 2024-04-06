CREATE DATABASE  IF NOT EXISTS `sts_security` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sts_security`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: sts_security
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `id_bole` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `fecha` date DEFAULT NULL,
  `codigo` int DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_bole`),
  KEY `FKcjy1r2qn45ocorkpqhy85txqw` (`codigo`),
  KEY `FKck9nxiwf5e2os2svcv0qdqj7j` (`id_usuario`),
  CONSTRAINT `FKcjy1r2qn45ocorkpqhy85txqw` FOREIGN KEY (`codigo`) REFERENCES `tb_electrodomesticos` (`codigo`),
  CONSTRAINT `FKck9nxiwf5e2os2svcv0qdqj7j` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--

LOCK TABLES `tb_boleta` WRITE;
/*!40000 ALTER TABLE `tb_boleta` DISABLE KEYS */;
INSERT INTO `tb_boleta` VALUES (1,2,'2023-07-30',1,101),(2,1,'2023-07-31',1,101);
/*!40000 ALTER TABLE `tb_boleta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_electrodomesticos`
--

DROP TABLE IF EXISTS `tb_electrodomesticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_electrodomesticos` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nom_archivo` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_electrodomesticos`
--

LOCK TABLES `tb_electrodomesticos` WRITE;
/*!40000 ALTER TABLE `tb_electrodomesticos` DISABLE KEYS */;
INSERT INTO `tb_electrodomesticos` VALUES (1,'oster','olla Arrocera','2009.jpg',900,50),(2,'Oster','lucuadora','10011.PNG',1500,50),(3,'Samnsung','Refrigeradora black','2005.jpg',1500,60),(4,'oster','fhfghfg','',1000,10);
/*!40000 ALTER TABLE `tb_electrodomesticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'USER'),(2,'ADMIN'),(3,'CAJERO');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (100,'orizano','cristian@gmail.com','cristian orizano','$2a$10$MuV88P1T/hsovjszgtT7Wem59.PGmFVRuvF2ICLXviVnR7uH6KC/W','cristian@gmail.com'),(101,'Salazar','nini@gmail','Nini salazar','$2a$10$MuV88P1T/hsovjszgtT7Wem59.PGmFVRuvF2ICLXviVnR7uH6KC/W','nini@gmail.com'),(104,'Alvares Lopes','lucas50@gmail.com','lucas','$2a$10$MMXQwNYUPdTbNKwrLOBYge3ZaQ5vPsOhhbOOzuyiyEFQJ9Y7FwCUe','lucas@gmail.com'),(105,'Reinf','cristian@gmail57','Roman','$2a$10$tfXRcIX9UlMr.cernHNAqeyTg58qxgyAMwTQWJOwkYOFH4QgRJNkG','ana'),(106,'Dorw','i201912294@cibertec.edu.pe','asaff','$2a$10$ccNgBw/WecfQzUflHY453uVV7uR5lBzN8NO53ylKhBudsSrJZ9STS','asaf'),(107,'Swift','i201912294@cibertec.edu.pe','Taylor','$2a$10$kMScFsCVORRXdwTy4H7bkOuGd8W4X/9/mF.VVSJetLYhY8Zl4QKrm','taylor'),(108,'Orizano','cristian@gmail57','kim','$2a$10$Ken3BEnSe1iRKK5PnVQtG.ZLVWxCZ2MyUayGM7sYCPbOGaWOaNAjK','kim');
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_role`
--

DROP TABLE IF EXISTS `usuario_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_role` (
  `id_usuario` int NOT NULL,
  `id_rol` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `FK13ad1sf5q7cr6xp5qcnimbpoa` (`id_rol`),
  CONSTRAINT `FK13ad1sf5q7cr6xp5qcnimbpoa` FOREIGN KEY (`id_rol`) REFERENCES `tb_rol` (`id_rol`),
  CONSTRAINT `FK83y4586107wo4pjki246pse1w` FOREIGN KEY (`id_usuario`) REFERENCES `tb_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_role`
--

LOCK TABLES `usuario_role` WRITE;
/*!40000 ALTER TABLE `usuario_role` DISABLE KEYS */;
INSERT INTO `usuario_role` VALUES (101,1),(104,1),(107,1),(100,2),(106,2),(105,3),(108,3);
/*!40000 ALTER TABLE `usuario_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sts_security'
--

--
-- Dumping routines for database 'sts_security'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 20:19:57
