-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 2020 m. Rgp 20 d. 07:02
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saitynas_final_project`
--

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE IF NOT EXISTS `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8_lithuanian_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `genre`
--

INSERT INTO `genre` (`id`, `name`) VALUES
(1, 'Action');

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `movie`
--

DROP TABLE IF EXISTS `movie`;
CREATE TABLE IF NOT EXISTS `movie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text COLLATE utf8_lithuanian_ci NOT NULL,
  `year` int(11) NOT NULL,
  `ratedAs` text COLLATE utf8_lithuanian_ci NOT NULL,
  `lengthMinutes` int(11) NOT NULL,
  `languages` text COLLATE utf8_lithuanian_ci NOT NULL,
  `country` text COLLATE utf8_lithuanian_ci NOT NULL,
  `type` text COLLATE utf8_lithuanian_ci NOT NULL,
  `producedBy` text COLLATE utf8_lithuanian_ci NOT NULL,
  `genreId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_ibfk_1` (`genreId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `movie`
--

INSERT INTO `movie` (`id`, `title`, `year`, `ratedAs`, `lengthMinutes`, `languages`, `country`, `type`, `producedBy`, `genreId`) VALUES
(1, 'The Avengers', 2012, 'PG-13', 143, 'English;Russian;Hindi', 'USA', 'Movie', 'Walt Disney Pictures', 1);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `nomination`
--

DROP TABLE IF EXISTS `nomination`;
CREATE TABLE IF NOT EXISTS `nomination` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8_lithuanian_ci NOT NULL,
  `year` int(11) NOT NULL,
  `won` tinyint(1) NOT NULL,
  `movieId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movie_id` (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `nomination`
--

INSERT INTO `nomination` (`id`, `name`, `year`, `won`, `movieId`) VALUES
(2, 'Best Achievement in Visual Effects', 2013, 0, 1);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `internetMovieDatabase` double NOT NULL,
  `rottenTomatoes` double NOT NULL,
  `metacritic` double NOT NULL,
  `metascore` double NOT NULL,
  `imdb` double NOT NULL,
  `imdbVotes` int(11) NOT NULL,
  `movieId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movieId` (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `rating`
--

INSERT INTO `rating` (`id`, `internetMovieDatabase`, `rottenTomatoes`, `metacritic`, `metascore`, `imdb`, `imdbVotes`, `movieId`) VALUES
(2, 8, 92, 69, 69, 8, 1239566, 1);

-- --------------------------------------------------------

--
-- Sukurta duomenų struktūra lentelei `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text COLLATE utf8_lithuanian_ci NOT NULL,
  `surname` text COLLATE utf8_lithuanian_ci NOT NULL,
  `role` text COLLATE utf8_lithuanian_ci NOT NULL,
  `origin` text COLLATE utf8_lithuanian_ci NOT NULL,
  `movieId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `movieId` (`movieId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_lithuanian_ci;

--
-- Sukurta duomenų kopija lentelei `staff`
--

INSERT INTO `staff` (`id`, `name`, `surname`, `role`, `origin`, `movieId`) VALUES
(1, 'Joss', 'Whedon', 'Director/Writer', 'USA, New York', 1);

--
-- Apribojimai eksportuotom lentelėm
--

--
-- Apribojimai lentelei `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `movie_ibfk_1` FOREIGN KEY (`genreId`) REFERENCES `genre` (`id`);

--
-- Apribojimai lentelei `nomination`
--
ALTER TABLE `nomination`
  ADD CONSTRAINT `nomination_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`);

--
-- Apribojimai lentelei `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`);

--
-- Apribojimai lentelei `staff`
--
ALTER TABLE `staff`
  ADD CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
