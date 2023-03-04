# BookStoreApplicathion
На выполнение задания дается 4 дня с момента выдачи.

Для выполнения задания можно использовать
язык программирования Java/Kotlin/Groovy;
тестовый фреймворк TestNg/Junit;
сборка проекта Maven/Gradle;
для работы с UI можно использовать Selenide(https://selenide.org/) вместо Selenium

Объект тестирования - тестовое приложение Book Store Application (https://demoqa.com/books)
API тестового приложения - https://demoqa.com/swagger/

Обязательные требования:
описание UI части в коде выполнять с использованием паттерна Page Object
запуск тестов выполнить с поддержкой браузера Chrome
при использовании фреймворка Selenium для подключения вебдрайвера использовать библиотеку Webdrivermanager (https://github.com/bonigarcia/webdrivermanager). Подключить как бибилиотеку (https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.3.2). Библиотека позволяет автоматически скачать вебдрайвер нужной версии и не прикладывать файл в репозиторий
Основные действия в тесте сопроводить логированием с использованием любого логгера на выбор (Log4j или любой другой)

Критерий сдачи задания:
Результат работы выложить на GitHub и отправить линку на репозиторий. Репозиторий должен иметь уровень доступа Public (иметь возможность скачать и просмотреть код)
Код задания должен успешно компилироваться и запускаться после скачивания.

Задание 1:
Проверить основной функционал логина (возможность залогиниться) в веб прилолжение Book Store Application - https://demoqa.com/books.
Непосредственно пользователя возможно создать для теста с использованием существующего API приложения.

Задание 2:
Проверить что список книг на странице Book Store соответствует списку книг из API ответа. Для решения задачи использовать уже существующий список книг который представлен в приложении (https://demoqa.com/books). Сравнение книг выполнять по имени (Title).
