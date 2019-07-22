CREATE TABLE todo(
    id VARCHAR not null,
    text VARCHAR(100) not null ,
    is_complete BOOLEAN not null,
    primary key(id)
);