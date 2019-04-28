package functional;


import java.util.Objects;
import java.util.Optional;

/**
 * Created by Robert Burek
 */

final public class Student implements Comparable<Student> {

    private String name;
    private int age;

    private Index index;

    public Student(String name, int age, String indexNumber) {
        this.name = name;
        this.age = age;
        this.index = new Index(indexNumber);
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return index.equals(student.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }
}