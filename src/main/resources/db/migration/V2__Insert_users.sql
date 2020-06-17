insert into users(id, username, password, verified, avatar, balance, email, first_name, second_name, wish_list_access, birthday)
            values(1, 'Admin', '$2y$12$A0FTHWIb.IkFv2NRwVikgeT6wZytOotNbJmMBJ5d8OcVxooNWVJji', true,
             'user_default.jpg', 0, 'mitlg@yandex.ru', 'Админ', 'Магазина', 'PUBLIC', '2020-05-31');
insert into user_roles(user_id, roles) values(1, 'ADMIN');

insert into users(id, username, password, verified, avatar, balance, email, first_name, second_name, wish_list_access, birthday)
            values(2, 'Seller', '$2y$12$A0FTHWIb.IkFv2NRwVikgeT6wZytOotNbJmMBJ5d8OcVxooNWVJji', true,
             'user_default.jpg', 0, 'mitlg+1@yandex.ru', 'Seller', 'Магазина', 'PUBLIC', '2020-05-31');
insert into user_roles(user_id, roles) values(2, 'SELLER');

insert into users(id, username, password, verified, avatar, balance, email, first_name, second_name, wish_list_access, birthday)
            values(3, 'Customer', '$2y$12$A0FTHWIb.IkFv2NRwVikgeT6wZytOotNbJmMBJ5d8OcVxooNWVJji', true,
             'user_default.jpg', 0, 'mitlg+2@yandex.ru', 'Customer', 'Магазина', 'PUBLIC', '2020-05-31');
insert into user_roles(user_id, roles) values(3, 'CUSTOMER');
