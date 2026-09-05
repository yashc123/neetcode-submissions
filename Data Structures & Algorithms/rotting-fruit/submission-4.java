class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numFresh = 0;
        int minutes = 0;
        Deque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    numFresh++;
                }
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        if (numFresh == 0){
            return 0;
        }
        if (queue.isEmpty()){
            return -1;
        }

        while (!queue.isEmpty() && numFresh > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                if (r + 1 < rows && grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    numFresh--;
                    queue.offer(new int[]{r+1, c});
                }
                if (r - 1 >= 0 && grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    numFresh--;
                    queue.offer(new int[]{r-1, c});
                }
                if (c + 1 < cols && grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    numFresh--;
                    queue.offer(new int[]{r, c+1});
                }
                if (c - 1 >= 0 && grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    numFresh--;
                    queue.offer(new int[]{r, c-1});
                }
            }
            minutes++;
        }

        if(numFresh == 0){
            return minutes;
        }

        return -1;
    }
}
