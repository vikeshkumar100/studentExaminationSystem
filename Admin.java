public class Admin {
    public static void viewAllUsers(Student[] students, int studentCount, Faculty[] faculties, int facultyCount) {
        System.out.println("--------------------------------");
        System.out.println("All Users:");

        System.out.println("\nStudents:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].getName() + ", Reg No: " + students[i].getRegNo());
        }

        System.out.println("\nFaculties:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Name: " + faculties[i].getName() + ", ID: " + faculties[i].getId());
        }
        System.out.println("--------------------------------");
    }

    public static void viewStudents(Student[] students, int studentCount) {
        System.out.println("--------------------------------");
        System.out.println("Students:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].getName() + ", Reg No: " + students[i].getRegNo());
        }
        System.out.println("--------------------------------");
    }

    public static void viewFaculties(Faculty[] faculties, int facultyCount) {
        System.out.println("--------------------------------");
        System.out.println("Faculties:");
        for (int i = 0; i < facultyCount; i++) {
            System.out.println("Name: " + faculties[i].getName() + ", ID: " + faculties[i].getId());
        }
        System.out.println("--------------------------------");
    }
}