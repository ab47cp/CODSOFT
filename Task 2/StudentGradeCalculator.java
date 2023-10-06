import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float averagePercentage,marks,totalMarks = 0;
            String grade;
            int subjects,i;

            System.out.print("Enter the number of subjects: ");
            subjects = sc.nextInt();

            for (i = 1; i <= subjects; i++) {
                System.out.print("Enter marks of subject " + i + ": ");
                marks = sc.nextFloat();
                totalMarks += marks;
            }
            averagePercentage = totalMarks / (float) subjects;
            if (averagePercentage >= 90) 
                grade = "A";
            else if (averagePercentage >= 80)
                grade = "B";
            else if (averagePercentage >= 60)
                grade = "C";
            else if (averagePercentage >= 40)
                grade = "D";
            else
                grade = "F";

            System.out.println("\nTotal Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage+"%");
            System.out.println("\nGrade: " + grade+"\n");
        }
    }
}
