public class BestSet {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s) {
            return new int[]{-1};
        }

        for(int i = 0; i < n - (s % n); i++) {
            answer[i] = s / n;
        }
        for(int i = n - (s % n); i < n; i++) {
            answer[i] = s / n + 1;
        }
        return answer;
    }
}
