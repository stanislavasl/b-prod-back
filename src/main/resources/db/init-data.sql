INSERT INTO PRODUCTS(id, name, category, description, quantity, price)
VALUES ('48a95af7-8b83-4a08-8001-0f865db8ea26', 'Iphone 13', 'Phone', 'Very cheap phone', 50, 1999.99),
       ('15a95af7-8b83-4a08-8001-0f865db8ea27', 'Samsung Z3', 'Phone', 'Cheap samsung phone', 50, 1239.99),
       ('ebdee4f9-5763-4afc-85ed-98b2fdefb35f', 'SmartTV', 'TV', 'LG smart tv', 10, 999.21),
       ('abdee4f9-5763-4afc-85ed-98b2fdefb35d', 'Snaige', 'Fridge', 'Kazkoks Snaige Firdge, jis dar prekyboje?', 1,
        198.98),
       ('58a95af7-8b83-4a08-8001-0f865db8ea26', 'Iphone 10', 'Phone', 'Very cheap phone', 10, 1999.99),
       ('98a95af7-8b83-4a08-8001-0f865db8ea26', 'iphone 9', 'Phone', 'Very cheap phone', 10, 699.99),
       ('45a95af7-8b83-4a08-8001-0f865db8ea27', 'Samsung Z2', 'Phone', 'Cheap samsung phone2', 22, 939.99),
       ('abdee4f9-5763-4afc-85ed-98b2fdefb35f', 'SmartTV', 'TV', 'LG smart tv', 55, 999.21),
       ('cbdee4f9-5763-4afc-85ed-98b2fdefb35d', 'LG', 'Fridge', 'Kazkoks Snaige Firdge, jis dar prekyboje?', 14,
        198.98),
       ('58a95af7-8b83-4a08-8001-0f865db8ea23', 'Iphone 12', 'Phone', 'Very cheap phone', 6, 1999.99),
       ('45a95af7-8b83-4a08-8001-0f865db8ea22', 'Samsung Z1', 'Phone', 'Cheap samsung phone1', 10, 839.99),
       ('bbdee4f9-5763-4afc-85ed-98b2fdefb35e', 'SmartTV', 'TV', 'Samsung smart tv', 66, 1999.00),
       ('cbdee4f9-5763-4afc-85ed-98b2fdefb31d', 'Samsung', 'Fridge', 'Samsung Firdge', 89, 198.98);

INSERT INTO USERS(id, username, name, surname, country, city, street, zip_code, phone, password)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', 'user', 'Useriukas', 'Useriauskas', 'Lithuania', 'Vilniaus',
        'Savanoriu', '572441', '867489665',
        '{bcrypt}$2a$10$jYIbAef1H7S.womsk7MRtOCSEx/DgM7CZ1nNeLLzoZ/OPs0a25DV2'), /*pass->user*/
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', 'admin', 'Adminas', 'Adminiauskas', 'Lithuania', 'Kaunas', 'Savanoriu',
        '572441', '867489665', '{bcrypt}$2a$10$VylYhXDaKC7W28tQTvYYkOdZIj2pnPVIobXOConbXy3xeBcF6Xuni'); /*pass->user*/

INSERT INTO ROLES(id, name)
VALUES ('60dbb7bb-99a0-42eb-a837-8be6b697c074', 'USER'),
       ('3906c549-44bf-494b-9537-5e1658a029a8', 'ADMIN');

INSERT INTO USERS_ROLES(user_id, roles_id)
VALUES ('c2aa5f20-2441-40f8-8cce-d31dbd17bc84', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '60dbb7bb-99a0-42eb-a837-8be6b697c074'),
       ('bd8968db-ad2a-4dd0-a0ab-7eebcc05427e', '3906c549-44bf-494b-9537-5e1658a029a8');
