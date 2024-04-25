import java.util.*;
import java.io.*;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    public static int MAX_STUDENTS = 20;
    public static int MAX_FACULTIES = 5;
    public static Student[] students = new Student[MAX_STUDENTS];
    public static Faculty[] faculties = new Faculty[MAX_FACULTIES];
    public static int studentCount = 0;
    public static int facultyCount = 0;
    public static final String adminName = "vikesh";
    public static final String adminPassword = "vikesh";
    public static final String STUDENT_DATA_FILE = "students.txt";
    public static final String FACULTY_DATA_FILE = "faculties.txt";
    private static final String EXAM_DATA_FILE = "exams.txt";

    public static void start() {
        loadStudents();
        loadFaculties(); 
        loadExamData();
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nMain Menu");
            System.out.println("1. Student");
            System.out.println("2. Faculty");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    facultyMenu();
                    break;
                case 3:
                    adminLogin();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void studentMenu() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nStudent Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit student menu");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginStudent();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void facultyMenu() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nFaculty Menu");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    loginFaculty();
                    break;
                case 2:
                    registerFaculty();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void adminMenu() {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nAdmin Menu");
            System.out.println("1. View All Users");
            System.out.println("2. View Students");
            System.out.println("3. View Faculties");
            System.out.println("4. Exit admin Menu");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Admin.viewAllUsers(students, studentCount, faculties, facultyCount);
                    break;
                case 2:
                    Admin.viewStudents(students, studentCount);
                    break;
                case 3:
                    Admin.viewFaculties(faculties, facultyCount);
                    break;
                case 4:
                    System.out.println("Exiting Admin Menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void loginStudent() {
        System.out.print("Enter student Reg No: ");
        String regNo = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getRegNo().equals(regNo) && students[i].getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + students[i].getName() + "!");
                studentOptions(students[i]);
                return;
            }
        }
        System.out.println("Invalid student Reg No or password.");
    }

    public static void registerStudent() {
        if (studentCount < MAX_STUDENTS) {
            System.out.print("Enter student name: ");
            String name = scanner.next();
            System.out.print("Enter student Reg No: ");
            String regNo = scanner.next();
            System.out.print("Set password: ");
            String password = scanner.next();

            students[studentCount] = new Student(name, regNo, password);
            studentCount++;
            System.out.println("Registration successful!");
            saveStudents();
        } else {
            System.out.println("Maximum students limit reached.");
        }
    }

    public static void loginFaculty() {
        System.out.print("Enter faculty ID: ");
        String id = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (int i = 0; i < facultyCount; i++) {
            if (faculties[i].getId().equals(id) && faculties[i].getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + faculties[i].getName() + "!");
                facultyOptions(faculties[i]);
                return;
            }
        }
        System.out.println("Invalid faculty ID or password.");
    }

    public static void registerFaculty() {
        if (facultyCount < MAX_FACULTIES) {
            System.out.print("Enter faculty name: ");
            String name = scanner.next();
            System.out.print("Enter faculty ID: ");
            String id = scanner.next();
            System.out.print("Set password: ");
            String password = scanner.next();

            faculties[facultyCount] = new Faculty(name, id, password);
            facultyCount++;
            System.out.println("Registration successful!");
            saveFaculties();
        } else {
            System.out.println("Maximum faculties limit reached.");
        }
    }
    public static void adminLogin() {
        System.out.print("Enter admin name: ");
        String name = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (name.equals(adminName) && password.equals(adminPassword)) {
            System.out.println("Login successful! Welcome, " + adminName + "!");
            adminMenu();
        } else {
            System.out.println("Wrong credentials. Please try again.");
        }
    }

    public static void studentOptions(Student student) {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nStudent Options:");
            System.out.println("1. Exam");
            System.out.println("2. Result");
            System.out.println("3. Logout");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (student.isExamGiven()) {
                        System.out.println("You have already taken the exam.");
                        System.out.println("Exam Status: Already Given");
                        System.out.println("--------------------------------");
                    } else {
                        Exam.takeExam(student);
                        saveExamData(student);
                    }
                    break;
                case 2:
                    checkResult(student);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void checkResult(Student student) {
        int totalMarks = student.getMarks();
        int totalPossibleMarks = 100;

        double percentage = ((double) totalMarks / totalPossibleMarks) * 100;
        System.out.println("--------------------------------");
        System.out.println("Your total marks: " + totalMarks);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Exam Status: " + (student.isExamGiven() ? "Already Given" : "Not Given"));
        System.out.println("--------------------------------");
    }

    public static void facultyOptions(Faculty faculty) {
        while (true) {
            System.out.println("--------------------------------");
            System.out.println("\nFaculty Options:");
            System.out.println("1. All Marks");
            System.out.println("2. Insights");
            System.out.println("3. Logout");
            System.out.println("--------------------------------");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAllMarks();
                    break;
                case 2:
                    showInsights();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void showAllMarks() {
        System.out.println("\nStudent Marks:");
        System.out.println("--------------------------------");
        for (int i = 0; i < studentCount; i++) {
            if (students[i].isExamGiven()) {
                System.out.println("Name: " + students[i].getName() + ", Reg No: " + students[i].getRegNo() +
                        ", Marks: " + students[i].getMarks());
            } else {
                System.out.println("Name: " + students[i].getName() + ", Reg No: " + students[i].getRegNo() +
                        ", Marks: Absent");
            }
        }
        System.out.println("--------------------------------");
    }
    public static void showInsights() {
        int totalStudents = studentCount;
        int totalPresent = 0;
        int totalAbsent = 0;
        int totalFail = 0;
        int totalPass = 0;
        int totalMarks = 0;
        int highestMarks = Integer.MIN_VALUE;
        int lowestMarks = Integer.MAX_VALUE;

        for (int i = 0; i < studentCount; i++) {
            totalMarks += students[i].getMarks();
            highestMarks = Math.max(highestMarks, students[i].getMarks());
            lowestMarks = Math.min(lowestMarks, students[i].getMarks());

            if (students[i].isExamGiven()) {
                totalPresent++;
                if (students[i].getMarks() < 40) {
                    totalFail++;
                } else {
                    totalPass++;
                }
            } else {
                totalAbsent++;
                totalFail++;
            }
        }
        double averageMarks = (double) totalMarks / studentCount;
        System.out.println("--------------------------------");
        System.out.println("\nInsights:");
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Present: " + totalPresent);
        System.out.println("Total Absent: " + totalAbsent);
        System.out.println("Total Fail: " + totalFail);
        System.out.println("Total Pass: " + totalPass);
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Lowest Marks: " + lowestMarks);
        System.out.println("Average Marks: " + averageMarks);
        System.out.println("--------------------------------");
    }

    public static void saveExamData(Student student) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EXAM_DATA_FILE, true))) {
            writer.write(student.getRegNo() + "," + student.getMarks() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadExamData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(EXAM_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String regNo = tokenizer.nextToken();
                int marks = Integer.parseInt(tokenizer.nextToken());
                for (int i = 0; i < studentCount; i++) {
                    if (students[i].getRegNo().equals(regNo)) {
                        students[i].setMarks(marks);
                        students[i].setExamGiven(true);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENT_DATA_FILE))) {
            for (int i = 0; i < studentCount; i++) {
                Student student = students[i];
                writer.write(student.getName() + "," + student.getRegNo() + "," + student.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFaculties() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FACULTY_DATA_FILE))) {
            for (int i = 0; i < facultyCount; i++) {
                Faculty faculty = faculties[i];
                writer.write(faculty.getName() + "," + faculty.getId() + "," + faculty.getPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String name = tokenizer.nextToken();
                String regNo = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                students[studentCount++] = new Student(name, regNo, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void loadFaculties() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FACULTY_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String name = tokenizer.nextToken();
                String id = tokenizer.nextToken();
                String password = tokenizer.nextToken();
                faculties[facultyCount++] = new Faculty(name, id, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
