-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 30, 2023 at 03:35 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cis2103`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemID` int(11) NOT NULL,
  `itemName` varchar(50) NOT NULL,
  `itemPrice` int(11) NOT NULL,
  `itemAdded` timestamp NOT NULL DEFAULT current_timestamp(),
  `itemUpdated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemID`, `itemName`, `itemPrice`, `itemAdded`, `itemUpdated`) VALUES
(1, 'Soup', 200, '2023-03-29 03:31:19', '2023-03-29 05:06:19'),
(2, 'Fried Chicken', 200, '2023-03-29 03:31:19', '2023-03-29 05:06:31'),
(3, 'Choco Milkshake', 200, '2023-03-29 03:31:19', '2023-03-29 05:10:21'),
(4, 'Coke', 50, '2023-03-29 03:31:19', '2023-03-29 03:31:19'),
(5, 'Sisig', 150, '2023-03-29 03:35:07', '2023-03-29 03:35:07'),
(6, 'Pinakbet', 80, '2023-03-29 03:41:44', '2023-03-29 08:05:56'),
(7, 'Coffee', 100, '2023-03-29 03:43:24', '2023-03-29 03:43:24'),
(8, 'French Fries', 50, '2023-03-29 03:49:14', '2023-03-29 03:49:14'),
(9, 'Burger', 90, '2023-03-29 04:10:18', '2023-03-29 08:05:23'),
(10, 'French Toast', 80, '2023-03-29 04:10:47', '2023-03-29 08:05:51'),
(11, 'Pancake', 150, '2023-03-29 04:14:14', '2023-03-29 08:09:42'),
(12, 'Spaghetti', 200, '2023-03-29 04:15:20', '2023-03-29 04:15:20'),
(13, 'Coffee Jelly', 101, '2023-03-29 10:57:56', '2023-03-29 13:07:21');

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

CREATE TABLE `packages` (
  `packageID` int(11) NOT NULL,
  `packageName` varchar(50) NOT NULL,
  `packagePrice` varchar(50) NOT NULL,
  `packageCount` int(11) NOT NULL,
  `packageCreated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`packageID`, `packageName`, `packagePrice`, `packageCount`, `packageCreated`) VALUES
(1, 'Package 1', '500', 0, '2023-03-29 13:53:56'),
(2, 'Package 2', '0', 0, '2023-03-29 14:46:23');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `contact` varchar(11) NOT NULL,
  `usertype` varchar(10) NOT NULL,
  `userCreated` timestamp NOT NULL DEFAULT current_timestamp(),
  `userUpdated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `contact`, `usertype`, `userCreated`, `userUpdated`) VALUES
(1, 'janica', 'password', '09232576116', 'admin', '2023-03-29 11:15:36', '2023-03-29 11:15:36'),
(2, 'jempai', 'password', '09232576116', 'regular', '2023-03-29 12:51:08', '2023-03-29 13:08:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `packages`
--
ALTER TABLE `packages`
  ADD PRIMARY KEY (`packageID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `packages`
--
ALTER TABLE `packages`
  MODIFY `packageID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
