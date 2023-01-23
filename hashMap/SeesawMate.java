import java.util.*;

public class SeesawMate {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int length = weights.length;

        for(int i = 0; i < length; i++) {
            if(!map.containsKey(weights[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(weights[i], list);
            }else {
                map.get(weights[i]).add(i);
            }

            set.add(weights[i]);
        }

        for(int key : set) {
            int keySize = map.get(key).size();
            int keyX2 = key * 2;
            int keyX3 = key * 3;
            int keyX4 = key * 4;

            if(keyX2 % 3 == 0) {
                if(map.containsKey(keyX2 / 3)) {
                    answer += (long) map.get(keyX2 / 3).size() * keySize;
                }
            }
            if(keyX2 % 4 == 0) {
                if(map.containsKey(keyX2 / 4)) {
                    answer += (long) map.get(keyX2 / 4).size() * keySize;
                }
            }

            if(keyX3 % 2 == 0) {
                if(map.containsKey(keyX3 / 2)) {
                    answer += (long) map.get(keyX3 / 2).size() * keySize;
                }
            }
            if(keyX3 % 4 == 0) {
                if(map.containsKey(keyX3 / 4)) {
                    answer += (long) map.get(keyX3 / 4).size() * keySize;
                }
            }

            if(keyX4 % 2 == 0) {
                if(map.containsKey(keyX4 / 2)) {
                    answer += (long) map.get(keyX4 / 2).size() * keySize;
                }
            }
            if(keyX4 % 3 == 0) {
                if(map.containsKey(keyX4 / 3)) {
                    answer += (long) map.get(keyX4 / 3).size() * keySize;
                }
            }

            if(keySize > 1) {
                answer += (long)keySize * (long)(keySize - 1) / 2;
            }

            map.remove(key);
        }

        return answer;
    }
}
