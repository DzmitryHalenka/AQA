public class Task01 {
        public static void main(String[] args) {
            // Задача 1
            System.out.print("1. ");
            printThreeWords();

            // Задача 2
            System.out.print("\n"+"2. ");
            checkSumSign();

            // Задача 3
            System.out.print("\n"+"3. ");
            printColor();

            // Задача 4
            System.out.print("\n"+"4. ");
            compareNumbers();

            // Задача 5
            System.out.print("\n"+"5. ");
            System.out.println(isSumInRange(7, 8));  // Пример вызова

            // Задача 6
            System.out.print("\n"+"6. ");
            checkPositiveNegative(5);  // Пример вызова

            // Задача 7
            System.out.print("\n"+"7. ");
            System.out.println(isNegative(-5));  // Пример вызова

            // Задача 8
            System.out.print("\n"+"8. ");
            printStringMultipleTimes("Hello", 3);

            // Задача 9
            System.out.print("\n"+"9. ");
            System.out.println(isLeapYear(2024));  // Пример вызова

            // Задача 10
            System.out.print("\n"+"10. ");
            int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            flipArray(arr);

            // Задача 11
            System.out.print("\n"+"11. ");
            int[] filledArray = fillArray(100);

            // Задача 12
            System.out.print("\n"+"12. ");
            int[] arrToMultiply = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            multiplyLessThanSix(arrToMultiply);

            // Задача 13
            System.out.print("\n"+"13. ");
            int[][] squareMatrix = createSquareMatrix(5);  // Пример для 5x5
            fillDiagonalWithOnes(squareMatrix);

            // Задача 14
            System.out.print("\n"+"14. ");
            int[] newArray = createArray(5, 10);  // Пример длина 5 и начальное значение 10
        }

        // 1. Метод для вывода трех слов
        public static void printThreeWords() {
            System.out.println("Orange\n   Banana\n   Apple");
        }

        // 2. Метод для проверки суммы двух чисел
        public static void checkSumSign() {
            int a = 5, b = -3;
            int sum = a + b;
            if (sum >= 0) {
                System.out.println("Сумма положительная");
            } else {
                System.out.println("Сумма отрицательная");
            }
        }

        // 3. Метод для вывода цвета в зависимости от значения
        public static void printColor() {
            int value = 120;
            if (value <= 0) {
                System.out.println("Красный");
            } else if (value > 0 && value <= 100) {
                System.out.println("Желтый");
            } else if (value > 100){
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

        // 5. Метод для проверки суммы двух чисел в диапазоне от 10 до 20
        public static boolean isSumInRange(int a, int b) {
            int sum = a + b;
            return sum >= 10 && sum <= 20;
        }

        // 6. Метод для проверки положительности или отрицательности числа
        public static void checkPositiveNegative(int number) {
            if (number >= 0) {
                System.out.println("Положительное");
            } else {
                System.out.println("Отрицательное");
            }
        }

        // 7. Метод для проверки, является ли число отрицательным
        public static boolean isNegative(int number) {
            return number < 0;
        }

        // 8. Метод для вывода строки несколько раз
        public static void printStringMultipleTimes(String str, int times) {
            for (int i = 0; i < times; i++) {
                System.out.println(str);
            }
        }

        // 9. Метод для проверки високосного года
        public static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }

        // 10. Метод для инвертирования элементов массива (0 на 1, 1 на 0)
        public static void flipArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] == 0 ? 1 : 0;
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // 11. Метод для заполнения массива числами от 1 до 100
        public static int[] fillArray(int size) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = i + 1;
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return arr;
        }

        // 12. Метод для умножения чисел в массиве меньше 6 на 2
        public static void multiplyLessThanSix(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 6) {
                    arr[i] *= 2;
                }
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        // 13. Метод для создания квадратного массива и заполнения диагонали единицами
        public static int[][] createSquareMatrix(int size) {
            int[][] matrix = new int[size][size];
            return matrix;
        }

        public static void fillDiagonalWithOnes(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][i] = 1;  // Заполнение главной диагонали
            }
            for (int[] row : matrix) {
                for (int elem : row) {
                    System.out.print(elem + " ");
                }
                System.out.println();
            }
        }

        // 14. Метод для создания массива с одинаковыми значениями
        public static int[] createArray(int len, int initialValue) {
            int[] array = new int[len];
            for (int i = 0; i < len; i++) {
                array[i] = initialValue;
            }
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
            return array;
        }
}

// Во многих задачах нет условия вывода в консоль. Добавил для удобства проверки.