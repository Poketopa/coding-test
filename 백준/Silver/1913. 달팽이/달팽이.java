import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int indexY = 0;
        int indexX = 0;
        int count = N * N;
        int direction = 1;
        // 1: 아래, 2: 오른쪽, 3: 위, 4: 왼쪽

        while(true){
            if(direction == 1){ // 아래로 갈 때
                map[indexY][indexX] = count;
                count--;
                if(indexY + 1 >= N || map[indexY + 1][indexX] != 0){
                    direction++;
                    indexX++;
                }
                else{
                    indexY++;
                }
            }
            else if(direction == 2){ // 오른쪽
                map[indexY][indexX] = count;
                count--;
                if(indexX + 1 >= N || map[indexY][indexX + 1] != 0){
                    direction++;
                    indexY--;
                }
                else{
                    indexX++;
                }
            }
            else if(direction == 3){ // 위
                map[indexY][indexX] = count;
                count--;
                if(indexY - 1 < 0 || map[indexY - 1][indexX] != 0){
                    direction++;
                    indexX--;
                }
                else{
                    indexY--;
                }
            }
            else { // 왼쪽
                map[indexY][indexX] = count;
                count--;
                if(indexX - 1 < 0 || map[indexY][indexX - 1] != 0){
                    direction++;
                    indexY++;
                }
                else{
                    indexX--;
                }
            }
            if(direction == 5) direction -= 4;
            if(count == 0) break;
        }
        int targetY = 0;
        int targetX = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == F){
                    targetY = i + 1;
                    targetX = j + 1;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.print(targetY +" "+targetX);
    }
}
