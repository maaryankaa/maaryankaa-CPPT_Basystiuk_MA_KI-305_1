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
        Name name = new Name("Mariana", "Shevchenko");
        BirthInfo birthInfo = new BirthInfo(LocalDate.of(2000, 5, 15), "Lviv");
        Address address = new Address("Lviv", "Shevchenko Street", "Ukraine");
        Job job = new Job("Design", "IT");

        // Створення об'єкта Human
        Human human = new Human(name, birthInfo, address,job);

        // Виклик методів для демонстрації роботи
        System.out.println("\nAll Information about object:");
        human.printAllInfo();

        // Закриття лог-файлу
        human.closeLog();
    }
}