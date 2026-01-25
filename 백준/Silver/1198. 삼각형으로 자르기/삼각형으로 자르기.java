import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[][] tri = new int[input][2];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tri[i][0] = Integer.parseInt(st.nextToken());
            tri[i][1] = Integer.parseInt(st.nextToken());
        }

        double max = Double.MIN_VALUE;

        for(int i=0;i<input-2;i++){
            for(int j=i+1;j<input-1;j++){
                for(int k=j+1;k<input;k++){
                    max = Math.max(max, (0.5) * Math.abs((tri[i][0]*tri[j][1] + tri[j][0]*tri[k][1] + tri[k][0]*tri[i][1])
                    - (tri[j][0]*tri[i][1] + tri[k][0]*tri[j][1] + tri[i][0]*tri[k][1])));
                }
            }
        }

        System.out.print(max);
    }
}
