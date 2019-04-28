package functional;

import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Robert Burek
 */
public class App {

    public static void main(String[] args) {


        Predicate<Student> over30 = student -> (student.getAge() > 30);
        Consumer<Object> print = System.out::println;
        Consumer<Student> printAll = student -> System.out.println(student.getName() + ", wiek: " + student.getAge());
        Function<Student, String> getStudentName = Student::getName;
        Function<Student, Integer> getStudentAge = Student::getAge;

        System.out.println("Lista studentów i ich wiek: ");
        createDataStream().forEach(printAll);

        //pełny zapis
        createDataStream().map(getStudentAge).mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value.intValue();
            }
        }).forEach(System.out::print);
        System.out.println("");

        //lambda
        createDataStream().map(getStudentAge).mapToInt(value -> value.intValue()).forEach(System.out::print);
        System.out.println("");

        //referencyjny
        createDataStream().map(getStudentAge).mapToInt(Integer::intValue).forEach(System.out::print);
        System.out.println("");

        IntStream intStream = createDataStream().map(getStudentAge).mapToInt(Integer::intValue);
        intStream.map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return 0;
            }
        });

        System.out.println("Posortowany wiek studentów (prymitywów int)");
        createDataStream().map(getStudentAge).mapToInt(Integer::intValue).sorted().forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value + ", ");
            }
        });

        //Long i double - identycznie

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
