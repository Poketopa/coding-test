
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.valueOf(br.readLine());
        int[] number = new int[input];
        int sum = 0;
        int max = -1;
        int maxIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<input;i++){
            number[i] = Integer.valueOf(br.readLine());
            map.put(number[i], map.getOrDefault(number[i], 0)+1);
            if(map.get(number[i])>maxIndex){
                max = number[i];
                maxIndex = map.get(number[i]);
            }
            sum += number[i];
        }
        Arrays.sort(number);
        if((double)sum/input % 1 >= 0.5){
            System.out.println((int)((sum / input)+1));
        }
        else if((double)sum/input%1 <= -0.5){
            System.out.println((int)((sum/input)-1));
        }
        else{
            System.out.println((sum / input));
        }
        System.out.println(number[number.length/2]);

        int count = 0;
        for(int i=0;i<number.length;i++){
            if(i>0&&number[i] == number[i-1]) continue;
            if(map.get(number[i]) == maxIndex) count++;
        }
        boolean flag = false;
        if(count == 1) System.out.println(max);
        else{
            for(int i=0;i<number.length;i++){
                if(i>0&&number[i] == number[i-1]) continue;
                if(map.get(number[i]) == maxIndex) {
                    if(!flag) {
                        flag = true;
                        continue;
                    }
                    else {
                        System.out.println(number[i]);
                        break;
                    }
                }
            }
        }
        System.out.println(number[number.length-1]-number[0]);
    }
}