import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        int[][] visited = new int[input][input];

        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int nowY = temp[0];
            int nowX = temp[1];
            if(map[nowY][nowX] == -1){
                System.out.print("HaruHaru");
                return;
            }
            int newY = temp[0] + map[nowY][nowX];
            int newX = temp[1] + map[nowY][nowX];

            try {
                if (visited[nowY][newX] == 0) {
                    queue.add(new int[]{nowY, newX});
                    visited[nowY][newX] = 1;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}

            try {
                if (visited[newY][nowX] == 0) {
                    queue.add(new int[]{newY, nowX});
                    visited[newY][nowX] = 1;
                }
            }catch (ArrayIndexOutOfBoundsException ignored){}
        }
        System.out.print("Hing");
    }
}
