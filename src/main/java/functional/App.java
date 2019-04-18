package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Supplier<List<Student>> supplyPredefinedStudents = App::createData;
        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<String> print = System.out::println;
        Function<Student, String> getStudentName = Student::getName;

        BiFunction<Student, String, Student> changeIndex = Student::changeIndexNumber;

        System.out.println("Imiona studentów z wykorzystaniem Function: ");
        consumerStudentsNew(filterStudents(supplyPredefinedStudents, over30), getStudentName, print);
        System.out.println("");

        Student studentPierwszy = supplyPredefinedStudents.get().get(1);
        Optional<Index> indeks = studentPierwszy.getIndeks();

        if (indeks.isPresent()) {
            System.out.println("Istnieje index: " + indeks.get().getIndexNumber());
        }

        indeks.ifPresent(ind -> {
            System.out.println(ind.getIndexNumber());
        });

        //indeks.orElse();
        //indeks.orElseGet(Supplier);

        if (indeks.isPresent()) {
            if (indeks.get().getIndexNumber().equals("223344"))
                System.out.println("Zgadza się numer indexu: " + indeks.get().getIndexNumber());
        }

        //zamiast tego powyżej można zrobić
        //Optional<Index> indddd = indeks.filter(i -> i.getIndexNumber().equals("223344"));  //lub to poniżej
        //indeks.filter(i -> i.getIndexNumber().equals("223344")).ifPresent(Consumer);

        indeks.map(i -> i.getIndexNumber()).filter(indexNumber -> indexNumber.equals("223344")).ifPresent(indexNumber -> System.out.println("Cos takiego: " + indexNumber));
    }

    private static void consumerStudentsNew(List<Student> students, Function<Student, String> function, Consumer<String> consumer) {
        for (Student s : students) {
            consumer.accept(function.apply(s));
        }
    }

    //     metoda z Supplier
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

    private static void consumerStudents(List<Student> students, Consumer<Student> consumer) {
        for (Student s : students) {
            consumer.accept(s);
        }
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
