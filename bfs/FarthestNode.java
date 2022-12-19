import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    boolean[] check;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        check = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(i, new ArrayList<>());
        }

        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        answer = bfs();

        return answer;
    }

    public int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        check[1] = true;
        int cnt = 0;

        while (true) {
            Queue<Integer> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for(int i : list.get(cur)) {
                    if(!check[i]) {
                        tmp.add(i);
                        check[i] = true;
                    }
                }
            }

            if(tmp.isEmpty()) {
                break;
            }
            queue.addAll(tmp);
            cnt = tmp.size();
        }

        return cnt;
    }
}
