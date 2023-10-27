-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-10-2023 a las 04:37:21
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `granhotel80s`
--
CREATE DATABASE IF NOT EXISTS `granhotel80s` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `granhotel80s`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `idTipoHabitacion` int(11) NOT NULL,
  `categoria` varchar(60) NOT NULL,
  `Piso` int(11) NOT NULL,
  `nroHabitacion` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `idTipoHabitacion`, `categoria`, `Piso`, `nroHabitacion`, `estado`) VALUES
(1, 1, 'StdSimple', 0, 1, 1),
(2, 1, 'StdSimple', 0, 2, 1),
(3, 1, 'StdSimple', 0, 3, 1),
(4, 1, 'StdSimple', 0, 4, 1),
(5, 1, 'StdSimple', 0, 5, 1),
(6, 1, 'StdSimple', 0, 6, 1),
(7, 1, 'StdSimple', 0, 7, 1),
(8, 1, 'StdSimple', 0, 8, 1),
(9, 1, 'StdSimple', 0, 9, 1),
(10, 1, 'StdSimple', 0, 10, 1),
(11, 2, 'StdSimple', 0, 28, 1),
(12, 2, 'StdSimple', 0, 29, 1),
(13, 2, 'StdSimple', 0, 30, 1),
(14, 2, 'StdSimple', 0, 31, 1),
(15, 2, 'StdSimple', 0, 32, 1),
(16, 2, 'StdSimple', 0, 33, 1),
(17, 2, 'StdSimple', 0, 34, 1),
(18, 2, 'StdSimple', 0, 35, 1),
(19, 2, 'StdSimple', 0, 36, 1),
(20, 2, 'StdSimple', 0, 37, 1),
(21, 3, 'StdDoble', 1, 101, 1),
(22, 3, 'StdDoble', 1, 102, 1),
(23, 3, 'StdDoble', 1, 103, 1),
(24, 3, 'StdDoble', 1, 104, 1),
(25, 3, 'StdDoble', 1, 105, 1),
(26, 3, 'StdDoble', 1, 106, 1),
(27, 3, 'StdDoble', 1, 107, 1),
(28, 3, 'StdDoble', 1, 108, 1),
(29, 3, 'StdDoble', 1, 109, 1),
(30, 3, 'StdDoble', 1, 110, 1),
(31, 4, 'StdDoble', 1, 127, 1),
(32, 4, 'StdDoble', 1, 128, 1),
(33, 4, 'StdDoble', 1, 129, 1),
(34, 4, 'StdDoble', 1, 130, 1),
(35, 4, 'StdDoble', 1, 131, 1),
(36, 4, 'StdDoble', 1, 132, 1),
(37, 4, 'StdDoble', 1, 133, 1),
(38, 4, 'StdDoble', 1, 134, 1),
(39, 4, 'StdDoble', 1, 135, 1),
(40, 4, 'StdDoble', 1, 136, 1),
(41, 5, 'StdTriple', 2, 201, 1),
(42, 5, 'StdTriple', 2, 202, 1),
(43, 5, 'StdTriple', 2, 203, 1),
(44, 5, 'StdTriple', 2, 204, 1),
(45, 5, 'StdTriple', 2, 205, 1),
(46, 5, 'StdTriple', 2, 206, 1),
(47, 5, 'StdTriple', 2, 207, 1),
(48, 5, 'StdTriple', 2, 208, 1),
(49, 5, 'StdTriple', 2, 209, 1),
(50, 5, 'StdTriple', 2, 210, 1),
(51, 6, 'StdTriple', 2, 227, 1),
(52, 6, 'StdTriple', 2, 228, 1),
(53, 6, 'StdTriple', 2, 229, 1),
(54, 6, 'StdTriple', 2, 230, 1),
(55, 6, 'StdTriple', 2, 231, 1),
(56, 6, 'StdTriple', 2, 232, 1),
(57, 6, 'StdTriple', 2, 233, 1),
(58, 6, 'StdTriple', 2, 234, 1),
(59, 6, 'StdTriple', 2, 235, 1),
(60, 6, 'StdTriple', 2, 236, 1),
(61, 7, 'Suite Lujo', 3, 301, 1),
(62, 7, 'Suite Lujo', 3, 302, 1),
(63, 7, 'Suite Lujo', 3, 303, 1),
(64, 7, 'Suite Lujo', 3, 304, 1),
(65, 7, 'Suite Lujo', 3, 305, 1),
(66, 8, 'Suite Lujo', 3, 315, 1),
(67, 8, 'Suite Lujo', 3, 316, 1),
(68, 8, 'Suite Lujo', 3, 317, 1),
(69, 8, 'Suite Lujo', 3, 318, 1),
(70, 8, 'Suite Lujo', 3, 319, 1),
(71, 9, 'Suite Lujo', 3, 329, 1),
(72, 9, 'Suite Lujo', 3, 330, 1),
(73, 9, 'Suite Lujo', 3, 330, 1),
(74, 9, 'Suite Lujo', 3, 331, 1),
(75, 9, 'Suite Lujo', 3, 332, 1),
(76, 9, 'Suite Lujo', 3, 333, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huesped`
--

DROP TABLE IF EXISTS `huesped`;
CREATE TABLE `huesped` (
  `idHuesped` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `domicilio` varchar(60) NOT NULL,
  `telefono` varchar(16) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `huesped`
--

INSERT INTO `huesped` (`idHuesped`, `dni`, `nombre`, `apellido`, `correo`, `domicilio`, `telefono`, `estado`) VALUES
(1, 12345678, 'Juan', 'Ibarra', 'juanibarra@gmail.com', 'Av. Mitre 100', '3456567897', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idReserva` int(11) NOT NULL,
  `idHuesped` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `cantPersonas` int(11) NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipohabitacion`
--

DROP TABLE IF EXISTS `tipohabitacion`;
CREATE TABLE `tipohabitacion` (
  `idTipoHabitacion` int(11) NOT NULL,
  `codigo` varchar(30) NOT NULL,
  `cantMaxPersonas` int(11) NOT NULL,
  `CantCamas` int(11) NOT NULL,
  `TipoDeCamas` varchar(30) NOT NULL,
  `Precio` double NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipohabitacion`
--

INSERT INTO `tipohabitacion` (`idTipoHabitacion`, `codigo`, `cantMaxPersonas`, `CantCamas`, `TipoDeCamas`, `Precio`, `estado`) VALUES
(1, 'ES1S', 1, 1, 'SIMPLE', 8500, 1),
(2, 'ES1Q', 2, 1, 'QUEEN', 9000, 1),
(3, 'ED2S', 2, 2, 'SIMPLE', 7850, 1),
(4, 'ED1Q1S', 3, 2, 'QUEEN-SIMPLE', 9500, 1),
(5, 'ET3S', 3, 3, 'SIMPLE', 8900, 1),
(6, 'ET1Q2S', 4, 3, 'QUEEN-SIMPLE', 9850, 1),
(7, 'SL1Q', 2, 1, 'KING SIZE', 11300, 1),
(8, 'SL1Q2S', 4, 3, 'KING SIZE-SIMPLE', 12400, 1),
(9, 'SL1Q3S', 5, 4, 'KING SIZE-SIMPLE', 15000, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD KEY `idTipoHabitacion` (`idTipoHabitacion`);

--
-- Indices de la tabla `huesped`
--
ALTER TABLE `huesped`
  ADD PRIMARY KEY (`idHuesped`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idReserva`),
  ADD KEY `idHuesped` (`idHuesped`),
  ADD KEY `idHabitacion` (`idHabitacion`);

--
-- Indices de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  ADD PRIMARY KEY (`idTipoHabitacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT de la tabla `huesped`
--
ALTER TABLE `huesped`
  MODIFY `idHuesped` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idReserva` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipohabitacion`
--
ALTER TABLE `tipohabitacion`
  MODIFY `idTipoHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=203;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`idTipoHabitacion`) REFERENCES `tipohabitacion` (`idTipoHabitacion`);

--
-- Filtros para la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`idHuesped`) REFERENCES `huesped` (`idHuesped`),
  ADD CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
