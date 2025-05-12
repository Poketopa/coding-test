import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[][] inputNum = new int[input][2];
        int[] number = new int[input];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputNum[i][0] = Integer.parseInt(st.nextToken());
            inputNum[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputNum, (a, b)->{
            if(a[0]<b[0]) return -1;
            else if(a[0]>b[0]) return 1;
            else return 0;
        });
        for(int i=0;i<input;i++) number[i] = inputNum[i][1];
        List<Integer> list = new ArrayList<>();
        list.add(number[0]);
        for(int i=1;i<input;i++){
            if(number[i] > list.get(list.size()-1)){
                list.add(number[i]);
            }
            else{
                for(int j=0;j<list.size();j++){
                    if(number[i] <= list.get(j)){
                        list.set(j, number[i]);
                        break;
                    }
                }
            }
        }
        System.out.println(input - list.size());
    }
}
