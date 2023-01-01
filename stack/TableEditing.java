import java.util.Stack;

public class TableEditing {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove = new Stack<>();
        int table = n;
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'D') {
                k += Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'U') {
                k -= Integer.parseInt(cmd[i].substring(2));
            }else if(c == 'C'){
                remove.add(k);
                table--;
                if(k == table) {
                    k--;
                }
            }else if(c == 'Z') {
                if(remove.pop() <= k) {
                    k++;
                }
                table++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < table; i++) {
            sb.append("O");
        }
        while (!remove.isEmpty()) {
            sb.insert(remove.pop().intValue(), "X");
        }
        String answer = sb.toString();
        return answer;
    }
}
