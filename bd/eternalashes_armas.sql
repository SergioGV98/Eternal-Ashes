CREATE DATABASE  IF NOT EXISTS `eternalashes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `eternalashes`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: eternalashes
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `armas`
--

DROP TABLE IF EXISTS `armas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `armas` (
  `nombre` varchar(150) NOT NULL,
  `daño` int NOT NULL,
  `rareza` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armas`
--

LOCK TABLES `armas` WRITE;
/*!40000 ALTER TABLE `armas` DISABLE KEYS */;
INSERT INTO `armas` VALUES ('Aguijón del Vengador',42,'Raro'),('Arco de madera podrida',12,'Raro'),('Arco del Cazador',22,'Raro'),('Arco del Viento',35,'Rara'),('Arco largo de hueso',28,'Legendario'),('Báculo de las Sombras',28,'Épico'),('Ballesta oxidada',15,'Raro'),('Bastón de la Luna Llena',40,'Épica'),('Bastón de la Tormenta',35,'Épica'),('Bastón de Roble Místico',18,'Común'),('Bastón del Arcano',100,'Legendario'),('Bastón del Dragón',15,'Raro'),('Bastón del Sabio',18,'Raro'),('Cimitarra del Abismo',72,'Legendario'),('Cuchillo de la Oscuridad',30,'Épica'),('Cuchillo mellado',8,'Común'),('Daga de la Eternidad',90,'Mítica'),('Daga de la Oscuridad',90,'Legendario'),('Daga de Plata Sagrada',20,'Común'),('Daga del Asesino',7,'Comun'),('Diente de Dragón',22,'Poco común'),('Diente de Rata',7,'Común'),('Espada corta',18,'Raro'),('Espada Corta del Vacío',21,'Poco común'),('Espada de Fuego',25,'Épico'),('Espada de la Destrucción',150,'Legendario'),('Espada de los Dioses',80,'Mítica'),('Espada del Destino',12,'Comun'),('Espada del Dragón de Hielo',50,'Mítica'),('Espada del Poderío',39,'Común'),('Espada del Viento',8,'Comun'),('Espadón mellado',22,'Épico'),('Estrella del Destino',60,'Legendario'),('Garra de Demonio',22,'Poco común'),('Garra de la Oscuridad',68,'Épico'),('Garrote oxidado',5,'Común'),('Guadaña del Inframundo',85,'Mítica'),('Hacha de Piedra',19,'Común'),('Hacha del Cazador de Demonios',45,'Mítica'),('Hacha desgastada',10,'Común'),('Hoja de Hielo Helada',20,'Común'),('Hueso Maldito',56,'Épico'),('Lanza de Escarcha',18,'Común'),('Lanza de Fuego Infernal',21,'Poco común'),('Lanza de la Destrucción',26,'Épico'),('Lanza de la Tormenta',75,'Mítica'),('Lanza de las Almas',25,'Común'),('Lanza de los Conquistadores',110,'Legendario'),('Lanza del Rey Salvaje',80,'Legendario'),('Látigo del Abominable',54,'Raro'),('Llamada del Olvido',50,'Mítica'),('Llave de las Sombras',61,'Legendario'),('Mandoble del Guerrero',20,'Raro'),('Martillo de guerra',25,'Épico'),('Martillo de Guerra Ancestral',19,'Poco común'),('Martillo de los Dioses',30,'Legendario'),('Martillo del Ancestro',40,'Rara'),('Martillo del Cielo',130,'Legendario'),('Maza de la Justicia',18,'Raro'),('Maza del Ocaso',30,'Rara'),('Vara de las Llamas Sagradas',77,'Legendario');
/*!40000 ALTER TABLE `armas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-14 18:29:44
