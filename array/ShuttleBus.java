import java.util.ArrayList;
import java.util.Collections;

public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < timetable.length; i++) {
            list.add(timeChange(timetable[i]));
        }
        Collections.sort(list);
        int start = 540;
        int last = 0;
        int index = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            cnt = 0;
            if(index >= list.size()) {
                break;
            }

            while (cnt < m) {
                if(start >= list.get(index)) {
                    last = list.get(index);
                    index++;
                    cnt++;

                    if(index >= list.size()) {
                        break;
                    }
                }else {
                    break;
                }
            }

            start += t;
        }

        if(cnt < m) {
            answer = reverse(start - t);
        }else {
            answer = reverse(last - 1);
        }

        return answer;
    }

    public int timeChange(String s) {
        String[] tmp = s.split(":");
        int hour = Integer.parseInt(tmp[0]);
        int minute = Integer.parseInt(tmp[1]);

        return hour * 60 + minute;
    }

    public String reverse(int i) {
        String hour = String.valueOf(i / 60);
        String minute = String.valueOf(i % 60);

        if(hour.length() < 2) {
            hour = "0" + hour;
        }
        if(minute.length() < 2) {
            minute = "0" + minute;
        }

        return hour + ":" + minute;
    }
}
