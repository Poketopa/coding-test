
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++) number[i] = Integer.parseInt(br.readLine());
        Arrays.sort(number);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<input-1;i++) set.add(number[i + 1] - number[i]);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int min = list.get(0);

        int num = 1;

        x : for(int i=min;i>0;i--){
            for(int j : list){
                if(j % i != 0){
                    continue x;
                }
            }
            num = i;
            break;
        }
        int sum = 0;
        for(int i=0;i<input-1;i++){
            sum += ((number[i + 1] - number[i]) / num) - 1;
        }
        System.out.println(sum);
    }
}