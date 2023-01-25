public class ExpressBinaryTree {
    private static int[] answer;

    public int[] solution(long[] numbers) {
        answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            String current = Long.toBinaryString(numbers[i]);
            int j = 0;

            while ((int)Math.pow(2, j) - 1 < current.length()) {
                j++;
            }
            while ((int)Math.pow(2, j) - 1 != current.length()) {
                current = "0" + current;
            }

            if(dfs(current)) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private static boolean dfs(String s) {
        boolean valid = true;

        int mid = (s.length() - 1) / 2;
        char c = s.charAt(mid);
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);

        if(c == '0' && (left.charAt((left.length() - 1) / 2) == '1' || right.charAt((right.length() - 1) / 2) == '1')) {
            return false;
        }

        if(left.length() >= 3) {
            valid = dfs(left);

            if(valid) {
                valid = dfs(right);
            }
        }

        return valid;
    }
}
