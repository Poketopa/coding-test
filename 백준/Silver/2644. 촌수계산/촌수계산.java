import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st2.nextToken());
            int num2 = Integer.parseInt(st2.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);
        }
        int[] visited = new int[N + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = 1;

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[0] == end){
                System.out.print(temp[1]);
                return;
            }
            for(int i=0;i<list[temp[0]].size();i++){
                if(visited[list[temp[0]].get(i)] == 1) continue;
                queue.add(new int[]{list[temp[0]].get(i), temp[1] + 1});
                visited[list[temp[0]].get(i)] = 1;
            }
        }
        System.out.print("-1");
    }
}
