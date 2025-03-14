

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, minTree;
    static long[] sumTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];
        int[] y = new int[]{1, -1, 0, 0};
        int[] x = new int[]{0, 0, 1, -1};
        int cleaner = 0;
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] == -1) cleaner = i;
            }
        }
        // 새로 추가해야하는 먼지 양을 담은 배열을 선언한다
        for(int i=0;i<time;i++){
            int[][] dust = new int[column][row];
            for(int j=0;j<column;j++){
                for(int k=0;k<row;k++){
                    if(map[j][k] == -1 || map[j][k] == 0) continue;
                    int count = 0;
                    for(int l = 0;l<4;l++){
                        int newY = j + y[l];
                        int newX = k + x[l];
                        if(0<=newY && newY<column
                         &&0<=newX && newX<row
                         &&map[newY][newX]!=-1){
                            count++;
                            dust[newY][newX] += map[j][k] / 5;
                        }
                    }
                    map[j][k] -= count * (map[j][k] / 5);
                }
            }
            for(int j=0;j<column;j++){
                for(int k=0;k<row;k++){
                    if(map[j][k] == -1 || dust[j][k] == 0) continue;
                    map[j][k] += dust[j][k];
                }
            }

            // 청소기 가동
            // 아래쪽 회전
            for(int j=cleaner + 1;j<column-1;j++){
                map[j][0] = map[j + 1][0];
            }
            for(int j=0;j<row-1;j++){
                map[column-1][j] = map[column-1][j + 1];
            }
            for(int j=column-1;j>cleaner;j--){
                map[j][row-1] = map[j -1][row-1];
            }
            for(int j=row-1;j>0;j--){
                map[cleaner][j] = map[cleaner][j -1];
            }
            map[cleaner][1] = 0;

            // 위쪽 회전
            for(int j = cleaner - 2;j>0;j--){
                map[j][0] = map[j-1][0];
            }
            for(int j=0;j<row-1;j++){
                map[0][j] = map[0][j+1];
            }
            for(int j=0;j<cleaner-1;j++){
                map[j][row-1] = map[j+1][row-1];
            }
            for(int j=row-1;j>0;j--){
                map[cleaner-1][j] = map[cleaner-1][j-1];
            }
            map[cleaner-1][1] = 0;
        }

        int sum = 0;
        for(int i=0;i<column;i++){
            for(int j=0;j<row;j++){
                if(map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }
}