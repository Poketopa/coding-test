import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        while(true){
            String input = br.readLine();
            if(input.equals("0")) return;
            StringTokenizer st = new StringTokenizer(input);
            int length = Integer.parseInt(st.nextToken());
            int[] number = new int[length];
            for(int i=0;i<length;i++) number[i] = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<=length-6;i++){
                dfs(number, list, i);
                list.remove(list.size()-1);
            }
            System.out.println("");
        }

    }
    public static void dfs(int[] number, List<Integer> list, int now){
        list.add(number[now]);
        if(list.size() == 6){
            for(int i=0;i<6;i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println("");
            return;
        }
        for(int i=now+1;i<number.length;i++){
            dfs(number, list, i);
            list.remove(list.size()-1);
        }
    }
}
