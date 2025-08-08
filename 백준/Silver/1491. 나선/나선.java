import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][column];

        int direction = 0;
        // 0오 1아래 2왼 3위

        int y = 0;
        int x = 0;


        while(true){
            if((y + 1 == row || map[y+1][x] == 1)
                    && (y  == 0 || map[y-1][x] == 1)
                    && (x + 1 == column || map[y][x+1] == 1)
                    && (x == 0 || map[y][x-1] == 1)){
                System.out.print(x + " " + y);
                return;
            }
            if(direction == 0){
                map[y][x] = 1;
                if((y + 1 == row || map[y+1][x] == 1)
                        && (y  == 0 || map[y-1][x] == 1)
                        && (x + 1 == column || map[y][x+1] == 1)
                        && (x == 0 || map[y][x-1] == 1)){
                    System.out.print(x + " " + y);
                    return;
                }
                if(x + 1 == column || map[y][x + 1] == 1){
                    direction++;
                    y++;
                }
                else x++;
            }
            else if(direction == 1){

                map[y][x] = 1;
                if((y + 1 == row || map[y+1][x] == 1)
                        && (y  == 0 || map[y-1][x] == 1)
                        && (x + 1 == column || map[y][x+1] == 1)
                        && (x == 0 || map[y][x-1] == 1)){
                    System.out.print(x + " " + y);
                    return;
                }
                if(y + 1 == row || map[y+1][x] == 1){
                    direction++;
                    x--;
                }
                else y++;
            }
            else if(direction == 2){

                map[y][x] = 1;
                if((y + 1 == row || map[y+1][x] == 1)
                        && (y  == 0 || map[y-1][x] == 1)
                        && (x + 1 == column || map[y][x+1] == 1)
                        && (x == 0 || map[y][x-1] == 1)){
                    System.out.print(x + " " + y);
                    return;
                }
                if(x == 0 || map[y][x-1] == 1){
                    direction++;
                    y--;
                }
                else x--;
            }
            else{
                if((y + 1 == row || map[y+1][x] == 1)
                        && (y  == 0 || map[y-1][x] == 1)
                        && (x + 1 == column || map[y][x+1] == 1)
                        && (x == 0 || map[y][x-1] == 1)){
                    System.out.print(x + " " + y);
                    return;
                }
                map[y][x] = 1;
                if(y == 0 || map[y-1][x] == 1){
                    direction++;
                    x++;
                }
                else y--;
            }

            if(direction > 3) direction %= 4;
        }
    }

}
