import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 2; i <= 1000000; i++) {
            // 이미 체크된 숫자면 넘어감 (소수가 아님)
            if(even[i]) continue;

            // 소수면 리스트에 추가
            if(i >= 3 && i % 2 != 0) { // 홀수 소수만 저장
                list.add(i);
            }

            // 에라토스테네스의 체 방식으로 배수 지우기
            for(int j = i * 2; j <= 1000000; j += i) {
                even[j] = true;
            }
        }
        while(true){
            int input = Integer.parseInt(br.readLine());

            if(input == 0) return;

            for(int i=0;i<list.size();i++){
                int temp = list.get(i);
                if(!even[input - temp]){
                    System.out.println(input + " = " + temp + " + " + (input - temp));
                    break;
                }
                if(temp > input / 2) {
                    System.out.println("Goldbach's conjecture is wrong.");
                    break;
                }
            }
        }
    }

    public static void isOdd (int number){
        boolean flag = false;
        int temp = 3;
        int count = 0;
        for(int i=temp;i<number/2;i+=2){
            if(number % i == 0) {
                flag = true;
                break;
            }
        }
        if(flag){
            for(int i=number;i<=1000000;i+=number){
                even[i] = true;
            }
        }
        else{
            list.add(number);
        }
    }
}
