-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- Insert tag data
INSERT INTO tag (id, name) VALUES
       (1, 'brown'),
       (2, 'geek'),
       (3, 'formal'),
       (4, 'blue'),
       (5, 'skin'),
       (6, 'red'),
       (7, 'action'),
       (8, 'sport'),
       (9, 'black'),
       (10, 'magic'),
       (11, 'green');



-- Insert data into `sock` without `imageUrls`
INSERT INTO sock (id, name, description, price, count) VALUES
       (1, 'Weave special', 'Limited issue Weave socks.', 17.15, 33),
       (2, 'Nerd leg', 'For all those leg lovers out there...', 7.99, 115),
       (3, 'Crossed', 'A mature sock, crossed, with an air of nonchalance.', 17.32, 738),
       (4, 'SuperSport XL', 'Ready for action. Engineers: be ready to smash that next bug!', 15.00, 820),
       (5, 'Holy', 'Socks fit for a Messiah.', 99.99, 1),
       (6, 'YouTube.sock', 'We were not paid to sell this sock. It''s just a bit geeky.', 10.99, 801),
       (7, 'Figueroa', 'enim officia aliqua excepteur esse deserunt quis aliquip nostrud anim', 14, 808),
       (8, 'Classic', 'Keep it simple.', 12, 127),
       (9, 'Colourful', 'proident occaecat irure et excepteur labore minim nisi amet irure', 18, 438),
       (10, 'Cat socks', 'consequat amet cupidatat minim laborum tempor elit ex consequat in', 15, 175);


-- Insert relationships into `sock_tag`
INSERT INTO sock_tag (sock_id, tag_id) VALUES
       (1, 2), (1, 9),
       (2, 4), (2, 5),
       (3, 4), (3, 6), (3, 7), (3, 3),
       (4, 8), (4, 9), (4, 3),
       (5, 10), (5, 7),
       (6, 2), (6, 3),
       (7, 3), (7, 11), (7, 4),
       (8, 1), (8, 11),
       (9, 1), (9, 4),
       (10, 1), (10, 11), (10, 3);

INSERT INTO imageurl (id, url) VALUES
       (1, '/catalogue/images/weave1.jpg'),
       (2, '/catalogue/images/weave2.jpg'),
       (3, '/catalogue/images/bit_of_leg_1.jpeg'),
       (4, '/catalogue/images/bit_of_leg_2.jpeg'),
       (5, '/catalogue/images/cross_1.jpeg'),
       (6, '/catalogue/images/cross_2.jpeg'),
       (7, '/catalogue/images/puma_1.jpeg'),
       (8, '/catalogue/images/puma_2.jpeg'),
       (9, '/catalogue/images/holy_1.jpeg'),
       (10, '/catalogue/images/holy_2.jpeg'),
       (11, '/catalogue/images/youtube_1.jpeg'),
       (12, '/catalogue/images/youtube_2.jpeg'),
       (13, '/catalogue/images/WAT.jpg'),
       (14, '/catalogue/images/WAT2.jpg'),
       (15, '/catalogue/images/classic.jpg'),
       (16, '/catalogue/images/classic2.jpg'),
       (17, '/catalogue/images/colourful_socks.jpg'),
       (18, '/catalogue/images/colourful_socks.jpg'),
       (19, '/catalogue/images/catsocks.jpg'),
       (20, '/catalogue/images/catsocks2.jpg');

INSERT INTO sock_imageurl (Sock_id, imageUrls_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4);

