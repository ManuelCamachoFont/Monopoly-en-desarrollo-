-- Monopoly
-- Crear la BD
CREATE DATABASE monopoly
CHARSET utf8mb4
COLLATE utf8mb4_spanish2_ci;
-- Activar la BD
USE monopoly;
-- Crear tabla casillas
CREATE TABLE casillas (
    idCasilla INT AUTO_INCREMENT,
    nombreCasilla VARCHAR(45) NOT NULL,
    tipoCasilla VARCHAR(45) NOT NULL,
    colorCasilla VARCHAR(7), 
    grupoCasilla INT,
    precioCasilla INT,
    alquilerCasilla INT,
    PRIMARY KEY (idCasilla)
);
-- Crear tabla ranking
CREATE TABLE ranking (
    idRanking INT AUTO_INCREMENT,
    nombreJugadorRanking VARCHAR (45) NOT NULL,
    dineroFinalRanking INT NOT NULL,
    casasFinalRanking INT NOT NULL,
    hotelesFinalRanking INT NOT NULL,
    PRIMARY KEY (idRanking)
);
-- Crear tabla cartas
CREATE TABLE cartas (
    idCarta INT AUTO_INCREMENT,
    tipoCarta VARCHAR(45) NOT NULL,
    textoCarta VARCHAR(150) NOT NULL,
    accionCarta VARCHAR(45) NOT NULL,
    valorCarta INT,
    destinoCarta INT,
    PRIMARY KEY (idCarta)
);

-- Creacion usuario
CREATE USER 'monopolyUser'@'localhost' IDENTIFIED BY 'studium';
GRANT SELECT ON monopoly.* TO 'monopolyUser'@'localhost';

-- INSERT CASILLAS
INSERT INTO casillas (nombreCasilla, tipoCasilla, colorCasilla, grupoCasilla, precioCasilla, alquilerCasilla) VALUES
-- LADO SUR (id 1-11)
('Salida',              'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Calle Mediterráneo',  'PROPIEDAD',  '#955436', 1,    60,   2),
('Caja Comunidad',      'CARTAS',     NULL,      NULL, NULL, NULL),
('Calle Báltico',       'PROPIEDAD',  '#955436', 1,    60,   4),
('Impuesto Renta',      'IMPUESTO',   NULL,      NULL, NULL, NULL),
('Est. Sur',            'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Av. Mediterránea',    'PROPIEDAD',  '#AAE0FA', 2,    100,  6),
('Suerte',              'CARTAS',     NULL,      NULL, NULL, NULL),
('Av. Levante',         'PROPIEDAD',  '#AAE0FA', 2,    100,  6),
('Av. Valencia',        'PROPIEDAD',  '#AAE0FA', 2,    120,  8),
('Cárcel / Visita',     'ESPECIAL',   NULL,      NULL, NULL, NULL),

-- LADO ESTE (id 12-20)
('Av. Aragón',          'PROPIEDAD',  '#D93A96', 3,    140,  10),
('Empresa Eléctrica',   'SERVICIO',   NULL,      NULL, 150,  NULL),
('Av. Navarra',         'PROPIEDAD',  '#D93A96', 3,    140,  10),
('Av. Cataluña',        'PROPIEDAD',  '#D93A96', 3,    160,  12),
('Est. Norte',          'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Calle Sevilla',       'PROPIEDAD',  '#F7941D', 4,    180,  14),
('Caja Comunidad',      'CARTAS',     NULL,      NULL, NULL, NULL),
('Calle Granada',       'PROPIEDAD',  '#F7941D', 4,    180,  14),
('Calle Málaga',        'PROPIEDAD',  '#F7941D', 4,    200,  16),

-- LADO NORTE (id 21-31)
('Parking Gratis',      'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Av. Diagonal',        'PROPIEDAD',  '#ED2939', 5,    220,  18),
('Suerte',              'CARTAS',     NULL,      NULL, NULL, NULL),
('Av. Castellana',      'PROPIEDAD',  '#ED2939', 5,    220,  18),
('Puerta del Sol',      'PROPIEDAD',  '#ED2939', 5,    240,  20),
('Est. Este',           'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Calle Alcalá',        'PROPIEDAD',  '#FFEF00', 6,    260,  22),
('Gran Vía',            'PROPIEDAD',  '#FFEF00', 6,    260,  22),
('Empresa Agua',        'SERVICIO',   NULL,      NULL, 150,  NULL),
('Calle Serrano',       'PROPIEDAD',  '#FFEF00', 6,    280,  24),
('Ir a la Cárcel',      'ESPECIAL',   NULL,      NULL, NULL, NULL),

-- LADO OESTE (id 32-40)
('Av. Prado',           'PROPIEDAD',  '#1FB25A', 7,    300,  26),
('Av. Retiro',          'PROPIEDAD',  '#1FB25A', 7,    300,  26),
('Caja Comunidad',      'CARTAS',     NULL,      NULL, NULL, NULL),
('Av. Salamanca',       'PROPIEDAD',  '#1FB25A', 7,    320,  28),
('Est. Oeste',          'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Suerte',              'CARTAS',     NULL,      NULL, NULL, NULL),
('Paseo del Prado',     'PROPIEDAD',  '#0072BB', 8,    350,  35),
('Impuesto Lujo',       'IMPUESTO',   NULL,      NULL, NULL, NULL),
('Paseo de la Castellana', 'PROPIEDAD','#0072BB', 8,   400,  50);
