package KI305.Basystiuk.Lab3;

/**
 * Інтерфейс Training представляє метод для тренування спортсменів.
 */
interface Training {
    void train();
}
/**
 * Клас Athlete представляє спортсмена, який є підкласом Human.
 */
public class Athlete extends Human implements Training {
    private String sportType;
    private int experienceYears;

    /**
     * Конструктор класу Athlete.
     * @param name ім'я
     * @param birthInfo інформація про народження
     * @param address адреса
     * @param job робота
     * @param sportType вид спорту
     * @param experienceYears роки досвіду
     */
    public Athlete(Name name, BirthInfo birthInfo, Address address, Job job, String sportType, int experienceYears) {
        super(name, birthInfo, address, job);
        this.sportType = sportType;
        this.experienceYears = experienceYears;
    }

    /**
     * Метод для тренування, реалізований з інтерфейсу Training.
     */
    @Override
    public void train() {
        Human.log("Спортсмен тренується у виді спорту: " + sportType);
        System.out.println("Спортсмен тренується: " + sportType);
    }

    /**
     * Метод для виведення інформації про спортсмена.
     */
    public void printAthleteInfo() {
        super.printAllInfo();
        System.out.println("Вид спорту: " + sportType);
        System.out.println("Досвід у спорті (років): " + experienceYears);
    }
}
