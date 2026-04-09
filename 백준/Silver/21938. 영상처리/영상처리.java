import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] map = new int[a][b];
        for(int i=0;i<a;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){
                int n1 = Integer.parseInt(st2.nextToken());
                int n2 = Integer.parseInt(st2.nextToken());
                int n3 = Integer.parseInt(st2.nextToken());
                map[i][j] = (n1 + n2 + n3) / 3;
            }
        }
        int stan = Integer.parseInt(br.readLine());
        int[][] visited = new int[a][b];
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        int answer = 0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(map[i][j] >= stan && visited[i][j] == 0){
                    answer++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = temp[0] + y[k];
                            int newX = temp[1] + x[k];
                            if(0 <= newY && newY <a
                            && 0 <= newX && newX < b
                            && map[newY][newX] >=stan
                            && visited[newY][newX] == 0){
                                queue.add(new int[]{newY, newX});
                                visited[newY][newX] = 1;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(answer);
    }
}
