CREATE DATABASE  IF NOT EXISTS `meal_gpt`;
USE `meal_gpt`;

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `fitness_info`;
DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `gpt_plan`;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `user_name` varchar(50) NOT NULL,
                        `phone_number` varchar(50) NOT NULL,
                        `email` varchar(64) NOT NULL,
                        `password` char(80) NOT NULL,
                        `gender` VARCHAR(10) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--
-- Default passwords here are: fun123
--

INSERT INTO `user` (`user_name`,`phone_number`,`email`, `password`, `gender`)
VALUES
    ('john','0411222333','john@gmail.com','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','MALE'),
    ('mary','0422333444','mary@gmail.com','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','FEMALE'),
    ('susan','0433444555','susan@gmail.com','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','FEMALE');


--
--
-- Table Struture for `fitness info`
--
--

DROP TABLE IF EXISTS `fitness_info`;

CREATE TABLE `fitness_info` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `user_name` varchar(50) NOT NULL,
                                `height` DECIMAL(5, 2) NOT NULL,
                                `weight` DECIMAL(5, 2) NOT NULL,
                                `goal` varchar(255) NOT NULL,
                                `bio_gender` varchar(10) NOT NULL,
                                `age` INT NOT NULL,
                                `activity_level` VARCHAR(255) NOT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fitness_info`
--
--

INSERT INTO `fitness_info` (`user_name`, `height`,`weight`,`goal`, `bio_gender`, `age`, `activity_level`)
VALUES
    ('john', '172.3','70','more muscle','MALE','32','go to gym once a week'),
    ('mary','170.2','50','health','FEMALE','23', 'walk home'),
    ('susan','170.4','50','health','FEMALE','32', 'swim twice a week');

CREATE TABLE `authorities` (
                               `username` VARCHAR(20) NOT NULL,
                               `authority` VARCHAR(20) NOT NULL,
                               primary key (`username`)
);


INSERT INTO `authorities` (`username`, `authority`)
VALUES
    ('john', 'ROLE_USER'),
    ('mary', 'ROLE_USER'),
    ('susan', 'ROLE_USER');


CREATE TABLE `gpt_plan` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `user_name` varchar(50) NOT NULL,
                            `plan` VARCHAR(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

