
С помощью spring boot, gradle создать сервис вет клиники.
Для хранения MongoDB, spring data MongoDB. Представление реализовать в веб интерфейсе.

Задачи:
- [x] Перечитать про REST.
- [x] Продумать модель данных (Врачи, Пациенты, Клиенты, МедКарта, Записи к врачу)
- [x] Прочитать про Hibernate, JPA, Sprint Repository
- [x] Разобраться как Spring Data Repository связан с Hibernate
- [x] Прочитать, какие аналоги есть у Hibernate
- [x] Прочитать, что такое Mongodb
- [x] Попробовать подключиться к mongodb через консоль
- [x] Создать коллекции в БД.
- [x] Использовать свою БД для проекта

- [x] Научиться делать GET
- [x] Научиться делать POST
- [x] Научиться делать PATCH
- [x] Научиться делать DELETE
- [x] Научиться делать PUT
- [x] Переделать PATCH на PUT

- [x] Реализовать линию "Клиент"
- [x] Реализовать линию "Доктор"
- [x] Реализовать линию "Пациент"
- [x] Реализовать линию "Медицинская карта"
- [x] Реализовать линию "Запись к доктору"

Структура БД:
- [x] список врачей(ФИО)
- [x] список клиентов(ФИО)
- [x] запись клиента ко врачу(дата и время)
- [x] список мед карт пациентов (кличка, порода, цвет)

- [ ] Настроить взаимосвязи эллементов БД(Не дублировать данные, наследоваться от родительских).
  - [ ] для Doctor
  - [ ] для Client
  - [ ] для Patient
  - [ ] для MedicalCard

Слой представлений:
- [ ] Главная страница(страница со списком имеющихся регистраций)
- [ ] Страница создания новых регистраций
- [ ] Страница работы с данными докторов
- [ ] Страница для работы с данными клиентов
- [ ] Страница с медицинской карточкой (формируется в процессе приёма, врачём)


Реализовать возможность:
- [ ] Прикрепление файла анализов к мед карте(фото/документ)
- [ ] Выгрузка отчета о посещениях в формате xlsx(отчёт файлом, агрегированный)
- [ ] Количество посещений по врачам

