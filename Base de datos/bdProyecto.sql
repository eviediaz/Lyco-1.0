/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.25-MariaDB : Database - bdproyecto
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bdproyecto` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `bdproyecto`;

/*Table structure for table `tipousuario` */

DROP TABLE IF EXISTS `tipousuario`;

CREATE TABLE `tipousuario` (
  `Tipo_usuario` varchar(1) NOT NULL,
  `desc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipousuario` */

insert  into `tipousuario`(`Tipo_usuario`,`desc`) values 
('1','Alumno'),
('2','Profesor');

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id_usuario` char(12) NOT NULL,
  `nombre_usuario` varchar(30) DEFAULT NULL,
  `apellido_usuario` varchar(30) DEFAULT NULL,
  `edad_usuario` int(2) DEFAULT NULL,
  `nombreusuario_usuario` varchar(30) DEFAULT NULL,
  `correo_usuario` varchar(50) DEFAULT NULL,
  `password_usuario` varchar(30) DEFAULT NULL,
  `Tipo_usuario` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `Type` (`Tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `usuario` */

insert  into `usuario`(`id_usuario`,`nombre_usuario`,`apellido_usuario`,`edad_usuario`,`nombreusuario_usuario`,`correo_usuario`,`password_usuario`,`Tipo_usuario`) values 
('001','Paz','Alejos',24,'pazAlejos','dayAlejos@gmail.com','hola1234','1'),
('002','Laura','Begoya',23,'lauBegoya','hola@gmail.com','laura1234','1'),
('003','Javier','Díaz',32,'javierDiaz','javier_diaz@gmail.com','d1i2a3z4','2'),
('004','Juana','Martinez',17,'juanMartinez','hola123@gmail.com','martiJuan','2'),
('005','Benito','Suarez',54,'benitosuarez','benitos@gmail.com','beniS123','2'),
('77272632','Evie','Diaz',19,'eviediaz','eviediaz@usil.pe','martiJuana','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
