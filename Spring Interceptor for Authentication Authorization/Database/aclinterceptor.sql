-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 05, 2020 at 01:22 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aclinterceptor`
--

-- --------------------------------------------------------

--
-- Table structure for table `acl`
--

CREATE TABLE `acl` (
  `ID` int(11) NOT NULL,
  `Role` varchar(30) NOT NULL,
  `URL` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `acl`
--

INSERT INTO `acl` (`ID`, `Role`, `URL`) VALUES
(1, 'ADMIN', '/x'),
(2, 'ADMIN', '/admin'),
(3, 'ADMIN', '/home'),
(4, 'USER', '/a'),
(5, 'USER', '/b'),
(6, 'CLIENT', '/c'),
(7, 'SELLER', '/d'),
(8, 'SELLER', '/e'),
(9, 'CLIENT', '/f'),
(10, 'USER', '/g'),
(11, 'CLIENT', '/admin');

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `ID` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `authority` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`ID`, `UID`, `username`, `authority`) VALUES
(1, 151, 'Razib', 'ADMIN'),
(2, 151, 'Razib', 'USER'),
(3, 152, 'Sakib', 'CLIENT'),
(4, 153, 'Nadim', 'SELLER'),
(5, 161, 'Antu', 'SELLER'),
(6, 152, 'Sakib', 'USER'),
(7, 162, 'Fatema', 'CLIENT');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `UID` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `UID`, `username`, `password`, `enabled`) VALUES
(1, 151, 'Razib', '123', 1),
(2, 152, 'Sakib', 'abc', 1),
(3, 153, 'Nadim', '111', 1),
(4, 161, 'Antu', 'aaa', 1),
(5, 162, 'Fatema', 'bbb', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acl`
--
ALTER TABLE `acl`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
