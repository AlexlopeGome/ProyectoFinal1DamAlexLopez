drop database if exists bdgestorcasa;
create database bdgestorcasa;

use bdgestorcasa;

create table usuario(
    nombre varchar(200) ,
    apellidos varchar(400) ,
    correo varchar(400) primary key,
    contrasenia varchar(10),
    fechaNacimiento date,
    numeroHijos numeric(1)
);

create table Trabajador (
nombre varchar(200) primary key,
actividadDesempeñada varchar(200)

);
create table Prestamo(
nombre varchar(200)primary Key,
importeFijo boolean,
importe numeric(7,3),
fecha date,
porcentaje numeric(2),
fechafin date,
codigoMovimento numeric(3)

);
create table diasSemana(
diaSemana varchar(100) primary key

);
create table Extraescolar(
nombre varchar(200)primary Key,
importeFijo boolean,
importe numeric(7,3),
fecha date,
nombreProfesor varchar(200),
asignaturas varchar(100),
diaSemana varchar(100),
codigoMovimento numeric(3),
foreign key (nombreProfesor) references trabajador(nombe),
foreign key (diasSemana) references diasSemana(diaSemana)

);

create table tipoCompras(
tipoCompra varchar(200) primary key
);
create table Compra(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
comentario varchar(200),
tipoCompras varchar(200),
codigoMovimento numeric(3),
foreign key (tipoCompras) references tipoCompras(tipoCompra)
);
create table tipoIngreso(
tipoIngreso varchar(200) primary key,
codigoMovimento numeric(3)
);

create table ClaseParticular(

nombre varchar(200) primary key,
importeFijo boolean,
importe numeric(7,3),
fecha date,
asignatatura varchar(200),
nombreTrabajador varchar(200),
nobreDiaSemana  varchar(100),
codigoMovimento numeric(3),
foreign key (nombreDiaSemana) references nombre(diasSemana),
foreign key (nombreTrabajador) references nombre(Trabajador)
);
create table Ingresos(
codigoMovimento numeric(3)primary key,
foreign key (codigoMovimiento) references tipoIngreso(codigoMovimiento)

);
create table Gastos(
codigoMovimento numeric(3)primary key,
foreign key (codigoMovimiento) references Claseparticular(codigoMovimiento),
foreign key (codigoMovimiento) references Compra(codigoMovimiento),
foreign key (codigoMovimiento) references Extraescolar(codigoMovimiento),
foreign key (codigoMovimiento) references Prestamo(codigoMovimiento)

);
