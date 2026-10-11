class Solution {
    private boolean isValid(int row, int col, ArrayList<StringBuilder> board){
        int r = row;
        int c = col;

        while(row >= 0 && col >= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        row = r;
        col = c;

        while(col >= 0){
            if(board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        col = c;

        while(row < board.size() && col >= 0){
            if(board.get(row).charAt(col) =='Q') return false;
            row++;
            col--; 
        }

        return true;
    }

    private void backtrack(List<List<String>> res, ArrayList<StringBuilder> board, int col, int n){
        if(col == n){
            ArrayList<String> temp = new ArrayList<>();

            for(StringBuilder s : board){
                temp.add(s.toString());
            }
            res.add(temp);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(isValid(i, col, board)){
                board.get(i).setCharAt(col, 'Q');
                backtrack(res, board, col+1, n);
                board.get(i).setCharAt(col, '.');
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        ArrayList<StringBuilder> board = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            StringBuilder s = new StringBuilder();
            
            for(int j = 0 ; j < n ; j++) s.append('.');
            
            board.add(s);
        }

        backtrack(res, board, 0, n);
        return res;
    }
}
