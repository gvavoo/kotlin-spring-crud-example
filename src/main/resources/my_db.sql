drop database if exists `my_db`;

create database `my_db` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

use `my_db`;

create table if not exists `user`(
	`id` serial primary key,
    `email` varchar(255) not null unique,
    `first_name` varchar(50) not null,
    `last_name` varchar(100) not null,
    `phone` varchar(20) not null
);


INSERT INTO user(id, email, first_name, last_name, phone) VALUES ('1', 'test@test.com', 'Jim', 'Smith', '+302345434876');
INSERT INTO user(id, email, first_name, last_name, phone) VALUES ('2', 'test2@test.com', 'Jack', 'Smith', '+302666634876');
INSERT INTO user(id, email, first_name, last_name, phone) VALUES ('3', 'john@test.com', 'John', 'Adams', '+302666655876');