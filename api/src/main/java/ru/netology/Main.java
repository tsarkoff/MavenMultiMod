package ru.netology;

public class Main {
    public static void main(String[] args) {
        System.out.println("CALL Main.main() from Child 'MavenMultiModuleProj.api'\n----------------");

        // под капотом:
        // 1. Текущий Модуль "api":
            // имея зависимости (dependencies) в своем pox.mml с Модулями "service" и "db"
            // создает объект new NyService(), находящийся в другом Модуле "service"
        // 2. Модуль "service" по умолчанию (в конструкторе, итд):
            // по зависимости (dependency) в своем pox.mml с Модулем "db" (database)
            // создает объекты из Модуля "db":
                // создает объект DbSetting из Модуля "db" (передает логин/парорль)
                // создает объект Db из Модуля "db" (передает DbSetting)
                // создает объект MyEntity (сущность) и передает его в Сеттер Db (database)
        // 3. Текущий Модуль "api":
            // выводит содержимое сущности MyEntity
            // по цепочке вызовов сквозь модули:
            // api.Main() -> service.myService.getEntity() -> db.db.getMyEntity();
        // 4. Текущий Модуль "api":
            // создает и устанавливает новый объект MyEntity (для наполнения из БД)
            // по цепочке вызовов сквозь модули:
            // api.Main() -> service.myService.setEntity(new MyEntity("second")) -> db.db.setMyEntity(myEntity.setId(UUID))
            // выводит содержимое новой сущности MyEntity
                // выводит факт установки сущности (SET)
                // выводит факт наличия текущей сущности (GET)

        MyService myService = new MyService();
        System.out.println(myService.getMyEntity());
        System.out.println(myService.setMyEntity(new MyEntity("second")));
        System.out.println(myService.getMyEntity());
    }
}