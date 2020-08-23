DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), is_complete Boolean);
INSERT INTO tasks(name, is_complete) VALUES('Requirement Analysis', true);


DROP TABLE IF EXISTS user;
CREATE TABLE user(id  VARCHAR(50) PRIMARY KEY AUTO_INCREMENT, user_name VARCHAR(100), password VARCHAR(100),enable Boolean);
INSERT INTO user(id, user_name,password) VALUES('dev.usr', 'DEV User',MD5('Secrect@2020'), true);
INSERT INTO user(id, user_name,password) VALUES('adm.usr', 'Admin User',MD5('Secrect@2020'),true);


DROP TABLE IF EXISTS login;
CREATE TABLE login(id BIGINT PRIMARY KEY AUTO_INCREMENT, user_id  VARCHAR(50),security_token VARCHAR(250), expiry BIGINT);