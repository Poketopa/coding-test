
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] number = new int[input];
        int sum = 0;
        int maxAppear = -1;
        for(int i=0;i<input;i++){
            number[i] = Integer.parseInt(br.readLine());
            map.put(number[i], map.getOrDefault(number[i], 0) + 1);
            if(map.get(number[i]) > maxAppear) maxAppear = map.get(number[i]);
            sum += number[i];
        }
        Arrays.sort(number);
        Set<Integer> set = new HashSet<>();
        for(int i : number){
            if(map.get(i) == maxAppear) set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        double up = (double)sum / (double)input;
        if(up < 0){
            up = -up;
            if(up % 1 >= 0.5){
                int result = (int)(up + 1);
                System.out.println(-result);
            }
            else{
                System.out.println(-(int)up);
            }
        }
        else{
            if(up % 1 >= 0.5){
                int result = (int)(up + 1);
                System.out.println(result);
            }
            else{
                System.out.println((int)up);
            }
        }
        System.out.println(number[input / 2]);
        if(list.size() == 1) System.out.println(list.get(0));
        else System.out.println(list.get(1));
        System.out.println(number[number.length-1] - number[0]);
    }
}