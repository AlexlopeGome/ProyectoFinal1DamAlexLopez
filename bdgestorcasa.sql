drop database if exists bdgestorcasa;
create database bdgestorcasa;

use bdgestorcasa;

create table usuario(
    nombre varchar(200) primary key,
    apellidos varchar(400) primary key,
    correo varchar(400),
    contrasenia int(10),
    fechaNacimiento date,
    numeroHijos numeric(1)
);

create table Trabajador (
nombre varchar(200) ,
actividadDesempeñada varchar(200),
codigoTrabajador numeric(3)
);
create table Prestamo(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
porcentaje numeric(2),
fechafin date
);
create table diasSemana(
codigoDiasSemana numeric(2),
diaSemana varchar(100)
);
create table Extraescolar(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
codigoTrabajador numeric(3),
asignaturas varchar(100),
codigoDiasSemana numeric(3)
);
create table diasSemana(
codigoDiasSemana numeric(2),
diaSemana varchar(100)
);

create table tipoCompra(
codigotipoCompra numeric(3),
tipoCompras varchar(200)
);
create table Compra(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
comentario varchar(200),
codigotipoCompra numeric(3)
);
create table tipoCompra(
codigotipoCompra numeric(3),
tipoCompras varchar(200)
);
create table Ingreso(
codigoMovimento numeric(3)
);
create table ClaseParticular(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
asignatatura varchar(200),
codigoTrabajador numeric(3),
codigoDiasSemana numeric(2)
);

