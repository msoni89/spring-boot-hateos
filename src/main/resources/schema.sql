DROP TABLE pin_code if EXISTS;

CREATE TABLE pin_code(
	id INT NOT NULL AUTO_INCREMENT,
	post_office_name VARCHAR(100),
	pin_code INT, city VARCHAR(100),
	district VARCHAR(100),
	state VARCHAR(100),
	PRIMARY KEY (id)
);