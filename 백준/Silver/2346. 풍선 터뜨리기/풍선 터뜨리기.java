
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int[] visited = new int[input];

        int start = 0;

        int count = 1;

        System.out.print("1 ");

        while(count < number.length){
            int temp = number[start];
            visited[start] = 1;

            if(temp >= 0){
                for(int i=1;i<=temp;i++){
                    start++;
                    if(start >= number.length) start %= number.length;
                    while(visited[start] == 1){
                        start++;
                        if(start >= number.length) start %= number.length;
                    }
                }
                System.out.print((start + 1) + " ");
            }
            else{
                for(int i=-1;i>=temp;i--){
                    start--;
                    if(start < 0) start = number.length - 1;
                    while(visited[start] == 1){
                        start--;
                        if(start < 0) start = number.length - 1;
                    }
                }
                System.out.print((start + 1) + " ");
            }
            count++;
        }
    }
}