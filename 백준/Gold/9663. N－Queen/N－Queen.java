
import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        int y = 0;
        int count = 0;
        for(int i=0;i<input;i++){
            dfs(input, map, i, y, count + 1);
        }
        System.out.println(answer);
    }

    private static void dfs(int input, int[][] map, int x, int y, int count){
        map[y][x] = 1;
        if(count == input){
            map[y][x] = 0;
            answer++;
            return;
        }

        for(int i=0;i<input;i++){
            boolean flag = false;
            for(int j = 0;j<=y;j++){
                if(map[j][i] == 1){
                    flag = true;
                    break;
                }
            }
            int temp = 1;
            if(!flag){
                while(0<=y + 1 - temp && 0<=i-temp){
                    if(map[y + 1-temp][i-temp] == 1) {
                        flag = true;
                        break;
                    }
                    temp++;
                }
            }
            temp = 1;
            if(!flag){
                while(0<=y + 1 - temp && i + temp < input){
                    if(map[y + 1-temp][i+temp] == 1) {
                        flag = true;
                        break;
                    }
                    temp++;
                }
            }
            if(flag){
                flag = false;
                continue;
            }
            dfs(input, map, i, y + 1, count + 1);
        }
        map[y][x] = 0;
    }
}
