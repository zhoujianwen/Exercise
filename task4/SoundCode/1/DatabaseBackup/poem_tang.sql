-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: poem
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `tang`
--

DROP TABLE IF EXISTS `tang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `author` varchar(45) NOT NULL,
  `content` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tang`
--

LOCK TABLES `tang` WRITE;
/*!40000 ALTER TABLE `tang` DISABLE KEYS */;
INSERT INTO `tang` VALUES (1,'望庐山瀑布','李白','日照香炉生紫烟，遥看瀑布挂前川。\n飞流直下三千尺，疑是银河落九天。'),(2,'行路难','李白','金尊清酒斗十千，玉盘珍羞直万钱。停杯投箸不能食，\n拔剑四顾心茫然。欲渡黄河冰塞川，将登太行雪暗天。\n闲来垂钓坐溪上，忽复乘舟梦日边。行路难，行路难，\n多岐路，今安在。长风破浪会有时，直挂云帆济沧海。\n\n赤鸡白狗赌梨栗。弹剑作歌奏苦声，曳裾王门不称情。\n淮阴市井笑韩信，汉朝公卿忌贾生。\n君不见昔时燕家重郭隗，拥彗折腰无嫌猜。\n剧辛乐毅感恩分，输肝剖胆效英才。昭王白骨萦蔓草，\n谁人更扫黄金台。行路难，归去来。\n\n何用孤高比云月。吾观自古贤达人，功成不退皆殒身。\n子胥既弃吴江上，屈原终投湘水滨。陆机才多岂自保，\n李斯税驾苦不早。华亭鹤唳讵可闻，上蔡苍鹰何足道。\n君不见吴中张翰称达士，秋风忽忆江东行。\n且乐生前一杯酒，何须身后千载名。'),(3,'蜀道难','李白','噫吁嚱，危乎高哉！蜀道之难，难于上青天！\n蚕丛及鱼凫，开国何茫然！\n尔来四万八千岁，不与秦塞通人烟。\n西当太白有鸟道，可以横绝峨眉巅。\n地崩山摧壮士死，然后天梯石栈相钩连。\n上有六龙回日之高标，下有冲波逆折之回川。\n黄鹤之飞尚不得过，猿猱欲度愁攀援。\n青泥何盘盘，百步九折萦岩峦。\n扪参历井仰胁息，以手抚膺坐长叹。'),(4,'将进酒','李白','君不见，黄河之水天上来，奔流到海不复回。\n君不见，高堂明镜悲白发，朝如青丝暮成雪！\n人生得意须尽欢，莫使金樽空对月。\n天生我材必有用，千金散尽还复来。\n烹羊宰牛且为乐，会须一饮三百杯。\n岑夫子，丹丘生，将进酒，杯莫停。\n与君歌一曲，请君为我倾耳听。\n钟鼓馔玉不足贵，但愿长醉不复醒。\n古来圣贤皆寂寞，惟有饮者留其名。\n陈王昔时宴平乐，斗酒十千恣欢谑。\n主人何为言少钱，径须沽取对君酌。\n五花马、千金裘，呼儿将出换美酒，与尔同销万古愁！');
/*!40000 ALTER TABLE `tang` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-30 10:18:42
