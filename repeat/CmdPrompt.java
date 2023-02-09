import java.util.Scanner;

public class CmdPrompt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] strings = new String[N];
        for(int i = 0; i < N; i++) {
            strings[i] = sc.next();
        }

        StringBuilder sb= new StringBuilder();
        boolean isSame = true;
        for(int i = 0; i < strings[0].length(); i++) {
            isSame = true;
            char c = strings[0].charAt(i);

            for(int j = 1; j < N; j++) {
                if(c != strings[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }

            if(isSame) {
                sb.append(c);
            }else {
                sb.append('?');
            }
        }

        System.out.println(sb.toString());
    }
}
