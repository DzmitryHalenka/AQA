import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task0502 {

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        // Добавляем корректные записи
        phoneDirectory.add("Иванов", "Иван", "123-456-789");
        phoneDirectory.add("Петров", "Петр", "987-654-321");
        phoneDirectory.add("Иванов", "Сергей", "555-555-555");
        phoneDirectory.add("Иванов", "Алексей", "111-222-333");

        // Некорректные записи (молча игнорируются)
        phoneDirectory.add("Сидоров", "", "999-999-999");
        phoneDirectory.add("Сидоров", "Дмитрий", "");
        phoneDirectory.add("", "Анна", "000-000-000");

        // Выводим записи
        phoneDirectory.printDirectory();
    }
}

class PhoneDirectory {
    private static class Person {
        String name;
        String phoneNumber;

        public Person(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return name + " (" + phoneNumber + ")";
        }
    }

    private final Map<String, List<Person>> directory = new HashMap<>();

    public void add(String surname, String name, String phoneNumber) {
        // Проверяем данные без вывода ошибок
        if (surname == null || surname.trim().isEmpty()) return;
        if (name == null || name.trim().isEmpty()) return;
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) return;

        // Добавляем запись
        directory.computeIfAbsent(surname, k -> new ArrayList<>())
                .add(new Person(name, phoneNumber));
    }

    // Метод для вывода справочника
    public void printDirectory() {
        for (Map.Entry<String, List<Person>> entry : directory.entrySet()) {
            String surname = entry.getKey();
            List<Person> people = entry.getValue();

            for (Person person : people) {
                System.out.println(surname + " " + person);
            }
        }
    }
}
// ошибки в консоль не выводил