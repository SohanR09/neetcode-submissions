class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] s_char = new int[26];
        int[] t_char = new int[26];

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            s_char[ch - 'a']++;
        }

        for(int i = 0; i < m; i++){
            char ch = t.charAt(i);
            t_char[ch - 'a']++;
        }

        for(int i = 0; i < s_char.length; i++){
            if(s_char[i] != t_char[i]) return false;
        }

        return true;
    }
}
