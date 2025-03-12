import java.util.List;
import java.util.ArrayList;

class Solution {
    static final char[] alphabet = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        dfs(list,"",0);

        for(int i=0;i<list.size();i++){
            if(list.get(i).equals(word)){
                answer=i;
                break;
            }
        }
        return answer;
    }

    void dfs(List<String> list, String str, int len){
        list.add(str);
        if(len==5){
            return;
        }

        for(int i=0;i<5;i++){
            dfs(list, str+alphabet[i],len+1);
        }
    }
}