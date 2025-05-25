# STUDENT COURSE MANAGEMENT
import java.util.*;

class Student {
    String id;
    String name;
    List<String> enrolledCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    void enroll(String courseId) {
        if (!enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
            System.out.println(name + " enrolled in " + courseId);
        }
    }

    void drop(String courseId) {
        if (enrolledCourses.remove(courseId)) {
            System.out.println(name + " dropped " + courseId);
        }
    }

    void viewCourses() {
        System.out.println("Courses enrolled: " + enrolledCourses);
    }
}

class Course {
    String id;
    String title;

    Course(String id, String title) {
        this.id = id;
        this.title = title;
    }
}

class Admin {
    Map<String, Student> students = new HashMap<>();
    Map<String, Course> courses = new HashMap<>();

    void addStudent(String id, String name) {
        students.put(id, new Student(id, name));
    }

    void removeStudent(String id) {
        students.remove(id);
    }

    void addCourse(String id, String title) {
        courses.put(id, new Course(id, title));
    }

    void removeCourse(String id) {
        courses.remove(id);
    }

    void assignCourse(String studentId, String courseId) {
        Student s = students.get(studentId);
        if (s != null && courses.containsKey(courseId)) {
            s.enroll(courseId);
        }
    }

    void generateReport() {
        for (Student s : students.values()) {
            System.out.println("Student: " + s.name + " -> " + s.enrolledCourses);
        }
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.addStudent("S1", "Alice");
        admin.addStudent("S2", "Bob");

        admin.addCourse("C1", "Math");
        admin.addCourse("C2", "Physics");

        admin.assignCourse("S1", "C1");
        admin.assignCourse("S1", "C2");
        admin.assignCourse("S2", "C1");

        admin.generateReport();

        Student alice = admin.students.get("S1");
        alice.viewCourses();
        alice.drop("C1");
        alice.viewCourses();
    }
}
