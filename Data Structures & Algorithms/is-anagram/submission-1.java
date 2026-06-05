class Solution {
    public boolean isAnagram(String s, String t) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];

        for (char ch: s.toCharArray()) {
            char1[ch - 'a']++;
        }
        for (char ch: t.toCharArray()) {
            char2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (char1[i] != char2[i]) return false;
        }

        return true;
    }
}
