
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        int count = 1;

        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) break;
            int[][] map = new int[input][input];
            int[][] visited = new int[input][input];
            for(int i=0;i<input;i++) Arrays.fill(visited[i], Integer.MAX_VALUE);
            visited[0][0] = 0;
            for(int i=0;i<input;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<input;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->{
                if(a[2] < b[2]) return -1;
                else if(a[2] > b[2]) return 1;
                else return 0;
            });
            queue.add(new int[]{0, 0, map[0][0]});
            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                // 도착 확인 필요
                for(int i=0;i<4;i++){
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if(0<=newY && newY<input
                            && 0<=newX && newX<input
                            && visited[newY][newX] > temp[2] + map[newY][newX]){
                        visited[newY][newX] = temp[2] + map[newY][newX];
                        queue.add(new int[]{newY, newX, temp[2] + map[newY][newX]});
                    }
                }
            }
            System.out.println("Problem " + count + ": "+visited[input-1][input-1]);
            count++;
        }

    }
}


