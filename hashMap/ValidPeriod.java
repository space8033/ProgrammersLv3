import java.util.ArrayList;
import java.util.HashMap;

public class ValidPeriod {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        ArrayList<Integer> list = new ArrayList<>();
        int todayInt = dayToInt(today);

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] str = terms[i].split(" ");
            map.put(str[0], Integer.parseInt(str[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            int issue = dayToInt(str[0]);
            String s = str[1];

            int valid = map.get(s);
            int expired = issue + valid * 28;

            if(todayInt >= expired) {
                list.add(i + 1);
            }
        }
        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int dayToInt(String date) {
        String[] arr = date.split("\\.");

        int dd = Integer.parseInt(arr[2]);
        int mm = Integer.parseInt(arr[1]);
        int yy = Integer.parseInt(arr[0]);

        return yy * 28 * 12 + mm * 28 + dd;
    }
}
