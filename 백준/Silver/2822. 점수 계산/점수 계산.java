import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[8];

        for(int i=0;i<8;i++){
            arr[i] = Integer.parseInt(br.readLine());
            map.put(arr[i], i+1);
        }

        Arrays.sort(arr);

        int sum = 0;

        for(int i=0;i<5;i++){
            sum += arr[arr.length-i-1];
        }

        System.out.println(sum);

        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<5;i++){
            list.add((map.get(arr[arr.length-i-1])));
        }
        
        Collections.sort(list);
        
        for(int i : list){
            System.out.print(i + " " );
        }
        
    }
}
