package KI305.Basystiuk.Lab3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

/**
 * Абстрактний клас {@code Human} представляє людину з іменем, інформацією про народження, адресою та даними про роботу.
 */
public abstract class Human  {
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
    public static void log(String message) {
        logWriter.println(LocalTime.now() + ": " + message);
        logWriter.flush();
    }

    /**
     * Метод для виведення всієї інформації про людину.
     */
    public void printAllInfo() {
        name.getFullName();
        birthInfo.getDateOfBirth();
        birthInfo.getPlaceOfBirth();
        birthInfo.isBirthdayToday();
        birthInfo.timeUntilNextBirthday();
        birthInfo.calculateAge();
        address.fullAddress();
        address.countryBan();
        job.fullJob();
        Human.log("Виведено всю інформацію.");
    }
}