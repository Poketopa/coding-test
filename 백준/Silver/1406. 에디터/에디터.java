import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<String> front = new ArrayDeque<>();
        Deque<String> back = new ArrayDeque<>();
        String input = br.readLine();
        int index = input.length();
        for(int i=0;i<input.length();i++){
            front.addLast(String.valueOf(input.charAt(i)));
        }
        int temp = Integer.parseInt(br.readLine());
        for(int i=0;i<temp;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("P")){
                front.addLast(st.nextToken());
                index++;
            }
            else if(command.equals("L") && index > 0){
                back.addFirst(front.pollLast());
                index--;
            }
            else if(command.equals("D") && index < front.size() + back.size()){
                front.addLast(back.pollFirst());
                index++;
            }
            else if(command.equals("B") && index > 0){
                front.pollLast();
                index--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String c : front) {
            sb.append(c);
        }
        for(String c : back){
            sb.append(c);
        }
        System.out.print(sb.toString());
    }
}
