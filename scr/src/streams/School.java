package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Criterion<E>
{
    boolean test(Student s);

    default Criterion<E> negate(){
        return s -> ! this.test(s);
    }

    static <E> Criterion<E> negate(Criterion<E> crit) {
        return s -> !crit.test(s);
    }
    static <E> Criterion<E> or(
            Criterion<E> first, Criterion<E> second) {
        return s -> first.test(s) || second.test(s);
    }

}


interface StudentCriterion {
    boolean test(Student student);
    default StudentCriterion or(StudentCriterion second) {
        return s -> this.test(s) || second.test(s);
    }
    static StudentCriterion negate(StudentCriterion crit) {
        return s -> !crit.test(s);
    }
    static StudentCriterion or(
            StudentCriterion first, StudentCriterion second) {
        return s -> first.test(s) || second.test(s);
    }

}

class EnthusiasticStudentCriterion implements StudentCriterion {
    @Override
    public boolean test(Student s) {
        return s.getCourses().size() > 3;
    }
}

class SmartStudentCriterion implements StudentCriterion {


    @Override
    public boolean test(Student s) {
        return s.getGpa() > 3;
    }
}


public class School {
    public static StudentCriterion negate(StudentCriterion criterion) {
        return s -> !criterion.test(s);
    }

    public static StudentCriterion or(StudentCriterion first, StudentCriterion second) {
        return s -> first.test(s) || second.test(s);
    }
    public static void printStudents(List<Student> ls) {
        for (Student s : ls) {
            if (s.getGpa() > 3) {
                System.out.println("> " + s);
            }
        }
        System.out.println("-------------------------------------------");

        Object o = "Helo";
        String st = (String)o;
        Object smartObject = (StudentCriterion) (s -> s.getGpa() > 3);

    }
    public static List<Student> showSmart(List<Student> ls , double threshold){
       List<Student> rv = new ArrayList<>();
        for (Student s : ls) {
            if (s.getGpa() > threshold) {
                rv.add(s);

            }
        }
        return rv;
    }

    // "Command" pattern
    public static List<Student> getByCriterion ( List<Student> ls, Criterion crit){
        List<Student> rv = new ArrayList<>();

        for (Student s : ls) {
            if (crit.test(s)) { // NOT crit(s) !!!! Lambdas create object instances
                rv.add(s);
            }
        }
        return rv;
    }

    public static List<Student> getByPredicate(List<Student> ls, Criterion<Student> crit){
        List<Student> rv = new ArrayList<>();
        for (Student s : ls) {
            if (crit.test(s)) { // NOT crit(s) !!!! Lambdas create object instances
                rv.add(s);
            }
        }
        return rv;
    }

    public static List<Student> getEnthusiastic(List<Student> ls , int threshold){
        List<Student> rv = new ArrayList<>();
        for (Student s : ls) {
            if (s.getCourses().size() > threshold) {
                rv.add(s);

            }
        }
        return rv;
    }





    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.of("Fred", 3.2, "Math", "Physics"),
                Student.of("Jim", 2.8, "Art"),
                Student.of("Sheila", 3.7, "Math",
                        "Physics", "Astrophysics", "Quantum Mechanics"));

        printStudents(school);

    }


    public static StudentCriterion getSmartCriterion(double threshold) {
        return s -> s.getGpa() > threshold;
    }

    StudentCriterion fairlySmart = s -> s.getGpa() > 3.5;
    StudentCriterion notSmart =  StudentCriterion.negate(Student.getSmartCriterion(2.9));

    StudentCriterion fairlySmartOrNotSmart = or(fairlySmart, notSmart);


}
