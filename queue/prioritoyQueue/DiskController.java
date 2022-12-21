import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int time = 0;
        int index = 0;
        int done = 0;
        int length = jobs.length;

        while (done < length) {
            while (index < length && jobs[index][0] <= time) {
                queue.add(jobs[index++]);
            }

            if(queue.isEmpty()) {
                time = jobs[index][0];

            }else {
                int[] tmp = queue.poll();
                answer += tmp[1] + time - tmp[0];
                time += tmp[1];
                done++;
            }
        }

        answer = (int) Math.floor(answer / length);

        return answer;
    }
}
