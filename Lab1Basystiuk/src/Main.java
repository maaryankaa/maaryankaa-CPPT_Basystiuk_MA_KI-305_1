import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

 /** клас Main, виконує програму завдання згідно варіанту роботи */

public class Main {

    /** метод мейн - виконавчий метод */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /** Запитуємо розмір матриці */

        System.out.print("Введіть розмір квадратної матриці: ");
        int size = scanner.nextInt();
        scanner.nextLine();  // Очистка буферу після введення числа

        /** Запитуємо символ-заповнювач */
        System.out.print("Введіть символ-заповнювач: ");
        String input = scanner.nextLine();

        // Перевірка коректності введення символу
        if (input.length() != 1) {
            System.out.println("Помилка: потрібно ввести лише один символ.");
            return;
        }

        char fillChar = input.charAt(0);

        /**  Ініціалізуємо масив */
        char[][] array = new char[size][];

        /** Заповнюємо матрицю і виводимо її в консоль та файл */
        for (int i = 0; i < size; i++) {
            array[i] = new char[size - i];  // Зменшуємо кількість елементів у кожному рядку
            // Заповнення кожного рядка символами
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = fillChar;
            }
        }

        // Виведення масиву на екран
        System.out.println("Згенерований зубчастий масив:");
        for (int i = 0; i < size; i++) {
            // Спочатку виводимо пробіли для вирівнювання справа
            for (int k = 0; k < i; k++) {
                System.out.print("  ");
            }
            // Виводимо символи заповнювача
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // Запис масиву в текстовий файл
        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < size; i++) {
                for (int k = 0; k < i; k++) {
                    writer.write("  ");  // Записуємо пробіли для вирівнювання
                }
                for (int j = 0; j < array[i].length; j++) {
                    writer.write(array[i][j] + " ");
                }
                writer.write("\n");
            }
            System.out.println("Масив збережено у файл output.txt.");
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
