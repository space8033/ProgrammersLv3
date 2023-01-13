import java.util.Stack;

public class Move110 {
    public String[] solution(String[] s) {
        int length = s.length;
        String[] answer = new String[length];
        StringBuilder sb;

        for(int i = 0; i < length; i++) {
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int cnt = 0;

            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if(stack.size() > 1) {
                    char x = stack.pop();
                    char y = stack.pop();

                    if(y == '1' && x == '1' && c == '0') {
                        cnt++;
                    }else {
                        stack.push(y);
                        stack.push(x);
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }

            int index = stack.size();
            boolean flag = false;
            sb = new StringBuilder();

            while (!stack.isEmpty()) {
                if(!flag) {
                    if(stack.peek() == '1') {
                        index--;
                    }else {
                        flag = true;
                    }
                }
                sb.insert(0, stack.pop());
            }

            if(cnt > 0) {
                while (cnt-- > 0) {
                    sb.insert(index, "110");
                    index += 3;
                }
                answer[i] = sb.toString();
            }else {
                answer[i] = s[i];
            }
        }
        return answer;
    }
}
