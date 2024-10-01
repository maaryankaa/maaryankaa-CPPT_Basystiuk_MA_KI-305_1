package KI305.Basystiuk.Lab2;

import java.time.LocalDate;

/**
 * Клас-драйвер для тестування класу Human.
 */
public class HumanDriver {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Очищення лог-файлу при запуску
        Human.clearLog();

        // Створення об'єктів Name, BirthInfo, Address
        Human.Name name = new Human.Name("Mariana", "Shevchenko");
        Human.BirthInfo birthInfo = new Human.BirthInfo(LocalDate.of(2000, 5, 15), "Lviv");
        Human.Address address = new Human.Address("Lviv", "Shevchenko Street", "Ukraine");
        Human.Job job = new Human.Job("Design", "IT");


        // Створення об'єкта Human
        Human human = new Human(name, birthInfo, address,job);

        // Виклик методів для демонстрації роботи
        System.out.print("\nAll Information about object:");
        human.printAllInfo();
        

        // Закриття лог-файлу
        human.closeLog();
    }
}