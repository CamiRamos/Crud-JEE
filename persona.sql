-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-10-2018 a las 20:14:34
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `persona`
--
CREATE DATABASE IF NOT EXISTS `persona` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `persona`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `documento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `edad` varchar(20) NOT NULL,
  `profesion` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `pass` varchar(50) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`documento`, `nombre`, `edad`, `profesion`, `apellido`, `telefono`, `pass`) VALUES
(20483155, 'Ana Isabel ', '50', 'Ama de casa', 'Rodriguez Martinez', '3506892363', '112233'),
(1005308685, 'Juan Camilo ', '17', 'Estudiante', 'Ramos Rodriguez', '3116178594', '123456'),
(1098311062, 'Wilman Javier', '21', 'Constructor', 'Ramos Rodriguez', '3108990258', '334455');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
