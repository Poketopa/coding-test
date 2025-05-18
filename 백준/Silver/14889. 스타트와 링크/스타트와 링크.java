import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] map = new int[input][input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int length = input / 2;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input-length;i++){
            dfs(map, length, list, i);
            list.remove(list.size()-1);
        }
        System.out.println(min);
    }
    private static void dfs(int[][] map, int length, List<Integer> list, int now){
        list.add(now);
        if(list.size() == length){
            // 체크 알고리즘
            Set<Integer> set = new HashSet<>(list);
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<map.length;i++){
                // 리스트에 있으면
                if(!set.contains(i)) temp.add(i);
            }
            int sumA = 0;
            int sumB = 0;
            for(int i=0;i<length;i++){
                for(int j=i + 1;j<length;j++){
                    if(i==j) continue;
                    sumA += map[list.get(i)][list.get(j)];
                    sumA += map[list.get(j)][list.get(i)];
                    sumB += map[temp.get(i)][temp.get(j)];
                    sumB += map[temp.get(j)][temp.get(i)];
                }
            }
            min = Math.min(min, Math.abs(sumA - sumB));
            return;
        }
        for(int i=now + 1;i<map.length;i++){
            dfs(map, length, list, i);
            list.remove(list.size()-1);
        }
    }
}
