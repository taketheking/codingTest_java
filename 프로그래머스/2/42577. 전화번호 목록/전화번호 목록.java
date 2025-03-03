import java.util.*;

class Solution {
    public boolean solution2(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
    
    public boolean solution(String[] phone_book) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String num : phone_book){
            if (!map.containsKey(num)){
                map.put(num, 0);
            } else{
                return false;
            }
        }

        for (String phone : phone_book){
            for (int i = 0 ; i < phone.length() ; i++){
                if(map.containsKey(phone.substring(0, i))){
                    return false;
                }
            }
        }


        return true;
    }
}