
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] array = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++){
            int temp = Integer.parseInt(st.nextToken());
            array[i] = temp;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        int type = 0;

        while(true){
            if(end == input) break;
            if(type <= 2){
                map.put(array[end], map.getOrDefault(array[end], 0)+1);
                // 새로 추가된거면
                if(map.get(array[end]) == 1){
                    type++;
                }
                end++;
            }
            else{
                if(start<input){
                    map.put(array[start], map.get(array[start])-1);
                    if(map.get(array[start]) == 0){
                        type--;
                    }
                    start++;
                }
            }
            if(type <= 2){
                max = Math.max(max, end - start);
            }

        }
        System.out.println(max);
    }
}