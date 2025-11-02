import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static class Node {
        int sum;
        int y;
        int x;
        String cal;
        boolean isNumber;

        public Node(int sum, int y, int x,String cal, boolean isNumber){
            this.sum = sum;
            this.y = y;
            this.x = x;
            this.cal = cal;
            this.isNumber = isNumber;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        String[][] map = new String[input][input];
        for(int i=0;i<input;i++){
            String[] arr = br.readLine().split(" ");
            for(int j=0;j<input;j++){
                map[i][j] = arr[j];
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(Integer.parseInt(map[0][0]), 0, 0, "", false));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.y == input -1 && node.x == input -1) {
                min = Math.min(min, node.sum);
                max = Math.max(max, node.sum);
                continue;
            }

            if(node.isNumber){ // 숫자면
                if(node.y + 1 < input){
                    if(node.cal.equals("+")){
                        queue.add(new Node(node.sum + Integer.parseInt(map[node.y + 1][node.x]), node.y + 1, node.x, node.cal, !node.isNumber));
                    }
                    if(node.cal.equals("-")){
                        queue.add(new Node(node.sum - Integer.parseInt(map[node.y + 1][node.x]), node.y + 1, node.x, node.cal, !node.isNumber));
                    }
                    if(node.cal.equals("*")){
                        queue.add(new Node(node.sum * Integer.parseInt(map[node.y + 1][node.x]), node.y + 1, node.x, node.cal, !node.isNumber));
                    }
                }
                if(node.x + 1 < input){
                    if(node.cal.equals("+")){
                        queue.add(new Node(node.sum + Integer.parseInt(map[node.y][node.x + 1]), node.y, node.x+ 1, node.cal, !node.isNumber));
                    }
                    if(node.cal.equals("-")){
                        queue.add(new Node(node.sum - Integer.parseInt(map[node.y][node.x + 1]), node.y, node.x + 1, node.cal, !node.isNumber));
                    }
                    if(node.cal.equals("*")){
                        queue.add(new Node(node.sum * Integer.parseInt(map[node.y][node.x + 1]), node.y, node.x + 1, node.cal, !node.isNumber));
                    }
                }
            }
            else{ // 문자면?
                if(node.y + 1 < input){
                    queue.add(new Node(node.sum, node.y + 1, node.x, map[node.y + 1][node.x], !node.isNumber));
                }
                if(node.x + 1 < input){
                    queue.add(new Node(node.sum, node.y, node.x + 1, map[node.y][node.x + 1], !node.isNumber));
                }
            }
        }
        System.out.print(max + " " + min);
    }
}






