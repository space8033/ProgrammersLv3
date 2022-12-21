import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {
    ArrayList<String> list = new ArrayList<>();
    boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public void dfs(String point, String route, String[][] tickets, int depth) {
        if(depth == tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0; i < visit.length; i++) {
            if(!visit[i] && point.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visit[i] =false;
            }
        }
    }
}
