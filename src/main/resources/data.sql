DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS tasks;
CREATE TABLE tasks(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), is_complete Boolean);
INSERT INTO tasks(name, is_complete) VALUES('Requirement Analysis', true);
commit;