

import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st2.nextToken());
        long B = Integer.parseInt(st2.nextToken());
        long C = Integer.parseInt(st2.nextToken());
        int[] number = new int[input];
        long sumNum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        int index = 0;
        long sum = 0;
        for(long i : number) sumNum+=i;
        sumNum *= B;
        if(B <= C){
            System.out.println(sumNum);
            return;
        }
        else{
            while(true){
                if(index == input-2) break;
                int a = number[index];
                int b = number[index + 1];
                int c = number[index + 2];
                // 3개 지울 수 있을 떄
                if(a > 0 && b > 0 && c > 0){
                    if(b > c && b > a){
                        if(c >= a){
                            int temp = Math.min(b - c, a);
                            number[index] -= temp;
                            number[index + 1] -= temp;
                            sum += (B + C) * temp;
                        }
                        else{
                            int temp = a - c;
                            number[index] -= temp;
                            number[index + 1] -= temp;
                            sum += (B + C) * temp;
                        }

                    }
                    else{
                        int temp = Math.min(a, Math.min(b, c));
                        number[index] -= temp;
                        number[index + 1] -= temp;
                        number[index + 2] -= temp;
                        sum += temp * (B + (2 *C));
                    }
                }
                // 2개 가능할 때
                else if(a > 0 && b > 0 && c == 0){
                    int temp = Math.min(a, b);
                    number[index] -= temp;
                    number[index + 1] -= temp;
                    sum += temp * (B + C);
                }
                else if((a > 0 && b ==0 && c == 0) || (a > 0 && b == 0 && c > 0)){
                    number[index] -= a;
                    sum += B * a;
                }
                else index++;
            }
            while(true){
                if(number[index] > 0 && number[index + 1] > 0){
                    int temp = Math.min(number[index], number[index + 1]);
                    number[index] -= temp;
                    number[index + 1] -= temp;
                    sum += temp * (B + C);
                }
                if(number[index] > 0) {
                    sum += number[index] * B;
                    number[index] = 0;
                }
                if(number[index + 1] > 0) {
                    sum += number[index + 1] * B;
                    number[index + 1] = 0;
                }
                if(number[index] == 0&& number[index + 1] == 0 ) break;
            }

            System.out.println(sum);

        }


    }
}