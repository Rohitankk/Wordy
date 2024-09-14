-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 04, 2023 at 01:46 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wordy_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `longestwords`
--

DROP TABLE IF EXISTS `longestwords`;
CREATE TABLE IF NOT EXISTS `longestwords` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `word` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `longestwords`
--

INSERT INTO `longestwords` (`userID`, `word`) VALUES
(1, NULL),
(2, NULL),
(3, NULL),
(4, NULL),
(5, NULL),
(6, NULL),
(7, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `username`, `password`, `status`) VALUES
(1, 'Rohit', '000', 'Offline'),
(2, 'Melody', '000', 'Offline'),
(3, 'John Rex', '000', 'Offline'),
(4, 'Allen', '000', 'Offline'),
(5, 'Crisha', '000', 'Offline'),
(6, 'Bruce', '000', 'Offline'),
(7, 'Kirk', '000', 'Offline');

-- --------------------------------------------------------

--
-- Table structure for table `userwins`
--

DROP TABLE IF EXISTS `userwins`;
CREATE TABLE IF NOT EXISTS `userwins` (
  `userID` int NOT NULL AUTO_INCREMENT,
  `wins` int NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `userwins`
--

INSERT INTO `userwins` (`userID`, `wins`) VALUES
(1, 1),
(2, 0),
(3, 0),
(4, 0),
(5, 0),
(6, 0),
(7, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
