import java.util.LinkedList;
import java.util.Queue;

public class BlockMoving {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int rx[][] = {{-1, 0, -1, 0}, {0, 0, 1, 1}};
    static int ry[][] = {{0, 0, 1, 1}, {-1, 0, -1, 0}};

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int length = board.length;
        Queue<Robot> queue = new LinkedList<>();
        boolean visited[][][] = new boolean[2][101][101];

        queue.add(new Robot(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Robot current = queue.poll();
            if(current.dir == 0 && current.x == length - 1 && current.y == length - 2) {
                answer = Math.min(answer, current.cnt);
                continue;
            } else if(current.dir == 1 && current.x == length - 2 && current.y == length - 1) {
                answer = Math.min(answer, current.cnt);
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(!canMove(nx, ny, current.dir, board)) {
                    continue;
                }
                if(!visited[current.dir][nx][ny]) {
                    queue.add(new Robot(nx, ny, current.dir, current.cnt + 1));
                    visited[current.dir][nx][ny] = true;
                }
            }

            for(int i = 0; i < 4; i++) {
                int nx = current.x + rx[current.dir][i];
                int ny = current.y + ry[current.dir][i];

                int cx = current.x + dx[i % 2];
                int cy = current.y + dy[i % 2];

                if(current.dir == 1) {
                    cx = current.x + dx[i<2? i+2 : i];
                    cy = current.y + dy[i<2? i+2 : i];
                }

                int ndir = current.dir^1;

                if(!canMove(nx, ny, ndir, board) || !canMove(cx, cy, current.dir, board)) {
                    continue;
                }
                if(!visited[ndir][nx][ny]) {
                    queue.add(new Robot(nx, ny, ndir, current.cnt + 1));
                    visited[ndir][nx][ny] = true;
                }
            }
        }

        return answer;
    }

    public static boolean canMove(int nx, int ny, int dir, int[][] board) {
        int length = board.length;
        if(dir == 0) {
            if(nx<0 || ny <0 || nx >= length || ny >= length || ny+1 >= length ||board[nx][ny] != 0 || board[nx][ny+1] != 0) {
                return false;
            }
        }else {
            if(nx<0 || ny<0 || nx >= length || nx+1>=length || ny>=length || board[nx][ny] != 0 || board[nx+1][ny] != 0) {
                return false;
            }
        }
        return true;
    }

    static class Robot {
        int x, y, dir, cnt;

        Robot(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
