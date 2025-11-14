import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        String[][] map = new String[-3 + (input * 4)][-3 + (input * 4)];
        for(int i=0;i<map.length;i++) Arrays.fill(map[i], " ");

        draw(map, 0);

        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void draw(String[][] map, int start){
        if(start > map.length / 2 + 1) return;
        for(int i=0;i<map.length - (2*start) ;i++){
            map[start][start + i] = "*";
        }
        for(int i=0;i<map.length - (2*start);i++){
            map[map.length - start - 1][start + i] = "*";
        }
        for(int i=0;i<map.length - (2*start);i++){
            map[start + i][start] = "*";
        }
        for(int i=0;i<map.length - (2*start);i++){
            map[start + i][map.length - 1 - start] = "*";
        }
        draw(map, start + 2);
    }
}
