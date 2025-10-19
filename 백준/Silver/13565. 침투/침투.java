import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int low = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        int[][] map = new int[low][column];
        int[][] visited = new int[low][column];
        Queue<int[]> queue = new LinkedList<>();
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};

        for (int i = 0; i < low; i++) {
            String input = br.readLine();
            for (int j = 0; j < column; j++) {
                map[i][j] = input.charAt(j) - '0';
                if(i == 0 && map[i][j] == 0){
                    queue.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == low -1){
                System.out.print("YES");
                return;
            }
            for(int i=0;i<4;i++){
                int newY = temp[0] + y[i];
                int newX = temp[1] + x[i];
                if(0 <= newY && newY < low
                && 0 <= newX && newX < column
                && visited[newY][newX] == 0
                && map[newY][newX] == 0){
                    queue.add(new int[]{newY, newX});
                    visited[newY][newX] = 1;
                }
            }
        }
        System.out.print("NO");


    }
}






