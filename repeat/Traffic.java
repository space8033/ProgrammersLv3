public class Traffic {
    public int solution(String[] lines) {
        int answer = 1;
        int[][] toInt = new int[lines.length][2];
        int index = 0;

        for(String s : lines) {
            int hour = Integer.valueOf(s.substring(11, 13));
            int minute = Integer.valueOf(s.substring(14, 16));
            double second = Double.valueOf(s.substring(17, 23));
            double milliSecond = Double.valueOf(s.substring(24, s.length() - 1));

            toInt[index][1] = hour * 3600 * 1000 + minute * 60 * 1000 + (int)(second * 1000);
            toInt[index][0] = toInt[index][1] - (int) (milliSecond * 1000) + 1;
            index++;
        }

        for(int i = 0; i < toInt.length; i++) {
            int cnt = 1;
            for(int j = i + 1; j < toInt.length; j++) {
                if(toInt[i][1] + 999 >= toInt[j][0]) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
