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
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static long N;
    static long P;
    static long Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());


        map.put(0L, 1L);

        System.out.print(getNum(N));
    }

    public static long getNum(long number){
        if(number == 0) return 1;
        long a=0L;
        long b=0L;
        if(map.containsKey(number / P)){
            a = map.get(number / P);
        } else {
            a = getNum(number / P);
            map.put(number / P, a);
        }
        if(map.containsKey(number / Q)){
            b = map.get(number / Q);
        } else {
            b = getNum(number / Q);
            map.put(number / Q, b);
        }

        return a + b;
    }
}
