public class PasswordBetweenTwo {
    public String solution(String s, String skip, int index) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < index; j++) {
                chars[i]++;
                if(chars[i] > 'z') {
                    chars[i] -= 26;
                }

                if(skip.contains(String.valueOf(chars[i]))) {
                    j--;
                }
            }
        }

        String answer = String.valueOf(chars);

        return answer;
    }
}
