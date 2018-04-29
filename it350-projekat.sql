-- phpMyAdmin SQL Dump
-- version 4.6.5.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 17, 2017 at 05:18 AM
-- Server version: 5.6.34
-- PHP Version: 7.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `it350-projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `apoteka`
--

CREATE TABLE `apoteka` (
`APOTEKA_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apoteka`
---- phpMyAdmin SQL Dump
-- version 4.6.5.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 17, 2017 at 06:45 PM
-- Server version: 5.6.34
-- PHP Version: 7.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `it350-projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `apoteka`
--

CREATE TABLE `apoteka` (
`APOTEKA_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `apoteka`
--

INSERT INTO `apoteka` (`APOTEKA_ID`, `IME`, `ADRESA`, `TELEFON`) VALUES
(1, 'Lili', 'Kraljice Marije 15', '+381603562585'),
(2, 'BENU', 'Kraljice Marije 15', '+381603562585'),
(3, 'Apoteka Lek', 'Bulevar Oslobodjenja 44', '+3816234567');

-- --------------------------------------------------------

--
-- Table structure for table `doktor`
--

CREATE TABLE `doktor` (
`DOKTOR_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`SPECIJALNOST` varchar(255) DEFAULT NULL,
`GODINE_ISKUSTVA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doktor`
--

INSERT INTO `doktor` (`DOKTOR_ID`, `IME`, `PREZIME`, `JMBG`, `SPECIJALNOST`, `GODINE_ISKUSTVA`) VALUES
(1, 'Nikola', 'Markovic', '1506971710256', 'pedijatar', 10),
(2, 'Verica', 'Acimovic', '1506971710256', 'pedijatar', 20),
(3, 'Stefan', 'Velimirovic', '1506971710256', 'hirurg', 15),
(4, 'Nikola', 'Stankovic', '1506971710256', 'oftamolog', 7),
(5, 'Marijana', 'Vasic', '1506971710256', 'pedijatar', 12),
(6, 'Nada', 'Spasic', '1506971710256', 'kardiolog', 10),
(7, 'Jarmila', 'Perunovic', '4567823', 'pedijatar', 7);

-- --------------------------------------------------------

--
-- Table structure for table `farmaceut`
--

CREATE TABLE `farmaceut` (
`RADNIK_ID` int(11) NOT NULL,
`APOTEKA_ID` int(11) DEFAULT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL,
`STRUCNA_SPREMA` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmaceut`
--

INSERT INTO `farmaceut` (`RADNIK_ID`, `APOTEKA_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `STRUCNA_SPREMA`) VALUES
(1, 1, 'Nemanja', 'Vasic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar'),
(2, 1, 'Natasa', 'Ninkovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar'),
(3, 2, 'Natalija', 'Stevanovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar');

-- --------------------------------------------------------

--
-- Table structure for table `farmaceutska_kompanija`
--

CREATE TABLE `farmaceutska_kompanija` (
`KOMPANIJA_ID` char(10) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmaceutska_kompanija`
--

INSERT INTO `farmaceutska_kompanija` (`KOMPANIJA_ID`, `IME`, `TELEFON`) VALUES
('1', 'galenika', '+381603562585'),
('2', 'hemoharm', '+381603562585'),
('3', 'pharmanova', '+381603562585'),
('4', 'zorka pharma', '+381603562585');

-- --------------------------------------------------------

--
-- Table structure for table `istorija_zaposlenja`
--

CREATE TABLE `istorija_zaposlenja` (
`APOTEKA_ID` int(11) NOT NULL,
`RADNIK_ID` int(11) NOT NULL,
`MESECI` int(11) DEFAULT NULL,
`DANI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `istorija_zaposlenja`
--

INSERT INTO `istorija_zaposlenja` (`APOTEKA_ID`, `RADNIK_ID`, `MESECI`, `DANI`) VALUES
(2, 2, 15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `komercijalista`
--

CREATE TABLE `komercijalista` (
`RADNIK_ID` int(11) NOT NULL,
`APOTEKA_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `komercijalista`
--

INSERT INTO `komercijalista` (`RADNIK_ID`, `APOTEKA_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`) VALUES
(2, 1, 'Slavica', 'Djankovic', '1677894', 'Milutina Milankovica 15', '+38164555234'),
(3, 2, 'Svetozar', 'Zoranovic', '3456788', 'Kneginje Zorke 77', '+381627345'),
(4, 1, 'Nemanja', 'Damjanovic', '1706971710246', 'Milutina Milankovica 4', '+381603562585'),
(5, 1, 'Marija', 'Stankovic', '1706971710246', 'Milutina Milankovica 4', '+381603562585'),
(6, 2, 'Nikola', 'Milosevic', '1706971710246', 'Milutina Milankovica 4', '+381603562585');

-- --------------------------------------------------------

--
-- Table structure for table `lek`
--

CREATE TABLE `lek` (
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lek`
--

INSERT INTO `lek` (`KOMPANIJA_ID`, `SIFRA`, `IME`) VALUES
('1', 256, 'amikacin'),
('1', 257, 'gentamicin'),
('1', 259, 'sintopozid'),
('1', 260, 'holoksan'),
('1', 262, 'sinoksal'),
('1', 263, 'avastin'),
('1', 264, 'dolamin'),
('2', 255, 'ampicilin'),
('2', 266, 'sinicilin'),
('2', 267, 'palitreks'),
('2', 269, 'neko ime sa dol'),
('3', 258, 'merocid'),
('3', 261, 'kasplatin'),
('3', 265, 'sinopen'),
('4', 268, 'amokcicilin');

-- --------------------------------------------------------

--
-- Table structure for table `pacijent`
--

CREATE TABLE `pacijent` (
`PACIJENT_ID` int(11) NOT NULL,
`DOKTOR_ID` int(11) DEFAULT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`DATUM_RODJENJA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacijent`
--

INSERT INTO `pacijent` (`PACIJENT_ID`, `DOKTOR_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `DATUM_RODJENJA`) VALUES
(2, 2, 'Natasa', 'Maric', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(3, 1, 'Suzana', 'Tomovic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(4, 1, 'Nikola', 'Tankosic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(5, 4, 'Marko', 'Milivojevic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(6, 6, 'Snezana', 'Taskovic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(7, 2, 'Marko', 'Prodanovic', '7653324567788', 'Cara Dusana 84', '1991-10-08'),
(8, 5, 'Slavis', 'Simikic', '6666666', 'Bulevar Oslobodjenja 5', '1992-03-03'),
(9, 5, 'Jovandeka', 'Radic', '7777', 'Prvomajska 5', '1992-02-06'),
(10, 5, 'Srdjan', 'Stevanovic', '98765', 'Branka Copica 2', '1994-01-10'),
(11, 5, 'Goran', 'Dimitrijevic', '44567', 'Branka Copica 1', '1993-10-10'),
(12, 5, 'Ljuba', 'Kretenovic', '55553', 'Nikole Tesle 13', '1993-10-10'),
(13, 5, 'Slavica', 'Stevic', '67234', 'Nikole Tesle 33', '1993-11-11'),
(14, 5, 'Jelena', 'Karleusa', '890324', 'Bulevar Oslobodjenja bb', '1977-01-11'),
(15, 5, 'Svetlana', 'Raznatovic', '673445', 'Bulevar Oslobodjenja 12', '1974-01-12'),
(16, 5, 'Svetlana', 'Beric', '1678934422', 'Bulevar Oslobodjenja 18', '1970-01-12'),
(17, 5, 'Zorica', 'Zoric', '1678934422', 'Bulevar Oslobodjenja 11', '1990-01-12'),
(18, 5, 'Zorica', 'Markovic', '65433678', 'Bulevar Oslobodjenja 23', '1993-01-12');

-- --------------------------------------------------------

--
-- Table structure for table `prepisani_lekovi`
--

CREATE TABLE `prepisani_lekovi` (
`RECEPT_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`KOLICINA` int(11) DEFAULT NULL,
`TRAJANJE_TERAPIJE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prepisani_lekovi`
--

INSERT INTO `prepisani_lekovi` (`RECEPT_ID`, `KOMPANIJA_ID`, `SIFRA`, `KOLICINA`, `TRAJANJE_TERAPIJE`) VALUES
(2, '1', 257, 7, 10),
(18, '1', 263, 16, 16),
(19, '1', 257, 2, 15);

-- --------------------------------------------------------

--
-- Table structure for table `prodaja_lekova`
--

CREATE TABLE `prodaja_lekova` (
`APOTEKA_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`CENA` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodaja_lekova`
--

INSERT INTO `prodaja_lekova` (`APOTEKA_ID`, `KOMPANIJA_ID`, `SIFRA`, `CENA`) VALUES
(1, '2', 255, 700),
(1, '2', 269, 500),
(2, '1', 259, 700),
(2, '1', 262, 700),
(2, '2', 255, 700);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE `radnik` (
`RADNIK_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`RADNIK_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`) VALUES
(1, 'Nemanja', 'Vasic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(2, 'Natasa', 'Ninkovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(3, 'Natalija', 'Stevanovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(4, 'Nemanja', 'Damjanovic', '1706971710246', 'Cvijiceva 112', '+381603562585'),
(5, 'Marija', 'Stankovic', '1706971710246', 'Cvijiceva 112', '+381603562585'),
(6, 'Nikola', 'Milosevic', '1706971710246', 'Cvijiceva 112', '+381603562585'),
(7, 'Dragan', 'Kojic', '13452677', 'Njegoseva 7', '+3816349885'),
(8, 'Milica', 'Todorovic', '14452677', 'Ustanicka 5', '+3816349981'),
(9, 'Milica', 'Milosavljevic', '12452655', 'Ustanicka 9', '+381614441');

-- --------------------------------------------------------

--
-- Table structure for table `recept`
--

CREATE TABLE `recept` (
`RECEPT_ID` int(11) NOT NULL,
`PACIJENT_ID` int(11) NOT NULL,
`DOKTOR_ID` int(11) NOT NULL,
`DATUM` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recept`
--

INSERT INTO `recept` (`RECEPT_ID`, `PACIJENT_ID`, `DOKTOR_ID`, `DATUM`) VALUES
(2, 3, 5, '2016-10-22'),
(3, 8, 5, '2016-01-01'),
(4, 9, 5, '2016-01-02'),
(5, 10, 5, '2016-01-03'),
(6, 11, 5, '2016-01-03'),
(7, 12, 5, '2016-01-04'),
(8, 13, 5, '2016-01-05'),
(9, 14, 5, '2016-01-06'),
(10, 15, 5, '2016-01-07'),
(11, 16, 5, '2016-02-07'),
(12, 17, 5, '2016-02-10'),
(13, 18, 5, '2016-02-15'),
(14, 10, 2, '2016-02-09'),
(15, 2, 2, '2017-08-19'),
(16, 8, 5, '2017-09-18'),
(17, 3, 1, '2017-10-11'),
(18, 7, 2, '2017-10-11'),
(19, 6, 6, '2016-03-23');

-- --------------------------------------------------------

--
-- Table structure for table `ugovor`
--

CREATE TABLE `ugovor` (
`UGOVOR_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`RADNIK_ID` int(11) NOT NULL,
`DATUM_SKLAPANJA` date DEFAULT NULL,
`DATUM_ISTEKA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ugovor`
--

INSERT INTO `ugovor` (`UGOVOR_ID`, `KOMPANIJA_ID`, `RADNIK_ID`, `DATUM_SKLAPANJA`, `DATUM_ISTEKA`) VALUES
(2, '1', 4, '2007-01-01', '2027-01-01'),
(3, '1', 5, '2005-07-05', '2027-07-05'),
(4, '2', 6, '2010-04-25', '2020-04-25');

-- --------------------------------------------------------

--
-- Table structure for table `zamene`
--

CREATE TABLE `zamene` (
`LEK_KOMPANIJA_ID` char(10) DEFAULT NULL,
`SIFRA` int(11) DEFAULT NULL,
`KOMPANIJA_ID` char(10) DEFAULT NULL,
`LEK_SIFRA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apoteka`
--
ALTER TABLE `apoteka`
ADD PRIMARY KEY (`APOTEKA_ID`);

--
-- Indexes for table `doktor`
--
ALTER TABLE `doktor`
ADD PRIMARY KEY (`DOKTOR_ID`);

--
-- Indexes for table `farmaceut`
--
ALTER TABLE `farmaceut`
ADD PRIMARY KEY (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_11` (`APOTEKA_ID`);

--
-- Indexes for table `farmaceutska_kompanija`
--
ALTER TABLE `farmaceutska_kompanija`
ADD PRIMARY KEY (`KOMPANIJA_ID`);

--
-- Indexes for table `istorija_zaposlenja`
--
ALTER TABLE `istorija_zaposlenja`
ADD PRIMARY KEY (`APOTEKA_ID`,`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_14` (`RADNIK_ID`);

--
-- Indexes for table `komercijalista`
--
ALTER TABLE `komercijalista`
ADD PRIMARY KEY (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_12` (`APOTEKA_ID`);

--
-- Indexes for table `lek`
--
ALTER TABLE `lek`
ADD PRIMARY KEY (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `pacijent`
--
ALTER TABLE `pacijent`
ADD PRIMARY KEY (`PACIJENT_ID`),
ADD KEY `FK_RELATIONSHIP_1` (`DOKTOR_ID`);

--
-- Indexes for table `prepisani_lekovi`
--
ALTER TABLE `prepisani_lekovi`
ADD PRIMARY KEY (`RECEPT_ID`,`KOMPANIJA_ID`,`SIFRA`),
ADD KEY `FK_RELATIONSHIP_5` (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `prodaja_lekova`
--
ALTER TABLE `prodaja_lekova`
ADD PRIMARY KEY (`APOTEKA_ID`,`KOMPANIJA_ID`,`SIFRA`),
ADD KEY `FK_RELATIONSHIP_8` (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
ADD PRIMARY KEY (`RADNIK_ID`);

--
-- Indexes for table `recept`
--
ALTER TABLE `recept`
ADD PRIMARY KEY (`RECEPT_ID`),
ADD KEY `FK_RELATIONSHIP_2` (`DOKTOR_ID`),
ADD KEY `FK_RELATIONSHIP_3` (`PACIJENT_ID`);

--
-- Indexes for table `ugovor`
--
ALTER TABLE `ugovor`
ADD PRIMARY KEY (`UGOVOR_ID`),
ADD KEY `FK_RELATIONSHIP_15` (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_16` (`KOMPANIJA_ID`);

--
-- Indexes for table `zamene`
--
ALTER TABLE `zamene`
ADD KEY `FK_RELATIONSHIP_6` (`KOMPANIJA_ID`,`LEK_SIFRA`),
ADD KEY `FK_RELATIONSHIP_7` (`LEK_KOMPANIJA_ID`,`SIFRA`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `farmaceut`
--
ALTER TABLE `farmaceut`
ADD CONSTRAINT `FK_INHERITANCE_1` FOREIGN KEY (`RADNIK_ID`) REFERENCES `radnik` (`RADNIK_ID`) ON DELETE CASCADE;

--
-- Constraints for table `istorija_zaposlenja`
--
ALTER TABLE `istorija_zaposlenja`
ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`RADNIK_ID`) REFERENCES `farmaceut` (`RADNIK_ID`);

--
-- Constraints for table `komercijalista`
--
ALTER TABLE `komercijalista`
ADD CONSTRAINT `FK_INHERITANCE_2` FOREIGN KEY (`RADNIK_ID`) REFERENCES `radnik` (`RADNIK_ID`) ON DELETE CASCADE;

--
-- Constraints for table `lek`
--
ALTER TABLE `lek`
ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`KOMPANIJA_ID`) REFERENCES `farmaceutska_kompanija` (`KOMPANIJA_ID`) ON DELETE CASCADE;

--
-- Constraints for table `pacijent`
--
ALTER TABLE `pacijent`
ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`DOKTOR_ID`) REFERENCES `doktor` (`DOKTOR_ID`) ON DELETE SET NULL;

--
-- Constraints for table `prepisani_lekovi`
--
ALTER TABLE `prepisani_lekovi`
ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`RECEPT_ID`) REFERENCES `recept` (`RECEPT_ID`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`) ON DELETE CASCADE;

--
-- Constraints for table `prodaja_lekova`
--
ALTER TABLE `prodaja_lekova`
ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`) ON DELETE CASCADE;

--
-- Constraints for table `recept`
--
ALTER TABLE `recept`
ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`DOKTOR_ID`) REFERENCES `doktor` (`DOKTOR_ID`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`PACIJENT_ID`) REFERENCES `pacijent` (`PACIJENT_ID`) ON DELETE CASCADE;

--
-- Constraints for table `ugovor`
--
ALTER TABLE `ugovor`
ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`RADNIK_ID`) REFERENCES `komercijalista` (`RADNIK_ID`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`KOMPANIJA_ID`) REFERENCES `farmaceutska_kompanija` (`KOMPANIJA_ID`) ON DELETE CASCADE;

--
-- Constraints for table `zamene`
--
ALTER TABLE `zamene`
ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`KOMPANIJA_ID`,`LEK_SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`LEK_KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`) ON DELETE CASCADE;


INSERT INTO `apoteka` (`APOTEKA_ID`, `IME`, `ADRESA`, `TELEFON`) VALUES
(1, 'Lili', 'Kraljice Marije 15', '+381603562585'),
(2, 'Neko ime', 'Kraljice Marije 15', '+381603562585'),
(3, 'Apoteka Lek', 'Bulevar Oslobodjenja 44', '+3816234567');

-- --------------------------------------------------------

--
-- Table structure for table `doktor`
--

CREATE TABLE `doktor` (
`DOKTOR_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`SPECIJALNOST` varchar(255) DEFAULT NULL,
`GODINE_ISKUSTVA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doktor`
--

INSERT INTO `doktor` (`DOKTOR_ID`, `IME`, `PREZIME`, `JMBG`, `SPECIJALNOST`, `GODINE_ISKUSTVA`) VALUES
(1, 'Nikola', 'Markovic', '1506971710256', 'pedijatar', 10),
(2, 'Verica', 'Acimovic', '1506971710256', 'pedijatar', 20),
(3, 'Stefan', 'Velimirovic', '1506971710256', 'hirurg', 15),
(4, 'Nikola', 'Stankovic', '1506971710256', 'oftamolog', 7),
(5, 'Marijana', 'Vasic', '1506971710256', 'pedijatar', 12),
(6, 'Nada', 'Spasic', '1506971710256', 'kardiolog', 10),
(7, 'Jarmila', 'Perunovic', '4567823', 'pedijatar', 7);

-- --------------------------------------------------------

--
-- Table structure for table `farmaceut`
--

CREATE TABLE `farmaceut` (
`RADNIK_ID` int(11) NOT NULL,
`APOTEKA_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL,
`STRUCNA_SPREMA` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmaceut`
--

INSERT INTO `farmaceut` (`RADNIK_ID`, `APOTEKA_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `STRUCNA_SPREMA`) VALUES
(1, 1, 'Nemanja', 'Vasic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar'),
(2, 1, 'Natasa', 'Ninkovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar'),
(3, 2, 'Natalija', 'Stevanovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585', 'farmaceutski tehnicar');

-- --------------------------------------------------------

--
-- Table structure for table `farmaceutska_kompanija`
--

CREATE TABLE `farmaceutska_kompanija` (
`KOMPANIJA_ID` char(10) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farmaceutska_kompanija`
--

INSERT INTO `farmaceutska_kompanija` (`KOMPANIJA_ID`, `IME`, `TELEFON`) VALUES
('1', 'galenika', '+381603562585'),
('2', 'hemoharm', '+381603562585'),
('3', 'pharmanova', '+381603562585'),
('4', 'zorka pharma', '+381603562585');

-- --------------------------------------------------------

--
-- Table structure for table `istorija_zaposlenja`
--

CREATE TABLE `istorija_zaposlenja` (
`APOTEKA_ID` int(11) NOT NULL,
`RADNIK_ID` int(11) NOT NULL,
`MESECI` int(11) DEFAULT NULL,
`DANI` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `istorija_zaposlenja`
--

INSERT INTO `istorija_zaposlenja` (`APOTEKA_ID`, `RADNIK_ID`, `MESECI`, `DANI`) VALUES
(2, 2, 15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `komercijalista`
--

CREATE TABLE `komercijalista` (
`RADNIK_ID` int(11) NOT NULL,
`APOTEKA_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `komercijalista`
--

INSERT INTO `komercijalista` (`RADNIK_ID`, `APOTEKA_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`) VALUES
(2, 1, 'Slavica', 'Djankovic', '1677894', 'Milutina Milankovica 15', '+38164555234'),
(3, 2, 'Svetozar', 'Zoranovic', '3456788', 'Kneginje Zorke 77', '+381627345'),
(4, 1, 'Nemanja', 'Damjanovic', '1706971710246', 'Milutina Milankovica 4', '+381603562585'),
(5, 1, 'Marija', 'Stankovic', '1706971710246', 'Milutina Milankovica 4', '+381603562585'),
(6, 2, 'Nikola', 'Milosevic', '1706971710246', 'Milutina Milankovica 4', '+381603562585');

-- --------------------------------------------------------

--
-- Table structure for table `lek`
--

CREATE TABLE `lek` (
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lek`
--

INSERT INTO `lek` (`KOMPANIJA_ID`, `SIFRA`, `IME`) VALUES
('1', 256, 'amikacin'),
('1', 257, 'gentamicin'),
('1', 259, 'sintopozid'),
('1', 260, 'holoksan'),
('1', 262, 'sinoksal'),
('1', 263, 'avastin'),
('1', 264, 'dolamin'),
('2', 255, 'ampicilin'),
('2', 266, 'sinicilin'),
('2', 267, 'palitreks'),
('2', 269, 'neko ime sa dol'),
('3', 258, 'merocid'),
('3', 261, 'kasplatin'),
('3', 265, 'sinopen'),
('4', 268, 'amokcicilin');

-- --------------------------------------------------------

--
-- Table structure for table `pacijent`
--

CREATE TABLE `pacijent` (
`PACIJENT_ID` int(11) NOT NULL,
`DOKTOR_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`DATUM_RODJENJA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pacijent`
--

INSERT INTO `pacijent` (`PACIJENT_ID`, `DOKTOR_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `DATUM_RODJENJA`) VALUES
(1, 2, 'Jovana', 'Stanimirovic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(2, 2, 'Natasa', 'Maric', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(3, 1, 'Suzana', 'Tomovic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(4, 1, 'Nikola', 'Tankosic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(5, 4, 'Marko', 'Milivojevic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(6, 6, 'Snezana', 'Taskovic', '1706971710246', 'Milosa Pocerca 15', '1997-12-15'),
(7, 2, 'Marko', 'Prodanovic', '7653324567788', 'Cara Dusana 84', '1991-10-08'),
(8, 5, 'Slavis', 'Simikic', '6666666', 'Bulevar Oslobodjenja 5', '1992-03-03'),
(9, 5, 'Jovandeka', 'Radic', '7777', 'Prvomajska 5', '1992-02-06'),
(10, 5, 'Srdjan', 'Stevanovic', '98765', 'Branka Copica 2', '1994-01-10'),
(11, 5, 'Goran', 'Dimitrijevic', '44567', 'Branka Copica 1', '1993-10-10'),
(12, 5, 'Ljuba', 'Kretenovic', '55553', 'Nikole Tesle 13', '1993-10-10'),
(13, 5, 'Slavica', 'Stevic', '67234', 'Nikole Tesle 33', '1993-11-11'),
(14, 5, 'Jelena', 'Karleusa', '890324', 'Bulevar Oslobodjenja bb', '1977-01-11'),
(15, 5, 'Svetlana', 'Raznatovic', '673445', 'Bulevar Oslobodjenja 12', '1974-01-12'),
(16, 5, 'Svetlana', 'Beric', '1678934422', 'Bulevar Oslobodjenja 18', '1970-01-12'),
(17, 5, 'Zorica', 'Zoric', '1678934422', 'Bulevar Oslobodjenja 11', '1990-01-12'),
(18, 5, 'Zorica', 'Markovic', '65433678', 'Bulevar Oslobodjenja 23', '1993-01-12');

-- --------------------------------------------------------

--
-- Table structure for table `prepisani_lekovi`
--

CREATE TABLE `prepisani_lekovi` (
`RECEPT_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`KOLICINA` int(11) DEFAULT NULL,
`TRAJANJE_TERAPIJE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prepisani_lekovi`
--

INSERT INTO `prepisani_lekovi` (`RECEPT_ID`, `KOMPANIJA_ID`, `SIFRA`, `KOLICINA`, `TRAJANJE_TERAPIJE`) VALUES
(1, '1', 257, 2, 14),
(1, '1', 264, 5, 15),
(2, '1', 257, 7, 10),
(18, '1', 263, 16, 16);

-- --------------------------------------------------------

--
-- Table structure for table `prodaja_lekova`
--

CREATE TABLE `prodaja_lekova` (
`APOTEKA_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`SIFRA` int(11) NOT NULL,
`CENA` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prodaja_lekova`
--

INSERT INTO `prodaja_lekova` (`APOTEKA_ID`, `KOMPANIJA_ID`, `SIFRA`, `CENA`) VALUES
(1, '2', 255, 700),
(1, '2', 269, 500),
(2, '1', 259, 700),
(2, '1', 262, 700),
(2, '2', 255, 700);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

CREATE TABLE `radnik` (
`RADNIK_ID` int(11) NOT NULL,
`IME` varchar(255) DEFAULT NULL,
`PREZIME` varchar(255) DEFAULT NULL,
`JMBG` varchar(13) DEFAULT NULL,
`ADRESA` varchar(255) DEFAULT NULL,
`TELEFON` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`RADNIK_ID`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`) VALUES
(1, 'Nemanja', 'Vasic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(2, 'Natasa', 'Ninkovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(3, 'Natalija', 'Stevanovic', '1506971710245', 'Milutina Milankovica 4', '+381603562585'),
(4, 'Nemanja', 'Damjanovic', '1706971710246', 'Cvijiceva 112', '+381603562585'),
(5, 'Marija', 'Stankovic', '1706971710246', 'Cvijiceva 112', '+381603562585'),
(6, 'Nikola', 'Milosevic', '1706971710246', 'Cvijiceva 112', '+381603562585');

-- --------------------------------------------------------

--
-- Table structure for table `recept`
--

CREATE TABLE `recept` (
`RECEPT_ID` int(11) NOT NULL,
`PACIJENT_ID` int(11) NOT NULL,
`DOKTOR_ID` int(11) NOT NULL,
`DATUM` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recept`
--

INSERT INTO `recept` (`RECEPT_ID`, `PACIJENT_ID`, `DOKTOR_ID`, `DATUM`) VALUES
(1, 1, 2, '2017-01-02'),
(2, 3, 5, '2016-10-22'),
(3, 8, 5, '2016-01-01'),
(4, 9, 5, '2016-01-02'),
(5, 10, 5, '2016-01-03'),
(6, 11, 5, '2016-01-03'),
(7, 12, 5, '2016-01-04'),
(8, 13, 5, '2016-01-05'),
(9, 14, 5, '2016-01-06'),
(10, 15, 5, '2016-01-07'),
(11, 16, 5, '2016-02-07'),
(12, 17, 5, '2016-02-10'),
(13, 18, 5, '2016-02-15'),
(14, 10, 2, '2016-02-09'),
(15, 2, 2, '2017-08-19'),
(16, 8, 5, '2017-09-18'),
(17, 3, 1, '2017-10-11'),
(18, 7, 2, '2017-10-11');

-- --------------------------------------------------------

--
-- Table structure for table `ugovor`
--

CREATE TABLE `ugovor` (
`UGOVOR_ID` int(11) NOT NULL,
`KOMPANIJA_ID` char(10) NOT NULL,
`RADNIK_ID` int(11) NOT NULL,
`DATUM_SKLAPANJA` date DEFAULT NULL,
`DATUM_ISTEKA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ugovor`
--

INSERT INTO `ugovor` (`UGOVOR_ID`, `KOMPANIJA_ID`, `RADNIK_ID`, `DATUM_SKLAPANJA`, `DATUM_ISTEKA`) VALUES
(2, '1', 4, '2007-01-01', '2027-01-01'),
(3, '1', 5, '2005-07-05', '2027-07-05'),
(4, '2', 6, '2010-04-25', '2020-04-25');

-- --------------------------------------------------------

--
-- Table structure for table `zamene`
--

CREATE TABLE `zamene` (
`LEK_KOMPANIJA_ID` char(10) DEFAULT NULL,
`SIFRA` int(11) DEFAULT NULL,
`KOMPANIJA_ID` char(10) DEFAULT NULL,
`LEK_SIFRA` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `apoteka`
--
ALTER TABLE `apoteka`
ADD PRIMARY KEY (`APOTEKA_ID`);

--
-- Indexes for table `doktor`
--
ALTER TABLE `doktor`
ADD PRIMARY KEY (`DOKTOR_ID`);

--
-- Indexes for table `farmaceut`
--
ALTER TABLE `farmaceut`
ADD PRIMARY KEY (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_11` (`APOTEKA_ID`);

--
-- Indexes for table `farmaceutska_kompanija`
--
ALTER TABLE `farmaceutska_kompanija`
ADD PRIMARY KEY (`KOMPANIJA_ID`);

--
-- Indexes for table `istorija_zaposlenja`
--
ALTER TABLE `istorija_zaposlenja`
ADD PRIMARY KEY (`APOTEKA_ID`,`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_14` (`RADNIK_ID`);

--
-- Indexes for table `komercijalista`
--
ALTER TABLE `komercijalista`
ADD PRIMARY KEY (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_12` (`APOTEKA_ID`);

--
-- Indexes for table `lek`
--
ALTER TABLE `lek`
ADD PRIMARY KEY (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `pacijent`
--
ALTER TABLE `pacijent`
ADD PRIMARY KEY (`PACIJENT_ID`),
ADD KEY `FK_RELATIONSHIP_1` (`DOKTOR_ID`);

--
-- Indexes for table `prepisani_lekovi`
--
ALTER TABLE `prepisani_lekovi`
ADD PRIMARY KEY (`RECEPT_ID`,`KOMPANIJA_ID`,`SIFRA`),
ADD KEY `FK_RELATIONSHIP_5` (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `prodaja_lekova`
--
ALTER TABLE `prodaja_lekova`
ADD PRIMARY KEY (`APOTEKA_ID`,`KOMPANIJA_ID`,`SIFRA`),
ADD KEY `FK_RELATIONSHIP_8` (`KOMPANIJA_ID`,`SIFRA`);

--
-- Indexes for table `radnik`
--
ALTER TABLE `radnik`
ADD PRIMARY KEY (`RADNIK_ID`);

--
-- Indexes for table `recept`
--
ALTER TABLE `recept`
ADD PRIMARY KEY (`RECEPT_ID`),
ADD KEY `FK_RELATIONSHIP_2` (`DOKTOR_ID`),
ADD KEY `FK_RELATIONSHIP_3` (`PACIJENT_ID`);

--
-- Indexes for table `ugovor`
--
ALTER TABLE `ugovor`
ADD PRIMARY KEY (`UGOVOR_ID`),
ADD KEY `FK_RELATIONSHIP_15` (`RADNIK_ID`),
ADD KEY `FK_RELATIONSHIP_16` (`KOMPANIJA_ID`);

--
-- Indexes for table `zamene`
--
ALTER TABLE `zamene`
ADD KEY `FK_RELATIONSHIP_6` (`KOMPANIJA_ID`,`LEK_SIFRA`),
ADD KEY `FK_RELATIONSHIP_7` (`LEK_KOMPANIJA_ID`,`SIFRA`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `farmaceut`
--
ALTER TABLE `farmaceut`
ADD CONSTRAINT `FK_INHERITANCE_1` FOREIGN KEY (`RADNIK_ID`) REFERENCES `radnik` (`RADNIK_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_11` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`);

--
-- Constraints for table `istorija_zaposlenja`
--
ALTER TABLE `istorija_zaposlenja`
ADD CONSTRAINT `FK_RELATIONSHIP_13` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_14` FOREIGN KEY (`RADNIK_ID`) REFERENCES `farmaceut` (`RADNIK_ID`);

--
-- Constraints for table `komercijalista`
--
ALTER TABLE `komercijalista`
ADD CONSTRAINT `FK_INHERITANCE_2` FOREIGN KEY (`RADNIK_ID`) REFERENCES `radnik` (`RADNIK_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_12` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`);

--
-- Constraints for table `lek`
--
ALTER TABLE `lek`
ADD CONSTRAINT `FK_RELATIONSHIP_10` FOREIGN KEY (`KOMPANIJA_ID`) REFERENCES `farmaceutska_kompanija` (`KOMPANIJA_ID`);

--
-- Constraints for table `pacijent`
--
ALTER TABLE `pacijent`
ADD CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`DOKTOR_ID`) REFERENCES `doktor` (`DOKTOR_ID`);

--
-- Constraints for table `prepisani_lekovi`
--
ALTER TABLE `prepisani_lekovi`
ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`RECEPT_ID`) REFERENCES `recept` (`RECEPT_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_5` FOREIGN KEY (`KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`);

--
-- Constraints for table `prodaja_lekova`
--
ALTER TABLE `prodaja_lekova`
ADD CONSTRAINT `FK_RELATIONSHIP_8` FOREIGN KEY (`KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`),
ADD CONSTRAINT `FK_RELATIONSHIP_9` FOREIGN KEY (`APOTEKA_ID`) REFERENCES `apoteka` (`APOTEKA_ID`);

--
-- Constraints for table `recept`
--
ALTER TABLE `recept`
ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`DOKTOR_ID`) REFERENCES `doktor` (`DOKTOR_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`PACIJENT_ID`) REFERENCES `pacijent` (`PACIJENT_ID`);

--
-- Constraints for table `ugovor`
--
ALTER TABLE `ugovor`
ADD CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`RADNIK_ID`) REFERENCES `komercijalista` (`RADNIK_ID`),
ADD CONSTRAINT `FK_RELATIONSHIP_16` FOREIGN KEY (`KOMPANIJA_ID`) REFERENCES `farmaceutska_kompanija` (`KOMPANIJA_ID`);

--
-- Constraints for table `zamene`
--
ALTER TABLE `zamene`
ADD CONSTRAINT `FK_RELATIONSHIP_6` FOREIGN KEY (`KOMPANIJA_ID`,`LEK_SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`),
ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`LEK_KOMPANIJA_ID`,`SIFRA`) REFERENCES `lek` (`KOMPANIJA_ID`, `SIFRA`);
