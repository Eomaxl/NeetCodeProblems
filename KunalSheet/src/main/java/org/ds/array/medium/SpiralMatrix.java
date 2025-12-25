package org.ds.array.medium;
import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = spiralPrint(matrix);
        for(int i: result){
            System.out.print(i+" , ");
        }

    }

    public static List<Integer> spiralPrint(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int column = 0;
        int VISITED = 101;
        int[][] directions = {{0,1},{1,0},{0,-1},{0,1}};
        int currentDirection = 0;
        int changeDirection = 0;
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;

        while (changeDirection < 2){
            while (
                row + directions[currentDirection][0] >= 0 && row + directions[currentDirection][0] < matrix.length &&
                column + directions[currentDirection][1] >=0 && column + directions[currentDirection][1] < matrix[0].length &&
                matrix[row + directions[currentDirection][0]][column + directions[currentDirection][1]] != VISITED
            ){
                // Reset the direction to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                column = column + directions[currentDirection][1];
                result.add(matrix[row][column]);
                matrix[row][column] = VISITED;
            }
            currentDirection = (currentDirection + 1) % 4;
            changeDirection++;
        }
        return result;
    }
}
