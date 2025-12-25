package org.ds.array.medium;

public class RotateAntiClockwiseMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(matrix);
        for(int[] arr: matrix){
            for(int i : arr){
                System.out.print(i+" | ");
            }
            System.out.println();
        }
    }

    public static void rotateImage(int[][] matrix){
        int n = matrix.length;
        for (int i =0; i< (n+1)/2; i++){
            for (int j =0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = temp;
            }
        }
    }
}
