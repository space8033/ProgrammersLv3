import java.util.HashSet;

public class NumberConvert {
    public int solution(int x, int y, int n) {
        HashSet<Integer> current = new HashSet<>();
        HashSet<Integer> next = null;
        current.add(x);
        int cnt = 0;

        while (!current.isEmpty()) {
            if (current.contains(y)) {
                return cnt;
            }
            next = new HashSet<>();
            for(int value : current) {
                int plus = value + n;
                int value2 = value * 2;
                int value3 = value * 3;

                if(plus <= y) {
                    next.add(plus);
                }
                if(value2 <= y) {
                    next.add(value2);
                }
                if(value3 <= y) {
                    next.add(value3);
                }

            }
            current = next;
            cnt++;
        }
        return -1;
    }
}
