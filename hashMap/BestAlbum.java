import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genreList = new ArrayList<>();
        for(String s : map.keySet()) {
            genreList.add(s);
        }
        Collections.sort(genreList, (o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < genreList.size(); i++) {
            String s = genreList.get(i);
            int max = -1;
            int first = -1;

            for(int j = 0; j < genres.length; j++) {
                if(genres[j].equals(s) && max < plays[j]) {
                    max = plays[j];
                    first = j;
                }
            }

            max = 0;
            int second = -1;
            for(int j = 0; j < genres.length; j++) {
                if(genres[j].equals(s) && max < plays[j] && j != first) {
                    max = plays[j];
                    second = j;
                }
            }

            list.add(first);
            if(second >= 0) {
                list.add(second);
            }
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
