
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());

        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j=0;j<temp;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String wear = st.nextToken();
                map.put(wear, map.getOrDefault(wear, 0) + 1);
            }
            Set<String> set = new HashSet<>(map.keySet());
            List<Integer> list = new ArrayList<>();
            for(String j : set){
                list.add(map.get(j));
            }
            long sum = 1;
            for(int j : list){
                sum *= (j + 1);
            }
            System.out.println(sum-1);
        }

    }
}