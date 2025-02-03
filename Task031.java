import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    protected String name;
    protected static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isFull = true;
            System.out.println(name + " покушал и теперь сыт.");
        } else {
            System.out.println(name + " не смог покушать, еды недостаточно.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + food + " еды.");
    }

    public int getFoodAmount() {
        return food;
    }
}

public class Task031 {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurka = new Cat("Мурка");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(150);
        catMurka.run(200);
        dogBobik.swim(5);
        catMurka.swim(5);

        Bowl bowl = new Bowl(15);
        List<Cat> cats = new ArrayList<>();
        cats.add(catMurka);
        cats.add(catBarsik);

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        bowl.addFood(20);
        catBarsik.eat(bowl, 10);

        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());
        System.out.println("Всего животных: " + Animal.getAnimalCount());
    }
}
