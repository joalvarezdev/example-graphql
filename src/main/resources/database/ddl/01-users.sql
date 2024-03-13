CREATE TABLE IF NOT EXISTS "users"(
    id SERIAL NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    user_id UUID NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT false,
    CONSTRAINT "pk_users" PRIMARY KEY (id)
);