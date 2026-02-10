import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] words;
    static int[] pointers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;
            list.add(num);
        }

        if(list.isEmpty()) {
            System.out.print("0") ;
            return;
        }

        int[][][] dp = new int[list.size() + 1][5][5];
        if(list.get(0) == 1) {
            dp[1][0][1] = 2;
            dp[1][1][0] = 2;
        }
        if(list.get(0) == 2) {
            dp[1][0][2] = 2;
            dp[1][2][0] = 2;
        }
        if(list.get(0) == 3) {
            dp[1][0][3] = 2;
            dp[1][3][0] = 2;
        }
        if(list.get(0) == 4) {
            dp[1][0][4] = 2;
            dp[1][4][0] = 2;
        }

        for(int i=1;i<list.size();i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    // 왼발 옮기기
                    int value = dp[i][j][k];
                    if(value == 0) continue;
                    int rightBefore = j;
                    int after = list.get(i);
                    int leftBefore = k;


                    if(dp[i+1][after][k] == 0) dp[i+1][after][k] = value + getValue(rightBefore, after);
                    else dp[i+1][after][k] = Math.min(value + getValue(rightBefore, after), dp[i+1][after][k]);

                    if(dp[i+1][j][after] == 0) dp[i+1][j][after] = value + getValue(leftBefore, after);
                    else dp[i+1][j][after] = Math.min(dp[i+1][j][after], value + getValue(leftBefore, after));
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(dp[list.size()][i][j] == 0) continue;
                answer = Math.min(answer, dp[list.size()][i][j]);
            }
        }

        System.out.print(answer);
    }

    public static int getValue(int before, int after){
        if(before == 0){
            return 2;
        }
        if(before == 1){
            if(after == 1) return 1;
            if(after == 2) return 3;
            if(after == 3) return 4;
            if(after == 4) return 3;
        }
        if(before == 2){
            if(after == 1) return 3;
            if(after == 2) return 1;
            if(after == 3) return 3;
            if(after == 4) return 4;
        }
        if(before == 3){
            if(after == 1) return 4;
            if(after == 2) return 3;
            if(after == 3) return 1;
            if(after == 4) return 3;
        }
        if(before == 4){
            if(after == 1) return 3;
            if(after == 2) return 4;
            if(after == 3) return 3;
            if(after == 4) return 1;
        }
        return 1;
    }
}
