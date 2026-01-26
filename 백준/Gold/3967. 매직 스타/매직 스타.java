import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String[] input = new String[5];
        for(int i=0;i<5;i++) input[i] = br.readLine();

        int[] visited = new int[13];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(visited, 0);
        Set<Integer> set = new HashSet<>();

        checkInput(input, visited, map, set);



        List<Integer> list = new ArrayList<>();

        dfs(visited, list, 0, set, map);
    }

    public static void dfs(int[] visited, List<Integer> list, int index, Set<Integer> set, Map<Integer, Integer> map){
        if(flag) return;
        if(index == 12){
            if(checkSum(list)){
                flag = true;
                printResult(list);
            }
            return;
        }
        if(set.contains(index)){
            int number = map.get(index);
            list.add(number);
            dfs(visited, list, index + 1, set, map);
            if(flag) return;
            list.remove(list.size()-1);
        } else {
            for(int i=1; i<=12; i++){
                if(visited[i] == 1) continue;
                list.add(i);
                visited[i] = 1;
                dfs(visited, list, index + 1, set, map);
                if(flag) return;
                list.remove(list.size()-1);
                visited[i] = 0;
            }
        }

    }

    public static void printResult(List<Integer> list){
        System.out.println("...." + matchAlphabet(list.get(0)) + "....");
        System.out.println("." + matchAlphabet(list.get(1)) + "."
                + matchAlphabet(list.get(2)) + "."
                + matchAlphabet(list.get(3)) + "."
                + matchAlphabet(list.get(4)) + ".");
        System.out.println(".." + matchAlphabet(list.get(5)) + "..."
                + matchAlphabet(list.get(6)) + "..");

        System.out.println("." + matchAlphabet(list.get(7)) + "."
                + matchAlphabet(list.get(8)) + "."
                + matchAlphabet(list.get(9)) + "."
                + matchAlphabet(list.get(10)) + ".");
        System.out.println("...." + matchAlphabet(list.get(11)) + "....");
    }

    public static boolean checkSum(List<Integer> list){
        if(list.get(1) + list.get(2) + list.get(3) + list.get(4) != 26) return false;
        if(list.get(0) + list.get(2) + list.get(5) + list.get(7) != 26) return false;
        if(list.get(0) + list.get(3) + list.get(6) + list.get(10) != 26) return false;
        if(list.get(1) + list.get(5) + list.get(8) + list.get(11) != 26) return false;
        if(list.get(4) + list.get(6) + list.get(9) + list.get(11) != 26) return false;
        if(list.get(7) + list.get(8) + list.get(9) + list.get(10) != 26) return false;
        return true;
    }

    public static void checkInput(String[] input, int[] visited, Map<Integer, Integer> map, Set<Integer> set){
        if(input[0].charAt(4) != 'x' && input[0].charAt(4) != '.'){
            visited[matchNumber(String.valueOf(input[0].charAt(4)))] = 1;
            map.put(0, matchNumber(String.valueOf(input[0].charAt(4))));
            set.add(0);
        }
        if(input[1].charAt(1) != 'x' && input[1].charAt(1) != '.'){
            visited[matchNumber(String.valueOf(input[1].charAt(1)))] = 1;
            map.put(1, matchNumber(String.valueOf(input[1].charAt(1))));
            set.add(1);
        }
        if(input[1].charAt(3) != 'x' && input[1].charAt(3) != '.'){
            visited[matchNumber(String.valueOf(input[1].charAt(3)))] = 1;
            map.put(2, matchNumber(String.valueOf(input[1].charAt(3))));
            set.add(2);
        }
        if(input[1].charAt(5) != 'x' && input[1].charAt(5) != '.'){
            visited[matchNumber(String.valueOf(input[1].charAt(5)))] = 1;
            map.put(3, matchNumber(String.valueOf(input[1].charAt(5))));
            set.add(3);
        }
        if(input[1].charAt(7) != 'x' && input[1].charAt(7) != '.'){
            visited[matchNumber(String.valueOf(input[1].charAt(7)))] = 1;
            map.put(4, matchNumber(String.valueOf(input[1].charAt(7))));
            set.add(4);
        }
        if(input[2].charAt(2) != 'x' && input[2].charAt(2) != '.'){
            visited[matchNumber(String.valueOf(input[2].charAt(2)))] = 1;
            map.put(5, matchNumber(String.valueOf(input[2].charAt(2))));
            set.add(5);
        }
        if(input[2].charAt(6) != 'x' && input[2].charAt(6) != '.'){
            visited[matchNumber(String.valueOf(input[2].charAt(6)))] = 1;
            map.put(6, matchNumber(String.valueOf(input[2].charAt(6))));
            set.add(6);
        }
        if(input[3].charAt(1) != 'x' && input[3].charAt(1) != '.'){
            visited[matchNumber(String.valueOf(input[3].charAt(1)))] = 1;
            map.put(7, matchNumber(String.valueOf(input[3].charAt(1))));
            set.add(7);
        }
        if(input[3].charAt(3) != 'x' && input[3].charAt(3) != '.'){
            visited[matchNumber(String.valueOf(input[3].charAt(3)))] = 1;
            map.put(8, matchNumber(String.valueOf(input[3].charAt(3))));
            set.add(8);
        }
        if(input[3].charAt(5) != 'x' && input[3].charAt(5) != '.'){
            visited[matchNumber(String.valueOf(input[3].charAt(5)))] = 1;
            map.put(9, matchNumber(String.valueOf(input[3].charAt(5))));
            set.add(9);
        }
        if(input[3].charAt(7) != 'x' && input[3].charAt(7) != '.'){
            visited[matchNumber(String.valueOf(input[3].charAt(7)))] = 1;
            map.put(10, matchNumber(String.valueOf(input[3].charAt(7))));
            set.add(10);
        }
        if(input[4].charAt(4) != 'x' && input[4].charAt(4) != '.'){
            visited[matchNumber(String.valueOf(input[4].charAt(4)))] = 1;
            map.put(11, matchNumber(String.valueOf(input[4].charAt(4))));
            set.add(11);
        }
    }
    
    public static int matchNumber(String input){
        if(input.equals("A")) return 1;
        if(input.equals("B")) return 2;
        if(input.equals("C")) return 3;
        if(input.equals("D")) return 4;
        if(input.equals("E")) return 5;
        if(input.equals("F")) return 6;
        if(input.equals("G")) return 7;
        if(input.equals("H")) return 8;
        if(input.equals("I")) return 9;
        if(input.equals("J")) return 10;
        if(input.equals("K")) return 11;
        return 12;
    }

    public static String matchAlphabet(int input){
        if(input == 1) return "A";
        if(input == 2) return "B";
        if(input == 3) return "C";
        if(input == 4) return "D";
        if(input == 5) return "E";
        if(input == 6) return "F";
        if(input == 7) return "G";
        if(input == 8) return "H";
        if(input == 9) return "I";
        if(input == 10) return "J";
        if(input == 11) return "K";
        return "L";
    }
}
