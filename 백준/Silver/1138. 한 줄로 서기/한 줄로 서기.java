import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] line = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) line[i] = Integer.parseInt(st.nextToken());

        int[] answer = new int[input];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for(int i=0;i<input;i++){
            int count = 0;
            for(int j=0;j<input;j++){
                if(count == line[i]){
                    int temp = j;
                    while(answer[temp] < i + 1){
                        temp++;
                    }
                    answer[temp] = i + 1;
                    break;
                }
                // answer 확인하면서 값이 나보다 작으면 큰거 나올때까지 올림
                if(answer[j] > i + 1) count++;
            }
        }
        for(int i : answer){
            System.out.print(i + " ");
        }


    }
}