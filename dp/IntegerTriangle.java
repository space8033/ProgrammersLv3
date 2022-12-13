public class IntegerTriangle {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] dp = new int[length][length];
        int answer = 0;

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < length; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];

            for(int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }

            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for(int i = 0; i < length; i++) {
            answer = Math.max(answer, dp[length-1][i]);
        }

        return answer;
    }
}
