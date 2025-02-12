import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        String[][] str = new String[input][2];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            str[i] = new String[]{age, name};
        }
        Arrays.sort(str, (a, b)->{
           if(Integer.valueOf(a[0])<Integer.valueOf(b[0])) return -1;
           else if(Integer.valueOf(a[0])>Integer.valueOf(b[0])) return 1;
           else{
               return 0;
           }
        });
        for(int i=0;i<str.length;i++){
            System.out.println(str[i][0]+" "+str[i][1]);
        }
    }
}