import java.util.*;

public class UnitReturn {
    int N, D;
    List<List<Integer>> edge;
    int[] min;

    public class Point {
        int n, c;
        public Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        N = n;
        D = destination;
        edge = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            edge.add(new ArrayList<>());
        }

        for(int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];

            edge.get(from).add(to);
            edge.get(to).add(from);
        }

        min = new int[N + 1];
        Arrays.fill(min, -1);
        dijkstra();

        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++) {
            answer[i] = min[sources[i]];
        }

        return answer;
    }

    public int dijkstra() {
        Queue<Point> queue = new ArrayDeque<>();
        min[D] = 0;
        queue.add(new Point(D, 0));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i = 0; i < edge.get(current.n).size(); i++) {
                int nextN = edge.get(current.n).get(i);
                if(min[nextN] != -1) {
                    continue;
                }
                min[nextN] = current.c + 1;
                queue.add(new Point(nextN, current.c + 1));
            }
        }

        return -1;
    }
}
