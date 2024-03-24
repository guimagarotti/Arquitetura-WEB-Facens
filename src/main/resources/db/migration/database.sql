-- Database: tasks

-- DROP DATABASE IF EXISTS tasks;

CREATE DATABASE students
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

    -- Table: public.categoria

-- DROP TABLE IF EXISTS public.categoria;

CREATE TABLE IF NOT EXISTS public.categoria
(
    id integer NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categoria
    OWNER to postgres;

-- Table: public.student

-- DROP TABLE IF EXISTS public.student;

CREATE TABLE IF NOT EXISTS public.student
(
    id bigint NOT NULL,
    name character varying COLLATE pg_catalog."default",
    lastName character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    cpf character varying COLLATE pg_catalog."default",
    hobby character varying COLLATE pg_catalog."default",
    categoria_id integer,
    CONSTRAINT student_pkey PRIMARY KEY (id),
    CONSTRAINT fk_student_categoria FOREIGN KEY (categoria_id)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT task_categoria_id_fkey FOREIGN KEY (categoria_id)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.student
    OWNER to postgres;