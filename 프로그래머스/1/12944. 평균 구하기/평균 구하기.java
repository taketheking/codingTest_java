class Solution {
    public double solution(int[] arr) {
        
        int len = arr.length;
        double sum = 0;
        
        for(int num : arr) {
            sum += num;
        }
        
        return sum / len;
    }
}