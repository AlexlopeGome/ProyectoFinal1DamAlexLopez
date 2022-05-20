drop database if exists bdgestorcasa;
create database bdgestorcasa;
use bdgestorcasa;
create table usuario(
    nombre varchar(200),
    apellidos varchar(400), 
    correo varchar(400),
    contrasenia int(10),
    fechaNacimiento date,
    numeroHijos numeric(1),
    nick varchar(200)primary Key
);

create table Trabajador (
	nombre varchar(200) ,
	actividadDesempeñada varchar(200),
	codigoTrabajador numeric(3) primary Key
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
create table DiasSemana(
codigoDiasSemana numeric(2) primary key,
nombrediaSemana varchar(100)
);

create table Extraescolar(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
codigoTrabajador numeric(3),
asignaturas varchar(100),
codigoDiasSemana numeric(2),
foreign key (codigoTrabajador) references Trabajador(codigoTrabajador),
foreign key (codigoDiasSemana)references DiasSemana(codigoDiasSemana)
);

create table TipoCompra(
codigoTipoCompra numeric(3) primary key,
tipoCompras varchar(200)
);

create table Compra(
codigo numeric(3) primary Key,
nombre varchar(200),
importeFijo boolean,
importe numeric(7,3),
fecha date,
comentario varchar(200),
codigoTipoCompra numeric(3),
foreign key (codigoTipoCompra) references  TipoCompra(codigoTipoCompra) 
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
codigoDiasSemana numeric(2),
foreign key (codigoTrabajador) references Trabajador(codigoTrabajador),
foreign key (codigoDiasSemana) references diasSemana(codigoDiasSemana)
);

