import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] map = new int[y][x];
        for(int i=0;i<y;i++){
            String[] input = br.readLine().split(" ");
            for(int j=0;j<x;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<x-2;i++){
            for(int j=i + 1;j<x-1;j++){
                for(int k=j + 1;k<x;k++){
                    int tempMax = 0;
                    for(int l=0;l<y;l++){
                        tempMax += Math.max(Math.max(map[l][i], map[l][j]), map[l][k]);
                    }
                    max = Math.max(max, tempMax);
                }
            }
        }
        System.out.print(max);
    }
}
