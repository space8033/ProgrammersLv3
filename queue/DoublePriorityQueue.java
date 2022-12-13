import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> dsc = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < operations.length; i++) {
            String[] str = operations[i].split(" ");
            int a = Integer.parseInt(str[1]);

            if(str[0].equals("I")) {
                asc.add(a);
                dsc.add(a);
            }else if(a == -1) {
                dsc.remove(asc.poll());
            }else {
                asc.remove(dsc.poll());
            }
        }

        if(asc.size() > 0) {
            answer[0] = dsc.peek();
            answer[1] = asc.peek();
        }

        return answer;
    }
}
