
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int[] range = new int[node + 1];
        int[][] distance = new int[node + 1][node + 1];
        for(int i=0;i<distance.length;i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        for(int i=1;i<distance.length;i++) distance[i][i] = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<node;i++) range[i+1] = Integer.parseInt(st2.nextToken());
        for(int i=0;i<edge;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st3.nextToken());
            int temp2 = Integer.parseInt(st3.nextToken());
            int temp3 = Integer.parseInt(st3.nextToken());
            distance[temp1][temp2] = temp3;
            distance[temp2][temp1] = temp3;
        }

        // 경유
        for(int i= 1;i<distance.length;i++){
            for(int j=1;j<distance.length;j++){ // 출발
                for(int k=1;k<distance.length;k++){ // 도착
                    if(distance[j][i] == Integer.MAX_VALUE || distance[i][k] == Integer.MAX_VALUE) continue;
                    if(distance[j][k] > distance[j][i] + distance[i][k]){
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }
        int max = -1;
        for(int i = 1;i<distance.length;i++){
            int answer = 0;
            for(int j=1;j<distance.length;j++){
                if(distance[i][j] == Integer.MAX_VALUE) continue;

                if(distance[i][j] <= length) answer += range[j];
            }
            max = Math.max(max, answer);
        }
        System.out.println(max);
    }
}


