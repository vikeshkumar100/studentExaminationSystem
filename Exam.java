import java.util.Random;
import java.util.Scanner;

public class Exam {
    private static final Scanner scanner = new Scanner(System.in);

    public static void takeExam(Student student) {
        String[] questions = {
                " - What does JVM stand for?\nA. Java Virtual Machine\nB. Java Visual Machine\nC. Java Virtual Method\nD. Java Visual Method",
                " - What is the default value of the data type byte in Java?\nA. 0\nB. 0.0\nC. null\nD. undefined",
                " - Which one among these is not a keyword in Java?\nA. class\nB. int\nC. get\nD. if",
                " - What is the range of short data type in Java?\nA. -128 to 127\nB. -32768 to 32767\nC. -2147483648 to 2147483647\nD. None of the mentioned",
                " - What is the use of finalize method in Java?\nA. The finalize() method is used to perform cleanup operations on object finalization\nB. The finalize() method is used to initialize objects\nC. The finalize() method is used to free the allocated memory\nD. The finalize() method is used to destroy objects",
                " - Which package contains all the classes and interfaces required for servlets?\nA. java.servlet\nB. javax.servlet\nC. javax.servlets\nD. java.servlets",
                " - What is the return type of the hashCode() method in the Object class?\nA. int\nB. void\nC. boolean\nD. long",
                " - Which operator is used to allocate memory to an array in Java?\nA. *\nB. .\nC. new\nD. /",
                " - Which keyword is used to define packages in Java?\nA. pack\nB. pkg\nC. package\nD. packages",
                " - What is the correct way to define an interface in Java?\nA. interface MyInterface { }\nB. interface MyInterface\nC. MyInterface interface { }\nD. interface MyInterface { } interface { }",
                " - What is the result of 3 + 4 * 2 in Java?\nA. 10\nB. 11\nC. 14\nD. 24",
                " - What is the parent class of all classes in Java?\nA. Object\nB. Main\nC. Super\nD. Parent",
                " - What is the difference between == and .equals() method in Java?\nA. They are the same\nB. == compares object references, .equals() compares values\nC. .equals() compares object references, == compares values\nD. None of the above",
                " - Which of the following is not a valid identifier in Java?\nA. _variableName\nB. $variableName\nC. 9variableName\nD. variableName",
                " - What is the output of the following code?\npublic class Test {\n    public static void main(String[] args) {\n        int x = 5;\n        System.out.println(x++);\n        System.out.println(++x);\n    }\n}\nA. 6 and 7\nB. 5 and 6\nC. 5 and 7\nD. 6 and 6",
                " - What is the output of System.out.println(10 % 3); in Java?\nA. 1\nB. 3\nC. 0.1\nD. 10",
                " - Which of the following is a marker interface in Java?\nA. Runnable\nB. Serializable\nC. Cloneable\nD. Comparable",
                " - What is the output of the following code?\npublic class Test {\n    public static void main(String[] args) {\n        System.out.println(\"Java\".substring(1, 3));\n    }\n}\nA. ava\nB. Jav\nC. va\nD. av",
                " - What does the 'static' keyword mean in Java?\nA. It means the variable is dynamic\nB. It means the method is dynamic\nC. It means the variable or method belongs to the class, not instances\nD. It means the variable or method belongs to the instances, not the class",
                " - What is the correct way to declare a constant variable in Java?\nA. final int constantVar;\nB. int constantVar;\nC. static int constantVar;\nD. final static int constantVar;",
                " - What is a Java servlet?\nA. A small, server-side Java program that runs within a web server\nB. A client-side Java applet\nC. A Java programming language compiler\nD. A Java database connection",
                " - What is the purpose of the 'transient' keyword in Java?\nA. It indicates that a variable is to be serialized\nB. It indicates that a variable should not be serialized\nC. It indicates that a variable should be copied on object cloning\nD. It indicates that a variable should be accessed from multiple threads",
                " - What is the purpose of the 'volatile' keyword in Java?\nA. It indicates that a variable is to be serialized\nB. It indicates that a variable should not be serialized\nC. It indicates that a variable should be copied on object cloning\nD. It indicates that a variable should be accessed from multiple threads",
                " - Which of the following is a checked exception in Java?\nA. NullPointerException\nB. ArrayIndexOutOfBoundsException\nC. FileNotFoundException\nD. IllegalArgumentException",
                " - What is the difference between a checked and an unchecked exception in Java?\nA. Checked exceptions must be caught or declared, unchecked exceptions need not be\nB. Checked exceptions need not be caught or declared, unchecked exceptions must be\nC. Checked exceptions are thrown by the JVM, unchecked exceptions are thrown by the programmer\nD. There is no difference",
                " - What is the purpose of the 'finally' block in Java exception handling?\nA. To handle exceptions that occur during execution of the try block\nB. To execute code after either the try or catch blocks, regardless of whether an exception occurs\nC. To execute code only if an exception occurs\nD. To rethrow exceptions caught in the try block",
                " - What is the purpose of the 'super' keyword in Java?\nA. It is used to call a method in the superclass\nB. It is used to create a new object\nC. It is used to access the current object\nD. It is used to access static members of a class",
                " - What is the purpose of the 'this' keyword in Java?\nA. It is used to call a method in the current class\nB. It is used to create a new object\nC. It is used to access the current object\nD. It is used to access static members of a class",
                " - What is the purpose of the 'break' statement in Java?\nA. It is used to terminate the current loop or switch statement\nB. It is used to skip the current iteration of a loop\nC. It is used to exit the entire program\nD. It is used to return a value from a method"
        };

        String[] correctAnswers = {
                "A", "A", "C", "B", "A", "B", "A", "C", "C", "A",
                "C", "A", "B", "C", "A", "B", "A", "B", "D", "D",
                "A", "B", "B", "C", "A", "B", "B", "A", "C", "A"
        };

        int totalMarks = 0;

        System.out.println("Starting exam...");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(questions.length);
            System.out.println(i + 1 + questions[randomIndex]);
            System.out.print("Your answer (A/B/C/D): ");
            String answer = scanner.next().toUpperCase();
            if (answer.equals(correctAnswers[randomIndex])) {
                totalMarks += 10;
            }
            System.out.println();
        }

        student.takeExam(totalMarks);
        System.out.println("Exam completed! You scored " + totalMarks + " marks out of 100 marks.");
    }
}
