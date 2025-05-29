import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long input = Integer.parseInt(st.nextToken());
        long length = Integer.parseInt(st.nextToken());
        // (input / length) + length 부터 시작
        // length 개씩 확인, 만약 input보다 작아지는 부분 있으면 length + 1, 합 맞으면 출력

        x: while(true){
            long start = (input / length) + length;
            while(true){
                long sum = 0;
                for(long i=0;i<length;i++){
                    if(start - i < 0) {
                        System.out.println("-1");
                        return;
                    }
                    sum += start - i;
                }
                if(sum == input){
                   for(long i=0;i<length;i++){
                       System.out.print((start - length + 1 + i) + " ");
                   }
                    return;
                }
                else{
                    if(sum < input){
                        break;
                    }
                    else start--;
                }
            }
            length++;
            if(length == 101){
                System.out.println("-1");
                return;
            }
        }
    }
}
