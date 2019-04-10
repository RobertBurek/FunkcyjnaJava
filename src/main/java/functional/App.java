package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {

        List<Student> students = createData();


        Predicate<Student> over30 = student -> (student.getAge() > 30);

//        pełny zapis interfejsu funkcyjnego Consumer
//        Consumer<Student> consumer = new Consumer<Student>() {
//            @Override
//            public void accept(Student student) {
//                System.out.println(student.getName());
//            }
//        };

//        lambda Consumer
        Consumer<Student> printStudentName = student -> System.out.print(student.getName());
        Consumer<Student> printStudentNameUppercase =
                student -> System.out.println(" -> " + student.getName().toUpperCase());

        System.out.println("Lista studentów powyżej 30 lat");
        System.out.println(filterStudents(students,over30));
        System.out.println("Imiona tych studentów");
        consumerStudents(filterStudents(students,over30),printStudentName);
        System.out.println("Imiona tych studentów oraz WIELKIMI LITERAMI");
        consumerStudents(filterStudents(students,over30),printStudentName.andThen(printStudentNameUppercase));

    }

    private static void consumerStudents(List<Student> students, Consumer<Student> consumer){
        for (Student s: students){
            consumer.accept(s);
        }
    }

    //    jedna metoda z Predicate
    private static List<Student> filterStudents(List<Student> students, Predicate<Student> predicate) {
        List<Student> result = new ArrayList<>();
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
