insert into users(id, username, password, verified, avatar, balance, email, first_name, second_name, wish_list_access, birthday)
            values(1, 'Artem', '$2y$12$h41PT44OGa0sbaDzivvMY.eIRodaqbJu8uxMb/ru7SV4dz6qMDj9u', true, 'user_default.jpg', 0, 'kostartem@yandex.ru', 'Артем', 'Костюченков', 'PUBLIC', '2020-05-31');

insert into user_roles(user_id, roles) values(1, 'ADMIN');