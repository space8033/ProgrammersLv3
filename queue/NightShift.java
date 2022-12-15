import java.util.Collections;
import java.util.PriorityQueue;

public class NightShift {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : works) {
            queue.add(i);
        }

        for(int i = 0; i < n; i ++) {
            queue.add(queue.poll() - 1);
        }

        for(int i : queue) {
            if(i < 0) {
                continue;
            }else {
                answer += i * i;
            }
        }
        return answer;
    }
}
