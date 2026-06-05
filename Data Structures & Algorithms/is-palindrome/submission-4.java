class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i <= j){
            char ch = Character.toLowerCase(s.charAt(i));
            char ch1 = Character.toLowerCase(s.charAt(j));


            if(Character.isLetterOrDigit(ch) && Character.isLetterOrDigit(ch1)){
                if(Character.compare(ch, ch1) != 0) {
                    return false;
                }
                i++; j--;
            }

            if(!Character.isLetter(ch) || Character.isWhitespace(ch)){
                i++;
            }
            if(!Character.isLetter(ch1) || Character.isWhitespace(ch1)){
                j--;
            }

        }
        
        return true;
    }
}
