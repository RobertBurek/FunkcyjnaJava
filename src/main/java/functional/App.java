package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Supplier<List<Student>> supplyPredefinedStudent = App::createData;
        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<String> print = System.out::println;
        Function<Student, String> getStudentName = Student::getName;
        BiFunction<Student, String, Student> changeIndex = Student::changeIndexNumber;
        System.out.println("Imiona studentów z wykorzystaniem Function: ");

        consumerStudentsNew(filterStudents(supplyPredefinedStudent, over30), getStudentName, print);


        System.out.println("");
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


    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Paweł", 31, "123456"));
        result.add(new Student("Robert", 24, "223344"));
        result.add(new Student("Monika", 36));
        result.add(new Student("Robert", 33, "555555"));
        return result;
    }

}
