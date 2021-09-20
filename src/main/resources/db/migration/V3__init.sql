DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id          bigserial primary key,
    name        varchar(255),
    email       varchar(255),
    social      varchar(100),
    register_at timestamp default current_timestamp,
    visited_at  timestamp default current_timestamp,
    user_status INTEGER
)