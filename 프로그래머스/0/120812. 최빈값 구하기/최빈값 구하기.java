

import java.util.*;


class Solution {
    public int solution(int[] array) {
    	int max = -1;
    	int key = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i:array) {
    		if(map.containsKey(i)) {
    			map.put(i,map.get(i)+1);
    		}
    		else {
    			map.put(i, 1);
    		}
    	}
    	for(Map.Entry<Integer,Integer> i : map.entrySet()) {
    		if(i.getValue()>max) {
    			max = i.getValue();
    			key = i.getKey();
    		}
    	}
    	
    	List<Integer> list = new ArrayList<>(map.values());
    	Collections.sort(list);
    	if(list.size()>1) {
	    	if(list.get(list.size()-1) == list.get(list.size()-2)) {
	    		return -1;
	    	}
	    	else {
	    		return key;
	    	}
    	}
    	else {
    		return key;
    	}
    

    }
}