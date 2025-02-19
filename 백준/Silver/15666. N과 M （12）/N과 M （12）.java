
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[] number = new int[input];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(number);
        List<Integer> list = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<>();


        for(int i=0;i<number.length;i++){
            dfs(number, i, length, list, map);
        }
    }

    private static void dfs(int[] number, int now, int length, List<Integer> list, Map<String, Boolean> map){
        list.add(number[now]);
        if(list.size() == length){
            if(!map.containsKey(list.toString())) {
                map.put(list.toString(), true);
                for(int i=0;i<length;i++) System.out.print(list.get(i)+" ");
                System.out.println("");
            }
            list.remove(list.size()-1);
            return;
        }
        for(int i=now;i<number.length;i++){
            dfs(number, i, length, list, map);
        }
        list.remove(list.size()-1);
    }
}