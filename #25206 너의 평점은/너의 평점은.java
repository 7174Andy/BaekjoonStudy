import java.util.*;

public class Main {
    public static double gradeToGPA(String grade) {
        if (grade.compareTo("A+") == 0) {
            return 4.5;
        } else if (grade.compareTo("A0") == 0) {
            return 4.0;
        } else if (grade.compareTo("B+") == 0) {
            return 3.5;
        } else if (grade.compareTo("B0") == 0) {
            return 3.0;
        } else if (grade.compareTo("C+") == 0) {
            return 2.5;
        } else if (grade.compareTo("C0") == 0) {
            return 2.0;
        } else if (grade.compareTo("D+") == 0) {
            return 1.5;
        } else if (grade.compareTo("D0") == 0) {
            return 1.0;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        double totalGrade = 0;
        double totalUnit = 0;
        while (n <= 20) {
            String subject = sc.next();
            double unit = sc.nextDouble();
            String grade = sc.next();
            if (grade.compareTo("P") == 0) {
                n++;
                continue;
            }
            totalGrade += unit * gradeToGPA(grade);
            totalUnit += unit;
            n++;
        }
        System.out.println(totalGrade / totalUnit);
    }
}
