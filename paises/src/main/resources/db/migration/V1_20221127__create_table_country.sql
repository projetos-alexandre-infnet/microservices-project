create table if not exists country (
    id serial primary key,
    name varchar(255) not null,
    phone_code varchar(10) not null
);