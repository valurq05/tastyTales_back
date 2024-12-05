@ -0,0 +1,142 @@
-- CREACIÓN BASE DE DATOS
CREATE DATABASE tasty_tales;

USE tasty_tales;

-- Creación tablas

CREATE TABLE Usuarios (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    userNombre VARCHAR(255),
    userPassword VARCHAR(255),
    userDoc VARCHAR(255)
);
CREATE TABLE Recetas (
    recetaID INT PRIMARY KEY AUTO_INCREMENT,
    recetaTitulo VARCHAR(255),
    recetaDescripcion VARCHAR(255),
    recetaStatus INT,
    userID INT,
    FOREIGN KEY (userID) REFERENCES Usuarios(userID)
);
CREATE TABLE Adicionales (
    adicionalID INT PRIMARY KEY AUTO_INCREMENT,
    adDescripcion VARCHAR(255)
);

CREATE TABLE Pasos (
    pasosID INT PRIMARY KEY AUTO_INCREMENT,
    pasoTitulo VARCHAR(255),
    pasoDescripcion VARCHAR(255),
    recetaID INT,
    FOREIGN KEY (recetaID) REFERENCES Recetas(recetaID)
);

CREATE TABLE PasosAdicionales (
    pasAdicID INT PRIMARY KEY AUTO_INCREMENT,
    pasoID INT,
    adicionalID INT,
    FOREIGN KEY (pasoID) REFERENCES Pasos(pasosID),
    FOREIGN KEY (adicionalID) REFERENCES Adicionales(adicionalID)
);

CREATE TABLE Categorias (
    categoriaID INT PRIMARY KEY AUTO_INCREMENT,
    categoriaNombre VARCHAR(255),
    categoriaStatus INT
);

CREATE TABLE RecetasCategorias (
    resCatID INT PRIMARY KEY AUTO_INCREMENT,
    recetaID INT,
    categoriaID INT,
    FOREIGN KEY (recetaID) REFERENCES Recetas(recetaID),
    FOREIGN KEY (categoriaID) REFERENCES Categorias(categoriaID)
);


CREATE TABLE RecetasFavoritas (
    recFavID INT PRIMARY KEY AUTO_INCREMENT,
    recFavStatus INT,
    userID INT,
    recetaID INT,
    FOREIGN KEY (userID) REFERENCES Usuarios(userID),
    FOREIGN KEY (recetaID) REFERENCES Recetas(recetaID)
);

CREATE TABLE CalificacionRecetas (
    califRecID INT PRIMARY KEY AUTO_INCREMENT,
    calificacion INT,
    recetaID INT,
    userID INT,
    FOREIGN KEY (recetaID) REFERENCES Recetas(recetaID),
    FOREIGN KEY (userID) REFERENCES Usuarios(userID)
);
-- INSERTAR DATOS

-- Tabla Recetas
INSERT INTO Recetas (recetaTitulo, recetaDescripcion, recetaStatus) VALUES 
    ('Ensalada César', 'Ensalada clásica con aderezo César y crutones', 1), 
    ('Pizza Margarita', 'Pizza con tomate, albahaca y mozzarella', 0), 
    ('Pastel de Chocolate', 'Pastel suave de chocolate con frosting', 1), 
    ('Sopa de Verduras', 'Sopa caliente con verduras frescas', 1), 
    ('Tacos al Pastor', 'Tacos de carne de cerdo al pastor con piña', 1);

-- Tabla Adicionales
INSERT INTO Adicionales (adDescripcion) VALUES 
    ('Cronometro'), 
    ('Video');

-- Tabla Pasos
INSERT INTO Pasos (pasoTitulo, pasoDescripcion, recetaID) VALUES 
    ('Preparar ingredientes', 'Lavar y cortar los ingredientes necesarios', 1), 
    ('Precalentar horno', 'Encender el horno a 180 grados Celsius', 2), 
    ('Mezclar ingredientes', 'Combinar los ingredientes en un bol', 1), 
    ('Hornear', 'Poner en el horno por 30 minutos', 3), 
    ('Servir', 'Emplatar y servir caliente', 1);

-- Tabla PasosAdicionales
INSERT INTO PasosAdicionales (pasoID, adicionalID) VALUES 
    (1, 1), 
    (2, 2), 
    (3, 1), 
    (4, 2), 
    (5, 1);

-- Tabla Categorias
INSERT INTO Categorias (categoriaNombre, categoriaStatus) VALUES 
    ('Ensaladas', 1), 
    ('Italiano', 0), 
    ('Postres', 1), 
    ('Sopas', 1), 
    ('Mexicano', 1);

-- Tabla RecetasCategorias
INSERT INTO RecetasCategorias (recetaID, categoriaID) VALUES 
    (1, 1), 
    (2, 2), 
    (3, 3), 
    (4, 4), 
    (5, 5);

-- Tabla Usuarios
INSERT INTO Usuarios (userNombre, userPassword, userDoc) VALUES 
    ('Juan Perez', 'password123', '12345678A'), 
    ('Ana Gomez', 'password456', '87654321B'), 
    ('Luis Lopez', 'password789', '12312312C'), 
    ('Maria Garcia', 'password101', '45645645D'), 
    ('Carlos Ruiz', 'password102', '78978978E');

-- Tabla RecetasFavoritas
INSERT INTO RecetasFavoritas (userID, recetaID, recFavStatus) VALUES 
    (1, 1, 1), 
    (2, 2, 0), 
    (3, 3, 1), 
    (4, 4, 0), 
    (5, 5, 1);

-- Tabla CalificacionRecetas
INSERT INTO CalificacionRecetas (calificacion, recetaID, userID) VALUES 
    (5, 1, 1), 
    (4, 2, 2), 
    (3, 3, 3), 
    (5, 4, 4), 
    (2, 5, 5);