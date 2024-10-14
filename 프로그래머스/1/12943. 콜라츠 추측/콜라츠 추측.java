class Solution {
    public int solution(int num) {
        long newNum=num;
        int count = 0;
        while (true) { 
            if(newNum == 1){
                return count;
            }
            if(count == 500){
                return -1;
            }
            if (newNum % 2 == 0){
            	newNum /= 2;
                count++;
                continue;
            }
            else{
            	newNum *= 3;
            	newNum++;
                count++;
                continue;
            }
        }
    }
}