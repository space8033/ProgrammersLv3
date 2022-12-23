public class MakeSmallerNum {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length();

        for(int i = 0; i < t.length() - length + 1; i++) {
            long a = Long.parseLong(t.substring(i, i + length));

            if(Long.parseLong(p) >= a) {
                answer++;
            }
        }

        return answer;
    }
}
