CREATE TYPE status AS ENUM ('BANNED', 'VALID');
CREATE TABLE user_table
(
    id varchar(255) primary key,
    name varchar (255),
    email varchar (255),
    social varchar (100),
    register_at timestamp default current_timestamp,
    visited_at timestamp default current_timestamp,
    user_status status
)