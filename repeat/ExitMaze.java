public class ExitMaze {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer;
        int distance = Math.abs(x - r) + Math.abs(y - c);
        k -= distance;

        if(k < 0 || k % 2 != 0) {
            return "impossible";
        }
        StringBuilder sb = new StringBuilder();

        int[] direction = new int[4];
        if(x > r) {
            direction[0] = x - r;
        }else {
            direction[1] = r - x;
        }
        if(y > c) {
            direction[2] = y - c;
        }else {
            direction[3] = c - y;
        }

        for(int i = 0 ; i < direction[1]; i++) {
            sb.append('d');
        }
        int down = Math.min((int)(k / 2), n - (x + direction[1]));
        for(int i = 0; i < down; i++) {
            sb.append('d');
        }
        direction[0] += down;
        k -= 2 * down;

        for(int i = 0; i < direction[2]; i++) {
            sb.append('l');
        }
        int left = Math.min((int)(k / 2), y - direction[2] - 1);
        for(int i = 0; i < left; i++) {
            sb.append('l');
        }
        direction[3] += left;
        k -= 2 * left;

        for(int i = 0; i < (int)(k / 2); i++) {
            sb.append("rl");
        }
        for(int i = 0; i < direction[3]; i++) {
            sb.append('r');
        }
        for(int i = 0; i < direction[0]; i++) {
            sb.append('u');
        }

        answer = sb.toString();

        return answer;
    }
}
