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
GRANT INSERT ON monopoly.ranking TO 'monopolyUser'@'localhost';
FLUSH PRIVILEGES;

-- INSERT CASILLAS
INSERT INTO casillas (nombreCasilla, tipoCasilla, colorCasilla, grupoCasilla, precioCasilla, alquilerCasilla) VALUES
('Salida',              'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Calle Mediterráneo',  'PROPIEDAD',  '#955436', 1,    60,   2),
('Caja Comunidad',      'COMUNIDAD',     NULL,      NULL, NULL, NULL),
('Calle Báltico',       'PROPIEDAD',  '#955436', 1,    60,   4),
('Impuesto Renta',      'IMPUESTO',   NULL,      NULL, 200, NULL),
('Est. Sur',            'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Av. Mediterránea',    'PROPIEDAD',  '#AAE0FA', 2,    100,  6),
('Suerte',              'SUERTE',     NULL,      NULL, NULL, NULL),
('Av. Levante',         'PROPIEDAD',  '#AAE0FA', 2,    100,  6),
('Av. Valencia',        'PROPIEDAD',  '#AAE0FA', 2,    120,  8),
('Cárcel / Visita',     'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Av. Aragón',          'PROPIEDAD',  '#D93A96', 3,    140,  10),
('Empresa Eléctrica',   'SERVICIO',   NULL,      NULL, 150,  NULL),
('Av. Navarra',         'PROPIEDAD',  '#D93A96', 3,    140,  10),
('Av. Cataluña',        'PROPIEDAD',  '#D93A96', 3,    160,  12),
('Est. Norte',          'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Calle Sevilla',       'PROPIEDAD',  '#F7941D', 4,    180,  14),
('Caja Comunidad',      'COMUNIDAD',     NULL,      NULL, NULL, NULL),
('Calle Granada',       'PROPIEDAD',  '#F7941D', 4,    180,  14),
('Calle Málaga',        'PROPIEDAD',  '#F7941D', 4,    200,  16),
('Parking Gratis',      'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Av. Diagonal',        'PROPIEDAD',  '#ED2939', 5,    220,  18),
('Suerte',              'SUERTE',     NULL,      NULL, NULL, NULL),
('Av. Castellana',      'PROPIEDAD',  '#ED2939', 5,    220,  18),
('Puerta del Sol',      'PROPIEDAD',  '#ED2939', 5,    240,  20),
('Est. Este',           'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Calle Alcalá',        'PROPIEDAD',  '#FFEF00', 6,    260,  22),
('Gran Vía',            'PROPIEDAD',  '#FFEF00', 6,    260,  22),
('Empresa Agua',        'SERVICIO',   NULL,      NULL, 150,  NULL),
('Calle Serrano',       'PROPIEDAD',  '#FFEF00', 6,    280,  24),
('Ir a la Cárcel',      'ESPECIAL',   NULL,      NULL, NULL, NULL),
('Av. Prado',           'PROPIEDAD',  '#1FB25A', 7,    300,  26),
('Av. Retiro',          'PROPIEDAD',  '#1FB25A', 7,    300,  26),
('Caja Comunidad',      'COMUNIDAD',     NULL,      NULL, NULL, NULL),
('Av. Salamanca',       'PROPIEDAD',  '#1FB25A', 7,    320,  28),
('Est. Oeste',          'ESTACION',   '#B4B4B4', NULL, 200,  25),
('Suerte',              'SUERTE',     NULL,      NULL, NULL, NULL),
('Paseo del Prado',     'PROPIEDAD',  '#0072BB', 8,    350,  35),
('Impuesto Lujo',       'IMPUESTO',   NULL,      NULL, 150, NULL),
('Paseo de la Castellana', 'PROPIEDAD','#0072BB', 8,   400,  50);


-- INSERT CARTAS
-- =========================================================================
-- CARTAS DE SUERTE
-- =========================================================================

INSERT INTO cartas (tipoCarta, textoCarta, accionCarta, valorCarta, destinoCarta) VALUES 
('SUERTE', 'Avance hasta la casilla de Salida.', 'MOVER', 0, 1),
('SUERTE', 'Avance hasta la Calle Alcalá. Si pasa por la casilla de Salida, cobre 200€.', 'MOVER', 200, 27),
('SUERTE', 'Avance hasta el Paseo de la Castellana.', 'MOVER', 0, 40),
('SUERTE', 'La banca le paga un dividendo de 50€.', 'COBRAR', 50, NULL),
('SUERTE', 'Multa por exceso de velocidad. Pague 15€.', 'PAGAR', 15, NULL),
('SUERTE', 'Vaya directamente a la cárcel sin pasar por la casilla de Salida y sin cobrar los 200€.', 'IR_A_CARCEL', 0, 11),
('SUERTE', 'Retroceda tres casillas.', 'MOVER_ATRAS', 3, NULL),
('SUERTE', 'Haga reparaciones en todas sus propiedades. Pague 25€ por cada casa.', 'REPARAR_CASAS', 25, NULL),
('SUERTE', 'Queda libre de la cárcel. Esta carta puede conservarse hasta que se necesite.', 'SALIR_CARCEL', 0, NULL);

-- =========================================================================
-- CARTAS DE CAJA DE COMUNIDAD
-- =========================================================================

INSERT INTO cartas (tipoCarta, textoCarta, accionCarta, valorCarta, destinoCarta) VALUES 
('COMUNIDAD', 'Error de la banca a su favor. Cobre 200€.', 'COBRAR', 200, NULL),
('COMUNIDAD', 'Gastos médicos. Pague 50€.', 'PAGAR', 50, NULL),
('COMUNIDAD', 'Por la venta de sus acciones, recibe 100€.', 'COBRAR', 100, NULL),
('COMUNIDAD', 'Hacienda le devuelve 20€.', 'COBRAR', 20, NULL),
('COMUNIDAD', 'Es su cumpleaños. Recibe 10€ de cada jugador.', 'CUMPLEANOS', 10, NULL),
('COMUNIDAD', 'Le toca el premio anual de la lotería. Cobre 100€.', 'COBRAR', 100, NULL),
('COMUNIDAD', 'Pague la fianza del hospital de 100€.', 'PAGAR', 100, NULL),
('COMUNIDAD', 'Pague la escuela privada. 150€.', 'PAGAR', 150, NULL),
('COMUNIDAD', 'Vaya directamente a la cárcel sin pasar por la casilla de Salida y sin cobrar los 200€.', 'IR_A_CARCEL', 0, 11);

SELECT * FROM casillas;
SELECT * FROM cartas;
SELECT * FROM ranking;