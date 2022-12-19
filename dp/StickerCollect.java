public class StickerCollect {
    public int solution(int sticker[]) {
        int answer = 0;
        int length  = sticker.length;

        if(length == 1) {
            return sticker[0];
        }

        int[] dp1 = new int[length]; // 첫번째 스티커를 뗀 경우
        int[] dp2 = new int[length]; // 첫번째 스티커를 떼지 않는 경우

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i = 2; i < length - 1; i++) { // 첫번쨰 스티커를 뗐으므로 length-1까지만
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2; i < length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        answer = Math.max(dp1[length - 2], dp2[length - 1]);

        return answer;
    }
}
