public class LongestPalindrome {
    public int solution(String s){
        int answer = 1;
        int length = s.length();

        for(int i = length; i > 0; i--) {
            for(int j = 0; j + i <= length; j++) {
                if(palindrome(s, j, j + i - 1)) {
                    return i;
                }
            }
        }

        return answer;
    }

    public boolean palindrome(String s, int start, int end) {
        while (start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
