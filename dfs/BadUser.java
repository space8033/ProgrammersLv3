import java.util.HashSet;
import java.util.LinkedHashSet;

public class BadUser {
    HashSet<HashSet<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        result = new HashSet<>();

        dfs(new LinkedHashSet<>(), user_id, banned_id);
        answer = result.size();

        return answer;
    }

    public void dfs(HashSet<String> set, String[] user_id, String[] banned_id) {
        if(set.size() == banned_id.length) {
            if(isBanned(set, banned_id)) {
                result.add(new HashSet<>(set));
            }
            return;
        }

        for(String s : user_id) {
            if(set.add(s)) {
                dfs(set, user_id, banned_id);
                set.remove(s);
            }
        }
    }

    public boolean isBanned(HashSet<String> set, String[] banned_id) {
        int index = 0;
        for(String id : set) {
            String banned = banned_id[index++];
            if(id.length() != banned.length()) {
                return false;
            }

            for(int i = 0; i < banned.length(); i++) {
                if(banned.charAt(i) == '*') {
                    continue;
                }
                if(id.charAt(i) != banned.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
