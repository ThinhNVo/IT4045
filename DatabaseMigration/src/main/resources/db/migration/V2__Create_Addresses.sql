create table Addresses
(
    id      bigint auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    state   varchar(255) null,
    zip     varchar(255) not null,
    user_id bigint       not null,
    constraint Addresses_users_id_fk
        foreign key (user_id) references users (id)
);

