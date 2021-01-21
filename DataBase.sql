-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 22 jan. 2021 à 00:31
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tutorat`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `idCours` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `heur` time DEFAULT NULL,
  `salle` varchar(50) NOT NULL,
  `nbEleveMax` tinyint(4) NOT NULL,
  `descriptif` text DEFAULT NULL,
  `idmatiere` int(11) NOT NULL,
  `idResponsable` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`idCours`, `nom`, `date`, `heur`, `salle`, `nbEleveMax`, `descriptif`, `idmatiere`, `idResponsable`) VALUES
(1, 'Algèbre 2', '2021-01-25', '10:15:00', 'L1080', 20, ' Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 1, '21603273'),
(2, 'Mathématiques : raisonnement', '2021-02-01', '16:45:00', 'L0050', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 6, '21803142'),
(3, 'Mathématiques : calculus', '2021-02-08', '17:00:00', 'L0040', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 6, '21803142'),
(4, 'Physique', '2021-01-26', '18:00:00', 'L0060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 7, '21902198'),
(5, 'Informatique I', '2021-01-28', '17:30:00', 'E20070', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 31, '21902769'),
(6, 'Analyse 2', '2021-02-15', '19:00:00', 'L0020', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 14, '21903861'),
(7, 'Informatique II', '2021-02-09', '15:15:00', 'E20070', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 32, '22002211'),
(8, 'Mécanique du point avancée', '2021-02-16', '18:00:00', 'L1060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 2, '21700437'),
(9, 'Algorithmique & Prog. Objet', '2021-02-03', '08:00:00', 'L0050', 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 3, '21705267'),
(10, 'Electrostatique', '2021-02-25', '09:00:00', 'L0040', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 8, '21806841'),
(11, 'Chimie I', '2021-02-19', '14:00:00', 'L0090', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 33, '21900851'),
(12, 'Mathématiques II', '2021-03-01', '18:30:00', 'E20070', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 9, '21901985'),
(13, 'Logique pour l\'informatique', '2021-02-16', '13:30:00', 'L1080', 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 11, '21801345'),
(14, 'Prog. Fonctionnelle & Ocaml', '2021-02-16', '19:00:00', 'L0050', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 12, '21809442'),
(15, 'Prog.web', '2021-03-23', '17:15:00', 'E20050', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 13, '21906195'),
(16, 'Algo & Prog.objet', '2021-03-09', '10:15:00', 'L0060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 3, '21904248'),
(17, 'Chimie 2', '2021-02-18', '18:00:00', 'L0080', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 4, '21907196'),
(18, 'SV2', '2021-02-26', '15:15:00', 'L0050', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 28, '21701536'),
(19, 'Eléments de chimie', '2021-02-24', '16:30:00', 'L0040', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 24, '21802569'),
(20, 'Transformation de la matière', '2021-02-17', '18:00:00', 'L0060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 19, '21907207'),
(21, 'Réactivité en chimie organique', '2021-02-10', '19:00:00', 'L0020', 15, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 18, '21909003'),
(22, 'Chimie I', '2021-01-27', '08:00:00', 'L1060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 22, '21708435'),
(23, 'Géosciences & env.', '2021-01-29', '17:00:00', 'L0050', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 5, '21987540'),
(24, 'Outils de géosciences', '2021-03-05', '16:00:00', 'L0040', 10, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 21, '21801589'),
(25, 'Géosciences I', '2021-03-12', '11:00:00', 'L0060', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 38, '21806420'),
(26, 'Physique+Bio', '2021-01-27', '09:00:00', 'L0020', 20, 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\ntempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\nquis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\nconsequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\ncillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\nproident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 23, '0'),
(31, 'Maths Revision TD1', '2021-01-29', '10:15:00', 'E21060', 12, '', 9, '21705267');

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `idFiliere` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`idFiliere`, `nom`) VALUES
(1, 'Mathématiques'),
(2, 'Physique'),
(3, 'Informatique'),
(4, 'Chimie'),
(5, 'Sciences de la Terre');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `idmatiere` int(11) NOT NULL,
  `nom` varchar(70) NOT NULL,
  `idFiliere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`idmatiere`, `nom`, `idFiliere`) VALUES
(1, 'Algèbre 2 : structures de base', 1),
(2, 'Mécanique du point', 2),
(3, 'Algorithmique & Prog. Objet', 3),
(4, 'Chimie 2', 4),
(5, 'Géosciences & environnements I', 5),
(6, 'Calculus & raisonnement', 1),
(7, 'Physique (maths)', 1),
(8, 'Electrostatique', 2),
(9, 'Mathématiques II', 2),
(10, 'Algèbre & Analyse II', 3),
(11, 'Logique pour l\'informatique', 3),
(12, 'Prog. Fonctionnelle', 3),
(13, 'Base de données & Prog Web', 3),
(14, 'Analyse 2: suites & fonctions', 1),
(15, 'Mécanique du point avancée', 2),
(16, 'Informatique I', 2),
(17, 'Architecture et propriétés des composés inorganiques', 4),
(18, 'Réactivité et transformation en chimie organique', 4),
(19, 'Structure et transformation de la matière', 4),
(20, 'Physique', 5),
(21, 'Outils des géosciences', 5),
(22, 'Chimie 1', 5),
(23, 'Physique + Biologie', 5),
(24, 'Eléments de chimie inorganique et organique', 4),
(25, 'Physique I', 4),
(26, 'Physique II', 4),
(27, 'Géosciences', 4),
(28, 'SV2', 4),
(29, 'Physique (info)', 3),
(30, 'Math: calculus & raisonnement', 3),
(31, 'Informatique I', 1),
(32, 'Informatique II', 1),
(33, 'Chimie I', 2),
(34, 'Géosciences I', 2),
(35, 'Sciences de la terre', 2),
(36, 'Mathématiques I', 2),
(37, ' Réactivité & cinétique de la transformation chimique', 5),
(38, 'Géosciences I', 5);

-- --------------------------------------------------------

--
-- Structure de la table `s_inscrit`
--

CREATE TABLE `s_inscrit` (
  `idCours` int(11) NOT NULL,
  `userNumEtu` char(8) NOT NULL,
  `surAttente` tinyint(1) NOT NULL,
  `présence` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `s_inscrit`
--

INSERT INTO `s_inscrit` (`idCours`, `userNumEtu`, `surAttente`, `présence`) VALUES
(1, '21705277', 0, 0),
(1, '21900010', 0, 0),
(1, '21902170', 0, 0),
(1, '21902236', 0, 0),
(4, '21805280', 0, 0),
(4, '21808675', 0, 0),
(4, '21904081', 0, 0),
(4, '21907018', 0, 0),
(7, '21705267', 0, 0),
(7, '21902287', 0, 0),
(7, '21902390', 0, 0),
(7, '21903073', 0, 0),
(7, '21903175', 0, 0),
(13, '21705267', 0, 0),
(13, '21900298', 0, 0),
(13, '21900673', 0, 0),
(13, '21900744', 0, 0),
(13, '21901215', 0, 0),
(13, '21904248', 0, 0),
(13, '21905372', 0, 0),
(13, '21905665', 0, 0),
(13, '21905810', 0, 0),
(13, '21906455', 0, 0),
(13, '21906622', 0, 0),
(13, '22009350', 1, 0),
(21, '21606559', 0, 0),
(21, '21701435', 0, 0),
(21, '21701536', 0, 0),
(21, '21704106', 0, 0),
(21, '21706231', 0, 0),
(21, '21802569', 0, 0),
(21, '21804930', 0, 0),
(21, '21808158', 0, 0),
(21, '21808197', 0, 0),
(21, '21901576', 0, 0),
(21, '21901793', 0, 0),
(21, '21903145', 0, 0),
(21, '21904889', 0, 0),
(21, '21905747', 0, 0),
(21, '21907115', 0, 0),
(21, '21907207', 1, 0),
(21, '21907542', 1, 0),
(21, '21908100', 1, 0),
(21, '21908420', 1, 0),
(24, '21900021', 0, 0),
(24, '21900210', 0, 0),
(24, '21900396', 0, 0),
(24, '21902145', 0, 0),
(24, '21903889', 0, 0),
(24, '21908020', 0, 0),
(24, '21908132', 0, 0),
(24, '21927631', 0, 0),
(24, '21945623', 0, 0),
(24, '21987540', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `userNumEtu` char(8) NOT NULL,
  `userNom` varchar(50) NOT NULL,
  `userPrenom` varchar(50) NOT NULL,
  `userMail` varchar(80) NOT NULL,
  `password` varchar(15) NOT NULL,
  `statut` varchar(50) NOT NULL,
  `idFiliere` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`userNumEtu`, `userNom`, `userPrenom`, `userMail`, `password`, `statut`, `idFiliere`) VALUES
('21603273', 'Paillard', 'Felix', 'felix.paillard@etu.univ-tours.fr', 'Vgr1$7', 'Etudiant-Tuteur', 1),
('21606559', 'Faili', 'Mohamed', 'mohamed.faili@etu.univ-tours.fr', 'baby71', 'Etudiant', 4),
('21700437', 'Chatelin', 'Lucie', 'lucie.chatelin@etu.univ-tours.fr', 'vanilk20!', 'Etudiant-Tuteur', 2),
('21701435', 'Gourja', 'Ahmed', 'ahmed.gourja@etu.univ-tours.fr', 'Mmbappe_', 'Etudiant', 4),
('21701536', 'Marhouf', 'Lena', 'lena.marhouf@etu.univ-tours.fr', 'tahia213!', 'Etudiant-Tuteur', 4),
('21701972', 'Palata Apu', 'Syntiche', 'syntiche.palataapu@etu.univ-tours.fr', '01syn27', 'Etudiante', 5),
('21702171', 'Razavet', 'Quentin', 'quentin.razavet@etu.univ-tours.fr', 'flou_5', 'Etudiant', 2),
('21702271', 'Hussein', 'Hassan', 'hassan.hussein@etu.univ-tours.fr', 'huss-itachi', 'Etudiant', 2),
('21704106', 'Ntumba Ntumba', 'Daniel', 'daniel.ntumbantumba@etu.univ-tours.fr', 'mardo3112', 'Etudiant', 4),
('21705267', 'Perrouault', 'Léo', 'léo.perrouault@etu.univ-tours.fr', 'solene015', 'Etudiant-Tuteur', 3),
('21705277', 'Van', 'Hugo', 'hugo.van@etu.univ-tours.fr', 'soleil015', 'Etudiant', 1),
('21706231', 'Mathy', 'Jose', 'jose.mathy@etu.univ-tours.fr', 'paulM213!', 'Etudiant', 4),
('21708435', 'Arfa', 'Amine', 'amine.arfa@etu.univ-tours.fr', 'Kmbappe_', 'Etudiant-Tuteur', 5),
('21709310', 'El Asri', 'Oussama', 'oussama.elasri@etu.univ-tours.fr', 'movic89!', 'Etudiant', 3),
('21709437', 'Chataignier', 'Edouard', 'edouard.chataignier@etu.univ-tours.fr', 'TomCRk20!', 'Etudiant', 1),
('21725370', 'Bertili', 'Gael', 'gael.bertili@etu.univ-tours.fr', 'pauBr17', 'Etudiant', 5),
('21754002', 'LaBroche', 'Nicolas', 'nicolas.labroche@etu.univ-tours.fr', 'mymyM213!', 'Etudiant', 5),
('21801345', 'Abraham', 'Aurélie', 'aurélie.abraham@etu.univ-tours.fr', 'Mark20!', 'Etudiant-Tuteur', 3),
('21801463', 'Litaudon', 'Lilian', 'lilian.litaudon@etu.univ-tours.fr', 'VwxNni_2', 'Etudiant', 1),
('21801589', 'Delaunay', 'Cassandra', 'Cassandra.Delaunay@etu.univ-tours.fr', '.Delaunay', 'Etudiant-Tuteur', 5),
('21801623', 'Robenson', 'Lucas', 'lucas.robenson@etu.univ-tours.fr', 'reiner__0', 'Etudiant', 2),
('21802569', 'Aulnay', 'Patrick', 'patrick.aulnay@etu.univ-tours.fr', 'Resax14?', 'Etudiant-Tuteur', 4),
('21802841', 'Toledano', 'Dylan', 'dylan.toledano@etu.univ-tours.fr', 'Xcwar56!', 'Etudiant', 1),
('21803142', 'Serghini', 'Amel', 'amel.serghini@etu.univ-tours.fr', 'for$ra210', 'Etudiant-Tuteur', 1),
('21804365', 'Pornet', 'Jean', 'jean.pornet@etu.univ-tours.fr', 'VBr1$7', 'Etudiant', 3),
('21804930', 'Bourgs', 'Fanny', 'fanny.bourgs@etu.univ-tours.fr', 'ducer__', 'Etudiant-Tuteur', 4),
('21805280', 'Soliveres', 'Deborah', 'deborah.soliveres@etu.univ-tours.fr', 'buenema_9', 'Etudiante', 1),
('21805663', 'Proix', 'Rapha', 'rapha.proix@etu.univ-tours.fr', 'Nni_2', 'Etudiant', 2),
('21805887', 'Boucher', 'Alexandre', 'alexandre.boucher@etu.univ-tours.fr', 'fix_10', 'Etudiant', 3),
('21806420', 'Bourgeois', 'Fabien', 'fabien.bourgeois@etu.univ-tours.fr', 'duczer__', 'Etudiant-Tuteur', 5),
('21806841', 'Pons', 'Olivier', 'olivier.pons@etu.univ-tours.fr', 'Var56!', 'Etudiant-Tuteur', 2),
('21808158', 'Diallo', 'Amina', 'amina.diallo@etu.univ-tours.fr', 'extra8210', 'Etudiante', 4),
('21808187', 'Arfa', 'Ines', 'ines.arfa@etu.univ-tours.fr', 'Tourgi-momo12', 'Etudiante', 5),
('21808197', 'Tourga', 'Sarah', 'sarah.tourga@etu.univ-tours.fr', 'Tourga-Samo12', 'Etudiante', 4),
('21808672', 'Saint-ouen', 'Jimmy', 'jimmy.saint-ouen@etu.univ-tours.fr', 'bouboule_', 'Etudiant', 2),
('21808675', 'Mbuta', 'Davina', 'davina.mbuta@etu.univ-tours.fr', 'CI-Vboule_', 'Etudiante', 1),
('21809240', 'Millet', 'Bruno', 'bruno.millet@etu.univ-tours.fr', 'benZema_9', 'Etudiant', 2),
('21809442', 'Baert', 'Nicolas', 'nicolas.baert@etu.univ-tours.fr', 'xvy11', 'Etudiant-Tuteur', 3),
('21810024', 'Ba', 'Aboubacar', 'aboubacar.ba@etu.univ-tours.fr', 'neymar10', 'Etudiant', 5),
('21811024', 'Mhaili', 'Majda', 'majda.mhaili@etu.univ-tours.fr', 'baby571', 'Etudiante', 5),
('21900010', 'Bachelot', 'Aubin', 'aubin.bachelot@etu.univ-tours.fr', 'pommy13!', 'Etudiant', 1),
('21900021', 'Lamy', 'Jessica', 'jessica.lamy@etu.univ-tours.fr', 'jesss37?', 'Etudiant-Tuteur', 5),
('21900054', 'Mermod', 'Emma', 'emma.mermod@etu.univ-tours.fr', 'filou_25', 'Etudiante', 3),
('21900210', 'Detree', 'Valentin', 'valentin.detree@etu.univ-tours.fr', 'detree_3107', 'Etudiant', 5),
('21900298', 'Cherbonnier', 'Marie', 'marie.cherbonnier@etu.univ-tours.fr', 'dLLucer__', 'Etudiante', 3),
('21900396', 'Perret', 'Yves', 'yves.perret@etu.univ-tours.fr', 'croos-210', 'Etudiant', 5),
('21900400', 'Michel', 'Jean', 'jean.michel@etu.univ-tours.fr', 'jm3710', 'Etudiant', 5),
('21900510', 'Touze', 'Tom', 'tom.touze@etu.univ-tours.fr', 'tommy13!', 'Etudiant', 2),
('21900673', 'Chauvin', 'Lisa', 'lisa.chauvin@etu.univ-tours.fr', 'socle015', 'Etudiant-Tuteur', 3),
('21900744', 'Dézé', 'Raphaël', 'raphaël.dézé@etu.univ-tours.fr', 'Nnzonzi_2', 'Etudiant', 3),
('21900759', 'Wolf', 'Emilie', 'emilie.wolf@etu.univ-tours.fr', 'Xtra210', 'Etudiante', 3),
('21900851', 'Michaud', 'Thomas', 'thomas.michaud@etu.univ-tours.fr', 'famine__', 'Etudiant-Tuteur', 2),
('21901021', 'DuFontenay', 'Stéphane', 'stephane.dufontenay@etu.univ-tours.fr', 'oracle015', 'Etudiant', 5),
('21901215', 'Fournier', 'Lucas', 'lucas.fournier@etu.univ-tours.fr', 'rail-20', 'Etudiant', 3),
('21901536', 'Charles', 'Léa', 'léa.Charles@etu.univ-tours.fr', '!emma27', 'Etudiant-Tuteur', 5),
('21901576', 'Dubellay', 'Paul', 'paul.dubellay@etu.univ-tours.fr', 'afix_107', 'Etudiant-Tuteur', 4),
('21901598', 'Mohammed', 'Saïd', 'saïd.mohamed@etu.univ-tours.fr', 'moha_212', 'Etudiant', 2),
('21901793', 'Durant', 'Stéphanie', 'stephanie.durant@etu.univ-tours.fr', 'sacle015', 'Etudiante', 4),
('21901984', 'Timar', 'Richard', 'richard.timar@etu.univ-tours.fr', 'SAlah__', 'Etudiant', 2),
('21901985', 'Paolorsi', 'Lorenzo', 'lorenzo.paolorsi@etu.univ-tours.fr', 'topchef_10', 'Etudiant-Tuteur', 2),
('21902145', 'Fall', 'Khadidja', 'khadidja.fall@etu.univ-tours.fr', 'K?all225', 'Etudiante', 5),
('21902170', 'Rebillard', 'Amaury', 'amaury.rebillard@etu.univ-tours.fr', 'T-pain2', 'Etudiant', 2),
('21902198', 'Cesar', 'Jester', 'jester.cesar@etu.univ-tours.fr', 'topchef_00', 'Etudiant-Tuteur', 1),
('21902236', 'Brocherie', 'Nathan', 'nathan.brocherie@etu.univ-tours.fr', 'skyy11', 'Etudiant', 2),
('21902287', 'Berneuil', 'Justin', 'justin.berneuil@etu.univ-tours.fr', 'skyVany11', 'Etudiant', 1),
('21902390', 'Deceus', 'Daryl', 'daryl.deceus@etu.univ-tours.fr', 'Erenx-in2', 'Etudiant', 1),
('21902769', 'Vang', 'Antonia', 'antonia.vang@etu.univ-tours.fr', 'morFan7?', 'Etudiant-Tuteur', 1),
('21902793', 'Simmons', 'Stella', 'stella.simmons@etu.univ-tours.fr', 'morgan7?', 'Etudiant-Tuteur', 2),
('21903073', 'Lepinoy', 'Felix', 'felix.lepinoy@etu.univ-tours.fr', 'Vgr1$7', 'Etudiant', 2),
('21903144', 'Ejaz', 'Zaineb', 'zaineb.ejaz@etu.univ-tours.fr', 'Py?52', 'Etudiante', 1),
('21903145', 'Fall', 'Sally', 'sally.fall@etu.univ-tours.fr', 'V?all237', 'Etudiante', 4),
('21903169', 'Lefrere', 'Colin', 'colin.lefrere@etu.univ-tours.fr', 'Flisey71', 'Etudiant-Tuteur', 2),
('21903175', 'Sy', 'Omar', 'omar.sy@etu.univ-tours.fr', 'Py?52', 'Etudiant', 2),
('21903179', 'Beneditto', 'Liam', 'liam.beneditto@etu.univ-tours.fr', 'Flisey71', 'Etudiante', 1),
('21903192', 'Vercoutere', 'Estelle', 'estelle.vercoutere@etu.univ-tours.fr', 'fortra210', 'Etudiant-Tuteur', 2),
('21903381', 'Dijoux', 'FLEUR', 'fleur.dijoux@etu.univ-tours.fr', 'Thingsfer__', 'Etudiante', 1),
('21903861', 'Ahamat', 'Issa', 'ahamat.issa@etu.univ-tours.fr', 'amine__', 'Etudiant-Tuteur', 1),
('21903889', 'Bucher', 'Clément', 'clément.bucher@etu.univ-tours.fr', 'mauricette69!', 'Etudiant-Tuteur', 5),
('21904081', 'Pasquier', 'Marthe', 'pasquier.marthe@etu.univ-tours.fr', 'Lucifer__', 'Etudiante', 2),
('21904169', 'Amezquiti', 'Ismaïl', 'ismaïl.amezquito@etu.univ-tours.fr', 'movie9!', 'Etudiant', 1),
('21904248', 'Angama', 'Thomas', 'thomas.angama@etu.univ-tours.fr', 'paul13!', 'Etudiant-Tuteur', 3),
('21904298', 'Boissou', 'Matthieu', 'matthieu.boissou@etu.univ-tours.fr', 'FFby71', 'Etudiant', 3),
('21904889', 'Burshr', 'Yvan', 'yvan.bushr@etu.univ-tours.fr', 'maurice79!', 'Etudiant', 4),
('21905236', 'Chapelle', 'Nathan', 'nathan.chapelle@etu.univ-tours.fr', 'Sardo12', 'Etudiant-Tuteur', 3),
('21905372', 'Dumiot', 'Fidji', 'fidji.dumiot@etu.univ-tours.fr', 'T-Sal12', 'Etudiante', 3),
('21905665', 'Ndiaye', 'Kady', 'kady.ndiaye@etu.univ-tours.fr', 'Papy?52', 'Etudiante', 3),
('21905747', 'Bertolt', 'Vincent', 'vincent.bertolt@etu.univ-tours.fr', 'VauBr17', 'Etudiant-Tuteur', 4),
('21905810', 'Manon', 'Martin', 'manon.martin@etu.univ-tours.fr', 'ben110', 'Etudiante', 3),
('21906195', 'Mbomy Mbala', 'Maria Grace', 'mariagrace.mbomymbala@etu.univ-tours.fr', 'kayembe21!', 'Etudiant-Tuteur', 3),
('21906223', 'Ferraoun', 'Amina', 'amina.ferraoun@etu.univ-tours.fr', 'abdou14_', 'Etudiante', 3),
('21906455', 'Barretau', 'Nadjime', 'nadjime.barretau@etu.univ-tours.fr', 'latan15', 'Etudiant-Tuteur', 3),
('21906622', 'Bradu', 'Adeline', 'adeline.bradu@etu.univ-tours.fr', 'morphe17?', 'Etudiante', 3),
('21907018', 'Edwar', 'Steven', 'steven.edwar@etu.univ-tours.fr', 'Satoio12', 'Etudiant', 2),
('21907115', 'LaPie', 'Laurent', 'laurent.lapie@etu.univ-tours.fr', 'xvg21', 'Etudiant', 4),
('21907143', 'Petree', 'Mylene', 'mylene.petree@etu.univ-tours.fr', 'ben1710', 'Etudiante', 4),
('21907162', 'Mouzni', 'Lamara', 'lamara.mouzni@etu.univ-tours.fr', 'movic9!', 'Etudiant-Tuteur', 2),
('21907196', 'Kayembe ', 'Peter', 'peter.kayembe@etu.univ-tours.fr', 'Maria!2198', 'Etudiant-Tuteur', 4),
('21907207', 'LeMarchand', 'Audrey', 'audrey.lemarchand@etu.univ-tours.fr', 'morphe37?', 'Etudiant-Tuteur', 4),
('21907318', 'Fernandes', 'Antoine', 'antoine.fernandes@etu.univ-tours.fr', 'Santonio12', 'Etudiant', 1),
('21907542', 'Nung', 'Sophie', 'sophie.nung@etu.univ-tours.fr', 'louz10!', 'Etudiante', 4),
('21908020', 'Deschamps', 'Alice', 'alice.deschamps@etu.univ-tours.fr', 'milou_355', 'Etudiante', 5),
('21908100', 'Khalif', 'Aymen', 'aymen.khalif@etu.univ-tours.fr', 'ibrahimovic89!', 'Etudiant', 4),
('21908132', 'Leboeuf', 'Sacha', 'sacha.leboeuf@etu.univ-tours.fr', 'corail-201', 'Etudiant', 5),
('21908420', 'Moineaux', 'Alice', 'alice.moineaux@etu.univ-tours.fr', 'lilou_355', 'Etudiante', 4),
('21908932', 'Louveteaux', 'Benjamin', 'benjamin.louveteaux@etu.univ-tours.fr', 'crail-201', 'Etudiant', 4),
('21909003', 'Charles', 'Xavier', 'xavier.charles@etu.univ-tours.fr', 'zlatan15', 'Etudiant-Tuteur', 4),
('21927631', 'Yasser', 'Manel', 'manel.yasser@etu.univ-tours.fr', 'manel89!', 'Etudiante', 5),
('21945623', 'Lacroix', 'Thomas', 'thomas.lacroix@etu.univ-tours.fr', 'xvgf21', 'Etudiant', 5),
('21987540', 'Bernard', 'Adrien', 'adrien.bernard@etu.univ-tours.fr', 'loulou!', 'Etudiant-Tuteur', 5),
('22001678', 'Manonellas', 'Aurèle', 'aurèle.manonellas@etu.univ-tours.fr', 'mikasa__0', 'Etudiante', 1),
('22002211', 'Razmoket', 'Philippe', 'philippe.razmoket@etu.univ-tours.fr', 'fleVou_5', 'Etudiant-Tuteur', 1),
('22009350', 'Bouchez', 'Yohan', 'yohan.bouchez@etu.univ-tours.fr', 'Varane79!', 'Etudiant', 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`idCours`),
  ADD KEY `cours_matiere_FK` (`idmatiere`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`idFiliere`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`idmatiere`),
  ADD KEY `matiere_filiere_FK` (`idFiliere`);

--
-- Index pour la table `s_inscrit`
--
ALTER TABLE `s_inscrit`
  ADD PRIMARY KEY (`idCours`,`userNumEtu`),
  ADD KEY `s_inscrit_user0_FK` (`userNumEtu`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userNumEtu`),
  ADD UNIQUE KEY `userNumEtu` (`userNumEtu`),
  ADD KEY `user_filiere_FK` (`idFiliere`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `idCours` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT pour la table `filiere`
--
ALTER TABLE `filiere`
  MODIFY `idFiliere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `idmatiere` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_matiere_FK` FOREIGN KEY (`idmatiere`) REFERENCES `matiere` (`idmatiere`);

--
-- Contraintes pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `matiere_filiere_FK` FOREIGN KEY (`idFiliere`) REFERENCES `filiere` (`idFiliere`);

--
-- Contraintes pour la table `s_inscrit`
--
ALTER TABLE `s_inscrit`
  ADD CONSTRAINT `s_inscrit_cours_FK` FOREIGN KEY (`idCours`) REFERENCES `cours` (`idCours`),
  ADD CONSTRAINT `s_inscrit_user0_FK` FOREIGN KEY (`userNumEtu`) REFERENCES `user` (`userNumEtu`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_filiere_FK` FOREIGN KEY (`idFiliere`) REFERENCES `filiere` (`idFiliere`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
