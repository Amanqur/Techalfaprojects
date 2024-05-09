   import java.util.Scanner;
public class GradeTracker1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter How many Students: ");
        int numStudents = scanner.nextInt();
        double[] averages = new double[numStudents];
        double[] highestGrades = new double[numStudents];
        double[] lowestGrades = new double[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEntering grades for student " + (i + 1) + ":");
            System.out.print("Enter total no of grades(subjects): ");
            int numGrades = scanner.nextInt();

            double[] grades = new double[numGrades];

            // Input grades
            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                grades[j] = scanner.nextDouble();
            }

            // Calculate average, highest, and lowest grades
            double sum = 0;
            double highest = grades[0];
            double lowest = grades[0];

            for (double grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            averages[i] = sum / numGrades;
            highestGrades[i] = highest;
            lowestGrades[i] = lowest;
        }

        // Output results
        System.out.println("\nStudent Grade Summary:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("Average Grade: " + averages[i]);
            System.out.println("Highest Grade: " + highestGrades[i]);
            System.out.println("Lowest Grade: " + lowestGrades[i]);
        }
    }
}