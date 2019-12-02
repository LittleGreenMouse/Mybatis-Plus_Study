DELETE FROM user where 1;

INSERT INTO user (id, name, age, email, super_id) VALUES
(1, 'Jone', 18, 'test1@baomidou.com', null),
(2, 'Jack', 20, 'test2@baomidou.com', 1),
(3, 'Tom', 28, 'test3@baomidou.com', 2),
(4, 'Sandy', 21, 'test4@baomidou.com', 2),
(5, 'Billie', 24, 'test5@baomidou.com', 2);