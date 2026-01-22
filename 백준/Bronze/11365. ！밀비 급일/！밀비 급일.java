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

        while(true){
            String input = br.readLine();
            if(input.equals("END")){
                return;
            }
            for(int i=0;i<input.length();i++){
                System.out.print(input.charAt(input.length()-1-i));
            }
            System.out.println();
        }
    }
}
