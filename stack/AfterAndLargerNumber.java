import java.util.Stack;

public class AfterAndLargerNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < numbers.length; i++) {
            if(stack.isEmpty() || numbers[i] < numbers[i - 1]) {
                stack.push(i);
            }else {
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
