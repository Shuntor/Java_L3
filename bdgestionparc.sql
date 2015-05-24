-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 24 Mai 2015 à 23:48
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `bdgestionparc`
--

-- --------------------------------------------------------

--
-- Structure de la table `appareils`
--

CREATE TABLE IF NOT EXISTS `appareils` (
  `idA` int(11) NOT NULL,
  `nom` varchar(150) DEFAULT NULL,
  `typeA` varchar(150) DEFAULT NULL,
  `adrMac` varchar(150) DEFAULT NULL,
  `idS` int(11) DEFAULT NULL,
  `idO` int(11) DEFAULT NULL,
  `etat` varchar(30) NOT NULL,
  PRIMARY KEY (`idA`),
  KEY `idS` (`idS`),
  KEY `idO` (`idO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `appareils`
--

INSERT INTO `appareils` (`idA`, `nom`, `typeA`, `adrMac`, `idS`, `idO`, `etat`) VALUES
(1, 'dqd', 'Switch', 'qdzd', 1, 2, 'Marche '),
(2, 'dqd2', 'Switch', 'qdzd', 2, 2, 'Marche '),
(3, 'dqd3', 'Switch', 'qdzd', 3, 2, 'Marche '),
(4, 'dqd4', 'Switch', 'qdzd', 3, 2, 'Marche '),
(5, 'dqd5', 'Switch', 'qdzd', 3, 2, 'Marche '),
(6, 'dqd6', 'Switch', 'qdzd', 1, 1, 'Marche '),
(7, 'azaz', 'Switch', 'azazzazazaza', 1, 1, 'Marche '),
(8, 'A', 'Routeur ', 'aa:aa:aa:aa:aa:aa', 1, 1, 'Marche '),
(9, 'ordi', 'Ordinateur', 'ii:ii:ii:ii:ii:ii', 1, 1, 'Marche '),
(10, 'ordi2', 'Ordinateur', '22:22:22:22:22:22', 1, 1, 'Marche '),
(11, 'switch1', 'Switch', '11:11:11:11:11:11', 1, 1, 'Marche '),
(12, 'ordi3', 'Switch', 'dzdzdzdzdzdz', 1, 1, 'Marche ');

-- --------------------------------------------------------

--
-- Structure de la table `connecter`
--

CREATE TABLE IF NOT EXISTS `connecter` (
  `idAppareilA` int(11) NOT NULL DEFAULT '0',
  `idAppareilB` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idAppareilA`,`idAppareilB`),
  KEY `idAppareilB` (`idAppareilB`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `connecter`
--

INSERT INTO `connecter` (`idAppareilA`, `idAppareilB`) VALUES
(1, 2),
(8, 9),
(8, 10),
(8, 11);

-- --------------------------------------------------------

--
-- Structure de la table `locaux`
--

CREATE TABLE IF NOT EXISTS `locaux` (
  `idL` int(11) NOT NULL,
  `nom` varchar(150) DEFAULT NULL,
  `adresse` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `locaux`
--

INSERT INTO `locaux` (`idL`, `nom`, `adresse`) VALUES
(3, 'jTextField1zad', 'jTextField1azdezad'),
(4, 'Local Test1', 'jTextField1'),
(5, 'Local Test3', 'jTextField1'),
(6, 'localTest4', 'zdzefze');

-- --------------------------------------------------------

--
-- Structure de la table `os`
--

CREATE TABLE IF NOT EXISTS `os` (
  `idO` int(11) NOT NULL,
  `nom` varchar(150) DEFAULT NULL,
  `version` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `os`
--

INSERT INTO `os` (`idO`, `nom`, `version`) VALUES
(1, 'windows', '7.1'),
(2, 'Windows 8', '3'),
(3, 'Windows', '7.1');

-- --------------------------------------------------------

--
-- Structure de la table `salles`
--

CREATE TABLE IF NOT EXISTS `salles` (
  `idS` int(11) NOT NULL,
  `idL` int(11) DEFAULT NULL,
  `numero` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idS`),
  KEY `idL` (`idL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `salles`
--

INSERT INTO `salles` (`idS`, `idL`, `numero`) VALUES
(1, 3, 'Salle Test1'),
(2, 3, 'Salle Test2'),
(3, 3, 'salleTest3');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `appareils`
--
ALTER TABLE `appareils`
  ADD CONSTRAINT `appareils_ibfk_1` FOREIGN KEY (`idS`) REFERENCES `salles` (`idS`),
  ADD CONSTRAINT `appareils_ibfk_2` FOREIGN KEY (`idO`) REFERENCES `os` (`idO`);

--
-- Contraintes pour la table `connecter`
--
ALTER TABLE `connecter`
  ADD CONSTRAINT `connecter_ibfk_1` FOREIGN KEY (`idAppareilA`) REFERENCES `appareils` (`idA`),
  ADD CONSTRAINT `connecter_ibfk_2` FOREIGN KEY (`idAppareilB`) REFERENCES `appareils` (`idA`);

--
-- Contraintes pour la table `salles`
--
ALTER TABLE `salles`
  ADD CONSTRAINT `salles_ibfk_1` FOREIGN KEY (`idL`) REFERENCES `locaux` (`idL`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
