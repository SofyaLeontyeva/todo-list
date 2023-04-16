CREATE SEQUENCE hibernate_sequence;

create table person(
    id integer not null,
    name varchar(20),
    age integer,
    primary key(id)
);

create table task(
    id integer not null,
    header varchar(20),
    description varchar(100),
    status boolean,
    person_id integer,
    foreign key(person_id) references person
);