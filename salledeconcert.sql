-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 06 juin 2023 à 23:18
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `salledeconcert`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_login` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_login`, `admin_password`) VALUES
(1, 'admin', '$2a$10$x47Gqg8KhtBNg0HDpfTokORm4WIICTNvq08O6pbvLZJUyoS6FIBTK');

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

DROP TABLE IF EXISTS `artiste`;
CREATE TABLE IF NOT EXISTS `artiste` (
  `artiste_id` bigint NOT NULL AUTO_INCREMENT,
  `artiste_nationalite` varchar(255) DEFAULT NULL,
  `artiste_nom` varchar(255) DEFAULT NULL,
  `event_artiste` varchar(255) DEFAULT NULL,
  `artiste_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`artiste_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `artiste`
--

INSERT INTO `artiste` (`artiste_id`, `artiste_nationalite`, `artiste_nom`, `event_artiste`, `artiste_image`) VALUES
(4, 'Français', 'DJ AB+', NULL, '../../../../assets/images/Jordan2.jpg'),
(5, 'Français', 'DJ GOZLAN', NULL, '../../../../assets/images/olivier.png'),
(7, 'AJC country', 'DJ JORDAN', NULL, NULL),
(8, 'Américain', 'Abid J', NULL, NULL),
(9, 'Français', 'Abid Benzema', NULL, NULL),
(10, 'Américain', 'JordEminem', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `client_id` bigint NOT NULL AUTO_INCREMENT,
  `client_login` varchar(255) DEFAULT NULL,
  `client_password` varchar(255) DEFAULT NULL,
  `client_naissance` date NOT NULL,
  `client_nom` varchar(255) DEFAULT NULL,
  `client_prenom` varchar(255) DEFAULT NULL,
  `client_tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`client_id`, `client_login`, `client_password`, `client_naissance`, `client_nom`, `client_prenom`, `client_tel`) VALUES
(8, 'a', '$2a$10$GVFpVIByFmuBmw.nJ0LcZef1rhyzNUTItoWZVM5ooaGfFiZJ.JX36', '2023-06-05', 'a', 'a', '0645785612'),
(10, 'oui', '$2a$10$X2viz1pqcD7ovtRND0qbtu6/tWYrksYCkbOJDHOmI7cmrykIsPB4u', '2023-06-06', 'oui', 'oui', '0712456932'),
(11, 'Login', '$2a$10$RqAEcGwNsFfxQauXrcGr9Oh0/DUJNyG80cTcq462wukCOWi1cgywq', '1997-03-26', 'test', 'test', '0714253678'),
(12, 'client', '$2a$10$x7/c.Q/AeZ85MAZYi6Ea8.ATovkcGclQJyQIAn1vV7vApubNZPPVC', '2023-06-06', 'client', 'client', '0625369874'),
(15, 'clientDemo2', '$2a$10$fRIOUDuY3784RwxpZUYhHOwbUVQsqrkwAVBI8a1Y7tbsju/3j..xS', '1997-03-27', 'Demo', 'client', '1234567898'),
(16, 'clientDemo', '$2a$10$R2ZZRBUxLmB6KpEyYaXNLuIR8YPEzTzNaxQTzuLs6JXff6xYapv2a', '1997-06-12', 'Demo', 'client', '1234567897');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `event_id` bigint NOT NULL AUTO_INCREMENT,
  `event_date_begining` date NOT NULL,
  `event_date_finish` date NOT NULL,
  `event_time_begining` time NOT NULL,
  `event_time_finish` time NOT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `event_price` double DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  `event_local_id` bigint DEFAULT NULL,
  `event_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `event_local_id_fk` (`event_local_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`event_id`, `event_date_begining`, `event_date_finish`, `event_time_begining`, `event_time_finish`, `event_name`, `event_price`, `event_type`, `event_local_id`, `event_image`) VALUES
(13, '2023-07-07', '2023-07-07', '20:00:00', '00:00:00', 'Awesome Reggae Fest', 50, 'concert', 11, '../../../../assets/images/Green_and_Orange_African_Even_Instagram_Post.png'),
(14, '2023-12-20', '2023-12-20', '21:00:00', '23:00:00', 'Jordan Abid Live', 29.99, 'concert', 1, '../../../../assets/images/Blue_Music_Concert_Instagram_Post.png'),
(17, '2023-07-07', '2023-07-08', '19:00:00', '05:00:00', 'Music Party', 100, 'concert', 14, '../../../../assets/images/Black_Modern_Music_Party_Poster.png'),
(18, '2023-12-11', '2023-12-11', '20:00:00', '22:00:00', 'Concert Ange ou Demon', 20, 'concert', 15, '../../../../assets/images/Bleu_et_Rose_Disco_Degrade_Concert_Soiree_Evenement_Flyer.png'),
(19, '2030-12-24', '2030-12-25', '23:00:00', '05:00:00', 'BEATS AJC NIGHT', 25, 'concert', 14, '../../../../assets/images/Blue_Music_Concert_Instagram_Post_1.png'),
(20, '2023-12-10', '2023-12-11', '19:00:00', '19:00:00', 'AJC Foot Festival', 15, 'festival', 16, '../../../../assets/images/foot-festival.png'),
(21, '2023-10-13', '2023-10-13', '19:00:00', '23:00:00', 'JAVA Party', 20, 'concert', 17, '../../../../assets/images/javaparty.png'),
(22, '2023-08-27', '2023-08-27', '10:00:00', '23:59:00', 'AJC METAL FEST', 50, 'festival', 11, '../../../../assets/images/Dark Blue Yellow Simple Rock Music Fest Poster.png'),
(23, '2023-08-15', '2023-08-16', '09:00:00', '20:00:00', 'Javan Expo', 20, 'exposition', 18, '../../../../assets/images/JAVANEXPO.png'),
(24, '2023-11-18', '2023-11-18', '20:00:00', '23:30:00', 'JORDEMINEM SHOW CASE', 70, 'concert', 19, '../../../../assets/images/Jordeminem.png'),
(25, '2023-08-30', '2023-08-31', '22:00:00', '05:00:00', 'Tropical AJC Party', 30, 'festival', 19, '../../../../assets/images/party.png'),
(26, '2023-06-15', '2023-06-15', '20:00:00', '23:00:00', 'Le concert de J Abid', 50, 'concert', 20, '../../../../assets/images/Poster_concert_musique_photomaton.png'),
(27, '2023-09-09', '2023-09-09', '16:00:00', '19:00:00', 'Concert of AJC', 50, 'concert', 19, '../../../../assets/images/Retro  Music Party Announcement Poster  .png'),
(28, '2030-12-24', '2030-12-25', '22:00:00', '05:00:00', 'Music Party Night', 25, 'festival', 19, '../../../../assets/images/Yellow_And_Red_Modern_DJ_Music_Party_Night_Instagram_Post_Portrait.png');

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

DROP TABLE IF EXISTS `localisation`;
CREATE TABLE IF NOT EXISTS `localisation` (
  `local_id` bigint NOT NULL AUTO_INCREMENT,
  `local_name` varchar(255) DEFAULT NULL,
  `local_places_assises` int DEFAULT NULL,
  `local_places_fosse` int DEFAULT NULL,
  `local_places_pmr` int DEFAULT NULL,
  `local_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`local_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `localisation`
--

INSERT INTO `localisation` (`local_id`, `local_name`, `local_places_assises`, `local_places_fosse`, `local_places_pmr`, `local_image`) VALUES
(1, 'Zenith de Montpellier', 10000, 5000, 1000, ''),
(2, 'Paris Bercy', 20000, 10000, 10000, NULL),
(11, 'Zenith de Marseille', 15000, 5000, 1000, NULL),
(14, 'Zenith de Paris', 15000, 0, 0, NULL),
(15, 'Théâtre de Vichy', 750, 0, 0, NULL),
(16, 'Abid Stadium Arena', 30000, 0, 0, NULL),
(17, 'Olympia', 5000, 0, 0, NULL),
(18, 'Parc Floral de Paris', 7500, 0, 0, NULL),
(19, 'AJC LOCAUX', 200, 0, 0, NULL),
(20, 'Salle Jacques Brel', 300, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `organisation`
--

DROP TABLE IF EXISTS `organisation`;
CREATE TABLE IF NOT EXISTS `organisation` (
  `organisation_staff_id` bigint NOT NULL,
  `organisation_event_id` bigint NOT NULL,
  PRIMARY KEY (`organisation_staff_id`,`organisation_event_id`),
  KEY `organisation_event_id_fk` (`organisation_event_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `organisation`
--

INSERT INTO `organisation` (`organisation_staff_id`, `organisation_event_id`) VALUES
(1, 13),
(1, 14),
(1, 18),
(1, 22),
(1, 24),
(2, 13),
(2, 17),
(2, 18),
(2, 20),
(4, 17),
(4, 21),
(4, 25),
(4, 26),
(4, 27),
(4, 28);

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

DROP TABLE IF EXISTS `participant`;
CREATE TABLE IF NOT EXISTS `participant` (
  `participant_id` bigint NOT NULL AUTO_INCREMENT,
  `participant_age` int DEFAULT NULL,
  `participant_name` varchar(255) DEFAULT NULL,
  `reduc` varchar(255) DEFAULT NULL,
  `type_place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`participant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `participation_participant_id` bigint NOT NULL,
  `participation_reservation_id` bigint NOT NULL,
  PRIMARY KEY (`participation_participant_id`,`participation_reservation_id`),
  KEY `participation_reservation_id_fk` (`participation_reservation_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `prestation`
--

DROP TABLE IF EXISTS `prestation`;
CREATE TABLE IF NOT EXISTS `prestation` (
  `prestation_artiste_id` bigint NOT NULL,
  `prestation_event_id` bigint NOT NULL,
  PRIMARY KEY (`prestation_artiste_id`,`prestation_event_id`),
  KEY `prestation_event_id_fk` (`prestation_event_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `prestation`
--

INSERT INTO `prestation` (`prestation_artiste_id`, `prestation_event_id`) VALUES
(4, 18),
(4, 19),
(4, 20),
(4, 22),
(4, 25),
(4, 28),
(5, 17),
(5, 20),
(5, 22),
(5, 25),
(5, 27),
(5, 28),
(7, 13),
(7, 20),
(7, 21),
(7, 22),
(7, 27),
(7, 28),
(8, 14),
(8, 20),
(8, 22),
(8, 26),
(9, 20),
(9, 22),
(10, 24);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` bigint NOT NULL AUTO_INCREMENT,
  `reservation_date` date DEFAULT NULL,
  `reservation_price` double DEFAULT NULL,
  `reservation_client_id` bigint DEFAULT NULL,
  `reservation_event_id` bigint DEFAULT NULL,
  PRIMARY KEY (`reservation_id`),
  KEY `reservation_client_id_fk` (`reservation_client_id`),
  KEY `reservation_event_id_fk` (`reservation_event_id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `reservation_date`, `reservation_price`, `reservation_client_id`, `reservation_event_id`) VALUES
(12, '2023-06-06', 179.94, 9, 14),
(33, '2023-06-06', 20, 13, 21),
(36, '2023-06-06', 100, 16, 28),
(28, '2023-06-06', 89.97, 12, 14),
(23, '2023-06-06', 200, 11, 12),
(34, '2023-06-06', 50, 15, 28),
(24, '2023-06-06', 150, 11, 13);

-- --------------------------------------------------------

--
-- Structure de la table `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` bigint NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `staff`
--

INSERT INTO `staff` (`staff_id`, `staff_name`) VALUES
(1, 'staff1'),
(2, 'staff2'),
(4, 'staff3');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `event_local_id_fk` FOREIGN KEY (`event_local_id`) REFERENCES `localisation` (`local_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
