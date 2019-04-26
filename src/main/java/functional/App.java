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

        System.out.println("Imiona wszystkich studentów alfabetycznie ");
        createDataStream()
                .map(getStudentName)
                .sorted()
                .forEach(System.out::println);

        // 1
        System.out.println("Imiona studentów po MAP1: ");
        createDataStream()
                .filter(student -> student.getName().startsWith("Robert"))
                .filter(over30)
                .map(getStudentName)
                .map(String::toUpperCase)
                .forEach(print);

        // 2
        System.out.println("Imiona studentów po MAP2: ");
        createDataStream()
                .filter(over30)
                .map(Student::getName)// zdefiniowanie funcji zajmuje więcej miejsca niż sama logika funcji,
                // zatem można się jej pozbyć - getStudentName
                .filter(name -> name.startsWith("Robert"))
                .map(String::toUpperCase)
                .forEach(print);

        // 3 wypisanie indeksów studenta
        createDataStream()
                .map(student -> student.getIndeks())
                .filter(optionalIndex -> optionalIndex.isPresent())
                .map(optionalIndex -> optionalIndex.get())
                .map(index -> index.getIndexNumber())
                .forEach(print);

        // 4 zapis referencyjny //3
        createDataStream()
                .map(Student::getIndeks)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(Index::getIndexNumber)
                .forEach(print);
    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Paweł", 31, "123456");
        Student robert = new Student("Robert B", 24, "223344");
        Student monika = new Student("Monika", 36);
        Student robert1 = new Student("Robert C", 33, "555555");
        Student ania = new Student("Anna", 35, "564534");
        Student zenek = new Student("Zenon", 38, "435688");
        return Stream.of(pawel, robert, monika, robert1, ania, zenek);
    }

}
