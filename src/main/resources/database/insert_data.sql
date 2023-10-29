-- Добавляем клиентов
INSERT INTO clients (name, password, email, created_at, updated_at)
VALUES ('admin', 'admin_password', 'admin@example.com', "10-08-2023", "10-08-2023"),
       ('user1', 'user1_password', 'user1@example.com', "10-09-2023", "10-09-2023"),
       ('user2', 'user2_password', 'user2@example.com', "11-10-2023", "11-10-2023"),
       ('user3', 'user3_password', 'user3@example.com', "15-10-2023", "15-10-2023");

-- Добавляем роли
INSERT INTO roles (name) VALUES ('ADMIN'),('USER');
