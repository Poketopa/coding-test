import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        String[] arr = new String[input];
        Integer[] index = new Integer[input];
        List<String> list = new ArrayList<>();
        for(int i=0;i<input;i++){
            arr[i] = br.readLine();
            index[i] = i;
            list.add(change(arr[i]));
        }
        Arrays.sort(index, (a, b) -> {
            return list.get(a).compareTo(list.get(b));
        });

        for(int i=0;i<input;i++){
            System.out.println(arr[index[i]]);
        }

    }

    public static String change(String input){
        input = input.replace("ng", "1");
        input = input.replace("k", "c");
        input = input.replace("l", "j");
        input = input.replace("m", "k");
        input = input.replace("n", "l");
        input = input.replace("1", "m");
        return input;
    }
}
