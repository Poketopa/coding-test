
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String input;
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            count++;
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (String key : list) {
            System.out.printf("%s %.4f\n", key, (map.get(key) * 100.0) / count);
        }
    }
}