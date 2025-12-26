package org.ds.array.medium;

public class MaxAreaOfIsland {
    private int[][] grid;
    private boolean[][] seen;
    public static void main(String[] args){}

    public int maxArea(int[][] grid){
        int area = 0;
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        for(int r =0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                area = Math.max(area, dfs(r,c));
            }
        }
        return area;
    }

    public int dfs(int r, int c){
        if (r <0 || r >=grid.length || c < 0 || c > grid[0].length || grid[r][c] == 0 || seen[r][c]){
            return 0;
        }
        seen[r][c] = true;
        return (1 + dfs(r+1, c) + dfs(r-1, c) + dfs(r, c-1) + dfs(r,c+1));
    }

}
