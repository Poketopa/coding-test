import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c});
        }

        Collections.sort(list, (a, b) -> {
            return b[2] - a[2];
        });

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int index = 0;
        while(count < 3){
            if(map.getOrDefault(list.get(index)[0], 0) < 2){
                map.put(list.get(index)[0], map.getOrDefault(list.get(index)[0], 0) + 1);
                count++;
                System.out.println(list.get(index)[0] + " " + list.get(index)[1]);
            }
            index++;
        }
    }
}
