drop database if exists bdgestorcasa;
create database bdgestorcasa;

use bdgestorcasa;

create table usuario(
    nombre varchar(200) ,
    apellidos varchar(400) ,
    correo varchar(400) unique,
    contrasenia varchar(10),
    fechaNacimiento date,
    numeroHijos varchar(2),
    direccion varchar(400),
    nick varchar(200) primary key
);

create table Trabajador (
nombre varchar(200) primary key,
actividadDesempeñada varchar(200),
telefono int(9)

);
create table Prestamo(
nombre varchar(200),
importeFijo boolean,
importe float(7,2),
fecha date,
porcentaje float(7,2),
fechafin date,
codigoMovimiento int(3) primary Key

);

create table extraEscolar(
nombre varchar(200),
importeFijo boolean,
importe float(7,2),
fecha date,
nombreProfesor varchar(200),
asignaturas varchar(100),
diaSemana varchar(100),
codigoMovimiento int(3)  primary Key,
foreign key (nombreProfesor) references Trabajador(nombre)

);

create table Servicio(
nombre varchar(200),
importeFijo boolean,
importe float(7,2),
fecha date,
nombreTrabajador varchar(200),
diaSemana varchar(100),
codigoMovimiento int(3)  primary Key,
foreign key (nombreTrabajador) references Trabajador(nombre)

);


create table tipoIngreso(
nombre varchar(200),
importeFijo boolean,
importe float(7,2),
fecha date,
tipoIngreso varchar(200),
codigoMovimiento int(3)  primary key

);

create table Compra(
nombre varchar(200),
importeFijo boolean,
importe float(7,2),
fecha date,
comentario varchar(200),
tipoCompras varchar(200),
codigoMovimiento int(3)  primary key
);




create table GastoExtra(
nombre varchar (200),
importeFijo boolean,
importe float(7,2),
fecha date,
codigoMovimiento  int(3)  primary key
);


