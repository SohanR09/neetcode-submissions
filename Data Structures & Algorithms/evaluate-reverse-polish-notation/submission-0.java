class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;

        for(int i = 0; i < n; i++){
            String cur = tokens[i];
            if(!cur.equals("+") && !cur.equals("-") &&
                !cur.equals("*") && !cur.equals("/")){
                    int temp = Integer.parseInt(cur);
                    stack.push(temp);
            }else{
                if(stack.isEmpty()) return -1;
                int el1 = stack.pop();
                if(stack.isEmpty()) return -1;
                int el2 = stack.pop();

                if(cur.equals("+")){
                    stack.push(el1 + el2);
                }else if(cur.equals("-")){
                    stack.push(el2 - el1);
                }else if(cur.equals("*")){
                    stack.push(el1 * el2);
                }else if(cur.equals("/")){
                    stack.push(el2 / el1);
                }else{
                    return -1;
                }
            }
        }

        if(stack.size() > 1){
            return -1;
        }
        return stack.peek();
    }
}
