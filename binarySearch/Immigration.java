import java.util.Arrays;

public class Immigration {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 0;
        long end = (long)times[times.length-1] * n;

        while (start <= end) {
            long sum = 0;
            long mid = (start + end) / 2;

            for(int a : times) {
                sum += mid / a;
            }

            if(sum >= n) {
                end = mid - 1;
                answer = mid;
            }else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
