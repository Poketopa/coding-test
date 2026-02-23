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
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());
        int cheese = Integer.parseInt(st.nextToken());

        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        int nowY = 0;
        int nowX = 0;
        char[][] map = new char[row][column];
        for(int i=0;i<row;i++){
            String input = br.readLine();
            for(int j=0;j<column;j++){
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'S'){
                    nowY = i;
                    nowX = j;
                }
            }
        }

        int sum = 0;

        x: for(int k=1;k<=cheese;k++){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{nowY, nowX, 0});
            int[][] visited = new int[row][column];
            visited[nowY][nowX] = 1;

            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                if(map[temp[0]][temp[1]] - '0' == k){
                    sum += temp[2];
                    nowY = temp[0];
                    nowX = temp[1];
                    continue x;
                }
                for(int i=0;i<4;i++){
                    int newY = temp[0] + y[i];
                    int newX = temp[1] + x[i];
                    if(0 <= newY && newY < row
                            && 0 <= newX && newX < column
                            && map[newY][newX] != 'X'
                            && visited[newY][newX] == 0){
                        visited[newY][newX] = 1;
                        queue.add(new int[]{newY, newX, temp[2] + 1});
                    }
                }
            }
        }
        System.out.print(sum);
    }
}
