import java.util.Scanner;

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

    public static void start()
    {
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
        } else {
            System.out.println("Maximum faculties limit reached.");
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
                        takeExam(student);
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

    public static void takeExam(Student student) {
        String[] questions = {
                "1 - What does JVM stand for?\nA. Java Virtual Machine\nB. Java Visual Machine\nC. Java Virtual Method\nD. Java Visual Method",
                "2 - What is the default value of the data type byte in Java?\nA. 0\nB. 0.0\nC. null\nD. undefined",
                "3 - Which one among these is not a keyword in Java?\nA. class\nB. int\nC. get\nD. if",
                "4 - What is the range of short data type in Java?\nA. -128 to 127\nB. -32768 to 32767\nC. -2147483648 to 2147483647\nD. None of the mentioned",
                "5 - What is the use of finalize method in Java?\nA. The finalize() method is used to perform cleanup operations on object finalization\nB. The finalize() method is used to initialize objects\nC. The finalize() method is used to free the allocated memory\nD. The finalize() method is used to destroy objects",
                "6 - Which package contains all the classes and interfaces required for servlets?\nA. java.servlet\nB. javax.servlet\nC. javax.servlets\nD. java.servlets",
                "7 - What is the return type of the hashCode() method in the Object class?\nA. int\nB. void\nC. boolean\nD. long",
                "8 - Which operator is used to allocate memory to an array in Java?\nA. *\nB. .\nC. new\nD. /",
                "9 - Which keyword is used to define packages in Java?\nA. pack\nB. pkg\nC. package\nD. packages",
                "10 - What is the correct way to define an interface in Java?\nA. interface MyInterface { }\nB. interface MyInterface\nC. MyInterface interface { }\nD. interface MyInterface { } interface { }"
        };

        String[] correctAnswers = { "A", "A", "C", "B", "A", "B", "A", "C", "C", "A" };

        int totalMarks = 0;

        System.out.println("Starting exam...");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer (A/B/C/D): ");
            String answer = scanner.next().toUpperCase();
            if (answer.equals(correctAnswers[i])) {
                totalMarks += 10;
            }
            System.out.println();
        }

        student.takeExam(totalMarks);
        System.out.println(
                "Exam completed! You scored " + totalMarks + " marks out of " + (questions.length * 10) + " marks.");
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
}
