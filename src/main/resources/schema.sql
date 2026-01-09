drop table if exists ingredient cascade;
drop table if exists taco cascade;
drop table if exists taco_ingredient cascade;
drop table if exists taco_ingredients cascade;
drop table if exists taco_order cascade;
drop table if exists taco_order_tacos cascade;
drop table if exists ingredient_ref cascade;

create table if not exists taco_order
(
    id              bigserial primary key,
    delivery_name   varchar(50) not null,
    delivery_street varchar(50) not null,
    delivery_city   varchar(50) not null,
    delivery_state  varchar(2)  not null,
    delivery_zip    varchar(10) not null,
    cc_number       varchar(16) not null,
    cc_expiration   varchar(5)  not null,
    cccvv          varchar(3)  not null,
    placed_at       timestamp   not null
);

create table if not exists ingredient
(
    id   varchar(4)   primary key,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists taco
(
    id             bigserial primary key,
    name           varchar(50) not null,
    created_at     timestamp   not null,
    taco_order_id  bigint      not null references taco_order(id)
);

create table if not exists taco_ingredient
(
    taco_id bigint references taco(id),
    ingredient_id varchar(4) references ingredient(id)
);