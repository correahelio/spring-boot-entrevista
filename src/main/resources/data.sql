DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS logs;

CREATE TABLE clients (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) UNIQUE NOT NULL
);

CREATE TABLE logs (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    log VARCHAR(250) NOT NULL
);

CREATE TABLE products (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    codigo INT UNIQUE NOT NULL,
    description VARCHAR(250) NOT NULL
);

INSERT INTO clients (name) VALUES
    ('Joao'),
    ('Maria'),
    ('Joana');

INSERT INTO products (codigo, description) VALUES
  (10, 'Monitor'),
  (20, 'Notebook'),
  (30, 'Copo');