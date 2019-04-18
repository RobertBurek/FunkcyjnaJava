package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {

//        List<Student> students = createData();


        //       Predicate<Student> over30 = student -> (student.getAge() > 30);

//        pełny zapis interfejsu funkcyjnego Consumer
//        Consumer<Student> consumer = new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student.getName());
//            }
//        };

//        lambda Consumer
//        Consumer<Student> printStudentName = student -> System.out.print(student.getName() + " ");
//        Consumer<Student> printStudentNameUppercase =
//                student -> System.out.println(" -> " + student.getName().toUpperCase());


//        pełny zapis interfejsu funkcyjnego Supplier
//        Supplier<Student> getStudent = new Supplier<Student>() {
//            @Override
//            public Student get() {
//                return new Student("xxx",32,"999999");
//            }
//        };

//        System.out.println("Lista studentów powyżej 30 lat");
//        System.out.println(filterStudents(students,over30));
//        System.out.println("Imiona tych studentów");
//        consumerStudents(filterStudents(students,over30),printStudentName);
//        System.out.println("Imiona tych studentów oraz WIELKIMI LITERAMI");
//        consumerStudents(filterStudents(students,over30),printStudentName.andThen(printStudentNameUppercase));

        //   Supplier<Student> getStudent = () -> new Student("xxx", 32, "999999");
//        Supplier<List<Student>> studentSupplier = () -> createData();


        Supplier<List<Student>> supplyPredefinedStudent = () -> createData();
        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<String> print = text -> System.out.println(text);
        Function<Student, String> getStudentName = student -> student.getName();


        BiFunction<String, Student, Integer> test = new BiFunction<String, Student, Integer>() {
            @Override
            public Integer apply(String s, Student student) {
                return null;
            }
        };

        BinaryOperator<Student> binaryOperator = new BinaryOperator<Student>() {
            @Override
            public Student apply(Student student, Student student2) {
                return null;
            }
        };

        System.out.println("Imiona studentów z wykorzystaniem Function: ");
        consumerStudentsNew(filterStudents(supplyPredefinedStudent, over30), getStudentName, print);
        System.out.println("");
    }

    private static void consumerStudentsNew(List<Student> students, Function<Student, String> function, Consumer<String> consumer) {
        for (Student s : students) {
            consumer.accept(function.apply(s));
        }
    }

//       pełen zapis Function
//        Function<Student,String> getStudent= new Function<Student, String>() {
//            @Override
//            public String apply(Student student) {
//                return student.getName();
//            }
//        };

//        System.out.println("Lista studentów powyżej 30 lat");
//        System.out.println(filterStudents(supplyPredefinedStudent, over30));
//        System.out.print("Imiona tych studentów: ");
//        consumerStudents(filterStudents(supplyPredefinedStudent, over30), printStudentName);
//        System.out.println("");
//        System.out.println("Imiona tych studentów oraz WIELKIMI LITERAMI");
//        consumerStudents(filterStudents(supplyPredefinedStudent, over30), printStudentName.andThen(printStudentNameUppercase));
//        System.out.println("Wszyscy studenci:");
//        System.out.println(supplyPredefinedStudent.get());


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

    //    jedna metoda z Predicate
//    private static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
//        List<Student> result = new ArrayList<>();
//        for (Student s : students) {
//            if (predicate.test(s)) {
//                result.add(s);
//            }
//        }
//        return result;
//    }


    private static List<Student> createData() {
        List<Student> result = new ArrayList<>();
        result.add(new Student("Paweł", 31, "123456"));
        result.add(new Student("Robert", 24, "223344"));
        result.add(new Student("Monika", 36));
        result.add(new Student("Robert", 33, "555555"));
        return result;
    }

}
