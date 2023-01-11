import java.util.ArrayList;
import java.util.List;

public class OuterWall {
    boolean[] visited;
    int[] dist;
    int answer;
    List<Integer> workers = new ArrayList<>();

    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;
        visited = new boolean[dist.length];
        answer = dist.length + 1;

        for(int i = 0; i < weak.length; i++) {
            int[] shiftWeak = new int[weak.length];

            for(int j = 0; j < weak.length - i; j++) {
                shiftWeak[j] = weak[i + j];
            }

            for(int j = weak.length - i; j < weak.length; j++) {
                shiftWeak[j] = weak[j + i - weak.length] + n;
            }

            for(int j = 1; j <= dist.length; j++) {
                dfs(0, j, shiftWeak);
                if(j >= answer) {
                    break;
                }
            }
        }

        if(answer == dist.length + 1) {
            return  -1;
        }else {
            return answer;
        }
    }

    public void dfs(int depth, int max, int[] weak) {
        if(depth == max) {
            if(canFix(weak)) {
                answer = Math.min(depth, answer);
            }
            return;
        }

        for(int i = 0; i < dist.length; i++) {
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            workers.add(i);
            dfs(depth + 1, max, weak);
            workers.remove(workers.size() - 1);
            visited[i] = false;
        }
    }

    public boolean canFix(int[] weak) {
        int index = -1;

        for(int worker : workers) {
            int d = weak[index + 1] + dist[worker];

            for(int i = index + 1; i < weak.length; i++) {
                if(weak[i] <= d) {
                    index = i;
                }else {
                    break;
                }
            }
        }

        if(index == weak.length - 1) {
            return true;
        }else {
            return false;
        }
    }
}
