import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[][] map = new int[100][100];
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int downX = Integer.parseInt(st2.nextToken());
            int downY = Integer.parseInt(st2.nextToken());
            int upX = Integer.parseInt(st2.nextToken());
            int upY = Integer.parseInt(st2.nextToken());
            for(int j=downX-1;j<upX;j++){
                for(int k=downY-1;k<upY;k++){
                    map[j][k]++;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j] > target)answer++;
            }
        }
        System.out.println(answer);
    }
}
