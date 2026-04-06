package org.example;

import java.util.Arrays;

import static java.util.Arrays.toString;

public class LessonOne {
    // 1. Метод для печати трех слов в столбец
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // 2. Метод для проверки суммы двух чисел
    public static void checkSumSign() {
        int a = 15;
        int b = -8;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // 3. Метод для определения цвета по значению
    public static void printColor() {
        int value = 50;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    // 4. Метод для сравнения двух чисел
    public static void compareNumbers() {
        int a = 10;
        int b = 5;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // 5. Метод для проверки суммы в диапазоне 10-20
    public static boolean checkSumInRange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // 6. Метод для определения положительного или отрицательного числа
    public static void printNumberSign(int num) {
        if (num >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    // 7. Метод для проверки, является ли число отрицательным
    public static boolean isNegative(int num) {
        return num < 0;
    }

    // 8. Метод для печати строки N раз
    public static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // 9. Метод для проверки високосного года
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 10. Метод для замены 0 на 1 и 1 на 0 в массиве
    public static void swapBinaryArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Исходный массив:");
        printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }

        System.out.println("Массив после замены:");
        printArray(arr);
    }

    // 11. Метод для заполнения массива значениями 1-100
    public static void fillArrayWith1To100() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("Массив заполнен значениями от 1 до 100");
        System.out.println("Первые 10 элементов: " + Arrays.toString(java.util.Arrays.copyOfRange(arr, 0, 10)));
    }

    // 12. Метод для умножения элементов меньше 6 на 2
    public static void multiplyLessThan6() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив:");
        printArray(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }

        System.out.println("Массив после умножения элементов < 6 на 2:");
        printArray(arr);
    }

    // 13. Метод для заполнения диагонали квадратной матрицы единицами
    public static void fillDiagonalWithOnes() {
        int size = 5;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }

        System.out.println("Матрица с диагональю из единиц:");
        printMatrix(matrix);
    }

    // 14. Метод для создания массива с начальным значением
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    // Вспомогательный метод для печати массива
    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Вспомогательный метод для печати матрицы
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Main метод для вызова всех методов
    public static void main(String[] args) {
        System.out.println("=== 1. printThreeWords() ===");
        printThreeWords();

        System.out.println("\n=== 2. checkSumSign() ===");
        checkSumSign();

        System.out.println("\n=== 3. printColor() ===");
        printColor();

        System.out.println("\n=== 4. compareNumbers() ===");
        compareNumbers();

        System.out.println("\n=== 5. checkSumInRange(7, 5) ===");
        boolean result5 = checkSumInRange(7, 5);
        System.out.println("Результат: " + result5);

        System.out.println("\n=== 6. printNumberSign(42) ===");
        printNumberSign(42);

        System.out.println("\n=== 7. isNegative(-15) ===");
        boolean result7 = isNegative(-15);
        System.out.println("Число отрицательное: " + result7);

        System.out.println("\n=== 8. printString(\"Hello\", 3) ===");
        printString("Hello", 3);

        System.out.println("\n=== 9. isLeapYear() ===");
        System.out.println("2024 - високосный: " + isLeapYear(2024));
        System.out.println("2023 - високосный: " + isLeapYear(2023));
        System.out.println("2000 - високосный: " + isLeapYear(2000));
        System.out.println("1900 - високосный: " + isLeapYear(1900));

        System.out.println("\n=== 10. swapBinaryArray() ===");
        swapBinaryArray();

        System.out.println("\n=== 11. fillArrayWith1To100() ===");
        fillArrayWith1To100();

        System.out.println("\n=== 12. multiplyLessThan6() ===");
        multiplyLessThan6();

        System.out.println("\n=== 13. fillDiagonalWithOnes() ===");
        fillDiagonalWithOnes();

        System.out.println("\n=== 14. createArray(5, 7) ===");
        int[] arr14 = createArray(5, 7);
        System.out.println("Созданный массив: " + Arrays.toString(arr14));
    }
}
