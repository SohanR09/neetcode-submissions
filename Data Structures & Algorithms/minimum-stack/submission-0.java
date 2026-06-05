class MinStack {
    int idx = -1;
    ArrayList<Integer> A = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> minArr = new ArrayList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        idx++;
        A.add(val);
        min = Math.min(min, val);
        minArr.add(min);
    }
    
    public void pop() {
        A.remove(idx);
        minArr.remove(idx);
        idx--;
        if(idx >= 0) min = minArr.get(idx);
        else min = Integer.MAX_VALUE;
    }
    
    public int top() {
        return A.get(idx);
    }
    
    public int getMin() {
        return minArr.get(idx);
    }
}
