package service;

import model.Student;
import model.Course;
import java.util.*;

public class EnrollmentService {
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Set<String>> enrollments = new HashMap<>();

    public void addStudent(String id, String name) {
        if (students.containsKey(id)) {
            System.out.println("⚠️ Student already exists.");
            return;
        }
        students.put(id, new Student(id, name));
        System.out.println("✅ Student added.");
    }

    public void addCourse(String code, String name) {
        if (courses.containsKey(code)) {
            System.out.println("⚠️ Course already exists.");
            return;
        }
        courses.put(code, new Course(code, name));
        System.out.println("✅ Course added.");
    }

    public void enroll(String studentId, String courseCode) {
        if (!students.containsKey(studentId) || !courses.containsKey(courseCode)) {
            System.out.println("❌ Student or Course not found.");
            return;
        }
        enrollments.putIfAbsent(studentId, new HashSet<>());
        boolean added = enrollments.get(studentId).add(courseCode);
        System.out.println(added ? "✅ Enrolled successfully." : "⚠️ Already enrolled.");
    }

    public void showAllEnrollments() {
        enrollments.forEach((studentId, courseCodes) -> {
            Student student = students.get(studentId);
            System.out.println("\n📘 " + student.getName() + " (" + studentId + ")");
            courseCodes.forEach(code -> {
                Course course = courses.get(code);
                System.out.println("  - " + course);
            });
        });
    }

    public void listStudents() {
        if (students.isEmpty()) System.out.println("⚠️ No students found.");
        else students.values().forEach(System.out::println);
    }

    public void listCourses() {
        if (courses.isEmpty()) System.out.println("⚠️ No courses found.");
        else courses.values().forEach(System.out::println);
    }
}
