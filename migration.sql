\c postgres

CREATE DATABASE prog2final;

\c prog2

create table "user"(
  id varchar(255) primary key default gen_random_uuid(),
  name Varchar(255) not null,
  email Varchar(255) not null,
  password Varchar(255) not null
);

create table "tag" (
  id varchar(255) primary key default gen_random_uuid(),
  name Varchar(255) not null
);

create table "project"(
  id varchar(255) primary key default gen_random_uuid(),
  name Varchar(255) not null,
  description text not null,
  status boolean not null default false,
  userId varchar(255) references "user"(id) not null
);

create table "task"(
  id varchar(255) primary key default gen_random_uuid(),
  title Varchar(255) not null,
  status boolean not null default false,
  startDate Date default current_date not null,
  endDate Date not null,
  priority int not null default 1 check (priority >= 1),
  userId varchar(255) references "user"(id) not null,
  projectId varchar(255) references "project"(id),
  tagId varchar(255) references "tag"(id) not null
);

create table "include" (
  id varchar(255) primary key default gen_random_uuid(),
  userId varchar(255) references "user"(id) not null,
  projectId varchar(255) references "project"(id) not null
);
