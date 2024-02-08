# Приложение для работы с сотрудниками
Проект представляет из себя реализацию приложения для работы с сотрудниками.

### В приложении реализованы следующие функции:
1. Добавление сотрудников
2. Удаление сотрудников
3. Изменение/редактирование сотрудников 
4. Получение всех сотрудников 
5. Поиск сотрудника по имени
6. Поиск сотрудника по id


### SQL запрос для создания базовой таблицы
```sql
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


