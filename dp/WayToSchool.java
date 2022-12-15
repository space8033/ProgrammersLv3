public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] ways = new int[n + 1][m + 1];
        for(int i = 0; i < puddles.length; i++) {
            ways[puddles[i][1]][puddles[i][0]] = -1;
        }

        ways[1][1] = 1;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j ++) {
                if(ways[i][j] == -1) {
                    continue;
                }
                if(ways[i-1][j] > 0) {
                    ways[i][j] += ways[i-1][j] % 1000000007;
                }
                if(ways[i][j-1] > 0) {
                    ways[i][j] += ways[i][j-1] % 1000000007;
                }
            }
        }

        answer = ways[n][m] % 1000000007;

        return answer;
    }
}
