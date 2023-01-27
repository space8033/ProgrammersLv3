import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisitIsland {
    public int[] solution(String[] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < maps.length; i++) {
            int sum = 0;

            for(int j = 0; j < maps[0].length(); j++) {
                sum = area(i, j, visited, maps);

                if(sum != 0) {
                    list.add(sum);
                }
            }

        }

        if(list.size() == 0) {
            return new int[]{-1};
        }
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int area(int i, int j, boolean[][] visited, String[] maps) {
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || maps[i].charAt(j) == 'X') {
            return 0;
        }else {
            visited[i][j] = true;
        }

        int food = maps[i].charAt(j) - '0';

        return food + area(i - 1, j, visited, maps) + area(i + 1, j, visited, maps) + area(i , j - 1, visited, maps) + area(i, j + 1, visited, maps);
    }
}
