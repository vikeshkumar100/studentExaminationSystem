public class Student {
    private String name;
    private String regNo;
    private String password;
    private int marks;
    private boolean examGiven; // Flag to track if the exam has been given

    // Constructor
    public Student(String name, String regNo, String password) {
        this.name = name;
        this.regNo = regNo;
        this.password = password;
        this.marks = 0;
        this.examGiven = false; // Initially, the exam has not been given
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public boolean isExamGiven() {
        return examGiven;
    }

    public void setExamGiven(boolean examGiven) {
        this.examGiven = examGiven;
    }

    // Method to take the exam
    public void takeExam(int marksObtained) {
        this.marks = marksObtained;
        this.examGiven = true; // Set the examGiven flag to true after taking the exam
    }
}
