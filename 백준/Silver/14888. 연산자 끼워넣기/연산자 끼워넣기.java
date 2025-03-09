
import java.io.*;
import java.util.*;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<4;i++){
            int temp = Integer.parseInt(st2.nextToken());
            for(int j=0;j<temp;j++){
                list.add(i);
            }
        }
        List<Integer> cal = new ArrayList<>();
        int[] visited = new int[list.size()];
        // number[] / 숫자들
        // list / 사칙연산
        for(int i=0;i<list.size();i++){
            dfs(list, number, input-1, cal, visited, i);
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(List<Integer> list, int[] number, int length, List<Integer> cal, int[] visited, int now){
        cal.add(list.get(now));
        // 다 차면
        if(cal.size() == length){
            int temp = number[0];
            for(int i=0;i<number.length-1;i++){
                if(cal.get(i) == 0){
                    temp += number[i+1];
                }
                else if(cal.get(i) == 1){
                    temp -= number[i+1];
                }
                else if(cal.get(i) == 2){
                    temp *= number[i+1];
                }
                else{
                    temp /= number[i+1];
                }
            }
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            cal.remove(cal.size()-1);
            return;
        }
        visited[now] = 1;

        for(int i=0;i<list.size();i++){
            if(visited[i] == 1) continue;
            dfs(list, number, length, cal, visited, i);
        }

        cal.remove(cal.size()-1);
        visited[now] = 0;
    }
}
