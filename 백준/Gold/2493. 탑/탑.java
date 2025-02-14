import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[] tower = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) tower[i] = Integer.valueOf(st.nextToken());
        // {높이, 인덱스}
        Stack<int[]> stack = new Stack<>();
        int[] answer = new int[input];
        // 오른쪽부터 탐색
        for(int i=input-1;i>=0;i--){
            // 처음이면
            if(i==input-1){
                stack.add(new int[]{tower[i], i});
                continue;
            }
            // 수신 가능
            if(!stack.isEmpty() && stack.peek()[0] <= tower[i]){
                while(!stack.isEmpty() && stack.peek()[0]<=tower[i]){
                    int[] temp = stack.pop();
                    answer[temp[1]] = i+1;
                }
                stack.add(new int[]{tower[i], i});
            }
            else{
                stack.add(new int[]{tower[i], i});
            }
        }
        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] + " ");
        }
    }
}