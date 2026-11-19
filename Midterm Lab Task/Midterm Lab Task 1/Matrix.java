import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // reads user input
        int[][] nums = new int[3][3];           // 2D array: 3 rows, 3 columns
        char again;                             // answer for Try Again
        do {
            System.out.println("Input 9 elements:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int value;
                    do { // keep asking until the value is 0-9
                        value = input.nextInt();
                        if (value < 0 || value > 9) System.out.println("Invalid! Enter a number from 0 to 9:");
                    } while (value < 0 || value > 9);
                    nums[i][j] = value; // store valid value
                }
            }
            System.out.println("\nDisplay Here are the Numbers and the required outputs:\n==============================================");
            System.out.printf("%35s%n", "Row Sum");
            int[] colSum = new int[3]; // column totals
            int diag1 = 0, diag2 = 0;  // diagonal totals
            for (int i = 0; i < 3; i++) {
                int rowSum = 0; // resets for every row
                for (int j = 0; j < 3; j++) {
                    System.out.printf("%5d", nums[i][j]); // table format
                    rowSum += nums[i][j];
                    colSum[j] += nums[i][j];
                }
                System.out.printf("%15d%n", rowSum);
                diag1 += nums[i][i]; diag2 += nums[i][2 - i]; // both diagonals
            }
            System.out.print("\nColumn sum: ");
            for (int j = 0; j < 3; j++) System.out.printf("%5d", colSum[j]);
            System.out.println("\n==============================================");
            System.out.println("Diagonal sum 1: " + diag1);
            System.out.println("Diagonal sum 2: " + diag2);
            System.out.print("\nTry Again [y|n]: ");
            again = input.next().toLowerCase().charAt(0);
            System.out.println();
        } while (again == 'y'); // repeat if y, stop if n
        input.close();
    }
}
