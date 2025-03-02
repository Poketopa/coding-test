
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] number = new int[input];
        Map<String, Boolean> map = new HashMap<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++){
            number[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(number);
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<input;i++){
            dfs(length, number, list, i, map);
        }
    }

    private static void dfs(int length, int[] number, List<Integer> list, int now, Map<String, Boolean> map){
        list.add(number[now]);
        if(list.size() == length){
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<length;i++) {
                sb.append(list.get(i));
                sb.append("/");
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), true);
                for(int i=0;i<length;i++){
                    System.out.print(list.get(i) + " ");
                }
                System.out.println("");
            }
            list.remove(list.size()-1);
            return;
        }

        for(int i=now;i<number.length;i++){
            dfs(length, number, list, i, map);
        }
        list.remove(list.size()-1);
    }
}
