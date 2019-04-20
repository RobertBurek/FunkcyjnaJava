package functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Supplier<List<Student>> supplyPredefinedStudent = App::createData;
        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<String> print = System.out::println;
        Consumer<Integer> printWiek = System.out::println;
        Function<Student, String> getStudentName = Student::getName;
        Function<Student, Integer> getStudentAge = Student::getAge;
        BiFunction<Student, String, Student> changeIndex = Student::changeIndexNumber;
        System.out.println("Imiona studentów >30lat z wykorzystaniem STREAMa: ");

//        consumerStudentsNew(filterStudents(supplyPredefinedStudent, over30), getStudentName, print);

//       supplyPredefinedStudent.get().stream().filter(over30).map(getStudentName).forEach(print);

//        1) budowa streama z predefiniowanych wartości, poprzez deklarowanie danych
        Stream.of("A", "B", "C", "D", "E", "F").forEach(print);

//       2) budowa streama na kolekcji
        List<Student> studentList = createData();
        Stream<Student> studentStream = studentList.stream();
        studentStream.filter(over30).map(getStudentName).forEach(print);

//       3) generowanie streama na podstawie SUPPLIERa - losowe 10 wyników double
        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);

//       4) nieskończony (tutaj 20 elementów) strumien na postawie iterate
        Stream.iterate(0, i -> i + 2).limit(20).forEach(System.out::println);

//       5) strumienia prymitywów LONG, DOUBLE (metoda range - bez ostatniej wartości)
        IntStream.rangeClosed(5, 100).filter(i -> i % 2 == 0).forEach(System.out::println);

//        6) zmodyfikowana metoda createDataStream() pozwala stworzyć streama
        Stream<Student> streamStudent = createDataStream();
        streamStudent.forEach(System.out::println);


    }

    private static void consumerStudentsNew(List<Student> students, Function<Student, String> function, Consumer<String> consumer) {
        for (Student s : students) {
            consumer.accept(function.apply(s));
        }
    }

    private static List<Student> filterStudents(Supplier<List<Student>> supplier, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();

        List<Student> students = supplier.get();
        for (Student s : students) {
            if (predicate.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

//    modyfikacja metody aby zwracała nie liste a streama
    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Paweł", 31, "123456");
        Student robert = new Student("Robert", 24, "223344");
        Student monika = new Student("Monika", 36);
        Student robert1 = new Student("Robert", 33, "555555");
        return Stream.of(pawel,robert,monika,robert1);
    }

    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Paweł", 31, "123456"));
        result.add(new Student("Robert", 24, "223344"));
        result.add(new Student("Monika", 36));
        result.add(new Student("Robert", 33, "555555"));
        return result;
    }

}
