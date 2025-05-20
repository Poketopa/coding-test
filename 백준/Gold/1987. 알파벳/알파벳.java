import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        String[][] map = new String[column][row];
        for(int i=0;i<column;i++){
            String[] input = br.readLine().split("");
            for(int j=0;j<row;j++){
                map[i][j] = input[j];
            }
        }

        Set<String> set = new HashSet<>();
        int[][] visited = new int[column][row];
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};

        set.add(map[0][0]);
        visited[0][0] = 1;
        dfs(map, y, x, 0, 0, visited, set);

        System.out.println(max);
    }
    public static void dfs(String[][] map, int[] y, int[] x, int nowY, int nowX, int[][] visited, Set<String> set){
        max = Math.max(set.size(), max);
        for(int i=0;i<4;i++){
            int newY = nowY + y[i];
            int newX = nowX + x[i];
            if(0 <= newY && newY < map.length
            && 0 <= newX && newX < map[0].length
            && !set.contains(map[newY][newX])
            && visited[newY][newX] == 0){
                set.add(map[newY][newX]);
                visited[newY][newX] = 1;
                dfs(map, y, x, newY, newX, visited, set);
                visited[newY][newX] = 0;
                set.remove(map[newY][newX]);
            }
        }
    }
}
