import Stdent2.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Student> studentList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Import/Chèn new user information");
            System.out.println("2. Print member list to screen");
            System.out.println("3. Delete student by code");
            System.out.println("4. Arrange students in descending order of score");
            System.out.println("5. Search for students by student code or student name");
            System.out.println("6. Find students with score >= x");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    input();
                    break;
                case 2:
                    output();
                    break;
                case 3:
                    System.out.print("Enter the student code to delete: ");
                    String code = scanner.nextLine();
                    removeByCode(code);
                    break;
                case 4:
                    sortByGradeDesc();
                    break;
                case 5:
                    System.out.print("Enter the student code or name you want to find: ");
                    String keyword = scanner.nextLine();
                    Student foundStudent = findByCodeOrName(keyword);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("No students found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter point x: ");
                    float x = Float.parseFloat(scanner.nextLine());
                    List<Student> filteredStudents = filterByGrade(x);
                    if (filteredStudents.isEmpty()) {
                        System.out.println("No students were found with a score >=" + x);
                    } else {
                        for (Student student : filteredStudents) {
                            System.out.println(student);
                        }
                    }
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid selection, please select again!");
            }
        }
    }

    public static void input() {
        System.out.println("Enter student information:");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        System.out.print("Enter gender (0 - Female, 1 - Male): ");
        int gender = Integer.parseInt(scanner.nextLine());
        System.out.print("Input score: ");
        float grade = Float.parseFloat(scanner.nextLine());

        Student student = new Student(name, age, email, phone, code, gender, grade);
        studentList.add(student);
        System.out.println("Student added successfully!");
    }

    public static void output() {
        if (studentList.isEmpty()) {
            System.out.println("Student list is empty!");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public static void removeByCode(String code) {
        Student studentToRemove = null;
        for (Student student : studentList) {
            if (student.getCode().equals(code)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            studentList.remove(studentToRemove);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("No student found with the above code!");
        }
    }

    public static void sortByGradeDesc() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Float.compare(o2.getGrade(), o1.getGrade());
            }
        });
        System.out.println("Students have been arranged in descending order of score!");
    }

    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equalsIgnoreCase(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    public static List<Student> filterByGrade(float x) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}

