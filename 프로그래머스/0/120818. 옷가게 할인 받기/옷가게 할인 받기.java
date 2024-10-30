class Solution {
    public int solution(int price) {
    	if(price>=500000) {
    		price = (int)((float)0.8*(float)price);
    	}
    	else if(price>=300000){
    		price = (int)((float)0.9*(float)price);
    	}
    	else if(price>=100000) {
    		price = (int)((float)0.95*(float)price);
    	}
        return price;
    }
}