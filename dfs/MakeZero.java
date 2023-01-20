import java.util.ArrayList;

public class MakeZero {
    long answer;
    boolean[] visited;
    long[] arrayA;
    ArrayList<Integer>[] children;

    public long solution(int[] a, int[][] edges) {
        this.answer = 0;
        this.visited = new boolean[a.length];
        this.children = new ArrayList[a.length];
        this.arrayA = new long[a.length];

        long sum = 0;
        for(int i = 0; i < a.length; i++) {
            sum += a[i];
            children[i] = new ArrayList<>();
            arrayA[i] = a[i];
        }

        if(sum != 0) {
            return -1;
        }

        for(int i = 0; i < edges.length; i++) {
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return answer;
    }

    public long dfs(int x) {
        this.visited[x] = true;

        for(int i = 0; i < children[x].size(); i++) {
            int next = children[x].get(i);
            if(!visited[next]) {
                arrayA[x] += dfs(next);
            }
        }

        this.answer += Math.abs(arrayA[x]);

        return arrayA[x];
    }
}
