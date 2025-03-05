CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;


CREATE TABLE `tbl_user` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `userfname` varchar(100) NOT NULL,
  `userlname` varchar(100) NOT NULL,
  `useremailid` varchar(100) NOT NULL,
  `usercontactno` varchar(15) NOT NULL,
  `useraddress` varchar(300) NOT NULL,
  `userpassword` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `useremailid` (`useremailid`),
  UNIQUE KEY `usercontactno` (`usercontactno`),
  UNIQUE KEY `usercontactno_2` (`usercontactno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

