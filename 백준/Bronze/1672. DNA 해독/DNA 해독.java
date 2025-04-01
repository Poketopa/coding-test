
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] arr = new char[input];
        for(int i=0;i<input;i++) arr[i] = str.charAt(i);
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<input;i++) stack.add(arr[i]);
        while(stack.size()!=1){
            char a = stack.pop();
            char b = stack.pop();
            stack.add(find(a,b));
        }
        System.out.println(stack.get(0));
    }

    private static char find(char a, char b){
        if(a == b) return a;
        else if((a == 'A' && b == 'G') || (a == 'G' && b == 'A')) return 'C';
        else if((a == 'A' && b == 'T') || (a == 'T' && b == 'A')) return 'G';
        else if((a == 'A' && b == 'C') || (a == 'C' && b == 'A')) return 'A';
        else if((a == 'C' && b == 'G') || (a == 'G' && b == 'C')) return 'T';
        else if((a == 'T' && b == 'G') || (a == 'G' && b == 'T')) return 'A';
        else return 'G';
    }
}