CREATE TABLE IF NOT EXISTS `spring`.`users` (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `enabled` INT NOT NULL,
    PRIMARY KEY(`username`)
);

CREATE TABLE IF NOT EXISTS `spring`.`authorities` (
    `username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_user FOREIGN KEY (`username`) REFERENCES `users`(`username`)
);