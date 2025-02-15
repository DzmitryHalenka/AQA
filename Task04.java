public class Task04 {

    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"5", "6", "7"},
                {"8", "9", "10"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Пример с корректным массивом
        try {
            System.out.println("Сумма: " + sumArray(validArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // Пример с некорректным размером
        try {
            System.out.println("Сумма: " + sumArray(invalidSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }

        // Пример с некорректными данными
        try {
            System.out.println("Сумма: " + sumArray(invalidDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] array) {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        // Суммирование элементов
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

// Пользовательские исключения
class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Ошибка размера: массив должен быть 4x4");
    }
}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int col) {
        super(String.format("Ошибка данных в ячейке [%d][%d]", row, col));
    }
}