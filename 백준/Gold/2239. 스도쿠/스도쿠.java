
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[9][9];
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            String input = br.readLine();
            for(int j=0;j<9;j++) {
                map[i][j] = input.charAt(j) - '0';
                if(map[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        for(int i=1;i<=9;i++){
            dfs(map, list, 0);
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
    private static void dfs(int[][] map, List<int[]> list, int index){
        if(flag) return;
        int[] temp = list.get(index);
        int y = temp[0];
        int x = temp[1];
        // 들어갈 수 있는지 확인
        // 1부터 9까지 확인
        x:for(int i=1;i<=9;i++){
            // 가로 9개 가능한지 확인
            for(int j=0;j<9;j++){
                if(map[y][j] == i) continue x;
            } // 세로
            for(int j=0;j<9;j++){
                if(map[j][x] == i) continue x;
            }
            // 9개 영역 가능한지
            int yTemp = y / 3;
            int xTemp = x / 3;
            if(check(yTemp, xTemp, map, i)) continue x;

            map[y][x] = i;
            if(index == list.size()-1) flag = true;
            if(flag) return;
            dfs(map, list, index + 1);
        }
        if(flag) return;
        map[y][x] = 0;
    }
    private static boolean check(int y, int x, int[][] map, int num){
        if(y == 0 && x == 0){
            for(int i=0;i<=2;i++){
                for(int j=0;j<=2;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 0 && x == 1){
            for(int i=0;i<=2;i++){
                for(int j=3;j<=5;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 0 && x == 2){
            for(int i=0;i<=2;i++){
                for(int j=6;j<=8;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 1 && x == 0){
            for(int i=3;i<=5;i++){
                for(int j=0;j<=2;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 1 && x == 1){
            for(int i=3;i<=5;i++){
                for(int j=3;j<=5;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 1 && x == 2){
            for(int i=3;i<=5;i++){
                for(int j=6;j<=8;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 2 && x == 0){
            for(int i=6;i<=8;i++){
                for(int j=0;j<=2;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 2 && x == 1){
            for(int i=6;i<=8;i++){
                for(int j=3;j<=5;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        if(y == 2 && x == 2){
            for(int i=6;i<=8;i++){
                for(int j=6;j<=8;j++){
                    if(map[i][j] == num) return true;
                }
            }
        }
        return false;
    }
}
