class Solution {
    public long solution(long n) {
        String strN = String.valueOf(n);
        int nLength = strN.length();
        char[] array = new char[nLength];
        char temp;
        for (int i=0;i<nLength;i++){
            array[i] = (strN.charAt(i));
        }
        for (int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]<array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;    
                }
            }
        }
        

        String newChar = new String(array);
        long answer = Long.parseLong(newChar);

        return answer;
    }
}