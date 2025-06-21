import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        int[][] answer = new int[input][input];
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            for(int j=0;j<input;j++){
                if(temp.charAt(j) == '.'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = temp.charAt(j) - '0';
                    answer[i][j] = -1;
                }
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(answer[i][j] == -1){
                    continue;
                }
                else{
                    answer[i][j] = count(map, answer, i, j);
                }
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(answer[i][j] == -1){
                    System.out.print("*");
                }
                else if(answer[i][j] >= 10){
                    System.out.print("M");
                }
                else System.out.print(answer[i][j]);
            }
            System.out.println("");
        }

    }
    public static int count(int[][] map, int[][] answer, int a, int b){
        int sum = 0;
        for(int i=a-1;i<a+2;i++){
            for(int j=b-1;j<b+2;j++){
                if(i<0 || i >= map.length || j < 0 ||  j >= map.length) continue;
                if( i==a && j == b) continue;
                sum += map[i][j];
            }
        }
        return sum;
    }
}