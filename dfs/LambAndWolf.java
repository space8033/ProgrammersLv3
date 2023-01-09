import java.util.ArrayList;
import java.util.List;

public class LambAndWolf {
    ArrayList<Integer>[] children;
    int[] information;
    int max = 0;

    public int solution(int[] info, int[][] edges) {
        information = info;
        children = new ArrayList[info.length];

        for(int[] i : edges) {
            int parent = i[0];
            int child = i[1];

            if(children[parent] == null) {
                children[parent] = new ArrayList<>();
            }
            children[parent].add(child);
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);

        return max;
    }

    public void dfs(int index, int lamb, int wolf, List<Integer> next) {
        if(information[index] == 0) {
            lamb++;
        }else {
            wolf++;
        }

        if(wolf >= lamb) {
            return;
        }

        max = Math.max(lamb, max);

        List<Integer> list = new ArrayList<>();
        list.addAll(next);
        list.remove(Integer.valueOf(index));
        if(children[index] != null) {
            for(int c : children[index]) {
                list.add(c);
            }
        }

        for(int i : list) {
            dfs(i, lamb, wolf, list);
        }
    }
}
