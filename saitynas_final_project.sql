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
(1, 'Action'),(2, 'Comedy'),(3,'Drama'),(4,'Fantasy'),(5,'Horror'),(6,'Mystery'),(7,'Romance'),(8,'Thrailer'),(9,'Crime'),(10 ,'Adventure'),(11 ,'Biography'); 

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
(1, 'The Avengers', 2012, 'PG-13', 143, 'English;Russian;Hindi', 'USA', 'Movie', 'Walt Disney Pictures', 1),
(2, 'Project Power', 2020, 'PG-13', 113, 'English', 'USA', 'Movie', 'Supermarché', 9),
(3, 'Joker', 2019, 'PG-13', 122, 'English', 'USA;Canada', 'Movie', ' Warner Bros', 8),
(4, 'Jurassic Park', 1993, 'PG-13', 127, 'English;Spanish', 'USA', 'Movie', ' Universal Pictures', 1),
(5, 'The Kissing Booth', 2018, 'PG-13', 105, 'English', 'USA;UK', 'Movie', ' Komixx Entertainment', 2),
(6, 'Midway', 2019, 'PG-13', 138, ' English;Japanese;Mandarin', 'China;Hong Kong;Canada;USA', 'Movie', 'Bona Film Group', 3),
(7, 'The Revenant', 2015, 'PG-13', 156, 'English;Pawnee;French', 'USA;Hong Kong;Taiwan', 'Movie', 'Regency Enterprises,', 1),
(8, 'The Matrix', 1999, 'PG-13', 136, 'English', 'USA', 'Movie', ' Warner Bros', 1),
(9, 'Inception', 2010, 'PG-13', 148, 'English;Japanese;French', 'USA;UK', 'Movie', 'Legendary Entertainment,', 10),
(10, 'Hamilton', 2020, 'PG-13', 160, 'English', 'USA', 'Movie', '5000 Broadway Productions', 11),
(11, 'Gladiator', 2000, 'PG-13', 171, 'English', 'USA;UK;Malta;Morocco', 'Movie', 'DreamWorks', 10),
(12, '1917', 2019, 'PG-13', 119, 'English;French;German', 'USA;UK;India;Spain;Canada;China', 'Movie', 'DreamWorks', 3),
(13, 'Green Book', 2018, 'PG-13', 130, 'English;Italian;Russian;German', 'USA;China', 'Movie', 'Participant', 2),
(14, 'Fast & Furious Presents: Hobbs & Shaw', 2019, 'PG-13', 137, 'English;Samoan;Russian', 'USA;Japan', 'Movie', 'Chris Morgan Productions', 8),
(15, 'Wrong Turn', 2003, 'PG-13', 84, 'English', ' USA;Germany;Canada', 'Movie', ' Summit Entertainment', 5);

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
(1, 'Best Achievement in Visual Effects', 2013, 0, 1), 
(2, 'BEST PICTURE', 2001, 1, 11), 
(3, 'CINEMATOGRAPHY', 2020, 0, 3), 
(4, 'COSTUME DESIGN', 2020, 0, 3), 
(5, 'DIRECTING', 2020, 0, 12), 
(6, 'DOCUMENTARY', 2013, 0, 1), 
(7, 'FILM EDITING', 2020, 0, 3),
(8, 'VISUAL EFFECTS', 1994, 1, 4);
(9, 'MAKEUP AND HAIRSTYLING', 2020, 0, 3),
(10, 'MUSIC (ORIGINAL SCORE)', 2020, 1, 3),
(11, 'PRODUCTION DESIGN', 2020, 0, 12),
(12, 'SOUND EDITING', 2020, 0, 3),
(13, 'SOUND MIXING', 2020, 1, 12),
(14, 'VISUAL EFFECTS', 2020, 1, 12),
(15, 'BLIMP AWARD', 2019, 1, 5),
(16, 'BEST PICTURE', 2016, 0, 7),
(17, 'FILM EDITING', 2000, 1, 8),
(18, 'VISUAL EFFECTS', 2011, 1, 9),
(19, 'BEST PICTURE', 2019, 0, 11),
(20, 'GOLDEN TRAILER', 2019, 1, 14)
(21, 'BEST FEATURE FILM', 2020, 0, 15),
VISUAL EFFECTS
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
(2, 'Zak', 'Penn', 'Story', 'USA, New York', 1),
(3, 'Robert', 'Downey Jr.', 'Iron Man', 'USA, New York', 1),
(4, 'Chris', 'Evans', 'Captain America', 'USA, Boston', 1),
(5, 'Henry', 'Joost', 'Director/Writer/Producer', 'Germany, Frankfurt', 2),
(6, 'Joseph', 'Gordon-Levitt', 'Frank', 'USA, California', 2),
(7, 'Dominique', 'Fishback', 'Robin', 'USA, New York', 2),
(8, 'Todd', 'Phillips', 'Director/Writer', 'USA, New York', 3),
(9, 'Joaquin', 'Phoenix', 'Arthur Fleck', 'Puerto Rico, San Juan', 3),
(10, 'Robert', 'De Niro', '	Murray Franklin', 'USA, New York', 3),
(11, 'Steven', 'Spielberg', 'Director', 'USA, Cincinnati', 4),
(12, 'Sam', 'Neill', 'Grant', 'UK, Tyrone', 4),
(13, 'Laura', 'Dern', 'Ellie', 'USA, California', 4),
(14, 'Roland', 'Emmerich', 'Director', 'Germany, Stuttgart', 6),
(15, 'Wes', 'Tooke', 'Writer', 'USA, New York', 6),
(16, 'Ed', 'Skrein', 'Dick Best', 'UK, London', 6),
(17, 'Alejandro', 'González Iñárritu', 'Director', 'Mexico, Distrito Federal', 7),
(18, 'Leonardo', 'DiCaprio', 'Hugh Glass', 'USA, Hollywood', 7),
(19, 'Tom', 'Hardy', 'John Fitzgerald', 'UK, London', 7),
(20, 'Lana', 'Wachowski', 'Director/Writer/Producer', 'USA, Chicago', 8),
(21, 'Keanu', 'Reeves', 'Neo', 'Lebanon, Beirut', 8),
(22, 'Laurence', 'Fishburne', 'Morpheus', 'USA, Georgia', 8),
(23, 'Vince', 'Marcello', 'Director/Writer', 'USA', 5),
(24, 'Stephen', 'Jennings', 'Mike Evans', 'USA, California', 5),
(25, 'Chloe', 'Williams', 'Joni Evans', 'USA', 5),
(26, 'Christopher', 'Nolan', 'Director/Writer', 'UK, London', 9),
(27, ' Leonardo', 'DiCaprio', 'Cobb', 'USA, Hollywood', 9),
(28, 'Joseph', 'Gordon-Levitt', '	Arthur', 'USA, California', 9),
(29, 'Thomas', 'Kail', 'Director', 'USA', 10),
(30, 'Daveed', 'Diggs', 'Marquis de Lafayette / Thomas Jefferson', 'USA, Oakland', 10),
(31, 'Renée', 'Elise Goldsberry', '	Angelica Schuyler', 'USA, California', 10),
(32, 'Ridley', 'Scott', 'Director', 'UK', 11),
(33, 'David', 'Franzoni', 'Story Writer', 'USA', 11),
(34, 'Russell', 'Crowe', 'Maximus', 'New Zealand,  Wellington', 11),
(35, 'Sam', 'Mendes', 'Director/Writer/Producer', 'UK, Berkshire', 12),
(36, 'Dean-Charles', 'Chapman', 'Lance Corporal Blake', 'UK, London', 12),
(37, 'George', 'MacKay', 'Lance Corporal Schofield', 'UK, London', 12),
(38, 'Peter', 'Farrelly', 'Director', 'USA, Pennsylvania', 13),
(39, 'Viggo', 'Mortensen', 'Tony Lip', 'USA, New York', 13),
(40, 'Mahershala', 'Ali', 'Dr. Donald Shirley', 'USA, California', 13),
(41, 'David', 'Leitch', 'Director', 'USA', 14),
(42, 'Dwayne', 'Johnson', '	Hobbs', 'USA, California', 14),
(43, 'Jason', 'Statham', 'Shaw', 'UK, England', 14),
(44, 'Rob', 'Schmidt', 'Director', 'USA, Pennsylvania', 15),
(45, 'Desmond', 'Harrington', 'Chris Flynn', 'USA, Georgia', 15),
(46, 'Eliza', 'Dushku', 'Jessie Burlingame', 'USA, Massachusetts', 15);


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
