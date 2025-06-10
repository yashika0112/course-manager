import service.EnrollmentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EnrollmentService service = new EnrollmentService();
        int choice;

        while (true) {
            System.out.println("""
                \n======= Student Course Management =======
                1. Add Student
                2. Add Course
                3. Enroll Student in Course
                4. View All Enrollments
                5. View All Students
                6. View All Courses
                0. Exit
                """);
            System.out.print("Enter choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Student ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Student Name: ");
                    String name = sc.nextLine().trim();
                    service.addStudent(id, name);
                }
                case 2 -> {
                    System.out.print("Course Code: ");
                    String code = sc.nextLine().trim();
                    System.out.print("Course Name: ");
                    String name = sc.nextLine().trim();
                    service.addCourse(code, name);
                }
                case 3 -> {
                    System.out.print("Student ID: ");
                    String id = sc.nextLine().trim();
                    System.out.print("Course Code: ");
                    String code = sc.nextLine().trim();
                    service.enroll(id, code);
                }
                case 4 -> service.showAllEnrollments();
                case 5 -> service.listStudents();
                case 6 -> service.listCourses();
                case 0 -> {
                    System.out.println("✅ Exiting. Goodbye!");
                    return;
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }
    }
}
