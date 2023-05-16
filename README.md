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

6. Добавить новый функционал: добавления тегов к задаче. Фронт делать необязательно.
- в  TaskController добавлен POST метод addTagToTask, в TaskService метод addTagToTask
  маппинг "/{id}/tag", принимает данные формата JSON и данные форм.
- в TaskControllerRest добавлен PUT метод addTagToTask "/{id}/tags" принимает данные (array) формата JSON

7. Добавить возможность подписываться на задачи, которые не назначены на текущего пользователя.
- в  DashboardUIController добавлен метод addUserToTask, в TaskService метод addUserToTask
  маппинг "/task/{id}/user/{userId}", где {id} id - task, {userId} - id user
  пример (/task/2/user/1} добавляет task id=2, user id=1)
  маппинг "/task/{id}/user", принимает данные формата JSON, text, html, xml в виде String (Integer поддерживает только JSON).
8. s
9. s
10. s
11. s
12. s
13. 


