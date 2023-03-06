CREATE TABLE users (
    id serial PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(1000) NOT NULL,
    is_locked BOOLEAN NOT NULL,
    is_enabled BOOLEAN NOT NULL,
    is_expired BOOLEAN NOT NULL,
    is_credentials_expired BOOLEAN NOT NULL,
    uuid VARCHAR(36) UNIQUE NOT NULL,
    email VARCHAR(100) NOT NULL
);