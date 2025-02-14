
import java.io.*;
import java.util.*;

public class Main {
    static int count0 = 0;
    static int count1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        for(int i=0;i<input;i++){
            int temp = Integer.valueOf(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=0;j<temp;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String wear = st.nextToken();
                map.put(wear, map.getOrDefault(wear, 1)+1);
            }
            Set<String> set = new HashSet<>();
            set = map.keySet();
            int sum = 1;
            for(String k : set){
                sum *= map.get(k);
            }
            System.out.println(sum-1);
        }

    }
}