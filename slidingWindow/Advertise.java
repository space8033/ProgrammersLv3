public class Advertise {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int play = toInt(play_time);
        int adv = toInt(adv_time);
        int[] total = new int[play + 1];

        for(String t : logs) {
            String[] time = t.split("-");
            int start = toInt(time[0]);
            int end = toInt(time[1]);

            for(int i = start; i < end; i++) {
                total[i]++;
            }
        }

        long max = 0;
        for(int i = 1; i < adv; i++) {
            max += total[i];
        }

        long now = max;
        int t = 0;
        for(int i = adv; i < play; i++) {
            now += (total[i] - total[i - adv]);
            if(now > max) {
                t = i - adv + 1;
                max = now;
            }
        }

        answer = toStr(t);

        return answer;
    }

    public int toInt(String s) {
        String[] arr = s.split(":");

        return (Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]));
    }

    public String toStr(int a) {
        String hh, mm, ss;

        if(a / 3600 > 9) {
            hh = a / 3600 + "";
        }else {
            hh = "0" + a / 3600;
        }

        a %= 3600;

        if(a / 60 > 9) {
            mm = a / 60 + "";
        }else {
            mm = "0" + a / 60;
        }

        a %= 60;

        if(a > 9) {
            ss = a + "";
        }else {
            ss = "0" + a;
        }

        return hh + ":" + mm + ":" + ss;
    }
}
