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
        Arrays.sort(phone_book);
        boolean answer = true;


        for(int i = 0; i < phone_book.length; i++) {
            String phone = phone_book[i];

             if(i+1 < phone_book.length && phone_book[i+1].length() >= phone.length() ) {

                 String str = phone_book[i+1].substring(0,phone.length());

                 if(str.equals(phone)) {
                     answer = false;
                 }
             }

        }
        return answer;
    }
}