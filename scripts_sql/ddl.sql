/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alberto.martin
 * Created: 4 nov 2026
 */

CREATE DATABASE IF NOT EXISTS gestion_peliculas;
USE gestion_peliculas;

CREATE TABLE peliculas (
    id_pelicula INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    director VARCHAR(100) NOT NULL,
    fecha_estreno DATE,
    duracion_minutos INT CHECK (duracion_minutos > 0),
    clasificacion_edad VARCHAR(5) CHECK (clasificacion_edad IN ('TP', '+7', '+12', '+16', '+18'))
);