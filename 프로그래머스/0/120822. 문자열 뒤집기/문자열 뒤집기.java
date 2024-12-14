class Solution {
    public String solution(String my_string) {
        char[] reverseCharArray = new char[my_string.length()];
        
        for(int i=0; i<my_string.length(); i++){
            reverseCharArray[i] = my_string.charAt(my_string.length()-i-1);
        }
        
        return String.valueOf(reverseCharArray);
    }
}