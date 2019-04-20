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

        List<Student> students = supplyPredefinedStudent.get();

       // students.stream().filter(over30).map(getStudentName).forEach(print);
//        powyższy stream jest do wykorzystania tylko raz, tylko raz można przeiterować,
//         próba kolejnego użycia tego strumienia daje wyjątek IllegalStateException
//           co poniżej udowniłem
//        Stream<Student> studentStream= students.stream();
//        studentStream.filter(over30).map(getStudentName).forEach(print);
//        studentStream.forEach(student -> student.getAge());

        // students.stream().filter(over30).map(getStudentName).forEach(print);
        // zapis powyżej mógłby wyglądać w sposób tradycyjny tak jak poniżej
//        List<Student> data = createData();
//        for(Student s: data) {
//            if(s.getAge()>30) {
//                String name = s.getName();
//                System.out.println(name);
//            }
//        }

        students.stream().filter(over30).map(getStudentName).forEach(print);

        System.out.println("");

        System.out.println("Imiona wszystkich studentów z wykorzystaniem STREAMa: ");
        students.stream().map(getStudentName).forEach(print);
        System.out.println("");
        System.out.println("Wiek wszystkich studentów z wykorzystaniem STREAMa: ");
        students.stream().map(getStudentAge).forEach(printWiek);

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
