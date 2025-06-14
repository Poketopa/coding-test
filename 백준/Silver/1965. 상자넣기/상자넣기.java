import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        list.add(number[0]);

        for(int i=1;i<input;i++){
            if(number[i] > list.get(list.size()-1)) list.add(number[i]);
            else{
                int index = list.size()-1;
                while(index >= 0 && list.get(index) >= number[i]){
                    index--;
                }
                list.set(index + 1, number[i]);
            }
        }
        System.out.println(list.size());
    }
}