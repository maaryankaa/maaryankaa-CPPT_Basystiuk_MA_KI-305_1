package KI305.Basystiuk.Lab2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Scanner;

/**
 * Клас {@code Human} представляє людину з іменем, інформацією про народження, адресою та даними про роботу.
 */
public class Human {
    private Name name;
    private BirthInfo birthInfo;
    private Address address;
    private Job job;
    private static PrintWriter logWriter;

    /**
     * Конструктор класу {@code Human}
     * @param name      ім'я людини
     * @param birthInfo інформація про народження
     * @param address   адреса проживання
     * @param job       дані про роботу
     */
    public Human(Name name, BirthInfo birthInfo, Address address, Job job) {
        this.name = name;
        this.birthInfo = birthInfo;
        this.address = address;
        this.job = job;
        try {
            logWriter = new PrintWriter(new BufferedWriter(new FileWriter("activityLog.txt", true)));
        } catch (IOException e) {
            System.err.println("Помилка відкриття файлу логів: " + e.getMessage());
        }
    }

    /**
     * Метод для перевірки, чи сьогодні день народження.
     *
     * @return {@code true}, якщо сьогодні день народження; {@code false} в іншому випадку.
     */
    public boolean isBirthdayToday() {
        LocalDate today = LocalDate.now();
        log("Перевірено, чи сьогодні день народження.");
        return today.getDayOfMonth() == birthInfo.getDateOfBirth().getDayOfMonth() && today.getMonth() == birthInfo.getDateOfBirth().getMonth();
    }

    /**
     * Метод для обчислення віку людини на основі дати народження.
     *
     * @return вік людини.
     */
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        log("Вік обчислено.");
        return Period.between(birthInfo.getDateOfBirth(), today).getYears();
    }

    /**
     * Метод для отримання повної адреси людини.
     *
     * @return повна адреса у форматі "місто, вулиця, країна".
     */
    public String fullAddress() {
        log("Отримано повну адресу.");
        return address.getCity() + ", " + address.getStreet() + ", " + address.getCountry();
    }

    /**
     * Метод для отримання інформації про роботу.
     *
     * @return інформація про роботу у форматі "посада, сфера".
     */
    public String fullJob() {
        log("Отримано інформацію про роботу.");
        return job.getJob() + ", " + job.getSphere();
    }

    /**
     * Метод для перевірки, чи є країна "Росією".
     *
     * @return {@code true}, якщо країна є "Росією", інакше {@code false}.
     */
    public boolean countryBan() {
        log("Перевірено, чи країна є Росією.");
        return !address.getCountry().equalsIgnoreCase("russia");
    }

    /**
     * Метод для обчислення часу до наступного дня народження.
     *
     * @return рядок, що містить кількість місяців і днів до наступного дня народження.
     */
    public String timeUntilNextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = birthInfo.getDateOfBirth().withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        Period untilNextBirthday = Period.between(today, nextBirthday);
        log("Обчислено час до наступного дня народження.");
        return "Місяців: " + untilNextBirthday.getMonths() + ", Днів: " + untilNextBirthday.getDays();
    }

    /**
     * Метод для виведення всієї інформації про людину.
     */
    public void printAllInfo() {
        System.out.println("Повне ім'я: " + getFullName());
        System.out.println("Дата народження: " + getDateOfBirth());
        System.out.println("Місце народження: " + birthInfo.getPlaceOfBirth());
        System.out.println("Чи сьогодні день народження: " + isBirthdayToday());
        System.out.println("Час до наступного дня народження: " + timeUntilNextBirthday());
        System.out.println("Вік: " + calculateAge());
        System.out.println("Адреса: " + fullAddress());
        System.out.println("Чи країна нормальна: " + countryBan());
        System.out.println("Робота: " + fullJob());
        log("Виведено всю інформацію.");
    }

    /**
     * Метод для отримання повного імені.
     *
     * @return повне ім'я у форматі "ім'я прізвище".
     */
    public String getFullName() {
        log("Отримано повне ім'я.");
        return name.getFirstName() + " " + name.getLastName();
    }

    /**
     * Метод для отримання дати народження.
     *
     * @return дата народження.
     */
    public LocalDate getDateOfBirth() {
        log("Отримано дату народження.");
        return birthInfo.getDateOfBirth();
    }

    /**
     * Метод для закриття лог-файлу.
     */
    public void closeLog() {
        if (logWriter != null) {
            logWriter.close();
        }
    }

    /**
     * Статичний метод для очищення лог-файлу.
     */
    public static void clearLog() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("activityLog.txt", false)))) {
            writer.print("");
            System.out.println("Файл логів очищено.");
        } catch (IOException e) {
            System.err.println("Помилка очищення файлу логів: " + e.getMessage());
        }
    }

    /**
     * Метод для запису повідомлення в лог-файл і виведення в консоль.
     *
     * @param message повідомлення для запису в лог.
     */
    public void log(String message) {
        logWriter.println(LocalTime.now() + ": " + message);
        logWriter.flush();
    }

    // Внутрішні класи Name, BirthInfo, Address, Job також можна прокоментувати таким чином:

    /**
     * Внутрішній клас {@code Name} для збереження імені та прізвища людини.
     */
    public static class Name {
        private final String firstName;
        private final String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    /**
     * Внутрішній клас {@code BirthInfo} для збереження дати і місця народження.
     */
    public static class BirthInfo {
        private final LocalDate dateOfBirth;
        private final String placeOfBirth;

        public BirthInfo(LocalDate dateOfBirth, String placeOfBirth) {
            this.dateOfBirth = dateOfBirth;
            this.placeOfBirth = placeOfBirth;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public String getPlaceOfBirth() {
            return placeOfBirth;
        }
    }

    /**
     * Внутрішній клас {@code Address} для збереження адреси людини.
     */
    public static class Address {
        private final String city;
        private final String street;
        private final String country;

        public Address(String city, String street, String country) {
            this.city = city;
            this.street = street;
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }

        public String getCountry() {
            return country;
        }
    }

    /**
     * Внутрішній клас {@code Job} для збереження інформації про роботу людини.
     */
    public static class Job {
        private final String job;
        private final String sphere;

        public Job(String job, String sphere) {
            this.job = job;
            this.sphere = sphere;
        }

        public String getJob() {
            return job;
        }

        public String getSphere() {
            return sphere;
        }
    }
}
