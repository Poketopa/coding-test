
import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int howManyChicken = Integer.parseInt(st.nextToken());
        List<int[]> chickenHouse = new ArrayList<>();
        List<int[]> house = new ArrayList<>();
        int[][] map = new int[length][length];
        for(int i=0;i<length;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=0;j<length;j++){
                map[i][j] = Integer.parseInt(st2.nextToken());
                if(map[i][j] == 1) house.add(new int[]{i, j});
                if(map[i][j] == 2) chickenHouse.add(new int[]{i, j});
            }
        }

        List<int[]> list = new ArrayList<>();

        for(int i=0;i<chickenHouse.size()-howManyChicken+1;i++){
            dfs(house, chickenHouse, list, howManyChicken, i);
        }
        System.out.println(answer);
    }

    private static void dfs(List<int[]> house, List<int[]> chickenHouse, List<int[]> list, int length, int now){
        list.add(chickenHouse.get(now));
        if(list.size() == length){
            int sum = 0;
            for(int i=0;i<house.size();i++){
                int min = Integer.MAX_VALUE;
                for(int j=0;j<list.size();j++){
                    int temp = 0;
                    temp += Math.abs(list.get(j)[0] - house.get(i)[0]);
                    temp += Math.abs(list.get(j)[1] - house.get(i)[1]);
                    min = Math.min(min, temp);
                }
                sum += min;
            }
            answer = Math.min(sum, answer);
            list.remove(list.size()-1);
            return;
        }

        for(int i=now+1;i<chickenHouse.size();i++){
            dfs(house, chickenHouse, list, length, i);
        }
        list.remove(list.size()-1);
    }
}
