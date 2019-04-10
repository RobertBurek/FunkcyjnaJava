package functional;


import java.util.Optional;

/**
 * Created by Robert Burek
 */

final public class Student {

    private String name;
    private int age;

    private Index index;

    public Student(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.index = new Index(indexNumber);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Optional<Index> getIndeks() {
        return Optional.ofNullable(this.index);
    }

    public String getStudentInformation() {
        return this.name + " " + this.age;
    }

    public Student changeIndexNumber(String newIndexNumber) {
        return new Student(this.name, this.age, newIndexNumber);
    }
}