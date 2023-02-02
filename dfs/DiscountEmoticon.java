import java.util.ArrayList;
import java.util.List;

public class DiscountEmoticon {
    int[] discount = {10, 20, 30, 40};
    int best = 0;
    int bestSales = 0;
    List<Integer> dis = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int length = emoticons.length;

        for(int i = 0; i < length; i++) {
            emoticons[i] /= 100;
        }

        dfs(0, length, users, emoticons);

        int[] answer = new int[]{best, bestSales};

        return answer;
    }

    private void solve(int[][] users, int[] emoticons) {
        int enroll = 0;
        int sales = 0;

        for(int[] user : users) {
            int buy = 0;
            for(int i = 0; i < emoticons.length; i++) {
                if(dis.get(i) >= user[0]) {
                    buy += emoticons[i] * (100 - dis.get(i));
                }
            }

            if(buy >= user[1]) {
                enroll++;
            }else {
                sales += buy;
            }
        }

        if(best < enroll) {
            best = enroll;
            bestSales = sales;
        }else if(best == enroll) {
            if(bestSales < sales) {
                bestSales = sales;
            }
        }
    }

    private void dfs(int i, int n, int[][] users, int[] emoticons) {
        if(i == n) {
            solve(users, emoticons);
            return;
        }

        for(int j = 0; j < 4; j++) {
            dis.add(discount[j]);
            dfs(i + 1, n, users, emoticons);
            dis.remove(dis.size()-1);
        }
    }
}
