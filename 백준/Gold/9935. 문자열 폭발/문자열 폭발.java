
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        String target = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<input.length();i++){
            sb.append(input.charAt(i));
            if(sb.length()>=target.length()){
                if(sb.substring(sb.length()-target.length(), sb.length()).equals(target)){
                    sb.delete(sb.length()-target.length(), sb.length());
                }
            }
        }
        if(sb.length()==0)System.out.println("FRULA");
        else System.out.println(sb);


    }
}