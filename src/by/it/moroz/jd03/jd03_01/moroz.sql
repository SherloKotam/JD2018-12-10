-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema moroz
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `moroz` ;

-- -----------------------------------------------------
-- Schema moroz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `moroz` DEFAULT CHARACTER SET utf8 ;
USE `moroz` ;

-- -----------------------------------------------------
-- Table `moroz`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moroz`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `address` VARCHAR(100) NULL,
  `name` VARCHAR(100) NULL,
  `surname` VARCHAR(100) NULL,
  `numberphone` INT(12) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `moroz`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moroz`.`menu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`menu` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `moroz`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `moroz`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `menu_id` INT NOT NULL,
  `count` INT NULL,
  `check` DOUBLE NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_orders_users1_idx` (`users_id` ASC),
  INDEX `fk_orders_Menu1_idx` (`menu_id` ASC),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `moroz`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_orders_Menu1`
    FOREIGN KEY (`menu_id`)
    REFERENCES `moroz`.`menu` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `moroz`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `moroz`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `moroz`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'TrinzoA', 'qwerty123', 'trizzzno@gmail.com', 'Nezavisimosti, 54-84', 'Andrei', 'Trizno', 298563456, 2);
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, 'BorokhaM', 'borokha', NULL, NULL, 'Maria', 'Borokha', NULL, 1);
INSERT INTO `moroz`.`users` (`id`, `login`, `password`, `email`, `address`, `name`, `surname`, `numberphone`, `roles_id`) VALUES (DEFAULT, NULL, NULL, NULL, 'Kedishko, 3-1', 'Vladislau', 'Makarevich', 447568394, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `moroz`.`menu`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'steak', 29.6);
INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'pizza', 13.4);
INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'spaghetti', 11.6);
INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'salad', 9.3);
INSERT INTO `moroz`.`menu` (`id`, `name`, `price`) VALUES (DEFAULT, 'coffe', 5.0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `moroz`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `moroz`;
INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) VALUES (DEFAULT, 1, 2, 59.2, 1);
INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) VALUES (DEFAULT, 2, 1, 13.4, 1);
INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) VALUES (DEFAULT, 3, 2, 23.2, 1);
INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) VALUES (DEFAULT, 4, 1, 9.3, 3);
INSERT INTO `moroz`.`orders` (`id`, `menu_id`, `count`, `check`, `users_id`) VALUES (DEFAULT, 5, 1, 5.0, 3);

COMMIT;

