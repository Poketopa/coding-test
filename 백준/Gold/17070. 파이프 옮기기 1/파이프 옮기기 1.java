import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int dir = 0;
        int[] head = {0, 1};
        // 0: 가로
        // 1: 세로
        // 2: 대각선
        dfs(map, 0, head);
        System.out.println(count);
    }
    public static void dfs(int[][] map, int dir, int[] head){
        if(head[0] == map.length-1 && head[1] == map.length-1) {
            count++;
            return;
        }
        // 가로일 때
        if(dir == 0){
            // 앞으로 갈 수 있는 경우
            if(head[1] + 1 < map.length
            && map[head[0]][head[1] + 1] == 0){
                dfs(map, 0, new int[]{head[0], head[1] + 1});
            }
            if(head[0] + 1 < map.length
            && head[1] + 1 < map.length
            && map[head[0] + 1][head[1]] == 0
            && map[head[0] + 1][head[1] + 1] == 0
            && map[head[0]][head[1] + 1] == 0){
                dfs(map, 2, new int[]{head[0] + 1, head[1] + 1});
            }
        }
        else if(dir == 1){
            // 앞으로 갈 수 있는 경우
            if(head[0] + 1 < map.length
            && map[head[0] + 1][head[1]] == 0){
                dfs(map, 1, new int[]{head[0] + 1, head[1]});
            }
            if(head[0] + 1 < map.length
            && head[1] + 1 < map.length
            && map[head[0] + 1][head[1]] == 0
            && map[head[0] + 1][head[1] + 1] == 0
            && map[head[0]][head[1] + 1] == 0){
                dfs(map, 2, new int[]{head[0] + 1, head[1] + 1});
            }
        }
        else{
            if(head[0] + 1 < map.length
                    && map[head[0] + 1][head[1]] == 0){
                dfs(map, 1, new int[]{head[0] + 1, head[1]});
            }
            if(head[1] + 1 < map.length
                    && map[head[0]][head[1] + 1] == 0){
                dfs(map, 0, new int[]{head[0], head[1] + 1});
            }
            if(head[0] + 1 < map.length
            && head[1] + 1 < map.length
            && map[head[0] + 1][head[1]] == 0
            && map[head[0] + 1][head[1] + 1] == 0
            && map[head[0]][head[1] + 1] == 0){
                dfs(map, 2, new int[]{head[0] + 1, head[1] + 1});
            }
        }
    }
}