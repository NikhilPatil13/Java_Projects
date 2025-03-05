CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;


--
-- Table structure for table `tbl_quiz`
--

DROP TABLE IF EXISTS `tbl_quiz`;

CREATE TABLE `tbl_quiz` (
  `quizid` int NOT NULL AUTO_INCREMENT,
  `quizuserid` int NOT NULL,
  `quiztotalpoints` int NOT NULL,
  `quizobtpoints` int NOT NULL,
  `quizsubid` int DEFAULT NULL,
  PRIMARY KEY (`quizid`),
  KEY `quizuserid` (`quizuserid`),
  KEY `quizsubid` (`quizsubid`),
  CONSTRAINT `tbl_quiz_ibfk_1` FOREIGN KEY (`quizuserid`) REFERENCES `tbl_user` (`userid`),
  CONSTRAINT `tbl_quiz_ibfk_2` FOREIGN KEY (`quizsubid`) REFERENCES `tbl_subject` (`subid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

