class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            char cur = s.charAt(i);

            if(cur == '{' || cur == '(' || cur == '['){
                stack.push(cur);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if(
                    (cur == '}' && top == '{') ||
                    (cur == ')' && top == '(') ||
                    (cur == ']' && top == '[')
                ){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
