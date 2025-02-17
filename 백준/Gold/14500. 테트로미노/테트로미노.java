
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

        int[][] map = new int[column][row];
        for(int i=0;i<column;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<row;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        blue(map);
        brown(map);
        orange(map);
        green(map);
        pink(map);
        System.out.println(max);
    }
    private static void blue(int[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length-3;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3]);
            }
        }
        for(int i=0;i<map.length-3;i++){
            for(int j=0;j<map[0].length;j++){
                max = Math.max(max, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j]);
            }
        }
    }
    private static void brown(int[][] map){
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i+1][j]+map[i+1][j+1]);
            }
        }
    }
    private static void orange(int[][] map){
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+2][j+1]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j]);
            }
        }
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]+map[i][j+2]);
            }
        }
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]+map[i+2][j]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2]);
            }
        }
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i+1][j]+map[i+2][j]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]);
            }
        }




    }
    private static void green(int[][] map){
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i+1][j]+map[i+1][j+1]+map[i][j+1]+map[i][j+2]);
            }
        }



        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i+1][j]+map[i+1][j+1]+map[i][j+1]+map[i+2][j]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i+1][j+1]+map[i+1][j+2]);
            }
        }
    }
    private static void pink(int[][] map){
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+1]);
            }
        }
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i+1][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]);
            }
        }
        for(int i=0;i<map.length-1;i++){
            for(int j=0;j<map[0].length-2;j++){
                max = Math.max(max, map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]+map[i][j+1]);
            }
        }
        for(int i=0;i<map.length-2;i++){
            for(int j=0;j<map[0].length-1;j++){
                max = Math.max(max, map[i][j]+map[i+1][j]+map[i+2][j]+map[i+1][j+1]);
            }
        }
    }
}