package org.neetcode.graph.shorestpathfinding;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    private static final int[][] directions = new int[][]{
            {-1,1},{-1,0},{-1,-1},{0,-1},{0,1},{1,0},{1,-1},{1,1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length][grid[0].length] != 0) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.offer(new int[]{0,0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length-1 && col == grid[0].length-1){
                return distance;
            }

            for (int[] neighbor : getNeighbors(row, col, grid)){
                int neighborRow = neighbor[0];
                int neighborCol = neighbor[1];
                queue.add(new int[]{neighborRow, neighborCol});
                grid[neighborRow][neighborCol] = distance + 1;
            }
        }
        return -1;
    }

    private List<int[]> getNeighbors(int row, int col, int[][] grid){
        List<int[]> neigh = new ArrayList<>();
        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length || grid[newRow][newCol] != 0) {
                continue;
            }
            neigh.add(new int[]{newRow, newCol});
        }
        return neigh;
    }
}
