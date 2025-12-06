import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        //선수과목 맵(과목 - set)으로 관리
        // 큐에 넣고 선수과목 들었으면 다음 노드 / 안들었으면 다시 큐에 넣음
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subject = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        int[] visited = new int[subject + 1];

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i=1;i<=subject;i++) {
            map.put(i, new HashSet<>());
            tree.put(i, new ArrayList<>());
        }

        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st2.nextToken());
            int after = Integer.parseInt(st2.nextToken());
            map.get(after).add(before);
            tree.get(before).add(after);
        }

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        int[] result = new int[subject + 1];

        while(true){
            for(int i=1;i<=subject;i++){
                if(map.get(i).isEmpty() && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                    result[i] = count;
                }
            }

            if(queue.isEmpty()) break;

            while(!queue.isEmpty()){
                int number = queue.poll();
                for(int i : tree.get(number)){
                    map.get(i).remove(number);
                }
            }

            count++;
        }

        for(int i=1;i<=subject;i++)System.out.print(result[i] + " ");

    }
}
