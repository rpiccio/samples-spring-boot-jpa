CREATE TABLE activity (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name LONGTEXT DEFAULT NULL
);

CREATE TABLE action (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  activity_id BIGINT NOT NULL,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT action_fk1 FOREIGN KEY (activity_id) REFERENCES activity (id) ON DELETE CASCADE ON UPDATE RESTRICT
);

INSERT INTO activity (id, name) VALUES (1, 'Activity 1');
INSERT INTO activity (id, name) VALUES (2, 'Activity 2');
INSERT INTO activity (id, name) VALUES (3, 'Activity 3');

INSERT INTO action (id, activity_id, name) VALUES (1, 1, 'Action 1.1');
INSERT INTO action (id, activity_id, name) VALUES (2, 2, 'Action 2.1');
INSERT INTO action (id, activity_id, name) VALUES (3, 2, 'Action 2.2');
INSERT INTO action (id, activity_id, name) VALUES (4, 3, 'Action 3.1');
INSERT INTO action (id, activity_id, name) VALUES (5, 3, 'Action 3.2');
INSERT INTO action (id, activity_id, name) VALUES (6, 3, 'Action 3.3');
