-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-02-2021 a las 07:45:58
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_konoha`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hokages`
--

CREATE TABLE `hokages` (
  `id` int(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hokages`
--

INSERT INTO `hokages` (`id`, `username`, `pass`) VALUES
(1, 'HashiramaSenju', 'admin1234'),
(2, 'TobiramaSenju', 'admin1234'),
(3, 'SarutobiHiruzen', 'admin1234'),
(4, 'MinatoNamikaze', 'admin1234'),
(5, 'TsunadeSenju', 'admin1234'),
(6, 'KakashiHatake', 'admin1234'),
(7, 'NarutoUzumaky', 'admin1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `misiones`
--

CREATE TABLE `misiones` (
  `id` int(20) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `dificultad` varchar(50) NOT NULL,
  `shinobi` varchar(50) NOT NULL,
  `rango` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `resultado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `misiones`
--

INSERT INTO `misiones` (`id`, `descripcion`, `dificultad`, `shinobi`, `rango`, `estado`, `resultado`) VALUES
(1, 'llevar pergamino a la aldea de la roca', 's', 'Kakashi', 'jounin', 'finalizado', 'exito'),
(2, 'Descubrir el esconfite de otsosuky', 's', 'sasuske', 'jounin', 'finalizado', 'fracaso'),
(3, 'prueba', 'prueba', 'prueba', 'prueba', 'finalizado', 'exito'),
(4, 'q', 'q', 'q', 'q', 'finalizado', 'fracaso'),
(5, 'w', 'w', 'w', 'w', 'finalizado', 'exito'),
(29, 'prueba', 'prueba', 'prueba', 'prueba', 'prueba', 'a'),
(30, 'prueba', 'prueba', 'shikmaru', 'jounin', 'finalizado', 'exito'),
(31, 'prueba', 'b', 'shikadai', 'gennin', 'finalizado', 'fracaso'),
(32, 'prueba', 'prueba', 'Yamato', 'ambu', 'finalizado', 'fracaso'),
(33, 'matar a hidan', 's', 'shikmaru', 'jounin', 'finalizado', 'exito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `shinobis`
--

CREATE TABLE `shinobis` (
  `id` int(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `clan` varchar(50) NOT NULL,
  `rango` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `misioncompletada` int(100) NOT NULL,
  `misionfallida` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `shinobis`
--

INSERT INTO `shinobis` (`id`, `nombre`, `clan`, `rango`, `estado`, `misioncompletada`, `misionfallida`) VALUES
(1, 'itachi', 'uchiha', 'ambu', 'Activo', 0, 0),
(2, 'sasuske', 'uchiha', 'jounin', 'Activo', 2, 1),
(3, 'hinata', 'hyuga', 'jounin', 'Activo', 1, 0),
(4, 'boruto', 'uzumaky', 'genin', 'Activo', 0, 0),
(5, 'shikmaru', 'nara', 'jounin', 'Activo', 2, 0),
(6, 'shikadai', 'nara', 'gennin', 'inactivo', 1, 1),
(8, 'Metal', 'Lee', 'genin', 'inactivo', 1, 2),
(12, 'Mitsuki', 'Orochimaru', 'genin', 'inactivo', 1, 3),
(14, 'Rock', 'Lee', 'Jounin', 'inactivo', 7, 1),
(15, 'Yamato', '--', 'ambu', 'Activo', 7, 2),
(16, 'obito', 'uchiha', 'Jounin', 'inactivo', 0, 0),
(17, 'prueba', 'prueba', 'prueba', 'prueba', 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `hokages`
--
ALTER TABLE `hokages`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `misiones`
--
ALTER TABLE `misiones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `shinobis`
--
ALTER TABLE `shinobis`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `hokages`
--
ALTER TABLE `hokages`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `misiones`
--
ALTER TABLE `misiones`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `shinobis`
--
ALTER TABLE `shinobis`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
