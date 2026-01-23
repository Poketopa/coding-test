import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<input;i++) list.add(Integer.parseInt(br.readLine()));

        for(int i=0;i<=100000;i++){
            int start = list.get(0) - i;
            int  temp= list.get(0) - i; // 1번 숫자 가정
            for(int j=1;j<list.size();j++){
                temp = list.get(j) - temp;
            }
            if(start + temp == list.get(0)){
                int num = i;
                System.out.println(num);
                for(int j=0;j<input-1;j++){
                    num = list.get(j) - num;
                    System.out.println(num);
                }
                return;
            }
        }
    }
}
