class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder decimalStr = new StringBuilder();

        int count = 0;
        while (decimalStr.length() < t * m) {
            decimalStr.append(toDecimal(n, count));
            count++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            if (i % m == p - 1) {
                result.append(decimalStr.charAt(i));
            }
        }

        return result.toString();
    }

    private String toDecimal(int n, int number) {
        return Integer.toString(number, n).toUpperCase();
    }    
}