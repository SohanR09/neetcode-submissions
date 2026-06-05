class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int max_length = 1;
        int start = 0;

        for(int i = 0; i < n; i++){
            // even length
            int left = i;
            int right = i+1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                int length = right - left + 1;
                if(length > max_length) {
                    start = left;
                    max_length = length;
                    // str.append(s.substring(left, right+1));
                }
                left--;
                right++;
            }

            // odd length
            int mid = i;
            int left1 = i - 1;
            int right1 = i + 1;
            while(left1 >= 0 && right1 < n && s.charAt(left1) == s.charAt(right1)){
                int length = right1 - left1 + 1;
                if(length > max_length) {
                    start = left1;
                    max_length = length;
                    // str.append(s.substring(left1, right1+1));
                }
                left1--;
                right1++;
            }
        }
        return s.substring(start, start + max_length);
    }
}
