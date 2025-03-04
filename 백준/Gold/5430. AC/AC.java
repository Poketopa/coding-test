
import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        x :for(int exe=0;exe<input;exe++){
            // RDD 커맨드
            String[] command = br.readLine().split("");
            // 배열 길이
            int length = Integer.parseInt(br.readLine());
            // 배열 문자열로 받아서 정수배열 만듦
            String arr = br.readLine();
            int[] number = new int[length];
            arr = arr.replace("[", "");
            arr = arr.replace("]", "");
            String[] newArr = arr.split(",");
            for(int i=0;i<length;i++){
                number[i] = Integer.parseInt(newArr[i]);
            }
            int startIndex = 0;
            int endIndex = length-1;
            // 플래그 true -> 앞 / false -> 뒤
            boolean flag = true;
            for(int i=0;i<command.length;i++){
                // R이면 반대로
                if(command[i].equals("R")){
                    flag = !flag;
                }
                // D면 제거
                else{
                    // true일 때
                    if(flag){
                        startIndex++;
                    }
                    else{
                        endIndex--;
                    }
                    // 에러 발생 상황
                    if(startIndex > endIndex + 1){
                        System.out.println("error");
                        continue x;
                    }
                }
            }
            // 크기가 0인 경우
            if(startIndex == endIndex+1){
                System.out.println("[]");
                continue x;
            }
            System.out.print("[");
            if(flag){
                for(int i=startIndex;i<=endIndex;i++){
                    if(i == endIndex) System.out.print(number[i]);
                    else System.out.print(number[i]+",");
                }
            }
            else{
                for(int i=endIndex;i>=startIndex;i--){
                    if(i == startIndex)System.out.print(number[i]);
                    else System.out.print(number[i]+",");
                }
            }
            System.out.println("]");
        }
    }
}
