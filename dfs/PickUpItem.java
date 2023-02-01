public class PickUpItem {
    static final int size = 101;
    static boolean[][] map = new boolean[size][size];
    int[] dR = new int[]{-1, 1, 0, 0};
    int[] dC = new int[]{0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer;

        int characterX2 = characterX * 2;
        int characterY2 = characterY * 2;
        int itemX2 = itemX * 2;
        int itemY2 = itemY * 2;

        rect(rectangle);

        int totalDistance = distance(characterY2, characterX2, characterY2, characterX2, new boolean[size][size], 0) + 1;
        int targetDistance = distance(characterY2, characterX2, itemY2, itemX2, new boolean[size][size], 0);

        answer = Math.min(targetDistance, totalDistance - targetDistance) / 2;

        return answer;
    }

    public void rect(int[][] rectangle) {
        for(int[] point : rectangle) {
            int firstRow = 2 * point[1];
            int firstCol = 2 * point[0];
            int secondRow = 2 * point[3];
            int secondCol = 2 * point[2];

            edge(firstRow, firstCol, secondRow, secondCol);
        }

        for(int[] point : rectangle) {
            int firstRow = 2 * point[1];
            int firstCol = 2 * point[0];
            int secondRow = 2 * point[3];
            int secondCol = 2 * point[2];

            space(firstRow, firstCol, secondRow, secondCol);
        }
    }

    public void edge(int firstRow, int firstCol, int secondRow, int secondCol) {
        for(int i = firstRow; i <= secondRow; i++) {
            map[i][firstCol] = true;
        }
        for(int i = firstCol + 1; i <= secondCol; i++) {
            map[secondRow][i] = true;
        }
        for(int i = secondRow - 1; i >= firstRow; i--) {
            map[i][secondCol] = true;
        }
        for(int i = secondCol - 1; i > firstCol; i--) {
            map[firstRow][i] = true;
        }
    }

    public void space(int firstRow, int firstCol, int secondRow, int secondCol) {
        for(int i = firstRow + 1; i < secondRow; i++) {
            for(int j = firstCol + 1; j < secondCol; j++) {
                map[i][j] = false;
            }
        }
    }

    public int distance(int firstRow, int firstCol, final int itemY2, final int itemX2, boolean[][] visited, int count) {
        if(count > 0 && firstRow == itemY2 && firstCol == itemX2) {
            return count;
        }

        visited[firstRow][firstCol] = true;

        for(int i =0; i < 4; i++) {
            int newFirstRow = firstRow + dR[i];
            int newFirstCol = firstCol + dC[i];

            if(newFirstRow >= 0 && newFirstRow < size && newFirstCol >= 0 && newFirstCol < size
                    && map[newFirstRow][newFirstCol] && !visited[newFirstRow][newFirstCol]) {
                return distance(newFirstRow, newFirstCol, itemY2, itemX2, visited, count + 1);
            }
        }

        return count;
    }
}
