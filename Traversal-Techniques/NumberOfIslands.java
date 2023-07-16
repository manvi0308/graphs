import java.util.*;

class Pair {
    int r;
    int c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class NumberOfIslands {
    static void bfsCount(int r, int c, boolean[][] visited, int[][] matrix) {
        visited[r][c] = true;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(r, c));
        int n = matrix.length;
        int m = matrix[0].length;

        while (!queue.isEmpty()) {
            int row = queue.peek().r;
            int col = queue.peek().c;
            queue.remove();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int nrow = delRow + row;
                    int ncol = delCol + col;

                    // check+ for row and column constraints
                    if (nrow >= 0 && nrow <= n && ncol >= 0 && ncol <= m
                            && matrix[nrow][ncol] == '1' &&
                            visited[nrow][ncol] == false) {
                        visited[nrow][ncol] = true;
                        bfsCount(nrow, ncol, visited, matrix);
                    }
                }
            }
        }
    }

    // Island is land surrounded by water on all 8 sides
    static int numIslands(int[][] matrix) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    count++;
                    bfsCount(i, j, visited, matrix);
                }
            }
        }
        return count;
    }

}
