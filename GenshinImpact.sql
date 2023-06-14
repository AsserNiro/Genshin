
create table holy_relic
(
    id         int identity
        constraint holy_relic_pk
        primary key,
    name       varchar(20) not null,
    type       int         not null,
    provide_hp int         not null
)
    go

create table weapon
(
    id         int identity
        constraint weapon_pk
        primary key,
    name       varchar(20) not null,
    type       int         not null,
    provide_hp int         not null
)
    go

create table role
(
    id            int identity
        constraint role_pk
        primary key,
    name          varchar(20) not null,
    introduce     varchar(200),
    base_hp       int         not null,
    holy_relic_id int
        constraint role_holy_relic_id_fk
            references holy_relic,
    weapon_id     int
        constraint role_weapon_id_fk
            references weapon
)
    go

