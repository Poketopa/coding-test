import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        // 남자 -> 배수의 스위치 반전
        // 여자 -> 대칭 맞는 구간 반전
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] button = new int[length + 1];
        for(int i=1;i<=length;i++) button[i] = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st2.nextToken());
            int number = Integer.parseInt(st2.nextToken());
            int temp = number;
            if(sex == 1){
                while(temp <= length){
                    if(button[temp] == 0) button[temp] = 1;
                    else button[temp] = 0;
                    temp += number;
                }
            }
            else{
                int left = number;
                int right = number;
                while(1 <= left && left <= length
                && 1<= right && right <= length
                && button[left] == button[right]){
                    if(button[right] == 1) button[right] = 0;
                    else button[right] = 1;
                    if(right != left){
                        if(button[left] == 1) button[left] = 0;
                        else button[left] = 1;
                    }
                    left--;
                    right++;
                }
            }
        }
        for(int i=1;i<=length;i++){
            System.out.print(button[i] + " ");
            if(i % 20 == 0) System.out.println("");
        }
    }
}