import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        int[] sorted = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++){
            number[i] = Integer.parseInt(st.nextToken());
            sorted[i] = number[i];
        }
        int[] visited = new int[input];
        Arrays.sort(sorted);
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(visited[j] == 1) continue;
                if(sorted[j] == number[i]){
                    visited[j] = 1;
                    System.out.print(j+" ");
                    break;
                }
            }
        }


    }
}
