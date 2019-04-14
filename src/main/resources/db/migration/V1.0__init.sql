CREATE DATABASE IF NOT EXISTS `realtime_notifer` /*!40100 COLLATE 'latin1_swedish_ci' */;

CREATE TABLE IF NOT EXISTS `realtime_notifer`.`test` (
	`id_test` INT NULL
)
COLLATE='latin1_swedish_ci'
;

CREATE TABLE IF NOT EXISTS `user_session` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`session_token` VARCHAR(255) NOT NULL,
	`user_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UKf1d22cgr6y2s3kx6tcqqn8h2v` (`session_token`, `user_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;


INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionA', '1');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionB', '1');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionC', '2');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionD', '3');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionE', '3');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionF', '3');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionG', '4');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionH', '5');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionI', '5');
INSERT IGNORE INTO `realtime_notifer`.`user_session` (`session_token`, `user_id`) VALUES ('sessionJ', '5');