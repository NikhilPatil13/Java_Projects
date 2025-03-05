CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_option`
--

DROP TABLE IF EXISTS `tbl_option`;

CREATE TABLE `tbl_option` (
  `optid` int NOT NULL AUTO_INCREMENT,
  `optstatement` varchar(500) NOT NULL,
  `isoptcorrect` tinyint(1) NOT NULL DEFAULT '0',
  `optqueid` int NOT NULL,
  PRIMARY KEY (`optid`),
  KEY `fk_opt_que` (`optqueid`),
  CONSTRAINT `fk_opt_que` FOREIGN KEY (`optqueid`) REFERENCES `tbl_question` (`queid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
