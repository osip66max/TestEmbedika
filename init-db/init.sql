create table car
(
    id     integer,
    number varchar,
    brand  varchar,
    model  varchar,
    color  varchar,
    year   integer
);

alter table car
    owner to postgres;
