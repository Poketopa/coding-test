import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        // N: 문제 수
        // L: 난이도 합 최소
        // R: 난이도 합 최대
        // X: 최소 난이도 차이
        int[] number = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) number[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(number);
        // 1. sum으로 합관리
        // 2. 첫, 마지막 인덱스로 난이도 관리
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<N;i++){
            dfs(i, N, L, R, X, number, list, sum);
        }

        System.out.println(answer);
    }
    public static void dfs(int now, int N, int L, int R, int X, int[] number, List<Integer> list, int sum){
        list.add(number[now]);
        sum += number[now];
        if(list.size() > 1 && L <= sum && sum <= R && (list.get(list.size()-1) - list.get(0)) >= X){
            answer++;
        }
        for(int i=now + 1;i<N;i++){
            dfs(i, N, L, R, X, number, list, sum);
        }
        list.remove(list.size()-1);
        sum -= number[now];
    }
}
