CREATE DATABASE  IF NOT EXISTS `quiztaker`;
USE `quiztaker`;

--
-- Table structure for table `tbl_admin`
--

DROP TABLE IF EXISTS `tbl_admin`;

CREATE TABLE `tbl_admin` (
  `adminusername` varchar(20) DEFAULT NULL,
  `adminpassword` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

