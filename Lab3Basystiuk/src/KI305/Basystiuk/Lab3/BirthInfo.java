package KI305.Basystiuk.Lab3;

import java.time.LocalDate;
import java.time.Period;

/**
 * Внутрішній клас {@code BirthInfo} для збереження дати і місця народження.
 */
public class BirthInfo {
    private LocalDate dateOfBirth;
    private String placeOfBirth;

    public BirthInfo(LocalDate dateOfBirth, String placeOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
    }

    public void getPlaceOfBirth() {
        System.out.println("Місце народження: " + placeOfBirth);
    }

    /**
     * Метод для обчислення віку людини на основі дати народження.
     *
     * @return вік людини.
     */
    public void calculateAge() {
        LocalDate today = LocalDate.now();
        Human.log("Вік обчислено.");
        System.out.println("Вік: " + Period.between(getDateOfBirth(), today).getYears());
    }

    /**
     * Метод для перевірки, чи сьогодні день народження.
     *
     * @return {@code true}, якщо сьогодні день народження; {@code false} в іншому випадку.
     */
    public void isBirthdayToday() {
        LocalDate today = LocalDate.now();
        Human.log("Перевірено, чи сьогодні день народження.");
        boolean isBirthdayToday = today.getDayOfMonth() == getDateOfBirth().getDayOfMonth()
                && today.getMonth() == getDateOfBirth().getMonth();
        System.out.println("Чи сьогодні день народження: " + isBirthdayToday);
    }

    /**
     * Метод для обчислення часу до наступного дня народження.
     *
     * @return рядок, що містить кількість місяців і днів до наступного дня народження.
     */
    public void timeUntilNextBirthday() {
        LocalDate today = LocalDate.now();
        LocalDate nextBirthday = getDateOfBirth().withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        Period untilNextBirthday = Period.between(today, nextBirthday);
        Human.log("Обчислено час до наступного дня народження.");
        System.out.println("Час до наступного дня народження: "
                +  "Місяців: " + untilNextBirthday.getMonths()
                + ", Днів: " + untilNextBirthday.getDays());
    }

    /**
     * Метод для отримання дати народження.
     *
     * @return дата народження.
     */
    public LocalDate getDateOfBirth() {
        Human.log("Отримано дату народження.");
        return dateOfBirth;
    }
}