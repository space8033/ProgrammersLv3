public class BalloonBoom {
    public int solution(int[] a) {
        if(a.length == 1) {
            return 1;
        }
        int answer = 2;
        int min = Integer.MAX_VALUE;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];

        for(int i = 0; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
            leftMin[i] = min;
        }

        min = Integer.MAX_VALUE;

        for(int i = a.length-1; i >= 0; i--) {
            if(min > a[i]) {
                min = a[i];
            }
            rightMin[i] = min;
        }

        for(int i = 1; i < a.length-1; i++) {
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) {
                continue;
            }
            answer++;
        }

        return answer;
    }
}
