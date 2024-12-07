import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<>();
        // 하나씩 확인
        for(String i : operations){
            String[] array = new String[2];
            array = i.split(" ");
            if(array[0].equals("I")){
                list.add(Integer.valueOf(array[1]));
            }
            if(array[0].equals("D")){
                if(array[1].equals("1")){
                    if(!list.isEmpty()){
                        list.remove(list.size()-1);
                    }

                }
                else{
                    if(!list.isEmpty()){
                        list.remove(0);
                    }

                }
            }
            Collections.sort(list);
        }
        if(list.isEmpty()){
            return new int[] {0,0};
        }
        else{
            return new int[] {list.get(list.size()-1), list.get(0)};
        }
    }
}