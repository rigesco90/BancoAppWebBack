-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-09-2019 a las 04:34:38
-- Versión del servidor: 5.7.26
-- Versión de PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `banco`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asesor`
--

DROP TABLE IF EXISTS `asesor`;
CREATE TABLE IF NOT EXISTS `asesor` (
  `idasesor` int(11) NOT NULL AUTO_INCREMENT,
  `especialidad_idespecialidad` int(11) NOT NULL,
  `persona_identificacion` int(11) NOT NULL,
  PRIMARY KEY (`idasesor`),
  KEY `fk_asesor_especialidad1_idx` (`especialidad_idespecialidad`),
  KEY `fk_asesor_persona1_idx` (`persona_identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `persona_identificacion` int(11) NOT NULL,
  PRIMARY KEY (`idcliente`),
  KEY `fk_cliente_persona1_idx` (`persona_identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `persona_identificacion`) VALUES
(1, 34322036),
(11, 34322300),
(8, 234567651),
(4, 1059237859),
(2, 1063810506),
(7, 1098765443),
(5, 1234567654);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumo`
--

DROP TABLE IF EXISTS `consumo`;
CREATE TABLE IF NOT EXISTS `consumo` (
  `idconsumo` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_consumo` datetime(6) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `monto` decimal(10,0) NOT NULL,
  `tarjeta_numero_tarjeta` varchar(20) NOT NULL,
  PRIMARY KEY (`idconsumo`),
  KEY `fk_consumo_tarjeta1_idx` (`tarjeta_numero_tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `consumo`
--

INSERT INTO `consumo` (`idconsumo`, `fecha_consumo`, `descripcion`, `monto`, `tarjeta_numero_tarjeta`) VALUES
(1, '2019-09-07 00:00:00.000000', 'PAGO EXITO MAYORCA', '2000000', '1234432156788765');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE IF NOT EXISTS `especialidad` (
  `idespecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`idespecialidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `identificacion` int(11) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`identificacion`, `nombres`, `apellidos`, `direccion`, `ciudad`, `telefono`) VALUES
(34322036, 'CLAUDIA XIMENA', 'BEDOYA CONSTAIN', 'Cl 57 S # 43a - 23', 'SABANETA', '3008645240'),
(34322300, 'MERY', 'ORDOÑEZ', 'LA ESMERALDA', 'POPAYAN', '315643218'),
(234567651, 'DIANA CAROLINA', 'PAZ', 'CL 4 # 12 - 23', 'POPAYAN', '3212333212'),
(1059237859, 'SANTIAGO', 'MUÑOZ BEDOYA', 'VIRGEN DEL CARMEN', 'SABANETA', '30132121234'),
(1063810506, 'RIGO ESLEIDER', 'CAMPO ORDOÑEZ', 'CL 57S # 43A - 23', 'SABANETA', '3012180172'),
(1098765443, 'MARICEL', 'CAMPO ORDOÑEZ', 'VD NARANJAL', 'TIMBIO', '3210987654'),
(1234567654, 'DAVID SANTIAGO', 'CAMPO ORDOÑEZ', 'VD NARANJAL', 'TIMBIO', '3146227546');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
CREATE TABLE IF NOT EXISTS `tarjeta` (
  `numero_tarjeta` varchar(20) NOT NULL,
  `ccv` int(11) NOT NULL,
  `tipo_tarjeta` varchar(50) NOT NULL,
  `cliente_idcliente` int(11) NOT NULL,
  PRIMARY KEY (`numero_tarjeta`),
  KEY `fk_tarjeta_cliente1_idx` (`cliente_idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`numero_tarjeta`, `ccv`, `tipo_tarjeta`, `cliente_idcliente`) VALUES
('1234432156788765', 1234, 'DEBITO', 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asesor`
--
ALTER TABLE `asesor`
  ADD CONSTRAINT `fk_asesor_especialidad1` FOREIGN KEY (`especialidad_idespecialidad`) REFERENCES `especialidad` (`idespecialidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_asesor_persona1` FOREIGN KEY (`persona_identificacion`) REFERENCES `persona` (`identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_persona1` FOREIGN KEY (`persona_identificacion`) REFERENCES `persona` (`identificacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `consumo`
--
ALTER TABLE `consumo`
  ADD CONSTRAINT `fk_consumo_tarjeta1` FOREIGN KEY (`tarjeta_numero_tarjeta`) REFERENCES `tarjeta` (`numero_tarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `fk_tarjeta_cliente1` FOREIGN KEY (`cliente_idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
