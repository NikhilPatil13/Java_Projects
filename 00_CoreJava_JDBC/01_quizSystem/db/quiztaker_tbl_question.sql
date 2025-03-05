CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_question`
--

DROP TABLE IF EXISTS `tbl_question`;

CREATE TABLE `tbl_question` (
  `queid` int NOT NULL AUTO_INCREMENT,
  `questatement` varchar(1000) NOT NULL,
  `quepoints` int NOT NULL,
  `quesubid` int DEFAULT NULL,
  PRIMARY KEY (`queid`),
  KEY `quesubid` (`quesubid`),
  CONSTRAINT `tbl_question_ibfk_1` FOREIGN KEY (`quesubid`) REFERENCES `tbl_subject` (`subid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

