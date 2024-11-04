// Define an interface with a default method
interface Greetable {
    void greet();
    default void farewell() {
        System.out.println("Goodbye!");
    }
}

// Base class for different types of employees
abstract class Employee implements Greetable {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Abstract method to be implemented by subclasses
    public abstract void work();

    // Demonstrate polymorphism
    public void getPaid() {
        System.out.println(name + " is paid " + salary);
    }
}

// Developer subclass with overridden methods and unique behavior
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }

    @Override
    public void greet() {
        System.out.println("Hello, I am a Developer named " + name + ".");
    }
}

// Manager subclass with overridden methods and unique behavior
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println(name + " is managing a team of " + teamSize + " people.");
    }

    @Override
    public void greet() {
        System.out.println("Hello, I am a Manager named " + name + ".");
    }
}

// Main class demonstrating usage
public class Main {
    public static void main(String[] args) {
        // Create objects of Developer and Manager using polymorphism
        Employee dev = new Developer("George", 10, "Java");
        Employee mgr = new Manager("Paul", 20, 5);

        // Demonstrate polymorphism
        dev.greet();
        dev.work();
        dev.getPaid();
        dev.farewell();

        System.out.println();

        mgr.greet();
        mgr.work();
        mgr.getPaid();
        mgr.farewell();

        System.out.println();

        // Using a lambda expression to create a Runnable
        Runnable task = () -> System.out.println("Task running in a separate thread!");
        new Thread(task).start();

        // Exception handling demo
        try {
            riskyOperation();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    // Method that throws an exception to demonstrate error handling
    public static void riskyOperation() throws Exception {
        throw new Exception("Something went wrong in riskyOperation!");
    }
}