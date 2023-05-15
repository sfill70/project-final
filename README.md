## [REST API](http://localhost:8080/doc)

## Концепция:
- Spring Modulith
  - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
  - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
  - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```
- Есть 2 общие таблицы, на которых не fk
  - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
  - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем проверять

## Аналоги
- https://java-source.net/open-source/issue-trackers

## Тестирование
- https://habr.com/ru/articles/259055/

Список выполненных задач:

2. Удалить социальные сети: vk, yandex
   удалены кнопки login.html
   удалены настройки для в application.yaml
   handler  VkOAuth2UserDataHandler and YandexOAuth2UserDataHandler удалена анотация компонент классы оставлены
   Изменены настройки liquibase

3. перенесение из application.yaml datasource, OAuth и mail (user, password) (секция security)  в secret.yaml  
   replace datasource, OAuth and mail (user, password) from application.yaml in secret.yaml.
- данные считываются из переменной окружения машины - %SECRET_PROPERTY%, в ней указан путь к файлу secret.yaml
  с property
4.  Переделать тесты так, чтоб во время тестов использовалась in memory БД (H2), а не PostgreSQL. 
    Для этого нужно определить 2 бина, и выборка какой из них использовать должно определяться активным профилем Spring.

5.  Написать тесты для всех публичных методов контроллера ProfileRestController.

6. s
7. s
8. s
9. s
10. s
11. s
12. s
13. 

