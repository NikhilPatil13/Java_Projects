CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_scorecard`
--

DROP TABLE IF EXISTS `tbl_scorecard`;

CREATE TABLE `tbl_scorecard` (
  `scorecardid` int NOT NULL AUTO_INCREMENT,
  `scorecarduserid` int NOT NULL,
  `scorecardquizid` int NOT NULL,
  `scorecardobtpoints` int NOT NULL,
  `scorecardtotalpoints` int NOT NULL,
  PRIMARY KEY (`scorecardid`),
  KEY `scorecarduserid` (`scorecarduserid`),
  KEY `scorecardquizid` (`scorecardquizid`),
  CONSTRAINT `tbl_scorecard_ibfk_1` FOREIGN KEY (`scorecarduserid`) REFERENCES `tbl_user` (`userid`),
  CONSTRAINT `tbl_scorecard_ibfk_2` FOREIGN KEY (`scorecardquizid`) REFERENCES `tbl_quiz` (`quizid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

