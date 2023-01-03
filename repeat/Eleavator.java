public class Elevator {
    public int solution(int storey) {
        int answer = 0;
        String s = String.valueOf(storey);
        String[] arrStr = s.split("");
        int[] arr = new int[arrStr.length];

        for(int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] > 5) {
                answer += 10 - arr[i];

                if(i == 0) {
                    answer++;
                }else {
                    arr[i-1]++;
                }
            }else if(arr[i] == 5 && i > 0 && arr[i-1] >= 5) {
                answer += 5;
                arr[i-1]++;
            }else {
                answer += arr[i];
            }
        }

        return answer;
    }
}
