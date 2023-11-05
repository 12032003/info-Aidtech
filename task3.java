import java.util.Scanner;

public class task3 {

    private static Scanner scanner = new Scanner(System.in);

    private static class Student {
        private int rollNumber;
        private String name;
        private String address;
        private String phoneNumber;

        public Student(int rollNumber, String name, String address, String phoneNumber) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rollNumber=" + rollNumber +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

    private static class StudentRecord {
        private Student[] students;

        public StudentRecord(int capacity) {
            students = new Student[capacity];
        }

        public void addStudent(Student student) {
            int i = 0;
            while (i < students.length && students[i] != null) {
                i++;
            }

            if (i < students.length) {
                students[i] = student;
            } else {
                System.out.println("Student record is full!");
            }
        }

        public Student removeStudent(int rollNumber) {
            int index = -1;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].getRollNumber() == rollNumber) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                Student student = students[index];
                students[index] = null;
                return student;
            } else {
                System.out.println("Student with roll number " + rollNumber + " does not exist!");
                return null;
            }
        }

        public Student getStudent(int rollNumber) {
            int index = -1;
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && students[i].getRollNumber() == rollNumber) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                return students[index];
            } else {
                System.out.println("Student with roll number " + rollNumber + " does not exist!");
                return null;
            }
        }

        public void displayAllStudents() {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null) {
                    System.out.println(students[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        StudentRecord studentRecord = new StudentRecord(10);

        boolean running = true;
        while (running) {
            System.out.println("Enter your choice:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Get student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addStudent(studentRecord);
                    break;
                case 2:
                    removeStudent(studentRecord);
                    break;
                case 3:
                    getStudent(studentRecord);
                    break;
                case 4:
                    displayAllStudents(studentRecord);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }


    private static void addStudent(StudentRecord studentRecord) {
        System.out.println("Enter student roll number:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Enter student name:");
        String name = scanner.nextLine();

        System.out.println("Enter student address:");
        String address = scanner.nextLine();

        System.out.println("Enter student phone number:");
        String phoneNumber = scanner.nextLine();

        Student student = new Student(rollNumber, name, address, phoneNumber);
        studentRecord.addStudent(student);
    }

    private static void removeStudent(StudentRecord studentRecord) {
        System.out.println("Enter student roll number to remove:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = studentRecord.removeStudent(rollNumber);
        if (student != null) {
            System.out.println("Student with roll number " + rollNumber + " has been removed!");
        }
    }

    private static void getStudent(StudentRecord studentRecord) {
        System.out.println("Enter student roll number to get:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Student student = studentRecord.getStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        }
    }

    private static void displayAllStudents(StudentRecord studentRecord) {
        studentRecord.displayAllStudents();
    }
}
