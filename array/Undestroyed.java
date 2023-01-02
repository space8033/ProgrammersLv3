public class Undestroyed {
    int[][] sum;
    int n, m;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;;
        m = board[0].length;
        sum = new int[n + 1][m + 1];

        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            if(type == 1) {
                degree *= -1;
            }

            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }
        operate();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] + sum[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public void operate() {
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sum[i][j] += sum[i-1][j];
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sum[j][i] += sum[j][i-1];
            }
        }
    }
}
