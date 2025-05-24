import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] number = new int[input][2];
        for(int i=0;i<input;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            number[i][0] = Integer.parseInt(st.nextToken());
            number[i][1] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            list.add(i);
            dfs(input, number, i, list);
            list.remove(list.size()-1);
        }
        System.out.println(min);
    }
    public static void dfs(int input, int[][] number, int now, List<Integer> list){
        int sumA = 1;
        int sumB = 0;
        for(int i=0;i<list.size();i++){
            sumA *= number[list.get(i)][0];
            sumB += number[list.get(i)][1];
        }
        min = Math.min(min, Math.abs(sumA - sumB));

        for(int i=now+1;i<input;i++){
            list.add(i);
            dfs(input, number, i, list);
            list.remove(list.size()-1);
        }
    }
}
