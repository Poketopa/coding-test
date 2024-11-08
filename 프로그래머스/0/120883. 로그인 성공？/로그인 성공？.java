class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        int idRight=0;
        for(int i=0;i<db.length;i++){
            if(db[i][0].equals(id_pw[0])&&db[i][1].equals(id_pw[1])){
                answer = "login";
                return answer;
            }
            else if(db[i][0].equals(id_pw[0])&& !(db[i][1].equals(id_pw[1]))){
                idRight=1;
            }
        }
        if(idRight==1){
            answer = "wrong pw";
            return answer;
        }
        else{
            answer = "fail";
            return answer;
        }
    }
}