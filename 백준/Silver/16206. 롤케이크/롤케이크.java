
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(st.nextToken());
        int knife = Integer.valueOf(st.nextToken());
        int[] cake = new int[input];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) cake[i] = Integer.valueOf(st2.nextToken());
        List<Integer> list = new ArrayList<>();
        for(int i : cake) list.add(i);
        Collections.sort(list, (a, b)->{
            if(a%10 < b%10) return -1;
            else if(a%10>b%10) return 1;
            else{
                if(a<b) return -1;
                else if(a>b) return 1;
                else return 0;
            }
        });
        for(int i=0;i<list.size();i++) cake[i] = list.get(i);
        int count = 0;

        for(int i=0;i<cake.length;i++){
            // 10 이상인지 확인, 20이상이어야 자를 수 있음
            if(cake[i]<10) continue;
            while(cake[i]>=20 && 0 < knife){
                knife--;
                cake[i] -= 10;
                count++;
            }
            if(cake[i] == 10) count++;
            else{
                if(0<knife){
                    knife--;
                    cake[i] -= 10;
                    count++;
                }
            }
        }




        System.out.println(count);
    }
}