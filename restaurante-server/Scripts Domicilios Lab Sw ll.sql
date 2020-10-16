-- phpMyAdmin SQL Dump
-- version 4.6.6deb4+deb9u1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-09-2020 a las 11:47:26
-- Versión del servidor: 10.1.45-MariaDB-0+deb9u1
-- Versión de PHP: 7.0.33-0+deb9u9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET GLOBAL time_zone = '-3:00';


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `domicilios`
--

/*==============================================================*/
/* Table: ADMINISTRADOR                                         */
/*==============================================================*/
create table ADMINISTRADOR
(
   ADMID                int not null,
   primary key (ADMID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*==============================================================*/
/* Table: PLATOS                                                */
/*==============================================================*/
create table PLATOS
(
   RESTID               int not null,
   PLTNOMBRE            varchar(30) not null,
   PLTPRECIO            int not null,
   PLTDESCRIPCION       text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table PLATOS add constraint FK_TIENE foreign key (RESTID)
      references RESTAURANTE (RESTID) on delete restrict on update restrict;

alter table RESTAURANTE add constraint FK_ADMINISTRA foreign key (ADMID)
      references ADMINISTRADOR (ADMID) on delete restrict on update restrict;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO ADMINISTRADOR VALUES(100);
INSERT INTO RESTAURANTE VALUES(1,100,"LA COSECHA","Cra 11 # 3-45",800001);
INSERT INTO RESTAURANTE VALUES(2,100,"PATATUS","Cll 3a # 4-25 n",800002);
INSERT INTO RESTAURANTE VALUES(3,100,"PIZZA PITS","cra 3s # 3-21",800003);
INSERT INTO PLATOS values(1,"Carne asada",15000,"300 g de carne asada al carbon");
INSERT INTO PLATOS values(1,"Pollo asado",12000,"300 g de pollo asado al carbon");
INSERT INTO PLATOS values(2,"Hamburguesa",11000,"300 g de carne angus, lechuga, tomate y salsa patatus");

