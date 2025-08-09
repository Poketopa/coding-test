import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] node = new List[N + 1];
        for(int i=0;i<node.length;i++) node[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            node[start].add(end);
        }

        Set<Integer> set = new HashSet<>();

        int[] visited = new int[N + 1];
        
        visited[X] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, 0});

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i=0;i<node[temp[0]].size();i++){
                if(visited[node[temp[0]].get(i)] == 1) continue;
                if(temp[1] + 1 == K){
                    set.add(node[temp[0]].get(i));
                    visited[node[temp[0]].get(i)] = 1;
                    continue;
                }
                queue.add(new int[]{node[temp[0]].get(i), temp[1] + 1});
                visited[node[temp[0]].get(i)] = 1;
            }
        }

        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);

        if(answer.size()==0){
            System.out.print(-1);
        }
        else{
            for(int i : answer){
                System.out.println(i);
            }
        }
    }
}
