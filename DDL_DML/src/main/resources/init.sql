CREATE TABLE IF NOT EXISTS homework (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS lesson (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    update_at DATE,
    homework_id INTEGER,
    FOREIGN KEY (homework_id) REFERENCES homework(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS schedule(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    update_at DATE
);

--many to many relationship
CREATE TABLE IF NOT EXISTS schedule_lesson(
    id_lesson INTEGER REFERENCES lesson(id),
    id_schedule INTEGER REFERENCES schedule(id),
    CONSTRAINT schedule_lesson_pk PRIMARY KEY (id_lesson, id_schedule)
);

--DDL operation CREATE ALTER DROP RENAME

ALTER TABLE schedule_lesson RENAME TO lesson_schedule;

ALTER TABLE homework ADD COLUMN count_task INTEGER;

ALTER TABLE homework DROP COLUMN count_task;

DROP TABLE IF EXISTS homework;

--DML operation SELECT INSERT UPDATE DELETE
INSERT INTO homework (name, description)
VALUES ('homework1', 'Вивчити мову SQL'),
       ('homework2', 'Виконати приклади №5/6/8'),
       ('homework3', 'Вивчити вірш'),
       ('homework4', 'Передивитись запис курсу');

INSERT INTO lesson (name, update_at, homework_id)
VALUES ('Курс Java Pro', '2023-12-10', 1),
       ('Курс Java Pro', '2023-12-15', 4),
       ('Алгебра', '2023-12-03', 2),
       ('Українська література', '2023-12-13', 3);

INSERT INTO schedule(name, update_at)
VALUES ('schedule1', '2023-12-20'),
       ('schedule1', '2023-12-25'),
       ('schedule1', '2024-01-15');

INSERT INTO schedule_lesson(id_lesson, id_schedule)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 3),
       (3, 2),
       (3, 3),
       (4, 3);

SELECT * FROM homework;
SELECT * FROM schedule;

SELECT lesson.*
FROM schedule_lesson
JOIN lesson ON schedule_lesson.id_lesson = lesson.id
WHERE schedule_lesson.id_schedule = 2;

UPDATE homework
SET description = 'Виконати дз16 з курсу'
WHERE name = 'homework4';

INSERT INTO homework (name, description)
VALUES  ('homework5', 'description');

SELECT * FROM homework;

DELETE FROM homework
WHERE id = 5;

SELECT * FROM homework;