package KI305.Basystiuk.Lab3;

import java.time.LocalDate;

/**
 * Клас-драйвер для тестування класів Athlete та Human.
 */
public class HumanDriver {
    public static void main(String[] args) {
        // Очищення лог-файлу при запуску
        Human.clearLog();

        // Створення об'єктів Name, BirthInfo, Address
        Name name = new Name("Mariana", "Shevchenko");
        BirthInfo birthInfo = new BirthInfo(LocalDate.of(2000, 5, 15), "Lviv");
        Address address = new Address("Lviv", "Shevchenko Street", "Ukraine");
        Job job = new Job("Design", "IT");

        // Створення об'єкта Athlete
        Athlete athlete = new Athlete(name, birthInfo, address, job, "Біг", 5);

        // Виклик методів для демонстрації роботи
        System.out.println("\nAll Information about Athlete:");
        athlete.printAthleteInfo();
        athlete.train();

        // Закриття лог-файлу
        athlete.closeLog();
    }
}
