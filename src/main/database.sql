CREATE DATABASE IF NOT EXISTS studentdb;

USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    course VARCHAR(100) NOT NULL
);

INSERT INTO students(name, email, course)
VALUES
('Rahul', 'rahul@gmail.com', 'Java'),
('Priya', 'priya@gmail.com', 'Python'),
('Amit', 'amit@gmail.com', 'Docker');
('Manoj', 'manoj@gmail.com', 'react')