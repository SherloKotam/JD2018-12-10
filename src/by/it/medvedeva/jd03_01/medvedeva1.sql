-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema medvedeva1
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `medvedeva1` ;

-- -----------------------------------------------------
-- Schema medvedeva1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `medvedeva1` DEFAULT CHARACTER SET utf8 ;
USE `medvedeva1` ;

-- -----------------------------------------------------
-- Table `medvedeva1`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medvedeva1`.`roles` ;

CREATE TABLE IF NOT EXISTS `medvedeva1`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medvedeva1`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medvedeva1`.`users` ;

CREATE TABLE IF NOT EXISTS `medvedeva1`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `medvedeva1`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medvedeva1`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medvedeva1`.`ads` ;

CREATE TABLE IF NOT EXISTS `medvedeva1`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rooms` VARCHAR(45) NULL,
  `floor` INT NULL,
  `floors` INT NULL,
  `price` DOUBLE NULL,
  `area` DOUBLE NULL,
  `description` VARCHAR(4500) NULL,
  `adress` VARCHAR(45) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `medvedeva1`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `medvedeva1`.`houseads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `medvedeva1`.`houseads` ;

CREATE TABLE IF NOT EXISTS `medvedeva1`.`houseads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `groundsquare` DOUBLE NULL,
  `floors` INT NULL,
  `rooms` INT NULL,
  `area` DOUBLE NULL,
  `price` DOUBLE NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_houseads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_houseads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `medvedeva1`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `medvedeva1`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `medvedeva1`;
INSERT INTO `medvedeva1`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `medvedeva1`.`roles` (`id`, `role`) VALUES (DEFAULT, 'User');
INSERT INTO `medvedeva1`.`roles` (`id`, `role`) VALUES (DEFAULT, 'Guest');

COMMIT;

