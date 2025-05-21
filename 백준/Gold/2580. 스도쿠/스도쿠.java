import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[9][9];
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) list.add(new int[]{i, j});
            }
        }
        int index = 0;
        dfs(0, map, list);
    }
    public static void dfs(int index, int[][] map, List<int[]> list){
        int y = list.get(index)[0];
        int x = list.get(index)[1];
        for(int i=1;i<=9;i++){
            if(!checkColumn(i, index, map, list)) continue;
            if(!checkRow(i, index, map, list)) continue;
            if(!checkBox(i, index, map, list)) continue;
            map[y][x] = i;
            if(index == list.size()-1){
                printMap(map);
                flag = true;
                return;
            }
            dfs(index + 1, map, list);
            if(flag) return;
            map[y][x] = 0;
        }
    }
    public static void printMap(int[][] map){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static boolean checkColumn(int number, int index, int[][] map, List<int[]> list){
        int row = list.get(index)[1];
        for(int i=0;i<9;i++){
            if(map[i][row] == number) return false;
        }
        return true;
    }
    public static boolean checkRow(int number, int index, int[][] map, List<int[]> list){
        int column = list.get(index)[0];
        for(int i=0;i<9;i++){
            if(map[column][i] == number) return false;
        }
        return true;
    }
    public static boolean checkBox(int number, int index, int[][] map, List<int[]> list){
        int y = list.get(index)[0];
        int x = list.get(index)[1];
        if(0 <= y && y < 3 && 0 <= x && x < 3){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(0 <= y && y < 3 && 3 <= x && x < 6){
            for(int i=0;i<3;i++){
                for(int j=3;j<6;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(0 <= y && y < 3 && 6 <= x && x < 9){
            for(int i=0;i<3;i++){
                for(int j=6;j<9;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(3 <= y && y < 6 && 0 <= x && x < 3){
            for(int i=3;i<6;i++){
                for(int j=0;j<3;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(3 <= y && y < 6 && 3 <= x && x < 6){
            for(int i=3;i<6;i++){
                for(int j=3;j<6;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(3 <= y && y < 6 && 6 <= x && x < 9){
            for(int i=3;i<6;i++){
                for(int j=6;j<9;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(6 <= y && y < 9 && 0 <= x && x < 3){
            for(int i=6;i<9;i++){
                for(int j=0;j<3;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(6 <= y && y < 9 && 3 <= x && x < 6){
            for(int i=6;i<9;i++){
                for(int j=3;j<6;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        if(6 <= y && y < 9 && 6 <= x && x < 9){
            for(int i=6;i<9;i++){
                for(int j=6;j<9;j++){
                    if(i==y && j == x) continue;
                    if(map[i][j] == number) return false;
                }
            }
        }
        return true;
    }

}
