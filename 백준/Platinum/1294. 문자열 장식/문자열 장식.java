import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[] words;
    static int[] pointers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int totalLength = 0;

        String[] words = new String[input];
        for(int i=0;i<input;i++) {
            words[i] = br.readLine();
            totalLength += words[i].length();
        }
        int[] nowIndex = new int[input];
        Arrays.fill(nowIndex, 0);

        StringBuilder answer = new StringBuilder();

        for(int i=0;i<totalLength;i++){
            String min = "";
            int minIndex = 0;
            for(int j=0;j<input;j++){
                if(nowIndex[j] == words[j].length()) continue;

                String compareWord = words[j].substring(nowIndex[j]);

                if(min.equals("")) {
                    min = compareWord;
                    minIndex = j;
                    continue;
                }

                int flag = 0;

                for(int k=0;k<min.length() + compareWord.length(); k++){
                    char a = ' ';
                    char b = ' ';
                    if(k < min.length()){
                        a = min.charAt(k);
                    } else {
                        a = compareWord.charAt(k - min.length());
                    }
                    if(k < compareWord.length()){
                        b = compareWord.charAt(k);
                    } else {
                        b = min.charAt(k - compareWord.length());
                    }

                    if(a < b){
                        flag = 1;
                        break;
                    }
                    else if(a > b){
                        flag = -1;
                        break;
                    }
                }

                if(flag <= 0) {
                    min = compareWord;
                    minIndex = j;
                }
            }
            answer.append(min.charAt(0));
            nowIndex[minIndex]++;
        }

        System.out.print(answer);
    }
}
