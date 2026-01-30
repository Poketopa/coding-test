import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int input = Integer.parseInt(br.readLine());
        int[] degree = new int[input + 1];
        int[] visited = new int[input + 1];
        int[] built = new int[input + 1];
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> need = new ArrayList<>();
        for(int i=0;i<=input;i++) {
            list.add(new ArrayList<>());
            need.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        // 리스트[몇번째인지, 지어지는 시간, 필요한 건물들~]
        for(int i=1;i<=input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(true){
                int num = Integer.parseInt(st.nextToken());
                if(num == - 1) break;
                list.get(i).add(num);
            }
            if(list.get(i).size() == 1){
                visited[i] = list.get(i).get(0);
                built[i] = 1;
                queue.add(i);
            }
        }
        for(int i=1;i<=input;i++){
            if(list.get(i).size() > 1){
                degree[i] = list.get(i).size() - 1;
                for(int j=1;j<list.get(i).size();j++){
                    need.get(list.get(i).get(j)).add(i);
                }
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            int max = Integer.MIN_VALUE;
            for(int i=1;i<list.get(temp).size();i++){
                max = Math.max(max, visited[list.get(temp).get(i)]);
            }
            for(int i=0;i<need.get(temp).size();i++){
                degree[need.get(temp).get(i)]--;
            }
            if(visited[temp] == 0) visited[temp] = max + list.get(temp).get(0);
            for(int i=1;i<=input;i++) if(built[i] == 0 && degree[i] == 0) {
                queue.add(i);
                built[i] = 1;
            }
        }



        for(int i=1;i<=input;i++) System.out.println(visited[i]);
    }
}
