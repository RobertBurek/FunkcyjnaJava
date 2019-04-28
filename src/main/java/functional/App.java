package functional;

import java.util.Comparator;
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
        Function<Student, Integer> getStudentAge = Student::getAge;

        System.out.println("Imiona wszystkich studentów ");//alfabetycznie: ");
        createDataStream()
                .map(getStudentName)
                .forEach(print);

        //limit
        System.out.println("Pierwsze trzy (limit) imiona studentów alfabetycznie: ");
        createDataStream().limit(3).map(getStudentName).sorted().forEach(print);

        //skip
        System.out.println("Wszystkie pozostałe poza czterema pierwszymi (skip) alfabetycznie: ");
        createDataStream().skip(4).map(getStudentName).sorted().forEach(print);

        //distinct
        System.out.println("Wszystkie imiona o unikalnym indeksie (distinct) wymaga equals(Object o): ");
        createDataStream().distinct().map(getStudentName).forEach(print);

        //sorted
        System.out.println("Wszystkie imiona alfabetycznie (sorted) listy stringów (imion): ");
        createDataStream().map(getStudentName).sorted().forEach(print);

        //sorted
        System.out.println("Imiona alfabetycznie (sorted) streama wymaga implementacji Comparable<Student>: ");
        createDataStream().sorted().map(getStudentName).forEach(print);

        //sorted
        System.out.println("Imiona posortowane po wieku-rosnąco (sorted(Comparator()-pełny zapis) w streamie: ");
        createDataStream().sorted(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        }).map(getStudentName).forEach(print);

        //sorted
        System.out.println("Imiona posortowane po wieku-malejąco (sorted(Comparator()-lambda) w streamie: ");
        createDataStream().sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge())).map(getStudentName).forEach(print);

        //sorted
        System.out.println("Imiona posortowane po wieku-rosnąco (sorted(Comparator().comparingint()-referencja): ");
        createDataStream().sorted(Comparator.comparing(Student::getAge)).map(getStudentName).forEach(print);

        //count
        System.out.print("Ilość elementów w streami (count): ");
        long countAgeStudents = createDataStream()
                .sorted(Comparator.comparing(Student::getAge))
                .map(getStudentName)
                .count();
        System.out.println(countAgeStudents);

    }

    private static Stream<Student> createDataStream() {
        Student pawel = new Student("Paweł", 31, "223344");
        Student robert = new Student("Robert B", 24, "223344");
        Student monika = new Student("Monika", 36);
        Student robert1 = new Student("Robert C", 33, "223344");
        Student ania = new Student("Anna", 40, "223344");
        Student zenek = new Student("Zenon", 24, "435688");
        Student zenek1 = new Student("Zenon D", 33, "223344");
        Student marian = new Student("Marian", 24, "223344");
        return Stream.of(pawel, robert, monika, robert1, ania, zenek, zenek1, marian);
    }

}
