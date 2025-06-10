package model;

public class Course {
    private String code;
    private String name;

    public Course(String code, String name) {
        if (code == null || code.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("Course code and name cannot be blank.");
        }
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return code + " - " + name;
    }
}
