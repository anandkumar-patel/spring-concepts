drop schema springboot cascade;
create schema if not exists springboot;

CREATE TABLE doctors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    specialty VARCHAR(100) NOT NULL
);
