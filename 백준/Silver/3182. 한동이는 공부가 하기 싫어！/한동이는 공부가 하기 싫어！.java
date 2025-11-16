import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input + 1];
        for(int i=1;i<=input;i++){
            number[i] = Integer.parseInt(br.readLine());
        }

        int max = Integer.MIN_VALUE;
        int answer = 1;
        for(int i=1;i<=input;i++){
            int count = 0;
            int now = i;
            int[] visited = new int[input + 1];
            while(true){
                if(visited[now] == 1){
                    if(max < count){
                        max = count;
                        answer = i;
                    }
                    break;
                }
                visited[now] = 1;
                now = number[now];
                count++;
            }
        }
        System.out.print(answer);
    }
}
