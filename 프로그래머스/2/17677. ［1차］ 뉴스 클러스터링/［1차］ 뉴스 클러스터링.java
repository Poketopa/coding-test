import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // --- 전처리
        // 대문자를 소문자로 변경
        List<Character> newstr1 = new ArrayList<>();
        List<Character> newstr2 = new ArrayList<>();
        for(int i=0;i<str1.length();i++){
            if('A'<= str1.charAt(i)&&str1.charAt(i)<='Z'){
                newstr1.add((char) (str1.charAt(i)+32));
            }
            else{
                newstr1.add((char) (str1.charAt(i)));
            }
        }
        for(int i=0;i<str2.length();i++){
            if('A'<= str2.charAt(i)&&str2.charAt(i)<='Z'){
                newstr2.add((char) (str2.charAt(i)+32));
            }
            else{
                newstr2.add((char) (str2.charAt(i)));
            }
        }
        // 2글자씩 끊는다
        // 같은거 모인 리스트 길이 / 같은거 + 남은거 길이
        List<String> string1 = new ArrayList<>();
        List<String> string2 = new ArrayList<>();
        for(int i=0;i<newstr1.size()-1;i++){
            String temp = String.valueOf(newstr1.get(i))+String.valueOf(newstr1.get(i+1));
            string1.add(temp);
        }for(int i=0;i<newstr2.size()-1;i++){
            String temp = String.valueOf(newstr2.get(i))+String.valueOf(newstr2.get(i+1));
            string2.add(temp);
        }

        int son = 0;
        for(int i=0;i<string1.size();i++){
            for(int j=0;j<string2.size();j++){
                if(string1.get(i).equals("")) break;
                if(string2.get(j).equals("")) continue;
                if(('a'<=string1.get(i).charAt(0)&&(string1.get(i).charAt(1)<='z')&&'a'<=string1.get(i).charAt(1)&&string1.get(i).charAt(0)<='z')){
                    if(('a'<=string2.get(j).charAt(0)&&string2.get(j).charAt(0)<='z')&&('a'<=string2.get(j).charAt(1)&&string2.get(j).charAt(1)<='z')){
                        if(string1.get(i).equals(string2.get(j))){
                            son++;
                            string1.set(i, "");
                            string2.set(j, "");
                            break;
                        }
                    }else{
                        string2.set(j, "");
                    }
                }else{
                    string1.set(i, "");
                }
            }
        }
        for(int j=0;j<string2.size();j++) {
            if (string2.get(j).equals("")) continue;
            if (('a' <= string2.get(j).charAt(0) && string2.get(j).charAt(0) <= 'z') && ('a' <= string2.get(j).charAt(1) && string2.get(j).charAt(1) <= 'z')) {
                continue;
            } else {
                string2.set(j, "");
            }
        }
        if(son == string1.size()) return 65536;

        int mom = 0;
        for(String i : string1){
            if(i.equals("")) continue;
            else mom++;
        }
        for(String i : string2){
            if(i.equals("")) continue;
            else mom++;
        }
        if(mom == 0) return 65536;
        if(son == 0) return 0;
        return (son*65536) / (mom+son);
    }
}