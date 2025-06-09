import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int myScore = Integer.parseInt(st.nextToken());
        int ranking = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();

        if(length > 0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int i=0;i<length;i++) list.add(Integer.parseInt(st2.nextToken()));
        }
        else{
            System.out.println("1");
            return;
        }

        int rank = length + 1;

        for(int i=0;i<length;i++){
            if(list.get(i) < myScore){
                rank = i + 1;
                break;
            }
        }
        if(rank > ranking){
            System.out.println("-1");
            return;
        }
        else{
            while(rank > 1 && Objects.equals(myScore, list.get(rank - 2))){
                rank--;
                if(rank == 1){
                    break;
                }
            }
            System.out.println(rank);
        }


    }
}