Запуск приложения:

1) откройте файл application.properties и в нем укажите данные для подключения к бд
spring.datasource.url=jdbc:mysql://localhost:3306/rgr_hibernate?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root

2)Измените путь для сохраннения изображений
upload.path = C:/img
И переместите туда дефолтные изображения из папки img проекта

3) При первом запуске программы в настройках hibernate укажите создание бд
spring.jpa.hibernate.ddl-auto=create
В дальнейшем create нужно заменить на validate
spring.jpa.hibernate.ddl-auto=validate

4)smtp можно оставить наше.

5)В миграции 2 создаются три тестовых пользователя,
Admin, Seller, Customer с уровнями доступа соответствующими их юзернейму
пароль от всех трех аккаунтов 1234

6)Демонстрационный вариант приложения доступен по ссылке(https пока не поддерживается!)
www.shoehub.design

