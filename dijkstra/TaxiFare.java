import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaxiFare {
    int[][] matrix;
    int num;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        num = n;
        matrix = new int[n][n];

        for(int i = 0; i < fares.length; i++) {
            int from = fares[i][0] - 1;
            int to = fares[i][1] - 1;
            int cost = fares[i][2];

            matrix[from][to] = cost;
            matrix[to][from] = cost;
        }

        int[] total = dijkstra(s - 1);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int[] alone = dijkstra(i);
            int cost = total[i] + alone[a-1] + alone[b-1];
            if(cost < min) {
                min = cost;
            }
        }

        answer = min;
        return answer;
    }

    public int[] dijkstra(int from) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        boolean[] visit = new boolean[num];
        int[] distance = new int[num];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[from] = 0;
        queue.add(new int[] { 0, from});

        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            int to = now[1];

            if(visit[to]) {
                continue;
            }
            visit[to] = true;

            for(int i = 0; i < num; i++) {
                if(matrix[to][i] == 0) {
                    continue;
                }
                if(distance[to] + matrix[to][i] < distance[i]) {
                    distance[i] = distance[to] + matrix[to][i];
                    queue.add(new int[] {distance[i], i});
                }
            }
        }

        return distance;
    }
}
