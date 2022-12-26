public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;
        for(int x = 0; x < point + lock.length; x++) {
            for(int y = 0; y < point + lock.length; y++) {
                for(int r = 0; r < 4; r++) {
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2];
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + point][j + point] = lock[i][j];
                        }
                    }

                    rotate(newLock, key, r, x, y);
                    if(check(newLock, point, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void rotate(int[][] newLock, int[][] key, int rotate, int x, int y) {
        int length = key.length;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(rotate == 0) {
                    newLock[x + i][y + j] += key[i][j];
                }else if(rotate == 1) {
                    newLock[x + i][y + j] += key[j][length - i - 1];
                }else if(rotate == 2) {
                    newLock[x + i][y + j] += key[length - i - 1][length - j - 1];
                }else {
                    newLock[x + i][y + j] += key[length - j - 1][i];
                }
            }
        }
    }

    public boolean check(int[][] newLock, int point, int length) {
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(newLock[point + i][point + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}