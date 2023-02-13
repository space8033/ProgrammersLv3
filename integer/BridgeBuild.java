import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BridgeBuild {

    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combi(M, N)).append('\n');
        }

        System.out.println(sb);

    }

    static int combi(int n, int m) {

        // 이미 풀린 경우 바로 반환
        if(dp[n][m] > 0) {
            return dp[n][m];
        }

        // 2번 성질
        if(n == m || m == 0) {
            return dp[n][m] = 1;
        }

        // 1번 성질
        return dp[n][m] = combi(n - 1, m - 1) + combi(n - 1, m);
    }
}