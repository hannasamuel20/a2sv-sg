package Week3.Snapchat;
import java.util.*;

public class Q2 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid.length];
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        visited[0][0] = true;
        if(grid[0][0] == 0)
            queue.offer(new int[]{0,0});

        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] cell = queue.poll();
                if(cell[0] == grid.length-1 && cell[1] == grid.length-1) return res+1;
                for(int[] direction : directions){
                    int row = cell[0]+direction[0];
                    int column = cell[1]+direction[1];
                    if(row < 0 || row >= grid.length || column < 0 || column >= grid.length ||
                            visited[row][column] || grid[row][column] == 1)
                        continue;
                    visited[row][column] = true;
                    queue.offer(new int[]{row,column});
                }
            }
            res++;
        }

        return -1;

    }
}
