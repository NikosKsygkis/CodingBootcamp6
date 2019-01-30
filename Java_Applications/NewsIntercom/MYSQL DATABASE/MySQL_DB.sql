CREATE DATABASE `newsintercom`;

USE `newsintercom`;

CREATE TABLE `user`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(25) NOT NULL,
    `password` VARCHAR(25) NOT NULL,
    `fname` VARCHAR(45) NOT NULL,
    `lname` VARCHAR(45) NOT NULL,
    `creation_date` DATETIME NOT NULL,
    `is_online` BOOLEAN NOT NULL,
    UNIQUE KEY(`username`),
    PRIMARY KEY(`id`)
);

CREATE TABLE `loginfo`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT,
    `login` DATETIME NOT NULL,
    `logout`DATETIME,
    
    PRIMARY KEY(`id`),
    FOREIGN KEY(`user_id`) REFERENCES `newsintercom`.`user`(`id`) ON DELETE SET NULL
);

CREATE TABLE `userroles`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT,
    `administrator` BOOLEAN NOT NULL,
    `editor` BOOLEAN NOT NULL,
    `writer` BOOLEAN NOT NULL,
    PRIMARY KEY(`id`),
    UNIQUE KEY(`user_id`),
    FOREIGN KEY(`user_id`) REFERENCES `newsintercom`.`user`(`id`) ON DELETE SET NULL
);

CREATE TABLE `messages`(
	`id` INT NOT NULL AUTO_INCREMENT,
    `reply_id` INT,
    `creator_id` INT,
    `receiver_id` INT,
    `creator_username` VARCHAR(25),
    `receiver_username` VARCHAR(25),
    `title` VARCHAR(130),
    `mdata` VARCHAR(250) NOT NULL,
    `submit_date` DATETIME NOT NULL,
    `is_read` BOOLEAN NOT NULL,
    `is_creator_active` BOOLEAN NOT NULL,
	`is_receiver_active` BOOLEAN NOT NULL,
    PRIMARY KEY(`id`),
	FOREIGN KEY(`reply_id`) REFERENCES `newsintercom`.`messages`(`id`) ON DELETE SET NULL,
    FOREIGN KEY(`creator_id`) REFERENCES `newsintercom`.`user`(`id`) ON DELETE SET NULL,
    FOREIGN KEY(`receiver_id`) REFERENCES `newsintercom`.`user`(`id`) ON DELETE SET NULL
   
);

SET @@global.time_zone = '+00:00';

SET @@session.time_zone = '+00:00';

insert into `user`(`username`, `password`, `fname`, `lname`, `creation_date`,`is_online`)
VALUES ('admin','admin','nikos','ksygkis', '2018-12-16 00:00:00',false);

insert into `userroles`(`user_id`,`administrator`, `editor`, `writer`) 
VALUES(1,true,false,false);

insert into `user`(`username`, `password`, `fname`, `lname`, `creation_date`,`is_online`)
VALUES ('editor1','editor1','John','Doe', '2018-12-16 00:00:00',false);

insert into `userroles`(`user_id`,`administrator`, `editor`, `writer`) 
VALUES(2,false,true,false);

insert into `user`(`username`, `password`, `fname`, `lname`, `creation_date`,`is_online`)
VALUES ('editor2','editor2','Mary','Mckinley', '2018-12-16 00:00:00',false);

insert into `userroles`(`user_id`,`administrator`, `editor`, `writer`) 
VALUES(3,false,true,false);

insert into `user`(`username`, `password`, `fname`, `lname`, `creation_date`,`is_online`)
VALUES ('writer1','writer1','George','Cassidy', '2018-12-16 00:00:00',false);

insert into `userroles`(`user_id`,`administrator`, `editor`, `writer`) 
VALUES(4,false,false,true);

insert into `user`(`username`, `password`, `fname`, `lname`, `creation_date`,`is_online`)
VALUES ('writer2','writer2','Trevor','Gibbs', '2018-12-16 00:00:00',false);

insert into `userroles`(`user_id`,`administrator`, `editor`, `writer`) 
VALUES(5,false,false,true);