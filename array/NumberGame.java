import java.util.Arrays;

public class NumberGame {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int index = A.length - 1;
        for(int i = A.length - 1; i >= 0; i--) {
            if(B[index] > A[i]) {
                answer++;
                index--;
            }
        }

        return answer;
    }
}
