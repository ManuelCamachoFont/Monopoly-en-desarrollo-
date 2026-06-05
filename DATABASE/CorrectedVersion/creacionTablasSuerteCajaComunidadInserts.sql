CREATE SCHEMA monopoly
CHARSET utf8mb4
COLLATE utf8mb4_spanish2_ci;

USE monopoly;
-- Crear tabla casillas

CREATE TABLE Casillas (
    id INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Propiedad, Estacion, Servicio, Especial, etc.
    color VARCHAR(30) NULL,
    precio INT NULL,
    alquiler_base INT NULL
);

-- Crear tabla ranking
CREATE TABLE ranking (
    idRanking INT AUTO_INCREMENT,
    nombreJugadoresRanking VARCHAR (45) NOT NULL,
    dineroFinalRanking INT NOT NULL,
    casasFinalRanking INT NOT NULL,
    hotelesFinalRanking INT NOT NULL,
    PRIMARY KEY (idRanking)
);

-- Tabla de cartas de comunidad
CREATE TABLE CartasComunidad (
    id INT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    accion VARCHAR(50) NOT NULL, 
    valorDinero INT NULL, 
    valorDesplazamiento VARCHAR(50) NULL 
);

-- Tabla de cartas de suerte
CREATE TABLE CartasSuerte (
    id INT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    accion VARCHAR(50) NOT NULL, 
    valorDinero INT NULL, 
    valorDesplazamiento VARCHAR(50) NULL 
);

INSERT INTO CartasComunidad (id, descripcion, accion, valorDinero, valorDesplazamiento) VALUES
(1, 'Avanza hasta la casilla de Salida.', 'Desplaza', NULL, 'Salida'),
(2, 'Error del banco a tu favor. Recibe 200€.', 'Suma', 200, NULL),
(3, 'Gastos médicos. Paga 50€.', 'Resta', -50, NULL),
(4, 'Obtienes 50€ por la venta de tus acciones.', 'Suma', 50, NULL),
(5, 'Quedas libre de la Cárcel. Puedes conservar esta carta.', 'Especial', NULL, 'Libre_Carcel'),
(6, 'Ve directamente a la Cárcel. No pases por la salida ni cobres los 200€.', 'Desplaza', NULL, 'Carcel'),
(7, 'Devolución de Hacienda. Recibe 200€.', 'Suma', 200, NULL),
(8, 'Es tu cumpleaños. Recibe 10€ de cada jugador.', 'Especial', 10, 'De_Jugadores'),
(9, 'Te toca pagar la póliza del seguro. Paga 50€.', 'Resta', -50, NULL),
(10, 'Paga la factura del hospital. Te cuesta 100€.', 'Resta', -100, NULL),
(11, 'Paga una multa escolar de 50€.', 'Resta', -50, NULL),
(12, 'Recibe 25€ por tus servicios de consultoría.', 'Suma', 25, NULL);

INSERT INTO CartasSuerte (id, descripcion, accion, valorDinero, valorDesplazamiento) VALUES
(1, 'Avanza hasta la casilla de Salida.', 'Desplaza', NULL, 'Salida'),
(2, 'Avanza hasta el Paseo de la Castellana.', 'Desplaza', NULL, 'Paseo de la Castellana'),
(3, 'Avanza hasta la Avenida de los Reyes Católicos. Si pasas por la casilla de Salida, cobra 200€.', 'Desplaza', NULL, 'Avenida de los Reyes Catolicos'),
(4, 'Avanza hasta la Estación de Goya. Si pasas por la casilla de Salida, cobra 200€.', 'Desplaza', NULL, 'Estacion de Goya'),
(5, 'El banco te paga un dividendo de 50€.', 'Suma', 50, NULL),
(6, 'Ve directamente a la Cárcel. No pases por la salida ni cobres los 200€.', 'Desplaza', NULL, 'Carcel'),
(7, 'Haz reparaciones en todos tus edificios. Paga 25€ por casa y 100€ por hotel.', 'Especial', NULL, 'Reparaciones'),
(8, 'Retrocede tres casillas.', 'Desplaza', NULL, '-3'),
(9, 'Multa por exceso de velocidad. Paga 15€.', 'Resta', -15, NULL),
(10, 'La inspección de la calle te cuesta 150€.', 'Resta', -150, NULL),
(11, 'Quedas libre de la Cárcel. Puedes conservar esta carta.', 'Especial', NULL, 'Libre_Carcel'),
(12, 'Tu fondo de inversión vence. Recibe 150€.', 'Suma', 150, NULL);


-- Insertar las 40 casillas del tablero
INSERT INTO Casillas (id, nombre, tipo, color, precio, alquiler_base) VALUES
(1, 'Salida', 'Especial', NULL, NULL, NULL),
(2, 'Ronda de Valencia', 'Propiedad', '#955436', 60, 2),
(3, 'Caja de Comunidad', 'Especial', NULL, NULL, NULL),
(4, 'Plaza Lavapies', 'Propiedad', '#955436', 60, 4),
(5, 'Impuesto sobre la Renta', 'Especial', NULL, NULL, 200),
(6, 'Estacion de Goya', 'Estacion', '#000000', 200, 25),
(7, 'Calle de Genova', 'Propiedad', '#ACE5EE', 100, 6),
(8, 'Suerte', 'Especial', NULL, NULL, NULL),
(9, 'Glorieta de Cuatro Caminos', 'Propiedad', '#ACE5EE', 100, 6),
(10, 'Avenida de los Reyes Catolicos', 'Propiedad', '#ACE5EE', 120, 8),
(11, 'Carcel / De Visita', 'Especial', NULL, NULL, NULL),
(12, 'Calle Bailen', 'Propiedad', '#D9381E', 140, 10),
(13, 'Compania de Electricidad', 'Servicio', '#FFFFFF', 150, NULL),
(14, 'Plaza de Espana', 'Propiedad', '#D9381E', 140, 10),
(15, 'Puerta del Sol', 'Propiedad', '#D9381E', 160, 12),
(16, 'Estacion de las Delicias', 'Estacion', '#000000', 200, 25),
(17, 'Calle Alcala', 'Propiedad', '#F7941D', 180, 14),
(18, 'Caja de Comunidad', 'Especial', NULL, NULL, NULL),
(19, 'Gran Via', 'Propiedad', '#F7941D', 180, 14),
(20, 'Calle Princesa', 'Propiedad', '#F7941D', 200, 16),
(21, 'Parking Gratuito', 'Especial', NULL, NULL, NULL),
(22, 'Paseo de la Castellana', 'Propiedad', '#ED1C24', 220, 18),
(23, 'Suerte', 'Especial', NULL, NULL, NULL),
(24, 'Calle Bravo Murillo', 'Propiedad', '#ED1C24', 220, 18),
(25, 'Glorieta de Bilbao', 'Propiedad', '#ED1C24', 240, 20),
(26, 'Estacion de Mediodia', 'Estacion', '#000000', 200, 25),
(27, 'Calle Serrano', 'Propiedad', '#FFF200', 260, 22),
(28, 'Paseo de Recoletos', 'Propiedad', '#FFF200', 260, 22),
(29, 'Compania de Aguas', 'Servicio', '#FFFFFF', 150, NULL),
(30, 'Avenida de la Habana', 'Propiedad', '#FFF200', 280, 24),
(31, 'Ve a la Carcel', 'Especial', NULL, NULL, NULL),
(32, 'Paseo de Rosales', 'Propiedad', '#1FB25A', 300, 26),
(33, 'Calle Alberto Aguilera', 'Propiedad', '#1FB25A', 300, 26),
(34, 'Caja de Comunidad', 'Especial', NULL, NULL, NULL),
(35, 'Avenida de la Castellana', 'Propiedad', '#1FB25A', 320, 28),
(36, 'Estacion de Principe Pio', 'Estacion', '#000000', 200, 25),
(37, 'Suerte', 'Especial', NULL, NULL, NULL),
(38, 'Paseo de la Castellana', 'Propiedad', '#0072BC', 350, 35),
(39, 'Impuesto de Lujo', 'Especial', NULL, NULL, 100),
(40, 'Paseo del Prado', 'Propiedad', '#0072BC', 400, 50);