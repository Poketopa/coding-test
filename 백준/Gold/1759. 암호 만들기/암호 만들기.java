
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int length = Integer.parseInt(st.nextToken());
        int input = Integer.parseInt(st.nextToken());
        String[] str = new String[input];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) str[i] = st2.nextToken();
        Arrays.sort(str);

        List<String> temp = new ArrayList<>();

        for(int i=0;i<str.length;i++){
            dfs(i, str, temp, length);
        }

    }


    private static void dfs(int now, String[] str, List<String> temp, int length){
        temp.add(str[now]);
        if(temp.size() == length){
            int ja = 0;
            int mo = 0;
            for(int i=0;i<length;i++){
                if(temp.get(i).equals("a")||temp.get(i).equals("e")||temp.get(i).equals("i")||temp.get(i).equals("o")||temp.get(i).equals("u")){
                    mo++;
                }
                else ja++;
            }
            if(mo>=1 && ja>=2){
                String answer = "";
                for(int i=0;i<length;i++){
                    answer += temp.get(i);
                }
                System.out.println(answer);
            }
            temp.remove(temp.size()-1);
            return;
        }
        for(int i=now+1;i<str.length;i++){
            dfs(i, str, temp, length);
        }
        temp.remove(temp.size()-1);
    }
}