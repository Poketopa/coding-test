
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int index = 0;
        long sum = 0;
        while(true){
            if(index == input-2) break;
            int a = number[index];
            int b = number[index + 1];
            int c = number[index + 2];
            // 3개 지울 수 있을 떄
            if(a > 0 && b > 0 && c > 0){
                if(b > c && b > a){
                    number[index]--;
                    number[index + 1]--;
                    sum += 5;
                }
                else{
                    int temp = Math.min(a, Math.min(b, c));
                    number[index] -= temp;
                    number[index + 1] -= temp;
                    number[index + 2] -= temp;
                    sum += temp * 7;
                }
            }
            // 2개 가능할 때
            else if(a > 0 && b > 0 && c == 0){
                int temp = Math.min(a, b);
                number[index] -= temp;
                number[index + 1] -= temp;
                sum += temp * 5;
            }
            else if((a > 0 && b ==0 && c == 0) || (a > 0 && b == 0 && c > 0)){
                number[index] -= a;
                sum += 3 * a;
            }
            else index++;
        }
        while(true){
            if(number[index] > 0 && number[index + 1] > 0){
                int temp = Math.min(number[index], number[index + 1]);
                number[index] -= temp;
                number[index + 1] -= temp;
                sum += temp * 5;
            }
            if(number[index] > 0) {
                sum += number[index] * 3;
                number[index] = 0;
            }
            if(number[index + 1] > 0) {
                sum += number[index + 1] * 3;
                number[index + 1] = 0;
            }
            if(number[index] == 0&& number[index + 1] == 0 ) break;
        }

        System.out.println(sum);
    }
}
