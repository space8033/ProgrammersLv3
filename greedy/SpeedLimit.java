import java.util.Arrays;
import java.util.Comparator;

public class SpeedLimit {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int location = routes[0][1];

        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] > location) {
                answer++;
                location = routes[i][1];
            }
        }
        return answer;
    }
}
