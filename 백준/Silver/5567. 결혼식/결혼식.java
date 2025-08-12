import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[input + 1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<>();

        for(int i=0;i<length;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 0});

        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            if(temp[1] > 2) continue;
            set.add(temp[0]);
            for(int i=0;i<list[temp[0]].size();i++){
                if(!set.contains(list[temp[0]].get(i))){
                    queue.add(new int[]{list[temp[0]].get(i), temp[1] + 1});
                }
            }
        }
        System.out.print(set.size()-1);
    }
}
