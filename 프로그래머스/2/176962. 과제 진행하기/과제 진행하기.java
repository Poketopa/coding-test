import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int index = 0;
        // 미완성 과제 인덱스, 시간
        List<int[]> homework = new ArrayList<>();

        // 과목 - 시, 분, 남은시간 매핑
        HashMap<String, int[]> map = new HashMap<>();
        for(String[] i : plans){
            String[] time = i[1].split(":");
            int hour = Integer.valueOf(time[0]);
            int minute = Integer.valueOf(time[1]);
            map.put(i[0], new int[]{hour, minute, Integer.valueOf(i[2])});
        }
        // plans 배열 정렬
        Arrays.sort(plans, (a, b)->{
            String[] time1 = a[1].split(":");
            String[] time2 = b[1].split(":");
            if(Integer.valueOf(time1[0])<(Integer.valueOf(time2[0]))){
                return -1;
            }
            else if(Integer.valueOf(time1[0])>(Integer.valueOf(time2[0]))){
                return 1;
            }
            else{
                if(Integer.valueOf(time1[1])<(Integer.valueOf(time2[1]))) return -1;
                else if(Integer.valueOf(time1[1])>(Integer.valueOf(time2[1]))) return 1;
                else return 0;
            }
        });
        // 1. 2번째에서 1번째 시간을 뺀다
        // 1240-1220 = 20분
        // 2. 1번째의 시간보다 크면 배열에 넣는다
        // 3. 1번째 시간보다 작으면 차이나는 시간만큼 배열에서 꺼내서 쓴다
        // 배열의 값이 0이 되면 remove, result에 넣는다
        // 순서대로 들어감
        for(int i=0;i<plans.length-1;i++){
            // 다음 시간까지 얼마나 걸리는지 리턴
            int time = subTime(plans, map, i, i+1);
            // 시간 안에 할 수 있으면
            if(time>=map.get(plans[i][0])[2]){
                answer[index] = plans[i][0];
                index++;
                // 남는 시간만큼 빼야함
                // 남는 시간을 뺀 뒤에 0이하면 pop하고 다음 요소에 뺀다
                if(!homework.isEmpty()){
                    int leftTime = time - map.get(plans[i][0])[2];
                    while(!homework.isEmpty()){
                        int[] last = homework.get(homework.size()-1);
                        if(last[1] - leftTime > 0){
                            last[1] -= leftTime;
                            homework.set(homework.size()-1, last);
                            break;
                        }
                        else if(last[1]-leftTime == 0){
                            answer[index] = plans[homework.get(homework.size()-1)[0]][0];
                            index++;
                            homework.remove(homework.size()-1);
                            break;
                        }
                        // 대기시간보다 길어서 하나 빼야할 때
                        else{
                            leftTime -= last[1];
                            answer[index] = plans[homework.get(homework.size()-1)[0]][0];
                            index++;
                            homework.remove(homework.size()-1);
                        }
                    }
                }

            }
            // 시간 안에 못하면
            else{
                // 리스트에 넣는다
                homework.add(new int[]{i,map.get(plans[i][0])[2]-time});
            }
        }
        // 마지막은 상관 없음
        answer[index] = plans[plans.length-1][0];
        index++;
        while(!homework.isEmpty()){
            answer[index] = plans[homework.get(homework.size()-1)[0]][0];
            index++;
            homework.remove(homework.size()-1);
        }
        return answer;
    }

    private static int subTime(String[][] plans, HashMap<String, int[]> map, int x, int y){
        int hour = map.get(plans[y][0])[0] - map.get(plans[x][0])[0];
        int minute = map.get(plans[y][0])[1] - map.get(plans[x][0])[1];
        return hour*60 + minute;
    }
}