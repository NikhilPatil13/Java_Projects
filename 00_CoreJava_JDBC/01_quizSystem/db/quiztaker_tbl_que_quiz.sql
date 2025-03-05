CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;


--
-- Table structure for table `tbl_que_quiz`
--

DROP TABLE IF EXISTS `tbl_que_quiz`;

CREATE TABLE `tbl_que_quiz` (
  `quizid` int NOT NULL,
  `queid` int NOT NULL,
  PRIMARY KEY (`quizid`,`queid`),
  KEY `queid` (`queid`),
  CONSTRAINT `tbl_que_quiz_ibfk_1` FOREIGN KEY (`quizid`) REFERENCES `tbl_quiz` (`quizid`),
  CONSTRAINT `tbl_que_quiz_ibfk_2` FOREIGN KEY (`queid`) REFERENCES `tbl_question` (`queid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
