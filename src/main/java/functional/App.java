package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {

//        //1
//        Runnable cos1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("AAA");
//            }
//        };
//
//        //2
//        Runnable cos2 = () -> {
//            System.out.println("AAA");
//        };
//
//        //3
//        Runnable cos3 = () -> System.out.println("AAA");
//
//        //1
//        Comparable<String> comparable1 = new Comparable<String>() {
//            @Override
//            public int compareTo(String o) {
//                return 0;
//            }
//        };
//
//        //2
//        Comparable<String> comparable2 = (String o) -> 0;
//
//        //3
//        Comparable<String> comparable3 = o -> 0;
//
//
//        //1
//        Movable m1 = new Movable() {
//            @Override
//            public int move(String direction) {
//                return 11;
//            }
//        };
//
//        //2
//        Movable m2 = direction -> 11;
//
//        test("pierwsza", cos1);
//        test("druga", cos2);

        List<Student> students = createData();

//        Student robert = students.get(1);
//        Student ktos = robert.changeIndexNumber("654321");
//        System.out.println(ktos);

//          pełna implementacja metody test z interfejsu funcyjnego Predicate
/*
        Predicate<Student> isRobert = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return (student.getName()).equals("Robert");
            }
        };
        Predicate<Student> over30 = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return (student.getAge() > 30);
            }
        };
*/

        Predicate<Student> isRobert = student -> (student.getName()).equals("Robert");
        Predicate<Student> over30 = student -> (student.getAge() > 30);


//        tradycyjnie poprzez osobne metody
        System.out.println("Tradycyjnie poprzez osobne metody");
        System.out.println(getRoberty(students));
        System.out.println(getOver30(students));

//        poprzez zdefiniowane predicate  isRobert i over30
        System.out.println("Wyniki poprzez predicate isRobert i over30");
        System.out.println(filterStudents(students, isRobert));
        System.out.println(filterStudents(students, over30));

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

    //    osobne metody getOver30 i getRoberty
    private static List<Student> getOver30(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getAge() > 30) {
                result.add(s);
            }
        }
        return result;
    }

    private static List<Student> getRoberty(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().equals("Robert")) {
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

//    public static void test(String name, Runnable a) {
//    }
}
