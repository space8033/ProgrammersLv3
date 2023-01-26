import java.util.*;

public class ClimbingCourse {
    private int resultNode = Integer.MAX_VALUE;
    private int minIntensity = Integer.MAX_VALUE;
    private List<Node>[] node;
    private int[] list;
    private Set<Integer> gateSet = new HashSet<>();
    private Set<Integer> summitSet = new HashSet<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        node = new List[n + 1];
        list = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for(int gate : gates) {
            gateSet.add(gate);
        }

        for(int summit : summits) {
            summitSet.add(summit);
        }

        for(int[] path : paths) {
            if(gateSet.contains(path[0]) || summitSet.contains(path[1])) {
                node[path[0]].add(new Node(path[1], path[2]));
            }else if(gateSet.contains(path[1]) || summitSet.contains(path[0])) {
                node[path[1]].add(new Node(path[0], path[2]));
            }else {
                node[path[0]].add(new Node(path[1], path[2]));
                node[path[1]].add(new Node(path[0], path[2]));
            }
        }

        dijkstra(n, gates, summits);

        return new int[]{resultNode, minIntensity};
    }

    public void dijkstra(int n , int[] gates, int[] summits) {
        Queue<int[]> queue = new ArrayDeque<>();
        Arrays.fill(list, Integer.MAX_VALUE);

        for(int gate : gates) {
            queue.add(new int[]{gate, 0});
            list[gate] = 0;
        }

        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            if(list[x] < y) {
                continue;
            }

            for(Node next : node[x]) {
                int dis = Math.max(list[x], next.y);
                if(list[next.x] > dis) {
                    list[next.x] = dis;
                    queue.add(new int[]{next.x, dis});
                }
            }
        }

        Arrays.sort(summits);

        for(int summit : summits) {
            if(minIntensity > list[summit]) {
                minIntensity = list[summit];
                resultNode = summit;
            }
        }
    }
}

class Node {
    int x,y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
