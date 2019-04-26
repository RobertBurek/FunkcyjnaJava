package functional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<Object> print = System.out::println;
        Function<Student, String> getStudentName = Student::getName;

        System.out.println("Imiona wszystkich studentów alfabetycznie: ");
        createDataStream()
                .map(getStudentName)
                .sorted()
                .forEach(print);

    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Paweł", 31, "123456");
        Student robert = new Student("Robert B", 24, "223344");
        Student monika = new Student("Monika", 36);
        Student robert1 = new Student("Robert C", 33, "555555");
        Student ania = new Student("Anna", 40, "564534");
        Student zenek = new Student("Zenon", 28, "435688");
        return Stream.of(pawel, robert, monika, robert1, ania, zenek);
    }

}
