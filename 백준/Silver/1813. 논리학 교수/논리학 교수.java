import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer>  map = new HashMap<>();

        for(int i=0;i<input;i++){
            int number = Integer.parseInt(st.nextToken());
            set.add(number);
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        int max = list.get(0);
        for(int i =max;i>=0;i--){
            if(i == map.getOrDefault(i, 0)){
                System.out.print(i);
                return;
            }
        }
        System.out.print("-1");
    }
}
