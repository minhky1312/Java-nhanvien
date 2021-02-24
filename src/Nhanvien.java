public class Nhanvien {
    private String name;
    private int age;
    private int salary;

    public Nhanvien(String name, int age, int salary) {
        this.name=name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

