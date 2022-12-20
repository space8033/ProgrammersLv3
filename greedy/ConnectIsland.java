import java.util.Arrays;
import java.util.Comparator;

public class ConnectIsland {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        }

        for(int i = 0; i < costs.length; i++) {
            if(findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }
        return answer;
    }
    public int findParent(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }
        return findParent(parent, parent[node]);
    }

    public void union(int[] parent, int a, int b) {
        int p1 = findParent(parent, a);
        int p2 = findParent(parent, b);

        if(p1 < p2) {
            parent[p2] = p1;
        }else {
            parent[p1] = p2;
        }
    }
}
