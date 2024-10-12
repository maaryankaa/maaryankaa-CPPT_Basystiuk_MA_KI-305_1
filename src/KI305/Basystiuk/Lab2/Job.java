package KI305.Basystiuk.Lab2;

/**
 * Внутрішній клас {@code Job} для збереження інформації про роботу людини.
 */
public class Job{
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
    /**
     * Метод для отримання інформації про роботу.
     *
     * @return інформація про роботу у форматі "посада, сфера".
     */
    public void fullJob() {
        Human.log("Отримано інформацію про роботу.");
        System.out.println("Робота: " + getJob() + ", " + getSphere());
    }
}