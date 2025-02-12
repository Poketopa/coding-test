import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String[] input = new String[3];
        for(int i=0;i<3;i++) input[i] = br.readLine();

        int target = 0;
        // 피즈버즈 아닌거 하나 찾기
        for(int i=0;i<3;i++){
            if(!input[i].equals("Fizz")&&!input[i].equals("Buzz")&&!input[i].equals("FizzBuzz")){
                target = i;
                break;
            }
        }
        int output = 0;
        if(target == 0) output = Integer.valueOf(input[target]) + 3;
        else if(target == 1) output = Integer.valueOf(input[target]) + 2;
        else output = Integer.valueOf(input[target]) + 1;

        if(output % 3 == 0&& output % 5 == 0) System.out.println("FizzBuzz");
        else if(output % 3 == 0) System.out.println("Fizz");
        else if(output % 5 == 0) System.out.println("Buzz");
        else System.out.println(output);
    }
}