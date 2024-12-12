-- CREACIÓN BASE DE DATOS
CREATE DATABASE tasty_tales;

USE tasty_tales;

-- Creación tablas

CREATE TABLE Usuarios (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    userNombre VARCHAR(255),
    userPassword VARCHAR(255),
    userFoto VARCHAR(255)
);

CREATE TABLE Personas (
    perID INT PRIMARY KEY AUTO_INCREMENT,
    perName VARCHAR(255),
    perLastName VARCHAR(255),
    perDoc VARCHAR(15),
    userID INT,
    FOREIGN KEY (userID) REFERENCES Usuarios(userID)
);

CREATE TABLE Recetas (
    recetaID INT PRIMARY KEY AUTO_INCREMENT,
    recetaTitulo VARCHAR(255),
    recetaDescripcion VARCHAR(255),
    recetaStatus INT,
    userID INT,
    FOREIGN KEY (userID) REFERENCES Usuarios(userID)
);

CREATE TABLE ingredientes (
    ingredID INT PRIMARY KEY AUTO_INCREMENT,
    ingredNombre VARCHAR(255),
    ingredDescripcion VARCHAR(255),
    ingredStatus INT
);


CREATE TABLE medidas (
    medID INT PRIMARY KEY AUTO_INCREMENT,
    medNombre VARCHAR(255),
    ingredStatus INT
);

CREATE TABLE ingredientesRecetas (
    ingrRecID INT PRIMARY KEY AUTO_INCREMENT,
    ingrRecCantidad DECIMAL(10,2),
    ingrRecStatus INT,
    medID INT,
    recetaID INT,
    ingredID INT,
    FOREIGN KEY (medID) REFERENCES medidas(medID),
    FOREIGN KEY (ingredID) REFERENCES ingredientes(ingredID),
    FOREIGN KEY (recetaID) REFERENCES recetas(recetaID)
);

CREATE TABLE features (
    featureID INT PRIMARY KEY AUTO_INCREMENT,
    featureDesc VARCHAR(255)
);

CREATE TABLE Pasos (
    pasosID INT PRIMARY KEY AUTO_INCREMENT,
    pasoTitulo VARCHAR(255),
    pasoDescripcion VARCHAR(255),
    recetaID INT,
    FOREIGN KEY (recetaID) REFERENCES Recetas(recetaID)
);

CREATE TABLE featuresByUser (
    featUseID INT PRIMARY KEY AUTO_INCREMENT,
    pasoID INT,
    featureID INT,
    FOREIGN KEY (pasoID) REFERENCES Pasos(pasosID),
    FOREIGN KEY (featureID) REFERENCES features(featureID)
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

-- Tabla Usuarios
INSERT INTO Usuarios (userNombre, userPassword, userFoto) VALUES 
    ('juan@gmail.com', 'password123', '/fotos/juan.jpg'), 
    ('ana@gmail.com', 'password456', '/fotos/ana.jpg'), 
    ('luis@gmail.com', 'password789', '/fotos/luis.jpg'), 
    ('Maria@gmail.com', 'password101', '/fotos/maria.jpg'), 
    ('carlos@gmail.com', 'password102', '/fotos/carlos.jpg');

-- Tabla Recetas
INSERT INTO Recetas (recetaTitulo, recetaDescripcion, recetaStatus, userID) VALUES 
    ('Ensalada César', 'Ensalada clásica con aderezo César y crutones', 1, 1), 
    ('Pizza Margarita', 'Pizza con tomate, albahaca y mozzarella', 0, 1), 
    ('Pastel de Chocolate', 'Pastel suave de chocolate con frosting', 1, 2), 
    ('Sopa de Verduras', 'Sopa caliente con verduras frescas', 1, 3), 
    ('Tacos al Pastor', 'Tacos de carne de cerdo al pastor con piña', 1, 1);

-- Tabla ingredientes
INSERT INTO `ingredientes`(`ingredNombre`, `ingredDescripcion`, `ingredStatus`) VALUES 
('Cebolla larga','Vegetal normalmente vendido en plazas de mercado',1),
('Tomate','Fruto rojo utilizado en ensaladas y salsas',1),
('Ajo','Bulbo aromático utilizado como condimento',1),
('Pimiento','Vegetal de colores variados utilizado en diversas recetas',1),
('Zanahoria','Raíz comestible de color naranja',1),
('Yogur','Producto lácteo fermentado',1),
('Queso','Producto lácteo obtenido por la coagulación de la leche',1),
('Leche','Líquido blanco producido por las glándulas mamarias de los mamíferos',1),
('Pollo','Carne de ave comúnmente utilizada en diversas recetas',1),
('Carne de res','Carne roja proveniente del ganado vacuno',1),
('Cerdo','Carne proveniente del cerdo',1),
('Pimienta','Especia obtenida de los granos de la planta Piper nigrum',1),
('Canela','Especia obtenida de la corteza de árboles del género Cinnamomum',1),
('Comino','Especia obtenida de las semillas de la planta Cuminum cyminum',1),
('Orégano','Especia obtenida de las hojas de la planta Origanum vulgare',1);


-- Tabla medidas
INSERT INTO `medidas`(`medNombre`, `ingredStatus`) VALUES 
('GRAMOS',1),
('CUCHARADA',1),
('TAZA',1);

-- Tabla ingredientesrecetas
INSERT INTO `ingredientesrecetas`(`ingrRecCantidad`, `ingrRecStatus`, `medID`, `recetaID`, `ingredID`) VALUES 
(500, 1, 1, 2, 1),
(1, 1, 2, 3, 10),
(50, 1, 1, 4, 3),
(300, 1, 1, 5, 4),
(150, 1, 1, 5, 5),
(500, 1, 1, 1, 1),
(200, 1, 1, 2, 2),
(50, 1, 1, 3, 3),
(300, 1, 1, 4, 4),
(150, 1, 1, 5, 5),
(500, 1, 1, 1, 1),
(200, 1, 1, 2, 2),
(50, 1, 1, 3, 3),
(300, 1, 1, 4, 4);


-- Tabla Adicionales
INSERT INTO features (featureDesc) VALUES 
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
INSERT INTO featuresByUser (pasoID, featureID) VALUES 
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

-- Tabla Personas
INSERT INTO Personas (perName, perLastName, perDoc, userID) VALUES 
    ('Juan', 'Perez', '12345678A', 1), 
    ('Ana', 'Gomez', '87654321B', 2), 
    ('Luis', 'Lopez', '12312312C', 3), 
    ('Maria', 'Garcia', '45645645D', 4), 
    ('Carlos', 'Ruiz', '78978978E', 5);

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
    (2, 5, 5),
    (5, 1, 1), 
    (4, 1, 2), 
    (3, 1, 3), 
    (5, 2, 4), 
    (2, 3, 5);

