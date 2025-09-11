import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] list = new List[N + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st1.nextToken());
            int temp2 = Integer.parseInt(st1.nextToken());
            int temp3 = Integer.parseInt(st1.nextToken());
            list[temp1].add(new int[]{temp2, temp3});
            list[temp2].add(new int[]{temp1, temp3});
        }
        x:for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int sum = 0;
            int[] visited = new int[N + 1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{start, 0});
            visited[start] = 1;

            while(!queue.isEmpty()){
                int[] temp = queue.poll();
                if(temp[0] == end){
                    System.out.println(temp[1]);
                    continue x;
                }
                for(int j=0;j<list[temp[0]].size();j++){
                    if(visited[list[temp[0]].get(j)[0]] == 1) continue;
                    queue.add(new int[]{list[temp[0]].get(j)[0], temp[1] + list[temp[0]].get(j)[1]});
                    visited[list[temp[0]].get(j)[0]] = 1;
                }
            }
        }
    }
}
