class Solution {
    public int solution(String s) {

        String[] numberWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<numberWord.length; i++) {
            String word = numberWord[i];
            if(s.contains(word)) {
                s= s.replaceAll(word, String.valueOf(i));
            }
        }
        return Integer.parseInt(s);
    }
}