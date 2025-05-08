import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        List<Integer> number = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<input.length();i++){
            number.add(input.charAt(i) - '0');
            sum += input.charAt(i) - '0';
        }
        Collections.sort(number, Collections.reverseOrder());
        if(sum % 3 == 0 && number.get(number.size()-1) == 0){
            for(int i : number)System.out.print(i);
        } else{
            System.out.print("-1");
        }
    }
}
