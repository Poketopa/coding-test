import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length;i++) list.add(Integer.parseInt(st2.nextToken()));
        int[][] dp = new int[length + 1][max + 1];
        dp[0][start] = 1;
        for(int i=0;i<list.size();i++){
            int num = list.get(i);
            for(int j=0;j<max + 1;j++){
                if(dp[i][j] == 1){
                    if(j - num >= 0){
                        dp[i + 1][j-num] = 1;
                    }
                    if(j + num < max + 1) {
                        dp[i+1][j+num] = 1;
                    }
                }

            }
        }
        int index = max;
        while(index >= 0){
            if(dp[length][index] == 1) {
                System.out.print(index);
                return;
            }
            index--;
        }
        System.out.print("-1");
    }
}
