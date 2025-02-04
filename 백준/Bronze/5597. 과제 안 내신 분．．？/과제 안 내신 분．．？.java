import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] student = new int[31];
        for(int i=0;i<28;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            student[Integer.valueOf(st.nextToken())] = 1;
        }
        for(int i=1;i<student.length;i++){
            if(student[i] == 0) System.out.println(i);
        }
    }
}
