CREATE DATABASE  IF NOT EXISTS `monopoly` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `monopoly`;
-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: monopoly
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `cartas`
--

DROP TABLE IF EXISTS `cartas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartas` (
  `idCarta` int NOT NULL AUTO_INCREMENT,
  `tipoCarta` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `textoCarta` varchar(150) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `accionCarta` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `valorCarta` int DEFAULT NULL,
  `destinoCarta` int DEFAULT NULL,
  PRIMARY KEY (`idCarta`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartas`
--

LOCK TABLES `cartas` WRITE;
/*!40000 ALTER TABLE `cartas` DISABLE KEYS */;
INSERT INTO `cartas` VALUES (1,'SUERTE','Avance hasta la casilla de Salida.','MOVER',0,1),(2,'SUERTE','Avance hasta la Calle Alcalá. Si pasa por la casilla de Salida, cobre 200€.','MOVER',200,25),(3,'SUERTE','Avance hasta el Paseo de la Castellana.','MOVER',0,40),(4,'SUERTE','La banca le paga un dividendo de 50€.','COBRAR',50,NULL),(5,'SUERTE','Multa por exceso de velocidad. Pague 15€.','PAGAR',15,NULL),(6,'SUERTE','Vaya directamente a la cárcel sin pasar por la casilla de Salida y sin cobrar los 200€.','IR_A_CARCEL',0,11),(7,'SUERTE','Retroceda tres casillas.','MOVER_ATRAS',3,NULL),(8,'SUERTE','Haga reparaciones en todas sus propiedades. Pague 25€ por cada casa.','REPARAR_CASAS',25,NULL),(9,'SUERTE','Queda libre de la cárcel. Esta carta puede conservarse hasta que se necesite.','SALIR_CARCEL',0,NULL),(10,'COMUNIDAD','Error de la banca a su favor. Cobre 200€.','COBRAR',200,NULL),(11,'COMUNIDAD','Gastos médicos. Pague 50€.','PAGAR',50,NULL),(12,'COMUNIDAD','Por la venta de sus acciones, recibe 100€.','COBRAR',100,NULL),(13,'COMUNIDAD','Hacienda le devuelve 20€.','COBRAR',20,NULL),(14,'COMUNIDAD','Es su cumpleaños. Recibe 10€ de cada jugador.','CUMPLEANOS',10,NULL),(15,'COMUNIDAD','Le toca el premio anual de la lotería. Cobre 100€.','COBRAR',100,NULL),(16,'COMUNIDAD','Pague la fianza del hospital de 100€.','PAGAR',100,NULL),(17,'COMUNIDAD','Pague la escuela privada. 150€.','PAGAR',150,NULL),(18,'COMUNIDAD','Vaya directamente a la cárcel sin pasar por la casilla de Salida y sin cobrar los 200€.','IR_A_CARCEL',0,11);
/*!40000 ALTER TABLE `cartas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `casillas`
--

DROP TABLE IF EXISTS `casillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `casillas` (
  `idCasilla` int NOT NULL AUTO_INCREMENT,
  `nombreCasilla` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tipoCasilla` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `colorCasilla` varchar(7) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `grupoCasilla` int DEFAULT NULL,
  `precioCasilla` int DEFAULT NULL,
  `alquilerCasilla` int DEFAULT NULL,
  PRIMARY KEY (`idCasilla`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `casillas`
--

LOCK TABLES `casillas` WRITE;
/*!40000 ALTER TABLE `casillas` DISABLE KEYS */;
INSERT INTO `casillas` VALUES (1,'Salida','ESPECIAL',NULL,NULL,NULL,NULL),(2,'Calle Mediterráneo','PROPIEDAD','#955436',1,60,2),(3,'Caja Comunidad','COMUNIDAD',NULL,NULL,NULL,NULL),(4,'Calle Báltico','PROPIEDAD','#955436',1,60,4),(5,'Impuesto Renta','IMPUESTO',NULL,NULL,200,NULL),(6,'Est. Sur','ESTACION','#B4B4B4',NULL,200,25),(7,'Av. Mediterránea','PROPIEDAD','#AAE0FA',2,100,6),(8,'Suerte','SUERTE',NULL,NULL,NULL,NULL),(9,'Av. Levante','PROPIEDAD','#AAE0FA',2,100,6),(10,'Av. Valencia','PROPIEDAD','#AAE0FA',2,120,8),(11,'Cárcel / Visita','ESPECIAL',NULL,NULL,NULL,NULL),(12,'Av. Aragón','PROPIEDAD','#D93A96',3,140,10),(13,'Empresa Eléctrica','SERVICIO',NULL,NULL,150,NULL),(14,'Av. Navarra','PROPIEDAD','#D93A96',3,140,10),(15,'Av. Cataluña','PROPIEDAD','#D93A96',3,160,12),(16,'Est. Norte','ESTACION','#B4B4B4',NULL,200,25),(17,'Calle Sevilla','PROPIEDAD','#F7941D',4,180,14),(18,'Caja Comunidad','COMUNIDAD',NULL,NULL,NULL,NULL),(19,'Calle Granada','PROPIEDAD','#F7941D',4,180,14),(20,'Calle Málaga','PROPIEDAD','#F7941D',4,200,16),(21,'Parking Gratis','ESPECIAL',NULL,NULL,NULL,NULL),(22,'Av. Diagonal','PROPIEDAD','#ED2939',5,220,18),(23,'Suerte','SUERTE',NULL,NULL,NULL,NULL),(24,'Av. Castellana','PROPIEDAD','#ED2939',5,220,18),(25,'Puerta del Sol','PROPIEDAD','#ED2939',5,240,20),(26,'Est. Este','ESTACION','#B4B4B4',NULL,200,25),(27,'Calle Alcalá','PROPIEDAD','#FFEF00',6,260,22),(28,'Gran Vía','PROPIEDAD','#FFEF00',6,260,22),(29,'Empresa Agua','SERVICIO',NULL,NULL,150,NULL),(30,'Calle Serrano','PROPIEDAD','#FFEF00',6,280,24),(31,'Ir a la Cárcel','ESPECIAL',NULL,NULL,NULL,NULL),(32,'Av. Prado','PROPIEDAD','#1FB25A',7,300,26),(33,'Av. Retiro','PROPIEDAD','#1FB25A',7,300,26),(34,'Caja Comunidad','COMUNIDAD',NULL,NULL,NULL,NULL),(35,'Av. Salamanca','PROPIEDAD','#1FB25A',7,320,28),(36,'Est. Oeste','ESTACION','#B4B4B4',NULL,200,25),(37,'Suerte','SUERTE',NULL,NULL,NULL,NULL),(38,'Paseo del Prado','PROPIEDAD','#0072BB',8,350,35),(39,'Impuesto Lujo','IMPUESTO',NULL,NULL,100,NULL),(40,'Paseo de la Castellana','PROPIEDAD','#0072BB',8,400,50);
/*!40000 ALTER TABLE `casillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ranking`
--

DROP TABLE IF EXISTS `ranking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ranking` (
  `idRanking` int NOT NULL AUTO_INCREMENT,
  `nombreJugadorRanking` varchar(45) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dineroFinalRanking` int NOT NULL,
  `casasFinalRanking` int NOT NULL,
  `hotelesFinalRanking` int NOT NULL,
  PRIMARY KEY (`idRanking`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ranking`
--

LOCK TABLES `ranking` WRITE;
/*!40000 ALTER TABLE `ranking` DISABLE KEYS */;
INSERT INTO `ranking` VALUES (1,'Player 4',20,0,0),(2,'Manu',20,0,0),(3,'Player 2',20,0,0),(4,'Player 2',20,0,0),(5,'Player 2',20,0,0),(6,'Player 2',20,0,0),(7,'Manu',20,0,0),(8,'Manu',20,0,0),(9,'Player 2',20,0,0),(10,'Player 2',20,0,0),(11,'Player 4',20,0,0),(12,'Player 2',20,0,0),(13,'Player 2',20,0,0),(14,'Player 2',20,0,0),(15,'Player 3',20,0,0),(16,'Player 3',20,0,0),(17,'Player 3',20,0,0),(18,'Jairo',20,0,0),(19,'Player 2',20,0,0);
/*!40000 ALTER TABLE `ranking` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-06  7:54:25
