/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alberto.martin
 * Created: 4 nov 2026
 */

USE gestion_peliculas;

INSERT INTO peliculas (titulo, director, fecha_estreno, duracion_minutos, clasificacion_edad) VALUES 
('El Padrino', 'Francis Ford Coppola', '1972-03-24', 175, '+18'),
('Toy Story', 'John Lasseter', '1995-11-22', 81, 'TP'),
('Interstellar', 'Christopher Nolan', '2014-11-07', 169, '+7'),
('Buscando a Nemo', 'Andrew Stanton', '2003-05-30', 100, 'TP'),
('Matrix', 'Lana y Lilly Wachowski', '1999-03-31', 136, '+16'),
('El Rey León', 'Roger Allers', '1994-06-15', 88, 'TP'),
('El Señor de los Anillos: La Comunidad del Anillo', 'Peter Jackson', '2001-12-19', 178, '+12'),
('Jurassic Park', 'Steven Spielberg', '1993-06-11', 127, '+12'),
('Shrek', 'Andrew Adamson', '2001-05-18', 90, 'TP'),
('Spider-Man: Un nuevo universo', 'Bob Persichetti', '2018-12-14', 117, '+7');