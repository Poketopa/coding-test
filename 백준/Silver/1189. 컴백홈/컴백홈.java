import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int[][] visited = new int[column][row];
        for(int i=0;i<column;i++){
            String input = br.readLine();
            for(int j=0;j<row;j++){
                if(input.charAt(j) == '.') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        dfs(column-1, 0, map, visited, y, x, length, 1, column, row);
        System.out.println(answer);
    }
    public static void dfs(int nowY, int nowX, int[][] map, int[][] visited, int[] y, int[] x, int length, int count, int column, int row){
        if(count == length){
            if(nowY == 0 && nowX == map[0].length - 1){
                answer++;
            }
            return;
        }
        visited[nowY][nowX] = 1;
        for(int i=0;i<4;i++){
            int newY = nowY + y[i];
            int newX = nowX + x[i];
            if(0 <= newY && newY < column
            && 0 <= newX && newX < row
            && map[newY][newX] == 0
            && visited[newY][newX] == 0){
                dfs(newY, newX, map, visited, y, x, length, count + 1, column, row);

            }
        }
        visited[nowY][nowX] = 0;
    }
}
