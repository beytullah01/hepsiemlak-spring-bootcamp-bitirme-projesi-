-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 24 Mar 2022, 11:27:13
-- Sunucu sürümü: 5.7.31
-- PHP Sürümü: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `adverts`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adverts`
--

DROP TABLE IF EXISTS `adverts`;
CREATE TABLE IF NOT EXISTS `adverts` (
  `advert_id` int(11) NOT NULL,
  `advert_no` int(11) NOT NULL,
  `baslik` varchar(255) DEFAULT NULL,
  `fiyat` decimal(19,2) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `suresi` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`advert_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `adverts`
--

INSERT INTO `adverts` (`advert_id`, `advert_no`, `baslik`, `fiyat`, `status`, `suresi`, `user_id`) VALUES
(14, 38164785, 'hemen satAD?l?k', '355900.00', 'ACTIVE', 9, 8),
(15, 38164785, 'hemen satAD?l?k', '355900.00', 'ACTIVE', 9, 8),
(16, 38164786, 'hemen satAD?l?k', '355900.00', 'ACTIVE', 9, 8),
(17, 38164787, 'hemen satAD?l?k', '355900.00', 'ACTIVE', 9, 8),
(18, 38164785, 'hemen sat?l?k acillll', '355900.00', 'ACTIVE', 9, 1),
(19, 38164786, 'hemen sat?l?k acillll', '355900.00', 'ACTIVE', 9, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(20);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
