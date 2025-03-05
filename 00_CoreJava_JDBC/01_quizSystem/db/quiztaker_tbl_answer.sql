CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_answer`
--

DROP TABLE IF EXISTS `tbl_answer`;

CREATE TABLE `tbl_answer` (
  `ansid` int NOT NULL AUTO_INCREMENT,
  `ansqueid` int NOT NULL,
  `ansoptid` int NOT NULL,
  `isoptcorrect` tinyint(1) NOT NULL DEFAULT '0',
  `anspoints` int NOT NULL,
  PRIMARY KEY (`ansid`),
  KEY `ansqueid` (`ansqueid`),
  KEY `ansoptid` (`ansoptid`),
  CONSTRAINT `tbl_answer_ibfk_1` FOREIGN KEY (`ansqueid`) REFERENCES `tbl_question` (`queid`),
  CONSTRAINT `tbl_answer_ibfk_2` FOREIGN KEY (`ansoptid`) REFERENCES `tbl_option` (`optid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
