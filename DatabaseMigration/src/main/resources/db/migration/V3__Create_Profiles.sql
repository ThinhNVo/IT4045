create table Profiles
(
    id              bigint                 not null
        primary key,
    bio             TEXT                   null,
    phone_number    varchar(15)            null,
    date_of_birth   date                   null,
    loyality_points int unsigned default 0 null,
    constraint Profiles_users_id_fk
        foreign key (id) references users (id)
);

