package KI305.Basystiuk.Lab2;

/**
 * Внутрішній клас {@code Name} для збереження імені та прізвища людини.
 */
public class Name {
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
    /**
     * Метод для отримання повного імені.
     *
     * @return повне ім'я у форматі "ім'я прізвище".
     */
    public void getFullName() {
        Human.log("Отримано повне ім'я.");
        System.out.println("Повне ім'я: " + getFirstName() + " " + getLastName());
    }
}