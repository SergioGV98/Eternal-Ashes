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
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `enunciado` varchar(500) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `respuestaincorrecta1` varchar(100) NOT NULL,
  `respuestaincorrecta2` varchar(100) NOT NULL,
  `respuestaincorrecta3` varchar(100) NOT NULL,
  `respuestacorrecta` varchar(100) NOT NULL,
  PRIMARY KEY (`enunciado`),
  UNIQUE KEY `id_UNIQUE` (`enunciado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES ('¿Cómo se llama el anime en el que los personajes utilizan poderes llamados \"Nen\"?','Anime','Fullmetal Alchemist','Naruto','Dragon Ball Z','Hunter x Hunter'),('¿Cómo se llama el personaje principal de la serie de anime \"One Piece\"?','Anime','Zoro Roronoa','Sanji Vinsmoke','Nami','Monkey D. Luffy'),('¿Cómo se llama el protagonista de la serie Oliver y Benji?','Anime','Tsubasa Ozora','Hyuga Kojiro','Genzo Wakabayashi','Oliver Atom'),('¿Cuál es el nombre completo de la protagonista femenina de \"Zero no Tsukaima\"?','Anime','Louise Françoise Le Blanc de la Petit','Louise Françoise Le Blanc de la Fontaine','Louise Françoise Le Blanc de la Trémoille','Louise Françoise Le Blanc de La Vallière'),('¿Cuál es el nombre de la archimaga que se une al grupo de Kazuma en \'KonoSuba: God\'s Blessing on This Wonderful World!\'?','Anime','Aqua','Wiz','Yunyun','Megumin'),('¿Cuál es el nombre de la chica que trabaja en la mansión de la familia Roswaal y que ayuda a Subaru en su lucha contra los enemigos?','Anime','Emilia','Beatrice','Ram','Rem'),('¿Cuál es el nombre de la técnica de respiración de Tanjiro que le permite aumentar temporalmente su fuerza y velocidad en Kimetsu no Yaiba?','Anime','Kokushibo','Kamado','Shinobu','Hinokami Kagura'),('¿Cuál es el nombre del arzobispo de la Pereza en la serie de anime Re:Zero?','Anime','Ley Batenkaitos','Regulus Corneas','Roy Alphard','Petelgeuse Romanée-Conti'),('¿Cuál es el nombre del compositor de la banda sonora de la serie \"Neon Genesis Evangelion\"?','Anime','Yoko Kanno','Kenji Kawai','Hiroyuki Sawano','Shiro Sagisu'),('¿Cuál es el nombre del demonio que aparece en la segunda temporada de \'KonoSuba: God\'s Blessing on This Wonderful World!\'?','Anime','Vanir','Sylvie','Wolbach','Verdia'),('¿Cuál es el nombre del estudio de animación que produjo la película \"Kimi no Na Wa\" (Your Name)?','Anime','P.A. Works','Shaft','Trigger','CoMix Wave Films'),('¿Cuál es el nombre del estudio de animación que produjo la serie \"One Punch Man\"?','Anime','Madhouse','Kyoto Animation','Studio Trigger','J.C. Staff'),('¿Cuál es el nombre del líder de los demonios que aparece en la segunda temporada de \'That Time I Got Reincarnated as a Slime\'?','Anime','Ramiris','Veldora','Chloe','Clayman'),('¿Cuál es el nombre del padre de Tanjirou Kamado?','Anime','Kokushibou','Muzan Kibutsuji','Urokodaki Sakonji','Kamado Tanjirou Sr.'),('¿Cuál es el nombre del personaje principal de \'KonoSuba: God\'s Blessing on This Wonderful World!\'?','Anime','Megumin','Aqua','Darkness','Kazuma'),('¿Cuál es el nombre del protagonista de Kimetsu no Yaiba?','Anime','Zenitsu Agatsuma','Giyuu Tomioka','Nezuko Kamado','Tanjiro Kamado'),('¿Cuál es el nombre del protagonista de la serie \"My Hero Academia\"?','Anime','Bakugo','Todoroki','All Might','Izuku Midoriya'),('¿Cuál es el nombre del protagonista masculino de \'Akame ga Kill\'?','Anime','Leone','Mine','Esdeath','Tatsumi'),('¿Cuál es el nombre del reino liderado por el padre de Kohaku en \'Dr. Stone\'?','Anime','Reino de la Ciencia','Reino del Acero','Reino de la Electricidad','Reino del Petròleo'),('¿Cuál es el nombre del seiyuu (actor de voz) japonés que dio vida al personaje \"Saitama\" en la serie \"One Punch Man\"?','Anime','Nobuhiko Okamoto','Yūki Kaji','Mamoru Miyano','Makoto Furukawa'),('¿Cuál es el nombre del Stand de Yoshikage Kira en \'JoJo\'s Bizarre Adventure: Diamond is Unbreakable\'?','Anime','Za Warudo','The Hand','Star Platinum','Killer Queen'),('¿Cuál es el nombre del villano principal en \'Dr. Stone\'?','Anime','Tsukasa Shishio','Gen Asagiri','Ryusui Nanami','Hyoga'),('¿En qué año se estrenó la serie de anime \"Cowboy Bebop\"?','Anime','1996','1997','1999','1998'),('¿En qué año se estrenó la serie de anime \"Neon Genesis Evangelion\"?','Anime','1993','1994','1996','1995'),('¿En qué equipo juega Oliver Atom en la segunda parte de la serie Oliver y Benji?','Anime','Mambo FC','New Team','FC Barcelona','Toho FC'),('¿En qué saga de \'Dragon Ball Z\' Goku alcanza la forma de Super Saiyan 2 por primera vez en la serie?','Anime','Saga de Namek','Saga de la Pelea en el Otro Mundo','Saga de los Androides','Saga de Cell'),('¿Qué tipo de Stand tiene Jotaro Kujo en \'JoJo\'s Bizarre Adventure: Stardust Crusaders\'?','Anime','Stand de alcance largo','Stand de corto alcance','Stand de control mental','Stand de parar el tiempo'),('¿Quién es el personaje principal de la serie de anime \"Naruto\"?','Anime','Kakashi Hatake','Sasuke Uchiha','Itachi Uchiha','Naruto Uzumaki'),('¿Quién es el protagonista de \'Dr. Stone\'?','Anime','Kohaku','Tsukasa','Gen','Senku'),('¿Quién es el protagonista del anime Re:Zero?','Anime','Emilia','Beatrice','Ram','Subaru Natsuki'),('¿Quiénes son los protagonistas principales de \"Highschool of the Dead\"?','Anime','Takashi Komuro y Saeko Busujima','Kohta Hirano y Shizuka Marikawa','Saya Takagi y Rei Miyamoto','Takashi Komuro y Rei Miyamoto'),('En \'KonoSuba\', ¿cuántas veces ha muerto el personaje de Kazuma?','Anime','3 veces','9 veces','7 veces','5 veces'),('En el anime Kimetsu no Yaiba, ¿qué técnica utiliza el personaje principal, Tanjiro Kamado, para derrotar al demonio \"Muzan Kibutsuji\" al final de la serie?','Anime','Danza de la Mariposa','Danza del Dios del Agua','Danza de la Llama','Danza del Dios del Fuego'),('En la saga de \'Dragon Ball Super\', ¿quién es el guerrero del Universo 6 que es capaz de transformarse en un Super Saiyan Legendario?','Anime','Hit','Frost','Cabba','Caulifla'),('En qué arco de la serie de anime Re:Zero, el personaje principal Subaru Natsuki enfrenta su batalla más difícil?','Anime','Arco 1: \"Empezando de Cero en Otro Mundo\"','Arco 2: \"Retorno a la Capital Real\"','Arco 4: \"El Santuario y la Bruja de la Codicia\"','Arco 3: \"La verdad de Zero\"');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
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
