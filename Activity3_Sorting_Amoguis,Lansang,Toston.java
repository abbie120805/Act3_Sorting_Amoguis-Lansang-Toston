import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name + " - " + grade;
    }
}

public class StudentSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many Students?");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(name, grade);
        }

        selectionSort(students);

        System.out.println("\nSorted Students by Grade (Ascending):");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }

    public static void selectionSort(Student[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].grade < arr[minIndex].grade) {
                    minIndex = j;
                }
            }
            Student temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].grade > arr[j + 1].grade) {
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
