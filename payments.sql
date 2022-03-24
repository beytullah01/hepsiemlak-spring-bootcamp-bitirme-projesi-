-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1:3306
-- Üretim Zamanı: 24 Mar 2022, 11:27:29
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
-- Veritabanı: `payments`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE IF NOT EXISTS `payments` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `credit_card` varchar(255) DEFAULT NULL,
  `is_pay` bit(1) DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `payments`
--

INSERT INTO `payments` (`payment_id`, `amount`, `credit_card`, `is_pay`, `order_id`, `product_id`, `user_id`) VALUES
(1, '90000.00', '111111', b'1', 1000, 1, 1),
(2, '90000.00', '111111', b'1', 1000, 1, 1),
(3, '90000.00', '111111', b'1', 1001, 1, 1),
(4, '90000.00', '111111', b'1', 1002, 1, 1),
(5, '90000.00', '111111', b'1', 1003, 1, 2),
(6, '90000.00', '111111', b'1', 1000, 1, 2),
(7, '90000.00', '111111', b'1', 1000, 1, 2),
(8, '90000.00', '111111', b'1', 1000, 1, 2),
(9, '90000.00', '111111', b'1', 1001, 1, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
