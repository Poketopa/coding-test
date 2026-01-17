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
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                for(int k=1;k<=c;k++){
                    int sum = i + j + k;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(maxValue < map.get(list.get(i))){
                maxValue = map.get(list.get(i));
                maxKey = list.get(i);
            }
        }
        System.out.print(maxKey);
    }
}
