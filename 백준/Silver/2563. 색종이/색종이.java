
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[][] map = new boolean[101][101];
        for(int i=0;i<map.length;i++)  Arrays.fill(map[i], false);
        int sum = 0;
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            for(int j=from;j<from+10;j++){
                for(int k=to;k<to+10;k++){
                    if(map[j][k]) continue;
                    else{
                        map[j][k] = true;
                        sum++;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}