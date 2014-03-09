CREATE DATABASE  IF NOT EXISTS `roadtrip` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `roadtrip`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: roadtrip
-- ------------------------------------------------------
-- Server version	5.6.16-log

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
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (1,'София'),(2,'Пловдив'),(3,'Варна'),(4,'Бургас'),(5,'Велико Търново'),(6,'Плевен'),(7,'Стара Загора'),(8,'Айтос'),(9,'Аксаково'),(10,'Албена'),(11,'Ален мак'),(12,'Алфатар'),(13,'Антоново'),(14,'Априлци'),(15,'Арапя'),(16,'Ардино'),(17,'Асеновград'),(18,'Ахелой'),(19,'Ахтопол'),(20,'Балчик'),(21,'Банкя'),(22,'Банско'),(23,'Баня'),(24,'Батак'),(25,'Батановци'),(26,'Белене'),(27,'Белица'),(28,'Белово'),(29,'Белоградчик'),(30,'Белослав'),(31,'Берковица'),(32,'Благоевград'),(33,'Бобов дол'),(34,'Бобошево'),(35,'Божурище'),(36,'Бойчиновци'),(37,'Болярово'),(38,'Борово'),(39,'Боровец'),(40,'Ботевград'),(41,'Брацигово'),(42,'Брегово'),(43,'Брезник'),(44,'Брезово'),(45,'Брусарци'),(46,'Бухово'),(47,'Българово'),(48,'Бяла'),(49,'Бяла - Варна'),(50,'Бяла Слатина'),(51,'Бяла Черква'),(52,'Велики Преслав'),(53,'Велинград'),(54,'Ветово'),(55,'Ветрен'),(56,'Видин'),(57,'Враца'),(58,'Вълчедръм'),(59,'Вълчи дол'),(60,'Върбица'),(61,'Вършец'),(62,'Габрово'),(63,'Генерал Тошево'),(64,'Главиница'),(65,'Глоджево'),(66,'Годеч'),(67,'Горна Оряховица'),(68,'Гоце Делчев'),(69,'Градина'),(70,'Грамада'),(71,'Гулянци'),(72,'Гурково'),(73,'Гълъбово'),(74,'Две могили'),(75,'Дебелец'),(76,'Девин'),(77,'Девня'),(78,'Джебел'),(79,'Димитровград'),(80,'Димово'),(81,'Добринище'),(82,'Добрич'),(83,'Долна баня'),(84,'Долна Митрополия'),(85,'Долна Оряховица'),(86,'Долни Дъбник'),(87,'Долни чифлик'),(88,'Доспат'),(89,'Драгоман'),(90,'Дряново'),(91,'Дулово'),(92,'Дунавци'),(93,'Дупница'),(94,'Дългопол'),(95,'Дюни'),(96,'Евксиноград'),(97,'Елена'),(98,'Елените'),(99,'Елин Пелин'),(100,'Елхово'),(101,'Етрополе'),(102,'Завет'),(103,'Земен'),(104,'Златарица'),(105,'Златица'),(106,'Златни пясъци'),(107,'Златоград'),(108,'Ивайловград'),(109,'Игнатиево'),(110,'Иракли'),(111,'Искър'),(112,'Исперих'),(113,'Ихтиман'),(114,'Каблешково'),(115,'Каварна'),(116,'Казанлък'),(117,'Калофер'),(118,'Камено'),(119,'Камчия'),(120,'Каолиново'),(121,'Карандила'),(122,'Карлово'),(123,'Карнобат'),(124,'Каспичан'),(125,'Кермен'),(126,'Килифарево'),(127,'Китен'),(128,'Клисура'),(129,'Кнежа'),(130,'Козлодуй'),(131,'Койнаре'),(132,'Копривщица'),(133,'Костандово'),(134,'Костенец'),(135,'Костинброд'),(136,'Котел'),(137,'Кочериново'),(138,'Кресна'),(139,'Криводол'),(140,'Кричим'),(141,'Крумовград'),(142,'Кубрат'),(143,'Куклен'),(144,'Кула'),(145,'Кърджали'),(146,'Кюстендил'),(147,'Левски'),(148,'Летница'),(149,'Ловеч'),(150,'Лозенец'),(151,'Лозница'),(152,'Лом'),(153,'Луковит'),(154,'Лъки'),(155,'Любимец'),(156,'Лясковец'),(157,'Мадан'),(158,'Маджарово'),(159,'Малко Търново'),(160,'Мартен'),(161,'Мездра'),(162,'Мелник'),(163,'Меричлери'),(164,'Мизия'),(165,'Момин проход'),(166,'Момчилград'),(167,'Монтана'),(168,'Мъглиж'),(169,'Неделино'),(170,'Несебър'),(171,'Николаево'),(172,'Никопол'),(173,'Нова Загора'),(174,'Нови Искър'),(175,'Нови пазар'),(176,'Обзор'),(177,'Омуртаг'),(178,'Опака'),(179,'Оряхово'),(180,'Павел баня'),(181,'Павликени'),(182,'Пазарджик'),(183,'Панагюрище'),(184,'Пампорово'),(185,'Паша дере'),(186,'Перник'),(187,'Перущица'),(188,'Петрич'),(189,'Пещера'),(190,'Пирдоп'),(191,'Плачковци'),(192,'Плиска'),(193,'Полски Тръмбеш'),(194,'Поморие'),(195,'Попово'),(196,'Пордим'),(197,'Правец'),(198,'Приморско'),(199,'Провадия'),(200,'Първомай'),(201,'Раднево'),(202,'Радомир'),(203,'Разград'),(204,'Разлог'),(205,'Ракитово'),(206,'Раковски'),(207,'Рила'),(208,'Роман'),(209,'Романтика'),(210,'Рудозем'),(211,'Русалка'),(212,'Русе'),(213,'Садово'),(214,'Самоков'),(215,'Сандански'),(216,'Сапарева баня'),(217,'Св. св. Константин и Елена'),(218,'Свети Влас'),(219,'Свиленград'),(220,'Свищов'),(221,'Своге'),(222,'Севлиево'),(223,'Сеново'),(224,'Септември'),(225,'Силистра'),(226,'Симеоновград'),(227,'Симитли'),(228,'Славяново'),(229,'Сливен'),(230,'Сливница'),(231,'Сливо поле'),(232,'Слънчев бряг'),(233,'Смолян'),(234,'Смокиня'),(235,'Смядово'),(236,'Созопол'),(237,'Сопот'),(238,'Средец'),(239,'Стамболийски'),(240,'Стражица'),(241,'Стралджа'),(242,'Стрелча'),(243,'Суворово'),(244,'Сунгурларе'),(245,'Сухиндол'),(246,'Съединение'),(247,'Сърница'),(248,'Твърдица'),(249,'Тервел'),(250,'Тетевен'),(251,'Тополовград'),(252,'Троян'),(253,'Трън'),(254,'Тръстеник'),(255,'Трявна'),(256,'Тутракан'),(257,'Търговище'),(258,'Угърчин'),(259,'Хаджидимово'),(260,'Харманли'),(261,'Хасково'),(262,'Хисаря'),(263,'Цар Калоян'),(264,'Царево'),(265,'Чепеларе'),(266,'Червен бряг'),(267,'Черноморец'),(268,'Чипровци'),(269,'Чирпан'),(270,'Шабла'),(271,'Шивачево'),(272,'Шипка'),(273,'Шумен'),(274,'Ябланица'),(275,'Якоруда'),(276,'Ямбол');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `rating` varchar(45) DEFAULT NULL,
  `reviewscol` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_information`
--

DROP TABLE IF EXISTS `route_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_information` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `seats` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  `smoker` tinyint(1) DEFAULT NULL,
  `type` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_route_idx` (`user_id`),
  CONSTRAINT `user_id_route` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_information`
--

LOCK TABLES `route_information` WRITE;
/*!40000 ALTER TABLE `route_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `routes` (
  `route_id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `direction` tinyint(1) NOT NULL,
  PRIMARY KEY (`route_id`,`city_id`,`direction`),
  KEY `city_id_idx` (`city_id`),
  CONSTRAINT `city_id` FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `route_id` FOREIGN KEY (`route_id`) REFERENCES `route_information` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='link between city and routes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `MAC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
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

-- Dump completed on 2014-03-10  0:10:35
