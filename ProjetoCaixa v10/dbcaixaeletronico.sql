-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 13-Jun-2019 às 06:42
-- Versão do servidor: 5.7.26
-- versão do PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbcaixaeletronico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

DROP TABLE IF EXISTS `conta`;
CREATE TABLE IF NOT EXISTS `conta` (
  `id_conta` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `rg` varchar(9) DEFAULT NULL,
  `agencia` int(4) NOT NULL,
  `login` int(11) NOT NULL,
  `senha` int(11) NOT NULL,
  `saldo` float NOT NULL,
  PRIMARY KEY (`id_conta`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`id_conta`, `nome`, `cpf`, `rg`, `agencia`, `login`, `senha`, `saldo`) VALUES
(4, 'Tainah Carrion', '12345677811', '326665333', 1000, 987654, 201293, 20),
(5, 'Jonathan Marchetti', '46472976830', '375683434', 1000, 879542, 201456, 20),
(6, 'Teste', '565556', '2654', 1000, 5658, 123, 353),
(7, 'Teste2', '464852364', '565684', 1000, 1234, 1234, 180),
(11, 'Stefany Petronilho', '46673381809', '375683434', 1000, 1507, 150718, 265);

-- --------------------------------------------------------

--
-- Estrutura da tabela `deposito`
--

DROP TABLE IF EXISTS `deposito`;
CREATE TABLE IF NOT EXISTS `deposito` (
  `id_deposito` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `id_contaFK` int(11) NOT NULL,
  `dataTransacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_deposito`),
  KEY `FK_Conta` (`id_contaFK`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `deposito`
--

INSERT INTO `deposito` (`id_deposito`, `valor`, `id_contaFK`, `dataTransacao`) VALUES
(1, 265, 11, '2019-06-13 06:29:19'),
(2, 353, 6, '2019-06-13 06:39:43');

-- --------------------------------------------------------

--
-- Estrutura da tabela `saque`
--

DROP TABLE IF EXISTS `saque`;
CREATE TABLE IF NOT EXISTS `saque` (
  `id_saque` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `id_contaFK` int(11) NOT NULL,
  `dataTransacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_saque`),
  KEY `id_contaFK` (`id_contaFK`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `saque`
--

INSERT INTO `saque` (`id_saque`, `valor`, `id_contaFK`, `dataTransacao`) VALUES
(1, 3, 6, '2019-06-13 06:24:44'),
(2, 20, 11, '2019-06-13 06:24:44'),
(3, 10, 11, '2019-06-13 06:24:44'),
(4, 153, 6, '2019-06-13 06:25:28');

-- --------------------------------------------------------

--
-- Estrutura da tabela `transferencia`
--

DROP TABLE IF EXISTS `transferencia`;
CREATE TABLE IF NOT EXISTS `transferencia` (
  `id_transferencia` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float NOT NULL,
  `id_contaFK` int(11) NOT NULL,
  `dataTransacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_transferencia`),
  KEY `FK_Conta` (`id_contaFK`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `transferencia`
--

INSERT INTO `transferencia` (`id_transferencia`, `valor`, `id_contaFK`, `dataTransacao`) VALUES
(1, 10, 6, '2019-06-13 06:26:07'),
(2, 5, 6, '2019-06-13 06:26:07'),
(3, 120, 11, '2019-06-13 06:26:07'),
(4, 5, 11, '2019-06-13 06:26:07');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
