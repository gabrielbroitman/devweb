-- MySQL dump 10.13  Distrib 5.6.42, for Win64 (x86_64)
--
-- Host: localhost    Database: weedem
-- ------------------------------------------------------
-- Server version	5.6.42

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(15) NOT NULL,
  `descricao_categoria` varchar(500) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE KEY `nome_categoria` (`nome_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Concentrados','Extrações com solventes e sem solventes'),(2,'Terpenos','Terpenos extraídos'),(3,'Extrações','Tinctures e florais'),(4,'Comestiveis','Alimentos com infusion de canabinóides'),(5,'Vaporizadores','Vaporizadores'),(6,'Acessórios','Diversos');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome_cliente` varchar(50) NOT NULL,
  `endereco_cliente` tinytext NOT NULL,
  `email_cliente` varchar(50) NOT NULL,
  `cpf_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf_cliente` (`cpf_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemvenda`
--

DROP TABLE IF EXISTS `itemvenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemvenda` (
  `id_produto` int(11) NOT NULL,
  `id_venda` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  KEY `ItemVenda_fk0` (`id_produto`),
  KEY `ItemVenda_fk1` (`id_venda`),
  CONSTRAINT `ItemVenda_fk0` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `ItemVenda_fk1` FOREIGN KEY (`id_venda`) REFERENCES `venda` (`id_venda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemvenda`
--

LOCK TABLES `itemvenda` WRITE;
/*!40000 ALTER TABLE `itemvenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemvenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id_marca` int(11) NOT NULL AUTO_INCREMENT,
  `nome_marca` varchar(50) NOT NULL,
  `descricao_marca` varchar(500) NOT NULL,
  PRIMARY KEY (`id_marca`),
  UNIQUE KEY `nome_marca` (`nome_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'GOVBR','Marca de produtos produzidos pelo SUS'),(2,'Ignite','by DB.'),(3,'West Coast Culture','Shatters and Concentrates'),(4,'My Best Bud','Produtos para cães e gatos.'),(5,'PAX Inc.','Vaporizadores'),(6,'Volcano','Desktop Vaporizer');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(11) NOT NULL,
  `id_marca` int(11) NOT NULL,
  `nome_produto` varchar(50) NOT NULL,
  `url_img` varchar(50) DEFAULT NULL,
  `descricao_produto` varchar(500) NOT NULL,
  `preco_produto` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `Produto_fk0` (`id_categoria`),
  KEY `Produto_fk1` (`id_marca`),
  CONSTRAINT `Produto_fk0` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`),
  CONSTRAINT `Produto_fk1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_marca`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,3,1,'Tintura 1000mg','','',0.00),(2,3,1,'Tintura 4000mg','','',0.00),(3,3,1,'Tintura 500mg','','',0.00),(4,3,2,'Unflavored CBD Drops 1000mg','','Tintura de CBD',0.00),(5,1,2,'Calm | Bubble Gum CBD Vape Pen','','Vaporizador + Cartucho de CBD - Bubble Gum - Calmaria',0.00),(6,1,2,'SFV OG Live Resin Sauce','','Extrato SFV OG - Para uso diurno',0.00),(7,3,3,'CureBD? Tincture - Kiwi 1000mg','','Tintura 1000mg com contador de gotas de 1ml - 30ml',0.00),(8,1,3,'CUREpen? Cartridge - Strawberry Banana','','SEM VG E SEM PG - Cartucho de Strawberry Banana',0.00),(9,1,3,'Gelato Shatter','','Shatter do Gelato - Sativa perfeita para uso diurno',0.00),(10,3,4,'20:1 (CBD/THC) Pet Liquid Supplement 15ml','','Tintura para cachorros e gatos.',0.00),(11,3,4,'1:1 (CBD/THC) Pet Liquid Supplement 15ml','','Tintura para cachorros e gatos.',0.00),(12,5,5,'PAX 3','','Vaporizador para ervas e concentrados.',0.00),(13,5,5,'PAX 2','','Vaporizador para ervas secas.',0.00),(14,5,6,'Volcano Vaporizer - com 3 bags','','',0.00),(15,5,6,'Volcano Vaporizer - com 2 bags','','',0.00);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `data_venda` date NOT NULL,
  `total_venda` decimal(6,2) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `qtd_venda` int(11) NOT NULL,
  PRIMARY KEY (`id_venda`),
  KEY `Venda_fk0` (`id_cliente`),
  CONSTRAINT `Venda_fk0` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-17 17:15:26
