import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JewelShopping {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String s : gems) {
            set.add(s);
        }

        int start = 0;
        int tmp = 0;
        int length = gems.length;

        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            queue.add(gems[i]);

            while (true) {
                String str = queue.peek();
                if(map.get(str) > 1) {
                    map.put(str, map.get(str) - 1);
                    queue.poll();
                    tmp++;
                }else {
                    break;
                }
            }

            if(map.size() == set.size()) {
                if(length > queue.size()) {
                    length = queue.size();
                    start = tmp;
                }
            }
        }

        answer[0] = start + 1;
        answer[1] = start + length;

        return answer;
    }
}
