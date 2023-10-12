import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number of rows");
        int rowCount = scanner.nextInt();

        System.out.println("Enter the Number of columns");
        int columnCount = scanner.nextInt();

        int[][] matrix1 = readMatrix(rowCount, columnCount, scanner, "First");
        int[][] matrix2 = readMatrix(rowCount, columnCount, scanner, "Second");

        System.out.println("=======================================================================");
        System.out.println("First Matrix:");
        printMatrix(matrix1);
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Second Matrix:");
        printMatrix(matrix2);

        int[][] addedResult = addMatrices(matrix1, matrix2);
        System.out.println("=======================================================================");
        System.out.println("Addition Result:");
        printMatrix(addedResult);

        int[][] subtractedResult = subtractMatrices(matrix1, matrix2);
        System.out.println("=======================================================================");
        System.out.println("Subtraction Result:");
        printMatrix(subtractedResult);

        int[][] multipliedResult = multiplyMatrices(matrix1, matrix2);
        System.out.println("=======================================================================");
        System.out.println("Multiplication Result:");
        printMatrix(multipliedResult);
    }

    public static int[][] readMatrix(int rows, int columns, Scanner scanner, String matrixName) {
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the data for " + matrixName + " Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter data for Position(" + i + "," + j + ")");
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int columns = matrix1[0].length;
        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }
        return result;
    }
}