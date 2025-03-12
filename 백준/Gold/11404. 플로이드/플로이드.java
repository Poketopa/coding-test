
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());
        int[][] distance = new int[node + 1][node + 1];
        for(int i=0;i<distance.length;i++) Arrays.fill(distance[i], Integer.MAX_VALUE);
        for(int i=1;i<distance.length;i++) distance[i][i] = 0;
        for(int i=0;i<edge;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            int temp3 = Integer.parseInt(st.nextToken());
            distance[temp1][temp2] = Math.min(temp3, distance[temp1][temp2]);
        }

        // 경우
        for(int i=1;i<distance.length;i++){
            // 출발
            for(int j=1;j<distance.length;j++){
                // 도착
                for(int k=1;k<distance.length;k++){
                    if(distance[j][i] ==  Integer.MAX_VALUE|| distance[i][k] == Integer.MAX_VALUE) continue;
                    if(distance[j][k] > distance[j][i] + distance[i][k]){
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }

        for(int i = 1;i<distance.length;i++){
            for(int j=1;j<distance.length;j++){
                if(distance[i][j] == Integer.MAX_VALUE) System.out.print("0 ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }
}


