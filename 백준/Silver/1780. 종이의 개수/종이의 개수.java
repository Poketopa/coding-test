import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    static Map<Integer, Integer> answer = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        answer.put(-1, 0);
        answer.put(0, 0);
        answer.put(1, 0);

        check(0, 0, input, input, map);

        System.out.println(answer.get(-1));
        System.out.println(answer.get(0));
        System.out.println(answer.get(1));
    }

    public static void check(int y1, int x1, int y2, int x2, int[][] map){
        boolean isCorrect = true;
        int start = map[y1][x1];
        if(start == -2) return;
        x:for(int i=y1;i<y2;i++){
            for(int j=x1;j<x2;j++){
                if(map[i][j] != start){
                    isCorrect = false;
                    break x;
                }
            }
        }
        if(isCorrect){
            if(start == 1) answer.put(1, answer.get(1) + 1);
            if(start == 0) answer.put(0, answer.get(0) + 1);
            if(start == -1) answer.put(-1, answer.get(-1) + 1);
            for(int i=y1;i<y2;i++){
                for(int j=x1;j<x2;j++){
                    map[i][j] = -2;
                }
            }
        }
        int temp = (y2 - y1) / 3;
        if(temp == 0) return;
        check(y1, x1, y1 + temp, x1 + temp, map);
        check(y1, x1 + temp, y1 + temp, x1 + (2*temp), map);
        check(y1, x1+(2*temp), y1+temp, x1+(3*temp), map);
        check(y1+ temp, x1, y1+ (2*temp), x1 + temp, map);
        check(y1+ temp, x1+ temp, y1+ (2*temp), x1 + (2*temp), map);
        check(y1+ temp, x1+ (2*temp), y1+ (2*temp), x1 + (3*temp), map);
        check(y1+ (2*temp), x1, y1+(3*temp), x1+ temp, map);
        check(y1+ (2*temp), x1+ temp, y1+(3*temp), x1+ (2*temp), map);
        check(y1+ (2*temp), x1+ (2*temp), y1+(3*temp), x1+(3*temp), map);
    }
}
