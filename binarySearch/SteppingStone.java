public class SteppingStone {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1;
        int high = 200000000;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if(cross(stones, k, mid)) {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }else {
                high = mid - 1;
            }
        }

        return answer;
    }

    public boolean cross(int[] stones, int k, int mid) {
        int distance = 0;

        for(int num : stones) {
            if(num - mid < 0) {
                distance++;
            }else {
                distance = 0;
            }

            if(distance == k) {
                return false;
            }
        }

        return true;
    }
}
