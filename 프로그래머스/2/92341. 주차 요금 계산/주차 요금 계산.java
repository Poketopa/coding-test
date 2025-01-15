import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 1. 해시맵 차량 번호 - [입차, 출차]
        // 2. 차량 번호 list

        HashMap<String, int[]> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0;i<records.length;i++){
            String[] input = records[i].split(" ");
            if(!map.containsKey(input[1])){
                list.add(input[1]);
            }
            int time = timeCal(input[0]);
            // 입차인경우
            if(input[2].equals("IN")){
                // 이미 들어왔던 차인 경우
                if(map.containsKey(input[1])){
                    int temp1 = map.get(input[1])[1] - map.get(input[1])[0];
                    map.put(input[1], new int[]{time-temp1, -1});
                }
                else{
                    map.put(input[1], new int[]{time, -1});
                }

            }
            // 출차인 경우
            else{
                map.get(input[1])[1] = time;
            }
        }

        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<answer.length;i++){
            int length = 0;
            // 출차 없으면
            if(map.get(list.get(i))[1] == -1){
                length = (23*60)+59 - map.get(list.get(i))[0];
            }
            else{
                length = map.get(list.get(i))[1] - map.get(list.get(i))[0];
            }
            // 기본요금이면
            if(length<=fees[0]){
                answer[i] = fees[1];
            }
            // 시간 초과했으면
            else{
                // 기본요금 더하고
                length-=fees[0];
                answer[i]+=fees[1];
                // 나누어 떨어지면
                if(length%fees[2]==0){
                    answer[i] += fees[3] * (length / fees[2]);
                }
                else{
                    answer[i] += fees[3] * ((length/fees[2])+1);
                }
            }
        }
        return answer;
    }

    private int timeCal(String time){
        String[] temp = time.split(":");
        int hour = Integer.valueOf(temp[0]);
        int minute = Integer.valueOf(temp[1]);
        return (hour * 60) + minute;
    }
}