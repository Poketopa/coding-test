
import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, 1, -1};
        String[][] normalColor = new String[input][input];
        String[][] blindColor = new String[input][input];
        for(int i=0;i<input;i++){
            normalColor[i] = br.readLine().split("");
        }
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(normalColor[i][j].equals("G")) blindColor[i][j] = "R";
                else blindColor[i][j] = normalColor[i][j];
            }
        }

        // 정상 색 탐험
        // 2중포문
        int normalCount = 0;
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(normalColor[i][j].equals("R") || normalColor[i][j].equals("G") || normalColor[i][j].equals("B")){
                    // 색깔 만나면 카운트 올리고 인접한 색 모두 "A"로 변경
                    normalCount++;
                    String nowColor = normalColor[i][j];
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    normalColor[i][j] = "A";

                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = node.y + y[k];
                            int newX = node.x + x[k];
                            if(0<=newY && 0<=newX &&
                               newY<input && newX<input &&
                               normalColor[newY][newX].equals(nowColor)){
                                normalColor[newY][newX] = "A";
                                queue.add(new Node(newY, newX));
                            }
                        }
                    }
                }
            }
        }


        int blindCount = 0;
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(blindColor[i][j].equals("R") || blindColor[i][j].equals("B")){
                    // 색깔 만나면 카운트 올리고 인접한 색 모두 "A"로 변경
                    blindCount++;
                    String nowColor = blindColor[i][j];
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    blindColor[i][j] = "A";

                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        for(int k=0;k<4;k++){
                            int newY = node.y + y[k];
                            int newX = node.x + x[k];
                            if(0<=newY && 0<=newX &&
                                    newY<input && newX<input &&
                                    blindColor[newY][newX].equals(nowColor)){
                                blindColor[newY][newX] = "A";
                                queue.add(new Node(newY, newX));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(normalCount+" "+blindCount);

    }

    public static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.x = x;
            this.y = y;
        }
    }
}