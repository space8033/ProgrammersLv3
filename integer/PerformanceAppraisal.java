import java.util.Arrays;

public class PerformanceAppraisal {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int wanhoTotal = wanho[0] + wanho[1];
        int max = 0;

        for(int[] score : scores) {
            if(score[1] < max) {
                if(score.equals(wanho)) {
                    return -1;
                }
            }else {
                max = Math.max(max, score[1]);
                if(score[0] + score[1] > wanhoTotal) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
