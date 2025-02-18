

import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            int repeat = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> queue1 = new PriorityQueue<>((a, b)->{
                if(a<b) return -1;
                else if(a>b) return 1;
                else return 0;
            });
            PriorityQueue<Integer> queue2 = new PriorityQueue<>((a, b)->{
                if(a>b) return -1;
                else if(a<b) return 1;
                else return 0;
            });
            HashMap<Integer, Integer> map = new HashMap<>();

            // 입력이 들어오면 해당 숫자의 해시맵 값 하나 올린다
            for(int j=0;j<repeat;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String io = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                // I 정수 삽임
                if(io.equals("I")){
                    queue1.add(num);
                    queue2.add(num);
                    map.put(num, map.getOrDefault(num, 0)+ 1);
                }
                // D일 떄
                else{
                    // 1이면 최댓값 삭제
                    // 최대값을 삭제할 시에, 최상단의 값의 해시를 먼저 확인해서 0이면 팝 해야함 (더미값)
                    if(num == 1){
                        while(!queue2.isEmpty() && map.get(queue2.peek()) == 0){
                            queue2.poll();
                        }
                        // 더미값을 모두 없앴을 때, 실제로 값을 뺀다
                        if(!queue2.isEmpty()){
                            int temp = queue2.poll();
                            map.put(temp, map.get(temp) -1);
                        }
                    }
                    if(num == -1){
                        while(!queue1.isEmpty() && map.get(queue1.peek()) == 0){
                            queue1.poll();
                        }
                        // 더미값을 모두 없앴을 때, 실제로 값을 뺀다
                        if(!queue1.isEmpty()){
                            int temp = queue1.poll();
                            map.put(temp, map.get(temp) -1);
                        }
                    }
                }
            }
            while(!queue2.isEmpty() && map.get(queue2.peek()) == 0){
                queue2.poll();
            }
            while(!queue1.isEmpty() && map.get(queue1.peek()) == 0){
                queue1.poll();
            }
            if(queue1.isEmpty() || queue2.isEmpty()){
                System.out.println("EMPTY");
            }
            else System.out.println(queue2.poll()+" "+queue1.poll());
        }

    }
}