
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer input = new StringTokenizer(br.readLine());
        int yLength = Integer.parseInt(input.nextToken());
        int xLength = Integer.parseInt(input.nextToken());
        StringTokenizer where = new StringTokenizer(br.readLine());
        int nowY = Integer.parseInt(where.nextToken());
        int nowX = Integer.parseInt(where.nextToken());
        int direction = Integer.parseInt(where.nextToken());
        int[][] map = new int[yLength][xLength];
        for(int i=0;i<yLength;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<xLength;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        int count = 0;
        // 벽, 청소한 곳 구별 필요
        // 청소한 곳은 2으로 변경
        while(true){
            // 현재 칸 청소
            if(map[nowY][nowX] == 0){
                map[nowY][nowX] = 2;
                count++;
            }
            // 주변이 모두 청소되었다면?
            if(isClean(nowY, nowX, map, y, x)){
                if(direction == 0){
                    if(nowY<map.length-1 && map[nowY+1][nowX] != 1){
                        nowY++;
                        continue;
                    }
                    break;
                }
                else if(direction == 1){
                    if(nowX>0 && map[nowY][nowX-1] != 1){
                        nowX--;
                        continue;
                    }
                    break;
                }
                else if(direction == 2){
                    if(nowY>0 && map[nowY-1][nowX] != 1){
                        nowY--;
                        continue;
                    }
                    break;
                }
                else{
                    if(nowX<map[0].length-1 && map[nowY][nowX+1] != 1){
                        nowX++;
                        continue;
                    }
                    break;
                }
            }
            else{
                direction--;
                if(direction == -1) direction = 3;
                if(direction == 0){
                    if(map[nowY-1][nowX] == 0){
                        nowY--;
                    }
                }
                else if(direction == 1){
                    if(map[nowY][nowX+1] == 0){
                        nowX++;
                    }
                }
                else if(direction == 2){
                    if(map[nowY+1][nowX] == 0){
                        nowY++;
                    }
                }
                else{
                    if(map[nowY][nowX-1] == 0){
                        nowX--;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isClean(int nowY, int nowX, int[][] map, int[] y, int[] x){
        for(int i=0;i<4;i++){
            int newY = nowY + y[i];
            int newX = nowX + x[i];
            if(0<=newY && 0<=newX && newY < map.length && newX < map[0].length && map[newY][newX] == 0){
                return false;
            }
        }
        return true;
    }
}