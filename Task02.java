public class Task02 {
    public static void main(String[] args) {
        // Создаем массив сотрудников
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван", "Инженер", "ivanov@mail.com", "892312312", 30000, 30);
        employees[1] = new Employee("Петров Петр", "Менеджер", "petrov@mail.com", "891612312", 35000, 35);
        employees[2] = new Employee("Сидоров Алексей", "Разработчик", "sidorov@mail.com", "899912312", 50000, 28);
        employees[3] = new Employee("Козлов Сергей", "Аналитик", "kozlov@mail.com", "892622312", 40000, 40);
        employees[4] = new Employee("Морозова Анна", "Дизайнер", "morozova@mail.com", "890512312", 32000, 25);

        System.out.println("Список сотрудников:");
        for (Employee emp : employees) {
            emp.printInfo();
        }

        // Создаем парк с аттракционами
        Park park = new Park("Летний парк", 3);
        park.addAttraction(0, "Колесо обозрения", "10:00-22:00", 500);
        park.addAttraction(1, "Американские горки", "11:00-23:00", 700);
        park.addAttraction(2, "Комната страха", "12:00-21:00", 400);

        System.out.println("\nИнформация о парке:");
        park.printAttractions();
    }
}

// Класс "Сотрудник"
class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println("--------------------");
    }
}

// Класс "Парк" с внутренним классом "Аттракцион"
class Park {
    private String name;
    private Attraction[] attractions;

    public Park(String name, int attractionCount) {
        this.name = name;
        this.attractions = new Attraction[attractionCount];
    }

    public void addAttraction(int index, String name, String workingHours, double price) {
        if (index >= 0 && index < attractions.length) {
            attractions[index] = new Attraction(name, workingHours, price);
        }
    }

    public void printAttractions() {
        System.out.println("Парк: " + name);
        for (Attraction attraction : attractions) {
            if (attraction != null) {
                attraction.printInfo();
            }
        }
    }

    // Внутренний класс "Аттракцион"
    class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("--------------------");
        }
    }
}
