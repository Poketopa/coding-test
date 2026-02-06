import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(br.readLine()); // TC 개수

        x: for(int testcase = 0; testcase < num; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점의 수
            int M = Integer.parseInt(st.nextToken()); // 도로의 개수
            int W = Integer.parseInt(st.nextToken()); // 웜홀의 개수

            int[][] edges = new int[2 * M + W][3];
            int edgeCount = 0;

            for (int road = 0; road < M; road++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st2.nextToken());
                int end = Integer.parseInt(st2.nextToken());
                int weight = Integer.parseInt(st2.nextToken());

                edges[edgeCount][0] = start;
                edges[edgeCount][1] = end;
                edges[edgeCount][2] = weight;
                edgeCount++;

                edges[edgeCount][0] = end;
                edges[edgeCount][1] = start;
                edges[edgeCount][2] = weight;
                edgeCount++;
            }

            for (int wormhole = 0; wormhole < W; wormhole++) {
                StringTokenizer st3 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st3.nextToken());
                int end = Integer.parseInt(st3.nextToken());
                int weight = Integer.parseInt(st3.nextToken());

                edges[edgeCount][0] = start;
                edges[edgeCount][1] = end;
                edges[edgeCount][2] = -weight;
                edgeCount++;
            }

            int[] dist = new int[N + 1];
            boolean flag = false;

            for(int i=1;i<=N;i++){
                for(int j=0;j<edges.length;j++){
                    int start = edges[j][0];
                    int end = edges[j][1];
                    int weight = edges[j][2];

                    if(dist[end] > dist[start] + weight){
                        dist[end] = dist[start] + weight;
                        if(i == N) flag = true;
                    }
                }
                if(flag == true){
                    System.out.println("YES");
                    continue x;
                }
            }
            System.out.println("NO");
        }
    }
}
