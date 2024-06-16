DROP DATABASE IF EXISTS bookvault;

CREATE DATABASE bookvault;

USE bookvault;

CREATE TABLE IF NOT EXISTS events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(255) NOT NULL,
    event_type ENUM('KIDS_STORY', 'MOVIE_NIGHT', 'WORKSHOP', 'BOOK_LAUNCH') NOT NULL,
    event_description TEXT,
    event_activities TEXT,
    admission_fees DECIMAL(4, 2) NOT NULL
    
);

INSERT INTO events (event_name, event_type, event_description, event_activities, admission_fees) VALUES
    ('Kids Story Time 1', 'KIDS_STORY', 'A fun storytelling session for kids', 'Storytelling, games', 3.00),
    ('Kids Story Time 2', 'KIDS_STORY', 'Another exciting storytelling event for kids', 'Storytelling, activities', 3.00),
    ('Movie Night 1', 'MOVIE_NIGHT', 'Enjoy a movie night under the stars', 'Movie screening, snacks', 7.50),
    ('Movie Night 2', 'MOVIE_NIGHT', 'An indoor movie night for all ages', 'Movie screening, popcorn', 7.50),
    ('Workshop 1', 'WORKSHOP', 'Learn new skills in a hands-on workshop', 'Interactive sessions, learning materials', 15.00),
    ('Workshop 2', 'WORKSHOP', 'A creative workshop for aspiring artists', 'Art supplies provided, guidance from professionals', 15.00),
    ('Book Launch 1', 'BOOK_LAUNCH', 'Join us for the launch of an exciting new book', 'Book signing, author meet-and-greet', 2.00),
    ('Book Launch 2', 'BOOK_LAUNCH', 'Be the first to get your hands on a highly anticipated book', 'Exclusive access, limited edition copies', 2.00),
    ('Kids Story Time 3', 'KIDS_STORY', 'Another fun storytelling session for kids', 'Storytelling, interactive games', 3.00),
    ('Movie Night 3', 'MOVIE_NIGHT', 'A family-friendly movie night for everyone', 'Movie screening, family activities', 7.50),
    ('Workshop 3', 'WORKSHOP', 'Expand your knowledge with our expert-led workshop', 'Specialized training, certificates provided', 15.00),
    ('Book Launch 3', 'BOOK_LAUNCH', 'Celebrate the release of a groundbreaking new book', 'Book reading, live music', 2.00),
    ('Kids Story Time 4', 'KIDS_STORY', 'Join us for more exciting stories and adventures', 'Storytelling, creative activities', 3.00),
    ('Movie Night 4', 'MOVIE_NIGHT', 'Experience the magic of cinema with our movie night', 'Blockbuster movie, cinematic experience', 7.50),
    ('Workshop 4', 'WORKSHOP', 'Unlock your potential with our inspirational workshop', 'Personal development, goal setting', 15.00);
