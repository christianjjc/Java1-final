
CREATE DATABASE examenfinal;

USE examenfinal;

CREATE TABLE `estudiante` (
`codigo` int NOT NULL,
`nombre` varchar(100) NOT NULL,
`edad` int NOT NULL,
PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `estudiante` (codigo, nombre, edad)
VALUES (1, 'Christian Jiménez', 15);

INSERT INTO `estudiante` (codigo, nombre, edad)
VALUES (2, 'Emily Castro', 16);

INSERT INTO `estudiante` (codigo, nombre, edad)
VALUES (3, 'Hanna Jiménez', 13);

INSERT INTO `estudiante` (codigo, nombre, edad)
VALUES (4, 'Chimi Jiménez', 14);