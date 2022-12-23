public class ConstructRoad {
    int n, m;
    int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};

    public int solution(int[][] board) {
        n = board.length;;
        m = board[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != 1) {
                    board[i][j] = Integer.MAX_VALUE - 1000;
                }
            }
        }

        dfs(board, 0, 0, 0, 0);
        return board[n-1][m-1];
    }

    public void dfs(int[][] board, int dir, int sum, int i, int j) {
        if( i < 0 ||  j < 0 || i >= n || j >= m || board[i][j] == 1 || board[i][j] + 500 < sum) {
            return;
        }

        board[i][j] = Math.min(board[i][j], sum);

        for(int a = 0; a < dirs.length; a++) {
            if(i == 0 && j == 0) {
                dfs(board, a, sum + 100, i + dirs[a][0], j + dirs[a][1]);
                continue;
            }

            if(dir == a) {
                dfs(board, a, sum + 100, i + dirs[a][0], j + dirs[a][1]);
            }else {
                dfs(board, a, sum + 600, i + dirs[a][0], j + dirs[a][1]);
            }
        }
    }
}