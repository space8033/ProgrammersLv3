public class Network {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }
        return answer;
    }

    public boolean[] dfs(int[][] computers, int a, boolean[] check) {
        check[a] = true;

        for(int i  = 0; i < computers.length; i++) {
            if(i != a && computers[a][i] == 1 && check[i] == false) {
                check = dfs(computers, i, check);
            }
        }

        return check;
    }
}
