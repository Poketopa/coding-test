import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            for(int j=0;j<input;j++){
                if(temp.charAt(j) == 'N') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        int max = -1;
        for(int i=0;i<input;i++){
            int[] visited = new int[input];
            int count = 0;
            for(int j=0;j<input;j++){
                if(map[i][j] == 1){
                    visited[j] = 1;
                    // 1이면 해당 j로 들어감
                    for(int k=0;k<input;k++){
                        if(map[j][k] == 1 && visited[k] == 0){
                            visited[k] = 1;
                        }
                    }
                }
            }
            for(int j=0;j<input;j++) {
                if(visited[j] == 1 && j != i) count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}