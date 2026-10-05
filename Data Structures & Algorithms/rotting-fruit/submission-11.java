class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int freshFruits = 0;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                }
                if(grid[r][c] == 1){
                    freshFruits++;
                }
            }
        }

        if(freshFruits == 0){
            return 0;
        }

        if(queue.isEmpty()){
            return -1;
        }

        int minutes = 0;
        while(!queue.isEmpty() && freshFruits > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] recent = queue.poll();
                int r = recent[0];
                int c = recent[1];

                if(r + 1 < rows && grid[r + 1][c] == 1){
                    freshFruits--;
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                if(c + 1 < cols && grid[r][c + 1] == 1){
                    freshFruits--;
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                }
                if(r - 1 >= 0 && grid[r - 1][c] == 1){
                    freshFruits--;
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                } 
                if(c - 1 >= 0 && grid[r][c - 1] == 1){
                    freshFruits--;
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }
            }
            minutes++;
        }

        if(freshFruits == 0){
            return minutes;
        }

        return -1;
    }


}