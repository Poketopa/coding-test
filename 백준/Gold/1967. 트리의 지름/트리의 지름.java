import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int maxIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0;i<=input;i++) list.add(new ArrayList<>());
        int[] visited = new int[input + 1];

        for(int i=0;i<input-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b, weight});
            list.get(b).add(new int[]{a, weight});
        }

        int sum = 0;
        visited[1] = 1;
        dfs(1, visited, list, sum);

        int start = maxIndex;
        max = Integer.MIN_VALUE;
        maxIndex = 0;
        Arrays.fill(visited, 0);
        visited[start] = 1;
        dfs(start, visited, list, sum);

        System.out.print(max);
    }

    public static void dfs(int now, int[] visited, List<List<int[]>> list, int sum){
        for(int i=0;i<list.get(now).size();i++){
            if(visited[list.get(now).get(i)[0]] == 0){
                visited[list.get(now).get(i)[0]] = 1;
                dfs(list.get(now).get(i)[0], visited, list, sum + list.get(now).get(i)[1]);
                visited[list.get(now).get(i)[0]] = 0;
            }
        }
        if(max < sum){
            max = sum;
            maxIndex = now;
        }
    }
}
