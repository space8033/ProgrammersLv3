import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MadeByN {
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }

        setList.get(1).add(N);

        if(number == N) {
            return 1;
        }

        for(int i = 2; i < 9; i++) {
            for(int j = 1; j <= i / 2; j++) {
                combineSet(setList.get(i), setList.get(i - j), setList.get(j));
                combineSet(setList.get(i), setList.get(j), setList.get(i - j));
            }

            String nn = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(nn.repeat(i)));

            for(int num : setList.get(i)) {
                if(num == number) {
                    return i;
                }
            }
        }

        return -1;
    }

    public void combineSet(Set<Integer> combine, Set<Integer> a, Set<Integer> b) {
        for(int n1 : a) {
            for(int n2 : b) {
                combine.add(n1 + n2);
                combine.add(n1 - n2);
                combine.add(n1 * n2);
                if(n2 != 0) {
                    combine.add(n1 / n2);
                }
            }
        }
    }
}
