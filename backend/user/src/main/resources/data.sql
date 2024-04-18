DROP DATABASE IF EXISTS reminder_db;
CREATE DATABASE reminder_db;
USE reminder_db;

CREATE TABLE tb_user
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE tb_reminder
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id     BIGINT,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    due_date    DATE,
    priority    VARCHAR(6)
) ENGINE = InnoDB;

CREATE TABLE tb_role
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE tb_user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES tb_user (id),
    FOREIGN KEY (role_id) REFERENCES tb_role (id)
) ENGINE = InnoDB;

CREATE TABLE tb_user_reminder
(
    user_id     BIGINT NOT NULL,
    reminder_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, reminder_id),
    FOREIGN KEY (user_id) REFERENCES tb_user (id),
    FOREIGN KEY (reminder_id) REFERENCES tb_reminder (id)
) ENGINE = InnoDB;

INSERT INTO tb_user (name, email, password)
VALUES ('Douglas', 'doug@email.com', '$2a$12$8oCXyJ.x8Ily4p3WkbNa5e4BJQJwlCOgpdvtDhA9Nnamc/dmxmXba'),
       ('Maria', 'maria@email.com', '$2a$12$8oCXyJ.x8Ily4p3WkbNa5e4BJQJwlCOgpdvtDhA9Nnamc/dmxmXba'),
       ('John', 'john@email.com', '$2a$12$8oCXyJ.x8Ily4p3WkbNa5e4BJQJwlCOgpdvtDhA9Nnamc/dmxmXba'),
       ('Chuck', 'chuck@email.com', '$2a$12$8oCXyJ.x8Ily4p3WkbNa5e4BJQJwlCOgpdvtDhA9Nnamc/dmxmXba'),
       ('Barry', 'barry@email.com', '$2a$12$8oCXyJ.x8Ily4p3WkbNa5e4BJQJwlCOgpdvtDhA9Nnamc/dmxmXba');

INSERT INTO tb_role (role_name)
VALUES ('ROLE_OPERATOR'),
       ('ROLE_ADMINISTRATOR');

INSERT INTO tb_user_role (user_id, role_id)
VALUES (1, 2),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1);

INSERT INTO tb_reminder (title, description, due_date, priority)
VALUES ('Ir ao supermercado', 'Comprar leite e batatas', CURRENT_DATE(), 'LOW'),
       ('Ir a farmácia', 'Comprar uma nova vitamina', CURRENT_DATE(), 'MEDIUM'),
       ('Levar o carro no mecânico', 'Carro com pane elétrica', CURRENT_DATE(), 'HIGH'),
       ('Ir ao dentista', 'Fazer avaliação', CURRENT_DATE(), 'MEDIUM');

INSERT INTO tb_user_reminder (user_id, reminder_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);
