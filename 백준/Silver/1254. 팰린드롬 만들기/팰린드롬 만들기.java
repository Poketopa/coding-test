import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();

        int length = input.length();
        int pivot = input.length() / 2;

        // 시작부터인지 검사
        if(length % 2 == 0){
            // 짝수 먼저 비교
            flag = true;
            for(int i=0;i<length - pivot;i++){
                if(0<=pivot + i
                && pivot + i < length
                && 0<= pivot - i - 1
                && pivot - i - 1 < length){
                    if(input.charAt(pivot + i) != input.charAt(pivot - i - 1)){
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(pivot * 2);
                return;
            }
        }
        else{
            flag = true;
            for(int i=0;i<length - pivot;i++){
                if(0<=pivot + i
                        && pivot + i < length
                        && 0<= pivot - i
                        && pivot - i < length){
                    if(input.charAt(pivot + i) != input.charAt(pivot - i)){
                        flag = false;
                        break;
                    }
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(pivot * 2 + 1);
                return;
            }

        }

        // 홀수면 가운데, 짝수면 오른쪽
        // 피벗의 홀수 짝수 유무에 따라서 달라져야함
        boolean flag = true;
        while(pivot != length){
                // 짝수 먼저 비교
                flag = true;
                for(int i=0;i<length - pivot;i++){
                    if(0<=pivot + i
                            && pivot + i < length
                            && 0<= pivot - i - 1
                            && pivot - i - 1 < length){
                        if(input.charAt(pivot + i) != input.charAt(pivot - i - 1)){
                            flag = false;
                            break;
                        }
                    }
                    else{
                        flag = false;
                        break;
                    }

                }
                if(flag){
                    System.out.println(pivot * 2);
                    return;
                }
                flag = true;
                for(int i=0;i<length - pivot;i++){
                    if(0<=pivot + i
                            && pivot + i < length
                            && 0<= pivot - i
                            && pivot - i < length){
                        if(input.charAt(pivot + i) != input.charAt(pivot - i)){
                            flag = false;
                            break;
                        }
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.println(pivot * 2 + 1);
                    return;
                }
            pivot++;
        }
        System.out.println(length + length - 1);
    }
}