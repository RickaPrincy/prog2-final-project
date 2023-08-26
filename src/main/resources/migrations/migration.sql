\c postgres

CREATE DATABASE prog2final;

\c prog2final

create table "user"(
  id serial primary key,
  name varchar(255) not null,
  email varchar(255) not null,
  password varchar(255) not null
);

create table "tag" (
  id serial primary key ,
  name varchar(255) not null
);

create table "project"(
  id serial primary key,
  name varchar(255) not null,
  description text not null,
  status boolean default false not null,
  startDate timestamp default current_timestamp not null,
  endDate timestamp not null,
  userId int references "user"(id) not null
);

create table "task"(
  id serial primary key,
  title varchar(255) not null,
  status boolean default false not null,
  startDate timestamp default current_timestamp not null,
  endDate timestamp not null,
  priority int default 1 check (priority >= 1) not null,
  userId int references "user"(id) not null,
  projectId int references "project"(id) not null,
  tagId int references "tag"(id) not null
);

create table "include" (
  id serial primary key,
  userId int references "user"(id) not null,
  projectId int references "project"(id) not null
);
