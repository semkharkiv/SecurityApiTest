CREATE TABLE clients_roles
(
    user_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES clients (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);