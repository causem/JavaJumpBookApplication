-- === PUBLISHERS ===
INSERT INTO publisher (name) VALUES ('Penguin Random House'); -- id = 1
INSERT INTO publisher (name) VALUES ('HarperCollins');        -- id = 2
INSERT INTO publisher (name) VALUES ('PWN');                  -- id = 3

-- === BOOKS ===
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Hobbit', 'J.R.R. Tolkien', 2);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Władca Pierścieni', 'J.R.R. Tolkien', 2);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Silmarillion', 'J.R.R. Tolkien', 2);

INSERT INTO book_entity (title, author, publisher_id) VALUES ('1984', 'George Orwell', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Folwark zwierzęcy', 'George Orwell', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Rok 451 Fahrenheita', 'Ray Bradbury', 1);

INSERT INTO book_entity (title, author, publisher_id) VALUES ('Solaris', 'Stanisław Lem', 3);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Cyberiada', 'Stanisław Lem', 3);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Bajki robotów', 'Stanisław Lem', 3);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Dzienniki gwiazdowe', 'Stanisław Lem', 3);

INSERT INTO book_entity (title, author, publisher_id) VALUES ('Mistrz i Małgorzata', 'Michaił Bułhakow', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Zbrodnia i kara', 'Fiodor Dostojewski', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Bracia Karamazow', 'Fiodor Dostojewski', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Idiota', 'Fiodor Dostojewski', 1);

INSERT INTO book_entity (title, author, publisher_id) VALUES ('Proces', 'Franz Kafka', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Zamek', 'Franz Kafka', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Przemiana', 'Franz Kafka', 1);

INSERT INTO book_entity (title, author, publisher_id) VALUES ('Duma i uprzedzenie', 'Jane Austen', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Emma', 'Jane Austen', 1);
INSERT INTO book_entity (title, author, publisher_id) VALUES ('Rozważna i romantyczna', 'Jane Austen', 1);
