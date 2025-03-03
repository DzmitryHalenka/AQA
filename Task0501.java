import java.util.ArrayList;
import java.util.List;

// Класс Student
class Student {
    private String name;
    private String group;
    private int course;
    private List<Double> grades;

    // Конструктор
    public Student(String name, String group, int course, List<Double> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    // Метод для расчета среднего балла
    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Метод для проверки, переведен ли студент
    public boolean isPromoted() {
        return calculateAverageGrade() >= 3.0;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

// Основной класс Task0501
public class Task0501 {
    public static void main(String[] args) {
        // Создаем список студентов
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов Александр", "Группа 101", 1, List.of(4.5, 3.7, 5.0)));
        students.add(new Student("Петрова Мария", "Группа 102", 2, List.of(2.8, 3.0, 4.2)));
        students.add(new Student("Сидорова Ирина", "Группа 103", 1, List.of(3.5, 4.0, 4.5)));

        // Удаляем студентов со средним баллом < 3.0
        removeUnderperformingStudents(students);

        // Переводим студентов на следующий курс, если их средний балл >= 3.0
        promoteStudents(students);

        // Выводим студентов, обучающихся на определенном курсе
        printStudents(students, 2); // Например, выводим студентов 2 курса
    }

    // Метод для удаления студентов со средним баллом < 3.0
    public static void removeUnderperformingStudents(List<Student> students) {
        students.removeIf(student -> !student.isPromoted());
    }

    // Метод для перевода студентов на следующий курс
    public static void promoteStudents(List<Student> students) {
        for (Student student : students) {
            if (student.isPromoted()) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Метод для вывода студентов определенного курса
    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты " + course + " курса:");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}