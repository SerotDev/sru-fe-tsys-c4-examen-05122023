-- Crea y usa la base de datos
DROP DATABASE IF EXISTS examen_c4_db;
CREATE DATABASE examen_c4_db;
USE examen_c4_db;

-- Crear la tabla Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom_apels VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    usuario_steam VARCHAR(50),
    UNIQUE KEY unique_username (username),
    UNIQUE KEY unique_email (email)
);

-- Crear la tabla Videojuegos
CREATE TABLE IF NOT EXISTS Videojuegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    UNIQUE KEY unique_nombre (nombre)
);

-- Crear la tabla Partys
CREATE TABLE IF NOT EXISTS Partys (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_usuario INT,
    id_videojuego INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id),
    FOREIGN KEY (id_videojuego) REFERENCES Videojuegos(id)
);

-- Crear la tabla EntrarSalir
CREATE TABLE IF NOT EXISTS EntrarSalir (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT,
    id_party INT,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id),
    FOREIGN KEY (id_party) REFERENCES Partys(id),
    UNIQUE KEY unique_entrar (id_usuario,id_party)
);

-- Crear la tabla Mensajes
CREATE TABLE IF NOT EXISTS Mensajes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_party INT,
    id_usuario INT,
    fecha_hora DATETIME,
    mensaje TEXT,
    FOREIGN KEY (id_party) REFERENCES Partys(id),
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(id)
);

-- Inserciones en la tabla Usuarios
INSERT INTO Usuarios (nom_apels, username, contrasena, email, usuario_steam) VALUES
    ('Sergi Rodriguez', 'serot', 'password123', 'sergi@example.com', 'sergi_steam'),
    ('Jane Smith', 'jane_smith', 'pass456', 'jane@example.com', 'jane_steam'),
    ('Bob Johnson', 'bob_johnson', 'bob_pass', 'bob@example.com', 'bob_steam');

-- Inserciones en la tabla Videojuegos
INSERT INTO Videojuegos (nombre) VALUES
    ('Fortnite'),
    ('League of Legends'),
    ('Minecraft');

-- Inserciones en la tabla Partys
INSERT INTO Partys (nombre, id_usuario, id_videojuego) VALUES
    ('Party1', 1, 1),
    ('Party2', 2, 2),
    ('Party3', 3, 3);

-- Inserciones en la tabla EntrarSalir
INSERT INTO EntrarSalir (id_usuario, id_party) VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (1, 3);

-- Inserciones en la tabla Mensajes
INSERT INTO Mensajes (id_party, id_usuario, fecha_hora, mensaje) VALUES
    (1, 1, '2023-01-01 10:00:00', '¡Hola a todos!'),
    (1, 2, '2023-01-01 10:05:00', '¡Hola John!'),
    (2, 3, '2023-01-02 15:30:00', '¿Alguien quiere unirse a la Party2?'),
    (3, 1, '2023-01-03 20:00:00', '¡Bienvenidos a la Party3!');