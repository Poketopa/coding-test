import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][column];

        for(int i=0;i<row;i++){
            String input = br.readLine();
            for(int j=0;j<column;j++){
                map[i][j] = input.charAt(j);
            }
        }

        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == '|'){
                    count++;
                    int y = i;
                    int x = j;
                    while(y>0&& map[y-1][j] == '|'){
                        map[y][j] = '.';
                        y--;
                    }
                    y = i;
                    while(y<map.length&&map[y][j] == '|'){
                        map[y][j] = '.';
                        y++;
                    }
                }
                if(map[i][j] == '-'){
                    count++;
                    int y = i;
                    int x = j;
                    while( x>0 &&map[i][x-1] == '-' ){
                        map[i][x] = '.';
                        x--;
                    }
                    x = j;
                    while(x<map[0].length&& map[i][x] == '-' ){
                        map[i][x] = '.';
                        x++;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
