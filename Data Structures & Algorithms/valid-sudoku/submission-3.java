class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> rows = new HashMap<>();
        Map<Integer, HashSet<Integer>> columns = new HashMap<>();
        Map<Integer, HashSet<Integer>> boxes = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<Integer>());
            columns.put(i, new HashSet<Integer>());
            boxes.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int no = board[i][j] - '0';
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (rows.get(i).contains(no) || 
                    columns.get(j).contains(no) || 
                    boxes.get(boxIndex).contains(no)) {
                    return false;
                }

                rows.get(i).add(no);
                columns.get(j).add(no);
                boxes.get(boxIndex).add(no);
            }
        }
        return true;
    }
}
