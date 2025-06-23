import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String number = br.readLine();
        String[] input = number.split("");
        Arrays.sort(input);

        List<String> list = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        int[] visited = new int[input.length];

        for(int i=0;i<input.length;i++){
            if(visited[i] == 1) continue;
            dfs(numberList, number, input, list, visited, i);
            if(flag) return;
        }
        Collections.sort(numberList);
        for(int i : numberList){
            if(i > Integer.parseInt(number)){
                flag = true;
                System.out.println(i);
                break;
            }
        }
        if(!flag) System.out.println("0");
    }
    public static void dfs(List<Integer> numberList, String number, String[] input, List<String> list, int[] visited, int now){
        list.add(input[now]);
        visited[now] = 1;
        if(list.size() == input.length){
            String temp = "";
            for(String i : list) temp += i;
            numberList.add(Integer.parseInt(temp));
        }
        else {
            for(int i=0;i<input.length;i++){
                if(visited[i] == 1) continue;
                dfs(numberList, number, input, list, visited, i);
                if(flag) return;
            }
        }
        list.remove(list.size()-1);
        visited[now] = 0;
    }
}