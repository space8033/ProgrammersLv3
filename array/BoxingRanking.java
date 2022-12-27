public class BoxingRanking {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] match = new int[n + 1][n + 1];

        for(int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];

            match[winner][loser] = 1;
            match[loser][winner] = -1;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                for(int k = 1; k < n + 1; k++) {
                    if(match[i][k] == 1 && match[k][j] == 1) {
                        match[i][j] = 1;
                        match[j][i] = -1;
                    }
                    if(match[i][k] == -1 && match[k][j] == -1) {
                        match[i][j] = -1;
                        match[j][i] = 1;
                    }
                }
            }
        }

        for(int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for(int j = 1; j < n + 1; j++) {
                if(match[i][j] != 0) {
                    cnt++;
                }
            }

            if(cnt == n-1) {
                answer++;
            }
        }

        return answer;
    }
}