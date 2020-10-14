
drop table if exists ADMINISTRADOR;

drop table if exists PLATOS;

drop table if exists RESTAURANTE;


-- phpMyAdmin SQL Dump
-- version 4.6.6deb4+deb9u1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-09-2020 a las 11:47:26
-- Versión del servidor: 10.1.45-MariaDB-0+deb9u1
-- Versión de PHP: 7.0.33-0+deb9u9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


/*==============================================================*/
/* Table: ADMINISTRADOR                                         */
/*==============================================================*/
create table ADMINISTRADOR
(
   ADMID                int not null,
   primary key (ADMID)
);

/*==============================================================*/
/* Table: PLATOS                                                */
/*==============================================================*/
create table PLATOS
(
   RESTID               int not null,
   PLTNOMBRE            varchar(30) not null,
   PTLPRECIO            int not null,
   PLTDESCRIPCION       text
);

/*==============================================================*/
/* Table: RESTAURANTE                                           */
/*==============================================================*/
create table RESTAURANTE
(
   RESTID               int not null,
   ADMID                int not null,
   RESTNOMBRE           varchar(30) not null,
   RESTDIRECCION        varchar(30) not null,
   RESTTELEFONO         int not null,
   primary key (RESTID)
);

alter table PLATOS add constraint FK_TIENE foreign key (RESTID)
      references RESTAURANTE (RESTID) on delete restrict on update restrict;

alter table RESTAURANTE add constraint FK_ADMINISTRA foreign key (ADMID)
      references ADMINISTRADOR (ADMID) on delete restrict on update restrict;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

