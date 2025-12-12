import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫번째 입력이 스타트지점
        // visited 배열 만들어서 0인 곳과 1인 곳을 연결
        int input = Integer.parseInt(br.readLine());
        int[] visited = new int[input + 1];
        
        if(input == 2){
            System.out.print("1 2");
            return;
        }

        List<Integer>[] list = new List[input + 1];
        for(int i=0;i<=input;i++) list[i] = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int temp1 = Integer.parseInt(st2.nextToken());
        int temp2 = Integer.parseInt(st2.nextToken());
        list[temp1].add(temp2);
        list[temp2].add(temp1);
        int start = temp1;

        for(int i=0;i<input-3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i < list[temp].size(); i++) {
                if (visited[list[temp].get(i)] == 1)
                    continue;
                queue.add(list[temp].get(i));
                visited[list[temp].get(i)] = 1;
            }
        }

        int visit = 0;
        int notVisit = 0;

        for(int i=1;i<=input;i++){
            if(visit != 0 && notVisit != 0) break;
            if(visit == 0 && visited[i] == 1){
                visit = i;
            }
            if(notVisit == 0 && visited[i] == 0){
                notVisit = i;
            }
        }

        System.out.print(visit + " " + notVisit);
    }
}
