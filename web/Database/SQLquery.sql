CREATE DATABASE University;

USE University;

CREATE TABLE user (
  userId int AUTO_INCREMENT PRIMARY KEY,
  name varchar(50),
  email varchar(50) NOT NULL,  
  pwd varchar(50) NOT NULL
);

INSERT INTO user (name, email, pwd)
VALUES
('Braulio Sandi', 'braulio.sandi@university.com', 'Admin$1234'),
('Jason Taylor', 'jason.taylor@university.com', 'Admin$1234');

CREATE TABLE careers (
  id int AUTO_INCREMENT PRIMARY KEY,
  grade varchar(100) NOT NULL,
  name varchar(100) NOT NULL,
  description varchar(500) NOT NULL,  
  category varchar(100) NOT NULL,
  photo varchar(500) NOT NULL
);

INSERT INTO careers (grade, name, description, category, photo) VALUES 
('Licenciatura', 'Ingeniería en Inteligencia Artificial', 'Especialidad enfocada en el diseño de algoritmos de aprendizaje automático, procesamiento de lenguaje natural y automatización de procesos.', 'Tecnología', 'https://usil-blog.s3.amazonaws.com/PROD/blog/image/inteligencia-artificial.jpg'),
('Licenciatura', 'Diseño de Experiencia de Usuario (UX/UI)', 'Carrera centrada en optimizar la usabilidad, accesibilidad e interacción entre los usuarios y las plataformas digitales.', 'Diseño y Arte', 'https://blog.uvm.mx/hubfs/Blog_Contenido/UG/que-es-un-dise%C3%B1ador-de-experiencia.jpg'),
('Maestría', 'Dirección de Empresas de Energías Renovables', 'Programa ejecutivo enfocado en la gestión de proyectos sostenibles, eficiencia energética y legislación ambiental.', 'Negocios', 'https://www.santanderopenacademy.com/es/blog/energia-renovable-empresas/_jcr_content/root/container/responsivegrid/image_1170526714.coreimg.jpeg/1738140090886/energia-renovable-empresas-3.jpeg'),
('Licenciatura', 'Biotecnología Médica', 'Estudio de sistemas biológicos y organismos vivos para el desarrollo de tecnologías y fármacos que mejoren la salud humana.', 'Ciencia y Salud', 'https://images.ecestaticos.com/6bCplDjr00tyMKgzqF1A-T6ZiYo=/0x0:2121x1414/1200x900/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F06e%2F999%2F4e2%2F06e9994e2f8ac3122ef0499d57a1ea7e.jpg');

CREATE TABLE courses (
  courseId int AUTO_INCREMENT PRIMARY KEY,  
  careerId int,  
  category varchar(100) NOT NULL,
  name varchar(100) NOT NULL,
  credits int
);

INSERT INTO courses (careerId, category, name, credits) VALUES
-- Categoría: Programación y Desarrollo
(1, 'Programación', 'Fundamentos de Programación', 4),
(1, 'Programación', 'Programación Orientada a Objetos', 4),
(1, 'Programación', 'Estructuras de Datos Avanzadas', 5),
(1, 'Programación', 'Desarrollo Web Front-End', 3),
(1, 'Programación', 'Desarrollo Web Back-End', 4),
(1, 'Programación', 'Programación Móvil Multiplataforma', 4),
(1, 'Programación', 'Paradigma de Programación Funcional', 3),

-- Categoría: Ingeniería de Software
(1, 'Ingeniería de Software', 'Introducción a la Ingeniería de Software', 3),
(1, 'Ingeniería de Software', 'Análisis y Modelado de Requerimientos', 4),
(1, 'Ingeniería de Software', 'Diseño y Arquitectura de Software', 4),
(1, 'Ingeniería de Software', 'Pruebas y Aseguramiento de Calidad (QA)', 3),
(1, 'Ingeniería de Software', 'Gestión de Proyectos Ágiles (Scrum)', 3),
(1, 'Ingeniería de Software', 'DevOps y Despliegue Continuo (CI/CD)', 4),

-- Categoría: Datos e Información
(1, 'Bases de Datos', 'Fundamentos de Bases de Datos Relacionales', 4),
(1, 'Bases de Datos', 'Bases de Datos Avanzadas y NoSQL', 4),
(1, 'Datos', 'Introducción a la Ciencia de Datos', 3),
(1, 'Datos', 'Minería de Datos y Big Data', 4),

-- Categoría: Infraestructura y Redes
(1, 'Infraestructura', 'Sistemas Operativos', 4),
(1, 'Infraestructura', 'Redes y Conectividad de Computadoras', 4),
(1, 'Infraestructura', 'Fundamentos de Computación en la Nube', 3),
(1, 'Infraestructura', 'Seguridad Informática y Criptografía', 4),

-- Categoría: Ciencias de la Computación e IA
(1, 'Ciencias de la Computación', 'Matemáticas Discretas', 4),
(1, 'Ciencias de la Computación', 'Análisis y Diseño de Algoritmos', 5),
(1, 'Ciencias de la Computación', 'Teoría de la Computación y Autómatas', 3),
(1, 'Inteligencia Artificial', 'Introducción a la Inteligencia Artificial', 4),
(1, 'Inteligencia Artificial', 'Machine Learning Aplicado', 4),

-- Categoría: Gestión y Proyectos Finales
(1, 'Gestión', 'Gobernanza de TI y Arquitectura Empresarial', 3),
(1, 'Gestión', 'Ética y Legislación Informática', 2),
(1, 'Proyectos', 'Taller de Innovación y Emprendimiento Tecnológico', 3),
(1, 'Proyectos', 'Proyecto Integrador I (Capston Project)', 4),
(1, 'Proyectos', 'Proyecto Integrador II (Tesis/Práctica)', 6),
(1, 'Gestión', 'Liderazgo y Habilidades Blandas para Ingenieros', 2);