package KI305.Basystiuk.Lab3;

public class Address {
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
    /**
     * Метод для отримання повної адреси людини.
     *
     * @return повна адреса у форматі "місто, вулиця, країна".
     */
    public void fullAddress() {
        Human.log("Отримано повну адресу.");
        System.out.println("Адреса: " + getCity()
                + ", " + getStreet()
                + ", " + getCountry());
    }
    /**
     * Метод для перевірки, чи є країна "Росією".
     *
     * @return {@code true}, якщо країна є "Росією", інакше {@code false}.
     */
    public void countryBan() {
        Human.log("Перевірено, чи країна є Росією.");
        System.out.println("Чи країна нормальна: " + !getCountry().equalsIgnoreCase("russia"));
    }
}