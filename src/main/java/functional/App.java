package functional;

import java.util.function.*;
import java.util.stream.*;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<String> print = System.out::println;
        Function<Student, String> getStudentName = Student::getName;
        System.out.println("Imiona wszystkich studentów: ");
        createDataStream().filter(over30).map(getStudentName).forEach(print);

//     pełny zapis FILTER z implementacją metody test z interfejsu predicate
//        createDataStream().filter(new Predicate<Student>() {
//            @Override
//            public boolean test(Student student) {
//                return student.getName().equals("Robert");
//            }
//        }).forEach(System.out::println);

        createDataStream().filter(student -> student.getName().equals("Robert")).forEach(System.out::println);

//        można odfiltrować drugim filtrem
        createDataStream().filter(student -> student.getName().equals("Robert")).filter(over30).forEach(System.out::println);


    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Paweł", 31, "123456");
        Student robert = new Student("Robert", 24, "223344");
        Student monika = new Student("Monika", 36);
        Student robert1 = new Student("Robert", 33, "555555");
        return Stream.of(pawel,robert,monika,robert1);
    }

}
