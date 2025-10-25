import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for(int repeat = 0;repeat<input;repeat++){
            int length = Integer.parseInt(br.readLine());
            int count = 0;
            String[] str = br.readLine().split(" ");
            int[] number = new int[length + 1];
            for(int i=0;i<length;i++) number[i + 1] = Integer.parseInt(str[i]);
            int[] visited = new int[length + 1];
            for(int i=1;i<=length;i++){
                if(visited[number[i]] == 1) continue;
                count++;
                int temp = number[i];
                while(visited[temp] == 0){
                    visited[temp] = 1;
                    temp = number[temp];
                }
            }
            System.out.println(count);
        }
    }
}






