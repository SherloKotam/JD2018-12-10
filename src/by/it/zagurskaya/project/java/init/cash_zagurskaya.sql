-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema zagurskaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zagurskaya` ;

-- -----------------------------------------------------
-- Schema zagurskaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zagurskaya` DEFAULT CHARACTER SET utf8 ;
USE `zagurskaya` ;

-- -----------------------------------------------------
-- Table `zagurskaya`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(50) NULL,
  `password` VARCHAR(50) NULL,
  `roleId` INT NOT NULL DEFAULT 2,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roleId` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roleId`)
    REFERENCES `zagurskaya`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`currencies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`currencies` (
  `id` INT NOT NULL,
  `iso` VARCHAR(45) NULL,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`accounts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mask` VARCHAR(20) NULL,
  `subMask` VARCHAR(20) NULL,
  `currencyId` INT NULL,
  `fullAccount` VARCHAR(28) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_accaunts_currencys1_idx` (`currencyId` ASC),
  CONSTRAINT `fk_accaunts_currencys1`
    FOREIGN KEY (`currencyId`)
    REFERENCES `zagurskaya`.`currencies` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`rateNB`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`rateNB` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currencyId` INT NOT NULL,
  `date` DATE NULL,
  `sum` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rateNB_currencys1_idx` (`currencyId` ASC),
  CONSTRAINT `fk_rateNB_currencys1`
    FOREIGN KEY (`currencyId`)
    REFERENCES `zagurskaya`.`currencies` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`rateCB`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`rateCB` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `coming` INT NOT NULL,
  `spending` INT NOT NULL,
  `timestamp` TIMESTAMP(6) NULL,
  `sum` DOUBLE NULL,
  `isBack` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rateCB_currencys1_idx` (`coming` ASC),
  INDEX `fk_rateCB_currencys2_idx` (`spending` ASC),
  CONSTRAINT `fk_rateCB_currencys1`
    FOREIGN KEY (`coming`)
    REFERENCES `zagurskaya`.`currencies` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_rateCB_currencys2`
    FOREIGN KEY (`spending`)
    REFERENCES `zagurskaya`.`currencies` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`sprOperations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`sprOperations` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `specification` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`sprEntries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`sprEntries` (
  `id` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `currencyId` INT NULL,
  `sprOperationsId` INT NOT NULL,
  `accountDebit` VARCHAR(28) NULL,
  `accountCredit` VARCHAR(28) NULL,
  `isSpending` TINYINT(1) NULL,
  `rate` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sprEntries_sprOperations1_idx` (`sprOperationsId` ASC),
  CONSTRAINT `fk_sprEntries_sprOperations1`
    FOREIGN KEY (`sprOperationsId`)
    REFERENCES `zagurskaya`.`sprOperations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`duties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`duties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `timestamp` TIMESTAMP(6) NULL,
  `number` INT NULL,
  `isClose` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_duties_users1_idx` (`userId` ASC),
  CONSTRAINT `fk_duties_users1`
    FOREIGN KEY (`userId`)
    REFERENCES `zagurskaya`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`usersOperations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`usersOperations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `timestamp` TIMESTAMP(6) NOT NULL,
  `rate` DOUBLE NOT NULL,
  `sum` DOUBLE NOT NULL,
  `currencyId` INT NOT NULL,
  `userId` INT NOT NULL,
  `dutiesId` INT NOT NULL,
  `operationId` INT NOT NULL,
  `specification` VARCHAR(100) NULL,
  `checkingAccount` VARCHAR(28) NULL,
  `fio` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_has_operations_users1_idx` (`userId` ASC),
  INDEX `fk_usersOperations_duties1_idx` (`dutiesId` ASC),
  CONSTRAINT `fk_users_has_operations_users1`
    FOREIGN KEY (`userId`)
    REFERENCES `zagurskaya`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_usersOperations_duties1`
    FOREIGN KEY (`dutiesId`)
    REFERENCES `zagurskaya`.`duties` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`kassa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`kassa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currencyId` INT NULL,
  `received` DOUBLE NULL,
  `coming` DOUBLE NULL,
  `spending` DOUBLE NULL,
  `transmitted` DOUBLE NULL,
  `balance` DOUBLE NULL,
  `userId` INT NOT NULL,
  `date` DATE NULL,
  `dutiesId` INT NOT NULL,
  INDEX `fk_kassa_users1_idx` (`userId` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_kassa_duties1_idx` (`dutiesId` ASC),
  CONSTRAINT `fk_kassa_users1`
    FOREIGN KEY (`userId`)
    REFERENCES `zagurskaya`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_kassa_duties1`
    FOREIGN KEY (`dutiesId`)
    REFERENCES `zagurskaya`.`duties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zagurskaya`.`usersEntries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `zagurskaya`.`usersEntries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `userOperationId` INT NOT NULL,
  `sprEntryId` INT NOT NULL,
  `currencyId` INT NOT NULL,
  `accountDebit` VARCHAR(28) NULL,
  `accountCredit` VARCHAR(28) NULL,
  `sum` DOUBLE NOT NULL,
  `isSpending` TINYINT(1) NOT NULL,
  `rate` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usersEntrys_usersOperations1_idx` (`userOperationId` ASC),
  CONSTRAINT `fk_usersEntrys_usersOperations1`
    FOREIGN KEY (`userOperationId`)
    REFERENCES `zagurskaya`.`usersOperations` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zagurskaya`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`roles` (`id`, `name`) VALUES (DEFAULT, 'admin');
INSERT INTO `zagurskaya`.`roles` (`id`, `name`) VALUES (DEFAULT, 'kassir');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Admin', 'Admin', 1);
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Ivanova', 'Ivanova', 2);
INSERT INTO `zagurskaya`.`users` (`id`, `login`, `password`, `roleId`) VALUES (DEFAULT, 'Petrova', 'Petrova', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`currencies`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`currencies` (`id`, `iso`, `name`) VALUES (840, 'USD', 'Долоры США');
INSERT INTO `zagurskaya`.`currencies` (`id`, `iso`, `name`) VALUES (933, 'BUR', 'Белорусский рубль');
INSERT INTO `zagurskaya`.`currencies` (`id`, `iso`, `name`) VALUES (978, 'EUR', 'Евро');
INSERT INTO `zagurskaya`.`currencies` (`id`, `iso`, `name`) VALUES (643, 'RUR', 'Российский рубль');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`accounts`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '1010', '933', 933, '1010000000933');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '1010', '840', 840, '1010000000840');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '1010', '978', 978, '1010000000978');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '6901', '840', 840, '6901000000840');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '6901', '978', 978, '6901000000978');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '6901', '643', 643, '6901000000643');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '6911', '933', 933, '6911000000933');
INSERT INTO `zagurskaya`.`accounts` (`id`, `mask`, `subMask`, `currencyId`, `fullAccount`) VALUES (DEFAULT, '3819', '998', 933, '3819000000000');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`rateNB`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`rateNB` (`id`, `currencyId`, `date`, `sum`) VALUES (DEFAULT, 840, '2018-02-01', 2.16);
INSERT INTO `zagurskaya`.`rateNB` (`id`, `currencyId`, `date`, `sum`) VALUES (DEFAULT, 978, '2018-02-01', 2.44);
INSERT INTO `zagurskaya`.`rateNB` (`id`, `currencyId`, `date`, `sum`) VALUES (DEFAULT, 643, '2018-02-01', 0.0324);
INSERT INTO `zagurskaya`.`rateNB` (`id`, `currencyId`, `date`, `sum`) VALUES (DEFAULT, 933, '2018-02-01', 1);
INSERT INTO `zagurskaya`.`rateNB` (`id`, `currencyId`, `date`, `sum`) VALUES (DEFAULT, 840, '2018-02-25', 2.161);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`rateCB`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 840, 933, '2018-02-01 10:03:11', 2.15, 0);
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 933, 840, '2018-02-01 10:03:11', 2.17, 1);
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 978, 933, '2018-02-01 10:03:11', 2.43, 0);
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 933, 978, '2018-02-01 10:03:11', 2.45, 1);
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 643, 933, '2018-02-01 10:03:11', 0.0321, 0);
INSERT INTO `zagurskaya`.`rateCB` (`id`, `coming`, `spending`, `timestamp`, `sum`, `isBack`) VALUES (DEFAULT, 933, 643, '2018-02-01 10:03:11', 0.0328, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`sprOperations`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`sprOperations` (`id`, `name`, `specification`) VALUES (1000, 'Подкрепление', '');
INSERT INTO `zagurskaya`.`sprOperations` (`id`, `name`, `specification`) VALUES (10, 'Покупка валюты', '');
INSERT INTO `zagurskaya`.`sprOperations` (`id`, `name`, `specification`) VALUES (20, 'Продажа валюты', '');
INSERT INTO `zagurskaya`.`sprOperations` (`id`, `name`, `specification`) VALUES (998, 'Коммунальный платеж', NULL);
INSERT INTO `zagurskaya`.`sprOperations` (`id`, `name`, `specification`) VALUES (1100, 'Инкассация', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`sprEntries`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (100001, 'Получено валюты', 840, 1000, '1011000000840', '1010000000840', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (100002, 'Получено валюты', 978, 1000, '1011000000978', '1010000000978', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (100003, 'Получено валюты', 643, 1000, '1011000000643', '1010000000643', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (100004, 'Получено валюты', 933, 1000, '1011000000933', '1010000000933', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (1001, 'Покупка валюты(840)', 840, 10, '1010000000840', '6901000000840', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (1003, 'Покупка валюты(978)', 978, 10, '1010000000978', '6901000000978', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (1005, 'Покупка валюты(643)', 643, 10, '1010000000643', '6901000000643', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (2001, 'Продажа валюты(840)', 840, 20, '6901000000840', '1010000000840', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (2003, 'Продажа валюты(978)', 978, 20, '6901000000978', '1010000000978', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (2005, 'Продажа валюты(643)', 643, 20, '690100000063', '1010000000643', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (2006, 'Рублевый эквивалент(643)', 933, 20, '1010000000643', '6911000000000', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (99801, 'Приход денежных средст в кассу', 933, 998, '1010000000933', '3819000000000', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (110001, 'Отправлено валюты', 840, 1100, '1010000000840', '1011000000840', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (110002, 'Отправлено валюты', 978, 1100, '1010000000978', '1011000000978', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (110003, 'Отправлено валюты', 643, 1100, '1010000000643', '1011000000643', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (110004, 'Отправлено валюты', 933, 1100, '1010000000933', '1011000000933', 1, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (99802, 'Приход денежных средст в кассу', 643, 998, '1010000000643', '3819000000643', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (99803, 'Приход денежных средст в кассу', 840, 998, '1010000000840', '3819000000840', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (99804, 'Приход денежных средст в кассу', 978, 998, '1010000000840', '3819000000978', 0, NULL);
INSERT INTO `zagurskaya`.`sprEntries` (`id`, `name`, `currencyId`, `sprOperationsId`, `accountDebit`, `accountCredit`, `isSpending`, `rate`) VALUES (1006, 'Рублевый эквивалент', 933, 10, '6911000000000', '1010000000933', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`duties`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`duties` (`id`, `userId`, `timestamp`, `number`, `isClose`) VALUES (DEFAULT, 2, '2018-02-01 10:11:02', 1, 0);
INSERT INTO `zagurskaya`.`duties` (`id`, `userId`, `timestamp`, `number`, `isClose`) VALUES (DEFAULT, 3, '2018-02-01 10:13:04', 1, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`usersOperations`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:12:13', 2.1, 1000, 840, 2, 1, 1000, 'Получены денежные средства', NULL, NULL);
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:13:13', 2.1, 100, 840, 2, 1, 10, 'В личное пользование', NULL, NULL);
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:14:13', 1, 56, 933, 2, 1, 998, 'За питание в СД№3', '3012000000005', NULL);
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:15:13', 2.1, 1000, 840, 3, 2, 1000, 'Получены денежные средства', NULL, NULL);
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:16:13', 2.15, 200, 840, 3, 2, 20, 'В личное пользование', NULL, NULL);
INSERT INTO `zagurskaya`.`usersOperations` (`id`, `timestamp`, `rate`, `sum`, `currencyId`, `userId`, `dutiesId`, `operationId`, `specification`, `checkingAccount`, `fio`) VALUES (DEFAULT, '2018-02-01 11:17:13', 1, 20, 933, 3, 2, 998, 'За мобильный телефор', '3012000000023', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`kassa`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 643, 0, 0, 0, 0, 0, 2, '2018-02-01', 1);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 840, 1000, 100, 0, 0, 1100, 2, '2018-02-01', 1);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 978, 0, 0, 0, 0, 0, 2, '2018-02-01', 1);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 933, 1000, 100, 210, 0, 690, 2, '2018-02-01', 1);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 643, 0, 0, 0, 0, 0, 3, '2018-02-01', 2);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 840, 1000, 0, 200, 0, 800, 3, '2018-02-01', 2);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 978, 0, 0, 0, 0, 0, 3, '2018-02-01', 2);
INSERT INTO `zagurskaya`.`kassa` (`id`, `currencyId`, `received`, `coming`, `spending`, `transmitted`, `balance`, `userId`, `date`, `dutiesId`) VALUES (DEFAULT, 933, 1000, 450, 0, 0, 1450, 3, '2018-02-01', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zagurskaya`.`usersEntries`
-- -----------------------------------------------------
START TRANSACTION;
USE `zagurskaya`;
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 1, 100001, 840, NULL, '1010000000840', 1000, 0, 2.1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 1, 100004, 933, NULL, '1010000000933', 1000, 0, 1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 2, 1001, 840, '1010000000840', '6901000000840', 100, 0, 2.1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 2, 1002, 933, '6911000000840', '1010000000933', 210, 1, 1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 3, 99801, 933, '1010000000933', '3819000000000', 56, 0, 1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 4, 10001, 840, '', '1010000000840', 1000, 0, 2.1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 4, 10004, 933, NULL, '1010000000933', 1000, 0, 2.1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 5, 2001, 840, '6901000000840', '1010000000840', 200, 1, 2.15);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 5, 2001, 933, '1010000000840', '6911000000840', 430, 0, 1);
INSERT INTO `zagurskaya`.`usersEntries` (`id`, `userOperationId`, `sprEntryId`, `currencyId`, `accountDebit`, `accountCredit`, `sum`, `isSpending`, `rate`) VALUES (DEFAULT, 6, 99801, 933, '1010000000933', '3819000000000', 20, 0, 1);

COMMIT;

