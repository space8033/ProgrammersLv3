public class Pillar {
    boolean[][] pillar;
    boolean[][] bar;
    public int[][] solution(int n, int[][] build_frame) {
        pillar = new boolean[n+1][n+1];
        bar = new boolean[n+1][n+1];

        int cnt = 0;
        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int type = build_frame[i][2];
            int action = build_frame[i][3];

            if(type == 0) {
                if(action == 1) {
                    if(checkPillar(x,y)) {
                        pillar[x][y] = true;
                        cnt++;
                    }
                }else {
                    pillar[x][y] = false;
                    if(!canDelete(n)) {
                        pillar[x][y] = true;
                    }else {
                        cnt--;
                    }
                }
            }else {
                if(action == 1) {
                    if(checkBar(x, y)) {
                        bar[x][y] = true;
                        cnt++;
                    }
                }else {
                    bar[x][y] = false;
                    if(!canDelete(n)) {
                        bar[x][y] = true;
                    }else {
                        cnt--;
                    }
                }
            }
        }

        int[][] answer = new int[cnt][3];
        int index = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j]) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 0;
                }
                if(bar[i][j]) {
                    answer[index][0] = i;
                    answer[index][1] = j;
                    answer[index++][2] = 1;
                }
            }
        }

        return answer;
    }

    public boolean canDelete(int n) {
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(pillar[i][j] && checkPillar(i , j) == false) {
                    return  false;
                }else if(bar[i][j] && checkBar(i, j) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkPillar(int x, int y) {
        if(y == 0) {
            return true;
        }else if(y > 0 && pillar[x][y-1]) {
            return true;
        }else if(x > 0 && bar[x-1][y] || bar[x][y]) {
            return true;
        }

        return false;
    }

    public boolean checkBar(int x, int y) {
        if(y > 0 && pillar[x][y-1] || pillar[x+1][y-1]) {
            return true;
        }else if(x > 0 && bar[x-1][y] && bar[x+1][y]) {
            return true;
        }

        return false;
    }
}
