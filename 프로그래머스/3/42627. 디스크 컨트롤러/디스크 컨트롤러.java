import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Queue<int[]> job = new LinkedList<>();
        // 입력 [들어온 시간, 걸리는 시간]
        // jobs 정렬 필요?
        Arrays.sort(jobs, (a,b)->{
           if(a[0]<b[0]) return -1;
           else if(a[0]>b[0]) return 1;
           else{
               if(a[1]<b[1])return -1;
               else if(a[1]>b[1])return 1;
               else return 0;
           }
        });
        for(int[] i : jobs) job.add(i);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
                a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        int time = 0;
        int index = 0;
        while(true){
            int[] temp = new int[2];
            // 큐에 아무것도 없으면
            if(queue.isEmpty() && !job.isEmpty()){
                index++;
                queue.add(job.poll());
                temp = queue.poll();
                time = temp[0] + temp[1];
            }
            else{
                temp = queue.poll();
                time += temp[1];
            }

            answer += (time - temp[0]);
            while(index < jobs.length && jobs[index][0] <= time){
                index++;
                queue.add(job.poll());
            }
            if(job.isEmpty() && queue.isEmpty()) break;
        }
        return answer / jobs.length;
    }
}