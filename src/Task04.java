import java.util.Random;

public class Task04 {
    public static void main(String[] args) {
        System.out.println("Задание 4");

        int numRows = 5;

        int[][] triangle = generateTriangle(numRows);

        printTriangle(triangle);

        int maxSum = findMaxPathSum(triangle);

        System.out.println("Максимальная сумма чисел: " + maxSum);

    }


    private static int[][] generateTriangle(int numRows) {

        int[][] triangle = new int[numRows][];


        Random random = new Random();

        for (int i = 0; i < numRows; i++) {

            triangle[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {

                triangle[i][j] = random.nextInt(100);

            }

        }

        return triangle;

    }


    private static void printTriangle(int[][] triangle) {

        for (int i = 0; i < triangle.length; i++) {

            for (int j = 0; j < triangle[i].length; j++) {

                System.out.print(triangle[i][j] + " ");

            }

            System.out.println();

        }

    }

    private static int findMaxPathSum(int[][] triangle) {

        int numRows = triangle.length;


        int[][] maxSumTriangle = new int[numRows][];

        for (int i = 0; i < numRows; i++) {

            maxSumTriangle[i] = new int[i + 1];

        }

        for (int j = 0; j < triangle[numRows - 1].length; j++) {

            maxSumTriangle[numRows - 1][j] = triangle[numRows - 1][j];

        }

        for (int i = numRows - 2; i >= 0; i--) {

            for (int j = 0; j < triangle[i].length; j++) {

                maxSumTriangle[i][j] = triangle[i][j] + Math.max(maxSumTriangle[i + 1][j], maxSumTriangle[i + 1][j + 1]);

            }

        }

        int row = 0;

        int col = 0;

        StringBuilder path = new StringBuilder();

        while (row < numRows - 1) {

            path.append((col == 0 || maxSumTriangle[row + 1][col] > maxSumTriangle[row + 1][col + 1]) ? "Влево, " : "Вправо, ");

            col = (col == 0 || maxSumTriangle[row + 1][col] > maxSumTriangle[row + 1][col + 1]) ? col : col + 1;

            row++;

        }

        System.out.println("Путь с максимальной суммой: " + path.toString());
        return maxSumTriangle[0][0];

    }

}



