class Solution {
    boolean solution(String s) {
        int countP = 0;
        int countY = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.toLowerCase().charAt(i) == 'p') {
                countP ++;
            } else if (s.toLowerCase().charAt(i) == 'y') {
                countY++;
            }
        }

        return countY == countP;
    }
}