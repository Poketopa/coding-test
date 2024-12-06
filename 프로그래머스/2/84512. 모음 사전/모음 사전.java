import java.util.*;

class Solution {
    public int solution(String word) {
        List<String> list = new ArrayList<>();
        int num = 0;
        while(true){
            if(String.join("",list).equals(word)){
                return num;
            }
            num++;
            if(list.size()!=5){
                list.add("A");
                continue;
            }
            else{
                func(list);
            }
        }
    }

    static void func(List<String> list){
        if(list.get(list.size()-1).equals("A")){
            list.remove(list.size()-1);
            list.add("E");
            return;
        }
        if(list.get(list.size()-1).equals("E")){
            list.remove(list.size()-1);
            list.add("I");
            return;
        }
        if(list.get(list.size()-1).equals("I")){
            list.remove(list.size()-1);
            list.add("O");
            return;
        }
        if(list.get(list.size()-1).equals("O")){
            list.remove(list.size()-1);
            list.add("U");
            return;
        }
        if(list.get(list.size()-1).equals("U")){
            list.remove(list.size()-1);
            func(list);
        }
    }
}