-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema lyakhova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `lyakhova` ;

-- -----------------------------------------------------
-- Schema lyakhova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `lyakhova` DEFAULT CHARACTER SET utf8 ;
USE `lyakhova` ;

-- -----------------------------------------------------
-- Table `lyakhova`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`roles` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`users` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `contacts` VARCHAR(150) NULL,
  `roles_id` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `lyakhova`.`roles` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`tour_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`tour_type` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`tour_type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`place`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`place` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`place` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(100) NULL,
  `town` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`transport` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`housing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`housing` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`housing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`tours`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`tours` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`tours` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `tour_type_id` INT NULL,
  `place_id` INT NULL,
  `transport_id` INT NULL,
  `housing_id` INT NULL,
  `price` INT NULL,
  `date` VARCHAR(100) NULL,
  `duration` INT NULL,
  `hot` TINYINT NULL DEFAULT 0,
  `discount` INT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tours_place1`
    FOREIGN KEY (`place_id`)
    REFERENCES `lyakhova`.`place` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_tours_transport1`
    FOREIGN KEY (`transport_id`)
    REFERENCES `lyakhova`.`transport` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_tours_housing1`
    FOREIGN KEY (`housing_id`)
    REFERENCES `lyakhova`.`housing` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_tours_tour_type1`
    FOREIGN KEY (`tour_type_id`)
    REFERENCES `lyakhova`.`tour_type` (`id`)
    ON DELETE SET NULL
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lyakhova`.`tours_has_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lyakhova`.`tours_has_users` ;

CREATE TABLE IF NOT EXISTS `lyakhova`.`tours_has_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `users_id` INT NOT NULL,
  `tours_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_tours_has_users_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `lyakhova`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_tours_has_users_tours1`
    FOREIGN KEY (`tours_id`)
    REFERENCES `lyakhova`.`tours` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `lyakhova`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'administrator', 'all rights');
INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'editor', 'edit information');
INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'user', 'read, wright');
INSERT INTO `lyakhova`.`roles` (`id`, `role`, `description`) VALUES (DEFAULT, 'guess', 'watch');

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'petrov', 'petrov', 'petrov@mail.ru', 'petrov@mail.ru', 3);
INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'sidorov', 'sidorov', 'sidorov@mail.ru', 'sidorov@mail.ru', 2);
INSERT INTO `lyakhova`.`users` (`id`, `login`, `password`, `email`, `contacts`, `roles_id`) VALUES (DEFAULT, 'agadjanov', 'agadjanov', 'agadjanov@gmail.com', 'agadjanov@gmail.com', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`tour_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`tour_type` (`id`, `type`) VALUES (DEFAULT, NULL);
INSERT INTO `lyakhova`.`tour_type` (`id`, `type`) VALUES (DEFAULT, 'recreation');
INSERT INTO `lyakhova`.`tour_type` (`id`, `type`) VALUES (DEFAULT, 'cruise');
INSERT INTO `lyakhova`.`tour_type` (`id`, `type`) VALUES (DEFAULT, 'shopping');
INSERT INTO `lyakhova`.`tour_type` (`id`, `type`) VALUES (DEFAULT, 'excursion');

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`place`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Vietnam', 'Hanoi');
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Sri Lanka', 'Kolombo');
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Malaysia', 'Kuala Lumpur');
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Russia', 'Moscow');
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Poland', 'Warszawa');
INSERT INTO `lyakhova`.`place` (`id`, `country`, `town`) VALUES (DEFAULT, 'Latvia', 'Riga');

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`transport`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'aircraft');
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'bus');
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'car');
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'train');
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'boat');
INSERT INTO `lyakhova`.`transport` (`id`, `type`) VALUES (DEFAULT, 'cruise');

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`housing`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, NULL);
INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'hotel');
INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'apartment');
INSERT INTO `lyakhova`.`housing` (`id`, `type`) VALUES (DEFAULT, 'house');

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`tours`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 1', 2, 1, 1, 1, 600, '21.12.2019', 10, NULL, NULL);
INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 2', 1, 6, 2, 3, 100, '03.03.2019', 2, NULL, NULL);
INSERT INTO `lyakhova`.`tours` (`id`, `name`, `tour_type_id`, `place_id`, `transport_id`, `housing_id`, `price`, `date`, `duration`, `hot`, `discount`) VALUES (DEFAULT, 'tour 3', 2, 2, 3, 2, 2000, '01.03.2019', 7, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `lyakhova`.`tours_has_users`
-- -----------------------------------------------------
START TRANSACTION;
USE `lyakhova`;
INSERT INTO `lyakhova`.`tours_has_users` (`id`, `users_id`, `tours_id`) VALUES (DEFAULT, 1, 1);
INSERT INTO `lyakhova`.`tours_has_users` (`id`, `users_id`, `tours_id`) VALUES (DEFAULT, 2, 3);
INSERT INTO `lyakhova`.`tours_has_users` (`id`, `users_id`, `tours_id`) VALUES (DEFAULT, 1, 2);

COMMIT;

