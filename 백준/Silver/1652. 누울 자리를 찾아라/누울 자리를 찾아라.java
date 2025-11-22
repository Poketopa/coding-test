import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        char[][] rawMap = new char[input][input];
        char[][] map = new char[input][input];

        for(int i=0;i<input;i++){
            String temp = br.readLine();
            for(int j=0;j<input;j++){
                rawMap[i][j] = temp.charAt(j);
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++) map[i][j] = rawMap[i][j];
        }
        int countRow = 0;
        int countColumn = 0;
        for(int i=0;i<input;i++){
            for(int j=0;j<input-1;j++){
                if(map[i][j] == '.' && map[i][j+1] == '.'){
                    countRow++;
                    int index = j;
                    while(index < input && map[i][index] == '.'){
                        map[i][index] = 'X';
                        index++;
                    }
                }
            }
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++) map[i][j] = rawMap[i][j];
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input-1;j++){
                if(map[j][i] == '.' && map[j + 1][i] == '.'){
                    countColumn++;
                    int index = j;
                    while(index < input && map[index][i] == '.'){
                        map[index][i] = 'X';
                        index++;
                    }
                }
            }
        }
        System.out.print(countRow + " " + countColumn);
    }
}
