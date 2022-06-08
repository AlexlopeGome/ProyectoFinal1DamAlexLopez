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



create table Ingresos(
codigoMovimiento int(3)  primary key,
foreign key (codigoMovimiento) references tipoIngreso(codigoMovimiento)

);
create table GastoExtra(
nombre varchar (200),
importeFijo boolean,
importe float(7,2),
fecha date,
codigoMovimiento  int(3)  primary key
);


create table Gastos(
codigoMovimiento int(3) primary key,
foreign key (codigoMovimiento) references Compra(codigoMovimiento),
foreign key (codigoMovimiento) references Extraescolar(codigoMovimiento),
foreign key (codigoMovimiento) references Servicio(codigoMovimiento),
foreign key (codigoMovimiento) references Prestamo(codigoMovimiento),
foreign key (codigoMovimiento) references GastoExtra(codigoMovimiento)

);
/*CONSULTA Q DEVUELVE LA SUMA DE TODAS LAS COLUMNAS importe*/
SELECT SUM(importe) FROM Compra;
SELECT SUM(importe) FROM extraEscolar;
SELECT SUM(importe) FROM Servicio;
SELECT SUM(importe) FROM GastosExtra;
SELECT SUM(importe) FROM Prestamo;

SELECT SUM(importe) FROM tipoIngreso;