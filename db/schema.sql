CREATE TABLE user
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name       VARCHAR(255) NOT NULL
);

INSERT INTO user (id, name)VALUES (1, 'Sasha');
INSERT INTO user (id, name)VALUES (2, 'Masha');

CREATE TABLE profession
(
  id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name       VARCHAR(255) NOT NULL
);