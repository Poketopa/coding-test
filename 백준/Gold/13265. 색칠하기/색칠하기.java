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

        int input = Integer.parseInt(br.readLine());
        x:for(int testcase = 0; testcase<input;testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int circle = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0;i<circle + 1; i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<line;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }
            int[] color = new int[circle + 1];
            int[] visited = new int[circle + 1];

            for(int j=1;j<=circle;j++){
                if(visited[j] == 1) continue;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);
                visited[j] = 1;
                color[j] = 1;

                while(!queue.isEmpty()){
                    int temp = queue.poll();
                    int tempColor = color[temp];

                    for(int i=0;i<list.get(temp).size();i++){
                        int next = list.get(temp).get(i);
                        if(visited[next] == 0){
                            visited[next] = 1;
                            if(tempColor == 1) color[next] = 2;
                            else color[next] = 1;
                            queue.add(next);
                        } else {
                            if(tempColor == color[next]) {
                                System.out.println("impossible");
                                continue x;
                            }
                        }
                    }
                }
            }
            

            System.out.println("possible");
        }
    }
}
