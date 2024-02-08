create table employees
(
    salary        integer,
    creation_time datetime(6),
    id            bigint not null auto_increment,
    department    varchar(255),
    name          varchar(255),
    surname       varchar(255),
    primary key (id)
);

insert into employees(salary, creation_time, department, name, surname)
values (2300, current_date, 'IT', 'Artem', 'Sidorov'), (1900, current_date, 'HR', 'Olga', 'Smirnova');
